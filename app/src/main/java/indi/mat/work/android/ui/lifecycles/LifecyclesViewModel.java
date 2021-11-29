package indi.mat.work.android.ui.lifecycles;

import androidx.lifecycle.ViewModel;

public class LifecyclesViewModel extends ViewModel {

    long elapse;

    public long getElapse() {
        return elapse;
    }

    public void setElapse(long elapse) {
        this.elapse = elapse;
    }
}
