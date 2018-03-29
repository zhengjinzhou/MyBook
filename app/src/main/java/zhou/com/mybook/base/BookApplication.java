package zhou.com.mybook.base;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import zhou.com.mybook.utils.AppUtils;
import zhou.com.mybook.utils.LogUtils;
import zhou.com.mybook.utils.SharedPreferencesUtil;

/**
 * Created by zhou on 2018/3/20.
 */

public class BookApplication extends Application {

    public static BookApplication app;
    private RefWatcher refWatcher;

    public static RefWatcher getRefWatcher(Context context) {
        BookApplication application = (BookApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        refWatcher = LeakCanary.install(this);
        AppUtils.init(this);
        initSp();
        initNightMode();
    }

    protected void initNightMode() {
        boolean isNight = SharedPreferencesUtil.getInstance().getBoolean(Constant.ISNIGHT, false);
        LogUtils.d("isNight=" + isNight);
        if (isNight) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    /**
     * 初始化SharedPreference
     */
    private void initSp() {
        SharedPreferencesUtil.init(getApplicationContext(), getPackageName() + "_preference", Context.MODE_MULTI_PROCESS);
    }

    public static BookApplication getInstance() {
        return app;
    }
}
