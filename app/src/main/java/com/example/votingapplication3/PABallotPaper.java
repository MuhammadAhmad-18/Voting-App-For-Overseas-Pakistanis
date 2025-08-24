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

public class PABallotPaper extends AppCompatActivity {

    // Declare all UI components
    private TextView textView2PABPName, textView3PABPCnic, textView3PABPHalqa;
    private ImageView imageView1ECP;

    // Arrays to hold all the symbol components
    private ImageView[] symbolImages = new ImageView[10];
    private TextView[] memberTextViews = new TextView[10];
    private Button[] voteButtons = new Button[10];

    boolean isPaVoteCasted = false;

    // Symbol names
    private final String[] symbolNames = {
            "Bat", "Sher", "Arrow", "Kite", "Book",
            "Lantern", "Tree", "Axe", "Cycle", "Eagle"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pa_ballot_paper); // Replace with your XML layout name

        // Initialize user info views
        textView2PABPName = findViewById(R.id.textView2PABPName);
        textView3PABPCnic = findViewById(R.id.textView3PABPCnic);
        textView3PABPHalqa = findViewById(R.id.textView3PABPHalqa);
        imageView1ECP = findViewById(R.id.imageView1ECP);

        // Set sample user data (replace with actual data from intent/extras)
        String PAVoterName = getIntent().getStringExtra("PAVoterName");
        String PAVoterCnic = getIntent().getStringExtra("PAVoterCnic");
        String PAHAlqaNo = getIntent().getStringExtra("PAHalqaNumber");

//        HomePage homePage = new HomePage();
//
//        String voterName = homePage.voterName;
//        String voterCnic = homePage.voterCnic;

        textView2PABPName.setText(PAVoterName);
        textView3PABPCnic.setText(PAVoterCnic);
        textView3PABPHalqa.setText(PAHAlqaNo);

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
        symbolImages[0] = findViewById(R.id.imageView1PABPBat);
        symbolImages[1] = findViewById(R.id.imageView2PABPSher);
        symbolImages[2] = findViewById(R.id.imageView3PABPArrow);
        symbolImages[3] = findViewById(R.id.imageView4PABPKite);
        symbolImages[4] = findViewById(R.id.imageView5PABPBook);
        symbolImages[5] = findViewById(R.id.imageView6PABPLantern);
        symbolImages[6] = findViewById(R.id.imageView7PABPTree);
        symbolImages[7] = findViewById(R.id.imageView8PABPAxe);
        symbolImages[8] = findViewById(R.id.imageView9PABPCycle);
        symbolImages[9] = findViewById(R.id.imageView10PABPEagle);

        // Initialize member text views
        memberTextViews[0] = findViewById(R.id.textView1PABPBat);
        memberTextViews[1] = findViewById(R.id.textView2PABPSher);
        memberTextViews[2] = findViewById(R.id.textView3PABPArrow);
        memberTextViews[3] = findViewById(R.id.textView4PABPKite);
        memberTextViews[4] = findViewById(R.id.textView5PABPBook);
        memberTextViews[5] = findViewById(R.id.textView6PABPLantern);
        memberTextViews[6] = findViewById(R.id.textView7PABPTree);
        memberTextViews[7] = findViewById(R.id.textView8PABPAxe);
        memberTextViews[8] = findViewById(R.id.textView9PABPCycle);
        memberTextViews[9] = findViewById(R.id.textView10PABPEagle);

        // Initialize vote buttons
        voteButtons[0] = findViewById(R.id.buttonPABPBat);
        voteButtons[1] = findViewById(R.id.buttonPABPSher);
        voteButtons[2] = findViewById(R.id.buttonPABPArrow);
        voteButtons[3] = findViewById(R.id.buttonPABPKite);
        voteButtons[4] = findViewById(R.id.buttonPABPBook);
        voteButtons[5] = findViewById(R.id.buttonPABPLantern);
        voteButtons[6] = findViewById(R.id.buttonPABPTree);
        voteButtons[7] = findViewById(R.id.buttonPABPAxe);
        voteButtons[8] = findViewById(R.id.buttonPABPCycle);
        voteButtons[9] = findViewById(R.id.buttonPABPEagle);

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
                        isPaVoteCasted = true;
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
        VoterSession.getInstance().setPaVoteCasted(true);

        Intent returnIntent = new Intent(this, HomePage.class);
        returnIntent.putExtra("PaVoteStatus", true);
        startActivity(returnIntent);
        finish();

//        Intent intent = new Intent(this, HomePage.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
////        intent.putExtra("NaVoteStatus", isNaVoteCasted);
//        intent.putExtra("PaVoteStatus", true);
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
                        PABallotPaper.super.onBackPressed();
                    }
                })
                .setNegativeButton("NO", null)
                .show();
    }
}