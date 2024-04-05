package my.edu.utar.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CardioExerciseMainActivity extends AppCompatActivity {
    private CardView cardioPlan1CardView,cardioPlan2CardView;
    private ImageView back;
    private TextView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_exercise_main);

        back = findViewById(R.id.backButton);
        titleView = findViewById(R.id.titleTextView);
        cardioPlan1CardView = findViewById(R.id.cardioPlan1ExerciseCardView);
        cardioPlan2CardView = findViewById(R.id.cardioPlan2ExerciseCardView);
        titleView.setText("Cardio Exercise Workout Plans");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        cardioPlan1CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CardioExerciseMainActivity.this, CardioExercisePlan1Activity.class));
            }
        });
        cardioPlan2CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CardioExerciseMainActivity.this, CardioExercisePlan2Activity.class));
            }
        });
    }
}