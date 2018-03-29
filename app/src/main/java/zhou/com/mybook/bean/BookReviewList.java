package zhou.com.mybook.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou on 2018/3/22.
 */

public class BookReviewList implements Serializable {


    /**
     * _id : 57c78c949869613834c1c519
     * title : 【书评两星，主要是不爱看这类的书，没有贬低此书的意思，见谅】
     * book : {"_id":"5086510f9dacd30e3a000026","cover":"/agent/http://image.cmfu
     * .com/books/109222/109222.jpg","title":"无限恐怖","site":"zhuishuvip","type":"khly"}
     * helpful : {"total":-38,"no":45,"yes":7}
     * likeCount : 1
     * state : normal
     * updated : 2016-09-01T13:07:57.530Z
     * created : 2016-09-01T02:04:04.487Z
     */

    public List<ReviewsBean> reviews;

    public static class ReviewsBean {
        public String _id;
        public String title;
        /**
         * _id : 5086510f9dacd30e3a000026
         * cover : /agent/http://image.cmfu.com/books/109222/109222.jpg
         * title : 无限恐怖
         * site : zhuishuvip
         * type : khly
         */

        public BookBean book;
        /**
         * total : -38
         * no : 45
         * yes : 7
         */

        public HelpfulBean helpful;
        public int likeCount;
        public String state;
        public String updated;
        public String created;

        public static class BookBean {
            public String _id;
            public String cover;
            public String title;
            public String site;
            public String type;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSite() {
                return site;
            }

            public void setSite(String site) {
                this.site = site;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            @Override
            public String toString() {
                return "BookBean{" +
                        "_id='" + _id + '\'' +
                        ", cover='" + cover + '\'' +
                        ", title='" + title + '\'' +
                        ", site='" + site + '\'' +
                        ", type='" + type + '\'' +
                        '}';
            }
        }

        public static class HelpfulBean {
            public int total;
            public int no;
            public int yes;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getNo() {
                return no;
            }

            public void setNo(int no) {
                this.no = no;
            }

            public int getYes() {
                return yes;
            }

            public void setYes(int yes) {
                this.yes = yes;
            }

            @Override
            public String toString() {
                return "HelpfulBean{" +
                        "total=" + total +
                        ", no=" + no +
                        ", yes=" + yes +
                        '}';
            }
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

        public BookBean getBook() {
            return book;
        }

        public void setBook(BookBean book) {
            this.book = book;
        }

        public HelpfulBean getHelpful() {
            return helpful;
        }

        public void setHelpful(HelpfulBean helpful) {
            this.helpful = helpful;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        @Override
        public String toString() {
            return "ReviewsBean{" +
                    "_id='" + _id + '\'' +
                    ", title='" + title + '\'' +
                    ", book=" + book +
                    ", helpful=" + helpful +
                    ", likeCount=" + likeCount +
                    ", state='" + state + '\'' +
                    ", updated='" + updated + '\'' +
                    ", created='" + created + '\'' +
                    '}';
        }
    }
}
