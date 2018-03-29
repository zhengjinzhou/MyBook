package zhou.com.mybook.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import butterknife.BindView;
import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseActivity;
import zhou.com.mybook.base.BaseCommuniteActivity;
import zhou.com.mybook.ui.fragment.BookDiscussionFragment;
import zhou.com.mybook.view.SelectionLayout;

/**
 * 综合讨论区
 */
public class BookDiscussionActivity extends BaseCommuniteActivity {

    private static final String INTENT_DIS = "isDis";
    private boolean mIsDiscussion;

    @BindView(R.id.slOverall) SelectionLayout slOverall;


    public static void startActivity(Context context, boolean isDiscussion) {
        context.startActivity(new Intent(context, BookDiscussionActivity.class).putExtra(INTENT_DIS, isDiscussion));
    }

    @Override
    public int getLayout() {
        return R.layout.activity_book_discussion;
    }

    @Override
    public void initToolBar() {
        mIsDiscussion = getIntent().getBooleanExtra(INTENT_DIS, false);
        if (mIsDiscussion){
            common_toolbar.setTitle("综合讨论区");
        }else {
            common_toolbar.setTitle("原创区");
        }
        common_toolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void configView() {
        BookDiscussionFragment fragment = BookDiscussionFragment.newInstance(mIsDiscussion ? "ramble" : "original");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentCO, fragment).commit();
    }

    @Override
    protected List<List<String>> getTabList() {
        return list1;
    }
}
