package zhou.com.mybook.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import zhou.com.mybook.R;
import zhou.com.mybook.base.Constant;
import zhou.com.mybook.bean.BookLists;
import zhou.com.mybook.manager.SettingManager;
import zhou.com.mybook.view.recyclerview.adapter.BaseViewHolder;
import zhou.com.mybook.view.recyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by zhou on 2018/3/22.
 */

public class SubjectBookListAdapter extends RecyclerArrayAdapter<BookLists.BookListsBean> {

    public SubjectBookListAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseViewHolder<BookLists.BookListsBean>(parent, R.layout.item_sub_category_list) {
            @Override
            public void setData(BookLists.BookListsBean item) {
                super.setData(item);
                if (!SettingManager.getInstance().isNoneCover()) {
                    holder.setRoundImageUrl(R.id.ivSubCateCover, Constant.IMG_BASE_URL + item.cover,
                            R.drawable.cover_default);
                } else {
                    holder.setImageResource(R.id.ivSubCateCover, R.drawable.cover_default);
                }

                holder.setText(R.id.tvSubCateTitle, item.title)
                        .setText(R.id.tvSubCateAuthor, item.author)
                        .setText(R.id.tvSubCateShort, item.desc)
                        .setText(R.id.tvSubCateMsg, String.format(mContext.getResources().getString(R.string.subject_book_msg), item.bookCount, item.collectorCount));
            }
        };
    }
}
