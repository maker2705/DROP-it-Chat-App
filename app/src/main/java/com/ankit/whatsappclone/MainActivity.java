package com.ankit.whatsappclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.ankit.whatsappclone.Adapters.FragmentsAdapter;
import com.ankit.whatsappclone.databinding.ActivityMainBinding;
import com.ankit.whatsappclone.databinding.ActivitySignInBinding;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
FirebaseAuth mAuth;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mAuth=FirebaseAuth.getInstance();

        binding.viewPager.setAdapter(new FragmentsAdapter(getSupportFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                Intent intent2=new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent2);
                break;
            case R.id.groupChat:
                //write the code
                Intent intent1=new Intent(MainActivity.this, GroupChatActivity.class);
                startActivity(intent1);
                break;
            case R.id.logout:
                mAuth.signOut();
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);

    }
 }
