package com.ayusma.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ayusma.task1.Helper.SharedHelper;
import com.ayusma.task1.R;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin, btnRegister;
    private EditText editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.login_button);
        btnRegister = findViewById(R.id.register_button);
        editTextPassword = findViewById(R.id.password);
        editTextEmail = findViewById(R.id.email);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });


    }


    private void loginUser() {
        final String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            editTextEmail.setError(getString(R.string.enter_email));
            editTextEmail.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError(getString(R.string.enter_password));
            editTextPassword.requestFocus();
            return;
        }


        String confirmEmail = SharedHelper.getKey(this, email);
        String confirmPassword = SharedHelper.getKey(this, password);
        if (!confirmEmail.isEmpty() && !confirmPassword.isEmpty()) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("Email", email);
            startActivity(intent);
            finish();
            Toast.makeText(this, "Login Successfully", Toast.LENGTH_LONG).show();
            overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        } else {
            Toast.makeText(this, "Incorrect Login Details", Toast.LENGTH_LONG).show();
        }
        //create user

    }

}
