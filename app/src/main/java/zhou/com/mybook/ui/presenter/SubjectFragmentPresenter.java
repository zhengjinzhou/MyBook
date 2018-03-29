package zhou.com.mybook.ui.presenter;

import android.util.Log;

import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import zhou.com.mybook.api.BookApi;
import zhou.com.mybook.base.RxPresenter;
import zhou.com.mybook.bean.BookLists;
import zhou.com.mybook.ui.activity.SubjectBookListActivity;
import zhou.com.mybook.ui.contract.SubjectFragmentContract;
import zhou.com.mybook.ui.fragment.SubjectFragment;
import zhou.com.mybook.utils.LogUtils;
import zhou.com.mybook.utils.RxUtil;
import zhou.com.mybook.utils.StringUtils;
import zhou.com.mybook.utils.ToastUtils;

/**
 * Created by zhou on 2018/3/22.
 */

public class SubjectFragmentPresenter extends RxPresenter<SubjectFragmentContract.View> implements SubjectFragmentContract.Presenter<SubjectFragmentContract.View> {

    SubjectFragment subjectFragment;
    private BookApi bookApi;

    public SubjectFragmentPresenter(SubjectFragment subjectFragment){
        this.subjectFragment = subjectFragment;
        bookApi = new BookApi(new OkHttpClient());
    }

    @Override
    public void getBookLists(String duration, String sort, int start, int limit, String tag, String gender) {
        String key = StringUtils.creatAcacheKey("book-lists", duration, sort, start + "", limit + "", tag, gender);
        Observable<BookLists> fromNetWork = bookApi.getBookLists(duration, sort, start + "", limit + "", tag, gender)
                .compose(RxUtil.<BookLists>rxCacheListHelper(key));

        //依次检查disk、network
        Subscription rxSubscription = Observable.concat(RxUtil.rxCreateDiskObservable(key, BookLists.class), fromNetWork)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookLists>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBookLists:" + e.toString());
                        mView.showError();
                    }

                    @Override
                    public void onNext(BookLists tags) {
                        mView.showBookList(tags.bookLists, start == 0 ? true : false);
                        if (tags.bookLists == null || tags.bookLists.size() <= 0) {
                            ToastUtils.showSingleToast("暂无相关书单");
                        }
                    }
                });
        addSubscrebe(rxSubscription);
    }
}
