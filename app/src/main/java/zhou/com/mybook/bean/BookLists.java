package zhou.com.mybook.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou on 2018/3/22.
 */

public class BookLists implements Serializable{
    public List<BookListsBean> bookLists;

    public class BookListsBean implements Serializable {
        public String _id;
        public String title;
        public String author;
        public String desc;
        public String gender;
        public int collectorCount;
        public String cover;
        public int bookCount;

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

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getCollectorCount() {
            return collectorCount;
        }

        public void setCollectorCount(int collectorCount) {
            this.collectorCount = collectorCount;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getBookCount() {
            return bookCount;
        }

        public void setBookCount(int bookCount) {
            this.bookCount = bookCount;
        }

        @Override
        public String toString() {
            return "BookListsBean{" +
                    "_id='" + _id + '\'' +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", desc='" + desc + '\'' +
                    ", gender='" + gender + '\'' +
                    ", collectorCount=" + collectorCount +
                    ", cover='" + cover + '\'' +
                    ", bookCount=" + bookCount +
                    '}';
        }
    }

    public List<BookListsBean> getBookLists() {
        return bookLists;
    }

    public void setBookLists(List<BookListsBean> bookLists) {
        this.bookLists = bookLists;
    }

    @Override
    public String toString() {
        return "BookLists{" +
                "bookLists=" + bookLists +
                '}';
    }
}
