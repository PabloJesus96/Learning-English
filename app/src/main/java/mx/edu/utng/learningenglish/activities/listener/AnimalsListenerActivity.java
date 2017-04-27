package mx.edu.utng.learningenglish.activities.listener;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import mx.edu.utng.learningenglish.R;

public class AnimalsListenerActivity extends AppCompatActivity  implements View.OnClickListener{
    private CardView cvRabbit;
    private CardView cvBee;
    private CardView cvSheep;
    private CardView cvButherfly;
    private CardView cvCat;
    private CardView cvDog;
    private CardView cvHorse;
    private CardView cvPig;
    private CardView cvLion;
    private CardView cvMonkey;
    private CardView cvSnail;
    private SoundPool soundPool;
    private int loaderRabbit;
    private int loaderBee;
    private int loaderSheep;
    private int loaderButherfly;
    private int loaderCat;
    private int loaderDog;
    private int loaderHorse;
    private int loaderPig;
    private int loaderLion;
    private int loaderMonkey;
    private int loaderSnail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_listener);
        this.setTitle("Animals Listener");

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        cvRabbit = (CardView) findViewById(R.id.cv_rabbit);
        cvBee = (CardView) findViewById(R.id.cv_bee);
        cvSheep = (CardView) findViewById(R.id.cv_sheep);
        cvButherfly = (CardView) findViewById(R.id.cv_butherfly);
        cvCat = (CardView) findViewById(R.id.cv_cat);
        cvDog = (CardView) findViewById(R.id.cv_dog);
        cvHorse = (CardView) findViewById(R.id.cv_horse);
        cvPig = (CardView) findViewById(R.id.cv_pig);
        cvLion = (CardView) findViewById(R.id.cv_lion);
        cvMonkey = (CardView) findViewById(R.id.cv_monkey);
        cvSnail = (CardView) findViewById(R.id.cv_snail);


        cvRabbit.setOnClickListener(this);
        cvBee.setOnClickListener(this);
        cvSheep.setOnClickListener(this);
        cvButherfly.setOnClickListener(this);
        cvCat.setOnClickListener(this);
        cvDog.setOnClickListener(this);
        cvHorse.setOnClickListener(this);
        cvPig.setOnClickListener(this);
        cvLion.setOnClickListener(this);
        cvMonkey.setOnClickListener(this);
        cvSnail.setOnClickListener(this);

        soundPool = new SoundPool(16, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loaderRabbit=soundPool.load(this,R.raw.rabbit,1);
        loaderBee=soundPool.load(this,R.raw.be,1);
        loaderSheep=soundPool.load(this,R.raw.sheep,1);
        loaderButherfly=soundPool.load(this,R.raw.butherfly,1);
        loaderCat=soundPool.load(this,R.raw.cat,1);
        loaderDog=soundPool.load(this,R.raw.dog,1);
        loaderHorse=soundPool.load(this,R.raw.horse,1);
        loaderPig=soundPool.load(this,R.raw.pig,1);
        loaderLion=soundPool.load(this,R.raw.lion,1);
        loaderMonkey=soundPool.load(this,R.raw.monkey,1);
        loaderSnail=soundPool.load(this,R.raw.snail,1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cv_rabbit:
                soundPool.play(loaderRabbit, 1,1,0,0,1);
                break;
            case R.id.cv_bee:
                soundPool.play(loaderBee, 1,1,0,0,1);
                break;
            case R.id.cv_sheep:
                soundPool.play(loaderSheep, 1,1,0,0,1);
                break;
            case R.id.cv_butherfly:
                soundPool.play(loaderButherfly, 1,1,0,0,1);
                break;
            case R.id.cv_cat:
                soundPool.play(loaderCat, 1,1,0,0,1);
                break;
            case R.id.cv_dog:
                soundPool.play(loaderDog, 1,1,0,0,1);
                break;
            case R.id.cv_horse:
                soundPool.play(loaderHorse, 1,1,0,0,1);
                break;
            case R.id.cv_pig:
                soundPool.play(loaderPig, 1,1,0,0,1);
                break;
            case R.id.cv_lion:
                soundPool.play(loaderLion, 1,1,0,0,1);
                break;
            case R.id.cv_monkey:
                soundPool.play(loaderMonkey, 1,1,0,0,1);
                break;
            case R.id.cv_snail:
                soundPool.play(loaderSnail, 1,1,0,0,1);
                break;
        }

    }
}
