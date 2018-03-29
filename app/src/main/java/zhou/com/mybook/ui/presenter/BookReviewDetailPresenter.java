package zhou.com.mybook.ui.presenter;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.mybook.api.BookApi;
import zhou.com.mybook.base.RxPresenter;
import zhou.com.mybook.bean.BookReview;
import zhou.com.mybook.bean.CommentList;
import zhou.com.mybook.ui.activity.BookReviewDetailActivity;
import zhou.com.mybook.ui.contract.BookReviewDetailContract;
import zhou.com.mybook.utils.LogUtils;

/**
 * Created by zhou on 2018/3/23.
 */

public class BookReviewDetailPresenter extends RxPresenter<BookReviewDetailContract.View> implements BookReviewDetailContract.Presenter {

    private BookApi bookApi;
    BookReviewDetailActivity bookReviewDetailActivity;

    public BookReviewDetailPresenter(BookReviewDetailActivity bookReviewDetailActivity) {
        this.bookReviewDetailActivity = bookReviewDetailActivity;
        bookApi = new BookApi(new OkHttpClient());
    }

    @Override
    public void getBookReviewDetail(String id) {
        Subscription rxSubscription = bookApi.getBookReviewDetail(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookReview>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBookReviewDetail:" + e.toString());
                    }

                    @Override
                    public void onNext(BookReview data) {
                        mView.showBookReviewDetail(data);
                    }
                });
        addSubscrebe(rxSubscription);
    }

    @Override
    public void getBestComments(String bookReviewId) {
        Subscription rxSubscription = bookApi.getBestComments(bookReviewId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBestComments:" + e.toString());
                    }

                    @Override
                    public void onNext(CommentList list) {
                        mView.showBestComments(list);
                    }
                });
        addSubscrebe(rxSubscription);
    }

    @Override
    public void getBookReviewComments(String bookReviewId, int start, int limit) {
        Subscription rxSubscription = bookApi.getBookReviewComments(bookReviewId, start + "", limit + "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBookReviewComments:" + e.toString());
                    }

                    @Override
                    public void onNext(CommentList list) {
                        mView.showBookReviewComments(list);
                    }
                });
        addSubscrebe(rxSubscription);
    }
}
