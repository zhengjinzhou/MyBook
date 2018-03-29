package zhou.com.mybook.bean;

import java.io.Serializable;

/**
 * Created by zhou on 2018/3/23.
 */

public class BookSource implements Serializable {

    /**
     * _id : 55219c4ea9240fb868282e65
     * lastChapter : 学神被封了，书也应该不可能放出来了。
     * link : http://leduwo.com/book/56/56121/index.html
     * source : tianyibook
     * name : 乐读窝
     * isCharge : false
     * chaptersCount : 515
     * updated : 2016-08-09T18:42:34.880Z
     * starting : false
     * host : leduwo.com
     */

    public String _id;
    public String lastChapter;
    public String link;
    public String source;
    public String name;
    public boolean isCharge;
    public int chaptersCount;
    public String updated;
    public boolean starting;
    public String host;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getLastChapter() {
        return lastChapter;
    }

    public void setLastChapter(String lastChapter) {
        this.lastChapter = lastChapter;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCharge() {
        return isCharge;
    }

    public void setCharge(boolean charge) {
        isCharge = charge;
    }

    public int getChaptersCount() {
        return chaptersCount;
    }

    public void setChaptersCount(int chaptersCount) {
        this.chaptersCount = chaptersCount;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public boolean isStarting() {
        return starting;
    }

    public void setStarting(boolean starting) {
        this.starting = starting;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String toString() {
        return "BookSource{" +
                "_id='" + _id + '\'' +
                ", lastChapter='" + lastChapter + '\'' +
                ", link='" + link + '\'' +
                ", source='" + source + '\'' +
                ", name='" + name + '\'' +
                ", isCharge=" + isCharge +
                ", chaptersCount=" + chaptersCount +
                ", updated='" + updated + '\'' +
                ", starting=" + starting +
                ", host='" + host + '\'' +
                '}';
    }
}
