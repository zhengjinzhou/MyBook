package zhou.com.mybook.ui.contract;

import zhou.com.mybook.base.BaseContract;
import zhou.com.mybook.bean.BookReview;
import zhou.com.mybook.bean.CommentList;

/**
 * Created by zhou on 2018/3/23.
 */

public interface BookReviewDetailContract {

    interface View extends BaseContract.BaseView {

        void showBookReviewDetail(BookReview data);

        void showBestComments(CommentList list);

        void showBookReviewComments(CommentList list);

    }

    interface Presenter extends BaseContract.BasePresenter<View> {

        void getBookReviewDetail(String id);

        void getBestComments(String bookReviewId);

        void getBookReviewComments(String bookReviewId, int start, int limit);

    }

}
