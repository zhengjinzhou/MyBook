package zhou.com.mybook.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import butterknife.BindView;
import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseCommuniteActivity;
import zhou.com.mybook.view.SelectionLayout;

/**
 * 书评区
 */
public class BookReviewActivity extends BaseCommuniteActivity {

    @BindView(R.id.slOverall) SelectionLayout slOverall;

    @Override
    public int getLayout() {
        return R.layout.activity_book_review;
    }

    @Override
    public void initToolBar() {
        common_toolbar.setTitle("书评区");
        common_toolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void configView() {

    }

    @Override
    protected List<List<String>> getTabList() {
        return list2;
    }

    @Override
    public void initData() {
        super.initData();
    }
}
