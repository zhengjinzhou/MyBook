package zhou.com.mybook.api.support;

import zhou.com.mybook.utils.LogUtils;

/**
 * Created by zhou on 2018/3/21.
 */

public class Logger implements LoggingInterceptor.Logger {

    @Override
    public void log(String message) {
        LogUtils.i("http : " + message);
    }
}

