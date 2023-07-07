package com.example.emafelyacademicapp;

import android.content.Intent;
import android.view.View;

import com.example.emafelyacademicapp.databinding.ActivityEmafelyLandingPage2Binding;

public class EmafelyLandingPageActivity2 extends BaseActivityBinding<ActivityEmafelyLandingPage2Binding> {


    @Override
    protected ActivityEmafelyLandingPage2Binding inflateBinding() {
        return ActivityEmafelyLandingPage2Binding.inflate(getLayoutInflater());
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_emafely_landing_page2;
    }

    @Override
    protected void initComponents() {

    }

    @Override
    protected void initListeners() {
        getViewBinding().getStartedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmafelyLandingPageActivity2.this, AboutUsActivity.class);
                startActivity(intent);
            }
        });
    }
}