package my.edu.utar.fyp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private EditText registerEmail,registerPassword,registerAge;
    private Button registerButton;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerEmail = findViewById(R.id.registerEmail);
        registerPassword = findViewById(R.id.registerPassword);
        registerButton = findViewById(R.id.registerButton);
        registerAge = findViewById(R.id.registerAge);
        progressDialog = new ProgressDialog(this);
        mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        Drawable drawable = getResources().getDrawable(R.drawable.age_icon);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap bitmap = bitmapDrawable.getBitmap();

        int desiredWidth = 100;
        int desiredHeight = 100;

        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, desiredWidth, desiredHeight, true);

        Drawable resizedDrawable = new BitmapDrawable(getResources(), resizedBitmap);

        registerAge.setCompoundDrawablesWithIntrinsicBounds(resizedDrawable, null, null, null);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registration();
            }
        });
    }

    private void registration() {
        String email = registerEmail.getText().toString();
        String password = registerPassword.getText().toString();
        int age = Integer.parseInt(registerAge.getText().toString());
        if(email.isEmpty())
        {
            registerEmail.setError("Enter Valid Email");
        }
        else if(password.isEmpty())
        {
            registerPassword.setError("Enter Valid Password");
        }
        else
        {
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        saveUserDetail(age);
                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void saveUserDetail(int age) {
        String userId = mAuth.getCurrentUser().getUid();

        DatabaseReference usersRef = FirebaseDatabase.getInstance("https://finalyearproject-ab7cc-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Users");

        usersRef.child("age").setValue(age)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()) {
                            nextActivity();
                            Toast.makeText(RegisterActivity.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(RegisterActivity.this,"Failed to register",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void nextActivity() {
        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}