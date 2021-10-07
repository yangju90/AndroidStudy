package indi.mat.work.android.ui.component;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import indi.mat.work.android.BaseActivity;
import indi.mat.work.android.R;

public class ComponentExampleActivity extends BaseActivity {

    private static final String TAG = "ComponentExaActivity";

    TextView display;
    Switch aSwitch;
    SeekBar seekBar;
    EditText seekBarInput;
    RadioGroup radioGroup;
    ImageView imageView;
    SeekBar seekBar2;
    CheckBox checkBoxA, checkBoxB, checkBoxC;
    String checkA = "", checkB = "", checkC = "";
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            Log.d(TAG, "success! onCreate: " + savedInstanceState );
        }

        setContentView(R.layout.activity_component_example);
        display = findViewById(R.id.component_example_display);
        aSwitch = findViewById(R.id.component_example_switch);
        onClickSwitchListener();
        seekBar = findViewById(R.id.component_example_seek_bar);
        seekBarInput = findViewById(R.id.component_example_seek_bar_input);
        radioGroup = findViewById(R.id.component_example_radio_group);
        imageView = findViewById(R.id.component_example_view_image);
        onClickRadioGroupListener();
        seekBar2 = findViewById(R.id.component_example_seek_bar2);
        onChangeSeekBarListener();
        checkBoxA = findViewById(R.id.component_example_checkbox_a);
        checkBoxB = findViewById(R.id.component_example_checkbox_b);
        checkBoxC = findViewById(R.id.component_example_checkbox_c);
        checkBoxA.setOnCheckedChangeListener((CompoundButton compoundButton, boolean b) ->{
            checkA = b ? getString(R.string.component_example_checkbox_a) : "";
            display.setText(checkA + " " +  checkB + " " + checkC);
        });

        checkBoxB.setOnCheckedChangeListener((CompoundButton compoundButton, boolean b) ->{
            checkB = b ? getString(R.string.component_example_checkbox_b) : "";
            display.setText(checkA + " " +  checkB + " " + checkC);
        });

        checkBoxC.setOnCheckedChangeListener((CompoundButton compoundButton, boolean b) ->{
            checkC = b ? getString(R.string.component_example_checkbox_c) : "";
            display.setText(checkA + " " +  checkB + " " + checkC);
        });

        ratingBar = findViewById(R.id.component_example_rating_bar);

        onChangeRatingBarListener();
    }

    public static void actionStart(Context context, String value1, String value2){
        Intent intent = new Intent("indi.mat.work.android.ui.component.COMPONENT_EXAMPLE_START");
        intent.putExtra("value1", value1);
        intent.putExtra("value2", value2);
        context.startActivity(intent);
    }

    public void onClickButtonLeft(View view){
        display.setText(R.string.component_example_button_left);
    }

    public void onClickButtonRight(View view){
        display.setText(R.string.component_example_button_right);
    }

    public void onClickSwitchListener(){
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                display.setText(b == true ? "开" : "关");
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClickSeekBarButton(View view){
        String s = seekBarInput.getText().toString();
        if(TextUtils.isEmpty(s)){
            s = "0";
        }
        seekBar.setProgress(Integer.valueOf(s), true);
        display.setText(s);
    }

    public void onClickRadioGroupListener(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                imageView.setImageResource(i == R.id.component_example_radio_android ? R.drawable.android : R.drawable.apple);
            }
        });
    }


    public void onChangeSeekBarListener(){
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                display.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void onChangeRatingBarListener(){
        ratingBar.setOnRatingBarChangeListener((RatingBar ratingBar, float v, boolean b)-> {
                Toast.makeText(this, String.valueOf(v) + "星评价！", Toast.LENGTH_SHORT).show();
        });
    }



    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
    }


    @Override
    public void finish() {
        Log.d(TAG, "finish: ");
        super.finish();
    }
}