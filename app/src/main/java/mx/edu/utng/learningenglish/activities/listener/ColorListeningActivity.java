package mx.edu.utng.learningenglish.activities.listener;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import mx.edu.utng.learningenglish.R;

public class ColorListeningActivity extends AppCompatActivity implements View.OnClickListener{
    private CardView ivRed;
    private CardView ivYellow;
    private CardView ivOrange;
    private CardView ivWhite;
    private CardView ivGreen;
    private CardView ivBlue;
    private CardView ivPink;
    private CardView ivGrey;

    private SoundPool soundPool;
    private int so1, so2 ,so3, so4,so5 ,so6, so7, so8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_listening);
        this.setTitle("Color Listening");
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ivRed = (CardView)findViewById(R.id.cv_group_c1);
        ivYellow = (CardView)findViewById(R.id.cv_group_c2);
        ivOrange = (CardView)findViewById(R.id.cv_group_c3);
        ivWhite = (CardView)findViewById(R.id.cv_group_c4);
        ivGreen = (CardView)findViewById(R.id.cv_group_c5);
        ivBlue  =(CardView)findViewById(R.id.cv_group_c6);
        ivPink  = (CardView)findViewById(R.id.cv_group_c7);
        ivGrey  = (CardView)findViewById(R.id.cv_group_c8);

        ivRed.setOnClickListener(this);
        ivYellow.setOnClickListener(this);
        ivOrange.setOnClickListener(this);
        ivWhite.setOnClickListener(this);
        ivGreen.setOnClickListener(this);
        ivBlue.setOnClickListener(this);
        ivPink.setOnClickListener(this);
        ivGrey.setOnClickListener(this);

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        so1 = soundPool.load(this,R.raw.red,1);
        so2 = soundPool.load(this,R.raw.yellow,1);
        so3 = soundPool.load(this,R.raw.orange,1);
        so4 = soundPool.load(this,R.raw.white,1);
        so5 = soundPool.load(this,R.raw.green,1);
        so6 = soundPool.load(this,R.raw.blue,1);
        so7 = soundPool.load(this,R.raw.pink,1);
        so8 = soundPool.load(this,R.raw.gray,1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cv_group_c1:
                soundPool.play(so1, 1,1,0,0,1);
                break;
            case R.id.cv_group_c2:
                soundPool.play(so6, 1,1,0,0,1);
                break;
            case R.id.cv_group_c3:
                soundPool.play(so4, 1,1,0,0,1);
                break;
            case R.id.cv_group_c4:
                soundPool.play(so5, 1,1,0,0,1);
                break;
            case R.id.cv_group_c5:
                soundPool.play(so2, 1,1,0,0,1);
                break;
            case R.id.cv_group_c6:
                soundPool.play(so8, 1,1,0,0,1);
                break;
            case R.id.cv_group_c7:
                soundPool.play(so7, 1,1,0,0,1);
                break;
            case R.id.cv_group_c8:
                soundPool.play(so3, 1,1,0,0,1);
                break;
        }
    }
}
