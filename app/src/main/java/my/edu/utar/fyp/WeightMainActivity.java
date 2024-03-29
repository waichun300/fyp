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

public class WeightMainActivity extends AppCompatActivity {
    private CardView weightEntryCardView, weightReviewCardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_main);

        weightEntryCardView = findViewById(R.id.weightEntryCardView);
        weightReviewCardView = findViewById(R.id.weightReviewCardView);
        weightEntryCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WeightMainActivity.this,WeightTrackActivity.class));
            }
        });
        weightReviewCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WeightMainActivity.this,WeightReviewActivity.class));
            }
        });
    }
}