package zhou.com.mybook.bean.support;

import java.io.Serializable;

/**
 * Created by zhou on 2018/3/22.
 */

public class BookMark implements Serializable {

    public int chapter;

    public String title;

    public int startPos;

    public int endPos;

    public String desc = "";
}
