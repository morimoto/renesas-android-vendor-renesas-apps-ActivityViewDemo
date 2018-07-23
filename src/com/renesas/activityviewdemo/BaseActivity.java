package com.renesas.activityviewdemo;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityView;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public abstract class BaseActivity extends Activity {
        //Works:
    /*public static final String FIRST_PACKAGE_NAME = "com.android.documentsui";
    public static final String FIRST_COMPONENT_NAME = FIRST_PACKAGE_NAME+".files.FilesActivity";

    public static final String SECOND_PACKAGE_NAME = "com.android.settings";
    public static final String SECOND_COMPONENT_NAME = SECOND_PACKAGE_NAME+".Settings";*/

        //End Works
    //com.android.car.dialer/.TelecomActivity
    //com.android.car.media/.MediaActivity
        public static final String FIRST_PACKAGE_NAME = "com.android.documentsui";
    public static final String FIRST_COMPONENT_NAME = FIRST_PACKAGE_NAME+".files.FilesActivity";

    public static final String SECOND_PACKAGE_NAME  = "com.android.car.dialer";
    public static final String SECOND_COMPONENT_NAME = SECOND_PACKAGE_NAME+".TelecomActivity";

    public abstract String getTag();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }


    public void setActivityViewAction(int avResId, final String packageName, final String componentName) {
        ((ActivityView) findViewById(avResId)).setCallback(new ActivityView.StateCallback() {

            @Override
            public void onActivityViewReady(ActivityView v) {
                Log.w(getTag(), "onActivityViewReady: " + packageName);
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(packageName, componentName));
                v.startActivity(intent);
            }

            @Override
            public void onActivityViewDestroyed(ActivityView v) {
                Log.w(getTag(), "onActivityViewDestroyed: " + packageName);
            }

            @Override
            public void onTaskMovedToFront(ActivityManager.StackInfo stackInfo) {
                Log.w(getTag(), "onTaskMovedToFront: stackInfo = " + stackInfo);
                ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                am.moveTaskToFront(
                        BaseActivity.this.getTaskId(), 0 /* Flags */, null /* Bundle */);
            }
        });
    }

}
