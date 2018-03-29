package zhou.com.mybook.api.support;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import zhou.com.mybook.utils.AppUtils;
import zhou.com.mybook.utils.DeviceUtils;

/**
 * Created by zhou on 2018/3/21.
 * Retrofit2 Header拦截器。用于保存和设置Cookies
 */

public final class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        String url = original.url().toString();
        if (url.contains("book/") ||
                url.contains("book-list/") ||
                url.contains("toc/") ||
                url.contains("post/") ||
                url.contains("user/")) {
            Request request = original.newBuilder()
                    .addHeader("User-Agent", "ZhuiShuShenQi/3.40[preload=false;locale=zh_CN;clientidbase=android-nvidia]") // 不能转UTF-8
                    .addHeader("X-User-Agent", "ZhuiShuShenQi/3.40[preload=false;locale=zh_CN;clientidbase=android-nvidia]")
                    .addHeader("X-Device-Id", DeviceUtils.getIMEI(AppUtils.getAppContext()))
                    .addHeader("Host", "api.zhuishushenqi.com")
                    .addHeader("Connection", "Keep-Alive")
                    .addHeader("If-None-Match", "W/\"2a04-4nguJ+XAaA1yAeFHyxVImg\"")
                    .addHeader("If-Modified-Since", "Tue, 02 Aug 2016 03:20:06 UTC")
                    .build();
            return chain.proceed(request);
        }
        return chain.proceed(original);
    }
}
