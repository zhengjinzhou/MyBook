package zhou.com.mybook.manager;

import org.greenrobot.eventbus.EventBus;

import zhou.com.mybook.bean.support.RefreshCollectionIconEvent;
import zhou.com.mybook.bean.support.RefreshCollectionListEvent;
import zhou.com.mybook.bean.support.SubEvent;

/**
 * Created by zhou on 2018/3/22.
 */

public class EventManager {

    public static void refreshCollectionList() {
        EventBus.getDefault().post(new RefreshCollectionListEvent());
    }

    public static void refreshCollectionIcon() {
        EventBus.getDefault().post(new RefreshCollectionIconEvent());
    }

    public static void refreshSubCategory(String minor, String type) {
        EventBus.getDefault().post(new SubEvent(minor, type));
    }

}