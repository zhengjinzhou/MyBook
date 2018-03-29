package zhou.com.mybook.ui.contract;

import zhou.com.mybook.base.BaseContract;
import zhou.com.mybook.bean.TagTypeBean;

/**
 * Created by zhou on 2018/3/21.
 */

public interface SubjectBookListContract {
    interface View extends BaseContract.BaseView{
        void showBookListTags(TagTypeBean data);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T>{
        void getBookListTags();
    }
}
