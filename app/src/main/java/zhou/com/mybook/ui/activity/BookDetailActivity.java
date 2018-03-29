package zhou.com.mybook.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yuyh.easyadapter.glide.GlideRoundTransform;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseActivity;
import zhou.com.mybook.base.BookApplication;
import zhou.com.mybook.base.Constant;
import zhou.com.mybook.bean.BookDetail;
import zhou.com.mybook.bean.BookLists;
import zhou.com.mybook.bean.HotReview;
import zhou.com.mybook.bean.Recommend;
import zhou.com.mybook.bean.RecommendBookList;
import zhou.com.mybook.bean.support.RefreshCollectionIconEvent;
import zhou.com.mybook.common.OnRvItemClickListener;
import zhou.com.mybook.manager.CollectionsManager;
import zhou.com.mybook.ui.adapter.HotReviewAdapter;
import zhou.com.mybook.ui.adapter.RecommendBookListAdapter;
import zhou.com.mybook.ui.contract.BookDetailContract;
import zhou.com.mybook.ui.presenter.BookDetailPresenter;
import zhou.com.mybook.utils.FormatUtils;
import zhou.com.mybook.utils.ToastUtils;
import zhou.com.mybook.view.DrawableCenterButton;
import zhou.com.mybook.view.TagColor;
import zhou.com.mybook.view.TagGroup;

public class BookDetailActivity extends BaseActivity implements BookDetailContract.View, OnRvItemClickListener<Object> {

    @BindView(R.id.ivBookCover) ImageView mIvBookCover;
    @BindView(R.id.tvBookListTitle) TextView mTvBookTitle;
    @BindView(R.id.tvBookListAuthor) TextView mTvAuthor;
    @BindView(R.id.tvCatgory) TextView mTvCatgory;
    @BindView(R.id.tvWordCount) TextView mTvWordCount;
    @BindView(R.id.tvLatelyUpdate) TextView mTvLatelyUpdate;
    @BindView(R.id.btnRead) DrawableCenterButton mBtnRead;
    @BindView(R.id.btnJoinCollection) DrawableCenterButton mBtnJoinCollection;
    @BindView(R.id.tvLatelyFollower) TextView mTvLatelyFollower;
    @BindView(R.id.tvRetentionRatio) TextView mTvRetentionRatio;
    @BindView(R.id.tvSerializeWordCount) TextView mTvSerializeWordCount;
    @BindView(R.id.tag_group) TagGroup mTagGroup;
    @BindView(R.id.tvlongIntro) TextView mTvlongIntro;
    @BindView(R.id.tvMoreReview) TextView mTvMoreReview;
    @BindView(R.id.rvHotReview) RecyclerView mRvHotReview;
    @BindView(R.id.rlCommunity) RelativeLayout mRlCommunity;
    @BindView(R.id.tvCommunity) TextView mTvCommunity;
    @BindView(R.id.tvHelpfulYes) TextView mTvPostCount;
    @BindView(R.id.tvRecommendBookList) TextView mTvRecommendBookList;
    @BindView(R.id.rvRecommendBoookList) RecyclerView mRvRecommendBoookList;

    public static String INTENT_BOOK_ID = "bookId";
    private String bookId;
    private BookDetailPresenter mPresenter = new BookDetailPresenter(this);

    private List<String> tagList = new ArrayList<>();
    private int times = 0;
    private HotReviewAdapter mHotReviewAdapter;
    private RecommendBookListAdapter mRecommendBookListAdapter;
    private List<HotReview.Reviews> mHotReviewList = new ArrayList<>();
    private List<RecommendBookList.RecommendBook> mRecommendBookList = new ArrayList<>();
    private Recommend.RecommendBooks recommendBooks;
    private boolean isJoinedCollections = false;
    private boolean collapseLongIntro = true;

    public static void startActivity(Context context, String bookId) {
        context.startActivity(new Intent(context, BookDetailActivity.class)
                .putExtra(INTENT_BOOK_ID, bookId));
    }

    @Override
    public int getLayout() {
        return R.layout.activity_book_detail;
    }

    @Override
    public void initToolBar() {
        common_toolbar.setTitle("书籍详情");
        common_toolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initData() {
        bookId = getIntent().getStringExtra(INTENT_BOOK_ID);
        EventBus.getDefault().register(this);
    }

    @Override
    public void configView() {
        showDialog();

        mRvHotReview.setHasFixedSize(true);
        mRvHotReview.setLayoutManager(new LinearLayoutManager(this));
        mHotReviewAdapter = new HotReviewAdapter(mContext, mHotReviewList, this);
        mRvHotReview.setAdapter(mHotReviewAdapter);

        mRvRecommendBoookList.setHasFixedSize(true);
        mRvRecommendBoookList.setLayoutManager(new LinearLayoutManager(this));
        mRecommendBookListAdapter = new RecommendBookListAdapter(mContext, mRecommendBookList, this);
        mRvRecommendBoookList.setAdapter(mRecommendBookListAdapter);

        mTagGroup.setOnTagClickListener(tag -> startActivity(new Intent(BookDetailActivity.this, BooksByTagActivity.class)
                .putExtra("tag", tag)));
        mPresenter.attachView(this);
        mPresenter.getBookDetail(bookId);
        mPresenter.getHotReview(bookId);
        mPresenter.getRecommendBookList(bookId, "3");
    }

    @Override
    public void onItemClick(View view, int position, Object data) {
        if (data instanceof HotReview.Reviews) {
            BookDiscussionDetailActivity.startActivity(this, ((HotReview.Reviews) data)._id);
        } else if (data instanceof RecommendBookList.RecommendBook) {
            RecommendBookList.RecommendBook recommendBook = (RecommendBookList.RecommendBook) data;

            BookLists bookLists = new BookLists();
            BookLists.BookListsBean bookListsBean = bookLists.new BookListsBean();
            bookListsBean._id = recommendBook.id;
            bookListsBean.author = recommendBook.author;
            bookListsBean.bookCount = recommendBook.bookCount;
            bookListsBean.collectorCount = recommendBook.collectorCount;
            bookListsBean.cover = recommendBook.cover;
            bookListsBean.desc = recommendBook.desc;
            bookListsBean.title = recommendBook.title;

            SubjectBookListDetailActivity.startActivity(this, bookListsBean);
        }
    }

    @OnClick(R.id.btnJoinCollection)
    public void onClickJoinCollection() {
        if (!isJoinedCollections) {
            if (recommendBooks != null) {
                CollectionsManager.getInstance().add(recommendBooks);
                ToastUtils.showToast(String.format(getString(
                        R.string.book_detail_has_joined_the_book_shelf), recommendBooks.title));
                initCollection(false);
            }
        } else {
            CollectionsManager.getInstance().remove(recommendBooks._id);
            ToastUtils.showToast(String.format(getString(
                    R.string.book_detail_has_remove_the_book_shelf), recommendBooks.title));
            initCollection(true);
        }
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {
        dismissDialog();
    }

    @Override
    public void showBookDetail(BookDetail data) {
        Glide.with(mContext)
                .load(Constant.IMG_BASE_URL + data.cover)
                .placeholder(R.drawable.cover_default)
                .transform(new GlideRoundTransform(mContext))
                .into(mIvBookCover);

        mTvBookTitle.setText(data.title);
        mTvAuthor.setText(String.format(getString(R.string.book_detail_author), data.author));
        mTvCatgory.setText(String.format(getString(R.string.book_detail_category), data.cat));
        mTvWordCount.setText(FormatUtils.formatWordCount(data.wordCount));
        mTvLatelyUpdate.setText(FormatUtils.getDescriptionTimeFromDateString(data.updated));
        mTvLatelyFollower.setText(String.valueOf(data.latelyFollower));
        mTvRetentionRatio.setText(TextUtils.isEmpty(data.retentionRatio) ?
                "-" : String.format(getString(R.string.book_detail_retention_ratio),
                data.retentionRatio));
        mTvSerializeWordCount.setText(data.serializeWordCount < 0 ? "-" :
                String.valueOf(data.serializeWordCount));

        tagList.clear();
        tagList.addAll(data.tags);
        times = 0;
        showHotWord();

        mTvlongIntro.setText(data.longIntro);
        mTvCommunity.setText(String.format(getString(R.string.book_detail_community), data.title));
        mTvPostCount.setText(String.format(getString(R.string.book_detail_post_count), data.postCount));

        recommendBooks = new Recommend.RecommendBooks();
        recommendBooks.title = data.title;
        recommendBooks._id = data._id;
        recommendBooks.cover = data.cover;
        recommendBooks.lastChapter = data.lastChapter;
        recommendBooks.updated = data.updated;

        refreshCollectionIcon();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void RefreshCollectionIcon(RefreshCollectionIconEvent event) {
        refreshCollectionIcon();
    }

    /**
     * 刷新收藏图标
     */
    private void refreshCollectionIcon() {
        if (CollectionsManager.getInstance().isCollected(recommendBooks._id)) {
            initCollection(false);
        } else {
            initCollection(true);
        }
    }

    private void initCollection(boolean coll) {
        if (coll) {
            mBtnJoinCollection.setText(R.string.book_detail_join_collection);
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.book_detail_info_add_img);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            mBtnJoinCollection.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.shape_common_btn_solid_normal));
            mBtnJoinCollection.setCompoundDrawables(drawable, null, null, null);
            mBtnJoinCollection.postInvalidate();
            isJoinedCollections = false;
        } else {
            mBtnJoinCollection.setText(R.string.book_detail_remove_collection);
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.book_detail_info_del_img);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            mBtnJoinCollection.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.btn_join_collection_pressed));
            mBtnJoinCollection.setCompoundDrawables(drawable, null, null, null);
            mBtnJoinCollection.postInvalidate();
            isJoinedCollections = true;
        }
    }

    @OnClick(R.id.btnRead)
    public void onClickRead() {
        if (recommendBooks == null) return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.System.canWrite(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS,
                        Uri.parse("package:" + BookApplication.getInstance().getPackageName()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivityForResult(intent, 1);
            } else {
                //有了权限，你要做什么呢？具体的动作
                ReadActivity.startActivity(this, recommendBooks);
            }
        }
    }

    @OnClick(R.id.tvBookListAuthor)
    public void searchByAuthor() {
        String author = mTvAuthor.getText().toString().replaceAll(" ", "");
        SearchByAuthorActivity.startActivity(this, author);
    }

    @OnClick(R.id.tvlongIntro)
    public void collapseLongIntro() {
        if (collapseLongIntro) {
            mTvlongIntro.setMaxLines(20);
            collapseLongIntro = false;
        } else {
            mTvlongIntro.setMaxLines(4);
            collapseLongIntro = true;
        }
    }

    @OnClick(R.id.tvMoreReview)
    public void onClickMoreReview() {
       // Log.d("", "onClickMoreReview: "+bookId+"   "+mTvBookTitle.getText());
        BookDetailCommunityActivity.startActivity(this, bookId, mTvBookTitle.getText().toString(), 1);
    }

    @OnClick(R.id.rlCommunity)
    public void onClickCommunity() {
        BookDetailCommunityActivity.startActivity(this, bookId, mTvBookTitle.getText().toString(), 0);
    }

    @Override
    public void showHotReview(List<HotReview.Reviews> list) {
        mHotReviewList.clear();
        mHotReviewList.addAll(list);
        mHotReviewAdapter.notifyDataSetChanged();
    }

    @Override
    public void showRecommendBookList(List<RecommendBookList.RecommendBook> list) {
        if (!list.isEmpty()) {
            mTvRecommendBookList.setVisibility(View.VISIBLE);
            mRecommendBookList.clear();
            mRecommendBookList.addAll(list);
            mRecommendBookListAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    /**
     * 每次显示8个
     */
    private void showHotWord() {
        int start, end;
        if (times < tagList.size() && times + 8 <= tagList.size()) {
            start = times;
            end = times + 8;
        } else if (times < tagList.size() - 1 && times + 8 > tagList.size()) {
            start = times;
            end = tagList.size() - 1;
        } else {
            start = 0;
            end = tagList.size() > 8 ? 8 : tagList.size();
        }
        times = end;
        if (end - start > 0) {
            List<String> batch = tagList.subList(start, end);
            List<TagColor> colors = TagColor.getRandomColors(batch.size());
            mTagGroup.setTags(colors, (String[]) batch.toArray(new String[batch.size()]));
        }
    }
}
