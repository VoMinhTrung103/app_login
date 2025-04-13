package com.hcmus.app_login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class RenewPasswordActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renew_password);
        Button backToMainButton = findViewById(R.id.buttonRenewPasswordDone);
        backToMainButton.setOnClickListener(v -> {
            Intent intent = new Intent(RenewPasswordActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}