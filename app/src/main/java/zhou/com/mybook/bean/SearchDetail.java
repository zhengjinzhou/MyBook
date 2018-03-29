package zhou.com.mybook.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou on 2018/3/22.
 */

public class SearchDetail implements Serializable {


    /**
     * _id : 55e2850dbda85d9f74e6f73b
     * hasCp : false
     * title : w
     * cat : 奇幻
     * author : w
     * site : faloo
     * cover : /agent/http://img.faloo.com/Novel/166x235/0/71/000071091.jpg
     * shortIntro : 最终之海的传说，可怕的烧烧能力，危险的黑暗能力，还有恐怖的冰冰能力。  看小Down怎样找到去另一个世界的大门。本书绝对会全本，更新时间固定每周六晚 绝对大更。...
     * lastChapter : 抢劫海贼
     * retentionRatio : null
     * latelyFollower : 4
     * wordCount : 5075
     */

    public List<SearchBooks> books;

    public static class SearchBooks {
        public String _id;
        public boolean hasCp;
        public String title;
        public String cat;
        public String author;
        public String site;
        public String cover;
        public String shortIntro;
        public String lastChapter;
        public String retentionRatio;
        public int latelyFollower;
        public int wordCount;

        public SearchBooks(String _id, String title, String author, String cover, String retentionRatio, int latelyFollower) {
            this._id = _id;
            this.title = title;
            this.author = author;
            this.cover = cover;
            this.retentionRatio = retentionRatio;
            this.latelyFollower = latelyFollower;
        }

        public SearchBooks() {
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public boolean isHasCp() {
            return hasCp;
        }

        public void setHasCp(boolean hasCp) {
            this.hasCp = hasCp;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCat() {
            return cat;
        }

        public void setCat(String cat) {
            this.cat = cat;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getShortIntro() {
            return shortIntro;
        }

        public void setShortIntro(String shortIntro) {
            this.shortIntro = shortIntro;
        }

        public String getLastChapter() {
            return lastChapter;
        }

        public void setLastChapter(String lastChapter) {
            this.lastChapter = lastChapter;
        }

        public String getRetentionRatio() {
            return retentionRatio;
        }

        public void setRetentionRatio(String retentionRatio) {
            this.retentionRatio = retentionRatio;
        }

        public int getLatelyFollower() {
            return latelyFollower;
        }

        public void setLatelyFollower(int latelyFollower) {
            this.latelyFollower = latelyFollower;
        }

        public int getWordCount() {
            return wordCount;
        }

        public void setWordCount(int wordCount) {
            this.wordCount = wordCount;
        }

        @Override
        public String toString() {
            return "SearchBooks{" +
                    "_id='" + _id + '\'' +
                    ", hasCp=" + hasCp +
                    ", title='" + title + '\'' +
                    ", cat='" + cat + '\'' +
                    ", author='" + author + '\'' +
                    ", site='" + site + '\'' +
                    ", cover='" + cover + '\'' +
                    ", shortIntro='" + shortIntro + '\'' +
                    ", lastChapter='" + lastChapter + '\'' +
                    ", retentionRatio='" + retentionRatio + '\'' +
                    ", latelyFollower=" + latelyFollower +
                    ", wordCount=" + wordCount +
                    '}';
        }
    }

}
