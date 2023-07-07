package com.example.emafelyacademicapp;

import androidx.appcompat.widget.AppCompatButton;

import android.widget.EditText;
import android.widget.TextView;
import com.example.emafelyacademicapp.databinding.ActivitySignInBinding;

public class SignInActivity extends BaseActivityBinding<ActivitySignInBinding> {

    EditText signIn_userName, signIn_password;
    TextView forgot_password, sign_up;
    AppCompatButton sign_in;
    @Override
    protected ActivitySignInBinding inflateBinding() {
        return ActivitySignInBinding.inflate(getLayoutInflater());
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_sign_in;
    }

    @Override
    protected void initComponents() {
        signIn_userName= getViewBinding().etSignInUsername;
        signIn_password= getViewBinding().etSignInPassword;
        forgot_password= getViewBinding().tvForgotPassword;
        sign_in= getViewBinding().btnSignIn;
        sign_up= getViewBinding().tvSignUp;
    }

    @Override
    protected void initListeners() {


    }
}