package zhou.com.mybook.ui.contract;

import zhou.com.mybook.base.BaseContract;
import zhou.com.mybook.bean.CategoryListLv2;

/**
 * Created by zhou on 2018/3/21.
 */

public interface SubCategoryActivityContract {
    interface View extends BaseContract.BaseView {
        void showCategoryList(CategoryListLv2 data);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getCategoryListLv2();
    }
}
