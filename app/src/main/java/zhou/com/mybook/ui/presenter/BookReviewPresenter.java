package zhou.com.mybook.ui.presenter;

import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import zhou.com.mybook.api.BookApi;
import zhou.com.mybook.base.RxPresenter;
import zhou.com.mybook.bean.BookReviewList;
import zhou.com.mybook.ui.contract.BookReviewContract;
import zhou.com.mybook.ui.fragment.BookReviewFragment;
import zhou.com.mybook.utils.LogUtils;
import zhou.com.mybook.utils.RxUtil;
import zhou.com.mybook.utils.StringUtils;

/**
 * Created by zhou on 2018/3/22.
 */

public class BookReviewPresenter extends RxPresenter<BookReviewContract.View> implements BookReviewContract.Presenter{

    BookReviewFragment bookReviewFragment;
    BookApi bookApi;
    public BookReviewPresenter(BookReviewFragment bookReviewFragment){
        this.bookReviewFragment = bookReviewFragment;
        bookApi = new BookApi(new OkHttpClient());
    }

    @Override
    public void getBookReviewList(String sort, String type, String distillate, int start, int limit) {
        String key = StringUtils.creatAcacheKey("book-review-list", sort, type, distillate, start, limit);
        Observable<BookReviewList> fromNetWork = bookApi.getBookReviewList("all", sort, type, start + "", limit + "", distillate)
                .compose(RxUtil.<BookReviewList>rxCacheListHelper(key));
        //依次检查disk、network
        Subscription rxSubscription = Observable.concat(RxUtil.rxCreateDiskObservable(key, BookReviewList.class), fromNetWork)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookReviewList>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("onError: "+e.toString());
                        mView.showError();
                    }

                    @Override
                    public void onNext(BookReviewList list) {
                        LogUtils.d("onNext: get data finish");
                        boolean isRefresh = start == 0 ? true : false;
                        mView.showBookReviewList(list.reviews, isRefresh);
                    }
                });
        addSubscrebe(rxSubscription);
    }
}
