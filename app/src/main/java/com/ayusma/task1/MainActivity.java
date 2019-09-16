package com.ayusma.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.ayusma.task1.Helper.SharedHelper;

public class MainActivity extends AppCompatActivity {
    private TextView textViewEmail, textViewPhone, textViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewEmail = findViewById(R.id.text_view_email);
        textViewName = findViewById(R.id.text_view_name);
        textViewPhone = findViewById(R.id.text_view_number);

       String email = getIntent().getStringExtra("Email");
       String phone = SharedHelper.getKey(this,email+" Phone");
       String fullName = SharedHelper.getKey(this,email+" Phone");

       textViewEmail.setText(email);
       textViewPhone.setText(phone);
       textViewName.setText(fullName);

    }
}
