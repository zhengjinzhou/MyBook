package zhou.com.mybook.ui.easyadapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.text.NumberFormat;

import zhou.com.mybook.R;
import zhou.com.mybook.base.Constant;
import zhou.com.mybook.bean.Recommend;
import zhou.com.mybook.manager.SettingManager;
import zhou.com.mybook.utils.FileUtils;
import zhou.com.mybook.utils.FormatUtils;
import zhou.com.mybook.view.recyclerview.adapter.BaseViewHolder;
import zhou.com.mybook.view.recyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by zhou on 2018/3/22.
 */

public class RecommendAdapter extends RecyclerArrayAdapter<Recommend.RecommendBooks> {

    public RecommendAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseViewHolder<Recommend.RecommendBooks>(parent, R.layout.item_recommend_list) {
            @Override
            public void setData(final Recommend.RecommendBooks item) {
                super.setData(item);
                String latelyUpdate = "";
                if (!TextUtils.isEmpty(FormatUtils.getDescriptionTimeFromDateString(item.updated))) {
                    latelyUpdate = FormatUtils.getDescriptionTimeFromDateString(item.updated) + ":";
                }

                holder.setText(R.id.tvRecommendTitle, item.title)
                        .setText(R.id.tvLatelyUpdate, latelyUpdate)
                        .setText(R.id.tvRecommendShort, item.lastChapter)
                        .setVisible(R.id.ivTopLabel, item.isTop)
                        .setVisible(R.id.ckBoxSelect, item.showCheckBox)
                        .setVisible(R.id.ivUnReadDot, FormatUtils.formatZhuiShuDateString(item.updated)
                                .compareTo(item.recentReadingTime) > 0);

                if (item.path != null && item.path.endsWith(Constant.SUFFIX_PDF)) {
                    holder.setImageResource(R.id.ivRecommendCover, R.drawable.ic_shelf_pdf);
                } else if (item.path != null && item.path.endsWith(Constant.SUFFIX_EPUB)) {
                    holder.setImageResource(R.id.ivRecommendCover, R.drawable.ic_shelf_epub);
                } else if (item.path != null && item.path.endsWith(Constant.SUFFIX_CHM)) {
                    holder.setImageResource(R.id.ivRecommendCover, R.drawable.ic_shelf_chm);
                } else if (item.isFromSD) {
                    holder.setImageResource(R.id.ivRecommendCover, R.drawable.ic_shelf_txt);
                    long fileLen = FileUtils.getChapterFile(item._id, 1).length();
                    if (fileLen > 10) {
                        double progress = ((double) SettingManager.getInstance().getReadProgress(item._id)[2]) / fileLen;
                        NumberFormat fmt = NumberFormat.getPercentInstance();
                        fmt.setMaximumFractionDigits(2);
                        holder.setText(R.id.tvRecommendShort, "当前阅读进度：" + fmt.format(progress));
                    }
                } else if (!SettingManager.getInstance().isNoneCover()) {
                    holder.setRoundImageUrl(R.id.ivRecommendCover, Constant.IMG_BASE_URL + item.cover,
                            R.drawable.cover_default);
                } else {
                    holder.setImageResource(R.id.ivRecommendCover, R.drawable.cover_default);
                }

                CheckBox ckBoxSelect = holder.getView(R.id.ckBoxSelect);
                ckBoxSelect.setChecked(item.isSeleted);
                ckBoxSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        item.isSeleted = isChecked;
                    }
                });
            }
        };
    }
}
