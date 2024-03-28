package my.edu.utar.fyp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class YogaDescriptionActivity extends AppCompatActivity {
    private VideoView videoView;
    private TextView titleView, descriptionView;
    private String video_path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_description);

        videoView = findViewById(R.id.YogaExerciseVideoView);
        titleView = findViewById(R.id.YogaExerciseTitleView);
        descriptionView = findViewById(R.id.YogaExerciseDescriptionView);
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        String reminder = "\nReminder: Please prepare yoga mat before starting your workout.";

        if(type.equals("utkatasana")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.virabhadrasana;
            Uri running_uri = Uri.parse(video_path);
            videoView.setVideoURI(running_uri);
            videoView.start();
            titleView.setText("Utkatasana");
            descriptionView.setText("Utkatasana (chair pose) is a standing yoga pose that mimics the shape of sitting in an imaginary chair. "
                    + "\nIt help in stretches the shoulders, chest, and spine, stimulating circulation and energizing the body."
                    + "\nTherefore,it is usually done to build up heat and prepare the body for more challenging poses."
                    + reminder);
        }else if(type.equals("virabhadrasana")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.virabhadrasana;
            Uri running_uri = Uri.parse(video_path);
            videoView.setVideoURI(running_uri);
            videoView.start();
            titleView.setText("Virabhadrasana");
            descriptionView.setText("Virabhadrasana(Warrior Pose) is a group of standing yoga poses that symbolize the fierce warrior Virabhadra from Hindu mythology. "
                    + "\nVirabhadrasana poses can help to strengthen the legs, core, and arms while improving balance, stability, and focus."
                    + "\nSo,there are three main variations of Virabhadrasana: Virabhadrasana I, II, and III."
                    + reminder);
        }else if(type.equals("navasana")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.navasana;
            Uri running_uri = Uri.parse(video_path);
            videoView.setVideoURI(running_uri);
            videoView.start();
            titleView.setText("Navasana");
            descriptionView.setText("Navasana(boat pose) is a core-strengthening yoga pose shaped like a boat."
                    + "\nIt can develop core strength and enhance overall physical endurance through the ore-strengthening yoga pose."
                    + "\nBesides, it also can stimulates the digestive system and can help alleviate stress and fatigue."
                    + reminder);
        }else if(type.equals("phalakasana")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.phalakasana;
            Uri running_uri = Uri.parse(video_path);
            videoView.setVideoURI(running_uri);
            videoView.start();
            titleView.setText("Phalakasana");
            descriptionView.setText("Phalakasana(Plank Pose) is a foundational yoga posture that primarily strengthens the core, shoulders, arms, and wrists."
                    + "\nIt can builds stability in the core muscles, improves posture, and enhances overall body strength. "
                    + "\nBesides, it is a versatile pose that can be modified to accommodate different levels of strength and flexibility."
                    + reminder);
        }else if(type.equals("surya namaskar")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.yoga1;
            Uri running_uri = Uri.parse(video_path);
            videoView.setVideoURI(running_uri);
            videoView.start();
            titleView.setText("Surya Namaskar");
            descriptionView.setText("Surya Namaskar(Sun Salutation) is a sequence of yoga postures performed in a fluid motion. "
                    + "\nIt is a complete body workout as it stretches, flexes, and tones the muscles while promoting flexibility and improving overall health."
                    + "\nBesides, it can be modified to suit different levels of experience and fitness"
                    + reminder);
        }
    }
}