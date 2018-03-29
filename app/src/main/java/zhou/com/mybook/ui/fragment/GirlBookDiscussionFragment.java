package zhou.com.mybook.ui.fragment;

import android.support.v4.app.Fragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseRVFragment;
import zhou.com.mybook.base.Constant;
import zhou.com.mybook.bean.DiscussionList;
import zhou.com.mybook.bean.support.SelectionEvent;
import zhou.com.mybook.ui.activity.BookDiscussionDetailActivity;
import zhou.com.mybook.ui.adapter.BookDiscussionAdapter;
import zhou.com.mybook.ui.contract.GirlBookDiscussionContract;
import zhou.com.mybook.ui.presenter.GirlBookDiscussionPresenter;

/**
 * Created by zhou on 2018/3/21.
 * 女生区Fragment
 */

public class GirlBookDiscussionFragment extends BaseRVFragment<GirlBookDiscussionPresenter, DiscussionList.PostsBean> implements GirlBookDiscussionContract.View {

    private GirlBookDiscussionPresenter mPresenter = new GirlBookDiscussionPresenter(this);
    private String sort = Constant.SortType.DEFAULT;
    private String distillate = Constant.Distillate.ALL;

    @Override
    public void showGirlBookDisscussionList(List<DiscussionList.PostsBean> list, boolean isRefresh) {
        if (isRefresh) {
            mAdapter.clear();
            start = 0;
        }
        mAdapter.addAll(list);
        start = start + list.size();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void initCategoryList(SelectionEvent event) {
        mRecyclerView.setRefreshing(true);
        sort = event.sort;
        distillate = event.distillate;
        onRefresh();
    }

    @Override
    public void showError() {
        loaddingError();
    }

    @Override
    public void complete() {
        mRecyclerView.setRefreshing(false);
    }


    @Override
    public int getLayoutResId() {
        return R.layout.common_easy_recyclerview;
    }

    @Override
    public void attachView() {
        if (mPresenter!=null){
            mPresenter.attachView(this);
        }
    }

    @Override
    public void initDatas() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        mPresenter.getGirlBookDisscussionList(sort, distillate, 0, limit);
    }

    @Override
    public void onLoadMore() {
        mPresenter.getGirlBookDisscussionList(sort, distillate, start, limit);
    }

    @Override
    public void configViews() {
        initAdapter(BookDiscussionAdapter.class, true, true);
        onRefresh();
    }

    @Override
    public void onItemClick(int position) {
        DiscussionList.PostsBean data = mAdapter.getItem(position);
        BookDiscussionDetailActivity.startActivity(activity, data._id);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onDestroy() {
        if (mPresenter!=null){
            mPresenter.detachView();
        }
        super.onDestroy();
    }
}
