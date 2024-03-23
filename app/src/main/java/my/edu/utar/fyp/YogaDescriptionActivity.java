package my.edu.utar.fyp;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class YogaDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_description);

        VideoView videoView1 = findViewById(R.id.VideoView);
        String surya_namaskar_video_path = "android.resource://" + getPackageName()+ "/" + R.raw.yoga1;
        Uri surya_namaskar_uri = Uri.parse(surya_namaskar_video_path);
        videoView1.setVideoURI(surya_namaskar_uri);
        videoView1.start();
    }
}