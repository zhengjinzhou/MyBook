package zhou.com.mybook.view.readview;

/**
 * Created by zhou on 2018/3/23.
 */

public interface OnReadStateChangeListener {

    void onChapterChanged(int chapter);

    void onPageChanged(int chapter, int page);

    void onLoadChapterFailure(int chapter);

    void onCenterClick();

    void onFlip();
}
