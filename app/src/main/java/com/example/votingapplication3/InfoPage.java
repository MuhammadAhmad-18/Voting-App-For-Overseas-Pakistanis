package com.example.votingapplication3;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class InfoPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_page); // Replace with your XML filename

        // Initialize TextViews
        TextView tvNameUsername = findViewById(R.id.textViewInfoProfile);
        TextView tvFirstName = findViewById(R.id.textViewInfo1);
        TextView tvLastName = findViewById(R.id.textViewInfo2);
        TextView tvFatherName = findViewById(R.id.textViewInfo3);
        TextView tvGender = findViewById(R.id.textViewInfo4);
        TextView tvEmail = findViewById(R.id.textViewInfo5);
        TextView tvCnic = findViewById(R.id.textViewInfo6);
        TextView tvPassport = findViewById(R.id.textViewInfo7);
        TextView tvDob = findViewById(R.id.textViewInfo8);
        TextView tvCountry = findViewById(R.id.textViewInfo9);
        TextView tvVisaType = findViewById(R.id.textViewInfo10);

        // Get voter data from VoterSession singleton
        VoterSession voter = VoterSession.getInstance();

        // Set data to TextViews
        if (voter != null) {
            tvNameUsername.setText(voter.getName() + "\n" + voter.getCnic());
            tvFirstName.setText("First Name: " + voter.getFirstName());
            tvLastName.setText("Last Name: " + voter.getLastName());
            tvFatherName.setText("Father Name: " + voter.getFatherName());
            tvGender.setText("Gender: " + voter.getGender());
            tvEmail.setText("Email: " + voter.getEmail());
            tvCnic.setText("CNIC: " + voter.getCnic());
            tvPassport.setText("Passport Number: " + voter.getPassportNo());
            tvDob.setText("DOB: " + voter.getDob());
            tvCountry.setText("Country of Residence: " + voter.getCountryOfResidence());
            tvVisaType.setText("Visa Type: " + voter.getVisaType());
        }
    }
}