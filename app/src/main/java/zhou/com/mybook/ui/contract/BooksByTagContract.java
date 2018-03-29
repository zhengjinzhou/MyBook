package zhou.com.mybook.ui.contract;

import java.util.List;

import zhou.com.mybook.base.BaseContract;
import zhou.com.mybook.bean.BooksByTag;

/**
 * Created by zhou on 2018/3/26.
 */

public interface BooksByTagContract {

    interface View extends BaseContract.BaseView {
        void showBooksByTag(List<BooksByTag.TagBook> list, boolean isRefresh);

        void onLoadComplete(boolean isSuccess, String msg);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getBooksByTag(String tags, String start, String limit);
    }

}
