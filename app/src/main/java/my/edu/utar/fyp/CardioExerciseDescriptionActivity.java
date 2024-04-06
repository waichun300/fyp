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

        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        if(type.equals("running")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.running;
            exerciseTitleView.setText("Running");
            descriptionView.setText("Running is a cardiovascular exercise which can improve cardiovascular health, burn calories, and improve overall fitness."
                    + "\n\nInstruction:"
                    + "\nFirst, keep your arms compact and relaxed, knees bent, and body tall to maintain proper posture throughout your run."
                    + "\nThen, land on your midfoot directly underneath your center of mass to avoid overstriding."
                    + "\nFinally, lean forward slightly from your ankles, rather than your hips, to move forward more efficiently.");
        }else if (type.equals("push up")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.push_up;
            exerciseTitleView.setText("Push Up");
            descriptionView.setText("Push up is a versatile body weight exercise that target multiple muscle groups to build upper body strength and endurance."
                    + "\n\nInstruction:"
                    + "\nFirst, start in a plank position with your hands shoulder-width apart and palms flat on the floor, making sure your wrists are aligned with your shoulders."
                    + "\nThen, bend your elbows close to your sides, then lower your body toward the floor by lowering your chest until it's almost touching the ground."
                    + "\nFinally, push your arms through your palms to extend and return to the starting position, fully straightening your elbows without locking them.");
        }else if (type.equals("jump rope")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.jump_rope;
            exerciseTitleView.setText("Jump Rope");
            descriptionView.setText("Jumping rope is a dynamic cardiovascular exercise that engages the entire body while improving coordination, agility, and endurance."
                    + "\n\nInstruction:"
                    + "\nFirst, stay low when jumping to conserve energy and avoid fatigue."
                    + "\nThen, keep your arms up and in a circular motion at your waist and elbows ensures effective rope rotation."
                    + "\nFinally, maintain correct body position when jumping rope, with hips over knees and shoulders over hips, like a boxer in the boxing ring.");
        }else if (type.equals("squat jump")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.squatjump;
            exerciseTitleView.setText("Squat Jump");
            descriptionView.setText("Squat Jump is an explosive lower body exercise that combines squats and jumps, which effectively targeting different muscle groups to increase strength and power."
                    + "\n\nInstruction:"
                    + "\nFirst, lower your body into a squat position while keeping your core tight."
                    + "\nThen, explode upward with force, extending your legs and hips to jump off the ground."
                    + "\nFinally, ensure a soft and controlled landing by landing quietly, absorbing impact with bent knees to protect your joints");
        }else if(type.equals("burpee")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.burpee;
            exerciseTitleView.setText("Burpee");
            descriptionView.setText( "Burpee is dynamic full-body exercise that involve squatting, jumping, and push-ups, which enhances cardiovascular fitness, strength, and endurance."
                    + "\n\nInstruction:"
                    + "\nFirst, bend the knees and place the hands on the floor, then step the legs back individually to assume a plank position."
                    + "\nThen, lower the chest to the floor, perform a push-up, and then push back up to return to the plank position."
                    + "\nFinally, step the legs back in, stand up, and return to the starting position.");
        }else if(type.equals("jumping jack")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.jump_jacks;
            exerciseTitleView.setText("Jumping Jacks");
            descriptionView.setText( "Jumping jacks are a dynamic full-body exercise that can improve cardiovascular endurance, coordination, and overall agility."
                    + "\n\nInstruction:"
                    + "\nFirst, start standing with arms by your side and legs together."
                    + "\nThen, jump, spreading your legs slightly wider than shoulder-width apart while raising your arms above your head."
                    + "\nFinally, return to the starting position and repeat, aiming for as many repetitions.");
        }else if(type.equals("high knee")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.high_knees;
            exerciseTitleView.setText("High knees");
            descriptionView.setText( "High knees are an effective exercise for improving cardiovascular fitness and strengthening lower body muscles."
                    + "\n\nInstruction:"
                    + "\nFirst, stand upright with feet hip width apart."
                    + "\nThen, run on the spot bringing the knee ups as high as possible."
                    + "\nFinally, return to the starting position and repeat, aiming for as many repetitions.");
        }else if(type.equals("mountain climber")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.mountain_climbers;
            exerciseTitleView.setText("Mountain Climbers");
            descriptionView.setText( "Mountain climbers are a dynamic exercise that targets multiple muscle groups, including the core, shoulders, and legs which help to build overall strength and endurance."
                    + "\n\nInstruction:"
                    + "\nFirst, ensure your body forms a straight line from head to heels, with shoulders directly over your wrists, engaging your core muscles."
                    + "\nThen, avoid lifting the hips too high, as it can cause the shoulders to move away from the wrists, limiting the range of motion and reducing core engagement."
                    + "\nFinally, focus on a controlled rhythm to maximize strength without sacrificing form.");
        }else if(type.equals("crunches")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.crunches;
            exerciseTitleView.setText("Crunches");
            descriptionView.setText( "Crunches are an effective exercise for strengthening the abdominal muscles which can help to improve core stability and posture."
                    + "\n\nInstruction:"
                    + "\nFirst, lie down with your feet hip-distance apart and fingertips touching your heels."
                    + "\nThen, place your hands behind your head, elbows open, and lift your chest, making sure your lower back is pressed into the mat and your shoulder blades are off the floor."
                    + "\nFinally, keep your neck neutral and focus on engaging your core muscles to feel the workout along the midline for maximum effectiveness.");
        }else if(type.equals("butt kick")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.butt_kicks;
            exerciseTitleView.setText("Butt Kicks");
            descriptionView.setText( "Butt kicks are a cardio exercise that targets the gluteus and hamstrings while improving cardiovascular health."
                    + "\n\nInstruction:"
                    + "\nFirst, run in place and aim to kick your heels up to touch your butt with each step."
                    + "\nThen, maintaining a fast pace and regular breathing and focus on landing on your toes."
                    + "\nFinally, keeping your chest up, and tightening your abs for proper form and effectiveness.");
        }else if(type.equals("inchworms")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.inchworm;
            exerciseTitleView.setText("Inchworms");
            descriptionView.setText( "Inchworms are a training exercise that can strengthens your arms, chest, shoulders and core."
                    + "\n\nInstruction:"
                    + "\nFirst, start by standing with your feet hip-width apart, then centering on your hips, place your hands as far in front of you as possible."
                    + "\nThen, hold the extended plank position briefly to engage your core and shoulders."
                    + "\nFinally, move your hands back to your feet, optionally standing or back to your toes, and repeat to stretch your hamstrings and warm up your core.");
        }else if(type.equals("bicycle crunch")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.bicycle_crunch;
            exerciseTitleView.setText("Bicycle Crunch");
            descriptionView.setText( "Bicycle crunch is an effective ab exercise which can help tone your midsection and slim your waist."
                    + "\n\nInstruction:"
                    + "\nFirst, start by lying on your back with your knees bent and lifted off the floor, working your abdominal muscles by pulling your belly button toward your spine."
                    + "\nThen, place your hands behind your head with your elbows open, making sure to keep them out of your peripheral vision to avoid straining your neck muscles."
                    + "\nNext, alternate bringing one knee closer to your chest while extending the other leg to fully engage your quadriceps."
                    + "\nFinally, rotate your torso so that your opposite elbow is closer to your knee and your shoulder blade away from the mat/floor.");
        }else if(type.equals("lateral shuffle")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.lateral_shuffle;
            exerciseTitleView.setText("Lateral Shuffle");
            descriptionView.setText( "Lateral Shuffle is an exercise that strengthens the calves, hamstrings, quadriceps, hip flexors, and gluteal muscles, helping to improve coordination and agility during difficult side-to-side movements."
                    + "\n\nInstruction:"
                    + "\nFirst, start standing with your feet hip-distance apart and your knees deeply ben."
                    + "\nThen, placing your hands in front of your chest in a protective position, begin moving your right foot, followed by your left foot."
                    + "\nFinally, shuffle to the right four steps from right to left, then move left to four steps from left to right, and then continue shuffling from right to left for the required time.");
        }else if(type.equals("skater jump")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.skater_jump;
            exerciseTitleView.setText("Skater Jump");
            descriptionView.setText( "Skater jump is an aerobic exercise that involves jumping in a pattern that transfers body weight from one side to the other, helping to improve balance and coordination."
                    + "\n\nInstruction:"
                    + "\nFirst, bend your legs slightly and place your arms at your sides, then jump to the right side while extending your left foot back and your left arm forward."
                    + "\nThen, alternate sides by jumping to the left and switching the position of your legs and arms with each jump."
                    + "\nFinally, shuffle to the right four steps from right to left, then move left to four steps from left to right, and then continue shuffling from right to left for the required time.");
        }else if(type.equals("jumping lunges")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.jumping_lunges;
            exerciseTitleView.setText("Jumping Lunges");
            descriptionView.setText( "Butt kicks are a cardio exercise that targets the gluteus and hamstrings while improving cardiovascular health."
                    + "\n\nInstruction:"
                    + "\nFirst, run in place and aim to kick your heels up to touch your butt with each step."
                    + "\nThen, maintaining a fast pace and regular breathing and focus on landing on your toes."
                    + "\nFinally, keeping your chest up, and tightening your abs for proper form and effectiveness.");
        }

        Uri video_uri = Uri.parse(video_path);
        videoView.setVideoURI(video_uri);
        videoView.start();
    }
}