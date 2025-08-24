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

public class PAHalqa extends AppCompatActivity {
    TextView textView1PaHalqaNo, textView6Pa, textView7Pa;

    ImageView imageViewPa;

    EditText editTextPaHalqaNo;

    Button buttonPaHalqaNo;

//    String paVoterName;
//
//    String paVoterCnic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pa_halqa_page);

        textView1PaHalqaNo = findViewById(R.id.textView1PaHalqaNo);
        textView6Pa = findViewById(R.id.textView6Pa);
        textView7Pa = findViewById(R.id.textView7Pa);
        imageViewPa = findViewById(R.id.imageViewPa);
        editTextPaHalqaNo = findViewById(R.id.editTextPaHalqaNo);
        buttonPaHalqaNo = findViewById(R.id.buttonPaHalqaNo);

    }

    public void halqaPa(View view){

       String paVoterName = getIntent().getStringExtra("PAVoterName");
       String paVoterCnic = getIntent().getStringExtra("PAVoterCnic");

//         paVoterName = VoterData.getInstance().getName();
//         paVoterCnic = VoterData.getInstance().getCnic();
        String paHalqaNumber = editTextPaHalqaNo.getText().toString().trim();

        if(paHalqaNumber.isEmpty()){
            Toast.makeText(PAHalqa.this, "Enter PA Halqa Number!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(PAHalqa.this, "Pa Ballot Paper", Toast.LENGTH_SHORT).show();
            Intent intent10 = new Intent(this, PABallotPaper.class);
            intent10.putExtra("PAVoterName", paVoterName);
            intent10.putExtra("PAVoterCnic", paVoterCnic);
            intent10.putExtra("PAHalqaNumber", paHalqaNumber);
            startActivity(intent10);
        }
    }
}
