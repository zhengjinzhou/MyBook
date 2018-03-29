package zhou.com.mybook.bean;

/**
 * Created by zhou on 2018/3/20.
 */

public class FindBean {
    private String title;
    private int icon;

    public FindBean(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "FindBean{" +
                "title='" + title + '\'' +
                ", icon=" + icon +
                '}';
    }
}
