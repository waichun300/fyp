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


public class WeightedExerciseDescriptionActivity extends AppCompatActivity {
    private VideoView videoView;
    private TextView titleView,exerciseTitleView, descriptionView;
    private ImageView back;
    private String video_path;
    private MediaController mediaController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weighted_exercise_description);

        back = findViewById(R.id.backButton);
        titleView = findViewById(R.id.titleTextView);
        videoView = findViewById(R.id.WeightedExerciseVideoView);
        exerciseTitleView = findViewById(R.id.WeightedExerciseTitleView);
        descriptionView = findViewById(R.id.WeightedExerciseDescriptionView);
        titleView.setText("Description");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        if(type.equals("dumbbell squat")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_squat;
            exerciseTitleView.setText(getString(R.string.dumbbell_squat));
            descriptionView.setText(getString(R.string.dumbbell_squat_description));
        }else if(type.equals("dumbbell lunges")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbell_lunges;
            exerciseTitleView.setText(getString(R.string.dumbbell_lunges));
            descriptionView.setText(getString(R.string.dumbbell_lunges_description));
        }else if(type.equals("dumbbell shoulder press")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_shoulder_press;
            exerciseTitleView.setText(getString(R.string.dumbbell_shoulder_press));
            descriptionView.setText(getString(R.string.dumbbell_shoulder_press_description));
        }else if(type.equals("dumbbell bent over rows")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_bent_over_rows;
            exerciseTitleView.setText(getString(R.string.dumbbell_bent_over_rows));
            descriptionView.setText(getString(R.string.dumbbell_bent_over_rows_description));
        }else if(type.equals("dumbbell deadlift")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_deadlift;
            exerciseTitleView.setText(getString(R.string.dumbbell_deadlift));
            descriptionView.setText(getString(R.string.dumbbell_deadlift_description));
        }else if(type.equals("dumbbell chest press")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_bench_press;
            exerciseTitleView.setText(getString(R.string.dumbbell_chest_press));
            descriptionView.setText(getString(R.string.dumbbell_chest_press_description));
        }else if(type.equals("dumbbell bicep curls")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_biceps_curl;
            exerciseTitleView.setText(getString(R.string.dumbbell_bicep_curls));
            descriptionView.setText(getString(R.string.dumbbell_bicep_curls_description));
        }else if(type.equals("dumbbell tricep extension")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_tricep_extension;
            exerciseTitleView.setText(getString(R.string.dumbbell_tricep_extension));
            descriptionView.setText(getString(R.string.dumbbell_tricep_extension_description));
        }else if(type.equals("dumbbell lateral raises")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_tricep_extension;
            exerciseTitleView.setText(getString(R.string.dumbbell_lateral_raises));
            descriptionView.setText(getString(R.string.dumbbell_lateral_raises_description));
        }else if(type.equals("dumbbell russian twist")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_russian_twist;
            exerciseTitleView.setText(getString(R.string.dumbbell_russian_twist));
            descriptionView.setText(getString(R.string.dumbbell_russian_twist_description));
        }else if(type.equals("dumbbell arnold press")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.arnold_press;
            exerciseTitleView.setText(getString(R.string.dumbbell_arnold_press));
            descriptionView.setText(getString(R.string.dumbbell_arnold_press_description));
        }else if(type.equals("dumbbell tricep kickback")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_tricep_kickback;
            exerciseTitleView.setText(getString(R.string.dumbbell_tricep_kickback));
            descriptionView.setText(getString(R.string.dumbbell_tricep_kickback_description));
        }else if(type.equals("dumbbell front raise")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_front_raise;
            exerciseTitleView.setText(getString(R.string.dumbbell_front_raise));
            descriptionView.setText(getString(R.string.dumbbell_front_raise_description));
        }else if(type.equals("dumbbell renegade row")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_renegade_rows;
            exerciseTitleView.setText(getString(R.string.dumbbell_renegade_row));
            descriptionView.setText(getString(R.string.dumbbell_renegade_row_description));
        }else if(type.equals("dumbbell reverse fly")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_reverse_fly;
            exerciseTitleView.setText(getString(R.string.dumbbell_reverse_fly));
            descriptionView.setText(getString(R.string.dumbbell_reverse_fly_description));
        }

        Uri video_uri = Uri.parse(video_path);
        videoView.setVideoURI(video_uri);
        videoView.start();
    }
}