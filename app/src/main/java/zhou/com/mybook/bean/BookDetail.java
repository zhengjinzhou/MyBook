package zhou.com.mybook.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou on 2018/3/22.
 */

public class BookDetail implements Serializable {
    public String _id;
    public String author;
    public int banned;
    public String cover;
    public String creater;
    public Object dramaPoint;
    public int followerCount;
    public int gradeCount;
    public boolean isSerial;
    public String lastChapter;
    public int latelyFollower;
    public String longIntro;
    public int postCount; // 社区帖子数
    public int serializeWordCount;
    public String site;
    public String title;
    public Object totalPoint;
    public String type;
    public String updated;
    public Object writingPoint;
    public boolean hasNotice;
    public int tagStuck;
    public int chaptersCount;
    public int tocCount;
    public String tocUpdated;
    public String retentionRatio;
    public boolean hasCmread;
    public String thirdFlagsUpdated;
    public int wordCount;
    public String cat;
    public String majorCate;
    public String minorCate;
    public int reviewCount;
    public int totalFollower;
    public boolean cpOnly;
    public boolean hasCp;
    public boolean _le;
    public List<String> tags;
    public List<String> tocs;
    public List<String> categories;
    public Object gender; // MLGB, 偶尔是String，偶尔是Array

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBanned() {
        return banned;
    }

    public void setBanned(int banned) {
        this.banned = banned;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Object getDramaPoint() {
        return dramaPoint;
    }

    public void setDramaPoint(Object dramaPoint) {
        this.dramaPoint = dramaPoint;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }

    public int getGradeCount() {
        return gradeCount;
    }

    public void setGradeCount(int gradeCount) {
        this.gradeCount = gradeCount;
    }

    public boolean isSerial() {
        return isSerial;
    }

    public void setSerial(boolean serial) {
        isSerial = serial;
    }

    public String getLastChapter() {
        return lastChapter;
    }

    public void setLastChapter(String lastChapter) {
        this.lastChapter = lastChapter;
    }

    public int getLatelyFollower() {
        return latelyFollower;
    }

    public void setLatelyFollower(int latelyFollower) {
        this.latelyFollower = latelyFollower;
    }

    public String getLongIntro() {
        return longIntro;
    }

    public void setLongIntro(String longIntro) {
        this.longIntro = longIntro;
    }

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    public int getSerializeWordCount() {
        return serializeWordCount;
    }

    public void setSerializeWordCount(int serializeWordCount) {
        this.serializeWordCount = serializeWordCount;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(Object totalPoint) {
        this.totalPoint = totalPoint;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Object getWritingPoint() {
        return writingPoint;
    }

    public void setWritingPoint(Object writingPoint) {
        this.writingPoint = writingPoint;
    }

    public boolean isHasNotice() {
        return hasNotice;
    }

    public void setHasNotice(boolean hasNotice) {
        this.hasNotice = hasNotice;
    }

    public int getTagStuck() {
        return tagStuck;
    }

    public void setTagStuck(int tagStuck) {
        this.tagStuck = tagStuck;
    }

    public int getChaptersCount() {
        return chaptersCount;
    }

    public void setChaptersCount(int chaptersCount) {
        this.chaptersCount = chaptersCount;
    }

    public int getTocCount() {
        return tocCount;
    }

    public void setTocCount(int tocCount) {
        this.tocCount = tocCount;
    }

    public String getTocUpdated() {
        return tocUpdated;
    }

    public void setTocUpdated(String tocUpdated) {
        this.tocUpdated = tocUpdated;
    }

    public String getRetentionRatio() {
        return retentionRatio;
    }

    public void setRetentionRatio(String retentionRatio) {
        this.retentionRatio = retentionRatio;
    }

    public boolean isHasCmread() {
        return hasCmread;
    }

    public void setHasCmread(boolean hasCmread) {
        this.hasCmread = hasCmread;
    }

    public String getThirdFlagsUpdated() {
        return thirdFlagsUpdated;
    }

    public void setThirdFlagsUpdated(String thirdFlagsUpdated) {
        this.thirdFlagsUpdated = thirdFlagsUpdated;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
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

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public int getTotalFollower() {
        return totalFollower;
    }

    public void setTotalFollower(int totalFollower) {
        this.totalFollower = totalFollower;
    }

    public boolean isCpOnly() {
        return cpOnly;
    }

    public void setCpOnly(boolean cpOnly) {
        this.cpOnly = cpOnly;
    }

    public boolean isHasCp() {
        return hasCp;
    }

    public void setHasCp(boolean hasCp) {
        this.hasCp = hasCp;
    }

    public boolean is_le() {
        return _le;
    }

    public void set_le(boolean _le) {
        this._le = _le;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getTocs() {
        return tocs;
    }

    public void setTocs(List<String> tocs) {
        this.tocs = tocs;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "BookDetail{" +
                "_id='" + _id + '\'' +
                ", author='" + author + '\'' +
                ", banned=" + banned +
                ", cover='" + cover + '\'' +
                ", creater='" + creater + '\'' +
                ", dramaPoint=" + dramaPoint +
                ", followerCount=" + followerCount +
                ", gradeCount=" + gradeCount +
                ", isSerial=" + isSerial +
                ", lastChapter='" + lastChapter + '\'' +
                ", latelyFollower=" + latelyFollower +
                ", longIntro='" + longIntro + '\'' +
                ", postCount=" + postCount +
                ", serializeWordCount=" + serializeWordCount +
                ", site='" + site + '\'' +
                ", title='" + title + '\'' +
                ", totalPoint=" + totalPoint +
                ", type='" + type + '\'' +
                ", updated='" + updated + '\'' +
                ", writingPoint=" + writingPoint +
                ", hasNotice=" + hasNotice +
                ", tagStuck=" + tagStuck +
                ", chaptersCount=" + chaptersCount +
                ", tocCount=" + tocCount +
                ", tocUpdated='" + tocUpdated + '\'' +
                ", retentionRatio='" + retentionRatio + '\'' +
                ", hasCmread=" + hasCmread +
                ", thirdFlagsUpdated='" + thirdFlagsUpdated + '\'' +
                ", wordCount=" + wordCount +
                ", cat='" + cat + '\'' +
                ", majorCate='" + majorCate + '\'' +
                ", minorCate='" + minorCate + '\'' +
                ", reviewCount=" + reviewCount +
                ", totalFollower=" + totalFollower +
                ", cpOnly=" + cpOnly +
                ", hasCp=" + hasCp +
                ", _le=" + _le +
                ", tags=" + tags +
                ", tocs=" + tocs +
                ", categories=" + categories +
                ", gender=" + gender +
                '}';
    }
}
