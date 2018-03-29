package zhou.com.mybook.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by zhou on 2018/3/20.
 * tabLayout与Viewpager与fragment结合使用
 * app:tabMode="scrollable"会使tablayout布局不权重
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments = null;
    private List<String> tabTitles = null;

    public MyPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> arrTabTitles) {
        super(fm);
        this.fragments = fragments;
        this.tabTitles = arrTabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
    }

}
