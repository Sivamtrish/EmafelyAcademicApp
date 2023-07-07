package com.example.emafelyacademicapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

public abstract class BaseActivityBinding<VB extends ViewBinding> extends AppCompatActivity {
    protected VB binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        executeMyBinding();
        initComponents();
        initListeners();
        getViewBinding();
    }

    protected abstract VB inflateBinding();

    protected abstract int getLayoutResource();

    protected abstract void initComponents();
    protected abstract void initListeners();

    public VB getViewBinding(){
        return binding;
    }

    private void executeMyBinding() {
        binding = inflateBinding();
        setContentView(binding.getRoot());
    }


}

