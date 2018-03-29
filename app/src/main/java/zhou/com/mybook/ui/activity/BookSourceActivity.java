package zhou.com.mybook.ui.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseRVActivity;
import zhou.com.mybook.bean.BookSource;
import zhou.com.mybook.ui.adapter.BookSourceAdapter;
import zhou.com.mybook.ui.contract.BookSourceContract;
import zhou.com.mybook.ui.presenter.BookSourcePresenter;

public class BookSourceActivity extends BaseRVActivity<BookSource> implements BookSourceContract.View  {

    public static final String INTENT_BOOK_ID = "bookId";
    private String bookId = "";
    public static void start(Activity activity, String bookId, int reqId) {
        activity.startActivityForResult(new Intent(activity, BookSourceActivity.class)
                .putExtra(INTENT_BOOK_ID, bookId), reqId);
    }

    private BookSourcePresenter mPresenter = new BookSourcePresenter(this);

    @Override
    public int getLayout() {
        return R.layout.activity_book_source;
    }

    @Override
    public void initToolBar() {
        bookId = getIntent().getStringExtra(INTENT_BOOK_ID);
        common_toolbar.setTitle("选择来源");
        common_toolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initData() {
        initAdapter(BookSourceAdapter.class, false, false);
    }

    @Override
    public void configView() {
        mPresenter.attachView(this);
        mPresenter.getBookSource("summary", bookId);

        new AlertDialog.Builder(this)
                .setMessage("换源功能暂未实现，后续更新...")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
    }

    @Override
    public void showBookSource(List<BookSource> list) {
        mAdapter.clear();
        mAdapter.addAll(list);
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
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void onItemClick(int position) {
        BookSource data = mAdapter.getItem(position);
        Intent intent = new Intent();
        intent.putExtra("source", data);
        setResult(RESULT_OK, intent);
        finish();
    }
}
