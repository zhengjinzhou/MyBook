package zhou.com.mybook.view.pdfview;

import android.graphics.Bitmap;

/**
 * Created by zhou on 2018/3/26.
 */

public interface BitmapContainer {
    Bitmap get(int position);

    void remove(int position);

    void clear();
}