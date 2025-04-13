package com.hcmus.app_login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Patterns;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button loginButton, signUpButton, forgetPasswordButton;
    private CheckBox showPasswordCheckbox;

    private final String defaultEmail = "admin@gmail.com";
    private final String defaultPassword = "Password123";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.editTextEmail);
        passwordEditText = findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.buttonLogin);
        signUpButton = findViewById(R.id.buttonSignup);
        forgetPasswordButton = findViewById(R.id.buttonForgetPassword);
        showPasswordCheckbox = findViewById(R.id.showPasswordCheckBox);

        showPasswordCheckbox.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                passwordEditText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            } else {
                passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        });

        loginButton.setOnClickListener(view -> {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString();

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(MainActivity.this, "Invalid email format", Toast.LENGTH_SHORT).show();
                return;
            }

            if (email.equals(defaultEmail) && password.equals(defaultPassword)) {
                startActivity(new Intent(MainActivity.this, HelloUserActivity.class));
            } else {
                Toast.makeText(MainActivity.this, "User or Password is incorrect", Toast.LENGTH_SHORT).show();
            }
        });

        signUpButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SignUpActivity.class)));

        forgetPasswordButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, RenewPasswordActivity.class)));
    }
}
