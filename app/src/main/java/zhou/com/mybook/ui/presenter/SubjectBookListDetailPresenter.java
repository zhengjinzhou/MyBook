package zhou.com.mybook.ui.presenter;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.mybook.api.BookApi;
import zhou.com.mybook.base.RxPresenter;
import zhou.com.mybook.bean.BookListDetail;
import zhou.com.mybook.ui.activity.SubjectBookListDetailActivity;
import zhou.com.mybook.ui.contract.SubjectBookListDetailContract;
import zhou.com.mybook.utils.LogUtils;

/**
 * Created by zhou on 2018/3/23.
 */

public class SubjectBookListDetailPresenter extends RxPresenter<SubjectBookListDetailContract.View> implements SubjectBookListDetailContract.Presenter<SubjectBookListDetailContract.View> {

    private BookApi bookApi;
    SubjectBookListDetailActivity subjectBookListDetailActivity;

    public SubjectBookListDetailPresenter(SubjectBookListDetailActivity subjectBookListDetailActivity) {
        this.subjectBookListDetailActivity = subjectBookListDetailActivity;
        this.bookApi = new BookApi(new OkHttpClient());
    }

    @Override
    public void getBookListDetail(String bookListId) {
        Subscription rxSubscription = bookApi.getBookListDetail(bookListId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookListDetail>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBookListDetail:" + e.toString());
                        mView.complete();
                    }

                    @Override
                    public void onNext(BookListDetail data) {
                        mView.showBookListDetail(data);
                    }
                });
        addSubscrebe(rxSubscription);
    }

}
