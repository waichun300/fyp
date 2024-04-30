package my.edu.utar.fyp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class CardioExerciseDescriptionActivity extends AppCompatActivity {

    private VideoView videoView;
    private TextView titleView,exerciseTitleView, descriptionView;
    private ImageView back;
    private String video_path;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_exercise_description);

        back = findViewById(R.id.backButton);
        titleView = findViewById(R.id.titleTextView);
        videoView = findViewById(R.id.CardioExerciseVideoView);
        exerciseTitleView = findViewById(R.id.CardioExerciseTitleView);
        descriptionView = findViewById(R.id.CardioExerciseDescriptionView);
        titleView.setText("Description");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        if (type.equals("running")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.running;
            exerciseTitleView.setText(R.string.running);
            descriptionView.setText(R.string.running_description);
        } else if (type.equals("push up")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.push_up;
            exerciseTitleView.setText(R.string.push_up);
            descriptionView.setText(R.string.push_up_description);
        } else if (type.equals("jump rope")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.jump_rope;
            exerciseTitleView.setText(R.string.jump_rope);
            descriptionView.setText(R.string.jump_rope_description);
        } else if (type.equals("squat jump")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.squatjump;
            exerciseTitleView.setText(R.string.squat_jump);
            descriptionView.setText(R.string.squat_jump_description);
        } else if (type.equals("burpee")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.burpee;
            exerciseTitleView.setText(R.string.burpee);
            descriptionView.setText(R.string.burpee_description);
        } else if (type.equals("jumping jack")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.jump_jacks;
            exerciseTitleView.setText(R.string.jumping_jack);
            descriptionView.setText(R.string.jumping_jack_description);
        } else if (type.equals("high knee")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.high_knees;
            exerciseTitleView.setText(getString(R.string.high_knees));
            descriptionView.setText(getString(R.string.high_knees_description));
        } else if (type.equals("mountain climber")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.mountain_climbers;
            exerciseTitleView.setText(getString(R.string.mountain_climbers));
            descriptionView.setText(getString(R.string.mountain_climbers_description));
        } else if (type.equals("crunches")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.crunches;
            exerciseTitleView.setText(getString(R.string.crunches));
            descriptionView.setText(getString(R.string.crunches_description));
        } else if (type.equals("butt kick")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.butt_kicks;
            exerciseTitleView.setText(getString(R.string.butt_kick));
            descriptionView.setText(getString(R.string.butt_kick_description));
        } else if (type.equals("inchworm")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.inchworm;
            exerciseTitleView.setText(getString(R.string.inchworm));
            descriptionView.setText(getString(R.string.inchworm_description));
        } else if (type.equals("bicycle crunch")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.bicycle_crunch;
            exerciseTitleView.setText(getString(R.string.bicycle_crunch));
            descriptionView.setText(getString(R.string.bicycle_crunch_description));
        } else if (type.equals("lateral shuffle")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.lateral_shuffle;
            exerciseTitleView.setText(getString(R.string.lateral_shuffle));
            descriptionView.setText(getString(R.string.lateral_shuffle_description));
        } else if (type.equals("skater jump")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.skater_jump;
            exerciseTitleView.setText(getString(R.string.skater_jump));
            descriptionView.setText(getString(R.string.skater_jump_description));
        } else if (type.equals("jumping lunges")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.jumping_lunges;
            exerciseTitleView.setText(getString(R.string.jumping_lunges));
            descriptionView.setText(getString(R.string.jumping_lunges_description));
        }

        mediaController = new MediaController(this);
        mediaController.setAnchorView((View) videoView.getParent());
        videoView.setMediaController(mediaController);

        Uri video_uri = Uri.parse(video_path);
        videoView.setVideoURI(video_uri);
        videoView.start();
    }
}