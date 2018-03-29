package zhou.com.mybook.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseCommuniteActivity;

/**
 * 书荒互助区
 */
public class BookHelpActivity extends BaseCommuniteActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_book_help;
    }

    @Override
    public void initToolBar() {
        common_toolbar.setTitle("书荒互助区");
        common_toolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void configView() {

    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    protected List<List<String>> getTabList() {
        return list1;
    }
}
