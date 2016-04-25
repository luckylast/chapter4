package com.ozwhver.efragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by amyhan on 23/01/16.
 */
public class TopSessionFragment extends Fragment {

    private static EditText topTextImput;
    private static EditText bottomTextImput;

    TopSectionListener activityCommander;

    public interface TopSectionListener{
        public void createMeme(String top, String bottom);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            activityCommander = (TopSectionListener) activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_section_fragment, container, false);

        topTextImput = (EditText) view.findViewById(R.id.topTextInput);
        bottomTextImput = (EditText) view.findViewById((R.id.buttomTextInput));
        final Button button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buttonClicked(v);
                    }
                }
        );
        return view;
    }

    private void buttonClicked(View v) {
        activityCommander.createMeme(topTextImput.getText().toString(), bottomTextImput.getText().toString());
    }
}
