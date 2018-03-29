package zhou.com.mybook.ui.presenter;

import java.util.List;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.mybook.api.BookApi;
import zhou.com.mybook.base.RxPresenter;
import zhou.com.mybook.bean.BookSource;
import zhou.com.mybook.ui.activity.BookSourceActivity;
import zhou.com.mybook.ui.activity.TopRankActivity;
import zhou.com.mybook.ui.contract.BookSourceContract;
import zhou.com.mybook.utils.LogUtils;

/**
 * Created by zhou on 2018/3/26.
 */

public class BookSourcePresenter extends RxPresenter<BookSourceContract.View> implements BookSourceContract.Presenter {

    private BookApi bookApi;
    private BookSourceActivity bookSourceActivity;

    public BookSourcePresenter(BookSourceActivity bookSourceActivity) {
        this.bookSourceActivity = bookSourceActivity;
        bookApi = new BookApi(new OkHttpClient());
    }

    @Override
    public void getBookSource(String viewSummary, String book) {
        Subscription rxSubscription = bookApi.getBookSource(viewSummary, book).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<BookSource>>() {
                    @Override
                    public void onNext(List<BookSource> data) {
                        if (data != null && mView != null) {
                            mView.showBookSource(data);
                        }
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("onError: " + e);
                    }
                });
        addSubscrebe(rxSubscription);
    }
}
