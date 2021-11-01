package indi.mat.work.android.ui.launchmode.singletask;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import indi.mat.work.android.R;
import indi.mat.work.android.ui.launchmode.MainLaunchModeActivity;
import indi.mat.work.android.ui.launchmode.singletask.other.SingleTaskOtherActivity;

public class SingleTaskSecondActivity extends AppCompatActivity {

    private static final String TAG = "SingleTaskSecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task_second);

        if(getIntent().getStringExtra("value1").length() != 0){
            SingleTaskOtherActivity.actionStart(this, "", "");
        }


        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Log.d(TAG, "创建 第二页");
        int taskId = getTaskId();
        Log.i(TAG, TAG +"所在的任务的id为: =======================" +  taskId);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    public void next(View view){
        SingleTaskThirdActivity.actionStart(this, "", "");
        Log.d(TAG, "next: Jumped to! 第三页");
    }

    public static void actionStart(Context context, String value1, String value2) {
        Intent intent = new Intent(context, SingleTaskSecondActivity.class);
        intent.putExtra("value1", value1);
        intent.putExtra("value2", value2);
        context.startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: =======================" + getTaskId());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy:  SingleTask 第二页");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
}