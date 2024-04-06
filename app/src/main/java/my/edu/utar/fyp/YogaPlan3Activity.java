package my.edu.utar.fyp;

import android.content.Intent;
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

public class YogaPlan3Activity extends AppCompatActivity {
    private CardView cardView1, cardView2, cardView3, cardView4, cardView5;
    private ImageView back;
    private TextView titleView;
    private Button startButton,stopButton,resetButton;
    private Chronometer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_plan3);

        cardView1 = findViewById(R.id.YogaExercisePlan3Card1);
        cardView2 = findViewById(R.id.YogaExercisePlan3Card2);
        cardView3 = findViewById(R.id.YogaExercisePlan3Card3);
        cardView4 = findViewById(R.id.YogaExercisePlan3Card4);
        cardView5 = findViewById(R.id.YogaExercisePlan3Card5);
        titleView = findViewById(R.id.titleTextView);
        back = findViewById(R.id.backButton);
        timer = findViewById(R.id.yogaPlan3Timer);
        startButton = findViewById(R.id.yogaPlan3StartButton);
        stopButton = findViewById(R.id.yogaPlan3StopButton);
        resetButton = findViewById(R.id.yogaPlan3ResetButton);
        titleView.setText("Yoga Exercise Plan 3");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YogaPlan3Activity.this, YogaDescriptionActivity.class);
                intent.putExtra("type", "natarajasana");
                startActivity(intent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YogaPlan3Activity.this, YogaDescriptionActivity.class);
                intent.putExtra("type", "chakravakasana");
                startActivity(intent);
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YogaPlan3Activity.this, YogaDescriptionActivity.class);
                intent.putExtra("type", "vasisthasana");
                startActivity(intent);
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YogaPlan3Activity.this, YogaDescriptionActivity.class);
                intent.putExtra("type", "ardha chandrasana");
                startActivity(intent);
            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YogaPlan3Activity.this, YogaDescriptionActivity.class);
                intent.putExtra("type", "mandukasana");
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