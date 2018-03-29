package zhou.com.mybook.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseFragment;
import zhou.com.mybook.bean.FindBean;
import zhou.com.mybook.common.OnRvItemClickListener;
import zhou.com.mybook.ui.activity.SubjectBookListActivity;
import zhou.com.mybook.ui.activity.TopCategoryListActivity;
import zhou.com.mybook.ui.activity.TopRankActivity;
import zhou.com.mybook.ui.adapter.FindAdapter;
import zhou.com.mybook.view.SupportDividerItemDecoration;

/**
 * Created by zhou on 2018/3/20.
 * 发现
 */

public class FindFragment extends BaseFragment implements OnRvItemClickListener<FindBean> {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private List<FindBean> mList = new ArrayList<>();
    private FindAdapter mAdapter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_find;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void initDatas() {
        mList.clear();
        List<String> mDatas = Arrays.asList(getResources().getStringArray(R.array.find_tab));
        mList.add(new FindBean(mDatas.get(0), R.drawable.home_find_rank));
        mList.add(new FindBean(mDatas.get(1), R.drawable.home_find_topic));
        mList.add(new FindBean(mDatas.get(2), R.drawable.home_find_category));
    }

    @Override
    public void configViews() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new SupportDividerItemDecoration(mContext, LinearLayoutManager.VERTICAL, true));

        mAdapter = new FindAdapter(mContext, mList, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(View view, int position, FindBean data) {
        switch (position) {
            case 0:
                startToActivity(TopRankActivity.class);
                break;
            case 1:
                startToActivity(SubjectBookListActivity.class);
                break;
            case 2:
                startToActivity(TopCategoryListActivity.class);
                break;
            default:
                break;
        }
    }
}
