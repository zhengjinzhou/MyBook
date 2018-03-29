package zhou.com.mybook.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou on 2018/3/26.
 */
public class BooksByTag implements Serializable {


    /**
     * _id : 559b29837a0f8b65521464a7
     * title : 申公豹传承
     * author : 第九天命
     * shortIntro : 本书主角玉独秀获得应灾劫大道而生的申公豹传承，然后又在无意间融合了一丝诸天劫难本源，有了执掌、引动大劫之力量，为众生带来劫难，可以借助大劫，来加快自己的修炼速，...
     * cover : /agent/http://image.cmfu.com/books/3533952/3533952.jpg
     * cat : 仙侠
     * majorCate : 仙侠
     * minorCate : 洪荒封神
     * latelyFollower : 776
     * retentionRatio : 69.68
     * lastChapter : 第1337章 狐媚子
     * tags : ["洪荒封神","仙侠"]
     */

    public List<TagBook> books;

    public static class TagBook {
        public String _id;
        public String title;
        public String author;
        public String shortIntro;
        public String cover;
        public String site;
        public String cat;
        public String majorCate;
        public String minorCate;
        public int latelyFollower;
        public String retentionRatio;
        public String lastChapter;
        public List<String> tags;

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

        public String getCat() {
            return cat;
        }

        public void setCat(String cat) {
            this.cat = cat;
        }

        public String getMajorCate() {
            return majorCate;
        }

        public void setMajorCate(String majorCate) {
            this.majorCate = majorCate;
        }

        public String getMinorCate() {
            return minorCate;
        }

        public void setMinorCate(String minorCate) {
            this.minorCate = minorCate;
        }

        public int getLatelyFollower() {
            return latelyFollower;
        }

        public void setLatelyFollower(int latelyFollower) {
            this.latelyFollower = latelyFollower;
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
            return "TagBook{" +
                    "_id='" + _id + '\'' +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", shortIntro='" + shortIntro + '\'' +
                    ", cover='" + cover + '\'' +
                    ", site='" + site + '\'' +
                    ", cat='" + cat + '\'' +
                    ", majorCate='" + majorCate + '\'' +
                    ", minorCate='" + minorCate + '\'' +
                    ", latelyFollower=" + latelyFollower +
                    ", retentionRatio='" + retentionRatio + '\'' +
                    ", lastChapter='" + lastChapter + '\'' +
                    ", tags=" + tags +
                    '}';
        }
    }
}
