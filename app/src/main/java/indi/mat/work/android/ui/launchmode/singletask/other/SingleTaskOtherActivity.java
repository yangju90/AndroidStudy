package indi.mat.work.android.ui.launchmode.singletask.other;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import indi.mat.work.android.R;
import indi.mat.work.android.ui.launchmode.singletask.SingleTaskFirstActivity;
import indi.mat.work.android.ui.launchmode.singletask.SingleTaskSecondActivity;


public class SingleTaskOtherActivity extends AppCompatActivity {

    private static final String TAG = "SingleTaskOtherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task_other);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Log.d(TAG, "创建 SingleTask 和Main 相同Task id 页");
        int taskId = getTaskId();
        Log.i(TAG, TAG +"所在的任务的id为: =======================" +  taskId);
    }
    @Override
    public boolean onSupportNavigateUp() {
        setResult(-100);
        finish();
        return super.onSupportNavigateUp();
    }

    public void next(View view){
        SingleTaskSecondActivity.actionStart(this, "", "PLC_OTHER");
        Log.d(TAG, "next: Jumped to! 第二页");
    }

    public static void actionStart(Context context, String value1, String value2) {
        Intent intent = new Intent(context, SingleTaskOtherActivity.class);
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
        Log.d(TAG, "onDestroy:  SingleTask 和Main 相同Task id 页");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
}