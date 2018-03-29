package zhou.com.mybook.bean.support;

import zhou.com.mybook.base.Constant;

/**
 * Created by zhou on 2018/3/21.
 */

public class SelectionEvent {

    public String distillate;

    public String type;

    public String sort;

    public SelectionEvent(@Constant.Distillate String distillate,
                          @Constant.BookType String type,
                          @Constant.SortType String sort) {
        this.distillate = distillate;
        this.type = type;
        this.sort = sort;
    }

    public SelectionEvent(@Constant.SortType String sort) {
        this.sort = sort;
    }
}