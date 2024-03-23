package my.edu.utar.fyp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CardioExerciseDescriptionActivity extends AppCompatActivity {

    private VideoView videoView;
    private TextView titleView;
    private TextView descriptionView;
    private String video_path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_exercise_description);

        videoView = findViewById(R.id.CardioExerciseVideoView);
        titleView = findViewById(R.id.CardioExerciseTitle);
        descriptionView = findViewById(R.id.CardioExerciseDescription);
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");

        if (type.equals("push up")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.push_up;
            Uri surya_namaskar_uri = Uri.parse(video_path);
            videoView.setVideoURI(surya_namaskar_uri);
            videoView.start();
            titleView.setText("Push Up");
            descriptionView.setText("Start in a plank position with your hands shoulder-width apart and palms flat on the floor, making sure your wrists are aligned with your shoulders."
                    + "\nBend your elbows close to your sides, then lower your body toward the floor by lowering your chest until it's almost touching the ground."
                    + "\nPush your arms through your palms to extend and return to the starting position, fully straightening your elbows without locking them.");
        } else if (type.equals("jump rope")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.jump_rope;
            Uri surya_namaskar_uri = Uri.parse(video_path);
            videoView.setVideoURI(surya_namaskar_uri);
            videoView.start();
            titleView.setText("Jump Rope");
            descriptionView.setText("Stay low when jumping to conserve energy and avoid fatigue."
                    + "\nKeeping your arms up and in a circular motion at your waist and elbows ensures effective rope rotation."
                    + "\nMaintain correct body position when jumping rope, with hips over knees and shoulders over hips, like a boxer in the boxing ring.");

        }
    }
}