package my.edu.utar.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CardioExerciseMainActivity extends AppCompatActivity {
    private CardView cardioPlan1CardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_exercise_main);

        cardioPlan1CardView = findViewById(R.id.cardioPlan1ExerciseCardView);
        cardioPlan1CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CardioExerciseMainActivity.this, CardioExercisePlan1Activity.class));
            }
        });
    }
}