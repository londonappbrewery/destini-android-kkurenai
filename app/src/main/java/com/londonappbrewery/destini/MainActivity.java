package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final private int FIRST_ANSWER = 0;
    final private int SECOND_ANSWER = 1;


    TextView storyTextView;
    Button buttonTop, buttonBottom;
    final Answer[] answers = new Answer[]{
            new Answer(R.string.T1_Ans1,2),
            new Answer(R.string.T1_Ans2,1),
            new Answer(R.string.T2_Ans1,2),
            new Answer(R.string.T2_Ans2,3),
            new Answer(R.string.T3_Ans1,5),
            new Answer(R.string.T3_Ans2,4),
    };
    final Phase[] phases = new Phase[]{
            new Phase(0,new Answer[]{answers[0],answers[1]}, R.string.T1_Story),
            new Phase(1,new Answer[]{answers[2],answers[3]},R.string.T2_Story),
            new Phase(2,new Answer[]{answers[4],answers[5]},R.string.T3_Story),
            new Phase(3,new Answer[]{},R.string.T4_End),
            new Phase(4,new Answer[]{},R.string.T5_End),
            new Phase(5,new Answer[]{},R.string.T6_End)
    };

    int currentPhase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null)
            currentPhase = savedInstanceState.getInt("phase_number");

        storyTextView = findViewById(R.id.storyTextView);
        buttonTop = findViewById(R.id.buttonTop);
        buttonBottom = findViewById(R.id.buttonBottom);

        storyTextView.setText(phases[currentPhase].story_part_id);
        if (phases[currentPhase].answers.length != 0) {
            buttonTop.setText(phases[currentPhase].answers[FIRST_ANSWER].getAnswer_id());
            buttonBottom.setText(phases[currentPhase].answers[SECOND_ANSWER].getAnswer_id());
        }

        buttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStory(FIRST_ANSWER);
            }
        });

        buttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStory(SECOND_ANSWER);
            }
        });

    }

    private void updateStory(int answer){
        currentPhase = phases[currentPhase].answers[answer].getNext_phase();
        storyTextView.setText(phases[currentPhase].story_part_id);
        if (phases[currentPhase].answers.length != 0) {
            buttonTop.setText(phases[currentPhase].answers[FIRST_ANSWER].getAnswer_id());
            buttonBottom.setText(phases[currentPhase].answers[SECOND_ANSWER].getAnswer_id());
        }else {
            buttonTop.setVisibility(View.GONE);
            buttonBottom.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("phase_number", currentPhase);
    }
}
