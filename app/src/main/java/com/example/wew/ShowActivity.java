package com.example.wew;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {
     TextView tvName,tvEmail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_layout);
        createUser();
        getIntentMain();
    }
    private void createUser()
    {
        tvName = findViewById(R.id.tvName);

        tvEmail = findViewById(R.id.tvEmail);

    }
    private void getIntentMain()
    {
        Intent i = getIntent();
        if(i != null)
        {
           tvName.setText(i.getStringExtra(Constant.USER_NAME));
//            tvSecName.setText(i.getStringExtra(Constant.USER_SEC_NAME));
            tvEmail.setText(i.getStringExtra(Constant.USER_EMAIL));
        }
    }
}