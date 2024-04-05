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
            exerciseTitleView.setText("Dumbbell Squat");
            descriptionView.setText("Dumbbell squat is a exercise that targets multiple muscle groups including the quadriceps and hamstrings to build lower body strength and stability."
                    + "\n\nInstruction:"
                    + "\nFirst, start by standing up straight, holding a dumbbell in each hand with your palms facing your legs."
                    + "\nSecondly, keep your feet shoulder-width apart, toes slightly outward, and always keep your back straight and your head up."
                    + "\nFinally, slowly lower your torso by bending your knees until your thighs are parallel to the floor, then exhale and push through your heels to return to the starting position.");
        }else if(type.equals("dumbbell lunges")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbell_lunges;
            exerciseTitleView.setText("Dumbbell Lunges");
            descriptionView.setText("Dumbbell lunge is a unilateral lower body exercise that improves lower body strength and stability."
                    + "\n\nInstruction:"
                    + "\nFirst, hold dumbbells at shoulder width with maintain proper posture."
                    + "\nThen, take step forward with one leg, lowering your body until your front thigh is parallel to the ground."
                    + "\nFinally, ensure your front knee doesn't extend past your toes, then push through your feet to return to standing.");
        }else if(type.equals("dumbbell shoulder press")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_shoulder_press;
            exerciseTitleView.setText("Dumbbell Shoulder Press");
            descriptionView.setText("Dumbbell shoulder press is a strength training exercise that targets the deltoid muscles of the shoulders."
                    + "\n\nInstruction:"
                    + "\nFirst, sit on a bench with back support and hold a dumbbell in each hand at shoulder height, palms facing forward."
                    + "\nThen, exhale as you push the dumbbells up until they touch the top, then inhale as you lower the dumbbells to shoulder height."
                    + "\nFinally, repeat for the desired number of repetitions and ensure controlled movement and proper wrist rotation throughout.");
        } else if(type.equals("dumbbell bent over rows")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_shoulder_press;
            exerciseTitleView.setText("Dumbbell Bent Over Rows");
            descriptionView.setText("Dumbbell bent over row is a exercise that primarily targets the back muscles to strengthen them and improve overall upper body strength."
                    + "\n\nInstruction:"
                    + "\nFirst, choose an suitable grip. But an overhand grip is more recommended because it reduces stress on your lower back during your repetitions."
                    + "\nWhen doing the Romanian deadlift, stand in the lowest position with your knees slightly bent and your hamstrings and glutes tight."
                    + "\nFinally, flex your abdominal muscles and keep your waist straight. Let the weight drop near your knees and row upward toward your belly button.");
        } else if(type.equals("dumbbell deadlift")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_deadlift;
            exerciseTitleView.setText("Dumbbell Deadlift");
            descriptionView.setText("Dumbbell deadlift is a exercise that targets the hamstrings and glutes which can emphasizing hip hinge movement."
                    + "\n\nInstruction:"
                    + "\nFirst, start by standing with your feet hip-width apart and pushing your hips back, keeping your back flat while feeling the tension in your hamstrings."
                    + "\nThen, push hips back to feel the hamstring stretch, then engage the glutes by pulling hips through at the top."
                    + "\nFinally, focusing on keeping your core engaged and avoiding hyperextension of your back.");
        } else if(type.equals("dumbbell chest press")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_bench_press;
            exerciseTitleView.setText("Dumbbell Chest Press");
            descriptionView.setText("Dumbbell chest presses are a exercise that target the pectoral muscles and help to improve stability during daily activities and athletic performance."
                    + "\n\nInstruction:"
                    + "\nFirst, start by tilting your shoulders down and back to engage your chest muscles and create stability by pressing your shoulder blades into the bench."
                    + "\nThen, push your chest outward while drawing your elbows in at a 45-60 degree angle to minimize the risk of shoulder injury and ensure proper activation of the chest muscles."
                    + "\nFinally, maintain this position throughout the entire exercise to effectively target the chest while reducing the risk of injury.");
        } else if (type.equals("dumbbell bicep curls")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_biceps_curl;
            exerciseTitleView.setText("Dumbbell Bicep Curls");
            descriptionView.setText("Dumbbell bicep curls are an exercise that targets the biceps arms and help to improve overall arm strength and definition."
                    + "\n\nInstruction:"
                    + "\nFirst, start with your hands in a neutral position and your feet on the ground while keeping your knees and elbows relaxed."
                    + "\nThen lift both dumbbells simultaneously, squeezing your upper biceps and controlling the negative motion as you lower the weight."
                    + "\nFinally, focus on exhaling during the lifting and lowering phases to maximize the effectiveness of the exercise.");
        } else if (type.equals("dumbbell tricep extension")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_tricep_extension;
            exerciseTitleView.setText("Dumbbell Tricep Extension");
            descriptionView.setText("Dumbbell tricep extension are an exercise that targets the tricep muscles which promote the muscle growth and improved arm strength."
                    + "\n\nInstruction:"
                    + "\nFirst, start with a dumbbell behind your head and stretch upward while squeezing the tops of your triceps."
                    + "\nThen, maintain control throughout the movement, focusing on stretching your triceps on the way down and squeezing it at the top while exhaling during the exertion phase."
                    + "\nFinally, avoid swinging or using dumbbells that are too heavy to avoid hitting yourself.");
        } else if (type.equals("dumbbell lateral raises")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_tricep_extension;
            exerciseTitleView.setText("Dumbbell Lateral Raises");
            descriptionView.setText("Dumbbell lateral raise is an exercise that targets the deltoid muscles, specifically the outer deltoid muscles and help to build shoulder stability and definition."
                    + "\n\nInstruction:"
                    + "\nFirst, stand with your feet hip-width apart."
                    + "\nThen, raise the dumbbells to your sides, at shoulder height, and reverse the movement in a controlled motion."
                    + "\nFinally, lift your chest, shoulders back, and squeeze your abs.");
        } else if (type.equals("dumbbell russian twist")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_russian_twist;
            exerciseTitleView.setText("Dumbbell Russian Twist");
            descriptionView.setText("The dumbbell Russian twist is an exercise that targets the oblique muscles and helps strengthen and sculpt your waistline."
                    + "\n\nInstruction:"
                    + "\nFirst, sit down with your feet slightly raised and your back tilted back."
                    + "\nThen, hold the dumbbells with both hands and twist them left and right."
                    + "\nFinally, keep your legs still and your neck neutral as you twist, and don't forget to exhale as you twist.");
        }

        Uri video_uri = Uri.parse(video_path);
        videoView.setVideoURI(video_uri);
        videoView.start();
    }
}