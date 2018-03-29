package zhou.com.mybook.ui.presenter;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zhou.com.mybook.api.BookApi;
import zhou.com.mybook.base.RxPresenter;
import zhou.com.mybook.bean.BooksByCats;
import zhou.com.mybook.bean.Rankings;
import zhou.com.mybook.ui.activity.SubOtherHomeRankActivity;
import zhou.com.mybook.ui.contract.SubRankContract;
import zhou.com.mybook.ui.fragment.SubRankFragment;
import zhou.com.mybook.utils.LogUtils;

/**
 * Created by zhou on 2018/3/22.
 */

public class SubRankPresenter extends RxPresenter<SubRankContract.View> implements SubRankContract.Presenter<SubRankContract.View>{

    BookApi bookApi;
    // SubOtherHomeRankActivity的
    SubOtherHomeRankActivity subOtherHomeRankActivity;
    public SubRankPresenter(SubOtherHomeRankActivity subOtherHomeRankActivity){
        this.subOtherHomeRankActivity = subOtherHomeRankActivity;
        bookApi = new BookApi(new OkHttpClient());
    }

    //SubRankFragment的
    SubRankFragment subRankFragment;
    public SubRankPresenter(SubRankFragment subRankFragment){
        this.subRankFragment = subRankFragment;
        bookApi = new BookApi(new OkHttpClient());
    }

    @Override
    public void getRankList(String id) {
        Subscription rxSubscription = bookApi.getRanking(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Rankings>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getRankList:" + e.toString());
                        mView.showError();
                    }

                    @Override
                    public void onNext(Rankings ranking) {
                        List<Rankings.RankingBean.BooksBean> books = ranking.ranking.books;

                        BooksByCats cats = new BooksByCats();
                        cats.books = new ArrayList<>();
                        for (Rankings.RankingBean.BooksBean bean : books) {
                            cats.books.add(new BooksByCats.BooksBean(bean._id, bean.cover, bean.title, bean.author, bean.cat, bean.shortIntro, bean.latelyFollower, bean.retentionRatio));
                        }
                        mView.showRankList(cats);
                    }
                });
        addSubscrebe(rxSubscription);
    }
}
