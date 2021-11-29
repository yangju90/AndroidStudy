package indi.mat.work.android.ui.lifecycles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Chronometer;

import indi.mat.work.android.BaseActivity;
import indi.mat.work.android.R;
import indi.mat.work.android.ui.toolbar.ToolBarActivity;

public class LifecyclesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycles);
        LifecyclesViewModel lifecyclesViewModel = new ViewModelProvider(this).get(LifecyclesViewModel.class);
        CustomChronometer chronometer = findViewById(R.id.chronometer);
        Log.d("LifecyclesActivity", String.valueOf(System.currentTimeMillis())); // 设置Unix时间，当前时间
        Log.d("LifecyclesActivity", String.valueOf(SystemClock.elapsedRealtime())); // 系统从启动开始的时间
        chronometer.setLifecyclesViewModel(lifecyclesViewModel);
        getLifecycle().addObserver(chronometer);
    }


    public static void actionStart(Context context, String value1, String value2){
        Intent intent = new Intent(context, LifecyclesActivity.class);
        intent.putExtra("value1", value1);
        intent.putExtra("value2", value2);
        context.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}