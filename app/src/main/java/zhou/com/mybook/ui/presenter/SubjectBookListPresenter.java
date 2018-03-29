package zhou.com.mybook.ui.presenter;

import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import zhou.com.mybook.api.BookApi;
import zhou.com.mybook.base.RxPresenter;
import zhou.com.mybook.bean.TagTypeBean;
import zhou.com.mybook.ui.activity.SubCategoryListActivity;
import zhou.com.mybook.ui.activity.SubjectBookListActivity;
import zhou.com.mybook.ui.contract.SubjectBookListContract;
import zhou.com.mybook.utils.LogUtils;
import zhou.com.mybook.utils.RxUtil;
import zhou.com.mybook.utils.StringUtils;

/**
 * Created by zhou on 2018/3/21.
 * 分类
 */

public class SubjectBookListPresenter extends RxPresenter<SubjectBookListContract.View> implements SubjectBookListContract.Presenter<SubjectBookListContract.View>{

    SubjectBookListActivity subjectBookListActivity;
    private BookApi bookApi;

    public SubjectBookListPresenter(SubjectBookListActivity subjectBookListActivity){
        this.subjectBookListActivity = subjectBookListActivity;
        bookApi = new BookApi(new OkHttpClient());
    }


    @Override
    public void getBookListTags() {
        String key = StringUtils.creatAcacheKey("book-list-tags");
        Observable<TagTypeBean> fromNetWork = bookApi.getBookListTags()
                .compose(RxUtil.<TagTypeBean>rxCacheListHelper(key));

        Subscription subscription = Observable.concat(RxUtil.rxCreateDiskObservable(key, TagTypeBean.class), fromNetWork)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TagTypeBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(e.getMessage());
                    }

                    @Override
                    public void onNext(TagTypeBean tagTypeBean) {
                        mView.showBookListTags(tagTypeBean);
                    }
                });
        addSubscrebe(subscription);
    }
}
