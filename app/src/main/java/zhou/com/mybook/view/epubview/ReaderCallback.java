package zhou.com.mybook.view.epubview;

/**
 * Created by zhou on 2018/3/26.
 */

public interface ReaderCallback {

    String getPageHref(int position);

    void toggleToolBarVisible();

    void hideToolBarIfVisible();


}
