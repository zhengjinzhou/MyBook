package zhou.com.mybook.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseActivity;
import zhou.com.mybook.bean.TagTypeBean;
import zhou.com.mybook.bean.support.TagEvent;
import zhou.com.mybook.common.OnRvItemClickListener;
import zhou.com.mybook.ui.adapter.MyPagerAdapter;
import zhou.com.mybook.ui.adapter.SubjectTagsAdapter;
import zhou.com.mybook.ui.contract.SubjectBookListContract;
import zhou.com.mybook.ui.fragment.CommunityFragment;
import zhou.com.mybook.ui.fragment.FindFragment;
import zhou.com.mybook.ui.fragment.RecommendFragment;
import zhou.com.mybook.ui.fragment.SubjectFragment;
import zhou.com.mybook.ui.presenter.SubjectBookListPresenter;
import zhou.com.mybook.utils.ToastUtils;
import zhou.com.mybook.view.ReboundScrollView;
import zhou.com.mybook.view.SupportDividerItemDecoration;

/**
 * 主题书单
 */
public class SubjectBookListActivity extends BaseActivity implements SubjectBookListContract.View,OnRvItemClickListener<String>{

    private static final String TAG = "SubjectBookListActivity";
    @BindView(R.id.viewPager) ViewPager viewPager;
    @BindView(R.id.tabLayout) TabLayout tabLayout;
    @BindView(R.id.rsvTags) ReboundScrollView rsvTags;
    @BindView(R.id.rvTags) RecyclerView rvTags;

    private List<Fragment> fragments = new ArrayList<>();
    private List<String> mDatas;

    private SubjectTagsAdapter mTagAdapter;
    private SubjectBookListPresenter mPresenter = new SubjectBookListPresenter(this);
    private List<TagTypeBean.DataBean> mTagList = new ArrayList<>();
    private String currentTag = "";

    @Override
    public int getLayout() {
        return R.layout.activity_subject_book_list;
    }

    @Override
    public void initToolBar() {
        common_toolbar.setTitle("主题书单");
        common_toolbar.setNavigationIcon(R.drawable.ab_back);

    }

    @Override
    public void initData() {
        mDatas = Arrays.asList(getResources().getStringArray(R.array.theme_tab));
        fragments.add(SubjectFragment.newInstance("", 0));
        fragments.add(SubjectFragment.newInstance("", 1));
        fragments.add(SubjectFragment.newInstance("", 2));
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),fragments,mDatas));
    }

    @Override
    public void configView() {
        tabLayout.setupWithViewPager(viewPager);

        mPresenter.attachView(this);
        mPresenter.getBookListTags();

        rvTags.setHasFixedSize(true);
        rvTags.setLayoutManager(new LinearLayoutManager(this));
        rvTags.addItemDecoration(new SupportDividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mTagAdapter = new SubjectTagsAdapter(this, mTagList);
        mTagAdapter.setItemClickListener(this);
        rvTags.setAdapter(mTagAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_subject, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_tags:
                if (isVisible(rsvTags)) {
                    hideTagGroup();
                } else {
                    showTagGroup();
                }
                break;
            case R.id.menu_my_book_list:
                startToActivity(MyBookListActivity.class);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void hideTagGroup() {
        Animation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, -1.0f);
        mHiddenAction.setDuration(400);
        rsvTags.startAnimation(mHiddenAction);
        rsvTags.setVisibility(View.GONE);
    }

    private void showTagGroup() {
        if (mTagList.isEmpty()) {
            ToastUtils.showToast(getString(R.string.network_error_tips));
            return;
        }
        Animation mShowAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, -1.0f,
                Animation.RELATIVE_TO_SELF, 0.0f);
        mShowAction.setDuration(400);
        rsvTags.startAnimation(mShowAction);
        rsvTags.setVisibility(View.VISIBLE);
    }

    @Override
    public void showBookListTags(TagTypeBean data) {
        Log.d(TAG, "showBookListTags: "+data.toString());
        mTagList.clear();
        mTagList.addAll(data.getData());
        mTagAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        if (isVisible(rsvTags)) {
            hideTagGroup();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    @Override
    public void onItemClick(View view, int position, String data) {
        hideTagGroup();
        currentTag = data;
        EventBus.getDefault().post(new TagEvent(currentTag));
    }

    @Override
    protected void onDestroy() {
        if (mPresenter == null){
            mPresenter.detachView();
        }
        super.onDestroy();
    }
}
