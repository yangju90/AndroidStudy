package indi.mat.work.android.ui.lifecycles;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class CustomChronometer extends Chronometer implements LifecycleObserver {

    LifecyclesViewModel lifecyclesViewModel;

    public CustomChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
        lifecyclesViewModel = new LifecyclesViewModel();
    }

    public void setLifecyclesViewModel(LifecyclesViewModel viewModel){
        this.lifecyclesViewModel = viewModel;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected void onResume() {
        setBase(SystemClock.elapsedRealtime() - lifecyclesViewModel.getElapse());
        start();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    protected void onPause() {
        lifecyclesViewModel.setElapse(SystemClock.elapsedRealtime() - getBase());
        stop();
    }
}
