package zhou.com.mybook.ui.activity;

import android.os.Bundle;

import java.util.List;

import butterknife.BindView;
import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseCommuniteActivity;
import zhou.com.mybook.view.SelectionLayout;

/**
 * 女生区
 */
public class GirlBookDiscussionActivity extends BaseCommuniteActivity {


    @BindView(R.id.slOverall) SelectionLayout slOverall;

    @Override
    public int getLayout() {
        return R.layout.activity_girl_book_discussion;
    }

    @Override
    public void initToolBar() {
        common_toolbar.setTitle("女生区");
        common_toolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void configView() {

    }

    @Override
    protected List<List<String>> getTabList() {
        return list1;
    }

    @Override
    public void initData() {
        super.initData();
    }
}
