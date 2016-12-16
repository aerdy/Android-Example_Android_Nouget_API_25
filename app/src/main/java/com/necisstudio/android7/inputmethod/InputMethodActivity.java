package com.necisstudio.android7.inputmethod;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.necisstudio.android7.R;

/**
 * Created by vim on 16/12/16.
 */

public class InputMethodActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputmethod_main);
    }
}
