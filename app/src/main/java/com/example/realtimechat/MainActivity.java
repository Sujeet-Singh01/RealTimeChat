// view pager -- chats, status, calls
// we use tab layout to use view pager.
// One adapter will be used to to replace chats, status, and calls fragments

package com.example.realtimechat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.realtimechat.Adapters.FragmentAdapter;
import com.example.realtimechat.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    FirebaseAuth auth;
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();


        binding.viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager())); // to set adapter in view pager
        binding.tabLayout.setupWithViewPager(binding.viewPager);

    }

    // to import menu.xml into java
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    // to do coding for menu above, what will be the output when a particular menu is selected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.settings:
        Intent i = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(i);
            break;
            case R.id.logout:
                auth.signOut();   //to sign out from our app
                //FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MainActivity.this,SignInActivity.class);
                startActivity(intent);
                break;

            case R.id.Chat_Room:
                Intent intentt = new Intent(MainActivity.this,GroupChatActivity.class);
                startActivity(intentt);
                break;
        }
        return true;
    }
}