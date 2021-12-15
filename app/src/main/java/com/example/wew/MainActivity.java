package com.example.wew;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

     DatabaseReference mDataBase;
     String USER_KEY = "User";
     FirebaseAuth mAuth;

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);


        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {

//         getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                    new HomeFragment()).commit();
//            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//            startActivity(intent);
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
//                            selectedFragment = new HomeFragment();
                            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                            startActivity(intent);
                            break;
                        case R.id.nav_favorites:

                            selectedFragment = new DisplayScreen();
                            //selectedFragment = new FavoritesFragment();
                            //SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

                            //String savedPassword = preferences.getString(password, "");
                            //String savedUserName = preferences.getString(user, "");

//                            String userDetails = preferences.getString( "data","No information on that user.");
//                            SharedPreferences.Editor editor = preferences.edit();
//                            editor.putString("display",userDetails);
//                            editor.commit();
//
//                            Intent displayScreen = new Intent(MainActivity.this, DisplayScreen.class);
//                            startActivity(displayScreen);

                            break;
                        case R.id.nav_search:
                            selectedFragment = new SearchFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };




}