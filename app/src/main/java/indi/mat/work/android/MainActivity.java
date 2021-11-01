package indi.mat.work.android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import indi.mat.work.android.ui.component.ComponentExampleActivity;
import indi.mat.work.android.ui.drawer.DrawerLayoutActivity;
import indi.mat.work.android.ui.intent.IntentActivity;
import indi.mat.work.android.ui.launchmode.MainLaunchModeActivity;
import indi.mat.work.android.ui.mvc.LiveDataActivity;
import indi.mat.work.android.ui.toolbar.ToolBarActivity;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            Log.d(TAG, "onCreate: savedInstanceState" + savedInstanceState.getString("intent_text_view_value"));
        }

        Button quitButton = findViewById(R.id.quitButton);
        quitButton.setOnClickListener((View view) -> {
            Toast.makeText(this, "Application exiting now", Toast.LENGTH_SHORT).show();
            finish();
        });


        Button browseButton = findViewById(R.id.main_browse);
        browseButton.setOnClickListener((View view) ->{
            // 打开系统浏览器
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.hao123.com"));
            startActivity(intent);
        });

    }


    public void sendMessage(View view){
        EditText editText = (EditText) findViewById(R.id.intent_text_view);
        Intent intent = new Intent("indi.mat.work.android.ui.intent.INTENT_START");
        String message = editText.getText().toString();
        intent.putExtra("text_view", message);
        startActivityForResult(intent, 1);
        Log.d(TAG, "sendMessage: send to Intent");
    }

    public void clickToComponentExampleActivity(View view){
        ComponentExampleActivity.actionStart(this, "", "");
        Log.d(TAG, "clickToComponentExampleActivity: Jumped to!");
    }

    public void clickToLiveDataActivity(View view){
        LiveDataActivity.actionStart(this, "", "");
        Log.d(TAG, "clickToComponentExampleActivity: Jumped to!");
    }

    public void clickToToolBarActivity(View view){
        ToolBarActivity.actionStart(this, "", "");
        Log.d(TAG, "clickToToolBarActivity: Jumped to!");
    }

    public void clickToDrawerLayoutActivity(View view){
        DrawerLayoutActivity.actionStart(this, "", "");
        Log.d(TAG, "clickToToolBarActivity: Jumped to!");
    }

    public void clickToLaunchModeActivity(View view){
        MainLaunchModeActivity.actionStart(this, "", "");
        Log.d(TAG, "clickToToolBarActivity: Jumped to!");
    }


    // Activity 回收时调用，没有测试出调用的逻辑
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        EditText editText = (EditText) findViewById(R.id.intent_text_view);
        outState.putString("intent_text_view_value", editText.getText().toString());
        Log.d(TAG, "onSaveInstanceState: " + editText.getText().toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if(resultCode == RESULT_OK){
                    String  s = data.getStringExtra(IntentActivity.ACTIVITY_RESULT_DATA);
                    Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
                    Log.d(TAG, s);
                }
                break;
            default:

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()){
            case R.id.profile:
                intent = new Intent("indi.mat.work.android.ui.profile.PROFILE_START");
                intent.addCategory("indi.mat.work.android.ui.profile.CATEGORY");
                startActivity(intent);
                break;
            case R.id.add_item:
                Toast.makeText(this, "Item add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "Item remove", Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_item:
                intent = new Intent("indi.mat.work.android.ui.login.LOGIN_START");
                intent.addCategory("indi.mat.work.android.ui.login.CATEGORY");
                startActivity(intent);
                break;
            default:
        }

        return super.onOptionsItemSelected(item);
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
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
}