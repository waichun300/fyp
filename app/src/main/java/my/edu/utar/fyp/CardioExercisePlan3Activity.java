package my.edu.utar.fyp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class CardioExercisePlan3Activity extends AppCompatActivity {
    private CardView cardView1, cardView2, cardView3, cardView4, cardView5;
    private Button startButton,stopButton,resetButton;
    private ImageView back;
    private TextView titleView;
    private Chronometer timer;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_exercise_plan3);

        back = findViewById(R.id.backButton);
        titleView = findViewById(R.id.titleTextView);
        cardView1 = findViewById(R.id.CardioExercisePlan3Card1);
        cardView2 = findViewById(R.id.CardioExercisePlan3Card2);
        cardView3 = findViewById(R.id.CardioExercisePlan3Card3);
        cardView4 = findViewById(R.id.CardioExercisePlan3Card4);
        cardView5 = findViewById(R.id.CardioExercisePlan3Card5);
        timer = findViewById(R.id.plan3Timer);
        startButton = findViewById(R.id.cardioPlan3startbutton);
        stopButton = findViewById(R.id.cardioPlan3StopButton);
        resetButton = findViewById(R.id.cardioPlan3ResetButton);
        titleView.setText("Cardio Exercises Plan 3");
        stopButton.setEnabled(false);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardioExercisePlan3Activity.this, CardioExerciseDescriptionActivity.class);
                intent.putExtra("type", "inchworms");
                startActivity(intent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardioExercisePlan3Activity.this, CardioExerciseDescriptionActivity.class);
                intent.putExtra("type", "bicycle crunch");
                startActivity(intent);
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardioExercisePlan3Activity.this, CardioExerciseDescriptionActivity.class);
                intent.putExtra("type", "lateral shuffle");
                startActivity(intent);
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardioExercisePlan3Activity.this, CardioExerciseDescriptionActivity.class);
                intent.putExtra("type", "skater jump");
                startActivity(intent);
            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardioExercisePlan3Activity.this, CardioExerciseDescriptionActivity.class);
                intent.putExtra("type", "jumping lunges");
                startActivity(intent);
            }
        });
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.fitness_bgm);
                mediaPlayer.start();
                mediaPlayer.setLooping(true);
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.stop();
                resetButton.setEnabled(true);
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.setBase(SystemClock.elapsedRealtime());
                timer.setText("00:00");
                startButton.setEnabled(true);
                stopButton.setEnabled(false);
            }
        });
    }
}