package com.example.emafelyacademicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.emafelyacademicapp.databinding.ActivityAboutUsBinding;

public class AboutUsActivity extends BaseActivityBinding<ActivityAboutUsBinding> {
    ImageView iv_stage_one, iv_stage_two;
    TextView tv_learn_about_us;
    LinearLayout ll_learn_aboutUs;

    @Override
    protected ActivityAboutUsBinding inflateBinding() {
        return ActivityAboutUsBinding.inflate(getLayoutInflater());
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_about_us;
    }

    @Override
    protected void initComponents() {
        iv_stage_one = getViewBinding().ivStageOne;
        iv_stage_two = getViewBinding().ivStageTwo;
        tv_learn_about_us = getViewBinding().tvLearnAboutUs;
        ll_learn_aboutUs = getViewBinding().llLearnAboutUs;
    }

    @Override
    protected void initListeners() {

    }
}