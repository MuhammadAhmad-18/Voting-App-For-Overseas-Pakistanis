package com.example.votingapplication3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class InstructionsPage extends AppCompatActivity {
    private boolean instructionsRead = false;

    private CheckBox checkbox;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.instruction_page);
        checkbox = findViewById(R.id.checkBox);
        nextButton = findViewById(R.id.registerButtonCredential);

//        checkbox.setOnFocusChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    instructionsRead = true;
//                }else{
//                    Toast.makeText(InstructionsPage.this, "Next Page", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                instructionsRead = isChecked;
            }
        });

    }


        public void onClickNext (View view){
            if (instructionsRead) {

                Toast.makeText(InstructionsPage.this, "Registeration Page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Credentials.class);
                startActivity(intent);
            }else{
                Toast.makeText(InstructionsPage.this, "Please check the instructions checkbox before continuing", Toast.LENGTH_SHORT).show();
            }
        }
    }