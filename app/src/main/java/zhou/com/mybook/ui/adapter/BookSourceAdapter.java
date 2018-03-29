package zhou.com.mybook.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import zhou.com.mybook.R;
import zhou.com.mybook.bean.BookSource;
import zhou.com.mybook.view.LetterView;
import zhou.com.mybook.view.recyclerview.adapter.BaseViewHolder;
import zhou.com.mybook.view.recyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by zhou on 2018/3/26.
 */

public class BookSourceAdapter extends RecyclerArrayAdapter<BookSource> {


    public BookSourceAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseViewHolder<BookSource>(parent, R.layout.item_book_source) {
            @Override
            public void setData(BookSource item) {
                holder.setText(R.id.tv_source_title, item.host)
                        .setText(R.id.tv_source_content, item.lastChapter);

                LetterView letterView = holder.getView(R.id.letter_view);
                letterView.setText(item.host);
            }
        };
    }
}
