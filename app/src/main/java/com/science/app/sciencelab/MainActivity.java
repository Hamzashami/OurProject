package com.science.app.sciencelab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ActionBarDrawerToggle toggle;
    NavigationView nav;
    DrawerLayout drawer;
    Toolbar toolbar;
    FragmentManager fm;
    ShowDevicesFragment showDevicesFragment;
    Bundle bundle;
    ShowDevicesFragment sd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
        initItems();
        initClicks();

    }


    private void initClicks() {
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.mech){
                    showDevicesFragment.refresh(1);
                }else if (id == R.id.elec){
                    showDevicesFragment.refresh(2);
                }else if (id == R.id.static_elec){
                    Toast.makeText(MainActivity.this, "cc", Toast.LENGTH_SHORT).show();

                }else if (id == R.id.magn){
                    Toast.makeText(MainActivity.this, "dd", Toast.LENGTH_SHORT).show();

                }else if (id == R.id.temp){
                    Toast.makeText(MainActivity.this, "ee", Toast.LENGTH_SHORT).show();

                }else if (id == R.id.light){
                    Toast.makeText(MainActivity.this, "dd", Toast.LENGTH_SHORT).show();

                }else if (id == R.id.chem){
                    Toast.makeText(MainActivity.this, "kk", Toast.LENGTH_SHORT).show();

                }else if (id == R.id.biol){
                    Toast.makeText(MainActivity.this, "ff", Toast.LENGTH_SHORT).show();

                }else if (id == R.id.glass){

                    Toast.makeText(MainActivity.this, "qq", Toast.LENGTH_SHORT).show();
                }else if (id == R.id.helper){
                    Toast.makeText(MainActivity.this, "oo", Toast.LENGTH_SHORT).show();

                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    private void initItems() {

        drawer.addDrawerListener(toggle);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(MainActivity.this,drawer,toolbar,R.string.app_name,R.string.app_name);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        bundle = new Bundle();
        fm = getSupportFragmentManager();
        sd = new ShowDevicesFragment();
        showDevicesFragment = new ShowDevicesFragment();
        showDevicesFragment.setArguments(bundle);
        bundle.putInt("num",1);
        getSupportFragmentManager().beginTransaction().remove(showDevicesFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.container,showDevicesFragment).commit();
        nav.setCheckedItem(0);
    }

    private void initViews() {
        nav = findViewById(R.id.nav_view);
        drawer = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar_main);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            finish();
            finishAffinity();
        }
    }

}
