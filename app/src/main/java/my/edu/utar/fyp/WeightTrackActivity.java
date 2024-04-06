package my.edu.utar.fyp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WeightTrackActivity extends AppCompatActivity {
    private EditText weightEditText;
    private TextView title;
    private Button submitButton;
    private ImageView back;
    private FirebaseFirestore fstore;
    private FirebaseAuth fAuth;
    private String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_track);

        weightEditText = findViewById(R.id.weightEditText);
        submitButton = findViewById(R.id.submitButton);
        back = findViewById(R.id.backButton);
        title = findViewById(R.id.titleTextView);
        fstore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();
        userId = fAuth.getCurrentUser().getUid();

        title.setText("Weight Entry");
        checkWeek();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveWeight();
            }
        });
    }

    private void checkWeek() {
        Calendar currentDate = Calendar.getInstance();
        currentDate.setTime(new Date());
        fstore.collection("Weight_tracking").document(userId).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            Date lastInputDate = documentSnapshot.getDate("date");
                            Calendar lastInputCal = Calendar.getInstance();
                            lastInputCal.setTime(lastInputDate);

                            long diffInMillis = currentDate.getTimeInMillis() - lastInputCal.getTimeInMillis();
                            long diffInDays = TimeUnit.MILLISECONDS.toDays(diffInMillis);

                            if (diffInDays < 7) {
                                Toast.makeText(WeightTrackActivity.this, "You haven't reached the date to input weight yet", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(WeightTrackActivity.this, "Failed to retrieve weight data", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void saveWeight() {
        String weight = weightEditText.getText().toString();

        if (!weight.isEmpty()) {
            double weightValue = Double.parseDouble(weight);
            Map<String, Object> weightEntry = new HashMap<>();
            weightEntry.put("date", new Date());
            fstore.collection("Weight_tracking").document(userId).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()) {
                                ArrayList<Double> weightList = (ArrayList<Double>) documentSnapshot.get("weight_list");
                                weightList.add(weightValue);
                                weightEntry.put("weight_list", weightList);
                                fstore.collection("Weight_tracking").document(userId).update(weightEntry).addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Toast.makeText(WeightTrackActivity.this, "Weight data added successfully", Toast.LENGTH_SHORT).show();
                                                finish();
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(WeightTrackActivity.this, "Failed to add weight data", Toast.LENGTH_SHORT).show();
                                                finish();
                                            }
                                        });
                            } else {
                                ArrayList<Double> weightList = new ArrayList<>();
                                weightList.add(weightValue);
                                weightEntry.put("weight_list", weightList);
                                fstore.collection("Weight_tracking").document(userId).set(weightEntry).addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Toast.makeText(WeightTrackActivity.this, "Weight data added successfully", Toast.LENGTH_SHORT).show();
                                                weightEditText.setEnabled(true);
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(WeightTrackActivity.this, "Failed to add weight data", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                            }
                        }
                    });
        } else {
            weightEditText.setError("Please enter weight");
        }
    }

}