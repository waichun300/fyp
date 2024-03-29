package my.edu.utar.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class WeightedExercisePlan1Activity extends AppCompatActivity {
    private CardView cardView1, cardView2, cardView3, cardView4, cardView5;
    private Button startButton,stopButton,resetButton;
    private Chronometer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weighted_exercise_plan1);

        cardView1 = findViewById(R.id.weightedExerciseCard1);
        cardView2 = findViewById(R.id.weightedExerciseCard2);
        cardView3 = findViewById(R.id.weightedExerciseCard3);
        cardView4 = findViewById(R.id.weightedExerciseCard4);
        cardView5 = findViewById(R.id.weightedExerciseCard5);
        timer = findViewById(R.id.weightedExercisePlan1Timer);
        startButton = findViewById(R.id.weightedExercisePlan1Startbutton);
        stopButton = findViewById(R.id.weightedExercisePlan1StopButton);
        resetButton = findViewById(R.id.weightedExercisePlan1ResetButton);

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WeightedExercisePlan1Activity.this, WeightedExerciseDescriptionActivity.class);
                intent.putExtra("type", "dumbbell squat");
                startActivity(intent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WeightedExercisePlan1Activity.this, WeightedExerciseDescriptionActivity.class);
                intent.putExtra("type", "dumbbell lunges");
                startActivity(intent);
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WeightedExercisePlan1Activity.this, WeightedExerciseDescriptionActivity.class);
                intent.putExtra("type", "dumbbell shoulder press");
                startActivity(intent);
            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WeightedExercisePlan1Activity.this, WeightedExerciseDescriptionActivity.class);
                intent.putExtra("type", "dumbbell bent over rows");
                startActivity(intent);
            }
        });

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WeightedExercisePlan1Activity.this, WeightedExerciseDescriptionActivity.class);
                intent.putExtra("type", "dumbbell deadlift");
                startActivity(intent);
            }
        });
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.start();
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.stop();
                resetButton.setEnabled(true);
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.setText("00:00");
                startButton.setEnabled(true);
                stopButton.setEnabled(false);
            }
        });
    }
}