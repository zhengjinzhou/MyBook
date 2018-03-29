package zhou.com.mybook.ui.contract;

import zhou.com.mybook.base.BaseContract;
import zhou.com.mybook.bean.BookHelp;
import zhou.com.mybook.bean.CommentList;

/**
 * Created by zhou on 2018/3/23.
 */

public interface BookHelpDetailContract {

    interface View extends BaseContract.BaseView {

        void showBookHelpDetail(BookHelp data);

        void showBestComments(CommentList list);

        void showBookHelpComments(CommentList list);

    }

    interface Presenter extends BaseContract.BasePresenter<View> {

        void getBookHelpDetail(String id);

        void getBestComments(String helpId);

        void getBookHelpComments(String helpId, int start, int limit);

    }

}
