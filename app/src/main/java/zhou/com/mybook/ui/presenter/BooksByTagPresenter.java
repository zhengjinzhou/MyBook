package zhou.com.mybook.ui.presenter;

import java.util.List;

import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import zhou.com.mybook.api.BookApi;
import zhou.com.mybook.base.RxPresenter;
import zhou.com.mybook.bean.BooksByTag;
import zhou.com.mybook.ui.activity.BooksByTagActivity;
import zhou.com.mybook.ui.contract.BooksByTagContract;
import zhou.com.mybook.utils.LogUtils;
import zhou.com.mybook.utils.RxUtil;
import zhou.com.mybook.utils.StringUtils;

/**
 * Created by zhou on 2018/3/26.
 */

public class BooksByTagPresenter extends RxPresenter<BooksByTagContract.View> implements BooksByTagContract.Presenter<BooksByTagContract.View> {

    private BookApi bookApi;

    private boolean isLoading = false;
    BooksByTagActivity booksByTagActivity;

    public BooksByTagPresenter(BooksByTagActivity booksByTagActivity) {
        this.booksByTagActivity = booksByTagActivity;
        bookApi = new BookApi(new OkHttpClient());
    }

    @Override
    public void getBooksByTag(String tags, final String start, String limit) {
        if (!isLoading) {
            isLoading = true;
            String key = StringUtils.creatAcacheKey("books-by-tag", tags, start, limit);
            Observable<BooksByTag> fromNetWork = bookApi.getBooksByTag(tags, start, limit)
                    .compose(RxUtil.<BooksByTag>rxCacheListHelper(key));

            //依次检查disk、network
            Subscription rxSubscription = Observable.concat(RxUtil.rxCreateDiskObservable(key, BooksByTag.class), fromNetWork)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<BooksByTag>() {
                        @Override
                        public void onNext(BooksByTag data) {
                            if (data != null) {
                                List<BooksByTag.TagBook> list = data.books;
                                if (list != null && !list.isEmpty() && mView != null) {
                                    boolean isRefresh = start.equals("0") ? true : false;
                                    mView.showBooksByTag(list, isRefresh);
                                }
                            }
                        }

                        @Override
                        public void onCompleted() {
                            isLoading = false;
                            mView.onLoadComplete(true, "");
                        }

                        @Override
                        public void onError(Throwable e) {
                            LogUtils.e(e.toString());
                            isLoading = false;
                            mView.onLoadComplete(false, e.toString());
                        }
                    });
            addSubscrebe(rxSubscription);
        }
    }
}
