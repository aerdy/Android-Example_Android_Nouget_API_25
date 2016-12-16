package com.necisstudio.android7;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.necisstudio.android7.imagekeyboard.ImageKeyboarActivity;
import com.necisstudio.android7.inputmethod.InputMethodActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //dinamic shortcut
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.N_MR1) {
            ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
            ShortcutInfo shortcut = new ShortcutInfo.Builder(this, "id1")
                    .setShortLabel("From Dinamic ShortCut")
                    .setLongLabel("From Dinamic ShortCut")
                    .setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher))
                    .setIntent(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.necistudio.com")))
                    .build();

            shortcutManager.setDynamicShortcuts(Arrays.asList(shortcut));
        }

        //inputmethodactivity
        Button btnInputMethod = (Button)findViewById(R.id.btnInputMethod);
        btnInputMethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InputMethodActivity.class);
                startActivity(intent);
            }
        });

        Button btnImageKey = (Button)findViewById(R.id.btnImageKeyboard);
        btnImageKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ImageKeyboarActivity.class);
                startActivity(intent);
            }
        });
    }
}
