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

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WeightedExercisePlan3Activity extends AppCompatActivity {
    private CardView cardView1, cardView2, cardView3, cardView4, cardView5;
    private Button startButton,stopButton,resetButton;
    private ImageView back;
    private TextView title;
    private Chronometer timer;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weighted_exercise_plan3);

        back = findViewById(R.id.backButton);
        title = findViewById(R.id.titleTextView);
        cardView1 = findViewById(R.id.weightedExercisePlan3Card1);
        cardView2 = findViewById(R.id.weightedExercisePlan3Card2);
        cardView3 = findViewById(R.id.weightedExercisePlan3Card3);
        cardView4 = findViewById(R.id.weightedExercisePlan3Card4);
        cardView5 = findViewById(R.id.weightedExercisePlan3Card5);
        timer = findViewById(R.id.weightedExercisePlan3Timer);
        startButton = findViewById(R.id.weightedExercisePlan3StartButton);
        stopButton = findViewById(R.id.weightedExercisePlan3StopButton);
        resetButton = findViewById(R.id.weightedExercisePlan3ResetButton);
        title.setText("Weighted Exercises Plan 3");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WeightedExercisePlan3Activity.this, WeightedExerciseDescriptionActivity.class);
                intent.putExtra("type", "dumbbell arnold press");
                startActivity(intent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WeightedExercisePlan3Activity.this, WeightedExerciseDescriptionActivity.class);
                intent.putExtra("type", "dumbbell tricep kickback");
                startActivity(intent);
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WeightedExercisePlan3Activity.this, WeightedExerciseDescriptionActivity.class);
                intent.putExtra("type", "dumbbell front raise");
                startActivity(intent);
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WeightedExercisePlan3Activity.this, WeightedExerciseDescriptionActivity.class);
                intent.putExtra("type", "dumbbell renegade row");
                startActivity(intent);
            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WeightedExercisePlan3Activity.this, WeightedExerciseDescriptionActivity.class);
                intent.putExtra("type", "dumbbell reverse fly");
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