package zhou.com.mybook.ui.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseActivity;
import zhou.com.mybook.base.BookApplication;
import zhou.com.mybook.base.Constant;
import zhou.com.mybook.manager.EventManager;
import zhou.com.mybook.service.DownloadBookService;
import zhou.com.mybook.ui.adapter.MyPagerAdapter;
import zhou.com.mybook.ui.contract.MainContract;
import zhou.com.mybook.ui.fragment.CommunityFragment;
import zhou.com.mybook.ui.fragment.FindFragment;
import zhou.com.mybook.ui.fragment.RecommendFragment;
import zhou.com.mybook.ui.presenter.MainActivityPresenter;
import zhou.com.mybook.utils.SharedPreferencesUtil;
import zhou.com.mybook.utils.ToastUtils;
import zhou.com.mybook.view.LoginPopupWindow;

public class MainActivity extends BaseActivity implements MainContract.View, LoginPopupWindow.LoginTypeListener {

    @BindView(R.id.viewPager) ViewPager viewPager;
    @BindView(R.id.tabLayout) TabLayout tabLayout;
    private LoginPopupWindow popupWindow;

    private MainActivityPresenter mPresenter = new MainActivityPresenter();

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initToolBar() {
        common_toolbar.setLogo(getResources().getDrawable(R.drawable.logo));
        common_toolbar.setTitle("");
    }

    @Override
    public void initData() {
        startService(new Intent(this, DownloadBookService.class));
        List<String> mDatas = Arrays.asList(getResources().getStringArray(R.array.home_tabs));
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecommendFragment());
        fragments.add(new CommunityFragment());
        fragments.add(new FindFragment());
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), fragments, mDatas));
    }

    @Override
    public void configView() {
        tabLayout.setupWithViewPager(viewPager);

        mPresenter.attachView(this);
        mPresenter.syncBookShelf();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                startToActivity(SearchActivity.class);
                break;

            case R.id.action_login:
                if (popupWindow == null) {
                    popupWindow = new LoginPopupWindow(this);
                    popupWindow.setLoginTypeListener(this);
                }
                popupWindow.showAtLocation(common_toolbar, Gravity.CENTER, 0, 0);
                break;
            case R.id.action_my_message:
                if (popupWindow == null) {
                    popupWindow = new LoginPopupWindow(this);
                    popupWindow.setLoginTypeListener(this);
                }
                popupWindow.showAtLocation(common_toolbar, Gravity.CENTER, 0, 0);
                break;
            case R.id.action_sync_bookshelf:
               // showDialog();
                mPresenter.syncBookShelf();
                break;
            case R.id.action_scan_local_book:
                requestPermission();
                break;
            case R.id.action_wifi_book:
                startToActivity(WifiBookActivity.class);
                break;
            case R.id.action_feedback:
                startToActivity(FeedbackActivity.class);
                break;
            case R.id.action_night_mode:
                if (SharedPreferencesUtil.getInstance().getBoolean(Constant.ISNIGHT, false)) {
                    SharedPreferencesUtil.getInstance().putBoolean(Constant.ISNIGHT, false);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    SharedPreferencesUtil.getInstance().putBoolean(Constant.ISNIGHT, true);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                recreate();
                break;
            case R.id.action_settings:
                startToActivity(SettingActivity.class);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 请求授权
     */
    private void requestPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) { //表示未授权时
            //进行授权
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        } else {
            startToActivity(ScanLocalBookActivity.class);
        }
    }


    /**
     * 权限申请返回结果
     *
     * @param requestCode  请求码
     * @param permissions  权限数组
     * @param grantResults 申请结果数组，里面都是int类型的数
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) { //同意权限申请
                    startToActivity(ScanLocalBookActivity.class);
                } else { //拒绝权限申请
                    Toast.makeText(this, "权限被拒绝了", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    public void pullSyncBookShelf() {
        mPresenter.syncBookShelf();
    }

    /**
     * 显示item中的图片；
     *
     * @param view
     * @param menu
     * @return
     */
    @SuppressLint("RestrictedApi")
    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        if (menu != null) {
            if (menu.getClass() == MenuBuilder.class) {
                try {
                    @SuppressLint("PrivateApi") Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.onPrepareOptionsPanel(view, menu);
    }

    @Override
    public void syncBookShelfCompleted() {
        EventManager.refreshCollectionList();
    }

    @Override
    public void showError() {
    }

    public void setCurrentItem(int position) {
        viewPager.setCurrentItem(position);
    }

    @Override
    public void complete() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DownloadBookService.cancel();
        stopService(new Intent(this, DownloadBookService.class));
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void onLogin(ImageView view, String type) {

    }

    public static long firstTime = 0;

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                this.exitApp();
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    /**
     * 退出程序
     */
    private void exitApp() {
        // 判断2次点击事件时间
        if ((System.currentTimeMillis() - firstTime) > 2000) {
            Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            firstTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }
}