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

public class YogaDescriptionActivity extends AppCompatActivity {
    private VideoView videoView;
    private TextView titleView,exerciseTitleView, descriptionView;
    private ImageView back;
    private String video_path;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_description);

        back = findViewById(R.id.backButton);
        titleView = findViewById(R.id.titleTextView);
        videoView = findViewById(R.id.YogaExerciseVideoView);
        exerciseTitleView = findViewById(R.id.YogaExerciseTitleView);
        descriptionView = findViewById(R.id.YogaExerciseDescriptionView);
        titleView.setText("Description");

        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Intent intent = getIntent();
        String type = intent.getStringExtra("type");

        if(type.equals("utkatasana")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.utkatasana;
            exerciseTitleView.setText(getString(R.string.utkatasana));
            descriptionView.setText(getString(R.string.utkatasana_description));
        }else if(type.equals("virabhadrasana")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.virabhadrasana;
            exerciseTitleView.setText(getString(R.string.virabhadrasana));
            descriptionView.setText(getString(R.string.virabhadrasana_description));
        }else if(type.equals("navasana")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.navasana;
            exerciseTitleView.setText(getString(R.string.navasana));
            descriptionView.setText(getString(R.string.navasana_description));
        }else if(type.equals("phalakasana")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.phalakasana;
            exerciseTitleView.setText(getString(R.string.phalakasana));
            descriptionView.setText(getString(R.string.phalakasana_description));
        }else if(type.equals("surya namaskar")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.yoga1;
            exerciseTitleView.setText(getString(R.string.surya_namaskar));
            descriptionView.setText(getString(R.string.surya_namaskar_description));
        }else if(type.equals("adho mukha svanasana")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.adho_mukha_svanasana;
            exerciseTitleView.setText(getString(R.string.adho_mukha_svanasana));
            descriptionView.setText(getString(R.string.adho_mukha_svanasana_description));
        }else if(type.equals("trikonasana")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.trikonasana;
            exerciseTitleView.setText(getString(R.string.trikonasana));
            descriptionView.setText(getString(R.string.trikonasana_description));
        }else if(type.equals("bhujangasana")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.bhujangasana;
            exerciseTitleView.setText(getString(R.string.bhujangasana));
            descriptionView.setText(getString(R.string.bhujangasana_description));
        }else if(type.equals("vrikshasana")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.vrikshasana;
            exerciseTitleView.setText(getString(R.string.vrikshasana));
            descriptionView.setText(getString(R.string.vrikshasana_description));
        }else if(type.equals("gomukhasana")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.gomukhasana;
            exerciseTitleView.setText(getString(R.string.gomukhasana));
            descriptionView.setText(getString(R.string.gomukhasana_description));
        }else if(type.equals("natarajasana")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.natarajasana;
            exerciseTitleView.setText(getString(R.string.natarajasana));
            descriptionView.setText(getString(R.string.natarajasana_description));
        }else if(type.equals("chakravakasana")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.chakravakasana;
            exerciseTitleView.setText(getString(R.string.chakravakasana));
            descriptionView.setText(getString(R.string.chakravakasana_description));
        }else if(type.equals("vasisthasana")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.vasisthasana;
            exerciseTitleView.setText(getString(R.string.vasisthasana));
            descriptionView.setText(getString(R.string.vasisthasana_description));
        }else if(type.equals("ardha chandrasana")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.ardha_chandrasana;
            exerciseTitleView.setText(getString(R.string.ardha_chandrasana));
            descriptionView.setText(getString(R.string.ardha_chandrasana_description));
        }else if(type.equals("mandukasana")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.mandukasana;
            exerciseTitleView.setText(getString(R.string.mandukasana));
            descriptionView.setText(getString(R.string.mandukasana_description));
        }

        Uri video_uri = Uri.parse(video_path);
        videoView.setVideoURI(video_uri);
        videoView.start();
    }
}
