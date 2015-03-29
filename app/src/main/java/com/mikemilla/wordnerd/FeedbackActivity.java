package com.mikemilla.wordnerd;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class FeedbackActivity extends Activity {

    Typeface font;
    TextView whatsUp;
    Button rhyme;
    Button glitch;
    Button graphic;
    Button word;
    Button idea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        whatsUp = (TextView) findViewById(R.id.whats_up);
        rhyme = (Button) findViewById(R.id.rhyme_feedback);
        glitch = (Button) findViewById(R.id.glitch_feedback);
        //graphic = (Button) findViewById(R.id.graphic_feedback);
        //word = (Button) findViewById(R.id.word_feedback);
        idea = (Button) findViewById(R.id.idea_feedback);
        font = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/OldSansBlack.ttf");

        whatsUp.setTypeface(font);
        rhyme.setTypeface(font);
        glitch.setTypeface(font);
        //graphic.setTypeface(font);
        //word.setTypeface(font);
        idea.setTypeface(font);

        rhyme.setText(GameActivity.generatedWord + " should rhyme with...");

        rhyme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                String[] recipients = new String[]{"mail@mikemilla.com", "",};
                intent.putExtra(android.content.Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT, "What word should " + "\"" + GameActivity.generatedWord + "\" rhyme with?");
                intent.setType("message/rfc822");
                startActivity(intent);
            }
        });

        glitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                String[] recipients = new String[]{"mail@mikemilla.com", "",};
                intent.putExtra(android.content.Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Try your best to describe it!");
                //intent.putExtra(Intent.EXTRA_TEXT, "" + GameActivity.hashedRhymes);
                intent.setType("message/rfc822");
                startActivity(intent);
            }
        });

        /*

        graphic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                String[] recipients = new String[]{"mail@mikemilla.com", "",};
                intent.putExtra(android.content.Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT, "What graphical stuff was messed up?");
                //intent.putExtra(Intent.EXTRA_TEXT, "" + GameActivity.hashedRhymes);
                intent.setType("message/rfc822");
                startActivity(intent);
            }
        });

        word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                String[] recipients = new String[]{"mail@mikemilla.com", "",};
                intent.putExtra(android.content.Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT, "What word should I add?");
                //intent.putExtra(Intent.EXTRA_TEXT, "" + GameActivity.hashedRhymes);
                intent.setType("message/rfc822");
                startActivity(intent);
            }
        });

        */

        idea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                String[] recipients = new String[]{"mail@mikemilla.com", "",};
                intent.putExtra(android.content.Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT, "What's your idea? :)");
                //intent.putExtra(Intent.EXTRA_TEXT, "" + GameActivity.hashedRhymes);
                intent.setType("message/rfc822");
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(FeedbackActivity.this, ScoreActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_up_in, R.anim.slide_right);
    }

}
