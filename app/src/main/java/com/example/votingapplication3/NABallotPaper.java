package com.example.votingapplication3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NABallotPaper extends AppCompatActivity {

    // Declare all UI components
    private TextView textView2NABPName, textView3NABPCnic, textView3NABPHalqa;
    private ImageView imageView1ECP;

    // Arrays to hold all the symbol components
    private ImageView[] symbolImages = new ImageView[10];
    private TextView[] memberTextViews = new TextView[10];
    private Button[] voteButtons = new Button[10];

    boolean isNaVoteCasted = false;

    // Symbol names
    private final String[] symbolNames = {
            "Bat", "Sher", "Arrow", "Kite", "Book",
            "Lantern", "Tree", "Axe", "Cycle", "Eagle"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.na_ballot_paper); // Replace with your XML layout name

        // Initialize user info views
        textView2NABPName = findViewById(R.id.textView2NABPName);
        textView3NABPCnic = findViewById(R.id.textView3NABPCnic);
        textView3NABPHalqa = findViewById(R.id.textView3NABPHalqa);
        imageView1ECP = findViewById(R.id.imageView1ECP);

        // Set sample user data (replace with actual data from intent/extras)
        String NAVoterName = getIntent().getStringExtra("NAVoterName");
        String NAVoterCnic = getIntent().getStringExtra("NAVoterCnic");
        String NAHAlqaNo = getIntent().getStringExtra("NAHalqaNumber");

//        HomePage homePage = new HomePage();
//
//        String voterName = homePage.voterName;
//        String voterCnic = homePage.voterCnic;

        textView2NABPName.setText(NAVoterName);
        textView3NABPCnic.setText(NAVoterCnic);
        textView3NABPHalqa.setText(NAHAlqaNo);

        // Initialize all symbol views and buttons
        initializeSymbolViews();

        // Set click listeners for all vote buttons
        for (int i = 0; i < voteButtons.length; i++) {
            final int index = i;
            voteButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showConfirmationDialog(symbolNames[index]);
                }
            });
        }
    }

    private void initializeSymbolViews() {
        // Initialize image views
        symbolImages[0] = findViewById(R.id.imageView1NABPBat);
        symbolImages[1] = findViewById(R.id.imageView2NABPSher);
        symbolImages[2] = findViewById(R.id.imageView3NABPArrow);
        symbolImages[3] = findViewById(R.id.imageView4NABPKite);
        symbolImages[4] = findViewById(R.id.imageView5NABPBook);
        symbolImages[5] = findViewById(R.id.imageView6NABPLantern);
        symbolImages[6] = findViewById(R.id.imageView7NABPTree);
        symbolImages[7] = findViewById(R.id.imageView8NABPAxe);
        symbolImages[8] = findViewById(R.id.imageView9NABPCycle);
        symbolImages[9] = findViewById(R.id.imageView10NABPEagle);

        // Initialize member text views
        memberTextViews[0] = findViewById(R.id.textView1NABPBat);
        memberTextViews[1] = findViewById(R.id.textView2NABPSher);
        memberTextViews[2] = findViewById(R.id.textView3NABPArrow);
        memberTextViews[3] = findViewById(R.id.textView4NABPKite);
        memberTextViews[4] = findViewById(R.id.textView5NABPBook);
        memberTextViews[5] = findViewById(R.id.textView6NABPLantern);
        memberTextViews[6] = findViewById(R.id.textView7NABPTree);
        memberTextViews[7] = findViewById(R.id.textView8NABPAxe);
        memberTextViews[8] = findViewById(R.id.textView9NABPCycle);
        memberTextViews[9] = findViewById(R.id.textView10NABPEagle);

        // Initialize vote buttons
        voteButtons[0] = findViewById(R.id.buttonNABPBat);
        voteButtons[1] = findViewById(R.id.buttonNABPSher);
        voteButtons[2] = findViewById(R.id.buttonNABPArrow);
        voteButtons[3] = findViewById(R.id.buttonNABPKite);
        voteButtons[4] = findViewById(R.id.buttonNABPBook);
        voteButtons[5] = findViewById(R.id.buttonNABPLantern);
        voteButtons[6] = findViewById(R.id.buttonNABPTree);
        voteButtons[7] = findViewById(R.id.buttonNABPAxe);
        voteButtons[8] = findViewById(R.id.buttonNABPCycle);
        voteButtons[9] = findViewById(R.id.buttonNABPEagle);

        // Set member names (replace with actual candidate names)
        for (int i = 0; i < memberTextViews.length; i++) {
            memberTextViews[i].setText("MEMBER: Candidate " + (i + 1));
        }
    }

    private void showConfirmationDialog(final String symbolName) {
        new AlertDialog.Builder(this)
                .setTitle("Confirm Your Vote")
                .setMessage("You are about to vote for " + symbolName + " symbol.\n\nThis action cannot be undone.")
                .setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        castVote(symbolName);
                        showVoteSuccessDialog(symbolName);
                        isNaVoteCasted = true;
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(R.drawable.warningimg) // Replace with your warning icon
                .show();
    }

    private void castVote(String symbolName) {
        // Implement your actual vote casting logic here
        // This could include:
        // 1. Saving to SharedPreferences
        // 2. Sending to a database
        // 3. Making an API call to your server

        // For now, we'll just simulate it
        // SharedPreferences preferences = getSharedPreferences("VotingSystem", MODE_PRIVATE);
        // preferences.edit().putString("selectedSymbol", symbolName).apply();
    }

    private void showVoteSuccessDialog(String symbolName) {
        new AlertDialog.Builder(this)
                .setTitle("Vote Cast Successfully")
                .setMessage("Your vote for " + symbolName + " has been recorded.\n\nThank you for voting!")
                .setPositiveButton("RETURN TO HOME", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        returnToHomePage();
                    }
                })
                .setIcon(R.drawable.baseline_check_24) // Replace with your success icon
                .setCancelable(false)
                .show();
    }

    private void returnToHomePage() {

// When voting is complete in PABallotPaper:
        VoterSession.getInstance().setNaVoteCasted(true);

        Intent returnIntent = new Intent(this, HomePage.class);
        returnIntent.putExtra("NaVoteStatus", true);
        startActivity(returnIntent);
        finish();

//        Intent intent = new Intent(this, HomePage.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
////        intent.putExtra("NaVoteStatus", isNaVoteCasted);
//        intent.putExtra("NaVoteStatus", true);
//        startActivity(intent);
//        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        new AlertDialog.Builder(this)
                .setTitle("Exit Voting")
                .setMessage("Are you sure you want to exit without voting?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        NABallotPaper.super.onBackPressed();
                    }
                })
                .setNegativeButton("NO", null)
                .show();
    }
}