package com.example.emafelyacademicapp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.emafelyacademicapp.databinding.ActivityEmafelyLandingPageBinding;

public class EmafelyLandingPageActivity extends BaseActivityBinding<ActivityEmafelyLandingPageBinding> {
    Button btnGetStarted;

    @Override
    protected ActivityEmafelyLandingPageBinding inflateBinding() {
        return ActivityEmafelyLandingPageBinding.inflate(getLayoutInflater());
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_emafely_landing_page;
    }

    @Override
    protected void initComponents() {
        btnGetStarted = getViewBinding().getStartedBtn;
    }

    @Override
    protected void initListeners() {
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmafelyLandingPageActivity.this, EmafelyLandingPageActivity2.class);
                startActivity(intent);
            }
        });
    }


}