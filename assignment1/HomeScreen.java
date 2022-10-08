package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

import com.example.assignment1.databinding.ActivityHomeScreenBinding;

public class HomeScreen extends AppCompatActivity {

    ActivityHomeScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(R.layout.activity_home_screen);

//        TextView intro = (TextView) findViewById(R.id.intro);
//        TextView obj = new ();
//        intro.setText(obj.UserUsername);
        delFragment(new HomeFragment());
        binding.bottomNavi.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.HomeButton:
                    delFragment(new HomeFragment());
                    break;
                case R.id.HistoryButton:
                    delFragment(new TransactionHistoryFragment());
                    break;
                case R.id.ProfileButton:
                    delFragment(new ProfileFragment());
                    break;

            }

            return true;
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    private void delFragment(Fragment fragment){
        FragmentManager fragmng = getSupportFragmentManager();
        FragmentTransaction fragtrsc = fragmng.beginTransaction();
        fragtrsc.replace(R.id.frameLayout,fragment);
        fragtrsc.commit();

    }
}