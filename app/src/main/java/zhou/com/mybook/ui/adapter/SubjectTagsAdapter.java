package zhou.com.mybook.ui.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yuyh.easyadapter.recyclerview.EasyRVAdapter;
import com.yuyh.easyadapter.recyclerview.EasyRVHolder;

import java.util.List;

import zhou.com.mybook.R;
import zhou.com.mybook.bean.TagTypeBean;
import zhou.com.mybook.common.OnRvItemClickListener;

/**
 * Created by zhou on 2018/3/21.
 */

public class SubjectTagsAdapter extends EasyRVAdapter<TagTypeBean.DataBean> {

    private OnRvItemClickListener listener;

    public SubjectTagsAdapter(Context context, List<TagTypeBean.DataBean> list) {
        super(context, list, R.layout.item_subject_tags_list);
    }

    @Override
    protected void onBindData(EasyRVHolder viewHolder, int position, TagTypeBean.DataBean item) {
        RecyclerView rvTagsItem = viewHolder.getView(R.id.rvTagsItem);
        rvTagsItem.setHasFixedSize(true);
        rvTagsItem.setLayoutManager(new GridLayoutManager(mContext, 4));
        TagsItemAdapter adapter = new TagsItemAdapter(mContext, item.getTags());
        rvTagsItem.setAdapter(adapter);

        viewHolder.setText(R.id.tvTagGroupName, item.getName());
    }

    class TagsItemAdapter extends EasyRVAdapter<String> {

        public TagsItemAdapter(Context context, List<String> list) {
            super(context, list, R.layout.item_subject_tag_list);
        }

        @Override
        protected void onBindData(EasyRVHolder viewHolder, final int position, final String item) {
            viewHolder.setText(R.id.tvTagName, item);
            viewHolder.getItemView().setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClick(v, position, item);
                }
            });
        }
    }

    public void setItemClickListener(OnRvItemClickListener<String> listener) {
        this.listener = listener;
    }
}
