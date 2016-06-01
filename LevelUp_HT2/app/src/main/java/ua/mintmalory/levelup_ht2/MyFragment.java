package ua.mintmalory.levelup_ht2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mintmalory on 29.05.16.
 */
public class MyFragment extends Fragment {
    private View v;
    private int color = 0x00FFFFFF;

    public MyFragment(int color){
        this();
        this.color = color;
    }
    public MyFragment(){
        this.setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= new View(getActivity().getBaseContext());
        v.setBackgroundColor(getResources().getColor(color));
        v.invalidate();
        return v;
    }

    @Override
    public String toString() {
        return Integer.toHexString(color);
    }
}
