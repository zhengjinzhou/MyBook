package zhou.com.mybook.base;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.squareup.leakcanary.RefWatcher;

import butterknife.ButterKnife;
import zhou.com.mybook.R;
import zhou.com.mybook.utils.StatusBarCompat;
import zhou.com.mybook.view.loadding.CustomDialog;

/**
 * Created by zhou on 2018/3/20.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public Context mContext;
    public Toolbar common_toolbar;
    protected int statusBarColor = 0;

    private CustomDialog dialog;
    protected View statusBarView = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        //在自己的应用初始Activity中加入如下两行代码,检查内存
        RefWatcher refWatcher = BookApplication.getRefWatcher(this);
        refWatcher.watch(this);

        if (statusBarColor == 0) {
            statusBarView = StatusBarCompat.compat(this, ContextCompat.getColor(this, R.color.colorPrimaryDark));
        } else if (statusBarColor != -1) {
            statusBarView = StatusBarCompat.compat(this, statusBarColor);
        }

        mContext = this;
        ButterKnife.bind(this);
        common_toolbar = ButterKnife.findById(this, R.id.common_toolbar);
        if (common_toolbar != null){
            initToolBar();
            setSupportActionBar(common_toolbar);
        }
        initData();
        configView();
    }

    protected void showStatusBar() {
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        if(statusBarView != null){
            statusBarView.setBackgroundColor(statusBarColor);
        }
    }

    protected void hideStatusBar() {
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        if(statusBarView != null){
            statusBarView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    public void startToActivity(Class<?> clzz){
        Intent intent = new Intent(mContext,clzz);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    protected boolean isVisible(View view) {
        return view.getVisibility() == View.VISIBLE;
    }


    protected void gone(final View... views) {
        if (views != null && views.length > 0) {
            for (View view : views) {
                if (view != null) {
                    view.setVisibility(View.GONE);
                }
            }
        }
    }

    protected void visible(final View... views) {
        if (views != null && views.length > 0) {
            for (View view : views) {
                if (view != null) {
                    view.setVisibility(View.VISIBLE);
                }
            }
        }

    }

    // dialog
    public CustomDialog getDialog() {
        if (dialog == null) {
            dialog = CustomDialog.instance(this);
            dialog.setCancelable(true);
        }
        return dialog;
    }

    public void hideDialog() {
        if (dialog != null)
            dialog.hide();
    }

    public void showDialog() {
        getDialog().show();
    }

    public void dismissDialog() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }
    public abstract int getLayout();//layout
    public abstract void initToolBar();//toolbar
    public abstract void initData();//加载数据方法
    public abstract void configView();//初始化控件
}
