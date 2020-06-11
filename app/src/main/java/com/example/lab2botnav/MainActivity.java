package com.example.lab2botnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ToBinFragment fragment1;
    private ToDecFragment fragment2;
    private AddFragment fragment3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        fragment1= new ToBinFragment();
        fragment2 = new ToDecFragment();
        fragment3= new AddFragment();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation); //меню
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_binary:
                        changeFragment(fragment2);
                        break;
                    case R.id.action_decimal:
                        changeFragment(fragment1);
                        break;
                    case R.id.action_plus:
                        changeFragment(fragment3);
                        break;
                }
                return true;
            }
        });
    }
    public void changeFragment(Fragment fragment) { // зміна фрагмента
         getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_conteiner, fragment)
                .commit();
    }
}
