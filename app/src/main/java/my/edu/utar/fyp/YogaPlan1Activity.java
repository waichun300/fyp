package my.edu.utar.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class YogaPlan1Activity extends AppCompatActivity {
    private CardView cardView1, cardView2, cardView3, cardView4, cardView5;
    private Button startButton,stopButton,resetButton;
    private Chronometer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_plan1);

        cardView1 = findViewById(R.id.YogaExerciseCard1);
        cardView2 = findViewById(R.id.YogaExerciseCard2);
        cardView3 = findViewById(R.id.YogaExerciseCard3);
        cardView4 = findViewById(R.id.YogaExerciseCard4);
        cardView5 = findViewById(R.id.YogaExerciseCard5);
        timer = findViewById(R.id.yogaPlan1Timer);
        startButton = findViewById(R.id.yogaPlan1StartButton);
        stopButton = findViewById(R.id.yogaPlan1StopButton);
        resetButton = findViewById(R.id.yogaPlan1ResetButton);

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YogaPlan1Activity.this, YogaDescriptionActivity.class);
                intent.putExtra("type", "utkatasana");
                startActivity(intent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YogaPlan1Activity.this, YogaDescriptionActivity.class);
                intent.putExtra("type", "virabhadrasana");
                startActivity(intent);
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YogaPlan1Activity.this, YogaDescriptionActivity.class);
                intent.putExtra("type", "navasana");
                startActivity(intent);
            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YogaPlan1Activity.this, YogaDescriptionActivity.class);
                intent.putExtra("type", "phalakasana");
                startActivity(intent);
            }
        });

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YogaPlan1Activity.this, YogaDescriptionActivity.class);
                intent.putExtra("type", "surya namaskar");
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