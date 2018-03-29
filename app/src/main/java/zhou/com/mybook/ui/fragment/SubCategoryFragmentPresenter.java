package zhou.com.mybook.ui.fragment;

import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import zhou.com.mybook.api.BookApi;
import zhou.com.mybook.base.RxPresenter;
import zhou.com.mybook.bean.BooksByCats;
import zhou.com.mybook.ui.contract.SubCategoryFragmentContract;
import zhou.com.mybook.utils.LogUtils;
import zhou.com.mybook.utils.RxUtil;
import zhou.com.mybook.utils.StringUtils;

/**
 * Created by zhou on 2018/3/22.
 */

public class SubCategoryFragmentPresenter extends RxPresenter<SubCategoryFragmentContract.View> implements SubCategoryFragmentContract.Presenter<SubCategoryFragmentContract.View>{

    SubCategoryFragment subCategoryFragment;
    BookApi bookApi;

    public SubCategoryFragmentPresenter(SubCategoryFragment subCategoryFragment){
        this.subCategoryFragment = subCategoryFragment;
        bookApi= new BookApi(new OkHttpClient());
    }

    @Override
    public void getCategoryList(String gender, String major, String minor, String type, int start, int limit) {
        String key = StringUtils.creatAcacheKey("category-list", gender, type, major, minor, start, limit);
        Observable<BooksByCats> fromNetWork = bookApi.getBooksByCats(gender, type, major, minor, start, limit)
                .compose(RxUtil.<BooksByCats>rxCacheListHelper(key));

        //依次检查disk、network
        Subscription rxSubscription = Observable.concat(RxUtil.rxCreateDiskObservable(key, BooksByCats.class), fromNetWork)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BooksByCats>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getCategoryList:" + e.toString());
                        mView.showError();
                    }

                    @Override
                    public void onNext(BooksByCats booksByCats) {
                        mView.showCategoryList(booksByCats, start == 0 ? true : false);
                    }
                });
        addSubscrebe(rxSubscription);
    }
}
