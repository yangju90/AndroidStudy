package indi.mat.work.android.ui.mvc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import indi.mat.work.android.BaseActivity;
import indi.mat.work.android.R;
import indi.mat.work.android.databinding.ActivityLiveDataBinding;

public class LiveDataActivity extends BaseActivity {
    private static final String TAG = "LiveDataActivity";

    ActivityLiveDataBinding binding;
    LiveDataViewModel liveDataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_live_data);
        liveDataViewModel = new ViewModelProvider(this).get(LiveDataViewModel.class);

        Log.d(TAG, "onCreate: " + liveDataViewModel.getLikedNumber());

        liveDataViewModel.getLikedNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.liveDataTextView.setText(String.valueOf(integer));
            }
        });
    }

    public void onClickButton(View view){
        Log.d(TAG, "onClickButton: " + view.getId());
        switch (view.getId()){
            case R.id.live_data_button_up:
                liveDataViewModel.addLikeNumber(1);
                break;
            case R.id.live_data_button_down:
                liveDataViewModel.addLikeNumber(-1);
                break;
            default:
        }
    }

    public static void actionStart(Context context, String value1, String value2){
        Intent intent = new Intent("indi.mat.work.android.ui.mvc.LIVE_DATA_START");
        intent.putExtra("value1", value1);
        intent.putExtra("value2", value2);
        context.startActivity(intent);
    }

}