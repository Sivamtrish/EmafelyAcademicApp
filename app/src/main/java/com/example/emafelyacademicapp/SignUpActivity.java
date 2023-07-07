package com.example.emafelyacademicapp;

import android.app.DatePickerDialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.emafelyacademicapp.databinding.ActivitySignUpBinding;
import com.example.emafelyacademicapp.utils.Tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SignUpActivity extends BaseActivityBinding<ActivitySignUpBinding> {
    String spSelectedGender, spSelectedRelationship, spSelectedStateOfOrigin;
    String confirmPassword, password;
    boolean termsAndConditionIsEmpty;

    @Override
    protected ActivitySignUpBinding inflateBinding() {
        return ActivitySignUpBinding.inflate(getLayoutInflater());
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_sign_up;
    }

    @Override
    protected void initComponents() {
    }

    /**
     * This validates the parent's/guardian name
     **/
    private void validateParentGuardianName(String parentGuardianName) {
        boolean isValid = true;

        // Check length
        if (parentGuardianName.length() < 2) {
            isValid = false;
        }

        // Check alphabetic characters
        if (!parentGuardianName.matches("^[a-zA-Z]*$")) {
            isValid = false;
        }

        if (isValid) {
            // Name is valid
            getViewBinding().etParentGuardianName.setError(null);
        } else {
            // Name is invalid
            getViewBinding().etParentGuardianName.setError("Please enter a valid name with at least two alphabetic characters.");
        }
    }

    /**
     * This method validates the username entered
     **/
    private void validateUsername(String username) {
        boolean isValid = true;

        // Check length
        if (username.length() < 6) {
            isValid = false;
        }

        // Check alphanumeric characters
        if (!username.matches("^[a-zA-Z0-9]*$")) {
            isValid = false;
        }

        if (isValid) {
            // Username is valid
            getViewBinding().etUsername.setError(null);
        } else {
            getViewBinding().etUsername.setError("Username must be at least 6 characters long and contain only alphanumeric characters.");
            // Username is invalid
        }
    }

    /**
     * This method validates the email address entered
     **/
    private void validateEmail(String email) {
        boolean isValid = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();

        if (isValid) {
            // Email address is valid
            getViewBinding().etEmailAddress.setError(null);
        } else {
            // Email address is invalid
            getViewBinding().etEmailAddress.setError("Please enter a valid email address.");
        }
    }

    /**
     * This method validates the name of child
     **/
    private void validateNameOfChild(String nameOfChild) {
        boolean isValid = true;

        // Check length
        if (nameOfChild.length() < 2) {
            isValid = false;
        }

        // Check alphabetic characters
        if (!nameOfChild.matches("^[a-zA-Z]*$")) {
            isValid = false;
        }

        if (isValid) {
            // Name is valid
            getViewBinding().etParentGuardianName.setError(null);
        } else {
            // Name is invalid
            getViewBinding().etParentGuardianName.setError("Please enter a valid name with at least two alphabetic characters.");
        }
    }

    /**
     * This method validates the date of birth
     **/
    private void validateDateOfBirth() {

        getViewBinding().etDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // the instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(SignUpActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        getViewBinding().etDob.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        String dateOfBirth= getViewBinding().etDob.getText().toString();

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
    }



//        boolean isValid = false;
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
//        dateFormat.setLenient(false); // Disable lenient mode to enforce strict parsing
//
//        try {
//            Date date= dateFormat.parse(dob, new java.sql.Date(d));
//            isValid = true;
//        } catch (ParseException exception) {
//            // Invalid date format
//        }
//
//        if (isValid) {
//            // DOB is valid
//            getViewBinding().etDob.setError(null);
//        } else {
//            // DOB is invalid
//            getViewBinding().etDob.setError("Please enter a valid date of birth in the format yyyy-MM-dd.");
//        }


    /**
     * This method validates phone number
     **/
    private void validatePhoneNumber(String phoneNumber) {
        boolean isValid = phoneNumber.matches("\\d{11}");

        if (isValid) {
            // Phone number is valid
            getViewBinding().etHomePhone.setError(null);
        } else {
            // Phone number is invalid
            getViewBinding().etHomePhone.setError("Please enter a valid 11-digit phone number.");
        }
    }

    /**
     * This method validates the house address
     **/
    private void validateHouseAddress(String houseAddress) {
        boolean isAddressValid = !TextUtils.isEmpty(houseAddress);
        if (isAddressValid) {
            // Address is valid
            getViewBinding().etHomeAddress.setError(null);
        } else {
            // Address is invalid
            if (!isAddressValid) {
                getViewBinding().etHomeAddress.setError("Please enter a valid street address.");
            }
        }
    }

    /**
     * This method validates the city of residence
     **/
    private void validateCityOfResidence(String cityOfResidence) {
        boolean isAddressValid = !TextUtils.isEmpty(cityOfResidence);

        if (isAddressValid) {
            // Address is valid
            getViewBinding().etCityOfResidence.setError(null);
        } else {
            // Address is invalid
            if (!isAddressValid) {
                getViewBinding().etCityOfResidence.setError("Please enter a valid street address.");
            }
        }
    }

    /**
     * This method validates the password entered
     **/
    private void validatePassword(String password) {
        boolean isValid = true;

        // Check length
        if (password.length() < 8) {
            isValid = false;
        }

        // Check uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            isValid = false;
        }

        // Check lowercase letter
        if (!password.matches(".*[a-z].*")) {
            isValid = false;
        }

        // Check digit
        if (!password.matches(".*\\d.*")) {
            isValid = false;
        }

        if (isValid) {
            getViewBinding().etPassword.setError(null);
            // Password is valid
        } else {
            // Password is invalid
            getViewBinding().etPassword.setError("Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, and one digit.");
        }
    }

    /**
     * This method confirms the similarity of the previously entered password with the second input
     **/
    private void validateConfirmPassword() {

        boolean isPasswordMatch = password.matches(confirmPassword);

        if (!isPasswordMatch) {
            getViewBinding().etConfirmPassword.setError("Password does not match");
        } else {
            getViewBinding().etConfirmPassword.setError(null);
            enableDisableBtn();
        }
    }

    @Override
    protected void initListeners() {
        /**Here we check the value entered by the user and validate the parent/guardian name**/

        getViewBinding().etParentGuardianName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This method is called before the text is changed.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // This method is called when the text is changed.
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This method is called after the text has been changed.
                String parentGuardianName = s.toString();
                validateParentGuardianName(parentGuardianName);
                enableDisableBtn();

            }
        });

        /**Here we check the username entered by the user and validate **/
        getViewBinding().etUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This method is called before the text is changed.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // This method is called when the text is changed.
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This method is called after the text has been changed.
                String username = s.toString();
                validateUsername(username);
                enableDisableBtn();
            }
        });

        /**Here we check the Email Address entered by the user and validate **/
        getViewBinding().etEmailAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This method is called before the text is changed.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // This method is called when the text is changed.
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This method is called after the text has been changed.
                String emailAddress = s.toString();
                validateEmail(emailAddress);
                enableDisableBtn();
            }
        });

        /**Here we check the name of child entered by the user and validate **/
        getViewBinding().etNameOfChild.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This method is called before the text is changed.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // This method is called when the text is changed.
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This method is called after the text has been changed.
                String nameOfChild = s.toString();
                validateNameOfChild(nameOfChild);
                enableDisableBtn();
            }
        });

        /**Here we store the spinner selected gender **/
        String[] genderOptions = getResources().getStringArray(R.array.gender);
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, genderOptions);
        getViewBinding().spGender.setAdapter(arrayAdapter);


        getViewBinding().spGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spSelectedGender = parent.getSelectedItem().toString();
                enableDisableBtn();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /**Here we validate the dob entered by the user**/


//        getViewBinding().etDob.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                // This method is called before the text is changed.
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                // This method is called when the text is changed.
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                // This method is called after the text has been changed.
//                String dob = s.toString();
//                validateDateOfBirth(dob);
//                enableDisableBtn();
//            }
//        });

        /**Here we validate the user's phone number**/
        getViewBinding().etHomePhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This method is called before the text is changed.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // This method is called when the text is changed.
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This method is called after the text has been changed.
                String phoneNumber = s.toString();
                validatePhoneNumber(phoneNumber);
                enableDisableBtn();
            }
        });

        /** Here we validate the user's house address **/
        getViewBinding().etHomeAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This method is called before the text is changed.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // This method is called when the text is changed.
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This method is called after the text has been changed.
                String houseAddress = s.toString();
                validateHouseAddress(houseAddress);
                enableDisableBtn();
            }
        });

        /** Here we validate the user's city of residence **/
        getViewBinding().etCityOfResidence.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This method is called before the text is changed.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // This method is called when the text is changed.
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This method is called after the text has been changed.
                String cityOfResidence = s.toString();
                validateCityOfResidence(cityOfResidence);
                enableDisableBtn();
            }
        });

        /** Here we store the spinner selected value (relationship status) **/
        String[] relationshipToChildOptions = getResources().getStringArray(R.array.relationship);
        ArrayAdapter arrayAdapterRelationship = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, relationshipToChildOptions);
        getViewBinding().spRelationshipToChild.setAdapter(arrayAdapterRelationship);

        getViewBinding().spRelationshipToChild.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spSelectedRelationship = parent.getSelectedItem().toString();
                enableDisableBtn();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        /**Here we store the user selected state of origin**/
        String[] stateOfOriginOptions = getResources().getStringArray(R.array.stateOfOrigin);
        ArrayAdapter arrayAdapterStateOfOrigin = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stateOfOriginOptions);
        getViewBinding().spStateOfOrigin.setAdapter(arrayAdapterStateOfOrigin);

        getViewBinding().spStateOfOrigin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spSelectedStateOfOrigin = parent.getSelectedItem().toString();
                enableDisableBtn();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /** Here we validate the entered password to conform to regex **/
        getViewBinding().etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This method is called before the text is changed.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // This method is called when the text is changed.
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This method is called after the text has been changed.
                password = s.toString();
                validatePassword(password);
                enableDisableBtn();
            }
        });

        /** Here we validate the previously entered password with the current one entered **/
        getViewBinding().etConfirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This method is called before the text is changed.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // This method is called when the text is changed.
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This method is called after the text has been changed.
                confirmPassword = s.toString().trim();
                validateConfirmPassword();
                enableDisableBtn();

            }
        });

        /** Here we check if the user has checked the terms and condition check box **/
        getViewBinding().cbTermsConditions.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                termsAndConditionIsEmpty = !getViewBinding().cbTermsConditions.isChecked();
                if (termsAndConditionIsEmpty) {
                    Toast.makeText(SignUpActivity.this, "To continue, accept the Terms and Conditions", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    getViewBinding().btnSubmit.setVisibility(View.VISIBLE);
                    enableDisableBtn();
                }
            }
        });

        getViewBinding().btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void enableDisableBtn() {
        getViewBinding().btnSubmit.setEnabled(
                Tools.checkIsEditTextNull(getViewBinding().etParentGuardianName)
                        && Tools.checkIsEditTextNull(getViewBinding().etUsername)
                        && Tools.checkIsEditTextNull(getViewBinding().etEmailAddress)
                        && Tools.checkIsEditTextNull(getViewBinding().etNameOfChild)
                        && !android.text.TextUtils.isEmpty(spSelectedGender)
                        && Tools.checkIsEditTextNull(getViewBinding().etDob)
                        && Tools.checkIsEditTextNull(getViewBinding().etHomePhone)
                        && Tools.checkIsEditTextNull(getViewBinding().etHomeAddress)
                        && !android.text.TextUtils.isEmpty(spSelectedStateOfOrigin)
                        && Tools.checkIsEditTextNull(getViewBinding().etCityOfResidence)
                        && !android.text.TextUtils.isEmpty(spSelectedRelationship)
                        && Tools.checkIsEditTextNull(getViewBinding().etPassword)
                        && Tools.checkIsEditTextNull(getViewBinding().etConfirmPassword));
    }
}



