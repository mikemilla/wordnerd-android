package com.mikemilla.wordnerd;

import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.common.api.GoogleApiClient;
import com.mikemilla.wordnerd.words.*;
import com.mikemilla.wordnerd.words.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;


public class GameFragmentOld extends Fragment implements View.OnClickListener {

    /**
     * Element Variables
     */
    RelativeLayout rhymeContainer;
    TextView computerRhyme;
    static EditText userRhyme;
    TextView score;
    Typeface font;

    View view;

    InputMethodManager imm;

    LinearLayout scoreCard;

    TextView finalScore;
    TextView bestText;
    TextView bestScore;

    Button restart;
    Button mainMenu;

    int best;

    /**
     * Progress Bar Variables
     */
    ProgressBar progressBar;
    int progress;
    CountDownTimer counter;
    long time = 6000;

    /**
     * Order and Score Variables
     */
    int order = 0;
    static int points;

    /* Amount-Random

    Random random;
    int amount;
    TextView amountNeeded;
    s
    */

    /**
     * Sound Variables
     */
    int correctSound, duplicateSound, gameOverSound;
    SoundPool soundPool;

    /**
     * Animation Variables
     */
    Animation shakeAnimation, flipInAnimation, flipOutAnimation,
            slideUpOutAnimation, slideDownOutAnimation, slideUpInAnimation, slideInRightAnimation, slideInLeft, slideOutLeft, scaleBig;
    Animation slideLeft, slideRight;
    ObjectAnimator animation;
    AnimationDrawable dotsAnimation;

    boolean counterRunning;

    LinearLayout rhymeArea;

    LinearLayout mother;

    /**
     * List and String Variables
     */
    ArrayList<String> singles, doubles, triples, quadruples, quintuples, sextuples;
    static ArrayList<String> words;
    static ArrayList<String> rhymesPlayed;
    static HashSet<String> hashedRhymes;
    static String generatedWord;
    String rhymedWord;

    static ToggleButton soundToggle;
    SharedPreferences sharedPrefs;

    private GoogleApiClient mGoogleApiClient;
    private final String TAG = "WordNerd";

    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    int oldBest;

    boolean firstLoad = true;

    private LinearLayout gameContainer;

    public interface Listener {
        public void onGameOver();

        public void onScoreScreenDismissed();

        public void onToggleClicked(View view);
    }

    Listener mListener = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_game_v2, container, false);

        /**
         * Run the loading, styling, and running methods
         */

        /**
         * Style Sound Button
         */
        soundToggle = (ToggleButton) v.findViewById(R.id.sound);

        soundToggle.setText(null);
        soundToggle.setTextOn(null);
        soundToggle.setTextOff(null);

        prefs = getActivity().getSharedPreferences("com.mikemilla.wordnerd", Context.MODE_PRIVATE);
        editor = prefs.edit();

        /**
         * @return soundToggle state (ON/OFF)
         */
        sharedPrefs = getActivity().getSharedPreferences("com.mikemilla.wordnerd", Context.MODE_PRIVATE);
        soundToggle.setChecked(sharedPrefs.getBoolean("toggleState", true));

        mListener.onToggleClicked(view);

        imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

        /**
         * Reset score
         */
        points = 0;
        //random = new Random();

        /**
         * Instantiate Views
         */
        score = (TextView) v.findViewById(R.id.score);
        rhymeContainer = (RelativeLayout) v.findViewById(R.id.rhyme_container);
        gameContainer = (LinearLayout) v.findViewById(R.id.game_container);
        computerRhyme = (TextView) v.findViewById(R.id.rhyme_with);
        userRhyme = (EditText) v.findViewById(R.id.submit_rhyme);
        progressBar = (ProgressBar) v.findViewById(R.id.progress_bar);
        //soundToggle = (ToggleButton) v.findViewById(R.id.sound);
        //amountNeeded = (TextView) findViewById(R.id.amount_needed);

        restart = (Button) v.findViewById(R.id.restart_game);
        mainMenu = (Button) v.findViewById(R.id.main_menu);
        scoreCard = (LinearLayout) v.findViewById(R.id.score_card);
        finalScore = (TextView) v.findViewById(R.id.final_score);
        bestText = (TextView) v.findViewById(R.id.best_text);
        bestScore = (TextView) v.findViewById(R.id.best_score);

        rhymeArea = (LinearLayout) v.findViewById(R.id.rhyme_area);

        v.findViewById(R.id.restart_game).setOnClickListener(this);
        v.findViewById(R.id.main_menu).setOnClickListener(this);

        userRhyme.requestFocus();

        /*
        parent = (ViewGroup) v.findViewById(android.R.id.content);
        view = LayoutInflater.from(getActivity()).inflate(R.layout.rules, parent, false);
        parent.setBackgroundColor(getResources().getColor(R.color.main_background));
        parent.invalidate();
        */

        /**
         * Load Sounds
         */
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        correctSound = soundPool.load(getActivity(), R.raw.correct_sound, 1);
        duplicateSound = soundPool.load(getActivity(), R.raw.duplicate_sound, 2);
        gameOverSound = soundPool.load(getActivity(), R.raw.gameover_sound, 3);

        /**
         * Load Animations
         */
        userRhyme.setBackgroundResource(R.drawable.dots_animation);
        shakeAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.shake);
        flipInAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.flip_in);
        flipOutAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.flip_out);
        slideLeft = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_left);
        slideRight = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_right);
        dotsAnimation = (AnimationDrawable) userRhyme.getBackground();
        dotsAnimation.start();

        slideUpOutAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_up);
        slideUpInAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_up);
        slideDownOutAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_down_out);
        slideInLeft = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_up_in);
        slideOutLeft = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_up_out);

        scaleBig = AnimationUtils.loadAnimation(getActivity(), R.anim.scale_big);

        /**
         * Style Send Button
         */
        //String code = "2202";
        //String uni = String.valueOf(Character.toChars(Integer.parseInt(code, 16)));
        userRhyme.setImeActionLabel("CLEAR", EditorInfo.IME_ACTION_SEND);

        /**
         * Set Fonts
         */
        font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/OldSansBlack.ttf");
        score.setTypeface(font, Typeface.NORMAL);
        userRhyme.setTypeface(font, Typeface.NORMAL);
        computerRhyme.setTypeface(font, Typeface.NORMAL);
        userRhyme.setCursorVisible(false);

        mother = (LinearLayout) v.findViewById(R.id.mother);

        bestText.setTypeface(font, Typeface.NORMAL);
        bestScore.setTypeface(font, Typeface.NORMAL);
        finalScore.setTypeface(font, Typeface.NORMAL);

        /**
         * Instantiate Lists
         */
        rhymesPlayed = new ArrayList<String>();
        hashedRhymes = new HashSet<String>();
        //generatedPlayed = new ArrayList<String>();

        oldBest = prefs.getInt("newScore", best);
        bestScore.setText("" + oldBest);

        if (firstLoad) {
            rhymeArea.startAnimation(slideUpInAnimation);
            soundToggle.startAnimation(slideInLeft);
            computerRhyme.startAnimation(flipInAnimation);
        }

        getNerdy();

        /**
         * Enable swipe to clear userRhyme
         */
        //SwipeDismissTouchListener swipeListener = new SwipeDismissTouchListener(getActivity());
        //rhymeContainer.setOnTouchListener(swipeListener);

        /**
         * @return if the user pressed the send button
         */
        userRhyme.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_ENTER)) {
                    userRhyme.setText(null);
                    return true;
                } else
                    return false;
            }
        });

        /* Amount-Random

        amount = 4;

        if (amount <= 1) {
            amountNeeded.setVisibility(View.GONE);
        } else {
            amountNeeded.setVisibility(View.VISIBLE);
        }

        amountNeeded.setText("" + amount);

        */

        /**
         * Method used to loop through words entered
         *
         * afterTextChanged()
         *      Handles disabled characters
         *
         * beforeTextChanged
         *      Gets the words that rhyme with the generated word
         *
         * onTextChanged
         *      Checks if the user enters an accepted rhyme
         */
        userRhyme.addTextChangedListener
                (new TextWatcher() {
                     public void afterTextChanged(Editable s) {
                         if (android.os.Build.VERSION.SDK_INT > 15) {
                             String space = s.toString().replaceAll(" ", "");
                             String back = s.toString().replaceAll("\\u003F", "");
                             if (!s.toString().equals(space)) {
                                 userRhyme.setText(space);
                                 userRhyme.setSelection(space.length());
                             }
                             if (!s.toString().equals(back)) {
                                 userRhyme.setText(back);
                                 userRhyme.setSelection(back.length());
                             }
                         } else if (android.os.Build.VERSION.SDK_INT <= 15) {
                             // TODO FIX ICS ISSUE
                         }
                     }

                     public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                     }

                     public void onTextChanged(CharSequence s, int start, int before, int count) {
                         crunchTheWord();
                     }
                 }

                );

        return v;
    }

    /**
     * Load elements and style them
     * Prepare timer, but don't run it
     * Load the library
     * Reset the library to find generated Word
     */
    public void getNerdy() {
        runTimer();
        runLibrary();
        resetLibrary();
        randomBackgroundColor();
    }

    /**
     * Run Countdown Timer
     */
    private void runTimer() {

        counter = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                counterRunning = true;

                /**
                 * Set ProgressBar to the Progress on ticks
                 */
                progress = (int) (millisUntilFinished / 1000);
                progressBar.setProgress(progress);

            }

            @Override
            public void onFinish() {

                Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(250);

                counterRunning = false;

                /**
                 * Set ProgressBar to 0 or Done
                 */
                progressBar.setProgress(0);

                /**
                 * Check is sound is enabled
                 */
                if (soundToggle.isChecked()) {
                    soundPool.play(gameOverSound, 1, 1, 0, 0, 1);
                }

                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) scoreCard.getLayoutParams();
                //params.setMargins(0, -AndroidBug5497Workaround.usableHeightPrevious, 0, 0); //substitute parameters for left, top, right, bottom
                scoreCard.setLayoutParams(params);

                //rhymeArea.startAnimation(slideUpOutAnimation);
                //rhymeArea.startAnimation(scaleBig);

                scoreCard.setVisibility(View.VISIBLE);
                scoreCard.startAnimation(slideUpInAnimation);

                //computerRhyme.startAnimation(slideDownOutAnimation);
                //score.startAnimation(slideRightOutAnimation);
                //soundToggle.startAnimation(slideLeftOutAnimation);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        scoreCard.setVisibility(View.VISIBLE);
                        gameOver();
                    }
                }, 500);

                /**
                 * Launch the Score Activity
                 */
                //Intent intent = new Intent(GameActivity.this, ScoreActivity.class);
                //startActivity(intent);
                //finish();
                //overridePendingTransition(R.anim.slide_in_down, R.anim.no_change_slow);
                //userRhyme.setText(null);
                //mListener.onGameOver();
                //scoreCard.setVisibility(View.VISIBLE);
                //gameContainer.startAnimation(slideOutDownAnimation);
                //gameOver();
            }
        };
        /**
         * Start of Restart Timer when called
         */
        counter.start();
    }

    /**
     * Load the library
     * Shuffle the Library
     * Set the text of generatedWord to the top of shuffled
     */
    private void runLibrary() {
        counter.cancel();
        //amountNeeded.setText("" + amount);

        words = new ArrayList<>();
        words.add("ABOUT");
        words.add("AMBER");
        words.add("AMOUNT");
        words.add("ART");
        words.add("ASK");
        words.add("ATTRACTS");
        words.add("BANKS");
        words.add("BARK");
        words.add("BATTLE");
        words.add("BIB");
        words.add("BOOKS");
        words.add("BRAND");
        words.add("BREAK");
        words.add("BUBBLE");
        words.add("BUILT");
        words.add("BULL");
        words.add("BUS");
        words.add("CABLE");
        words.add("CAKE");
        words.add("CAMPER");
        words.add("CASH");
        words.add("CASTLE");
        words.add("CHART");
        words.add("COAL");
        words.add("COLD");
        words.add("CHICK");
        words.add("CIRCULARITY");
        words.add("CITY");
        words.add("COURT");
        words.add("CRANKS");
        words.add("CRIB");
        words.add("CROOKS");
        words.add("CRUISE");
        words.add("CUP");
        words.add("DAMPER");
        words.add("DEAL");
        words.add("DEMAND");
        words.add("DEVICE");
        words.add("DIRECTION");
        words.add("DIRT");
        words.add("DISCUSS");
        words.add("DOG");
        words.add("DONATE");
        words.add("DOPE");
        words.add("DOUBT");
        words.add("DOWN");
        words.add("DRAMA");
        words.add("EMBARK");
        words.add("FACE");
        words.add("FACT");
        words.add("FALL");
        words.add("FARM");
        words.add("FLASK");
        words.add("FLOW");
        words.add("FUNK");
        words.add("FUNNY");
        words.add("GAME");
        words.add("GAS");
        words.add("GATE");
        words.add("GLAMOUR");
        words.add("GLOBE");
        words.add("GLOVE");
        words.add("GATE");
        words.add("HAM");
        words.add("HAMSTER");
        words.add("GRAND");
        words.add("GUN");
        words.add("HANGER");
        words.add("HAPPY");
        words.add("HEAT");
        words.add("HILL");
        words.add("HOBBY");
        words.add("HOOP");
        words.add("HOUSE");
        words.add("IDENTITY");
        words.add("IT");
        words.add("JET");
        words.add("JURY");
        words.add("KITTEN");
        words.add("LADY");
        words.add("LAKE");
        words.add("LESSON");
        words.add("LEVEL");
        words.add("LIFE");
        words.add("LOOM");
        words.add("MAPLE");
        words.add("MARK");
        words.add("MARS");
        words.add("MASH");
        words.add("MASK");
        words.add("MESS");
        words.add("MINT");
        words.add("NECK");
        words.add("NERD");
        words.add("NIBBLE");
        words.add("NOODLE");
        words.add("NUMBER");
        words.add("OVER");
        words.add("PANTS");
        words.add("PARK");
        words.add("PARTY");
        words.add("PEARL");
        words.add("PERRY");
        words.add("PHONE");
        words.add("PINK");
        words.add("PISTOL");
        words.add("POCKET");
        words.add("POINT");
        words.add("PORT");
        words.add("POSTER");
        words.add("PRINCESS");
        words.add("PRO");
        words.add("PURPLE");
        words.add("QUILT");
        words.add("QUIZ");
        words.add("RATED");
        words.add("RAY");
        words.add("RAZOR");
        words.add("REASON");
        words.add("RESTART");
        words.add("RIDE");
        words.add("RIM");
        words.add("RING");
        words.add("ROSE");
        words.add("RUDDER");
        words.add("SADDLE");
        words.add("SCOOT");
        words.add("SENSE");
        words.add("SEVEN");
        words.add("SEVERE");
        words.add("SHARP");
        words.add("SHELL");
        words.add("SLIDE");
        words.add("SLIM");
        words.add("SMART");
        words.add("SNORE");
        words.add("SOFA");
        words.add("SONG");
        words.add("SPROUT");
        words.add("SUGAR");
        words.add("TAIL");
        words.add("TANK");
        words.add("TASK");
        words.add("TATTLE");
        words.add("TATTOO");
        words.add("TEA");
        words.add("THANKS");
        words.add("THIRTY");
        words.add("TRUCK");
        words.add("TUBE");
        words.add("TUSK");
        words.add("TUX");
        words.add("TWILIGHT");
        words.add("VASE");
        words.add("VINE");
        words.add("WAR");
        words.add("WATER");
        words.add("WAVE");
        words.add("WEST");
        words.add("WIN");
        words.add("WIRE");
        words.add("WITCH");
        words.add("WITHOUT");
        words.add("WORD");

        Collections.shuffle(words);
        computerRhyme.setText(words.get(order++));

        // gamer
        // fool
        // education
        // prism
        // logical
        // mist
        // zombie
        // got
        // motion
        // magic
    }

    /**
     * Check if generatedWord equals a specific String
     * Depending on what the string equals, decide on which rhymes are accepted
     */
    private void resetLibrary() {
        String generated = computerRhyme.getText().toString();

        if (generated.equals("ABOUT")) {
            /**
             * Open a new Object containing the accepted rhymes
             */
            About o = new About();
            /**
             * Get the rhymes of that Object & Check syllable lengths
             */
            getRhymes(o);
        } else if (generated.equals("AMBER")) {
            Amber o = new Amber();
            getRhymes(o);
        } else if (generated.equals("AMOUNT")) {
            Amount o = new Amount();
            getRhymes(o);
        } else if (generated.equals("ART")) {
            Art o = new Art();
            getRhymes(o);
        } else if (generated.equals("ATTRACTS")) {
            Attracts o = new Attracts();
            getRhymes(o);
        } else if (generated.equals("ASK")) {
            Ask o = new Ask();
            getRhymes(o);
        } else if (generated.equals("BANKS")) {
            Banks o = new Banks();
            getRhymes(o);
        } else if (generated.equals("BARK")) {
            Bark o = new Bark();
            getRhymes(o);
        } else if (generated.equals("BATTLE")) {
            Battle o = new Battle();
            getRhymes(o);
        } else if (generated.equals("BIB")) {
            Bib o = new Bib();
            getRhymes(o);
        } else if (generated.equals("BOOKS")) {
            Books o = new Books();
            getRhymes(o);
        } else if (generated.equals("BRAND")) {
            Brand o = new Brand();
            getRhymes(o);
        } else if (generated.equals("BREAK")) {
            Break o = new Break();
            getRhymes(o);
        } else if (generated.equals("BUBBLE")) {
            Bubble o = new Bubble();
            getRhymes(o);
        } else if (generated.equals("BUILT")) {
            Built o = new Built();
            getRhymes(o);
        } else if (generated.equals("BULL")) {
            Bull o = new Bull();
            getRhymes(o);
        } else if (generated.equals("BUS")) {
            Bus o = new Bus();
            getRhymes(o);
        } else if (generated.equals("CABLE")) {
            Cable o = new Cable();
            getRhymes(o);
        } else if (generated.equals("CAKE")) {
            Cake o = new Cake();
            getRhymes(o);
        } else if (generated.equals("CAMPER")) {
            Camper o = new Camper();
            getRhymes(o);
        } else if (generated.equals("CASH")) {
            Cash o = new Cash();
            getRhymes(o);
        } else if (generated.equals("CASTLE")) {
            Castle o = new Castle();
            getRhymes(o);
        } else if (generated.equals("CHART")) {
            Chart o = new Chart();
            getRhymes(o);
        } else if (generated.equals("COAL")) {
            Coal o = new Coal();
            getRhymes(o);
        } else if (generated.equals("COLD")) {
            Cold o = new Cold();
            getRhymes(o);
        } else if (generated.equals("CHICK")) {
            Chick o = new Chick();
            getRhymes(o);
        } else if (generated.equals("CIRCULARITY")) {
            Circularity o = new Circularity();
            getRhymes(o);
        } else if (generated.equals("CITY")) {
            City o = new City();
            getRhymes(o);
        } else if (generated.equals("COURT")) {
            Court o = new Court();
            getRhymes(o);
        } else if (generated.equals("CRUISE")) {
            Cruise o = new Cruise();
            getRhymes(o);
        } else if (generated.equals("CRANKS")) {
            Cranks o = new Cranks();
            getRhymes(o);
        } else if (generated.equals("CRIB")) {
            Crib o = new Crib();
            getRhymes(o);
        } else if (generated.equals("CROOKS")) {
            Crooks o = new Crooks();
            getRhymes(o);
        } else if (generated.equals("CUP")) {
            Cup o = new Cup();
            getRhymes(o);
        } else if (generated.equals("DAMPER")) {
            Damper o = new Damper();
            getRhymes(o);
        } else if (generated.equals("DEAL")) {
            Deal o = new Deal();
            getRhymes(o);
        } else if (generated.equals("DEMAND")) {
            Demand o = new Demand();
            getRhymes(o);
        } else if (generated.equals("DEVICE")) {
            Device o = new Device();
            getRhymes(o);
        } else if (generated.equals("DIRECTION")) {
            Direction o = new Direction();
            getRhymes(o);
        } else if (generated.equals("DIRT")) {
            Dirt o = new Dirt();
            getRhymes(o);
        } else if (generated.equals("DISCUSS")) {
            Discuss o = new Discuss();
            getRhymes(o);
        } else if (generated.equals("DOG")) {
            Dog o = new Dog();
            getRhymes(o);
        } else if (generated.equals("DONATE")) {
            Donate o = new Donate();
            getRhymes(o);
        } else if (generated.equals("DOPE")) {
            Dope o = new Dope();
            getRhymes(o);
        } else if (generated.equals("DOUBT")) {
            Doubt o = new Doubt();
            getRhymes(o);
        } else if (generated.equals("DOWN")) {
            Down o = new Down();
            getRhymes(o);
        } else if (generated.equals("DRAMA")) {
            Drama o = new Drama();
            getRhymes(o);
        } else if (generated.equals("EMBARK")) {
            Embark o = new Embark();
            getRhymes(o);
        } else if (generated.equals("FALL")) {
            Fall o = new Fall();
            getRhymes(o);
        } else if (generated.equals("FACE")) {
            Face o = new Face();
            getRhymes(o);
        } else if (generated.equals("FACT")) {
            Fact o = new Fact();
            getRhymes(o);
        } else if (generated.equals("FARM")) {
            Farm o = new Farm();
            getRhymes(o);
        } else if (generated.equals("FLASK")) {
            Flask o = new Flask();
            getRhymes(o);
        } else if (generated.equals("FLOW")) {
            Flow o = new Flow();
            getRhymes(o);
        } else if (generated.equals("FUNK")) {
            Funk o = new Funk();
            getRhymes(o);
        } else if (generated.equals("FUNNY")) {
            Funny o = new Funny();
            getRhymes(o);
        } else if (generated.equals("GAME")) {
            Game o = new Game();
            getRhymes(o);
        } else if (generated.equals("GAS")) {
            Gas o = new Gas();
            getRhymes(o);
        } else if (generated.equals("GLOVE")) {
            Glove o = new Glove();
            getRhymes(o);
        } else if (generated.equals("GOAT")) {
            Goat o = new Goat();
            getRhymes(o);
        } else if (generated.equals("GLAMOUR")) {
            Glamour o = new Glamour();
            getRhymes(o);
        } else if (generated.equals("GATE")) {
            Gate o = new Gate();
            getRhymes(o);
        } else if (generated.equals("GLOBE")) {
            Globe o = new Globe();
            getRhymes(o);
        } else if (generated.equals("GRAND")) {
            Grand o = new Grand();
            getRhymes(o);
        } else if (generated.equals("GUN")) {
            Gun o = new Gun();
            getRhymes(o);
        } else if (generated.equals("HAM")) {
            Ham o = new Ham();
            getRhymes(o);
        } else if (generated.equals("HAMSTER")) {
            Hamster o = new Hamster();
            getRhymes(o);
        } else if (generated.equals("HANGER")) {
            Hanger o = new Hanger();
            getRhymes(o);
        } else if (generated.equals("HAPPY")) {
            Happy o = new Happy();
            getRhymes(o);
        } else if (generated.equals("HASSLE")) {
            Hassle o = new Hassle();
            getRhymes(o);
        } else if (generated.equals("HEAT")) {
            Heat o = new Heat();
            getRhymes(o);
        } else if (generated.equals("HILL")) {
            Hill o = new Hill();
            getRhymes(o);
        } else if (generated.equals("HOBBY")) {
            Hobby o = new Hobby();
            getRhymes(o);
        } else if (generated.equals("HOOP")) {
            Hoop o = new Hoop();
            getRhymes(o);
        } else if (generated.equals("HOUSE")) {
            House o = new House();
            getRhymes(o);
        } else if (generated.equals("IDENTITY")) {
            Identity o = new Identity();
            getRhymes(o);
        } else if (generated.equals("IT")) {
            It o = new It();
            getRhymes(o);
        } else if (generated.equals("JET")) {
            Jet o = new Jet();
            getRhymes(o);
        } else if (generated.equals("JUG")) {
            Jug o = new Jug();
            getRhymes(o);
        } else if (generated.equals("JURY")) {
            Jury o = new Jury();
            getRhymes(o);
        } else if (generated.equals("KITTEN")) {
            Kitten o = new Kitten();
            getRhymes(o);
        } else if (generated.equals("LADY")) {
            Lady o = new Lady();
            getRhymes(o);
        } else if (generated.equals("LAKE")) {
            Lake o = new Lake();
            getRhymes(o);
        } else if (generated.equals("LESSON")) {
            Lesson o = new Lesson();
            getRhymes(o);
        } else if (generated.equals("LEVEL")) {
            Level o = new Level();
            getRhymes(o);
        } else if (generated.equals("LIFE")) {
            Life o = new Life();
            getRhymes(o);
        } else if (generated.equals("LOOM")) {
            Loom o = new Loom();
            getRhymes(o);
        } else if (generated.equals("MAPLE")) {
            Maple o = new Maple();
            getRhymes(o);
        } else if (generated.equals("MARK")) {
            Mark o = new Mark();
            getRhymes(o);
        } else if (generated.equals("MARS")) {
            Mars o = new Mars();
            getRhymes(o);
        } else if (generated.equals("MASH")) {
            Mash o = new Mash();
            getRhymes(o);
        } else if (generated.equals("MASK")) {
            Mask o = new Mask();
            getRhymes(o);
        } else if (generated.equals("MESS")) {
            Mess o = new Mess();
            getRhymes(o);
        } else if (generated.equals("MINT")) {
            Mint o = new Mint();
            getRhymes(o);
        } else if (generated.equals("NECK")) {
            Neck o = new Neck();
            getRhymes(o);
        } else if (generated.equals("NERD")) {
            Nerd o = new Nerd();
            getRhymes(o);
        } else if (generated.equals("NIBBLE")) {
            Nibble o = new Nibble();
            getRhymes(o);
        } else if (generated.equals("NOODLE")) {
            Noodle o = new Noodle();
            getRhymes(o);
        } else if (generated.equals("NUMBER")) {
            com.mikemilla.wordnerd.words.Number o = new Number();
            getRhymes(o);
        } else if (generated.equals("OVER")) {
            Over o = new Over();
            getRhymes(o);
        } else if (generated.equals("PANTS")) {
            Pants o = new Pants();
            getRhymes(o);
        } else if (generated.equals("PARK")) {
            Park o = new Park();
            getRhymes(o);
        } else if (generated.equals("PARTY")) {
            Party o = new Party();
            getRhymes(o);
        } else if (generated.equals("PEARL")) {
            Pearl o = new Pearl();
            getRhymes(o);
        } else if (generated.equals("PERRY")) {
            Perry o = new Perry();
            getRhymes(o);
        } else if (generated.equals("PHONE")) {
            Phone o = new Phone();
            getRhymes(o);
        } else if (generated.equals("PINK")) {
            Pink o = new Pink();
            getRhymes(o);
        } else if (generated.equals("PISTOL")) {
            Pistol o = new Pistol();
            getRhymes(o);
        } else if (generated.equals("POCKET")) {
            Pocket o = new Pocket();
            getRhymes(o);
        } else if (generated.equals("POINT")) {
            Point o = new Point();
            getRhymes(o);
        } else if (generated.equals("PORT")) {
            Port o = new Port();
            getRhymes(o);
        } else if (generated.equals("POSTER")) {
            Poster o = new Poster();
            getRhymes(o);
        } else if (generated.equals("PRINCESS")) {
            Princess o = new Princess();
            getRhymes(o);
        } else if (generated.equals("PRO")) {
            Pro o = new Pro();
            getRhymes(o);
        } else if (generated.equals("PURPLE")) {
            Purple o = new Purple();
            getRhymes(o);
        } else if (generated.equals("QUILT")) {
            Quilt o = new Quilt();
            getRhymes(o);
        } else if (generated.equals("QUIZ")) {
            Quiz o = new Quiz();
            getRhymes(o);
        } else if (generated.equals("RATED")) {
            Rated o = new Rated();
            getRhymes(o);
        } else if (generated.equals("RAY")) {
            Ray o = new Ray();
            getRhymes(o);
        } else if (generated.equals("RAZOR")) {
            Razor o = new Razor();
            getRhymes(o);
        } else if (generated.equals("REASON")) {
            Reason o = new Reason();
            getRhymes(o);
        } else if (generated.equals("RESTART")) {
            Restart o = new Restart();
            getRhymes(o);
        } else if (generated.equals("RIDE")) {
            Ride o = new Ride();
            getRhymes(o);
        } else if (generated.equals("RIM")) {
            Rim o = new Rim();
            getRhymes(o);
        } else if (generated.equals("RING")) {
            Ring o = new Ring();
            getRhymes(o);
        } else if (generated.equals("ROSE")) {
            Rose o = new Rose();
            getRhymes(o);
        } else if (generated.equals("RUDDER")) {
            Rudder o = new Rudder();
            getRhymes(o);
        } else if (generated.equals("SADDLE")) {
            Saddle o = new Saddle();
            getRhymes(o);
        } else if (generated.equals("SCOOT")) {
            Scoot o = new Scoot();
            getRhymes(o);
        } else if (generated.equals("SENSE")) {
            Sense o = new Sense();
            getRhymes(o);
        } else if (generated.equals("SEVEN")) {
            Seven o = new Seven();
            getRhymes(o);
        } else if (generated.equals("SEVERE")) {
            Severe o = new Severe();
            getRhymes(o);
        } else if (generated.equals("SHARP")) {
            Sharp o = new Sharp();
            getRhymes(o);
        } else if (generated.equals("SHELL")) {
            Shell o = new Shell();
            getRhymes(o);
        } else if (generated.equals("SLIDE")) {
            Slide o = new Slide();
            getRhymes(o);
        } else if (generated.equals("SLIM")) {
            Slim o = new Slim();
            getRhymes(o);
        } else if (generated.equals("SMART")) {
            Smart o = new Smart();
            getRhymes(o);
        } else if (generated.equals("SNORE")) {
            Snore o = new Snore();
            getRhymes(o);
        } else if (generated.equals("SOFA")) {
            Sofa o = new Sofa();
            getRhymes(o);
        } else if (generated.equals("SONG")) {
            Song o = new Song();
            getRhymes(o);
        } else if (generated.equals("SPROUT")) {
            Sprout o = new Sprout();
            getRhymes(o);
        } else if (generated.equals("SUGAR")) {
            Sugar o = new Sugar();
            getRhymes(o);
        } else if (generated.equals("TAIL")) {
            Tail o = new Tail();
            getRhymes(o);
        } else if (generated.equals("TANK")) {
            Tank o = new Tank();
            getRhymes(o);
        } else if (generated.equals("TASK")) {
            Task o = new Task();
            getRhymes(o);
        } else if (generated.equals("TATTLE")) {
            Tattle o = new Tattle();
            getRhymes(o);
        } else if (generated.equals("TATTOO")) {
            Tattoo o = new Tattoo();
            getRhymes(o);
        } else if (generated.equals("TEA")) {
            Tea o = new Tea();
            getRhymes(o);
        } else if (generated.equals("THANKS")) {
            Thanks o = new Thanks();
            getRhymes(o);
        } else if (generated.equals("THIRTY")) {
            Thirty o = new Thirty();
            getRhymes(o);
        } else if (generated.equals("TRUCK")) {
            Truck o = new Truck();
            getRhymes(o);
        } else if (generated.equals("TUBE")) {
            Tube o = new Tube();
            getRhymes(o);
        } else if (generated.equals("TUSK")) {
            Tusk o = new Tusk();
            getRhymes(o);
        } else if (generated.equals("TUX")) {
            Tux o = new Tux();
            getRhymes(o);
        } else if (generated.equals("TWILIGHT")) {
            Twilight o = new Twilight();
            getRhymes(o);
        } else if (generated.equals("VASE")) {
            Vase o = new Vase();
            getRhymes(o);
        } else if (generated.equals("VINE")) {
            Vine o = new Vine();
            getRhymes(o);
        } else if (generated.equals("WAR")) {
            War o = new War();
            getRhymes(o);
        } else if (generated.equals("WATER")) {
            Water o = new Water();
            getRhymes(o);
        } else if (generated.equals("WAVE")) {
            Wave o = new Wave();
            getRhymes(o);
        } else if (generated.equals("WEST")) {
            West o = new West();
            getRhymes(o);
        } else if (generated.equals("WIN")) {
            Win o = new Win();
            getRhymes(o);
        } else if (generated.equals("WIRE")) {
            Wire o = new Wire();
            getRhymes(o);
        } else if (generated.equals("WITCH")) {
            Witch o = new Witch();
            getRhymes(o);
        } else if (generated.equals("WITHOUT")) {
            Without o = new Without();
            getRhymes(o);
        } else if (generated.equals("WORD")) {
            Word o = new Word();
            getRhymes(o);
        }
    }

    /**
     * Interface the lists containing the syllable amounts in each Word Object
     */
    private void getRhymes(Syllables i) {
        singles = i.getSingleSyllables();
        doubles = i.getDoubleSyllables();
        triples = i.getTripleSyllables();
        quadruples = i.getQuadrupleSyllables();
        quintuples = i.getQuintupleSyllables();
        sextuples = i.getSextupleSyllables();
    }

    /**
     * Check the hashedRhymes size to change Timer time
     * Advance the generated word 1 and animate flip change
     */
    private void advanceWordList() {

        /*

        if (hashedRhymes.size() > 9) {
            time = 5000;
        }
        if (hashedRhymes.size() > 19) {
            time = 4000;
        }

        */
        /*
        if (points > 9) {
            time = 5000;
        }
        /*
        if (points > 19) {
            time = 4000;
        }

        //if (hashedRhymes.size() > 29) {
        //time = 3000;
        //}

        //amount = 4;

        /*

        amount = random.nextInt((3 - 1) + 1) + 1;
        amountNeeded.setText("" + amount);

        */

        /* Amount-Random

        amount = 4;

        if (amount <= 1) {
            amountNeeded.setVisibility(View.GONE);
        } else {
            amountNeeded.setVisibility(View.VISIBLE);
        }

        */

        if (points > 0) {
            progressBar.setVisibility(View.VISIBLE);
        }

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(250);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            computerRhyme.setText(words.get(order++));
                            //computerRhyme.startAnimation(flipInAnimation);
                            computerRhyme.startAnimation(slideInLeft);
                            resetLibrary();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.start();
    }

    /**
     * Check the the user entered word matches anything
     */
    private void crunchTheWord() {
        /**
         * Get text of user word and generated word
         */
        rhymedWord = userRhyme.getText().toString().toUpperCase();
        generatedWord = computerRhyme.getText().toString().toUpperCase();

        /**
         * Animate dots if nothing is entered
         */
        if (rhymedWord.length() == 0) {
            userRhyme.setBackgroundResource(R.drawable.dots_animation);
            dotsAnimation = (AnimationDrawable) userRhyme.getBackground();
            dotsAnimation.start();
        }

        /**
         * If at least one character is entered remove the dots and show cursor
         */
        if (rhymedWord.length() > 0) {
            userRhyme.setBackgroundColor(Color.WHITE);
            userRhyme.setCursorVisible(true);

            /**
             * If the entered word matches the generated word or it has already been played:
             *      Shake (if equals generated word)
             *      Play sound
             *      Clear the text
             */
            if (generatedWord.equals(rhymedWord) || hashedRhymes.contains(rhymedWord)) {
                if (!("(BE|DE|PRE|DIS|NON|PRO|INT|" +
                        "OUT|MIS|SUB|ANT|COM|TRA|PAR|" +
                        "SUP|RES|PER|REC|CAR|FOR|CHA|" +
                        "IMP|TRI|STR|UND|COU|REP|HYP|" +
                        "STA|DEC|BAR|AIR|ISO|SUN|SEA|" +
                        "MID|GEO|MAL|UNS|DIA|SUR|RED|" +
                        "BIO|FLU|FRO|HATE|GO|DOWN|SHIT)").matches(rhymedWord)
                        ) {
                    userRhyme.startAnimation(shakeAnimation);
                    if (soundToggle.isChecked()) {
                        soundPool.play(duplicateSound, 1, 1, 0, 0, 1);
                    }
                    if (hashedRhymes.contains(rhymedWord)) {
                        userRhyme.setText(null);
                    }
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            userRhyme.setText(null);
                        }
                    }, 300);
                }
            }
            /**
             * Check the amount of syllables the word has and give respectable amount of points
             * Then, advance to the next word
             */
            else if (singles.contains(rhymedWord)) {
                points += 1;
                correctAnswer();
            } else if (doubles.contains(rhymedWord)) {
                points += 2;
                correctAnswer();
            } else if (triples.contains(rhymedWord)) {
                points += 3;
                correctAnswer();
            } else if (quadruples.contains(rhymedWord)) {
                points += 4;
                correctAnswer();
            } else if (quintuples.contains(rhymedWord)) {
                points += 5;
                correctAnswer();
            } else if (sextuples.contains(rhymedWord)) {
                /**
                 * If the word is a "Mega" word, add more points
                 */
                if (rhymedWord.equals("RADIOACTIVITY")
                        || rhymedWord.equals("UNDERSTANDABILITY")
                        || rhymedWord.equals("UNAVAILABILITY")
                        || rhymedWord.equals("PERPENDICULARITY")) {
                    points += 7;
                } else {
                    points += 6;
                }
                correctAnswer();
            }

        }
        /**
         * Don't show cursor if nothing is entered
         */
        else {
            userRhyme.setCursorVisible(false);
        }
    }

    /**
     * Method run if the answer was accepted
     */
    private void correctAnswer() {
        /**
         * Stop and Restart timer
         */
        counter.cancel();
        runTimer();

        /**
         * Add rhymes to the hashed list
         */
        hashedRhymes.add(rhymedWord);

        /**
         * Unlock Achievements for rhymes in a game
         */

        /*
        if (mGoogleApiClient.isConnected()) {
            if (hashedRhymes.size() == 1) {
                Games.Achievements.unlock(mGoogleApiClient, "achievement_rhyme_time");
            }

            if (points >= 40) {
                Games.Achievements.unlock(mGoogleApiClient, "achievement_forty_story");
            }
            else if (points >= 30) {
                Games.Achievements.unlock(mGoogleApiClient, "achievement_dirty_thirty");
            }
            else if (points >= 20) {
                Games.Achievements.unlock(mGoogleApiClient, "achievement_plenty_twenty");
            }
            else if (points >= 10) {
                Games.Achievements.unlock(mGoogleApiClient, "achievement_decade_parade");
            }
        }

        /* Amount-Random

        amount -= 1;
        amountNeeded.setText("" + amount);

        if (amount <= 0) {
            computerRhyme.startAnimation(flipOutAnimation);
            advanceWordList();
        }

        */

        //computerRhyme.startAnimation(flipOutAnimation);
        computerRhyme.startAnimation(slideOutLeft);
        advanceWordList();

        /**
         * Clear UserRhyme EditText
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                userRhyme.setText(null);
            }
        }, 150);

        /**
         * Show points as the new score
         */
        score.setText("" + points);
        finalScore.setText("" + points);

        /**
         * Reset progress bar
         */
        progressBar.setProgress(100);
        animation = ObjectAnimator.ofInt(progressBar, "progress", progress);
        animation.setDuration(time);
        animation.setInterpolator(new LinearInterpolator());
        animation.start();

        /**
         * Check if sound is enabled
         */
        if (soundToggle.isChecked()) {
            soundPool.play(correctSound, 1, 1, 0, 0, 1);
        }
    }

    private void gameOver() {
        //int newBest = newScore;

        Log.d(TAG, "" + hashedRhymes);

        userRhyme.setText(null);

        finalScore.setText("" + points);

        if (points > oldBest) {
            editor.putInt("newScore", points);
            editor.apply();
            bestScore.setText("" + points);
            Toast.makeText(getActivity(), "New Best MOFKER!", Toast.LENGTH_LONG).show();
        }

    }

    public void setListener(Listener l) {
        mListener = l;
    }

    /**
     * Method run when the user pressed the back button (After Down Arrow)
     */
    /*

    @Override
    public void onBackPressed() {
        super.onPause();
        userRhyme.requestFocus();
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(userRhyme, InputMethodManager.SHOW_IMPLICIT);
    }

    */
    @Override
    public void onStart() {
        super.onStart();

        counterRunning = false;
        firstLoad = true;

        GameFragmentOld.userRhyme.setText(null);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        final int height = displaymetrics.heightPixels;

        /*
        if (AndroidBug5497Workaround.usableHeightPrevious == height) {
            userRhyme.postDelayed(new Runnable() {
                @Override
                public void run() {
                    InputMethodManager keyboard = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.showSoftInput(userRhyme, 0);
                }
            }, 50);
        }
        */

        updateUi();
    }

    @Override
    public void onResume() {
        super.onResume();

        userRhyme.postDelayed(new Runnable() {
            @Override
            public void run() {
                InputMethodManager keyboard = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(userRhyme, 0);
            }
        }, 50);

        updateUi();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.restart_game:

                scoreCard.setVisibility(View.GONE);
                imm.showSoftInput(userRhyme, 0);

                userRhyme.setText(null);
                points = 0;
                score.setText(null);
                progressBar.setVisibility(View.GONE);
                hashedRhymes.clear();

                scoreCard.startAnimation(slideDownOutAnimation);

                computerRhyme.setText(words.get(order++));
                computerRhyme.startAnimation(flipInAnimation);
                computerRhyme.startAnimation(slideInLeft);

                runLibrary();
                resetLibrary();

                randomBackgroundColor();

                firstLoad = false;

                break;
            case R.id.main_menu:

                soundToggle.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);
                score.setVisibility(View.GONE);
                rhymeArea.setVisibility(View.GONE);
                computerRhyme.setVisibility(View.GONE);
                scoreCard.startAnimation(slideDownOutAnimation);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mListener.onScoreScreenDismissed();
                        imm.hideSoftInputFromWindow(GameFragmentOld.userRhyme.getWindowToken(), 0);
                    }
                }, 300);
                break;
        }
    }

    public void randomBackgroundColor() {
        Random random = new Random();
        int randomColor = random.nextInt((12 - 1) + 1) + 1;

        switch (randomColor) {
            case 1:
                mother.setBackgroundColor(getResources().getColor(R.color.indigo));
                break;
            case 2:
                mother.setBackgroundColor(getResources().getColor(R.color.pink));
                break;
            case 3:
                mother.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            case 4:
                mother.setBackgroundColor(getResources().getColor(R.color.teal));
                break;
            case 5:
                mother.setBackgroundColor(getResources().getColor(R.color.purple));
                break;
            case 6:
                mother.setBackgroundColor(getResources().getColor(R.color.deep_purple));
                break;
            case 7:
                mother.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
            case 8:
                mother.setBackgroundColor(getResources().getColor(R.color.light_blue));
                break;
            case 9:
                mother.setBackgroundColor(getResources().getColor(R.color.cyan));
                break;
            case 10:
                mother.setBackgroundColor(getResources().getColor(R.color.green));
                break;
            case 11:
                mother.setBackgroundColor(getResources().getColor(R.color.orange));
                break;
            case 12:
                mother.setBackgroundColor(getResources().getColor(R.color.blue_grey));
                break;
        }
    }

    /*

    @Override
    public void onPause() {
        super.onPause();
        if (counterRunning = false) {
            imm.hideSoftInputFromWindow(GameFragment.userRhyme.getWindowToken(), 0);
        }
    }

    */

    void updateUi() {
        if (getActivity() == null) return;
    }

}
