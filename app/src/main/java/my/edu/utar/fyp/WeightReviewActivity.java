package my.edu.utar.fyp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class WeightReviewActivity extends AppCompatActivity {
    private TableLayout tableLayout;
    private FirebaseFirestore fstore;
    private FirebaseAuth fAuth;
    private String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_review);

        tableLayout = findViewById(R.id.tableLayout);
        fstore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();
        userId = fAuth.getCurrentUser().getUid();

        fstore.collection("Weight_tracking").document(userId).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    ArrayList<Double> weightList = (ArrayList<Double>) documentSnapshot.get("weight_list");
                    if (weightList != null) {
                        for (int i = 0; i < weightList.size(); i++) {
                            addRowToTable(i + 1, weightList.get(i));
                        }
                    } else {
                        Toast.makeText(WeightReviewActivity.this,"No weight data available.",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(WeightReviewActivity.this,"Data does not exist.",Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(WeightReviewActivity.this, "Failed to retrieve weight data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addRowToTable(int week, double weight) {
        TableRow row = new TableRow(this);

        TextView weekTextView = new TextView(this);
        weekTextView.setText(String.valueOf(week));
        weekTextView.setBackgroundResource(R.color.white);
        weekTextView.setGravity(android.view.Gravity.CENTER);

        TextView weightTextView = new TextView(this);
        weightTextView.setText(String.valueOf(weight));
        weightTextView.setBackgroundResource(R.color.white);
        weightTextView.setGravity(android.view.Gravity.CENTER);

        row.addView(weekTextView);
        row.addView(weightTextView);

        tableLayout.addView(row);
    }
}