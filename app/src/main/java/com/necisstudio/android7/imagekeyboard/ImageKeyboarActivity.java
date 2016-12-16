package com.necisstudio.android7.imagekeyboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v13.view.inputmethod.EditorInfoCompat;
import android.support.v13.view.inputmethod.InputConnectionCompat;
import android.support.v13.view.inputmethod.InputContentInfoCompat;
import android.support.v4.os.BuildCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.necisstudio.android7.R;

/**
 * Created by vim on 16/12/16.
 */

public class ImageKeyboarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagekeyboard_main);
        LinearLayout linMain = (LinearLayout)findViewById(R.id.linMain);

        EditText editImage = new EditText(this) {
            @Override
            public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
                final InputConnection ic = super.onCreateInputConnection(editorInfo);
                EditorInfoCompat.setContentMimeTypes(editorInfo,
                        new String [] {"image/png"});

                final InputConnectionCompat.OnCommitContentListener callback =
                        new InputConnectionCompat.OnCommitContentListener() {
                            @Override
                            public boolean onCommitContent(InputContentInfoCompat inputContentInfo,
                                                           int flags, Bundle opts) {
                                // read and display inputContentInfo asynchronously
                                if (BuildCompat.isAtLeastNMR1() && (flags &
                                        InputConnectionCompat.INPUT_CONTENT_GRANT_READ_URI_PERMISSION) != 0) {
                                    try {
                                        inputContentInfo.requestPermission();
                                    }
                                    catch (Exception e) {
                                        return false; // return false if failed
                                    }
                                }

                                // read and display inputContentInfo asynchronously.
                                // call inputContentInfo.releasePermission() as needed.

                                return true;  // return true if succeeded
                            }
                        };
                return InputConnectionCompat.createWrapper(ic, editorInfo, callback);
            }
        };
        editImage.setText("asd");
        linMain.addView(editImage);
    }
}
