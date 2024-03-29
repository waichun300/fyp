package my.edu.utar.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class WeightedExerciseMainActivity extends AppCompatActivity {
    private CardView weightedExercisePlan1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weighted_exercise_main);
        weightedExercisePlan1 = findViewById(R.id.weightedPlan1ExerciseCardView);
        weightedExercisePlan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WeightedExerciseMainActivity.this, WeightedExercisePlan1Activity.class));
            }
        });
    }
}