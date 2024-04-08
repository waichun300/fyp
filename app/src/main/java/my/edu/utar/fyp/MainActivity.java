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

public class MainActivity extends AppCompatActivity {
    private CardView cardioCardView,yogaCardView,weightedExerciseCardView,weightCardView,nutritionDietCardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardioCardView = findViewById(R.id.cardioExerciseCardView);
        yogaCardView = findViewById(R.id.yogaExerciseCardView);
        weightedExerciseCardView = findViewById(R.id.weightedExerciseCardView);
        weightCardView = findViewById(R.id.weightCardView);
        nutritionDietCardView = findViewById(R.id.nutritionCardView);
        cardioCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CardioExerciseMainActivity.class));
            }
        });
        yogaCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,YogaMainActivity.class));
            }
        });
        weightedExerciseCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,WeightedExerciseMainActivity.class));
            }
        });
        weightCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,WeightMainActivity.class));
            }
        });
        nutritionDietCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,NutritionActivity.class));
            }
        });
    }
}