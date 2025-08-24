package com.example.votingapplication3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    private EditText nameEditText, usernameEditText2, passwordEditText2;
    private Button signUpButton;

     private String nameOfSignUp;
     public String userNameOfSignUp;

     public String passwordOfSignUp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.sign_up);

        nameEditText = findViewById(R.id.nameEditText);
        usernameEditText2 = findViewById(R.id.usernameEditText2);
        passwordEditText2 = findViewById(R.id.passwordEditText2);
        signUpButton = findViewById(R.id.logInButton2);


    }
    public void logInPage(View view){

        nameOfSignUp = nameEditText.getText().toString();
        userNameOfSignUp = usernameEditText2.getText().toString();
        passwordOfSignUp = passwordEditText2.getText().toString();

if (nameOfSignUp.isEmpty() || userNameOfSignUp.isEmpty() || passwordOfSignUp.isEmpty()) {
            Toast.makeText(SignUp.this, "Please enter name,username and password", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(SignUp.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();

            //storing to the singleton class
    VoterSession v1 = VoterSession.getInstance();
    v1.setUserName(userNameOfSignUp);
    v1.setPassword(passwordOfSignUp);
    v1.setRegistered(false);

            Intent intent2 = new Intent(this, MainActivity.class);
    intent2.putExtra("username", userNameOfSignUp);
    intent2.putExtra("password", passwordOfSignUp);
    startActivity(intent2);
        }
    }
}
