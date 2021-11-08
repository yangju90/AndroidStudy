package indi.mat.work.android.ui.launchmode.singletask;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import indi.mat.work.android.R;
import indi.mat.work.android.ui.launchmode.singletask.other.SingleTaskOtherActivity;

public class SingleTaskSecondActivity extends AppCompatActivity {

    private static final String TAG = "SingleTaskSecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task_second);

        if("true".equals(getIntent().getStringExtra("value1"))){
//            SingleTaskOtherActivity.actionStart(this, "", "");
            Intent intent = new Intent();
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == -100) finish();
                }
            }).launch(new Intent(this, SingleTaskOtherActivity.class));
        }


        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Log.d(TAG, "创建 第二页");
        int taskId = getTaskId();
        Log.d(TAG, TAG +"所在的任务的id为: =======================" +  taskId);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
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
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        System.out.println("value1:" + intent.getStringExtra("value1"));
        System.out.println("value2:" + intent.getStringExtra("value2"));
        setIntent(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView editText = findViewById(R.id.intentValue);
        if("true".equals(getIntent().getStringExtra("value1"))) {

        }else{
            if (getIntent().getStringExtra("value2") == null || getIntent().getStringExtra("value2").length() == 0) {
                finish();
            }
            editText.setText("content: " + getIntent().getStringExtra("value2"));
        }

        Log.d(TAG, "onResume: =======================");
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