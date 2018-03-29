package zhou.com.mybook.ui.contract;

import java.util.List;

import zhou.com.mybook.base.BaseContract;
import zhou.com.mybook.bean.BookSource;

/**
 * Created by zhou on 2018/3/26.
 */

public interface BookSourceContract {

    interface View extends BaseContract.BaseView {
        void showBookSource(List<BookSource> list);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getBookSource(String view, String book);
    }

}
