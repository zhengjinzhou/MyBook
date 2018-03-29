package zhou.com.mybook.bean.support;

/**
 * Created by zhou on 2018/3/23.
 */

public class DownloadProgress {

    public String bookId;

    public String message;

    public boolean isAlreadyDownload = false;

    public DownloadProgress(String bookId, String message, boolean isAlreadyDownload) {
        this.bookId = bookId;
        this.message = message;
        this.isAlreadyDownload = isAlreadyDownload;
    }
}
