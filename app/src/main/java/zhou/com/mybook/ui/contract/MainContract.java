package zhou.com.mybook.ui.contract;

import zhou.com.mybook.base.BaseContract;

/**
 * Created by zhou on 2018/3/22.
 */

public interface MainContract {

    interface View extends BaseContract.BaseView {
        //void loginSuccess();

        void syncBookShelfCompleted();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        //void login(String uid, String token, String platform);

        void syncBookShelf();
    }

}