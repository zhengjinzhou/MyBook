package zhou.com.mybook.ui.activity;

import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseActivity;
import zhou.com.mybook.bean.TopRankBean;
import zhou.com.mybook.common.OnRvItemClickListener;
import zhou.com.mybook.ui.adapter.TopFeRankAdapter;
import zhou.com.mybook.ui.adapter.TopRankAdapter;
import zhou.com.mybook.ui.contract.TopRankContract;
import zhou.com.mybook.ui.presenter.TopRankPresenter;

/**
 * 排行榜
 */
public class TopRankActivity extends BaseActivity implements TopRankContract.View{

    private static final String TAG = "TopRankActivity";
    @BindView(R.id.elvFeMale) ExpandableListView elvFeMale;
    @BindView(R.id.elvMale) ExpandableListView elvMale;
    private TopRankPresenter mPresenter = new TopRankPresenter(this);

    //男生
    private List<TopRankBean.MaleBean> maleGroups = new ArrayList<>();
    private List<List<TopRankBean.MaleBean>> maleChilds = new ArrayList<>();
    private TopRankAdapter maleAdapter;

    //女生
    private List<TopRankBean.FemaleBean> femaleGroups = new ArrayList<>();
    private List<List<TopRankBean.FemaleBean>> femaleChilds = new ArrayList<>();
    private TopFeRankAdapter femaleAdapter;

    @Override
    public int getLayout() {
        return R.layout.activity_top_rank;
    }

    @Override
    public void initToolBar() {
        common_toolbar.setTitle("排行榜");
        common_toolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initData() {
        //设置adapter数据
        maleAdapter = new TopRankAdapter(this,maleGroups,maleChilds);
        femaleAdapter = new TopFeRankAdapter(this,femaleGroups,femaleChilds);
        //为每一个item设置点击事件
        maleAdapter.setItemClickListener(new ClickListener());
        femaleAdapter.setItemClickListener(new ClickListener2());
    }

    class ClickListener2 implements OnRvItemClickListener<TopRankBean.FemaleBean> {

        @Override
        public void onItemClick(View view, int position, TopRankBean.FemaleBean data) {
            if (data.getMonthRank() == null) {
                SubOtherHomeRankActivity.startActivity(mContext, data.get_id(), data.getTitle());
            } else {
                SubRankActivity.startActivity(mContext, data.get_id(), data.getMonthRank(), data.getTotalRank(), data.getTitle());
            }
        }
    }

    class ClickListener implements OnRvItemClickListener<TopRankBean.MaleBean> {

        @Override
        public void onItemClick(View view, int position, TopRankBean.MaleBean data) {
            if (data.getMonthRank() == null) {
                SubOtherHomeRankActivity.startActivity(mContext, data.get_id(), data.getTitle());
            } else {
                SubRankActivity.startActivity(mContext, data.get_id(), data.getMonthRank(), data.getTotalRank(), data.getTitle());
            }
        }
    }

    @Override
    public void configView() {
        showDialog();

        mPresenter.attachView(this);
        mPresenter.getRankList();

        elvFeMale.setAdapter(femaleAdapter);
        elvMale.setAdapter(maleAdapter);

    }

    @Override
    public void showRankList(TopRankBean topRankBean) {
       // Log.d(TAG, "showRankList: "+topRankBean.toString());
        maleGroups.clear();
        femaleGroups.clear();
        updateMale(topRankBean);
        updateFemale(topRankBean);
    }

    /**
     * female的展示
     * @param topRankBean
     */
    private void updateFemale(TopRankBean topRankBean) {
        List<TopRankBean.FemaleBean> list = topRankBean.getFemale();
        List<TopRankBean.FemaleBean> collapse = new ArrayList<>();
        for (TopRankBean.FemaleBean bean : list) {
            if (bean.isCollapse()) { // 折叠
                collapse.add(bean);
            } else {
                femaleGroups.add(bean);
                femaleChilds.add(new ArrayList<TopRankBean.FemaleBean>());
            }
        }
        if (collapse.size() > 0) {
            femaleGroups.add(new TopRankBean.FemaleBean("别人家的排行榜"));
            femaleChilds.add(collapse);
        }
        femaleAdapter.notifyDataSetChanged();
    }

    /**
     * male的展示
     * @param topRankBean
     */
    private void updateMale(TopRankBean topRankBean) {
        List<TopRankBean.MaleBean> list = topRankBean.getMale();
        List<TopRankBean.MaleBean> collapse = new ArrayList<>();
        for (TopRankBean.MaleBean bean : list) {
            if (bean.isCollapse()) { // 折叠
                collapse.add(bean);
            } else {
                maleGroups.add(bean);
                maleChilds.add(new ArrayList<TopRankBean.MaleBean>());
            }
        }
        if (collapse.size() > 0) {
            maleGroups.add(new TopRankBean.MaleBean("别人家的排行榜"));
            maleChilds.add(collapse);
        }
        maleAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {
        dismissDialog();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }
}
