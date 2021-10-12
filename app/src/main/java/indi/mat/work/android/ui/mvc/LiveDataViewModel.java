package indi.mat.work.android.ui.mvc;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class LiveDataViewModel extends ViewModel {
    private MutableLiveData<Integer> likedNumber;

    public LiveDataViewModel() {
        this.likedNumber = new MutableLiveData<>();
        this.likedNumber.setValue(new Integer(20));
    }
    
    public LiveDataViewModel(SavedStateHandle handle) {
        this.likedNumber = new MutableLiveData<>();
        this.likedNumber.setValue(new Integer(20));
    }

    public MutableLiveData<Integer> getLikedNumber() {
        return likedNumber;
    }

    public void addLikeNumber(int n){
        likedNumber.setValue(likedNumber.getValue() + n);
    }
}
