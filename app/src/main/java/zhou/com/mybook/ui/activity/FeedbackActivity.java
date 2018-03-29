package zhou.com.mybook.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import zhou.com.mybook.R;
import zhou.com.mybook.base.BaseActivity;

public class FeedbackActivity extends BaseActivity {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, FeedbackActivity.class));
    }


    @Override
    public int getLayout() {
        return R.layout.activity_feedback;
    }

    @Override
    public void initToolBar() {
        common_toolbar.setTitle("反馈建议");
        common_toolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initData() {

    }

    @Override
    public void configView() {

    }
}
