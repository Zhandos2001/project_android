package com.example.wew;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;




import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class SearchFragment extends Fragment {
    Button sharebutton ;
    Button chan;
    LinearLayout layout ;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_search, container, false);
// get the reference of Button
        sharebutton = (Button) view.findViewById(R.id.share_btn);
        chan = (Button) view.findViewById(R.id.changeb);
        layout = (LinearLayout) view.findViewById(R.id.layout);
// perform setOnClickListener on first Button
        sharebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "This is the pre-formatted message to send.");
                startActivity(intent);
            }
        });

        chan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == chan){
                    layout.setBackgroundResource(R.color.cardview_dark_background);

                }
            }
        });


        return view;
    }}