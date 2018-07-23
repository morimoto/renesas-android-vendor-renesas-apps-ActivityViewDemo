package com.renesas.activityviewdemo;

import android.os.Bundle;
import android.util.Log;

public class UpDownActivity extends BaseActivity {



    @Override
    public String getTag() {
        return "UpDownActivity";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_down);
        setTitle(getTag());
        Log.w(getTag(), "onCreate");
        setActivityViewAction(R.id.activityViewFirst, FIRST_PACKAGE_NAME,FIRST_COMPONENT_NAME);
        setActivityViewAction(R.id.activityViewSecond, SECOND_PACKAGE_NAME,SECOND_COMPONENT_NAME);
    }
}
