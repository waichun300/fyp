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
    private TextView titleView, descriptionView;
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

        if(type.equals("running")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.running;
            Uri running_uri = Uri.parse(video_path);
            videoView.setVideoURI(running_uri);
            videoView.start();
            titleView.setText("Running");
            descriptionView.setText(" Keep your arms compact and relaxed, knees bent, and body tall to maintain proper posture throughout your run."
                    + "\nThen,land on your midfoot directly underneath your center of mass to avoid overstriding."
                    + "\nFinally, lean forward slightly from your ankles, rather than your hips, to move forward more efficiently.");
        }
        else if (type.equals("push up")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.push_up;
            Uri push_up_uri = Uri.parse(video_path);
            videoView.setVideoURI(push_up_uri);
            videoView.start();
            titleView.setText("Push Up");
            descriptionView.setText("First,start in a plank position with your hands shoulder-width apart and palms flat on the floor, making sure your wrists are aligned with your shoulders."
                    + "\nThen,bend your elbows close to your sides, then lower your body toward the floor by lowering your chest until it's almost touching the ground."
                    + "\nFinally,push your arms through your palms to extend and return to the starting position, fully straightening your elbows without locking them.");
        } else if (type.equals("jump rope")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.jump_rope;
            Uri jump_rope_uri = Uri.parse(video_path);
            videoView.setVideoURI(jump_rope_uri);
            videoView.start();
            titleView.setText("Jump Rope");
            descriptionView.setText("First,stay low when jumping to conserve energy and avoid fatigue."
                    + "\nThen,keep your arms up and in a circular motion at your waist and elbows ensures effective rope rotation."
                    + "\nFinally,maintain correct body position when jumping rope, with hips over knees and shoulders over hips, like a boxer in the boxing ring.");
        }else if (type.equals("squat jump")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.squat_jump;
            Uri squat_jump_uri = Uri.parse(video_path);
            videoView.setVideoURI(squat_jump_uri);
            videoView.start();
            titleView.setText("Squat Jump");
            descriptionView.setText("First,lower your body into a squat position while keeping your core tight."
                    + "\nThen,explode upward with force, extending your legs and hips to jump off the ground."
                    + "\nFinally, ensure a soft and controlled landing by landing quietly, absorbing impact with bent knees to protect your joints");
        }else if(type.equals("burpee")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.burpee;
            Uri burpee_uri = Uri.parse(video_path);
            videoView.setVideoURI(burpee_uri);
            videoView.start();
            titleView.setText("Burpee");
            descriptionView.setText("First,bend the knees and place the hands on the floor, then step the legs back individually to assume a plank position."
                    + "\nThen,lower the chest to the floor, perform a push-up, and then push back up to return to the plank position."
                    + "\nFinally, step the legs back in, stand up, and return to the starting position.");
        }
    }
}