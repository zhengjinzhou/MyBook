package zhou.com.mybook.ui.fragment;

import android.os.Bundle;

import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseRVFragment;
import zhou.com.mybook.bean.BooksByCats;
import zhou.com.mybook.ui.activity.BookDetailActivity;
import zhou.com.mybook.ui.adapter.SubCategoryAdapter;
import zhou.com.mybook.ui.contract.SubRankContract;
import zhou.com.mybook.ui.presenter.SubRankPresenter;

/**
 * Created by zhou on 2018/3/22.
 */

public class SubRankFragment  extends BaseRVFragment<SubRankPresenter, BooksByCats.BooksBean> implements SubRankContract.View{

    public final static String BUNDLE_ID = "_id";

    public static SubRankFragment newInstance(String id) {
        SubRankFragment fragment = new SubRankFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_ID, id);
        fragment.setArguments(bundle);
        return fragment;
    }
    private String id;
    private SubRankPresenter mPresenter = new SubRankPresenter(this);

    @Override
    public void showRankList(BooksByCats data) {
        mAdapter.clear();
        mAdapter.addAll(data.books);
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
        if (mPresenter!=null)
            mPresenter.attachView(this);
    }

    @Override
    public void initDatas() {
        id = getArguments().getString(BUNDLE_ID);
    }

    @Override
    public void configViews() {
        initAdapter(SubCategoryAdapter.class, true, false);

        onRefresh();
    }

    @Override
    public void onItemClick(int position) {
        BookDetailActivity.startActivity(activity, mAdapter.getItem(position)._id);
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        mPresenter.getRankList(id);
    }
}
