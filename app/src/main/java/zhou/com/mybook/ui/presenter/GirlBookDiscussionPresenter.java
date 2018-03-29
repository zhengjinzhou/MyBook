package zhou.com.mybook.ui.presenter;

import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import zhou.com.mybook.api.BookApi;
import zhou.com.mybook.base.RxPresenter;
import zhou.com.mybook.bean.DiscussionList;
import zhou.com.mybook.ui.contract.GirlBookDiscussionContract;
import zhou.com.mybook.ui.fragment.GirlBookDiscussionFragment;
import zhou.com.mybook.utils.LogUtils;
import zhou.com.mybook.utils.RxUtil;
import zhou.com.mybook.utils.StringUtils;

/**
 * Created by zhou on 2018/3/22.
 */

public class GirlBookDiscussionPresenter extends RxPresenter<GirlBookDiscussionContract.View> implements GirlBookDiscussionContract.Presenter{

    GirlBookDiscussionFragment girlBookDiscussionFragment;
    BookApi bookApi;
    public GirlBookDiscussionPresenter(GirlBookDiscussionFragment girlBookDiscussionFragment){
        this.girlBookDiscussionFragment = girlBookDiscussionFragment;
        bookApi=new BookApi(new OkHttpClient());
    }
    @Override
    public void getGirlBookDisscussionList(String sort, String distillate, int start, int limit) {
        String key = StringUtils.creatAcacheKey("girl-book-discussion-list", "girl", "all", sort, "all", start + "", limit + "", distillate);
        Observable<DiscussionList> fromNetWork = bookApi.getGirlBookDisscussionList("girl", "all", sort, "all", start + "", limit + "", distillate)
                .compose(RxUtil.<DiscussionList>rxCacheListHelper(key));

        //依次检查disk、network
        Subscription rxSubscription = Observable.concat(RxUtil.rxCreateDiskObservable(key, DiscussionList.class), fromNetWork)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DiscussionList>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("onError: " + e.toString());
                        mView.showError();
                    }

                    @Override
                    public void onNext(DiscussionList list) {
                        boolean isRefresh = start == 0 ? true : false;
                        mView.showGirlBookDisscussionList(list.posts, isRefresh);
                    }
                });
        addSubscrebe(rxSubscription);
    }
}
