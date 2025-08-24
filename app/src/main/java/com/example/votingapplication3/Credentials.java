
package com.example.votingapplication3; // Change this to your actual package name

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Credentials extends AppCompatActivity {

    // Declare all UI elements
    ImageView imageView;
    TextView textView1Reg, textView2Ent, textView3Dob, textView4Gender,
            textView5Email, textView6Cnic, textView7PassportNo, textView8Residence, textView9Visa;

    EditText editTextFirstName, editTextLastName, editTextFatherName, editTextDate, editTextEmail,
            editTextCnic, editTextPassportNo, editTextResidence, editTextOther;

    RadioButton radioButtonMale, radioButtonFemale, radioButtonTransgender;
    RadioButton radioButtonWork, radioButtonStudy, radioButtonPermanent, radioButtonOther;

    CheckBox checkBox;

    Button registerButtonCredential;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credentials_page); // make sure your XML file is named activity_register.xml

        // Initialize all views
        imageView = findViewById(R.id.imageView);
        textView1Reg = findViewById(R.id.textView1Reg);
        textView2Ent = findViewById(R.id.textView2Ent);
        textView3Dob = findViewById(R.id.textView3Dob);
        textView4Gender = findViewById(R.id.textView4Gender);
        textView5Email = findViewById(R.id.textView5Email);
        textView6Cnic = findViewById(R.id.textView6Cnic);
        textView7PassportNo = findViewById(R.id.textView7PassportNo);
        textView8Residence = findViewById(R.id.textView8Residence);
        textView9Visa = findViewById(R.id.textView9Visa);

        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextFatherName = findViewById(R.id.editTextFatherName);
        editTextDate = findViewById(R.id.editTextDate);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextCnic = findViewById(R.id.editTextCnic);
        editTextPassportNo = findViewById(R.id.editTextPassportNo);
        editTextResidence = findViewById(R.id.editTextResidence);
        editTextOther = findViewById(R.id.editTextOther);

        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        radioButtonTransgender = findViewById(R.id.radioButtonTransgender);

        radioButtonWork = findViewById(R.id.radioButtonWork);
        radioButtonStudy = findViewById(R.id.radioButtonStudy);
        radioButtonPermanent = findViewById(R.id.radioButtonPermanent);
        radioButtonOther = findViewById(R.id.radioButtonOther);

        checkBox = findViewById(R.id.checkBox);

        registerButtonCredential = findViewById(R.id.registerButtonCredential);

        // Set OnClickListener for the Register button
        registerButtonCredential.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Now collect all entered data into variables
                String firstName = editTextFirstName.getText().toString().trim();
                String lastName = editTextLastName.getText().toString().trim();
                String fatherName = editTextFatherName.getText().toString().trim();
                String dateOfBirth = editTextDate.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String cnic = editTextCnic.getText().toString().trim();
                String passportNo = editTextPassportNo.getText().toString().trim();
                String residence = editTextResidence.getText().toString().trim();
                String visaOtherDetail = editTextOther.getText().toString().trim();

                // Gender
                String gender = "";
                if (radioButtonMale.isChecked()) {
                    gender = "Male";
                } else if (radioButtonFemale.isChecked()) {
                    gender = "Female";
                } else if (radioButtonTransgender.isChecked()) {
                    gender = "Transgender";
                }

                // Visa Type
                String visaType = "";
                if (radioButtonWork.isChecked()) {
                    visaType = "Work";
                } else if (radioButtonStudy.isChecked()) {
                    visaType = "Study";
                } else if (radioButtonPermanent.isChecked()) {
                    visaType = "Permanent Resident";
                } else if (radioButtonOther.isChecked()) {
                    visaType = "Other: " + visaOtherDetail;
                }

                // Terms and Conditions
                boolean isAgreed = checkBox.isChecked();

                boolean isEmpty = false;

               if(!isAgreed){
                    Toast.makeText(Credentials.this, "Please accept the terms and conditions!", Toast.LENGTH_SHORT).show();
                }

                if (firstName.isEmpty() || lastName.isEmpty() || fatherName.isEmpty() || dateOfBirth.isEmpty() || email.isEmpty() || cnic.isEmpty() || passportNo.isEmpty() || residence.isEmpty() || visaType.isEmpty() || gender.isEmpty()) {
                    Toast.makeText(Credentials.this, "Please enter all the credentials!", Toast.LENGTH_SHORT).show();
                }else{
                    isEmpty = true;
                }

                if (isAgreed && isEmpty) {
                    // You can now send data to database or move to next page
                    Toast.makeText(Credentials.this, "Registration Successful!", Toast.LENGTH_SHORT).show();

                    VoterSession v3 = VoterSession.getInstance();
                    v3.setRegistered(true);


                    Intent intent3 = new Intent(Credentials.this, HomePage.class);
//                    intent3.putExtra("nameOfRegisterer", firstName.concat(lastName));
                    intent3.putExtra("nameOfRegisterer", firstName + " " + lastName);
                    intent3.putExtra("cnicOfRegisterer", cnic);
                    intent3.putExtra("passportNoOfRegisterer", passportNo);
                    intent3.putExtra("emailOfRegisterer", email);
                    intent3.putExtra("dobOfRegisterer", dateOfBirth);
                    intent3.putExtra("genderOfRegisterer", gender);
                    intent3.putExtra("firstNameOfRegisterer", firstName);
                    intent3.putExtra("lastNameOfRegisterer", lastName);
                    intent3.putExtra("fatherNameOfRegisterer", fatherName);
                    intent3.putExtra("countryOfResidenceOfRegisterer", residence);
                    intent3.putExtra("visaOfRegisterer", visaType);
                    startActivity(intent3);
                }
            }
        });
    }
}
