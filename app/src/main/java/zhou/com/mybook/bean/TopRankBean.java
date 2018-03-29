package zhou.com.mybook.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou on 2018/3/21.
 * http://api.zhuishushenqi.com/ranking/gender
 */

public class TopRankBean implements Serializable{

    /**
     * female : [{"_id":"54d43437d47d13ff21cad58b","title":"追书最热榜 Top100","cover":"/ranking-cover/142319314350435","collapse":false,"monthRank":"564d853484665f97662d0810","totalRank":"564d85b6dd2bd1ec660ea8e2","shortTitle":"最热榜"},{"_id":"5a684551fc84c2b8efaab179","title":"好评榜","cover":"/ranking-cover/142319144267827","collapse":false,"shortTitle":"好评榜"},{"_id":"5a684515fc84c2b8efaa9875","title":"热搜榜","cover":"/ranking-cover/142319144267827","collapse":false,"shortTitle":"热搜榜"},{"_id":"57eb959df60eb7e21fb3a8b7","title":"VIP排行榜","cover":"/ranking-cover/147505705336267","collapse":false,"monthRank":"57eb98afcf7ddb81588947b4","totalRank":"57eb98fe1ae40b985292051e","shortTitle":"VIP榜"},{"_id":"54d43709fd6ec9ae04184aa5","title":"本周潜力榜","cover":"/ranking-cover/142319383473238","collapse":false,"monthRank":"564eee77e3a44c9f0e5fd7ae","totalRank":"564eeeca5e6ba6ae074f10ec","shortTitle":"潜力榜"},{"_id":"5645482405b052fe70aeb1b5","title":"读者留存率 Top100","cover":"/ranking-cover/144738102858782","collapse":false,"monthRank":"564d8b6b36d10ccd6951195d","totalRank":"564d8c37752bcca16a976168","shortTitle":"留存榜"},{"_id":"564eb8a9cf77e9b25056162d","title":"追书完结榜 Top100","cover":"/ranking-cover/144799965747841","collapse":false,"monthRank":"564ee8ec146f8f1739777740","totalRank":"564eeae6c3345baa6bf06e38","shortTitle":"完结榜"},{"_id":"582fb5c412a401a20ea50275","title":"圣诞热搜榜","cover":"/ranking-cover/14795217326220","collapse":true,"shortTitle":"圣诞榜"},{"_id":"564d80d0e8c613016446c5aa","title":"掌阅热销榜","cover":"/ranking-cover/142319217152210","collapse":true,"shortTitle":"掌阅榜"},{"_id":"564d81151109835664770ad7","title":"书旗热搜榜","shortTitle":"书旗榜","cover":"/ranking-cover/142319217152210","collapse":true},{"_id":"550b841715db45cd4b022107","title":"17K订阅榜","shortTitle":"17K榜","cover":"/ranking-cover/142319217152210","collapse":true},{"_id":"550b836229cd462830ff4d1d","title":"起点粉红票榜","cover":"/ranking-cover/142319217152210","collapse":true,"shortTitle":"起点榜"},{"_id":"550b8397de12381038ad8c0b","title":"潇湘月票榜","cover":"/ranking-cover/142319217152210","collapse":true,"shortTitle":"潇湘榜"}]
     * picture : [{"_id":"5a322ef4fc84c2b8efaa8335","title":"人气榜","cover":"/ranking-cover/142319144267827","collapse":false,"shortTitle":"人气榜"},{"_id":"5a68296bfc84c2b8ef9efdb0","title":"热销榜","cover":"/ranking-cover/142319144267827","collapse":false,"shortTitle":"热搜榜"},{"_id":"5a39ca20fc84c2b8ef82c9ed","title":"畅销榜","cover":"/ranking-cover/142319144267827","collapse":false,"shortTitle":"畅销榜"},{"_id":"5a39ca3ffc84c2b8ef82da82","title":"新书榜","cover":"/ranking-cover/142319144267827","collapse":false,"shortTitle":"新书榜"},{"_id":"5a39ca59fc84c2b8ef82e96c","title":"完结榜","cover":"/ranking-cover/142319144267827","collapse":false,"shortTitle":"完结榜"},{"_id":"5a39ca7dfc84c2b8ef82ff4f","title":"免费榜","cover":"/ranking-cover/142319144267827","collapse":false,"shortTitle":"免费榜"}]
     * epub : [{"_id":"5a323096fc84c2b8efab2482","title":"热搜榜","cover":"/ranking-cover/142319144267827","collapse":false,"shortTitle":"热搜榜"},{"_id":"5a39d435fc84c2b8ef884798","title":"畅销榜","cover":"/ranking-cover/142319144267827","collapse":false,"shortTitle":"畅销榜"},{"_id":"5a683b68fc84c2b8efa68fc2","title":"VIP榜","cover":"/ranking-cover/142319144267827","collapse":false,"shortTitle":"VIP榜"},{"_id":"5a39d453fc84c2b8ef885812","title":"新书榜","cover":"/ranking-cover/142319144267827","collapse":false,"shortTitle":"新书榜"},{"_id":"5a683b8ffc84c2b8efa69fe6","title":"收藏榜","cover":"/ranking-cover/142319144267827","collapse":false,"shortTitle":"收藏榜"}]
     * male : [{"_id":"54d42d92321052167dfb75e3","title":"追书最热榜 Top100","cover":"/ranking-cover/142319144267827","collapse":false,"monthRank":"564d820bc319238a644fb408","totalRank":"564d8494fe996c25652644d2","shortTitle":"最热榜"},{"_id":"5a6844aafc84c2b8efaa6b6e","title":"好评榜","cover":"/ranking-cover/142319144267827","collapse":false,"shortTitle":"好评榜"},{"_id":"5a6844f8fc84c2b8efaa8bc5","title":"热搜榜","cover":"/ranking-cover/142319144267827","collapse":false,"shortTitle":"热搜榜"},{"_id":"54d42e72d9de23382e6877fb","title":"本周潜力榜","cover":"/ranking-cover/142319166399949","collapse":false,"monthRank":"564eee3ea82e3ada6f14b195","totalRank":"564eeeabed24953671f2a577","shortTitle":"潜力榜"},{"_id":"564547c694f1c6a144ec979b","title":"读者留存率 Top100","cover":"/ranking-cover/144738093413066","collapse":false,"monthRank":"564d898f59fd983667a5e3fa","totalRank":"564d8a004a15bb8369d9e28d","shortTitle":"留存榜"},{"_id":"564eb878efe5b8e745508fde","title":"追书完结榜 Top100","cover":"/ranking-cover/144799960841612","collapse":false,"monthRank":"564eb12c3edb8b45511139ff","totalRank":"564eea0b731ade4d6c509493","shortTitle":"完结榜"},{"_id":"57eb86f0ef9e5a8f20543d7d","title":"VIP排行榜","cover":"/ranking-cover/14750532964058","collapse":false,"totalRank":"5848d4a4602c289505581f6f","monthRank":"57eb9283f031bfcc219389af","shortTitle":"VIP榜"},{"_id":"582ed5fc93b7e855163e707d","title":"圣诞热搜榜","cover":"/ranking-cover/147946444450686","collapse":true,"shortTitle":"圣诞榜"},{"_id":"564ef4f985ed965d0280c9c2","title":"百度热搜榜","cover":"/ranking-cover/142319217152210","collapse":true,"shortTitle":"百度榜"},{"_id":"564d8003aca44f4f61850fcd","title":"掌阅热销榜","cover":"/ranking-cover/142319217152210","collapse":true,"shortTitle":"掌阅榜"},{"_id":"564d80457408cfcd63ae2dd0","title":"书旗热搜榜","shortTitle":"书旗榜","cover":"/ranking-cover/142319217152210","collapse":true},{"_id":"54d430e9a8cb149d07282496","title":"17K 鲜花榜","shortTitle":"17K榜","cover":"/ranking-cover/142319217152210","collapse":true},{"_id":"54d4306c321052167dfb75e4","title":"起点月票榜","cover":"/ranking-cover/142319217152210","collapse":true,"shortTitle":"起点榜"},{"_id":"54d430962c12d3740e4a3ed2","title":"纵横月票榜","cover":"/ranking-cover/142319217152210","collapse":true,"shortTitle":"纵横榜"},{"_id":"54d4312d5f3c22ae137255a1","title":"和阅读原创榜","cover":"/ranking-cover/142319217152210","collapse":true,"shortTitle":"和阅读榜"},{"_id":"5732aac02dbb268b5f037fc4","title":"逐浪点击榜","cover":"/ranking-cover/146293830220772","collapse":true,"shortTitle":"逐浪榜"}]
     * ok : true
     */

    private boolean ok;
    private List<FemaleBean> female;
    private List<PictureBean> picture;
    private List<EpubBean> epub;
    private List<MaleBean> male;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<FemaleBean> getFemale() {
        return female;
    }

    public void setFemale(List<FemaleBean> female) {
        this.female = female;
    }

    public List<PictureBean> getPicture() {
        return picture;
    }

    public void setPicture(List<PictureBean> picture) {
        this.picture = picture;
    }

    public List<EpubBean> getEpub() {
        return epub;
    }

    public void setEpub(List<EpubBean> epub) {
        this.epub = epub;
    }

    public List<MaleBean> getMale() {
        return male;
    }

    public void setMale(List<MaleBean> male) {
        this.male = male;
    }

    public static class FemaleBean {
        /**
         * _id : 54d43437d47d13ff21cad58b
         * title : 追书最热榜 Top100
         * cover : /ranking-cover/142319314350435
         * collapse : false
         * monthRank : 564d853484665f97662d0810
         * totalRank : 564d85b6dd2bd1ec660ea8e2
         * shortTitle : 最热榜
         */

        private String _id;
        private String title;
        private String cover;
        private boolean collapse;
        private String monthRank;
        private String totalRank;
        private String shortTitle;

        public FemaleBean(String title) {
            this.title = title;
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

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public boolean isCollapse() {
            return collapse;
        }

        public void setCollapse(boolean collapse) {
            this.collapse = collapse;
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

        public String getShortTitle() {
            return shortTitle;
        }

        public void setShortTitle(String shortTitle) {
            this.shortTitle = shortTitle;
        }

        @Override
        public String toString() {
            return "FemaleBean{" +
                    "_id='" + _id + '\'' +
                    ", title='" + title + '\'' +
                    ", cover='" + cover + '\'' +
                    ", collapse=" + collapse +
                    ", monthRank='" + monthRank + '\'' +
                    ", totalRank='" + totalRank + '\'' +
                    ", shortTitle='" + shortTitle + '\'' +
                    '}';
        }
    }

    public static class PictureBean {
        /**
         * _id : 5a322ef4fc84c2b8efaa8335
         * title : 人气榜
         * cover : /ranking-cover/142319144267827
         * collapse : false
         * shortTitle : 人气榜
         */

        private String _id;
        private String title;
        private String cover;
        private boolean collapse;
        private String shortTitle;

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

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public boolean isCollapse() {
            return collapse;
        }

        public void setCollapse(boolean collapse) {
            this.collapse = collapse;
        }

        public String getShortTitle() {
            return shortTitle;
        }

        public void setShortTitle(String shortTitle) {
            this.shortTitle = shortTitle;
        }

        @Override
        public String toString() {
            return "PictureBean{" +
                    "_id='" + _id + '\'' +
                    ", title='" + title + '\'' +
                    ", cover='" + cover + '\'' +
                    ", collapse=" + collapse +
                    ", shortTitle='" + shortTitle + '\'' +
                    '}';
        }
    }

    public static class EpubBean {
        /**
         * _id : 5a323096fc84c2b8efab2482
         * title : 热搜榜
         * cover : /ranking-cover/142319144267827
         * collapse : false
         * shortTitle : 热搜榜
         */

        private String _id;
        private String title;
        private String cover;
        private boolean collapse;
        private String shortTitle;

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

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public boolean isCollapse() {
            return collapse;
        }

        public void setCollapse(boolean collapse) {
            this.collapse = collapse;
        }

        public String getShortTitle() {
            return shortTitle;
        }

        public void setShortTitle(String shortTitle) {
            this.shortTitle = shortTitle;
        }

        @Override
        public String toString() {
            return "EpubBean{" +
                    "_id='" + _id + '\'' +
                    ", title='" + title + '\'' +
                    ", cover='" + cover + '\'' +
                    ", collapse=" + collapse +
                    ", shortTitle='" + shortTitle + '\'' +
                    '}';
        }
    }

    public static class MaleBean {
        /**
         * _id : 54d42d92321052167dfb75e3
         * title : 追书最热榜 Top100
         * cover : /ranking-cover/142319144267827
         * collapse : false
         * monthRank : 564d820bc319238a644fb408
         * totalRank : 564d8494fe996c25652644d2
         * shortTitle : 最热榜
         */

        private String _id;
        private String title;
        private String cover;
        private boolean collapse;
        private String monthRank;
        private String totalRank;
        private String shortTitle;

        public MaleBean(String title) {
            this.title = title;
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

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public boolean isCollapse() {
            return collapse;
        }

        public void setCollapse(boolean collapse) {
            this.collapse = collapse;
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

        public String getShortTitle() {
            return shortTitle;
        }

        public void setShortTitle(String shortTitle) {
            this.shortTitle = shortTitle;
        }

        @Override
        public String toString() {
            return "MaleBean{" +
                    "_id='" + _id + '\'' +
                    ", title='" + title + '\'' +
                    ", cover='" + cover + '\'' +
                    ", collapse=" + collapse +
                    ", monthRank='" + monthRank + '\'' +
                    ", totalRank='" + totalRank + '\'' +
                    ", shortTitle='" + shortTitle + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TopRankBean{" +
                "ok=" + ok +
                ", female=" + female +
                ", picture=" + picture +
                ", epub=" + epub +
                ", male=" + male +
                '}';
    }
}
