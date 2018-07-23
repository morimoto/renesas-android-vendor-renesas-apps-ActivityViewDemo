package com.renesas.activityviewdemo;

import android.os.Bundle;
import android.util.Log;

public class LeftRightActivity extends BaseActivity {

    @Override
    public String getTag() {
        return "LeftRightActivity";
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_right);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(getTag());
        Log.w(getTag(), "onCreate");
        setActivityViewAction(R.id.activityViewFirst, FIRST_PACKAGE_NAME,FIRST_COMPONENT_NAME);
        setActivityViewAction(R.id.activityViewSecond, SECOND_PACKAGE_NAME,SECOND_COMPONENT_NAME);
    }
}
