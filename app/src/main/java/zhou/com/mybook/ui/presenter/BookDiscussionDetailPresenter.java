package zhou.com.mybook.ui.presenter;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.mybook.api.BookApi;
import zhou.com.mybook.base.RxPresenter;
import zhou.com.mybook.bean.CommentList;
import zhou.com.mybook.bean.Disscussion;
import zhou.com.mybook.ui.activity.BookDiscussionDetailActivity;
import zhou.com.mybook.ui.contract.BookDiscussionDetailContract;
import zhou.com.mybook.utils.LogUtils;

/**
 * Created by zhou on 2018/3/22.
 */

public class BookDiscussionDetailPresenter extends RxPresenter<BookDiscussionDetailContract.View> implements BookDiscussionDetailContract.Presenter {

    private BookApi bookApi;
    BookDiscussionDetailActivity bookDiscussionDetailActivity;

    public BookDiscussionDetailPresenter(BookDiscussionDetailActivity bookDiscussionDetailActivity){
        this.bookDiscussionDetailActivity = bookDiscussionDetailActivity;
        this.bookApi = new BookApi(new OkHttpClient());
    }

    @Override
    public void getBookDisscussionDetail(String id) {
        Subscription rxSubscription = bookApi.getBookDisscussionDetail(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Disscussion>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBookDisscussionDetail:" + e.toString());
                    }

                    @Override
                    public void onNext(Disscussion disscussion) {
                        mView.showBookDisscussionDetail(disscussion);
                    }
                });
        addSubscrebe(rxSubscription);
    }

    @Override
    public void getBestComments(String disscussionId) {
        Subscription rxSubscription = bookApi.getBestComments(disscussionId)
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
    public void getBookDisscussionComments(String disscussionId, int start, int limit) {
        Subscription rxSubscription = bookApi.getBookDisscussionComments(disscussionId, start + "", limit + "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBookDisscussionComments:" + e.toString());
                    }

                    @Override
                    public void onNext(CommentList list) {
                        mView.showBookDisscussionComments(list);
                    }
                });
        addSubscrebe(rxSubscription);
    }

}
