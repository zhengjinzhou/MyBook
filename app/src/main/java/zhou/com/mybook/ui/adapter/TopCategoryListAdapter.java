package zhou.com.mybook.ui.adapter;

import android.content.Context;
import android.view.View;

import com.yuyh.easyadapter.recyclerview.EasyRVAdapter;
import com.yuyh.easyadapter.recyclerview.EasyRVHolder;

import java.util.List;

import zhou.com.mybook.R;
import zhou.com.mybook.bean.CategoryList;
import zhou.com.mybook.common.OnRvItemClickListener;

/**
 * Created by zhou on 2018/3/21.
 */

public class TopCategoryListAdapter extends EasyRVAdapter<CategoryList.MaleBean>{

    private OnRvItemClickListener itemClickListener;

    public TopCategoryListAdapter(Context context, List<CategoryList.MaleBean> list, OnRvItemClickListener itemClickListener) {
        super(context, list, R.layout.item_top_category_list);
        this.itemClickListener = itemClickListener;
    }

    @Override
    protected void onBindData(EasyRVHolder viewHolder, int position, CategoryList.MaleBean item) {
        viewHolder.setText(R.id.tvName,item.getName());
        viewHolder.setText(R.id.tvBookCount,String.format(mContext.getString(R.string
                .category_book_count),item.getBookCount()));
        viewHolder.setOnItemViewClickListener(v -> itemClickListener.onItemClick(viewHolder.getItemView(),position,item));
    }
}
