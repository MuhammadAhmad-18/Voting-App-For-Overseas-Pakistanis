package com.example.votingapplication3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;
    private Button loginButton, registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.logInButton);
        registerButton = findViewById(R.id.registerButton);

        String registeredUsername = getIntent().getStringExtra("username");
        String registeredPassword = getIntent().getStringExtra("password");


        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // Simple validation (in real app, use proper authentication)
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
            }

            VoterSession v2 = VoterSession.getInstance();

            if(username.equals(v2.getUserName()) || password.equals(v2.getPassword())){
                if(v2.isRegistered()){
                    Intent intent4 = new Intent(MainActivity.this, HomePage.class);
                    startActivity(intent4);
                }else {
                    Toast.makeText(MainActivity.this, "Log In Successful", Toast.LENGTH_SHORT).show();
                    Intent intent3 = new Intent(this, InstructionsPage.class);
                    startActivity(intent3);
                }

            } else {
                Toast.makeText(MainActivity.this, "Incorrect Username Or Password", Toast.LENGTH_SHORT).show();
            }




    });
}

public void signUpPage(View view){
    Toast.makeText(MainActivity.this, "Opening Sign Up Page", Toast.LENGTH_SHORT).show();
    Intent intent = new Intent(this, SignUp.class);
    startActivity(intent);
}
}
