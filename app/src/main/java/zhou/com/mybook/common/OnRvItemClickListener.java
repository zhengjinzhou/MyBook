package zhou.com.mybook.common;

import android.view.View;

/**
 * Created by zhou on 2018/3/20.
 */

public interface OnRvItemClickListener<T> {
    void onItemClick(View view,int position,T data);
}
