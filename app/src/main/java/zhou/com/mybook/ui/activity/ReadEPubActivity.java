package zhou.com.mybook.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListPopupWindow;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.SpineReference;
import nl.siegmann.epublib.domain.TOCReference;
import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseActivity;
import zhou.com.mybook.bean.BookMixAToc;
import zhou.com.mybook.ui.adapter.EPubReaderAdapter;
import zhou.com.mybook.ui.adapter.TocListAdapter;
import zhou.com.mybook.view.epubview.DirectionalViewpager;
import zhou.com.mybook.view.epubview.ReaderCallback;

public class ReadEPubActivity extends BaseActivity implements ReaderCallback {

    @BindView(R.id.epubViewPager)
    DirectionalViewpager viewpager;

    @BindView(R.id.toolbar_menu)
    View ivMenu;
    @BindView(R.id.toolbar_title)
    TextView tvTitle;

    private EPubReaderAdapter mAdapter;

    private String mFileName;
    private String mFilePath;

    private Book mBook;
    private ArrayList<TOCReference> mTocReferences;
    private List<SpineReference> mSpineReferences;
    public boolean mIsSmilParsed = false;

    private List<BookMixAToc.mixToc.Chapters> mChapterList = new ArrayList<>();
    private ListPopupWindow mTocListPopupWindow;
    private TocListAdapter mTocListAdapter;

    private boolean mIsActionBarVisible = true;
    private int currentChapter;

    public static void start(Context context, String filePath) {
        Intent intent = new Intent(context, ReadEPubActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.fromFile(new File(filePath)));
        context.startActivity(intent);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_read_epub;
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {

    }

    @Override
    public String getPageHref(int position) {
        return null;
    }

    @Override
    public void toggleToolBarVisible() {

    }

    @Override
    public void hideToolBarIfVisible() {

    }
}
