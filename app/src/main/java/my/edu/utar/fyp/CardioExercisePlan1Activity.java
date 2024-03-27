package my.edu.utar.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CardioExercisePlan1Activity extends AppCompatActivity {
    private ImageView runningImageView,pushUpImageView,jumpRopeImageView,squatJumpImageView,burpeeImageView;
    private Button startButton,stopButton,resetButton;
    private Chronometer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_exercise_plan1);

        runningImageView = findViewById(R.id.RunningImageView);
        pushUpImageView = findViewById(R.id.PushUpImageView);
        jumpRopeImageView = findViewById(R.id.JumpRopeImageView);
        squatJumpImageView = findViewById(R.id.SquatJumpImageView);
        burpeeImageView = findViewById(R.id.BurpeeImageView);
        timer = findViewById(R.id.plan1Timer);
        startButton = findViewById(R.id.plan1startbutton);
        stopButton = findViewById(R.id.plan1StopButton);
        resetButton = findViewById(R.id.plan1ResetButton);

        stopButton.setEnabled(false);
        runningImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardioExercisePlan1Activity.this, CardioExerciseDescriptionActivity.class);
                intent.putExtra("type", "running");
                startActivity(intent);
            }
        });

        pushUpImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardioExercisePlan1Activity.this, CardioExerciseDescriptionActivity.class);
                intent.putExtra("type", "push up");
                startActivity(intent);
            }
        });
        jumpRopeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardioExercisePlan1Activity.this, CardioExerciseDescriptionActivity.class);
                intent.putExtra("type", "jump rope");
                startActivity(intent);
            }
        });
        squatJumpImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardioExercisePlan1Activity.this, CardioExerciseDescriptionActivity.class);
                intent.putExtra("type", "squat jump");
                startActivity(intent);
            }
        });
        burpeeImageView.setOnClickListener(new View.OnClickListener() {
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