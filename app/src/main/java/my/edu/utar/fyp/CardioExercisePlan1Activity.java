package my.edu.utar.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CardioExercisePlan1Activity extends AppCompatActivity {
    private ImageView pushUpImageView,jumpRopeImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_exercise_plan1);
        pushUpImageView = findViewById(R.id.PushUpImageView);
        jumpRopeImageView = findViewById(R.id.JumpRopeImageView);
        pushUpImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardioExercisePlan1Activity.this, CardioExerciseDescriptionActivity.class);
                intent.putExtra("type", "push up");
                startActivity(intent);
            }
        });

        jumpRopeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardioExercisePlan1Activity.this, CardioExerciseDescriptionActivity.class);
                intent.putExtra("type", "jump rope");
                startActivity(intent);
            }
        });
    }
}