package com.necisstudio.android7.inputmethod;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.view.View;

import com.necisstudio.android7.R;

/**
 * Created by vim on 16/12/16.
 */

public class MyInputMethod extends InputMethodService {
    private Keyboard mKeyboard;
    private KeyboardView mInputView;

    @Override
    public void onInitializeInterface() {
        mKeyboard = new Keyboard(this, R.layout.keyboard);
    }
    
    @Override
    public View onCreateInputView() {
        mInputView = (KeyboardView) getLayoutInflater().inflate(
                R.layout.keyboard, null);

        mInputView.setKeyboard(mKeyboard);

        return mInputView;
    }
}
