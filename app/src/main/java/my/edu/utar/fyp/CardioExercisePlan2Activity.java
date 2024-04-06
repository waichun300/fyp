package my.edu.utar.fyp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
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

public class CardioExercisePlan2Activity extends AppCompatActivity {
    private CardView cardView1, cardView2, cardView3, cardView4, cardView5;
    private Button startButton,stopButton,resetButton;
    private ImageView back;
    private TextView titleView;
    private Chronometer timer;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_exercise_plan2);

        back = findViewById(R.id.backButton);
        titleView = findViewById(R.id.titleTextView);
        cardView1 = findViewById(R.id.CardioExercisePlan2Card1);
        cardView2 = findViewById(R.id.CardioExercisePlan2Card2);
        cardView3 = findViewById(R.id.CardioExercisePlan2Card3);
        cardView4 = findViewById(R.id.CardioExercisePlan2Card4);
        cardView5 = findViewById(R.id.CardioExercisePlan2Card5);
        timer = findViewById(R.id.plan2Timer);
        startButton = findViewById(R.id.cardioPlan2startbutton);
        stopButton = findViewById(R.id.cardioPlan2StopButton);
        resetButton = findViewById(R.id.cardioPlan2ResetButton);
        titleView.setText("Cardio Exercises Plan 2");
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
                Intent intent = new Intent(CardioExercisePlan2Activity.this, CardioExerciseDescriptionActivity.class);
                intent.putExtra("type", "jumping jack");
                startActivity(intent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardioExercisePlan2Activity.this, CardioExerciseDescriptionActivity.class);
                intent.putExtra("type", "high knee");
                startActivity(intent);
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardioExercisePlan2Activity.this, CardioExerciseDescriptionActivity.class);
                intent.putExtra("type", "mountain climber");
                startActivity(intent);
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardioExercisePlan2Activity.this, CardioExerciseDescriptionActivity.class);
                intent.putExtra("type", "crunches");
                startActivity(intent);
            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardioExercisePlan2Activity.this, CardioExerciseDescriptionActivity.class);
                intent.putExtra("type", "butt kick");
                startActivity(intent);
            }
        });
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                timer.setText("00:00");
                startButton.setEnabled(true);
                stopButton.setEnabled(false);
            }
        });
    }
}