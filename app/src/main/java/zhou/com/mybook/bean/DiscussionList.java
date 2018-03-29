package zhou.com.mybook.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou on 2018/3/22.
 * 综合讨论
 */

public class DiscussionList implements Serializable {


    /**
     * _id : 57c564e9818f568675624358
     * title : 【活动预告】9月2-4日三天两觉《惊悚乐园》签名书抢楼
     * author : {"_id":"52f840b982cfcc3a74031693",
     * "avatar":"/avatar/56/a9/56a96462a50ca99f9cf83440899e46f3","nickname":"追书首席打杂",
     * "type":"official","lv":9,"gender":"male"}
     * type : vote
     * likeCount : 651
     * block : ramble
     * state : hot
     * updated : 2016-09-01T12:30:52.286Z
     * created : 2016-08-30T10:50:17.927Z
     * commentCount : 5366
     * voteCount : 6337
     */

    public List<PostsBean> posts;

    public static class PostsBean {
        public String _id;
        public String title;
        /**
         * _id : 52f840b982cfcc3a74031693
         * avatar : /avatar/56/a9/56a96462a50ca99f9cf83440899e46f3
         * nickname : 追书首席打杂
         * type : official
         * lv : 9
         * gender : male
         */

        public AuthorBean author;
        public String type;
        public int likeCount;
        public String block;
        public String state;
        public String updated;
        public String created;
        public int commentCount;
        public int voteCount;

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

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public String getBlock() {
            return block;
        }

        public void setBlock(String block) {
            this.block = block;
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

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public int getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(int voteCount) {
            this.voteCount = voteCount;
        }

        @Override
        public String toString() {
            return "PostsBean{" +
                    "_id='" + _id + '\'' +
                    ", title='" + title + '\'' +
                    ", author=" + author +
                    ", type='" + type + '\'' +
                    ", likeCount=" + likeCount +
                    ", block='" + block + '\'' +
                    ", state='" + state + '\'' +
                    ", updated='" + updated + '\'' +
                    ", created='" + created + '\'' +
                    ", commentCount=" + commentCount +
                    ", voteCount=" + voteCount +
                    '}';
        }

        public static class AuthorBean {
            public String _id;
            public String avatar;
            public String nickname;
            public String type;
            public int lv;
            public String gender;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public int getLv() {
                return lv;
            }

            public void setLv(int lv) {
                this.lv = lv;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            @Override
            public String toString() {
                return "AuthorBean{" +
                        "_id='" + _id + '\'' +
                        ", avatar='" + avatar + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", type='" + type + '\'' +
                        ", lv=" + lv +
                        ", gender='" + gender + '\'' +
                        '}';
            }
        }
    }
}
