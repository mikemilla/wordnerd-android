package com.mikemilla.wordnerd;

import android.animation.ObjectAnimator;
import android.app.Activity;
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
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.mikemilla.wordnerd.words.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class MainActivity extends Activity implements View.OnClickListener {

    /**
     * Primitives
     */
    int order = 0;
    long time = 6000;
    boolean counterRunning;
    boolean firstLoad = true;
    int correctSound, duplicateSound, gameOverSound, points, progress, best, oldBest;

    /**
     * Views
     */
    EditText userRhyme;
    ImageButton playGames;
    ProgressBar mTimerBar;
    ImageButton restart, mainMenu;
    RelativeLayout mother, rhymeContainer;
    LinearLayout mainScreen, gameScreen, scoreScreen, rhymeArea;
    TextView finalScore, bestText, bestScore, computerRhyme, currentScore, nerd, tap, gameOver, syllablesText;

    /**
     * Lists and Strings
     */
    HashSet<String> hashedRhymes;
    final String TAG = "WordNerd";
    String rhymedWord, generatedWord;
    ArrayList<String> singles, doubles, triples, quadruples, quintuples, sextuples, words, rhymesPlayed;

    /**
     * Animations
     */
    ObjectAnimator animation;
    AnimationDrawable dotsAnimation;
    Animation shakeAnimation, slideDownOutAnimation, slideUpInAnimation, slideInLeft, slideOutLeft, fadeIn, fadeOut, slideLeft, slideRight;

    /**
     * Other
     */
    Typeface font;
    SoundPool soundPool;
    CountDownTimer counter;
    InputMethodManager imm;
    SharedPreferences prefs;
    //ToggleButton soundToggle;
    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;
    GoogleApiClient mGoogleApiClient;

    Handler handler = new Handler();

    /*
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            tap.setText("rhyme with the words");
            tap.startAnimation(fadeIn);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    tap.startAnimation(fadeOut);
                }
            }, 2000);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    tap.setText("tap to play");
                    tap.startAnimation(fadeIn);
                }
            }, 2400);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    tap.startAnimation(fadeOut);
                }
            }, 4400);
            if (tapShowing) {
                startLoops();
            }
        }
    };
    */

    public int color;
    private boolean DEBUG = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enitirety);

        /**
         * Assist the app with the fullscreen fix
         */
        AndroidBug5497Workaround.assistActivity(this);

        /**
         * Run the loading, styling, and running methods
         */

        /**
         * Style Sound Button
         */
        //soundToggle = (ToggleButton) findViewById(R.id.sound);
        //soundToggle.setText(null);
        //soundToggle.setTextOn(null);
        //soundToggle.setTextOff(null);

        prefs = getSharedPreferences("com.mikemilla.wordnerd", Context.MODE_PRIVATE);
        editor = prefs.edit();
        editor.apply();

        /**
         * @return soundToggle state (ON/OFF)
         */
        sharedPrefs = getSharedPreferences("com.mikemilla.wordnerd", Context.MODE_PRIVATE);
        //soundToggle.setChecked(sharedPrefs.getBoolean("toggleState", true));

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        /**
         * Reset score
         */
        points = 0;
        //random = new Random();

        /**
         * Instantiate Views
         */
        rhymeArea = (LinearLayout) findViewById(R.id.rhyme_area);
        rhymeContainer = (RelativeLayout) findViewById(R.id.rhyme_container);

        mTimerBar = (ProgressBar) findViewById(R.id.progress_bar);
        //soundToggle = (ToggleButton) v.findViewById(R.id.sound);

        restart = (ImageButton) findViewById(R.id.restart_game);
        mainMenu = (ImageButton) findViewById(R.id.main_menu);

        currentScore = (TextView) findViewById(R.id.current_score);
        computerRhyme = (TextView) findViewById(R.id.rhyme_with);
        finalScore = (TextView) findViewById(R.id.final_score);
        bestText = (TextView) findViewById(R.id.best_text);
        bestScore = (TextView) findViewById(R.id.best_score);
        nerd = (TextView) findViewById(R.id.nerd);
        tap = (TextView) findViewById(R.id.tap);

        userRhyme = (EditText) findViewById(R.id.submit_rhyme);

        /**
         * Load Sounds
         */
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        correctSound = soundPool.load(this, R.raw.correct_sound, 1);
        duplicateSound = soundPool.load(this, R.raw.duplicate_sound, 2);
        gameOverSound = soundPool.load(this, R.raw.gameover_sound, 3);

        mainScreen = (LinearLayout) findViewById(R.id.main);
        mainScreen.setOnClickListener(this);

        gameScreen = (LinearLayout) findViewById(R.id.game);
        gameScreen.setOnClickListener(this);

        scoreScreen = (LinearLayout) findViewById(R.id.score);
        scoreScreen.setOnClickListener(this);

        /**
         * Load Animations
         */
        userRhyme.setBackgroundResource(R.drawable.dots_animation);
        shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        //flipInAnimation = AnimationUtils.loadAnimation(this, R.anim.flip_in);
        //flipOutAnimation = AnimationUtils.loadAnimation(this, R.anim.flip_out);
        slideLeft = AnimationUtils.loadAnimation(this, R.anim.slide_left);
        slideRight = AnimationUtils.loadAnimation(this, R.anim.slide_right);
        dotsAnimation = (AnimationDrawable) userRhyme.getBackground();
        dotsAnimation.start();

        //slideUpOutAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        slideUpInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_up);
        slideDownOutAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_down_out);
        slideInLeft = AnimationUtils.loadAnimation(this, R.anim.slide_up_in);
        slideOutLeft = AnimationUtils.loadAnimation(this, R.anim.slide_up_out);

        playGames = (ImageButton) findViewById(R.id.play_games);
        playGames.setOnClickListener(this);

        //scaleBig = AnimationUtils.loadAnimation(this, R.anim.scale_big);

        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);

        /**
         * Style Send Button
         */
        userRhyme.setImeActionLabel("CLEAR", EditorInfo.IME_ACTION_SEND);

        /**
         * Set Fonts
         */
        font = Typeface.createFromAsset(this.getAssets(), "fonts/VarelaRound.otf");
        currentScore.setTypeface(font, Typeface.BOLD);
        userRhyme.setTypeface(font, Typeface.BOLD);
        computerRhyme.setTypeface(font, Typeface.BOLD);
        userRhyme.setCursorVisible(false);

        mother = (RelativeLayout) findViewById(R.id.mother);

        gameOver = (TextView) findViewById(R.id.game_over);
        syllablesText = (TextView) findViewById(R.id.syllables_text);

        nerd.setTypeface(font, Typeface.BOLD);
        tap.setTypeface(font, Typeface.BOLD);
        bestText.setTypeface(font, Typeface.BOLD);
        bestScore.setTypeface(font, Typeface.BOLD);
        finalScore.setTypeface(font, Typeface.BOLD);
        gameOver.setTypeface(font, Typeface.BOLD);
        syllablesText.setTypeface(font, Typeface.BOLD);

        /**
         * Instantiate Lists
         */
        rhymesPlayed = new ArrayList<>();
        hashedRhymes = new HashSet<>();

        oldBest = prefs.getInt("newScore", best);
        bestScore.setText("" + oldBest);

        if (firstLoad) {
            //soundToggle.startAnimation(slideInLeft);
            computerRhyme.startAnimation(slideInLeft);
        }

        findViewById(R.id.main_menu).setOnClickListener(this);
        restart.setOnClickListener(this);

        //startLoops();
        runIntroLoop(true);
        getNerdy();

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
        userRhyme.addTextChangedListener(new TextWatcher() {
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
        });
    }

    /*
    public void stopLoops() {
        tapShowing = false;
        handler.removeCallbacks(runnable);
    }

    public void startLoops() {
        tapShowing = true;
        handler.postDelayed(runnable, 4800);
    }
    */

    /**
     * Load elements and style them
     * Prepare timer, but don't run it
     * Load the library
     * Reset the library to find generated Word
     */

    public void getNerdy() {
        runTimer();
        mLoadLibrary();
        mReloadLibrary();
    }

    /**
     * Run Countdown Timer
     */
    public void runTimer() {
        counter = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                counterRunning = true;

                /**
                 * Set ProgressBar to the Progress on ticks
                 */
                progress = (int) (millisUntilFinished / 1000);
                mTimerBar.setProgress(progress);
            }

            @Override
            public void onFinish() {

                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(250);

                counterRunning = false;

                /**
                 * Set ProgressBar to 0 or Done
                 */
                mTimerBar.setProgress(0);

                /**
                 * Check is sound is enabled
                 */
                /*
                if (soundToggle.isChecked()) {
                    soundPool.play(gameOverSound, 1, 1, 0, 0, 1);
                }
                */

                /**
                 * Slide Up Animation Listener
                 */
                scoreScreen.setVisibility(View.VISIBLE);
                scoreScreen.startAnimation(slideUpInAnimation);
                slideUpInAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        /*
                         * Show the Score GUI
                         */
                        scoreScreen.setVisibility(View.VISIBLE);
                        gameOver();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
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
    private void mLoadLibrary() {

        counter.cancel();

        words = new ArrayList<>();
        words.add("about");
        words.add("amber");
        words.add("amount");
        words.add("art");
        words.add("ask");
        words.add("attracts");
        words.add("banks");
        words.add("bark");
        words.add("battle");
        words.add("bib");
        words.add("books");
        words.add("brand");
        words.add("break");
        words.add("bubble");
        words.add("built");
        words.add("bull");
        words.add("bus");
        words.add("cable");
        words.add("cake");
        words.add("camper");
        words.add("cash");
        words.add("castle");
        words.add("chart");
        words.add("coal");
        words.add("cold");
        words.add("chick");
        words.add("circularity");
        words.add("city");
        words.add("court");
        words.add("cranks");
        words.add("crib");
        words.add("crooks");
        words.add("cruise");
        words.add("cup");
        words.add("damper");
        words.add("deal");
        words.add("demand");
        words.add("device");
        words.add("direction");
        words.add("dirt");
        words.add("discuss");
        words.add("dog");
        words.add("donate");
        words.add("dope");
        words.add("doubt");
        words.add("down");
        words.add("drama");
        words.add("embark");
        words.add("face");
        words.add("fact");
        words.add("fall");
        words.add("farm");
        words.add("flask");
        words.add("flow");
        words.add("funk");
        words.add("funny");
        words.add("game");
        words.add("gas");
        words.add("gate");
        words.add("glamour");
        words.add("globe");
        words.add("glove");
        words.add("gate");
        words.add("ham");
        words.add("hamster");
        words.add("grand");
        words.add("gun");
        words.add("hanger");
        words.add("happy");
        words.add("heat");
        words.add("hill");
        words.add("hobby");
        words.add("hoop");
        words.add("house");
        words.add("identity");
        words.add("it");
        words.add("jet");
        words.add("jury");
        words.add("kitten");
        words.add("lady");
        words.add("lake");
        words.add("lesson");
        words.add("level");
        words.add("life");
        words.add("loom");
        words.add("maple");
        words.add("mark");
        words.add("mars");
        words.add("mash");
        words.add("mask");
        words.add("mess");
        words.add("mint");
        words.add("neck");
        words.add("nerd");
        words.add("nibble");
        words.add("noodle");
        words.add("number");
        words.add("over");
        words.add("pants");
        words.add("park");
        words.add("party");
        words.add("pearl");
        words.add("perry");
        words.add("phone");
        words.add("pink");
        words.add("pistol");
        words.add("pocket");
        words.add("point");
        words.add("port");
        words.add("poster");
        words.add("princess");
        words.add("pro");
        words.add("purple");
        words.add("quilt");
        words.add("quiz");
        words.add("rated");
        words.add("ray");
        words.add("razor");
        words.add("reason");
        words.add("restart");
        words.add("ride");
        words.add("rim");
        words.add("ring");
        words.add("rose");
        words.add("rudder");
        words.add("saddle");
        words.add("scoot");
        words.add("sense");
        words.add("seven");
        words.add("severe");
        words.add("sharp");
        words.add("shell");
        words.add("slide");
        words.add("slim");
        words.add("smart");
        words.add("snore");
        words.add("sofa");
        words.add("song");
        words.add("sprout");
        words.add("sugar");
        words.add("tail");
        words.add("tank");
        words.add("task");
        words.add("tattle");
        words.add("tattoo");
        words.add("tea");
        words.add("thanks");
        words.add("thirty");
        words.add("truck");
        words.add("tube");
        words.add("tusk");
        words.add("tux");
        words.add("twilight");
        words.add("vase");
        words.add("vine");
        words.add("war");
        words.add("water");
        words.add("wave");
        words.add("west");
        words.add("win");
        words.add("wire");
        words.add("witch");
        words.add("without");
        words.add("word");

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
    private void mReloadLibrary() {
        String generated = computerRhyme.getText().toString();

        if (generated.equals("about")) {
            /**
             * Open a new Object containing the accepted rhymes
             */
            About o = new About();
            /**
             * Get the rhymes of that Object & Check syllable lengths
             */
            getRhymes(o);
        } else if (generated.equals("amber")) {
            Amber o = new Amber();
            getRhymes(o);
        } else if (generated.equals("amount")) {
            Amount o = new Amount();
            getRhymes(o);
        } else if (generated.equals("art")) {
            Art o = new Art();
            getRhymes(o);
        } else if (generated.equals("attracts")) {
            Attracts o = new Attracts();
            getRhymes(o);
        } else if (generated.equals("ask")) {
            Ask o = new Ask();
            getRhymes(o);
        } else if (generated.equals("banks")) {
            Banks o = new Banks();
            getRhymes(o);
        } else if (generated.equals("bark")) {
            Bark o = new Bark();
            getRhymes(o);
        } else if (generated.equals("battle")) {
            Battle o = new Battle();
            getRhymes(o);
        } else if (generated.equals("bib")) {
            Bib o = new Bib();
            getRhymes(o);
        } else if (generated.equals("books")) {
            Books o = new Books();
            getRhymes(o);
        } else if (generated.equals("brand")) {
            Brand o = new Brand();
            getRhymes(o);
        } else if (generated.equals("break")) {
            Break o = new Break();
            getRhymes(o);
        } else if (generated.equals("bubble")) {
            Bubble o = new Bubble();
            getRhymes(o);
        } else if (generated.equals("built")) {
            Built o = new Built();
            getRhymes(o);
        } else if (generated.equals("bull")) {
            Bull o = new Bull();
            getRhymes(o);
        } else if (generated.equals("bus")) {
            Bus o = new Bus();
            getRhymes(o);
        } else if (generated.equals("cable")) {
            Cable o = new Cable();
            getRhymes(o);
        } else if (generated.equals("cake")) {
            Cake o = new Cake();
            getRhymes(o);
        } else if (generated.equals("camper")) {
            Camper o = new Camper();
            getRhymes(o);
        } else if (generated.equals("cash")) {
            Cash o = new Cash();
            getRhymes(o);
        } else if (generated.equals("castle")) {
            Castle o = new Castle();
            getRhymes(o);
        } else if (generated.equals("chart")) {
            Chart o = new Chart();
            getRhymes(o);
        } else if (generated.equals("coal")) {
            Coal o = new Coal();
            getRhymes(o);
        } else if (generated.equals("cold")) {
            Cold o = new Cold();
            getRhymes(o);
        } else if (generated.equals("chick")) {
            Chick o = new Chick();
            getRhymes(o);
        } else if (generated.equals("circularity")) {
            Circularity o = new Circularity();
            getRhymes(o);
        } else if (generated.equals("city")) {
            City o = new City();
            getRhymes(o);
        } else if (generated.equals("court")) {
            Court o = new Court();
            getRhymes(o);
        } else if (generated.equals("cruise")) {
            Cruise o = new Cruise();
            getRhymes(o);
        } else if (generated.equals("cranks")) {
            Cranks o = new Cranks();
            getRhymes(o);
        } else if (generated.equals("crib")) {
            Crib o = new Crib();
            getRhymes(o);
        } else if (generated.equals("crooks")) {
            Crooks o = new Crooks();
            getRhymes(o);
        } else if (generated.equals("cup")) {
            Cup o = new Cup();
            getRhymes(o);
        } else if (generated.equals("damper")) {
            Damper o = new Damper();
            getRhymes(o);
        } else if (generated.equals("deal")) {
            Deal o = new Deal();
            getRhymes(o);
        } else if (generated.equals("demand")) {
            Demand o = new Demand();
            getRhymes(o);
        } else if (generated.equals("device")) {
            Device o = new Device();
            getRhymes(o);
        } else if (generated.equals("direction")) {
            Direction o = new Direction();
            getRhymes(o);
        } else if (generated.equals("dirt")) {
            Dirt o = new Dirt();
            getRhymes(o);
        } else if (generated.equals("discuss")) {
            Discuss o = new Discuss();
            getRhymes(o);
        } else if (generated.equals("dog")) {
            Dog o = new Dog();
            getRhymes(o);
        } else if (generated.equals("donate")) {
            Donate o = new Donate();
            getRhymes(o);
        } else if (generated.equals("dope")) {
            Dope o = new Dope();
            getRhymes(o);
        } else if (generated.equals("doubt")) {
            Doubt o = new Doubt();
            getRhymes(o);
        } else if (generated.equals("down")) {
            Down o = new Down();
            getRhymes(o);
        } else if (generated.equals("drama")) {
            Drama o = new Drama();
            getRhymes(o);
        } else if (generated.equals("embark")) {
            Embark o = new Embark();
            getRhymes(o);
        } else if (generated.equals("fall")) {
            Fall o = new Fall();
            getRhymes(o);
        } else if (generated.equals("face")) {
            Face o = new Face();
            getRhymes(o);
        } else if (generated.equals("fact")) {
            Fact o = new Fact();
            getRhymes(o);
        } else if (generated.equals("farm")) {
            Farm o = new Farm();
            getRhymes(o);
        } else if (generated.equals("flask")) {
            Flask o = new Flask();
            getRhymes(o);
        } else if (generated.equals("flow")) {
            Flow o = new Flow();
            getRhymes(o);
        } else if (generated.equals("funk")) {
            Funk o = new Funk();
            getRhymes(o);
        } else if (generated.equals("funny")) {
            Funny o = new Funny();
            getRhymes(o);
        } else if (generated.equals("game")) {
            Game o = new Game();
            getRhymes(o);
        } else if (generated.equals("gas")) {
            Gas o = new Gas();
            getRhymes(o);
        } else if (generated.equals("glove")) {
            Glove o = new Glove();
            getRhymes(o);
        } else if (generated.equals("goat")) {
            Goat o = new Goat();
            getRhymes(o);
        } else if (generated.equals("glamour")) {
            Glamour o = new Glamour();
            getRhymes(o);
        } else if (generated.equals("gate")) {
            Gate o = new Gate();
            getRhymes(o);
        } else if (generated.equals("globe")) {
            Globe o = new Globe();
            getRhymes(o);
        } else if (generated.equals("grand")) {
            Grand o = new Grand();
            getRhymes(o);
        } else if (generated.equals("gun")) {
            Gun o = new Gun();
            getRhymes(o);
        } else if (generated.equals("ham")) {
            Ham o = new Ham();
            getRhymes(o);
        } else if (generated.equals("hamster")) {
            Hamster o = new Hamster();
            getRhymes(o);
        } else if (generated.equals("hanger")) {
            Hanger o = new Hanger();
            getRhymes(o);
        } else if (generated.equals("happy")) {
            Happy o = new Happy();
            getRhymes(o);
        } else if (generated.equals("hassle")) {
            Hassle o = new Hassle();
            getRhymes(o);
        } else if (generated.equals("heat")) {
            Heat o = new Heat();
            getRhymes(o);
        } else if (generated.equals("hill")) {
            Hill o = new Hill();
            getRhymes(o);
        } else if (generated.equals("hobby")) {
            Hobby o = new Hobby();
            getRhymes(o);
        } else if (generated.equals("hoop")) {
            Hoop o = new Hoop();
            getRhymes(o);
        } else if (generated.equals("house")) {
            House o = new House();
            getRhymes(o);
        } else if (generated.equals("identity")) {
            Identity o = new Identity();
            getRhymes(o);
        } else if (generated.equals("it")) {
            It o = new It();
            getRhymes(o);
        } else if (generated.equals("jet")) {
            Jet o = new Jet();
            getRhymes(o);
        } else if (generated.equals("jug")) {
            Jug o = new Jug();
            getRhymes(o);
        } else if (generated.equals("jury")) {
            Jury o = new Jury();
            getRhymes(o);
        } else if (generated.equals("kitten")) {
            Kitten o = new Kitten();
            getRhymes(o);
        } else if (generated.equals("lady")) {
            Lady o = new Lady();
            getRhymes(o);
        } else if (generated.equals("lake")) {
            Lake o = new Lake();
            getRhymes(o);
        } else if (generated.equals("lesson")) {
            Lesson o = new Lesson();
            getRhymes(o);
        } else if (generated.equals("level")) {
            Level o = new Level();
            getRhymes(o);
        } else if (generated.equals("life")) {
            Life o = new Life();
            getRhymes(o);
        } else if (generated.equals("loom")) {
            Loom o = new Loom();
            getRhymes(o);
        } else if (generated.equals("maple")) {
            Maple o = new Maple();
            getRhymes(o);
        } else if (generated.equals("mark")) {
            Mark o = new Mark();
            getRhymes(o);
        } else if (generated.equals("mars")) {
            Mars o = new Mars();
            getRhymes(o);
        } else if (generated.equals("mash")) {
            Mash o = new Mash();
            getRhymes(o);
        } else if (generated.equals("mask")) {
            Mask o = new Mask();
            getRhymes(o);
        } else if (generated.equals("mess")) {
            Mess o = new Mess();
            getRhymes(o);
        } else if (generated.equals("mint")) {
            Mint o = new Mint();
            getRhymes(o);
        } else if (generated.equals("neck")) {
            Neck o = new Neck();
            getRhymes(o);
        } else if (generated.equals("nerd")) {
            Nerd o = new Nerd();
            getRhymes(o);
        } else if (generated.equals("nibble")) {
            Nibble o = new Nibble();
            getRhymes(o);
        } else if (generated.equals("noodle")) {
            Noodle o = new Noodle();
            getRhymes(o);
        } else if (generated.equals("number")) {
            com.mikemilla.wordnerd.words.Number o = new com.mikemilla.wordnerd.words.Number();
            getRhymes(o);
        } else if (generated.equals("over")) {
            Over o = new Over();
            getRhymes(o);
        } else if (generated.equals("pants")) {
            Pants o = new Pants();
            getRhymes(o);
        } else if (generated.equals("park")) {
            Park o = new Park();
            getRhymes(o);
        } else if (generated.equals("party")) {
            Party o = new Party();
            getRhymes(o);
        } else if (generated.equals("pearl")) {
            Pearl o = new Pearl();
            getRhymes(o);
        } else if (generated.equals("perry")) {
            Perry o = new Perry();
            getRhymes(o);
        } else if (generated.equals("phone")) {
            Phone o = new Phone();
            getRhymes(o);
        } else if (generated.equals("pink")) {
            Pink o = new Pink();
            getRhymes(o);
        } else if (generated.equals("pistol")) {
            Pistol o = new Pistol();
            getRhymes(o);
        } else if (generated.equals("pocket")) {
            Pocket o = new Pocket();
            getRhymes(o);
        } else if (generated.equals("point")) {
            Point o = new Point();
            getRhymes(o);
        } else if (generated.equals("port")) {
            Port o = new Port();
            getRhymes(o);
        } else if (generated.equals("poster")) {
            Poster o = new Poster();
            getRhymes(o);
        } else if (generated.equals("princess")) {
            Princess o = new Princess();
            getRhymes(o);
        } else if (generated.equals("pro")) {
            Pro o = new Pro();
            getRhymes(o);
        } else if (generated.equals("purple")) {
            Purple o = new Purple();
            getRhymes(o);
        } else if (generated.equals("quilt")) {
            Quilt o = new Quilt();
            getRhymes(o);
        } else if (generated.equals("quiz")) {
            Quiz o = new Quiz();
            getRhymes(o);
        } else if (generated.equals("rated")) {
            Rated o = new Rated();
            getRhymes(o);
        } else if (generated.equals("ray")) {
            Ray o = new Ray();
            getRhymes(o);
        } else if (generated.equals("razor")) {
            Razor o = new Razor();
            getRhymes(o);
        } else if (generated.equals("reason")) {
            Reason o = new Reason();
            getRhymes(o);
        } else if (generated.equals("restart")) {
            Restart o = new Restart();
            getRhymes(o);
        } else if (generated.equals("ride")) {
            Ride o = new Ride();
            getRhymes(o);
        } else if (generated.equals("rim")) {
            Rim o = new Rim();
            getRhymes(o);
        } else if (generated.equals("ring")) {
            Ring o = new Ring();
            getRhymes(o);
        } else if (generated.equals("rose")) {
            Rose o = new Rose();
            getRhymes(o);
        } else if (generated.equals("rudder")) {
            Rudder o = new Rudder();
            getRhymes(o);
        } else if (generated.equals("saddle")) {
            Saddle o = new Saddle();
            getRhymes(o);
        } else if (generated.equals("scoot")) {
            Scoot o = new Scoot();
            getRhymes(o);
        } else if (generated.equals("sense")) {
            Sense o = new Sense();
            getRhymes(o);
        } else if (generated.equals("seven")) {
            Seven o = new Seven();
            getRhymes(o);
        } else if (generated.equals("severe")) {
            Severe o = new Severe();
            getRhymes(o);
        } else if (generated.equals("sharp")) {
            Sharp o = new Sharp();
            getRhymes(o);
        } else if (generated.equals("shell")) {
            Shell o = new Shell();
            getRhymes(o);
        } else if (generated.equals("slide")) {
            Slide o = new Slide();
            getRhymes(o);
        } else if (generated.equals("slim")) {
            Slim o = new Slim();
            getRhymes(o);
        } else if (generated.equals("smart")) {
            Smart o = new Smart();
            getRhymes(o);
        } else if (generated.equals("snore")) {
            Snore o = new Snore();
            getRhymes(o);
        } else if (generated.equals("sofa")) {
            Sofa o = new Sofa();
            getRhymes(o);
        } else if (generated.equals("song")) {
            Song o = new Song();
            getRhymes(o);
        } else if (generated.equals("sprout")) {
            Sprout o = new Sprout();
            getRhymes(o);
        } else if (generated.equals("sugar")) {
            Sugar o = new Sugar();
            getRhymes(o);
        } else if (generated.equals("tail")) {
            Tail o = new Tail();
            getRhymes(o);
        } else if (generated.equals("tank")) {
            Tank o = new Tank();
            getRhymes(o);
        } else if (generated.equals("task")) {
            Task o = new Task();
            getRhymes(o);
        } else if (generated.equals("tattle")) {
            Tattle o = new Tattle();
            getRhymes(o);
        } else if (generated.equals("tattoo")) {
            Tattoo o = new Tattoo();
            getRhymes(o);
        } else if (generated.equals("tea")) {
            Tea o = new Tea();
            getRhymes(o);
        } else if (generated.equals("thanks")) {
            Thanks o = new Thanks();
            getRhymes(o);
        } else if (generated.equals("thirty")) {
            Thirty o = new Thirty();
            getRhymes(o);
        } else if (generated.equals("truck")) {
            Truck o = new Truck();
            getRhymes(o);
        } else if (generated.equals("tube")) {
            Tube o = new Tube();
            getRhymes(o);
        } else if (generated.equals("tusk")) {
            Tusk o = new Tusk();
            getRhymes(o);
        } else if (generated.equals("tux")) {
            Tux o = new Tux();
            getRhymes(o);
        } else if (generated.equals("twilight")) {
            Twilight o = new Twilight();
            getRhymes(o);
        } else if (generated.equals("vase")) {
            Vase o = new Vase();
            getRhymes(o);
        } else if (generated.equals("vine")) {
            Vine o = new Vine();
            getRhymes(o);
        } else if (generated.equals("war")) {
            War o = new War();
            getRhymes(o);
        } else if (generated.equals("water")) {
            Water o = new Water();
            getRhymes(o);
        } else if (generated.equals("wave")) {
            Wave o = new Wave();
            getRhymes(o);
        } else if (generated.equals("west")) {
            West o = new West();
            getRhymes(o);
        } else if (generated.equals("win")) {
            Win o = new Win();
            getRhymes(o);
        } else if (generated.equals("wire")) {
            Wire o = new Wire();
            getRhymes(o);
        } else if (generated.equals("witch")) {
            Witch o = new Witch();
            getRhymes(o);
        } else if (generated.equals("without")) {
            Without o = new Without();
            getRhymes(o);
        } else if (generated.equals("word")) {
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
            if (generatedWord.equals(rhymedWord)) {
                userRhyme.startAnimation(shakeAnimation);
                shakeAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        userRhyme.setText(null);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            } else if (hashedRhymes.contains(rhymedWord)) {
                if (!("(BE|DE|PRE|DIS|NON|PRO|INT|" +
                        "OUT|MIS|SUB|ANT|COM|TRA|PAR|" +
                        "SUP|RES|PER|REC|CAR|FOR|CHA|" +
                        "IMP|TRI|STR|UND|COU|REP|HYP|" +
                        "STA|DEC|BAR|AIR|ISO|SUN|SEA|" +
                        "MID|GEO|MAL|UNS|DIA|SUR|RED|" +
                        "BIO|FLU|FRO|HATE|GO|DOWN|SHIT)").matches(rhymedWord)
                        ) {
                    /*
                    if (soundToggle.isChecked()) {
                        soundPool.play(duplicateSound, 1, 1, 0, 0, 1);
                    }
                    */
                    if (hashedRhymes.contains(rhymedWord)) {
                        userRhyme.setText(null);
                    }
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
        slideOutLeft.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                /**
                 * Clear UserRhyme EditText
                 */
                userRhyme.setText(null);
                computerRhyme.setText(words.get(order++));
                computerRhyme.startAnimation(slideInLeft);
                mReloadLibrary();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        
        if (points > 0) {
            mTimerBar.setVisibility(View.VISIBLE);
        }

        /**
         * Show points as the new score
         */
        currentScore.setText("" + points);
        finalScore.setText("" + points);

        /**
         * Reset progress bar
         */
        mTimerBar.setProgress(100);
        animation = ObjectAnimator.ofInt(mTimerBar, "progress", progress);
        animation.setDuration(time);
        animation.setInterpolator(new LinearInterpolator());
        animation.start();

        /**
         * Check if sound is enabled
         */
        /*
        if (soundToggle.isChecked()) {
            soundPool.play(correctSound, 1, 1, 0, 0, 1);
        }
        */
    }

    public boolean runIntroLoop(Boolean b) {
        if (b) {
            animationTapToPlay();
        } else {
            animationRhymeWithTheWords();
        }
        return true;
    }

    private void animationTapToPlay() {
        tap.setText("tap to play");
        tap.startAnimation(fadeIn);
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tap.startAnimation(fadeOut);
                        fadeOut.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                animationRhymeWithTheWords();
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                    }
                }, 2000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void animationRhymeWithTheWords() {
        tap.setText("rhyme with the words");
        tap.startAnimation(fadeIn);
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tap.startAnimation(fadeOut);
                        fadeOut.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                animationTapToPlay();
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                    }
                }, 2000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
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
            Toast.makeText(getApplicationContext(), "New Best MOFKER!", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        counterRunning = false;
        firstLoad = true;
        userRhyme.setText(null);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (imm.showSoftInput(userRhyme, 0)) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(userRhyme.getWindowToken(), 0);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            /**
             * Main Screen
             */
            case R.id.main:
                runIntroLoop(false);

                mainScreen.setVisibility(View.GONE);
                gameScreen.setVisibility(View.VISIBLE);
                scoreScreen.setVisibility(View.GONE);

                if (!imm.showSoftInput(userRhyme, 0)) {
                    ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                            .toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            userRhyme.requestFocus();
                        }
                    }, 300);
                }

                //stopLoops();
                mReloadLibrary();

                break;

            /**
             * Game Screen
             * Open keyboard if closed
             */
            case R.id.game:
                if (!imm.showSoftInput(userRhyme, 0)) {
                    imm.showSoftInput(userRhyme, 0);
                }
                break;

            /**
             * Score Screen
             * Open keyboard if closed
             */
            case R.id.score:
                if (!imm.showSoftInput(userRhyme, 0)) {
                    imm.showSoftInput(userRhyme, 0);
                }
                break;

            /**
             * Play Games Button
             */
            case R.id.play_games:
                //Toast.makeText(getApplicationContext(), "Dope", Toast.LENGTH_LONG).show();
                break;

            /**
             * Restart Button
             */
            case R.id.restart_game:

                // Keyboard Check
                scoreScreen.setVisibility(View.GONE);
                if (!imm.showSoftInput(userRhyme, 0)) {
                    imm.showSoftInput(userRhyme, 0);
                }

                userRhyme.setText(null);
                points = 0;
                currentScore.setText(null);
                mTimerBar.setVisibility(View.GONE);
                hashedRhymes.clear();

                scoreScreen.startAnimation(slideDownOutAnimation);

                computerRhyme.setText(words.get(order++));
                computerRhyme.startAnimation(slideInLeft);


                // Reset Score
                points = 0;

                switch (color) {
                    case 0:
                        mother.setBackgroundColor(getResources().getColor(R.color.blue_grey));
                        restart.setBackground(getResources().getDrawable(R.drawable.blue_grey_pink));
                        color = 1;
                        break;
                    case 1:
                        mother.setBackgroundColor(getResources().getColor(R.color.pink));
                        restart.setBackground(getResources().getDrawable(R.drawable.pink_orange));
                        color = 2;
                        break;
                    case 2:
                        mother.setBackgroundColor(getResources().getColor(R.color.orange));
                        restart.setBackground(getResources().getDrawable(R.drawable.orange_red));
                        color = 3;
                        break;
                    case 3:
                        mother.setBackgroundColor(getResources().getColor(R.color.red));
                        restart.setBackground(getResources().getDrawable(R.drawable.red_green));
                        color = 4;
                        break;
                    case 4:
                        mother.setBackgroundColor(getResources().getColor(R.color.green));
                        restart.setBackground(getResources().getDrawable(R.drawable.green_teal));
                        color = 5;
                        break;
                    case 5:
                        mother.setBackgroundColor(getResources().getColor(R.color.teal));
                        restart.setBackground(getResources().getDrawable(R.drawable.teal_cyan));
                        color = 6;
                        break;
                    case 6:
                        mother.setBackgroundColor(getResources().getColor(R.color.cyan));
                        restart.setBackground(getResources().getDrawable(R.drawable.cyan_purple));
                        color = 7;
                        break;
                    case 7:
                        mother.setBackgroundColor(getResources().getColor(R.color.purple));
                        restart.setBackground(getResources().getDrawable(R.drawable.purple_light_blue));
                        color = 8;
                        break;
                    case 8:
                        mother.setBackgroundColor(getResources().getColor(R.color.light_blue));
                        restart.setBackground(getResources().getDrawable(R.drawable.light_blue_deep_purple));
                        color = 9;
                        break;
                    case 9:
                        mother.setBackgroundColor(getResources().getColor(R.color.deep_purple));
                        restart.setBackground(getResources().getDrawable(R.drawable.deep_purple_blue));
                        color = 10;
                        break;
                    case 10:
                        mother.setBackgroundColor(getResources().getColor(R.color.blue));
                        restart.setBackground(getResources().getDrawable(R.drawable.blue_indigo));
                        color = 11;
                        break;
                    case 11:
                        mother.setBackgroundColor(getResources().getColor(R.color.indigo));
                        restart.setBackground(getResources().getDrawable(R.drawable.indigo_blue_grey));
                        color = 0;
                        break;
                }

                mLoadLibrary();
                mReloadLibrary();

                firstLoad = false;

                break;
            case R.id.main_menu:
                runIntroLoop(true);

                userRhyme.setText(null);
                points = 0;
                currentScore.setText(null);
                mTimerBar.setVisibility(View.GONE);
                hashedRhymes.clear();

                scoreScreen.startAnimation(slideDownOutAnimation);

                computerRhyme.setText(words.get(order++));
                //computerRhyme.startAnimation(flipInAnimation);
                computerRhyme.startAnimation(slideInLeft);

                mLoadLibrary();
                mReloadLibrary();
                mainScreen.setVisibility(View.VISIBLE);
                gameScreen.setVisibility(View.GONE);
                scoreScreen.setVisibility(View.GONE);
                imm.hideSoftInputFromWindow(userRhyme.getWindowToken(), 0);
                //startLoops();
                break;
        }
    }
}
