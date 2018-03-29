package zhou.com.mybook.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseActivity;
import zhou.com.mybook.ui.adapter.MyPagerAdapter;
import zhou.com.mybook.ui.fragment.CommunityFragment;
import zhou.com.mybook.ui.fragment.FindFragment;
import zhou.com.mybook.ui.fragment.RecommendFragment;
import zhou.com.mybook.ui.fragment.SubRankFragment;

public class SubRankActivity extends BaseActivity {

    public static final String INTENT_WEEK = "_id";
    public static final String INTENT_MONTH = "month";
    public static final String INTENT_ALL = "all";
    public static final String INTENT_TITLE = "title";
    private String week;
    private String month;
    private String all;
    private String title;

    public static void startActivity(Context context, String week, String month, String all, String title) {
        context.startActivity(new Intent(context, SubRankActivity.class)
                .putExtra(INTENT_WEEK, week)
                .putExtra(INTENT_MONTH, month)
                .putExtra(INTENT_ALL, all)
                .putExtra(INTENT_TITLE, title));
    }

    @BindView(R.id.viewPager) ViewPager viewPager;
    @BindView(R.id.tabLayout) TabLayout tabLayout;

    @Override
    public int getLayout() {
        return R.layout.activity_sub_rank;
    }

    @Override
    public void initToolBar() {
        week = getIntent().getStringExtra(INTENT_WEEK);
        month = getIntent().getStringExtra(INTENT_MONTH);
        all = getIntent().getStringExtra(INTENT_ALL);

        title = getIntent().getStringExtra(INTENT_TITLE).split(" ")[0];
        common_toolbar.setNavigationIcon(R.drawable.ab_back);
        common_toolbar.setTitle(title);
    }

    @Override
    public void initData() {
        List<String> mDatas = Arrays.asList(getResources().getStringArray(R.array.sub_rank_tabs));
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(SubRankFragment.newInstance(week));
        fragments.add(SubRankFragment.newInstance(month));
        fragments.add(SubRankFragment.newInstance(all));
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),fragments,mDatas));
    }

    @Override
    public void configView() {
        tabLayout.setupWithViewPager(viewPager);

    }
}
