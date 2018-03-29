package zhou.com.mybook.ui.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseActivity;
import zhou.com.mybook.base.Constant;
import zhou.com.mybook.bean.support.SelectionEvent;
import zhou.com.mybook.ui.adapter.MyPagerAdapter;
import zhou.com.mybook.ui.fragment.BookDetailDiscussionFragment;
import zhou.com.mybook.ui.fragment.BookDetailReviewFragment;
import zhou.com.mybook.ui.fragment.CommunityFragment;
import zhou.com.mybook.ui.fragment.FindFragment;
import zhou.com.mybook.ui.fragment.RecommendFragment;

//热门评论-更多
public class BookDetailCommunityActivity extends BaseActivity {

    public static final String INTENT_ID = "bookId";
    public static final String INTENT_TITLE = "title";
    public static final String INTENT_INDEX = "index";

    private String bookId;
    private String title;
    private int index;
    private int[] select = new int[]{0, 0};
    public static void startActivity(Context context, String bookId, String title, int index) {
        context.startActivity(new Intent(context, BookDetailCommunityActivity.class)
                .putExtra(INTENT_ID, bookId)
                .putExtra(INTENT_TITLE, title)
                .putExtra(INTENT_INDEX, index));
    }

    @BindView(R.id.viewPager) ViewPager viewPager;
    @BindView(R.id.tabLayout) TabLayout tabLayout;

    private AlertDialog dialog;

    @Override
    public int getLayout() {
        return R.layout.activity_book_detail_community;
    }

    @Override
    public void initToolBar() {
        bookId = getIntent().getStringExtra(INTENT_ID);
        title = getIntent().getStringExtra(INTENT_TITLE);
        index = getIntent().getIntExtra(INTENT_INDEX, 0);
        common_toolbar.setTitle(title);
        common_toolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initData() {
        List<String> mDatas = Arrays.asList(getResources().getStringArray(R.array.bookdetail_community_tabs));
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(BookDetailDiscussionFragment.newInstance(bookId));
        fragments.add(BookDetailReviewFragment.newInstance(bookId));
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),fragments,mDatas));
    }

    @Override
    public void configView() {
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_community, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_sort) {
            showSortDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showSortDialog() {
        int checked = select[viewPager.getCurrentItem()];
        dialog = new AlertDialog.Builder(this)
                .setTitle("排序")
                .setSingleChoiceItems(new String[]{"默认排序", "最新发布", "最多评论"},
                        checked, (dialog, which) -> {
                            if (select[viewPager.getCurrentItem()] != which) {
                                select[viewPager.getCurrentItem()] = which;
                                switch (which) {
                                    case 0:
                                        EventBus.getDefault().post(new SelectionEvent(Constant.SortType.DEFAULT));
                                        break;
                                    case 1:
                                        EventBus.getDefault().post(new SelectionEvent(Constant.SortType.CREATED));
                                        break;
                                    case 2:
                                        EventBus.getDefault().post(new SelectionEvent(Constant.SortType.COMMENT_COUNT));
                                        break;
                                    default:
                                        break;
                                }
                            }
                            dialog.dismiss();
                        })
                .setNegativeButton("取消", null)
                .create();
        dialog.show();
    }
}
