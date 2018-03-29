package zhou.com.mybook.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou on 2018/3/22.
 */

public class BookListTags implements Serializable {
    public List<DataBean> data;

    public static class DataBean {
        public String name;
        public List<String> tags;
    }
}
