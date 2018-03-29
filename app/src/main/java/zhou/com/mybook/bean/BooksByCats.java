package zhou.com.mybook.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou on 2018/3/22.
 */
public class BooksByCats implements Serializable {
    /**
     * _id : 555abb2d91d0eb814e5db04f
     * title : 全职法师
     * author : 乱
     * shortIntro : 一觉醒来，世界大变。 熟悉的高中传授的是魔法，告诉大家要成为一名出色的魔法师。 居住的都市之外游荡着袭击人类的魔物妖兽，虎视眈眈。
     * 崇尚科学的世界变成了崇尚魔法...
     * cover : /agent/http://image.cmfu.com/books/3489766/3489766.jpg
     * site : zhuishuvip
     * majorCate : 玄幻
     * latelyFollower : 109257
     * latelyFollowerBase : 0
     * minRetentionRatio : 0
     * retentionRatio : 72.88
     * lastChapter : 第1173章 文泰之死
     * tags : ["腹黑","玄幻","异界大陆"]
     */

    public List<BooksBean> books;

    public static class BooksBean {
        public String _id;
        public String title;
        public String author;
        public String shortIntro;
        public String cover;
        public String site;
        public String majorCate;
        public int latelyFollower;
        public int latelyFollowerBase;
        public String minRetentionRatio;
        public String retentionRatio;
        public String lastChapter;
        public List<String> tags;

        public BooksBean(String _id, String cover, String title, String author, String majorCate, String shortIntro, int latelyFollower, String retentionRatio) {
            this._id = _id;
            this.cover = cover;
            this.title = title;
            this.author = author;
            this.majorCate = majorCate;
            this.shortIntro = shortIntro;
            this.latelyFollower = latelyFollower;
            this.retentionRatio = retentionRatio;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getShortIntro() {
            return shortIntro;
        }

        public void setShortIntro(String shortIntro) {
            this.shortIntro = shortIntro;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public String getMajorCate() {
            return majorCate;
        }

        public void setMajorCate(String majorCate) {
            this.majorCate = majorCate;
        }

        public int getLatelyFollower() {
            return latelyFollower;
        }

        public void setLatelyFollower(int latelyFollower) {
            this.latelyFollower = latelyFollower;
        }

        public int getLatelyFollowerBase() {
            return latelyFollowerBase;
        }

        public void setLatelyFollowerBase(int latelyFollowerBase) {
            this.latelyFollowerBase = latelyFollowerBase;
        }

        public String getMinRetentionRatio() {
            return minRetentionRatio;
        }

        public void setMinRetentionRatio(String minRetentionRatio) {
            this.minRetentionRatio = minRetentionRatio;
        }

        public String getRetentionRatio() {
            return retentionRatio;
        }

        public void setRetentionRatio(String retentionRatio) {
            this.retentionRatio = retentionRatio;
        }

        public String getLastChapter() {
            return lastChapter;
        }

        public void setLastChapter(String lastChapter) {
            this.lastChapter = lastChapter;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        @Override
        public String toString() {
            return "BooksBean{" +
                    "_id='" + _id + '\'' +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", shortIntro='" + shortIntro + '\'' +
                    ", cover='" + cover + '\'' +
                    ", site='" + site + '\'' +
                    ", majorCate='" + majorCate + '\'' +
                    ", latelyFollower=" + latelyFollower +
                    ", latelyFollowerBase=" + latelyFollowerBase +
                    ", minRetentionRatio='" + minRetentionRatio + '\'' +
                    ", retentionRatio='" + retentionRatio + '\'' +
                    ", lastChapter='" + lastChapter + '\'' +
                    ", tags=" + tags +
                    '}';
        }
    }
}
