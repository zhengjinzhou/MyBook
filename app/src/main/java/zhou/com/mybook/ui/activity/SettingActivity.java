package zhou.com.mybook.ui.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseActivity;
import zhou.com.mybook.base.Constant;
import zhou.com.mybook.manager.CacheManager;
import zhou.com.mybook.manager.EventManager;
import zhou.com.mybook.manager.SettingManager;
import zhou.com.mybook.utils.SharedPreferencesUtil;

public class SettingActivity extends BaseActivity {

    @BindView(R.id.mTvSort) TextView mTvSort;
    @BindView(R.id.tvFlipStyle) TextView mTvFlipStyle;
    @BindView(R.id.tvCacheSize) TextView mTvCacheSize;
    @BindView(R.id.noneCoverCompat) SwitchCompat noneCoverCompat;

    @Override
    public int getLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void initToolBar() {
        common_toolbar.setTitle("设置");
        common_toolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String cachesize = CacheManager.getInstance().getCacheSize();
                runOnUiThread(() -> mTvCacheSize.setText(cachesize));

            }
        }).start();
        mTvSort.setText(getResources().getStringArray(R.array.setting_dialog_sort_choice)[
                SharedPreferencesUtil.getInstance().getBoolean(Constant.ISBYUPDATESORT, true) ? 0 : 1]);
        mTvFlipStyle.setText(getResources().getStringArray(R.array.setting_dialog_style_choice)[
                SharedPreferencesUtil.getInstance().getInt(Constant.FLIP_STYLE, 0)]);
    }

    @Override
    public void configView() {
        noneCoverCompat.setChecked(SettingManager.getInstance().isNoneCover());
        noneCoverCompat.setOnCheckedChangeListener((buttonView, isChecked) -> SettingManager.getInstance().saveNoneCover(isChecked));
    }

    @OnClick(R.id.bookshelfSort)
    public void onClickBookShelfSort() {
        new AlertDialog.Builder(mContext)
                .setTitle("书架排序方式")
                .setSingleChoiceItems(getResources().getStringArray(R.array.setting_dialog_sort_choice),
                        SharedPreferencesUtil.getInstance().getBoolean(Constant.ISBYUPDATESORT, true) ? 0 : 1,
                        (dialog, which) -> {
                            mTvSort.setText(getResources().getStringArray(R.array.setting_dialog_sort_choice)[which]);
                            SharedPreferencesUtil.getInstance().putBoolean(Constant.ISBYUPDATESORT, which == 0);
                            EventManager.refreshCollectionList();
                            dialog.dismiss();
                        })
                .create().show();
    }

    @OnClick(R.id.rlFlipStyle)
    public void onClickFlipStyle() {
        new AlertDialog.Builder(mContext)
                .setTitle("阅读页翻页效果")
                .setSingleChoiceItems(getResources().getStringArray(R.array.setting_dialog_style_choice),
                        SharedPreferencesUtil.getInstance().getInt(Constant.FLIP_STYLE, 0),
                        (dialog, which) -> {
                            mTvFlipStyle.setText(getResources().getStringArray(R.array.setting_dialog_style_choice)[which]);
                            SharedPreferencesUtil.getInstance().putInt(Constant.FLIP_STYLE, which);
                            dialog.dismiss();
                        })
                .create().show();
    }

    @OnClick(R.id.feedBack)
    public void feedBack() {
        FeedbackActivity.startActivity(this);
    }

    @OnClick(R.id.cleanCache)
    public void onClickCleanCache() {
        //默认不勾选清空书架列表，防手抖！！
        final boolean selected[] = {true, false};
        new AlertDialog.Builder(mContext)
                .setTitle("清除缓存")
                .setCancelable(true)
                .setMultiChoiceItems(new String[]{"删除阅读记录", "清空书架列表"}, selected, (dialog, which, isChecked) -> selected[which] = isChecked)
                .setPositiveButton("确定", (dialog, which) -> {
                    new Thread(() -> {
                        CacheManager.getInstance().clearCache(selected[0], selected[1]);
                        final String cacheSize = CacheManager.getInstance().getCacheSize();
                        runOnUiThread(() -> {
                            mTvCacheSize.setText(cacheSize);
                            EventManager.refreshCollectionList();
                        });
                    }).start();
                    dialog.dismiss();
                })
                .setNegativeButton("取消", (dialog, which) -> dialog.dismiss())
                .create().show();
    }
}
