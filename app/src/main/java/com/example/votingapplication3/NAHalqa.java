package com.example.votingapplication3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NAHalqa extends AppCompatActivity {
    TextView textView1NaHalqaNo, textView6Na, textView7Na;

    ImageView imageViewNa;

    EditText editTextNaHalqaNo;

    Button buttonHalqaNo;

    String naVoterName;

    String naVoterCnic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.na_halqa_page);

        textView1NaHalqaNo = findViewById(R.id.textView1NaHalqaNo);
        textView6Na = findViewById(R.id.textView6Na);
        textView7Na = findViewById(R.id.textView7Na);
        imageViewNa = findViewById(R.id.imageViewNa);
        editTextNaHalqaNo = findViewById(R.id.editTextNaHalqaNo);
        buttonHalqaNo = findViewById(R.id.buttonNaHalqaNo);

    }

    public void halqaNa(View view) {
naVoterName = getIntent().getStringExtra("NAVoterName");
naVoterCnic = getIntent().getStringExtra("NAVoterCnic");
        String naHalqaNumber = editTextNaHalqaNo.getText().toString().trim();

        if (naHalqaNumber.isEmpty()) {
            Toast.makeText(NAHalqa.this, "Enter NA Halqa Number!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(NAHalqa.this, "Na Ballot Paper", Toast.LENGTH_SHORT).show();
            Intent intent4 = new Intent(this, NABallotPaper.class);
            intent4.putExtra("NAVoterName", naVoterName);
            intent4.putExtra("NAVoterCnic", naVoterCnic);
            intent4.putExtra("NAHalqaNumber", naHalqaNumber);
            startActivity(intent4);
        }

    }

}
