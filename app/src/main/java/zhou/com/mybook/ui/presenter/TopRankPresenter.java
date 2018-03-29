package zhou.com.mybook.ui.presenter;

import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import zhou.com.mybook.api.BookApi;
import zhou.com.mybook.base.RxPresenter;
import zhou.com.mybook.bean.TopRankBean;
import zhou.com.mybook.ui.activity.TopRankActivity;
import zhou.com.mybook.ui.contract.TopRankContract;
import zhou.com.mybook.utils.LogUtils;
import zhou.com.mybook.utils.RxUtil;
import zhou.com.mybook.utils.StringUtils;

/**
 * Created by zhou on 2018/3/21.
 */

public class TopRankPresenter extends RxPresenter<TopRankContract.View> implements TopRankContract.Presenter<TopRankContract.View> {

    private BookApi bookApi;
    private TopRankActivity topRankActivity;

    public TopRankPresenter(TopRankActivity topRankActivity) {
        this.topRankActivity = topRankActivity;
        bookApi = new BookApi(new OkHttpClient());
    }

    @Override
    public void getRankList() {
        String key = StringUtils.creatAcacheKey("book-ranking-list");
        Observable<TopRankBean> fromNetWork = bookApi.getRanking()
                .compose(RxUtil.<TopRankBean>rxCacheBeanHelper(key));

        Subscription subscribe = Observable.concat(RxUtil.rxCreateDiskObservable(key, TopRankBean.class), fromNetWork)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TopRankBean>() {
                    @Override
                    public void onNext(TopRankBean data) {
                        if (data != null && mView != null) {
                            mView.showRankList(data);
                        }
                    }

                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getRankList:" + e.toString());
                        mView.complete();
                    }
                });
        addSubscrebe(subscribe);
    }
}
