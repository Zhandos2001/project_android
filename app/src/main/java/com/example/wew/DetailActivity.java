package com.example.wew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        ImageView imageView = findViewById(R.id.image_view);
        TextView textView = findViewById(R.id.text_view);
        TextView textView1 = findViewById(R.id.text_view1);


        Bundle bundle = getIntent().getExtras();

        String img = bundle.getString("img");
        String name = bundle.getString("name");
        String birthday = bundle.getString("birthday");

        Glide.with(this).load(img).into(imageView);
        textView.setText(name);
        textView1.setText(birthday);


    }
}