package indi.mat.work.android.ui.intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import indi.mat.work.android.BaseActivity;
import indi.mat.work.android.R;

public class IntentActivity extends BaseActivity {

    private static final String TAG = "IntentActivity";

    public static final String ACTIVITY_RESULT_DATA = "data_return";
    TextView textView;
    /**
     * <intent-filter> 标签配置<data> 用于更精确的指定当前活动能够响应什么类型的数据
     * android:scheme     协议 ，如http  一般仅配置 scheme
     * android:host       指定主机名，如 www.hao123.com
     * android:port       端口
     * android:path       资源
     * android:mimeType   指定可以处理的数据类型
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        textView = findViewById(R.id.text_view);
        if(savedInstanceState != null){
            Log.d(TAG, "onCreateBundle: " + savedInstanceState.getString("view_value"));
            textView.setText(savedInstanceState.getString("view_value"));
        }else {
            getActivityMessage();
        }

        Button telButton = findViewById(R.id.tel_button);
        telButton.setOnClickListener((View view)->{
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:10086"));
            startActivity(intent);
        });
    }

    // 按键退出Activity
    @Override
    public void onBackPressed() {
        intentPrevActivity(null);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: " + textView.getText().toString());
        super.onSaveInstanceState(outState);
        outState.putString("view_value", textView.getText().toString());
    }

    // 绑定按钮退出
    public void intentPrevActivity(View view){
        Intent intent  = new Intent();
        intent.putExtra(ACTIVITY_RESULT_DATA, "Hello MainActivity");
        setResult(RESULT_OK, intent);
        finish();
    }

    public void onClickButton(View view){
        textView.setText(R.string.button);
    }

    private void getActivityMessage(){
        Intent intent = getIntent();
        String message = intent.getStringExtra("text_view");
        Log.d(TAG, "getActivityMessage: get main message");
        textView.setText(message);
    }
}