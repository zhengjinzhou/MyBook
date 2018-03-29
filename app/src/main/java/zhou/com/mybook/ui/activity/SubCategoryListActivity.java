package zhou.com.mybook.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseActivity;
import zhou.com.mybook.base.Constant;
import zhou.com.mybook.bean.BookListTags;
import zhou.com.mybook.bean.CategoryListLv2;
import zhou.com.mybook.manager.EventManager;
import zhou.com.mybook.ui.adapter.MinorAdapter;
import zhou.com.mybook.ui.adapter.MyPagerAdapter;
import zhou.com.mybook.ui.adapter.SubjectTagsAdapter;
import zhou.com.mybook.ui.contract.SubCategoryActivityContract;
import zhou.com.mybook.ui.fragment.SubCategoryFragment;
import zhou.com.mybook.ui.presenter.SubCategoryActivityPresenter;
import zhou.com.mybook.ui.presenter.SubjectBookListPresenter;
import zhou.com.mybook.view.ReboundScrollView;

/**
 * 从分类进来
 * 二级分类
 */
public class SubCategoryListActivity extends BaseActivity implements SubCategoryActivityContract.View {


    private static final String TAG = "SubCategoryListActivity";

    public static void startActivity(Context context, String name, @Constant.Gender String gender) {
        Intent intent = new Intent(context, SubCategoryListActivity.class);
        intent.putExtra(INTENT_CATE_NAME, name);
        intent.putExtra(INTENT_GENDER, gender);
        context.startActivity(intent);
    }

    public static final String INTENT_CATE_NAME = "name";
    public static final String INTENT_GENDER = "gender";

    @BindView(R.id.viewPager) ViewPager viewPager;
    @BindView(R.id.tabLayout) TabLayout tabLayout;

    private String cate = "";
    private String gender = "";
    private String currentMinor = "";
    private MenuItem menuItem = null;

    private List<String> mMinors = new ArrayList<>();
    private ListPopupWindow mListPopupWindow;
    private MinorAdapter minorAdapter;
    private String[] types = new String[]{Constant.CateType.NEW, Constant.CateType.HOT, Constant.CateType.REPUTATION, Constant.CateType.OVER};

    private SubCategoryActivityPresenter mPresenter = new SubCategoryActivityPresenter(this);//二级分类

    @Override
    public int getLayout() {
        return R.layout.activity_sub_category_list;
    }

    @Override
    public void initToolBar() {
        cate = getIntent().getStringExtra(INTENT_CATE_NAME);
        if (menuItem != null) {
            menuItem.setTitle(cate);
        }
        gender = getIntent().getStringExtra(INTENT_GENDER);
        common_toolbar.setTitle(cate);
        common_toolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initData() {
        List<String> mDatas = Arrays.asList(getResources().getStringArray(R.array.sub_category_tab));
        List<Fragment> mTabContents = new ArrayList<>();
        mTabContents.add(SubCategoryFragment.newInstance(cate, "", gender, Constant.CateType.NEW));
        mTabContents.add(SubCategoryFragment.newInstance(cate, "", gender, Constant.CateType.HOT));
        mTabContents.add(SubCategoryFragment.newInstance(cate, "", gender, Constant.CateType.REPUTATION));
        mTabContents.add(SubCategoryFragment.newInstance(cate, "", gender, Constant.CateType.OVER));
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),mTabContents,mDatas));
    }

    @Override
    public void configView() {
        mPresenter.attachView(this);
        mPresenter.getCategoryListLv2();

        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sub_category, menu);
        menuItem = menu.findItem(R.id.menu_major);
        if (!TextUtils.isEmpty(cate)) {
            menuItem.setTitle(cate);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_major) {
            showMinorPopupWindow();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void showCategoryList(CategoryListLv2 data) {
        Log.d(TAG, "showCategoryList: "+data.toString());
        mMinors.clear();
        mMinors.add(cate);
        if (gender.equals(Constant.Gender.MALE)) {
            for (CategoryListLv2.MaleBean bean : data.getMale()) {
                if (cate.equals(bean.getMajor())) {
                    mMinors.addAll(bean.getMins());
                    break;
                }
            }
        } else {
            for (CategoryListLv2.FemaleBean bean : data.getFemale()) {
                if (cate.equals(bean.getMajor())) {
                    mMinors.addAll(bean.getMins());
                    break;
                }
            }
        }
        minorAdapter = new MinorAdapter(this, mMinors);
        minorAdapter.setChecked(0);
        currentMinor = "";
        EventManager.refreshSubCategory(currentMinor, Constant.CateType.NEW);
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    @Override
    protected void onDestroy() {
        if (mPresenter!=null){
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    private void showMinorPopupWindow() {
        if (mMinors.size() > 0 && minorAdapter != null) {
            if (mListPopupWindow == null) {
                mListPopupWindow = new ListPopupWindow(this);
                mListPopupWindow.setAdapter(minorAdapter);
                mListPopupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                mListPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                mListPopupWindow.setAnchorView(common_toolbar);
                mListPopupWindow.setModal(true);
                mListPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        minorAdapter.setChecked(position);
                        if (position > 0) {
                            currentMinor = mMinors.get(position);
                        } else {
                            currentMinor = "";
                        }
                        int current = viewPager.getCurrentItem();
                        EventManager.refreshSubCategory(currentMinor, types[current]);
                        mListPopupWindow.dismiss();
                        common_toolbar.setTitle(mMinors.get(position));
                    }
                });
            }
            mListPopupWindow.show();
        }
    }
}
