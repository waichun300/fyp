package my.edu.utar.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class CardioExercisePlan1Activity extends AppCompatActivity {
    private CardView cardView1, cardView2, cardView3, cardView4, cardView5;
    private Button startButton,stopButton,resetButton;
    private Chronometer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_exercise_plan1);

        cardView1 = findViewById(R.id.CardioExerciseCard1);
        cardView2 = findViewById(R.id.CardioExerciseCard2);
        cardView3 = findViewById(R.id.CardioExerciseCard3);
        cardView4 = findViewById(R.id.CardioExerciseCard4);
        cardView5 = findViewById(R.id.CardioExerciseCard5);
        timer = findViewById(R.id.plan1Timer);
        startButton = findViewById(R.id.cardioPlan1startbutton);
        stopButton = findViewById(R.id.cardioPlan1StopButton);
        resetButton = findViewById(R.id.cardioPlan1ResetButton);

        stopButton.setEnabled(false);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardioExercisePlan1Activity.this, CardioExerciseDescriptionActivity.class);
                intent.putExtra("type", "running");
                startActivity(intent);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardioExercisePlan1Activity.this, CardioExerciseDescriptionActivity.class);
                intent.putExtra("type", "push up");
                startActivity(intent);
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardioExercisePlan1Activity.this, CardioExerciseDescriptionActivity.class);
                intent.putExtra("type", "jump rope");
                startActivity(intent);
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardioExercisePlan1Activity.this, CardioExerciseDescriptionActivity.class);
                intent.putExtra("type", "squat jump");
                startActivity(intent);
            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardioExercisePlan1Activity.this, CardioExerciseDescriptionActivity.class);
                intent.putExtra("type", "burpee");
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