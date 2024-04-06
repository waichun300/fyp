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
        String reminder = "\n\nReminder: Please prepare yoga mat before starting your workout.";

        if(type.equals("utkatasana")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.utkatasana;
            exerciseTitleView.setText("Utkatasana (Chair pose)");
            descriptionView.setText("Utkatasana is a standing yoga pose that mimics the shape of sitting in an imaginary chair. "
                    + "\n\nInstruction:"
                    + "\nFirst, stand in mountain pose with feet together or slightly apart, engaging inner thighs and lifting arms overhead with external rotation."
                    + "\nThen, keep your spine neutral as you bend your knees to a comfortable position, focusing on lifting your chest and squeezing your inner thighs together."
                    + "\nFinally, keep your chest forward or slightly lifted throughout the movement."
                    + reminder);
        }else if(type.equals("virabhadrasana")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.virabhadrasana;
            exerciseTitleView.setText("Virabhadrasana (Warrior Pose)");
            descriptionView.setText("Virabhadrasana is a group of standing yoga poses that symbolize the fierce warrior Virabhadra from Hindu mythology. "
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
            exerciseTitleView.setText("Navasana (Boat Pose)");
            descriptionView.setText("Navasana is a core-strengthening yoga pose shaped like a boat."
                    + "\n\nInstruction:"
                    + "\nFirst, begin seated with legs together and knees bent, placing hands behind you and lifting onto fingertips, while lifting chest and engaging core. "
                    + "\nThen, lean back slightly, balancing on the back of your sitz bones, and lift legs up, pointing toes and squeezing inner thighs together."
                    + "\nOptionally, extend arms forward and straighten legs while lifting chest and gaze for an added challenge."
                    + reminder);
        }else if(type.equals("phalakasana")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.phalakasana;
            exerciseTitleView.setText("Phalakasana (Plank Pose)");
            descriptionView.setText("Phalakasana is a foundational yoga posture that primarily strengthens the core, shoulders, arms, and wrists."
                    + "\n\nInstruction:"
                    + "\nFirst, start in a tabletop position with your hands under your shoulders and your knees aligned under your hips."
                    + "\nThen, engage your triceps to rotate your elbows back while pressing your hands down and squeezing them together to activate your chest."
                    + "\nFinally, bend your knees and extend your legs, extending your shoulder blades, squeezing your inner thighs, and engaging your core while maintaining a neutral gaze."
                    + reminder);
        }else if(type.equals("surya namaskar")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.yoga1;
            exerciseTitleView.setText("Surya Namaskar (Sun Salutation)");
            descriptionView.setText("Surya Namaskar is a sequence of yoga postures performed in a fluid motion. "
                    + "\n\nInstruction:"
                    + "\nFirst, stretch your hands upward in Namaskar mudra, then forward and downward."
                    + "\nStep your right leg back and lower your knee, transitioning into the equestrian position ashas sanchalan."
                    + "\nThen, get into a plank position with your chest between your hands, then inhale and slide forward into Upward Dog."
                    + "\nFinally, return to the equestrian position, swing your legs forward, and then gently stand up, arching your back."
                    + reminder);
        }else if(type.equals("adho mukha svanasana")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.adho_mukha_svanasana;
            exerciseTitleView.setText("Adho Mukha Svanasana (Downward Dog Pose)");
            descriptionView.setText("Adho mukha svanasana is part arm balance, part inversion, and part restorative pose that stretches and strengthens various parts of the body."
                    + "\n\nInstruction:"
                    + "\nFirst, start on your hands and knees. Place your hands at the top of the mat, shoulder distance apart. "
                    + "\nExternally rotate your arms by wrapping your triceps back ,squeeze your hands together to activate your chest and lift knees and hips up and back."
                    + "\nThen, create extension in your spine by lifting up from your pelvis and pressing into your hands as well as wrap your triceps down to create space across your back."
                    + "\nFinally, lift your heels slightly and turn them out so they are aligned behind your toes and squeeze your inner thighs together."
                    + reminder);
        }else if(type.equals("trikonasana")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.trikonasana;
            exerciseTitleView.setText("Trikonasana (Triangle Pose)");
            descriptionView.setText("Trikonasana is a yoga posture that helps in stretching the legs and strengthening body muscles as well as activates the body core, which further stimulates the digestive organs."
                    + "\n\nInstruction:"
                    + "\nFirst, make sure the toes of the front foot are forward and the toes of the back foot are at an angle of about 45 degrees, focusing on lengthening the lower side of the body."
                    + "\nThen, if you need support, use a block and place it on the outside of your ankles, extending your upper arms upward while keeping your chest aligned with your hips and lifting your chest."
                    + "\nFinally, keep a straight line from wrist to wrist as you turn your body. "
                    + reminder);
        }else if(type.equals("bhujangasana")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.bhujangasana;
            exerciseTitleView.setText("Bhujangasana (Cobra Pose)");
            descriptionView.setText("Bhujangasana is a yoga pose that stretches and strengthens the abdominal muscles and is especially beneficial for toning the uterine muscles."
                    + "\n\nInstruction:"
                    + "\nFirst, lie on your stomach, place your hands under your shoulders, extend your legs behind you, and press your toes into the ground."
                    + "\nThen, using core and hip strength, lift your chest about three inches off the floor, making sure your head is aligned with your spine and your elbows are squeezed back."
                    + "\nFinally, keep lifting while squeezing your thighs together and opening your chest, then gradually relax."
                    + reminder);
        }else if(type.equals("vrikshasana")){
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.vrikshasana;
            exerciseTitleView.setText("Vrikshasana (Tree Pose)");
            descriptionView.setText("Vrikshasana is a yoga pose that strengthens the legs and core and  helps build better balance."
                    + "\n\nInstruction:"
                    + "\nFirst, stand with your feet together, then lift one leg and grab your knee for balance."
                    + "\nThen, firmly root your standing foot and place your lifted foot on the inner thigh of your standing leg, keeping your foot flexed and pressing the sole of your foot into your thigh."
                    + "\nFinally, place your hands over your heart center or extend your arms above your head while maintaining balance and stability."
                    + reminder);
        }else if(type.equals("gomukhasana")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.gomukhasana;
            exerciseTitleView.setText("Gomukhasana (Cow Face Pose)");
            descriptionView.setText("Gomukhasana is a yoga pose that great for those who frequently slouch or simply want to improve their posture."
                    + "\n\nInstruction:"
                    + "\nFirst, begin sitting with one heel on the outside of your opposite hip and your knees stacked together."
                    + "\nKeeping your spine straight, gently pull one arm behind your back, reaching toward your opposite shoulder blade."
                    + "\nThen, reach up with your other arm and bend your elbow, then rotate it inward and place it behind your back to clasp your hands or use a support to help if needed."
                    + "\nFinally, lift your chest and fold your legs forward for a deeper stretch."
                    + reminder);
        }else if(type.equals("natarajasana")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.natarajasana;
            exerciseTitleView.setText("Natarajasana (Dancer Pose)");
            descriptionView.setText("Natarajasana is a beautiful balancing pose that opens your entire front body which can strengthens your muscles, as well as your focus and your balance."
                    + "\n\nInstruction:"
                    + "\nFirst, stand with your feet together and pull one leg toward your chest, rooting down through the standing foot."
                    + "\nUse your quadriceps and gluteal muscles to stabilize your pelvis as you lower your bent knee into alignment with your standing leg."
                    + "\nThen, begin to lean forward, extending your raised foot behind you and holding it with your free arm."
                    + "\nAlternatively, use an inverted grip, placing your elbows on the outside of your legs and grabbing the edge of your feet with your pinky toes."
                    + "\nFinally, rotate your chest forward and raise your elbows toward the sky, then reach your free arm up behind you, kicking your feet to push your chest forward and straightening your standing leg for a deep stretch."
                    + reminder);
        }else if(type.equals("chakravakasana")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.chakravakasana;
            exerciseTitleView.setText("Chakravakasana (Cat-Cow Pose)");
            descriptionView.setText("Chakravakasana is an opening stretch that targets your entire back body which can strength the spine."
                    + "\n\nInstruction:"
                    + "\nFirst, start on all fours, making sure your shoulders are aligned with your wrists and your knees are aligned with your hips."
                    + "\nThen inhale into Cow Pose, arching your back and raising your gaze."
                    + "\nNext exhale into Cat Pose, rounding your spine and tightening your chin."
                    + "\nFinally, rotate your chest forward and raise your elbows toward the sky, then reach your free arm up behind you, kicking your feet to push your chest forward and straightening your standing leg for a deep stretch."
                    + reminder);
        }else if(type.equals("vasisthasana")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.vasisthasana;
            exerciseTitleView.setText("Vasisthasana (Side Plank Pose)");
            descriptionView.setText("Vasisthasana is an excellent exercise for strengthening the oblique abdominal muscles."
                    + "\n\nInstruction:"
                    + "\nFirst, start in a plank position with your hands under your shoulders and your triceps rotated back."
                    + "\nThen, with your feet together, squeeze your inner thighs and roll to the outer edge of one foot."
                    + "\nNext, stack your hips vertically together and align your shoulders while raising one arm above your head."
                    + "\nFinally, rotate the bottom arm outward, press to activate the side body, and look down, forward, or up toward the sky."
                    + reminder);
        }else if(type.equals("ardha chandrasana")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.ardha_chandrasana;
            exerciseTitleView.setText("Ardha Chandrasana (Half Moon Pose)");
            descriptionView.setText("Ardha Chandrasana is a standing balance that activates many different muscle groups, strengthening your core and lower body and relieving stress."
                    + "\n\nInstruction:"
                    + "\nFirst, start in a side angle position, then place one hand on your back hip and reach forward with the other hand."
                    + "\nThen, lift your front leg and lift your back leg, flexing your foot with your toes facing the side of the mat."
                    + "\nNext, root down through the corners of your standing feet, lift your kneecaps, tighten your outer hips toward your midline, and make sure the fingertips of your lower arms are under your shoulders."
                    + "\nFinally, gaze down and extend your upper arms toward the sky, forming a long line of energy between your lower and upper hands"
                    + reminder);
        }else if(type.equals("mandukasana")) {
            video_path = "android.resource://" + getPackageName() + "/" + R.raw.mandukasana;
            exerciseTitleView.setText("Mandukasana (Frog Pose)");
            descriptionView.setText("Mandukasana is a yoga pose that targets your core, hips, and inner thighs which can strength the back muscles."
                    + "\n\nInstruction:"
                    + "\nFirst, start in a hands and knees position, spreading your knees as far apart as your flexibility allows."
                    + "\nThen, rotate your toes outward, opening your feet above knee-width."
                    + "\nTo increase the stretch, move your hips back toward your heels and lower into your forearms."
                    + "\nFinally, look down or slightly forward to maintain alignment."
                    + reminder);
        }

        Uri video_uri = Uri.parse(video_path);
        videoView.setVideoURI(video_uri);
        videoView.start();
    }
}
