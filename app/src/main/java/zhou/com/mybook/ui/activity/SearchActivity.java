package zhou.com.mybook.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseRVActivity;
import zhou.com.mybook.bean.SearchDetail;
import zhou.com.mybook.manager.CacheManager;
import zhou.com.mybook.ui.adapter.AutoCompleteAdapter;
import zhou.com.mybook.ui.adapter.SearchHistoryAdapter;
import zhou.com.mybook.ui.contract.SearchContract;
import zhou.com.mybook.ui.easyadapter.SearchAdapter;
import zhou.com.mybook.ui.presenter.SearchPresenter;
import zhou.com.mybook.view.TagColor;
import zhou.com.mybook.view.TagGroup;

public class SearchActivity extends BaseRVActivity<SearchDetail.SearchBooks> implements SearchContract.View  {

    private MenuItem searchMenuItem;
    private SearchView searchView;
    private String key;
    private SearchPresenter mPresenter = new SearchPresenter(this);
    private ListPopupWindow mListPopupWindow;
    private SearchHistoryAdapter mHisAdapter;
    private AutoCompleteAdapter mAutoAdapter;
    private List<String> tagList = new ArrayList<>();

    @BindView(R.id.tvChangeWords) TextView mTvChangeWords;
    @BindView(R.id.tag_group) TagGroup mTagGroup;
    @BindView(R.id.rootLayout) LinearLayout mRootLayout;
    @BindView(R.id.layoutHotWord) RelativeLayout mLayoutHotWord;
    @BindView(R.id.rlHistory) RelativeLayout rlHistory;
    @BindView(R.id.tvClear) TextView tvClear;
    @BindView(R.id.lvSearchHistory) ListView lvSearchHistory;
    private List<String> mAutoList = new ArrayList<>();
    int hotIndex = 0;
    private List<String> mHisList = new ArrayList<>();
    private int times = 0;

    public static final String INTENT_QUERY = "query";
    public static void startActivity(Context context, String query) {
        context.startActivity(new Intent(context, SearchActivity.class)
                .putExtra(INTENT_QUERY, query));
    }

    @Override
    public int getLayout() {
        return R.layout.activity_search;
    }

    @Override
    public void initToolBar() {
        common_toolbar.setTitle("");
        common_toolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initData() {
        key = getIntent().getStringExtra(INTENT_QUERY);

        mHisAdapter = new SearchHistoryAdapter(this, mHisList);
        lvSearchHistory.setAdapter(mHisAdapter);
        lvSearchHistory.setOnItemClickListener((parent, view, position, id) -> search(mHisList.get(position)));
        initSearchHistory();
    }

    @Override
    public void configView() {
        initAdapter(SearchAdapter.class, false, false);
        initAutoList();
        mTagGroup.setOnTagClickListener(tag -> search(tag));
        mTvChangeWords.setOnClickListener(v -> showHotWord());
        mPresenter.attachView(this);
        mPresenter.getHotWordList();
    }

    /**
     * 每次显示8个热搜词
     */
    private synchronized void showHotWord() {
        int tagSize = 8;
        String[] tags = new String[tagSize];
        for (int j = 0; j < tagSize && j < tagList.size(); hotIndex++, j++) {
            tags[j] = tagList.get(hotIndex % tagList.size());
        }
        List<TagColor> colors = TagColor.getRandomColors(tagSize);
        mTagGroup.setTags(colors, tags);
    }

    private void initAutoList() {
        mAutoAdapter = new AutoCompleteAdapter(this, mAutoList);
        mListPopupWindow = new ListPopupWindow(this);
        mListPopupWindow.setAdapter(mAutoAdapter);
        mListPopupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        mListPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        mListPopupWindow.setAnchorView(common_toolbar);
        mListPopupWindow.setOnItemClickListener((parent, view, position, id) -> {
            mListPopupWindow.dismiss();
            TextView tv = view.findViewById(R.id.tvAutoCompleteItem);
            String str = tv.getText().toString();
            search(str);
        });
    }

    @Override
    public synchronized void showHotWordList(List<String> list) {
        visible(mTvChangeWords);
        tagList.clear();
        tagList.addAll(list);
        times = 0;
        showHotWord();
    }

    @Override
    public void showAutoCompleteList(List<String> list) {
        mAutoList.clear();
        mAutoList.addAll(list);
        if (!mListPopupWindow.isShowing()) {
            mListPopupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
            mListPopupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
            mListPopupWindow.show();
        }
        mAutoAdapter.notifyDataSetChanged();
    }

    @Override
    public void showSearchResultList(List<SearchDetail.SearchBooks> list) {
        mAdapter.clear();
        mAdapter.addAll(list);
        mAdapter.notifyDataSetChanged();
        initSearchResult();
    }

    private void initSearchResult() {
        gone(mTagGroup, mLayoutHotWord, rlHistory);
        visible(mRecyclerView);
        if (mListPopupWindow.isShowing())
            mListPopupWindow.dismiss();
    }

    @Override
    public void showError() {
        loaddingError();
    }

    @Override
    public void complete() {
        mRecyclerView.setRefreshing(false);
    }

    @Override
    public void onItemClick(int position) {
        SearchDetail.SearchBooks data = mAdapter.getItem(position);
        BookDetailActivity.startActivity(this, data._id);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search,menu);
        searchMenuItem = menu.findItem(R.id.action_search);//在菜单中找到对应控件的item
        searchView = (SearchView) MenuItemCompat.getActionView(searchMenuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                key = query;
                mPresenter.getSearchResultList(query);
                saveSearchHistory(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    if (mListPopupWindow.isShowing())
                        mListPopupWindow.dismiss();
                    initTagGroup();
                } else {
                    mPresenter.getAutoCompleteList(newText);
                }
                return false;
            }
        });
        search(key); // 外部调用搜索，则打开页面立即进行搜索
        MenuItemCompat.setOnActionExpandListener(searchMenuItem,
                new MenuItemCompat.OnActionExpandListener() {//设置打开关闭动作监听
                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item) {
                        return true;
                    }

                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem item) {
                        initTagGroup();
                        return true;
                    }
                });
        return true;
    }

    /**
     * 保存搜索记录.不重复，最多保存20条
     *
     * @param query
     */
    private void saveSearchHistory(String query) {
        List<String> list = CacheManager.getInstance().getSearchHistory();
        if (list == null) {
            list = new ArrayList<>();
            list.add(query);
        } else {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String item = iterator.next();
                if (TextUtils.equals(query, item)) {
                    iterator.remove();
                }
            }
            list.add(0, query);
        }
        int size = list.size();
        if (size > 20) { // 最多保存20条
            for (int i = size - 1; i >= 20; i--) {
                list.remove(i);
            }
        }
        CacheManager.getInstance().saveSearchHistory(list);
        initSearchHistory();
    }

    private void initSearchHistory() {
        List<String> list = CacheManager.getInstance().getSearchHistory();
        mHisAdapter.clear();
        if (list != null && list.size() > 0) {
            tvClear.setEnabled(true);
            mHisAdapter.addAll(list);
        } else {
            tvClear.setEnabled(false);
        }
        mHisAdapter.notifyDataSetChanged();
    }

    private void initTagGroup() {
        visible(mTagGroup, mLayoutHotWord, rlHistory);
        gone(mRecyclerView);
        if (mListPopupWindow.isShowing())
            mListPopupWindow.dismiss();
    }

    @OnClick(R.id.tvClear)
    public void clearSearchHistory() {
        CacheManager.getInstance().saveSearchHistory(null);
        initSearchHistory();
    }

    /**
     * 展开SearchView进行查询
     *
     * @param key
     */
    private void search(String key) {
        MenuItemCompat.expandActionView(searchMenuItem);
        if (!TextUtils.isEmpty(key)) {
            searchView.setQuery(key, true);
            saveSearchHistory(key);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
