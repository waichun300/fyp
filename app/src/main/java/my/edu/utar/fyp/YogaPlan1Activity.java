package my.edu.utar.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class YogaPlan1Activity extends AppCompatActivity {
    private ImageView suryaNamaskarImageView,virabhadrasanaImageView,utkatasanaImageView,navasanaImageView,phalakasanaImageView;
    private Button startButton,stopButton,resetButton;
    private Chronometer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_plan1);

        suryaNamaskarImageView = findViewById(R.id.SuryaNamaskarImageView);
        virabhadrasanaImageView = findViewById(R.id.VirabhadrasanaImageView);
        utkatasanaImageView = findViewById(R.id.UtkatasanaImageView);
        navasanaImageView = findViewById(R.id.NavasanaImageView);
        phalakasanaImageView = findViewById(R.id.PhalakasanaImageView);
        timer = findViewById(R.id.yogaPlan1Timer);
        startButton = findViewById(R.id.yogaPlan1StartButton);
        stopButton = findViewById(R.id.yogaPlan1StopButton);
        resetButton = findViewById(R.id.yogaPlan1ResetButton);

        utkatasanaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YogaPlan1Activity.this, YogaDescriptionActivity.class);
                intent.putExtra("type", "utkatasana");
                startActivity(intent);
            }
        });
        virabhadrasanaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YogaPlan1Activity.this, YogaDescriptionActivity.class);
                intent.putExtra("type", "virabhadrasana");
                startActivity(intent);
            }
        });

        navasanaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YogaPlan1Activity.this, YogaDescriptionActivity.class);
                intent.putExtra("type", "navasana");
                startActivity(intent);
            }
        });
        phalakasanaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YogaPlan1Activity.this, YogaDescriptionActivity.class);
                intent.putExtra("type", "phalakasana");
                startActivity(intent);
            }
        });

        suryaNamaskarImageView.setOnClickListener(new View.OnClickListener() {
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