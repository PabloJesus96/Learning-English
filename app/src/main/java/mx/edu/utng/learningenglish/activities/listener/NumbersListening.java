package mx.edu.utng.learningenglish.activities.listener;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import mx.edu.utng.learningenglish.R;

public class NumbersListening extends AppCompatActivity implements View.OnClickListener{
    private ImageView ivOne;
    private ImageView ivTwo;
    private ImageView ivThree;
    private ImageView ivFour;
    private ImageView ivFive;
    private ImageView ivSix;
    private ImageView ivSeven;
    private ImageView ivEight;
    private ImageView ivNine;
    private ImageView ivTen;
    private ImageView ivtwenty;
    private ImageView ivThirty;
    private ImageView ivFourty;
    private ImageView ivFifty;
    private ImageView ivSixty;
    private ImageView ivSeventy;
    private ImageView ivEighty;
    private ImageView ivNinety;
    private ImageView ivHundred;

    private SoundPool soundPool;
    
    private int n1;
    private int n2;
    private int n3;
    private int n4;
    private int n5;
    private int n6;
    private int n7;
    private int n8;
    private int n9;
    private int n10;

    private int n20;
    private int n30;
    private int n40;
    private int n50;
    private int n60;
    private int n70;
    private int n80;
    private int n90;
    private int n100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_listening);
        this.setTitle("Numbers Listening");

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ivOne = (ImageView)findViewById(R.id.iv_one);
        ivTwo = (ImageView)findViewById(R.id.iv_two);
        ivThree = (ImageView)findViewById(R.id.iv_three);
        ivFour = (ImageView)findViewById(R.id.iv_four);
        ivFive = (ImageView)findViewById(R.id.iv_five);
        ivSix =(ImageView)findViewById(R.id.iv_six);
        ivSeven = (ImageView)findViewById(R.id.iv_seven);
        ivEight = (ImageView)findViewById(R.id.iv_eight);
        ivNine = (ImageView)findViewById(R.id.iv_nine);
        ivTen = (ImageView)findViewById(R.id.iv_ten);

        ivtwenty = (ImageView)findViewById(R.id.iv_20);
        ivThirty = (ImageView)findViewById(R.id.iv_30);
        ivFourty = (ImageView)findViewById(R.id.iv_40);
        ivFifty= (ImageView)findViewById(R.id.iv_50);
        ivSixty = (ImageView)findViewById(R.id.iv_60);
        ivSeventy = (ImageView)findViewById(R.id.iv_70);
        ivEighty=(ImageView)findViewById(R.id.iv_80);
        ivNinety = (ImageView)findViewById(R.id.iv_90);
        ivHundred = (ImageView)findViewById(R.id.iv_100);

        ivOne.setOnClickListener(this);
        ivTwo.setOnClickListener(this);
        ivThree.setOnClickListener(this);
        ivFour.setOnClickListener(this);
        ivFive.setOnClickListener(this);
        ivSix.setOnClickListener(this);
        ivSeven.setOnClickListener(this);
        ivEight.setOnClickListener(this);
        ivNine.setOnClickListener(this);
        ivTen.setOnClickListener(this);

        ivtwenty.setOnClickListener(this);
        ivThirty.setOnClickListener(this);
        ivFourty.setOnClickListener(this);
        ivFifty.setOnClickListener(this);
        ivSixty.setOnClickListener(this);
        ivSeventy.setOnClickListener(this);
        ivEighty.setOnClickListener(this);
        ivNinety.setOnClickListener(this);
        ivHundred.setOnClickListener(this);


        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        n1=soundPool.load(this,R.raw.one,1);
        n2=soundPool.load(this,R.raw.two,1);
        n3=soundPool.load(this,R.raw.trhee,1);
        n4=soundPool.load(this,R.raw.four,1);
        n5=soundPool.load(this,R.raw.five,1);
        n6=soundPool.load(this,R.raw.six,1);
        n7=soundPool.load(this,R.raw.seven,1);
        n8=soundPool.load(this,R.raw.eigth,1);
        n9=soundPool.load(this,R.raw.nine,1);
        n10=soundPool.load(this,R.raw.tenn,1);

        n20=soundPool.load(this,R.raw.twenty,1);
        n30=soundPool.load(this,R.raw.thirty,1);
        n40=soundPool.load(this,R.raw.fourty,1);
        n50=soundPool.load(this,R.raw.fifty,1);
        n60=soundPool.load(this,R.raw.sixty,1);
        n70=soundPool.load(this,R.raw.seventy,1);
        n80=soundPool.load(this,R.raw.eighty,1);
        n90=soundPool.load(this,R.raw.ninety,1);
        n100=soundPool.load(this,R.raw.onehundred,1);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_one:
                soundPool.play(n1, 1,1,0,0,1);
                break;
            case R.id.iv_two:
                soundPool.play(n2, 1,1,0,0,1);
                break;
            case R.id.iv_three:
                soundPool.play(n3, 1,1,0,0,1);
                break;
            case R.id.iv_four:
                soundPool.play(n4, 1,1,0,0,1);
                break;
            case R.id.iv_five:
                soundPool.play(n5, 1,1,0,0,1);
                break;
            case R.id.iv_six:
                soundPool.play(n6, 1,1,0,0,1);
                break;
            case R.id.iv_seven:
                soundPool.play(n7, 1,1,0,0,1);
                break;
            case R.id.iv_eight:
                soundPool.play(n8, 1,1,0,0,1);
                break;
            case R.id.iv_nine:
                soundPool.play(n9, 1,1,0,0,1);
                break;
            case R.id.iv_ten:
                soundPool.play(n10, 1,1,0,0,1);
                break;
            case R.id.iv_20:
                soundPool.play(n20, 1,1,0,0,1);
                break;
            case R.id.iv_30:
                soundPool.play(n30, 1,1,0,0,1);
                break;
            case R.id.iv_40:
                soundPool.play(n40, 1,1,0,0,1);
                break;
            case R.id.iv_50:
                soundPool.play(n50, 1,1,0,0,1);
                break;
            case R.id.iv_60:
                soundPool.play(n60, 1,1,0,0,1);
                break;
            case R.id.iv_70:
                soundPool.play(n70, 1,1,0,0,1);
                break;
            case R.id.iv_80:
                soundPool.play(n80, 1,1,0,0,1);
                break;
            case R.id.iv_90:
                soundPool.play(n90, 1,1,0,0,1);
                break;
            case R.id.iv_100:
                soundPool.play(n100, 1,1,0,0,1);
                break;
        }

    }
}
