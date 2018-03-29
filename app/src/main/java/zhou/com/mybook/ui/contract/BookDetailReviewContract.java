package zhou.com.mybook.ui.contract;

import java.util.List;

import zhou.com.mybook.base.BaseContract;
import zhou.com.mybook.bean.HotReview;

/**
 * Created by zhou on 2018/3/23.
 */

public interface BookDetailReviewContract {

    interface View extends BaseContract.BaseView {
        void showBookDetailReviewList(List<HotReview.Reviews> list, boolean isRefresh);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getBookDetailReviewList(String bookId, String sort, int start, int limit);
    }
}
