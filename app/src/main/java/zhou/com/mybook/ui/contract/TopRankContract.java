package zhou.com.mybook.ui.contract;

import zhou.com.mybook.base.BaseContract;
import zhou.com.mybook.bean.TopRankBean;

/**
 * Created by zhou on 2018/3/21.
 */

public interface TopRankContract {
    interface View extends BaseContract.BaseView {
        void showRankList(TopRankBean topRankBean);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getRankList();
    }
}
