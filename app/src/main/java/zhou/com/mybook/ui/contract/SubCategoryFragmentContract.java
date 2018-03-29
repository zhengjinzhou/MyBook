package zhou.com.mybook.ui.contract;

import zhou.com.mybook.base.BaseContract;
import zhou.com.mybook.bean.BooksByCats;

/**
 * Created by zhou on 2018/3/22.
 */

public interface SubCategoryFragmentContract {
    interface View extends BaseContract.BaseView{
        void showCategoryList(BooksByCats data, boolean isRefresh);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getCategoryList(String gender, String major, String minor, String type, int start, int limit);
    }
}
