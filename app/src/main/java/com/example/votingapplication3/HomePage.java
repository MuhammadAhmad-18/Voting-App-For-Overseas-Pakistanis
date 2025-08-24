package com.example.votingapplication3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    TextView textView1Profile, textView2Name, textView3Cnic, textView4PassportNo, textView5Email;
    TextView textView9NaVote, textView7Status, textView8UpdateNaStatus;
    TextView textView9PaVote, textView10PaStatus, textView11UpdatePaStatus;
    Button button1CastNaVote, button2CastPaVote;
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        initializeViews();

        // Check if we're coming from registration or returning from another activity
        if (getIntent().getExtras() != null && getIntent().hasExtra("nameOfRegisterer")) {
            // New registration - store data in singleton
            storeRegistrationData();
        }

        // Always load data from singleton
        loadVoterData();
    }

    private void initializeViews() {
        textView1Profile = findViewById(R.id.textView1Profile);
        textView2Name = findViewById(R.id.textView2Name);
        textView3Cnic = findViewById(R.id.textView3cnic);
        textView4PassportNo = findViewById(R.id.textView4passportno);
        textView5Email = findViewById(R.id.textView5email);

        textView9NaVote = findViewById(R.id.textView9navote);
        textView7Status = findViewById(R.id.textView7status);
        textView8UpdateNaStatus = findViewById(R.id.textView8updatenastatus);

        textView9PaVote = findViewById(R.id.textView9pavote);
        textView10PaStatus = findViewById(R.id.textView10pastatus);
        textView11UpdatePaStatus = findViewById(R.id.textView11updateipastatus);

        button1CastNaVote = findViewById(R.id.button1castnavote);
        button2CastPaVote = findViewById(R.id.button2castpavote);
//        buttonHome = findViewById(R.id.btnHome);
//        buttonInfo = findViewById(R.id.btnInfo);
//        buttonLogOut = findViewById(R.id.btnLogout);

        imageView1 = findViewById(R.id.imageView1);
    }

    private void storeRegistrationData() {
        VoterSession session = VoterSession.getInstance();
        session.setName(getIntent().getStringExtra("nameOfRegisterer"));
        session.setCnic(getIntent().getStringExtra("cnicOfRegisterer"));
        session.setPassportNo(getIntent().getStringExtra("passportNoOfRegisterer"));
        session.setEmail(getIntent().getStringExtra("emailOfRegisterer"));
        session.setFirstName(getIntent().getStringExtra("firstNameOfRegisterer"));
        session.setLastName(getIntent().getStringExtra("lastNameOfRegisterer"));
        session.setFatherName(getIntent().getStringExtra("fatherNameOfRegisterer"));
        session.setGender(getIntent().getStringExtra("genderOfRegisterer"));
        session.setDob(getIntent().getStringExtra("dobOfRegisterer"));
        session.setCountryOfResidence(getIntent().getStringExtra("countryOfResidenceOfRegisterer"));
        session.setVisaType(getIntent().getStringExtra("visaOfRegisterer"));
        session.setNaVoteCasted(false);
        session.setPaVoteCasted(false);
    }

    private void loadVoterData() {
        VoterSession session = VoterSession.getInstance();

        textView2Name.setText(session.getName());
        textView3Cnic.setText("CNIC: " + session.getCnic());
        textView4PassportNo.setText("Passport No.: " + session.getPassportNo());
        textView5Email.setText("Email: " + session.getEmail());

        if (session.isNaVoteCasted()) {
            textView8UpdateNaStatus.setText("CASTED");
        } else {
            textView8UpdateNaStatus.setText("NOT CASTED");
        }

        if (session.isPaVoteCasted()) {
            textView11UpdatePaStatus.setText("CASTED");
        } else {
            textView11UpdatePaStatus.setText("NOT CASTED");
        }
    }

    public void castNaVote(View v) {
        VoterSession session = VoterSession.getInstance();
        if (session.isNaVoteCasted()) {
            showCastedVoteDialogBox("NA(National Assembly) Vote");
        } else {
            Toast.makeText(HomePage.this, "NA Halqa Page!", Toast.LENGTH_SHORT).show();
            Intent intent5 = new Intent(this, NAHalqa.class);
            intent5.putExtra("NAVoterName", session.getName());
            intent5.putExtra("NAVoterCnic", session.getCnic());
            startActivity(intent5);
        }
    }

    public void castPaVote(View v) {
        VoterSession session = VoterSession.getInstance();
        if (session.isPaVoteCasted()) {
            showCastedVoteDialogBox("PA(Provincial Assembly) Vote");
        } else {
            Toast.makeText(HomePage.this, "PA Halqa Page!", Toast.LENGTH_SHORT).show();
            Intent intent6 = new Intent(this, PAHalqa.class);
            intent6.putExtra("PAVoterName", session.getName());
            intent6.putExtra("PAVoterCnic", session.getCnic());
            startActivity(intent6);
        }
    }

    public void showCastedVoteDialogBox(String voteType) {
        new AlertDialog.Builder(this)
                .setTitle("NOTE: VOTE ALREADY CASTED!")
                .setMessage("Your " + voteType + " is already casted.\n\n You cannot cast vote again.")
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(R.drawable.warningimg)
                .show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // Update vote status if coming back from voting
        if (intent.getExtras() != null) {
            VoterSession session = VoterSession.getInstance();
            if (intent.hasExtra("NaVoteStatus")) {
                session.setNaVoteCasted(intent.getBooleanExtra("NaVoteStatus", false));
            }
            if (intent.hasExtra("PaVoteStatus")) {
                session.setPaVoteCasted(intent.getBooleanExtra("PaVoteStatus", false));
            }
            loadVoterData();
        }
    }

    public void onLogOut(View view){
        new AlertDialog.Builder(this)
                .setTitle("LOG OUT!")
                .setMessage("Are you sure you want to log out?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(HomePage.this, MainActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(R.drawable.warningimg)
                .show();
    }

  public void onHome(View view){
    Toast.makeText(HomePage.this, "Home Page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(HomePage.this, HomePage.class);
        startActivity(intent);
  }
//
   public void onInfo(View view){
       Toast.makeText(HomePage.this, "Info Page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(HomePage.this, InfoPage.class);
        startActivity(intent);
   }
}



//package com.example.votingapplication3;
//
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class HomePage extends AppCompatActivity {
//
//    TextView textView1Profile, textView2Name, textView3Cnic, textView4PassportNo, textView5Email;
//    TextView textView9NaVote, textView7Status, textView8UpdateNaStatus;
//    TextView textView9PaVote, textView10PaStatus, textView11UpdatePaStatus;
//    Button button1CastNaVote, button2CastPaVote;
//    ImageView imageView1;
//
//    boolean naVoteCasted = false;
//    boolean paVoteCasted = false;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.home_page);
//
//        textView1Profile = findViewById(R.id.textView1Profile);
//        textView2Name = findViewById(R.id.textView2Name);
//        textView3Cnic = findViewById(R.id.textView3cnic);
//        textView4PassportNo = findViewById(R.id.textView4passportno);
//        textView5Email = findViewById(R.id.textView5email);
//
//        textView9NaVote = findViewById(R.id.textView9navote);
//        textView7Status = findViewById(R.id.textView7status);
//        textView8UpdateNaStatus = findViewById(R.id.textView8updatenastatus);
//
//        textView9PaVote = findViewById(R.id.textView9pavote);
//        textView10PaStatus = findViewById(R.id.textView10pastatus);
//        textView11UpdatePaStatus = findViewById(R.id.textView11updateipastatus);
//
//        button1CastNaVote = findViewById(R.id.button1castnavote);
//        button2CastPaVote = findViewById(R.id.button2castpavote);
//
//        imageView1 = findViewById(R.id.imageView1);
//
//        // Only set voter data if intent has extras
//        if (getIntent().getExtras() != null) {
//            String registeredName = getIntent().getStringExtra("nameOfRegisterer");
//            String registeredCnic = getIntent().getStringExtra("cnicOfRegisterer");
//            String registeredPassportNo = getIntent().getStringExtra("passportNoOfRegisterer");
//            String registeredEmail = getIntent().getStringExtra("emailOfRegisterer");
//
//            // Save to Singleton
//            VoterData.getInstance().setData(registeredName, registeredCnic, registeredPassportNo, registeredEmail);
//        }
//
//        // Get data from Singleton
//        textView2Name.setText(VoterData.getInstance().getName());
//        textView3Cnic.setText("CNIC: " + VoterData.getInstance().getCnic());
//        textView4PassportNo.setText("Passport No.: " + VoterData.getInstance().getPassport());
//        textView5Email.setText("Email: " + VoterData.getInstance().getEmail());
//
//        // Set vote status if passed via Intent (optional logic if coming back from vote activity)
//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            boolean isNAVoteCasted = extras.getBoolean("NaVoteStatus", naVoteCasted);
//            boolean isPAVoteCasted = extras.getBoolean("PaVoteStatus", paVoteCasted);
//
//            naVoteCasted = isNAVoteCasted;
//            paVoteCasted = isPAVoteCasted;
//        }
//
//        textView8UpdateNaStatus.setText(naVoteCasted ? "CASTED" : "NOT CASTED");
//        textView11UpdatePaStatus.setText(paVoteCasted ? "CASTED" : "NOT CASTED");
//    }
//
//    public void castNaVote(View v) {
//        if (naVoteCasted) {
//            showCastedVoteDialogBox("NA(National Assembly) Vote");
//        } else {
//            Toast.makeText(HomePage.this, "NA Halqa Page!", Toast.LENGTH_SHORT).show();
//            Intent intent5 = new Intent(this, NAHalqa.class);
//            intent5.putExtra("NAVoterName", VoterData.getInstance().getName());
//            intent5.putExtra("NAVoterCnic", VoterData.getInstance().getCnic());
//            startActivity(intent5);
//        }
//    }
//
//    public void castPaVote(View v) {
//        if (paVoteCasted) {
//            showCastedVoteDialogBox("PA(Provincial Assembly) Vote");
//        } else {
//            Toast.makeText(HomePage.this, "PA Halqa Page!", Toast.LENGTH_SHORT).show();
//
////            String name = getIntent().getStringExtra("nameOfRegisterer");
////            String cnic = getIntent().getStringExtra("cnicOfRegisterer");
//
//            Intent intent6 = new Intent(this, PAHalqa.class);
//            intent6.putExtra("PAVoterName", VoterData.getInstance().getName());
//            intent6.putExtra("PAVoterCnic", VoterData.getInstance().getCnic());
//
////            intent6.putExtra("PAVoterName",name);
////            intent6.putExtra("PAVoterCnic",cnic);
//            startActivity(intent6);
//        }
//    }
//
//    public void showCastedVoteDialogBox(String voteType) {
//        new AlertDialog.Builder(this)
//                .setTitle("NOTE: VOTE ALREADY CASTED!")
//                .setMessage("Your " + voteType + " is already casted.\n\n You cannot cast vote again.")
//                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                })
//                .setIcon(R.drawable.warningimg)
//                .show();
//    }
//}




//package com.example.votingapplication3;
//
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class HomePage extends AppCompatActivity {
//
//    TextView textView1Profile, textView2Name, textView3Cnic, textView4PassportNo, textView5Email;
//    TextView textView9NaVote, textView7Status, textView8UpdateNaStatus;
//    TextView textView9PaVote, textView10PaStatus, textView11UpdatePaStatus;
//    Button button1CastNaVote, button2CastPaVote;
//    ImageView imageView1;
//
//    String voterName;
//
//    String voterCnic;
//
//    boolean naVoteCasted = false;
//    boolean paVoteCasted = false;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.home_page);
//
//        textView1Profile = findViewById(R.id.textView1Profile);
//        textView2Name = findViewById(R.id.textView2Name);
//        textView3Cnic = findViewById(R.id.textView3cnic);
//        textView4PassportNo = findViewById(R.id.textView4passportno);
//        textView5Email = findViewById(R.id.textView5email);
//
//        textView9NaVote = findViewById(R.id.textView9navote);
//        textView7Status = findViewById(R.id.textView7status);
//        textView8UpdateNaStatus = findViewById(R.id.textView8updatenastatus);
//
//        textView9PaVote = findViewById(R.id.textView9pavote);
//        textView10PaStatus = findViewById(R.id.textView10pastatus);
//        textView11UpdatePaStatus = findViewById(R.id.textView11updateipastatus);
//
//        button1CastNaVote = findViewById(R.id.button1castnavote);
//        button2CastPaVote = findViewById(R.id.button2castpavote);
//
//        imageView1 = findViewById(R.id.imageView1);
//
//String registeredName = getIntent().getStringExtra("nameOfRegisterer");
//String registeredCnic = getIntent().getStringExtra("cnicOfRegisterer");
//String registeredPassportNo = getIntent().getStringExtra("passportNoOfRegisterer");
//String registeredEmail = getIntent().getStringExtra("emailOfRegisterer");
//
//voterName = registeredName;
//voterCnic = registeredCnic;
//
//
//textView2Name.setText(registeredName);
//textView3Cnic.setText("CNIC: " + registeredCnic);
//textView4PassportNo.setText("Passport No.: " + registeredPassportNo);
//textView5Email.setText("Email: " + registeredEmail);
//
//boolean isNAVoteCasted = getIntent().getExtras().getBoolean("NaVoteStatus");
//boolean isPAVoteCasted = getIntent().getExtras().getBoolean("PaVoteStatus");
//
//if(!isNAVoteCasted){
//    textView8UpdateNaStatus.setText("NOT CASTED");
//}else{
//    textView8UpdateNaStatus.setText("CASTED");
//    naVoteCasted = true;
//}
//
//if(!isPAVoteCasted){
//    textView11UpdatePaStatus.setText("NOT CASTED");
//}else{
//    textView11UpdatePaStatus.setText("CASTED");
//    paVoteCasted = true;
//}
//
//
//    }
//
//    public void castNaVote(View v){
//        if(naVoteCasted){
//            showCastedVoteDialogBox("NA(National Assembly) Vote");
//        }else {
//            Toast.makeText(HomePage.this, "NA Halqa Page!", Toast.LENGTH_SHORT).show();
//            Intent intent5 = new Intent(this, NAHalqa.class);
//            intent5.putExtra("NAVoterName", voterName);
//            intent5.putExtra("NAVoterCnic", voterCnic);
//            startActivity(intent5);
//        }
//    }
//
//    public void castPaVote(View v){
//        if(paVoteCasted){
//            showCastedVoteDialogBox("PA(Provincial Assembly) Vote");
//        }else {
//            Toast.makeText(HomePage.this, "PA Halqa Page!", Toast.LENGTH_SHORT).show();
//            Intent intent6 = new Intent(this, PAHalqa.class);
//
//            intent6.putExtra("PAVoterName", voterName);
//            intent6.putExtra("PAVoterCnic", voterCnic);
//            startActivity(intent6);
//        }
//    }
//
////    dialog box when vote is casted
//    public void showCastedVoteDialogBox(String voteType){
//        new AlertDialog.Builder(this)
//                .setTitle("NOTE: VOTE ALREADY CASTED!")
//                .setMessage("Your " + voteType + " is already casted.\n\n You cannot cast vote again.")
////                .setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {
////                    public void onClick(DialogInterface dialog, int which) {
////
////                    }
////                })
//                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                })
//                .setIcon(R.drawable.warningimg) // Replace with your warning icon
//                .show();
//    }
//}
