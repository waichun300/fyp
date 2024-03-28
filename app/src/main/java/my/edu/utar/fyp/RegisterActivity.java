package my.edu.utar.fyp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private EditText registerUserName, registerEmail, registerPassword, registerAge;
    private Button registerButton;
    private RadioButton rb1,rb2;
    private String fitnessGoal="";
    private FirebaseAuth fAuth;
    private FirebaseFirestore fstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerUserName = findViewById(R.id.registerUserName);
        registerUserName = findViewById(R.id.registerUserName);
        registerEmail = findViewById(R.id.registerEmail);
        registerPassword = findViewById(R.id.registerPassword);
        registerButton = findViewById(R.id.registerButton);
        registerAge = findViewById(R.id.registerAge);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        Drawable userIcon = getResources().getDrawable(R.drawable.user_icon);
        Drawable ageIcon = getResources().getDrawable(R.drawable.age_icon);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) userIcon;
        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) ageIcon;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        Bitmap bitmap2 = bitmapDrawable2.getBitmap();

        int desiredWidth = 60;
        int desiredHeight = 60;

        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, desiredWidth, desiredHeight, true);
        Bitmap resizedBitmap2 = Bitmap.createScaledBitmap(bitmap2, desiredWidth, desiredHeight, true);
        Drawable resizedUserIcon = new BitmapDrawable(getResources(), resizedBitmap);
        Drawable resizedAgeIcon = new BitmapDrawable(getResources(), resizedBitmap2);

        registerUserName.setCompoundDrawablesWithIntrinsicBounds(resizedUserIcon, null, null, null);
        registerAge.setCompoundDrawablesWithIntrinsicBounds(resizedAgeIcon, null, null, null);

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

    private void registration() {
        String userName = registerUserName.getText().toString();
        String email = registerEmail.getText().toString();
        String password = registerPassword.getText().toString();
        String ageText = registerAge.getText().toString();
        if (userName.isEmpty()) {
            registerUserName.setError("Please Enter Username");
        } else if (email.isEmpty()) {
            registerEmail.setError("Please Enter Email");
        } else if (password.isEmpty()) {
            registerPassword.setError("Please Enter Password");
        } else if (ageText.isEmpty()) {
            registerAge.setError("Please Enter Age");
        } else {
            int age = Integer.parseInt(ageText);
            fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        String userId = fAuth.getCurrentUser().getUid();
                        Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        DocumentReference documentReference = fstore.collection("Users").document(userId);
                        Map<String, Object> user = new HashMap<>();
                        user.put("username", userName);
                        user.put("email", email);
                        user.put("age", age);
                        user.put("fitness goal", fitnessGoal);
                        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                finish();
                            }
                        });
                    } else {
                        Toast.makeText(RegisterActivity.this, "Registration failed" + task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}