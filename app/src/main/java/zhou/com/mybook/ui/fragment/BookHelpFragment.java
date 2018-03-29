package zhou.com.mybook.ui.fragment;

import android.support.v4.app.Fragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseRVFragment;
import zhou.com.mybook.base.Constant;
import zhou.com.mybook.bean.BookHelpList;
import zhou.com.mybook.bean.support.SelectionEvent;
import zhou.com.mybook.ui.activity.BookHelpDetailActivity;
import zhou.com.mybook.ui.adapter.BookHelpAdapter;
import zhou.com.mybook.ui.contract.BookHelpContract;
import zhou.com.mybook.ui.presenter.BookHelpPresenter;

/**
 * Created by zhou on 2018/3/21.
 * 书荒求助区fragment
 */

public class BookHelpFragment extends BaseRVFragment<BookHelpPresenter, BookHelpList.HelpsBean> implements BookHelpContract.View {

    private String sort = Constant.SortType.DEFAULT;
    private String distillate = Constant.Distillate.ALL;

    private BookHelpPresenter mPresenter = new BookHelpPresenter(this);

    @Override
    public void showBookHelpList(List<BookHelpList.HelpsBean> list, boolean isRefresh) {
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

    @Override
    public void complete() {
        mRecyclerView.setRefreshing(false);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.common_easy_recyclerview;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void initCategoryList(SelectionEvent event) {
        mRecyclerView.setRefreshing(true);
        sort = event.sort;
        distillate = event.distillate;
        onRefresh();
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        mPresenter.getBookHelpList(sort, distillate, 0, limit);
    }

    @Override
    public void onLoadMore() {
        mPresenter.getBookHelpList(sort, distillate, start, limit);
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
        initAdapter(BookHelpAdapter.class, true, true);
        onRefresh();
    }

    @Override
    public void onItemClick(int position) {
        BookHelpList.HelpsBean data = mAdapter.getItem(position);
        BookHelpDetailActivity.startActivity(activity, data._id);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onDestroy() {
        if (mPresenter!=null)
            mPresenter.detachView();
        super.onDestroy();
    }
}
