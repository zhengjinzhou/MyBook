package zhou.com.mybook.ui.presenter;

import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import zhou.com.mybook.api.BookApi;
import zhou.com.mybook.base.RxPresenter;
import zhou.com.mybook.bean.CategoryList;
import zhou.com.mybook.ui.activity.TopCategoryListActivity;
import zhou.com.mybook.ui.activity.TopRankActivity;
import zhou.com.mybook.ui.contract.TopCategoryListContract;
import zhou.com.mybook.utils.LogUtils;
import zhou.com.mybook.utils.RxUtil;
import zhou.com.mybook.utils.StringUtils;

/**
 * Created by zhou on 2018/3/21.
 */

public class TopCategoryListPresenter extends RxPresenter<TopCategoryListContract.View> implements TopCategoryListContract.Presenter<TopCategoryListContract.View>{

    private BookApi bookApi;
    private TopCategoryListActivity topCategoryListActivity;

    public TopCategoryListPresenter(TopCategoryListActivity topCategoryListActivity) {
        this.topCategoryListActivity = topCategoryListActivity;
        bookApi = new BookApi(new OkHttpClient());
    }

    @Override
    public void getCategoryList() {
        String key = StringUtils.creatAcacheKey("book-category-list");
        Observable<CategoryList> fromNetWork = bookApi.getCategoryList()
                .compose(RxUtil.<CategoryList>rxCacheBeanHelper(key));

        //依次检查disk、network
        Subscription rxSubscription = Observable.concat(RxUtil.rxCreateDiskObservable(key, CategoryList.class), fromNetWork)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CategoryList>() {
                    @Override
                    public void onNext(CategoryList data) {
                        if (data != null && mView != null) {
                            mView.showCategoryList(data);
                        }
                    }

                    @Override
                    public void onCompleted() {
                        LogUtils.i("complete");
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(e.toString());
                        mView.complete();
                    }
                });
        addSubscrebe(rxSubscription);
    }
}
