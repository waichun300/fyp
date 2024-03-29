package my.edu.utar.fyp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;


import androidx.appcompat.app.AppCompatActivity;


public class WeightedExerciseDescriptionActivity extends AppCompatActivity {
    private VideoView videoView;
    private TextView titleView, descriptionView;
    private String video_path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weighted_exercise_description);

        videoView = findViewById(R.id.WeightedExerciseVideoView);
        titleView = findViewById(R.id.WeightedExerciseTitleView);
        descriptionView = findViewById(R.id.WeightedExerciseDescriptionView);
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");

        if(type.equals("dumbbell squat")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_squat;
            Uri running_uri = Uri.parse(video_path);
            videoView.setVideoURI(running_uri);
            videoView.start();
            titleView.setText("Dumbbell Squat");
            descriptionView.setText("Dumbbell squat is a exercise that targets multiple muscle groups including the quadriceps and hamstrings to build lower body strength and stability."
                    + "\n\nInstruction:"
                    + "\nFirst, start by standing up straight, holding a dumbbell in each hand with your palms facing your legs."
                    + "\nSecondly, keep your feet shoulder-width apart, toes slightly outward, and always keep your back straight and your head up."
                    + "\nFinally, slowly lower your torso by bending your knees until your thighs are parallel to the floor, then exhale and push through your heels to return to the starting position.");
        }else if(type.equals("dumbbell lunges")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbell_lunges;
            Uri running_uri = Uri.parse(video_path);
            videoView.setVideoURI(running_uri);
            videoView.start();
            titleView.setText("Dumbbell Lunges");
            descriptionView.setText("Dumbbell lunge is a unilateral lower body exercise that improves lower body strength and stability."
                    + "\n\nInstruction:"
                    + "\nFirst, hold dumbbells at shoulder width with maintain proper posture."
                    + "\nThen, take step forward with one leg, lowering your body until your front thigh is parallel to the ground."
                    + "\nFinally, ensure your front knee doesn't extend past your toes, then push through your feet to return to standing.");
        }else if(type.equals("dumbbell shoulder press")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_shoulder_press;
            Uri running_uri = Uri.parse(video_path);
            videoView.setVideoURI(running_uri);
            videoView.start();
            titleView.setText("Dumbbell Shoulder Press");
            descriptionView.setText("Dumbbell shoulder press is a strength training exercise that targets the deltoid muscles of the shoulders."
                    + "\n\nInstruction:"
                    + "\nFirst, sit on a bench with back support and hold a dumbbell in each hand at shoulder height, palms facing forward."
                    + "\nThen, exhale as you push the dumbbells up until they touch the top, then inhale as you lower the dumbbells to shoulder height."
                    + "\nFinally, repeat for the desired number of repetitions and ensure controlled movement and proper wrist rotation throughout.");
        } else if(type.equals("dumbbell bent over rows")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_shoulder_press;
            Uri running_uri = Uri.parse(video_path);
            videoView.setVideoURI(running_uri);
            videoView.start();
            titleView.setText("Dumbbell Bent Over Rows");
            descriptionView.setText("Dumbbell bent over row is a exercise that primarily targets the back muscles to strengthen them and improve overall upper body strength."
                    + "\n\nInstruction:"
                    + "\nFirst, choose an suitable grip. But an overhand grip is more recommended because it reduces stress on your lower back during your repetitions."
                    + "\nWhen doing the Romanian deadlift, stand in the lowest position with your knees slightly bent and your hamstrings and glutes tight."
                    + "\nFinally, flex your abdominal muscles and keep your waist straight. Let the weight drop near your knees and row upward toward your belly button.");
        } else if(type.equals("dumbbell bent over rows")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.dumbbell_bent_over_rows;
            Uri running_uri = Uri.parse(video_path);
            videoView.setVideoURI(running_uri);
            videoView.start();
            titleView.setText("dumbbell deadlift");
            descriptionView.setText("The dumbbell deadlift targets the hamstrings and glutes, emphasizing hip hinge movement."
                    + "\n\nInstruction:"
                    + "\nFirst, start by standing with your feet hip-width apart and pushing your hips back, keeping your back flat while feeling the tension in your hamstrings."
                    + "\nThen, push hips back to feel the hamstring stretch, then engage the glutes by pulling hips through at the top."
                    + "\nFinally, focusing on keeping your core engaged and avoiding hyperextension of your back.");
        }
    }
}