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

public class WeightMainActivity extends AppCompatActivity {
    private CardView weightEntryCardView, weightReviewCardView;
    private ImageView back;
    private TextView titleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_main);

        back = findViewById(R.id.backButton);
        titleView = findViewById(R.id.titleTextView);
        weightEntryCardView = findViewById(R.id.weightEntryCardView);
        weightReviewCardView = findViewById(R.id.weightReviewCardView);
        titleView.setText("Body Weight Tracking");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
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