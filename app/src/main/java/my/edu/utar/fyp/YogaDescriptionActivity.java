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
        String reminder = "\nReminder: Please prepare yoga mat before starting your workout.";

        if(type.equals("utkatasana")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.utkatasana;
            exerciseTitleView.setText("Utkatasana");
            descriptionView.setText("Utkatasana (chair pose) is a standing yoga pose that mimics the shape of sitting in an imaginary chair. "
                    + "\n\nInstruction:"
                    + "\nFirst, stand in mountain pose with feet together or slightly apart, engaging inner thighs and lifting arms overhead with external rotation."
                    + "\nThen, keep your spine neutral as you bend your knees to a comfortable position, focusing on lifting your chest and squeezing your inner thighs together."
                    + "\nFinally, keep your chest forward or slightly lifted throughout the movement."
                    + reminder);
        }else if(type.equals("virabhadrasana")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.virabhadrasana;
            exerciseTitleView.setText("Virabhadrasana");
            descriptionView.setText("Virabhadrasana(Warrior Pose) is a group of standing yoga poses that symbolize the fierce warrior Virabhadra from Hindu mythology. "
                    + "\n\nInstruction:"
                    + "\nVirabhadrasana poses can help to strengthen the legs, core, and arms while improving balance, stability, and focus."
                    + "\nThere are three main variations of Virabhadrasana: Virabhadrasana I, II, and III."
                    + "\n\nVirabhadrasana I:"
                    + "\nFirst, start in Mountain Pose, step your left leg back into a lunge and place your right knee over your right ankle."
                    + "\nThen, align your hips by folding your tailbone down and turning your back heels inward at a 45-degree angle."
                    + "\nFinally, engage your core, sink deeper into your front leg, and raise your arms overhead, wrapping your triceps in them and aligning your biceps between your cheeks and ears."
                    + "\n\nVirabhadrasana II:"
                    + "\nFirst, start in Mountain Pose, then step your left foot back and transition into a high lunge."
                    + "\nThen, open your hips and extend your arms horizontally, aligning your front knee with your ankle and spine vertically."
                    + "\nFinally, relax your shoulders, stretch out your fingers, and turn your head to stare at the middle finger in front of you."
                    + "\n\nVirabhadrasana III:"
                    + "\nFirst, stand with your feet together, hands on your heart center, and focus on a fixed point."
                    + "\nThen, fold forward and extend one leg behind you, forming a straight line with your torso and raised leg."
                    + "\nFinally, engage your quads and inner thighs to root down through your standing feet while maintaining balance and alignment."
                    + reminder);
        }else if(type.equals("navasana")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.navasana;
            exerciseTitleView.setText("Navasana");
            descriptionView.setText("Navasana(boat pose) is a core-strengthening yoga pose shaped like a boat."
                    + "\n\nInstruction:"
                    + "\nFirst, begin seated with legs together and knees bent, placing hands behind you and lifting onto fingertips, while lifting chest and engaging core. "
                    + "\nThen, lean back slightly, balancing on the back of your sitz bones, and lift legs up, pointing toes and squeezing inner thighs together."
                    + "\nOptionally, extend arms forward and straighten legs while lifting chest and gaze for an added challenge."
                    + reminder);
        }else if(type.equals("phalakasana")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.phalakasana;
            exerciseTitleView.setText("Phalakasana");
            descriptionView.setText("Phalakasana(Plank Pose) is a foundational yoga posture that primarily strengthens the core, shoulders, arms, and wrists."
                    + "\n\nInstruction:"
                    + "\nFirst, start in a tabletop position with your hands under your shoulders and your knees aligned under your hips."
                    + "\nThen, engage your triceps to rotate your elbows back while pressing your hands down and squeezing them together to activate your chest."
                    + "\nFinally, bend your knees and extend your legs, extending your shoulder blades, squeezing your inner thighs, and engaging your core while maintaining a neutral gaze."
                    + reminder);
        }else if(type.equals("surya namaskar")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.yoga1;
            exerciseTitleView.setText("Surya Namaskar");
            descriptionView.setText("Surya Namaskar(Sun Salutation) is a sequence of yoga postures performed in a fluid motion. "
                    + "\n\nInstruction:"
                    + "\nFirst, stretch your hands upward in Namaskar mudra, then forward and downward."
                    + "\nStep your right leg back and lower your knee, transitioning into the equestrian position ashas sanchalan."
                    + "\nThen, get into a plank position with your chest between your hands, then inhale and slide forward into Upward Dog."
                    + "\nFinally, return to the equestrian position, swing your legs forward, and then gently stand up, arching your back."
                    + reminder);
        }

        Uri video_uri = Uri.parse(video_path);
        videoView.setVideoURI(video_uri);
        videoView.start();
    }
}
