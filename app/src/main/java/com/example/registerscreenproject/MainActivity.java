package com.example.registerscreenproject;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.customregisterscreen.OnRegistrationCompleteListener;
import com.example.customregisterscreen.RegistrationDialogBuilder;

public class MainActivity extends AppCompatActivity {

    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.my_title);

        RegistrationDialogBuilder builder = new RegistrationDialogBuilder(this, getSupportFragmentManager(), R.id.registration_container);

        // Add registration options
        builder.addNameOption(R.drawable.user, "Enter your name");
        builder.addLastNameOption(R.drawable.user, "Enter your last name");
        builder.addEmailOption(R.drawable.ic_mail, "Enter your email");
        builder.addPasswordOption(R.drawable.ic_password, "Enter your password");

        // Set button text and color
        builder.setButtonText("Sign Up");
        builder.setButtonColor(Color.parseColor("#FF5983"));

        builder.setOnRegistrationCompleteListener(new OnRegistrationCompleteListener() {
            @Override
            public void onRegistrationComplete() {
                title.setVisibility(View.VISIBLE);
            }
        });

        builder.show();

    }

}