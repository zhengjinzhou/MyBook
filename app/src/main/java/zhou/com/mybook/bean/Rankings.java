package zhou.com.mybook.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou on 2018/3/22.
 */

public class Rankings implements Serializable {

    /**
     * _id : 54d42d92321052167dfb75e3
     * updated : 2016-08-14T21:20:21.090Z
     * title : 追书最热榜 Top100
     * tag : zhuishuLatelyFollowerMale
     * cover : /ranking-cover/142319144267827
     * __v : 509
     * monthRank : 564d820bc319238a644fb408
     * totalRank : 564d8494fe996c25652644d2
     * isSub : false
     * collapse : false
     * new : true
     * gender : male
     * priority : 250
     * books : [{"_id":"53855a750ac0b3a41e00c7e6","title":"择天记","author":"猫腻",
     * "shortIntro":"太始元年，有神石自太空飞来，分散落在人间，其中落在东土大陆的神石，上面镌刻着奇怪的图腾，人因观其图腾而悟道，后立国教。
     * 数千年后，十四岁的少年孤儿陈长生，为治病...","cover":"/agent/http://image.cmfu.com/books/3347595/3347595.jpg",
     * "site":"qidian","cat":"玄幻","banned":0,"latelyFollower":182257,"latelyFollowerBase":0,
     * "minRetentionRatio":0,"retentionRatio":"52.48"}]
     * created : 2015-02-06T02:57:22.000Z
     * id : 54d42d92321052167dfb75e3
     */

    public RankingBean ranking;

    public static class RankingBean {
        public String _id;
        public String updated;
        public String title;
        public String tag;
        public String cover;
        public int __v;
        public String monthRank;
        public String totalRank;
        public boolean isSub;
        public boolean collapse;
        @SerializedName("new")
        public boolean newX;
        public String gender;
        public int priority;
        public String created;
        public String id;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }

        public String getMonthRank() {
            return monthRank;
        }

        public void setMonthRank(String monthRank) {
            this.monthRank = monthRank;
        }

        public String getTotalRank() {
            return totalRank;
        }

        public void setTotalRank(String totalRank) {
            this.totalRank = totalRank;
        }

        public boolean isSub() {
            return isSub;
        }

        public void setSub(boolean sub) {
            isSub = sub;
        }

        public boolean isCollapse() {
            return collapse;
        }

        public void setCollapse(boolean collapse) {
            this.collapse = collapse;
        }

        public boolean isNewX() {
            return newX;
        }

        public void setNewX(boolean newX) {
            this.newX = newX;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<BooksBean> getBooks() {
            return books;
        }

        public void setBooks(List<BooksBean> books) {
            this.books = books;
        }

        @Override
        public String toString() {
            return "RankingBean{" +
                    "_id='" + _id + '\'' +
                    ", updated='" + updated + '\'' +
                    ", title='" + title + '\'' +
                    ", tag='" + tag + '\'' +
                    ", cover='" + cover + '\'' +
                    ", __v=" + __v +
                    ", monthRank='" + monthRank + '\'' +
                    ", totalRank='" + totalRank + '\'' +
                    ", isSub=" + isSub +
                    ", collapse=" + collapse +
                    ", newX=" + newX +
                    ", gender='" + gender + '\'' +
                    ", priority=" + priority +
                    ", created='" + created + '\'' +
                    ", id='" + id + '\'' +
                    ", books=" + books +
                    '}';
        }

        /**
         * _id : 53855a750ac0b3a41e00c7e6
         * title : 择天记
         * author : 猫腻
         * shortIntro : 太始元年，有神石自太空飞来，分散落在人间，其中落在东土大陆的神石，上面镌刻着奇怪的图腾，人因观其图腾而悟道，后立国教。 数千年后，十四岁的少年孤儿陈长生，为治病...
         * cover : /agent/http://image.cmfu.com/books/3347595/3347595.jpg
         * site : qidian
         * cat : 玄幻
         * banned : 0
         * latelyFollower : 182257
         * latelyFollowerBase : 0
         * minRetentionRatio : 0
         * retentionRatio : 52.48
         */


        public List<BooksBean> books;

        public static class BooksBean {
            public String _id;
            public String title;
            public String author;
            public String shortIntro;
            public String cover;
            public String site;
            public String cat;
            public int banned;
            public int latelyFollower;
            public int latelyFollowerBase;
            public String minRetentionRatio;
            public String retentionRatio;

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

            public int getBanned() {
                return banned;
            }

            public void setBanned(int banned) {
                this.banned = banned;
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

            @Override
            public String toString() {
                return "BooksBean{" +
                        "_id='" + _id + '\'' +
                        ", title='" + title + '\'' +
                        ", author='" + author + '\'' +
                        ", shortIntro='" + shortIntro + '\'' +
                        ", cover='" + cover + '\'' +
                        ", site='" + site + '\'' +
                        ", cat='" + cat + '\'' +
                        ", banned=" + banned +
                        ", latelyFollower=" + latelyFollower +
                        ", latelyFollowerBase=" + latelyFollowerBase +
                        ", minRetentionRatio='" + minRetentionRatio + '\'' +
                        ", retentionRatio='" + retentionRatio + '\'' +
                        '}';
            }
        }
    }
}
