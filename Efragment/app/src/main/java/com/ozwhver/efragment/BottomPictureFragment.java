package com.ozwhver.efragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by amyhan on 23/01/16.
 */
public class BottomPictureFragment extends Fragment {

    private static TextView topmemeText;
    private static TextView bottommemeText;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_picture_fragment, container, false);
        topmemeText = (TextView) view.findViewById(R.id.topmemeText);
        bottommemeText = (TextView) view.findViewById(R.id.bttommemeText);
        return view;
    }

    public void setMemeText(String top, String bottom){
        topmemeText.setText(top);
        bottommemeText.setText(bottom);
    }
}
