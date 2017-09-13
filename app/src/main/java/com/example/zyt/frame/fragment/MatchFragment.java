package com.example.zyt.frame.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zyt.frame.R;

/**
 * Created by zyt on 2017/9/7.
 */

public class MatchFragment extends Fragment {
    private TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match,container,false);
        textView = (TextView) view.findViewById(R.id.textMatch);
        return view;

    }

    public void fresh(String string){
        textView.setText(string);
    }
}
