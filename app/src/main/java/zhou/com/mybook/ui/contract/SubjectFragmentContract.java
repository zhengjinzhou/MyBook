package zhou.com.mybook.ui.contract;

import java.util.List;

import zhou.com.mybook.base.BaseContract;
import zhou.com.mybook.bean.BookLists;

/**
 * Created by zhou on 2018/3/22.
 * 主题书单------本周最热-最新发布-最多收藏
 */

public interface SubjectFragmentContract {
    interface View extends BaseContract.BaseView{
        void showBookList(List<BookLists.BookListsBean> bookLists, boolean isRefresh);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getBookLists(String duration, String sort, int start, int limit, String tag, String gender);
    }
}
