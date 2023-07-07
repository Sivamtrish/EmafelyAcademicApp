package com.example.emafelyacademicapp.utils;

import android.widget.EditText;

public class Tools {

    public static boolean checkIsEditTextNull(EditText...editTexts){
        boolean isNotNull = editTexts.length >0;
        for (EditText editText: editTexts){
            if(android.text.TextUtils.isEmpty(editText.getText().toString())){
                isNotNull = false;
                break;
            }
        }
        return isNotNull;
    }

}
