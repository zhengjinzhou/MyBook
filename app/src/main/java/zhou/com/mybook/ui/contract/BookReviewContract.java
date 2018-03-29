package zhou.com.mybook.ui.contract;

import java.util.List;

import zhou.com.mybook.base.BaseContract;
import zhou.com.mybook.bean.BookReviewList;

/**
 * Created by zhou on 2018/3/22.
 */

public interface BookReviewContract {

    interface View extends BaseContract.BaseView {
        void showBookReviewList(List<BookReviewList.ReviewsBean> list, boolean isRefresh);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getBookReviewList(String sort, String type, String distillate, int start, int limit);
    }

}
