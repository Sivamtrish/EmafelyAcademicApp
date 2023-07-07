package com.example.emafelyacademicapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.emafelyacademicapp.databinding.ActivityEnrollmentBinding;
import com.example.emafelyacademicapp.databinding.ActivitySignInBinding;
import com.google.android.material.navigation.NavigationView;

public class EnrollmentActivity extends BaseActivityBinding<ActivityEnrollmentBinding> implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;


    @Override
    protected ActivityEnrollmentBinding inflateBinding() {
        return ActivityEnrollmentBinding.inflate(getLayoutInflater());
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_enrollment;
    }

    @Override
    protected void initComponents() {
        setSupportActionBar(toolbar);
        toolbar = getViewBinding().toolBar;
        drawerLayout = getViewBinding().drawerLayout;
        navigationView = getViewBinding().navView;

    }

    @Override
    protected void initListeners() {
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

//        if (savedInstantState == null) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DashboardFragment()).commit();
//            navigationView.setCheckedItem(R.id.nav_dashboard);
//        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_dashboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DashboardFragment()).commit();
                break;

            case R.id.nav_announcement:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AnnouncementFragment()).commit();
                break;

            case R.id.nav_retreat:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RetreatFragment()).commit();
                break;

            case R.id.nav_admission:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AdmissionFragment()).commit();
                break;

            case R.id.nav_contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ContactFragment()).commit();
                break;

            case R.id.nav_support:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SupportFragment()).commit();
                break;
            case R.id.nav_Logout:
                Intent intent = new Intent(EnrollmentActivity.this, SignInActivity.class);
                startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
       if(drawerLayout.isDrawerOpen(GravityCompat.START)){
           drawerLayout.closeDrawer(GravityCompat.START);
       }else{
           super.onBackPressed();
       }
    }
}

