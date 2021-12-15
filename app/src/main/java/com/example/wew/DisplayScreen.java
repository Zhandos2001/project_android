package com.example.wew;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class DisplayScreen extends Fragment {
    TextView displayInfo;

    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_display_screen, container, false);
        //SharedPreferences preferences = this.getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        SharedPreferences preferences = this.getActivity().getSharedPreferences("MYPREFS", Context.MODE_PRIVATE);
        String display = preferences.getString("display", "");

         displayInfo = (TextView) view.findViewById(R.id.textViewName);
        displayInfo.setText(display);

return view;
    }
}