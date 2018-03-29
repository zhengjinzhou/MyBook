package zhou.com.mybook.ui.adapter;

import android.content.Context;
import android.view.View;

import com.yuyh.easyadapter.recyclerview.EasyRVAdapter;
import com.yuyh.easyadapter.recyclerview.EasyRVHolder;

import java.util.List;

import zhou.com.mybook.R;
import zhou.com.mybook.bean.FindBean;
import zhou.com.mybook.common.OnRvItemClickListener;

/**
 * Created by zhou on 2018/3/20.
 *
 */

public class FindAdapter extends EasyRVAdapter<FindBean> {

    private OnRvItemClickListener itemClickListener;

    public FindAdapter(Context context, List<FindBean> list, OnRvItemClickListener listener) {
        super(context, list, R.layout.item_find);
        this.itemClickListener = listener;
    }

    @Override
    protected void onBindData(final EasyRVHolder holder, final int position, final FindBean item) {
        holder.setText(R.id.tvTitle,item.getTitle());
        holder.setImageResource(R.id.ivIcon,item.getIcon());
        holder.setOnItemViewClickListener(v -> itemClickListener.onItemClick(holder.getItemView(),position,item));
    }
}
