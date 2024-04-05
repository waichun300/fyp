package my.edu.utar.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class WeightedExerciseMainActivity extends AppCompatActivity {
    private CardView weightedExercisePlan1;
    private ImageView back;
    private TextView titleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weighted_exercise_main);

        back = findViewById(R.id.backButton);
        titleView = findViewById(R.id.titleTextView);
        weightedExercisePlan1 = findViewById(R.id.weightedPlan1ExerciseCardView);
        titleView.setText("Weighted Exercise Workout Plans");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        weightedExercisePlan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WeightedExerciseMainActivity.this, WeightedExercisePlan1Activity.class));
            }
        });
    }
}