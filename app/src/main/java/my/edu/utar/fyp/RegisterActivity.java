package my.edu.utar.fyp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private EditText registerUserName, registerEmail, registerPassword;
    private TextView dateOfBirth;
    private Button registerButton, dateOfBirthButton;
    private RadioButton rb1, rb2;
    private String emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
    private String fitnessGoal = "";
    private FirebaseAuth fAuth;
    private FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerUserName = findViewById(R.id.registerUserName);
        registerEmail = findViewById(R.id.registerEmail);
        registerPassword = findViewById(R.id.registerPassword);
        dateOfBirth = findViewById(R.id.dateOfBirthTextView);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        dateOfBirthButton = findViewById(R.id.dateOfBirthPickerButton);
        registerButton = findViewById(R.id.registerButton);

        Drawable userIcon = getResources().getDrawable(R.drawable.user_icon);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) userIcon;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        int desiredWidth = 60;
        int desiredHeight = 60;
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, desiredWidth, desiredHeight, true);
        Drawable resizedUserIcon = new BitmapDrawable(getResources(), resizedBitmap);
        registerUserName.setCompoundDrawablesWithIntrinsicBounds(resizedUserIcon, null, null, null);

        dateOfBirthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fitnessGoal = rb1.getText().toString();
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fitnessGoal = rb2.getText().toString();
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registration();
            }
        });
    }

    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                dateOfBirth.setText(selectedDate);
            }
        }, year, month, dayOfMonth);
        datePickerDialog.show();
    }

    private void registration() {
        String userName = registerUserName.getText().toString();
        String email = registerEmail.getText().toString();
        String password = registerPassword.getText().toString();
        String dateOfBirthday = dateOfBirth.getText().toString();
        if (userName.isEmpty()) {
            registerUserName.setError("Please Enter Username");
        } else if (!email.matches(emailPattern)) {
            registerEmail.setError("Please Enter Valid Email");
        } else if (password.isEmpty() || password.length() < 6) {
            registerPassword.setError("Please Enter Valid Password");
        } else if (dateOfBirthday.isEmpty()) {
            dateOfBirth.setError("Please Enter Date of Birth");
        } else {
            fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        String userId = fAuth.getCurrentUser().getUid();
                        Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        DocumentReference documentReference = fStore.collection("Users").document(userId);
                        Map<String, Object> user = new HashMap<>();
                        user.put("username", userName);
                        user.put("email", email);
                        user.put("date of birth", dateOfBirthday);
                        user.put("fitness goal", fitnessGoal);
                        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                Toast.makeText(RegisterActivity.this, "Registration Successfully. Please Login." + task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        Toast.makeText(RegisterActivity.this, "Registration Failed.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}