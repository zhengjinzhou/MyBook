package zhou.com.mybook.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yuyh.easyadapter.glide.GlideCircleTransform;
import com.yuyh.easyadapter.glide.GlideRoundTransform;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseRVActivity;
import zhou.com.mybook.base.Constant;
import zhou.com.mybook.bean.BookReview;
import zhou.com.mybook.bean.CommentList;
import zhou.com.mybook.common.OnRvItemClickListener;
import zhou.com.mybook.ui.adapter.BestCommentListAdapter;
import zhou.com.mybook.ui.adapter.CommentListAdapter;
import zhou.com.mybook.ui.contract.BookReviewDetailContract;
import zhou.com.mybook.ui.presenter.BookReviewDetailPresenter;
import zhou.com.mybook.utils.FormatUtils;
import zhou.com.mybook.view.BookContentTextView;
import zhou.com.mybook.view.SupportDividerItemDecoration;
import zhou.com.mybook.view.XLHRatingBar;
import zhou.com.mybook.view.recyclerview.adapter.RecyclerArrayAdapter;

/**
 * 书评区详情
 */
public class BookReviewDetailActivity extends BaseRVActivity<CommentList.CommentsBean> implements BookReviewDetailContract.View, OnRvItemClickListener<CommentList.CommentsBean> {

    private static final String INTENT_ID = "id";

    public static void startActivity(Context context, String id) {
        context.startActivity(new Intent(context, BookReviewDetailActivity.class)
                .putExtra(INTENT_ID, id));
    }

    private String id;
    private List<CommentList.CommentsBean> mBestCommentList = new ArrayList<>();
    private BestCommentListAdapter mBestCommentListAdapter;
    private HeaderViewHolder headerViewHolder;

    static class HeaderViewHolder {
        @BindView(R.id.ivAuthorAvatar)
        ImageView ivAuthorAvatar;
        @BindView(R.id.tvBookAuthor)
        TextView tvBookAuthor;
        @BindView(R.id.tvTime)
        TextView tvTime;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvContent)
        BookContentTextView tvContent;
        @BindView(R.id.rlBookInfo)
        RelativeLayout rlBookInfo;
        @BindView(R.id.ivBookCover)
        ImageView ivBookCover;
        @BindView(R.id.tvBookTitle)
        TextView tvBookTitle;
        @BindView(R.id.tvHelpfullYesCount)
        TextView tvHelpfullYesCount;
        @BindView(R.id.tvHelpfullNoCount)
        TextView tvHelpfullNoCount;
        @BindView(R.id.tvBestComments)
        TextView tvBestComments;
        @BindView(R.id.rvBestComments)
        RecyclerView rvBestComments;
        @BindView(R.id.tvCommentCount)
        TextView tvCommentCount;
        @BindView(R.id.rating)
        XLHRatingBar ratingBar;

        public HeaderViewHolder(View view) {
            ButterKnife.bind(this, view);   //view绑定
        }
    }

    private BookReviewDetailPresenter mPresenter = new BookReviewDetailPresenter(this);

    @Override
    public int getLayout() {
        return R.layout.activity_book_review_detail;
    }

    @Override
    public void initToolBar() {
        common_toolbar.setTitle("书评详情");
        common_toolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initData() {
        id = getIntent().getStringExtra(INTENT_ID);

        mPresenter.attachView(this);
        mPresenter.getBookReviewDetail(id);
        mPresenter.getBestComments(id);
        mPresenter.getBookReviewComments(id,start, limit);
    }

    @Override
    public void configView() {
        initAdapter(CommentListAdapter.class, false, true);

        mAdapter.addHeader(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                View headerView =  LayoutInflater.from(BookReviewDetailActivity.this).inflate(R.layout.header_view_book_review_detail, parent, false);
                return headerView;
            }

            @Override
            public void onBindView(View headerView) {
                headerViewHolder = new HeaderViewHolder(headerView);
            }
        });
    }

    @Override
    public void onItemClick(View view, int position, CommentList.CommentsBean data) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    @Override
    public void showBookReviewDetail(BookReview data) {
        Glide.with(mContext)
                .load(Constant.IMG_BASE_URL + data.review.author.avatar)
                .placeholder(R.drawable.avatar_default)
                .transform(new GlideCircleTransform(mContext))
                .into(headerViewHolder.ivAuthorAvatar);

        headerViewHolder.tvBookAuthor.setText(data.review.author.nickname);
        headerViewHolder.tvTime.setText(FormatUtils.getDescriptionTimeFromDateString(data.review.created));
        headerViewHolder.tvTitle.setText(data.review.title);
        headerViewHolder.tvContent.setText(data.review.content);

        Glide.with(mContext)
                .load(Constant.IMG_BASE_URL + data.review.book.cover)
                .placeholder(R.drawable.cover_default)
                .transform(new GlideRoundTransform(mContext))
                .into(headerViewHolder.ivBookCover);
        headerViewHolder.tvBookTitle.setText(data.review.book.title);

        headerViewHolder.tvHelpfullYesCount.setText(String.valueOf(data.review.helpful.yes));
        headerViewHolder.tvHelpfullNoCount.setText(String.valueOf(data.review.helpful.no));

        headerViewHolder.tvCommentCount.setText(String.format(mContext.getString(R.string.comment_comment_count), data.review.commentCount));

        headerViewHolder.rlBookInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookDetailActivity.startActivity(BookReviewDetailActivity.this, data.review.book._id);
            }
        });

        headerViewHolder.ratingBar.setCountSelected(data.review.rating);
    }

    @Override
    public void showBestComments(CommentList list) {
        if(list.comments.isEmpty()){
            gone(headerViewHolder.tvBestComments, headerViewHolder.rvBestComments);
        }else{
            mBestCommentList.addAll(list.comments);
            headerViewHolder.rvBestComments.setHasFixedSize(true);
            headerViewHolder.rvBestComments.setLayoutManager(new LinearLayoutManager(this));
            headerViewHolder.rvBestComments.addItemDecoration(new SupportDividerItemDecoration(mContext, LinearLayoutManager.VERTICAL, true));
            mBestCommentListAdapter = new BestCommentListAdapter(mContext, mBestCommentList);
            mBestCommentListAdapter.setOnItemClickListener(this);
            headerViewHolder.rvBestComments.setAdapter(mBestCommentListAdapter);
            visible(headerViewHolder.tvBestComments, headerViewHolder.rvBestComments);
        }
    }

    @Override
    public void showBookReviewComments(CommentList list) {
        mAdapter.addAll(list.comments);
        start=start+list.comments.size();
    }

    @Override
    public void onLoadMore() {
        super.onLoadMore();
        mPresenter.getBookReviewComments(id,start, limit);
    }

    @Override
    public void onItemClick(int position) {
        CommentList.CommentsBean data  = mAdapter.getItem(position);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
