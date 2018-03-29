package zhou.com.mybook.ui.fragment;

import android.support.v4.app.Fragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseRVFragment;
import zhou.com.mybook.base.Constant;
import zhou.com.mybook.bean.BookReviewList;
import zhou.com.mybook.bean.support.SelectionEvent;
import zhou.com.mybook.ui.activity.BookReviewDetailActivity;
import zhou.com.mybook.ui.adapter.BookReviewAdapter;
import zhou.com.mybook.ui.contract.BookReviewContract;
import zhou.com.mybook.ui.presenter.BookReviewPresenter;

/**
 * Created by zhou on 2018/3/21.
 * 书评区Fragment
 */

public class BookReviewFragment extends BaseRVFragment<BookReviewPresenter, BookReviewList.ReviewsBean> implements BookReviewContract.View {

    private String sort = Constant.SortType.DEFAULT;
    private String type = Constant.BookType.ALL;
    private String distillate = Constant.Distillate.ALL;

    private BookReviewPresenter mPresenter = new BookReviewPresenter(this);
    @Override
    public void showBookReviewList(List<BookReviewList.ReviewsBean> list, boolean isRefresh) {
        if (isRefresh) {
            mAdapter.clear();
        }
        mAdapter.addAll(list);
        start = start + list.size();
    }

    @Override
    public void showError() {
        loaddingError();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void initCategoryList(SelectionEvent event) {
        mRecyclerView.setRefreshing(true);
        sort = event.sort;
        type = event.type;
        distillate = event.distillate;
        start = 0;
        mPresenter.getBookReviewList(sort, type, distillate, start, limit);
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        mPresenter.getBookReviewList(sort, type, distillate, start, limit);
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
    public void configViews() {
        initAdapter(BookReviewAdapter.class, true, true);
        onRefresh();
    }

    @Override
    public void onLoadMore() {
        mPresenter.getBookReviewList(sort, type, distillate, start, limit);
    }

    @Override
    public void onItemClick(int position) {
        BookReviewList.ReviewsBean data = mAdapter.getItem(position);
        BookReviewDetailActivity.startActivity(activity, data._id);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
