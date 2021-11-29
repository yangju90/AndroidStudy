package indi.mat.work.android.ui.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import indi.mat.work.android.BaseActivity;
import indi.mat.work.android.R;
import indi.mat.work.android.ui.lifecycles.LifecyclesActivity;

public class RoomActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
    }

    public static void actionStart(Context context, String value1, String value2){
        Intent intent = new Intent(context, RoomActivity.class);
        intent.putExtra("value1", value1);
        intent.putExtra("value2", value2);
        context.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}