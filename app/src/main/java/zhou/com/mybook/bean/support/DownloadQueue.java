package zhou.com.mybook.bean.support;

import java.io.Serializable;
import java.util.List;

import zhou.com.mybook.bean.BookMixAToc;

/**
 * Created by zhou on 2018/3/26.
 */

public class DownloadQueue implements Serializable {

    public String bookId;

    public List<BookMixAToc.mixToc.Chapters> list;

    public int start;

    public int end;

    /**
     * 是否已经开始下载
     */
    public boolean isStartDownload = false;

    /**
     * 是否中断下载
     */
    public boolean isCancel = false;

    /**
     * 是否下载完成
     */
    public boolean isFinish = false;

    public DownloadQueue(String bookId, List<BookMixAToc.mixToc.Chapters> list, int start, int end) {
        this.bookId = bookId;
        this.list = list;
        this.start = start;
        this.end = end;
    }

    /**
     * 空事件。表示通知继续执行下一条任务
     */
    public DownloadQueue() {
    }
}
