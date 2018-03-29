package zhou.com.mybook.ui.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseActivity;
import zhou.com.mybook.base.Constant;
import zhou.com.mybook.bean.CategoryList;
import zhou.com.mybook.common.OnRvItemClickListener;
import zhou.com.mybook.ui.adapter.TopCategoryFeListAdapter;
import zhou.com.mybook.ui.adapter.TopCategoryListAdapter;
import zhou.com.mybook.ui.contract.TopCategoryListContract;
import zhou.com.mybook.ui.presenter.TopCategoryListPresenter;
import zhou.com.mybook.view.SupportGridItemDecoration;

/**
 * 分类
 */
public class TopCategoryListActivity extends BaseActivity implements TopCategoryListContract.View{

    private static final String TAG = "TopCategoryListActivity";
    @BindView(R.id.rvMaleCategory) RecyclerView mRvMaleCategory;
    @BindView(R.id.rvFemaleCategory) RecyclerView mRvFeMaleCategory;

    private TopCategoryListPresenter mPresenter = new TopCategoryListPresenter(this);
    private TopCategoryListAdapter mMaleCategoryListAdapter;//男生
    private TopCategoryFeListAdapter mFeCategoryListAdapter;//女生
    private List<CategoryList.MaleBean> mMaleCategoryList = new ArrayList<>();
    private List<CategoryList.FemaleBean> mFemaleCategoryList = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.activity_top_category_list;
    }

    @Override
    public void initToolBar() {
        common_toolbar.setTitle("分类");
        common_toolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {
        mRvMaleCategory.setHasFixedSize(true);
        mRvMaleCategory.setLayoutManager(new GridLayoutManager(this, 3));
        mRvMaleCategory.addItemDecoration(new SupportGridItemDecoration(this));//

        mRvFeMaleCategory.setHasFixedSize(true);
        mRvFeMaleCategory.setLayoutManager(new GridLayoutManager(this, 3));
        mRvFeMaleCategory.addItemDecoration(new SupportGridItemDecoration(this));

        mMaleCategoryListAdapter = new TopCategoryListAdapter(mContext, mMaleCategoryList, new ClickListener(Constant.Gender.MALE));
        mFeCategoryListAdapter = new TopCategoryFeListAdapter(mContext, mFemaleCategoryList, new ClickListener2(Constant.Gender.FEMALE));

        mRvMaleCategory.setAdapter(mMaleCategoryListAdapter);
        mRvFeMaleCategory.setAdapter(mFeCategoryListAdapter);

        mPresenter.attachView(this);
        mPresenter.getCategoryList();
    }

    //点击事件
    class ClickListener2 implements OnRvItemClickListener<CategoryList.FemaleBean> {
        private String gender;
        public ClickListener2(@Constant.Gender String gender) {
            this.gender = gender;
        }

        @Override
        public void onItemClick(View view, int position, CategoryList.FemaleBean data) {
            SubCategoryListActivity.startActivity(mContext, data.getName(), gender);
        }
    }
    //点击事件
    class ClickListener implements OnRvItemClickListener<CategoryList.MaleBean> {
        private String gender;
        public ClickListener(@Constant.Gender String gender) {
            this.gender = gender;
        }

        @Override
        public void onItemClick(View view, int position, CategoryList.MaleBean data) {
            SubCategoryListActivity.startActivity(mContext, data.getName(), gender);
        }
    }

    @Override
    public void showCategoryList(CategoryList data) {
        Log.d(TAG, "showCategoryList: "+data.toString());
        mMaleCategoryList.clear();
        mFemaleCategoryList.clear();

        mMaleCategoryList.addAll(data.getMale());
        mFemaleCategoryList.addAll(data.getFemale());

        mFeCategoryListAdapter.notifyDataSetChanged();
        mMaleCategoryListAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    @Override
    protected void onDestroy() {
        if (mPresenter==null){
            mPresenter.detachView();
        }
        super.onDestroy();
    }
}
