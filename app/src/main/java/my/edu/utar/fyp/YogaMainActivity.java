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

public class YogaMainActivity extends AppCompatActivity {
    private CardView yogaPlan1CardView;
    private ImageView back;
    private TextView titleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_main);

        back = findViewById(R.id.backButton);
        titleView = findViewById(R.id.titleTextView);
        yogaPlan1CardView = findViewById(R.id.yogaPlan1ExerciseCardView);
        titleView.setText("Yoga Exercise Workout Plans");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        yogaPlan1CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(YogaMainActivity.this,YogaPlan1Activity.class));
            }
        });
    }
}