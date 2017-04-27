package mx.edu.utng.learningenglish.activities.listener;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import mx.edu.utng.learningenglish.R;

public class FamilyListenerActivity extends AppCompatActivity  implements View.OnClickListener{
    private CardView cvMother;
    private CardView cvFather;
    private CardView cvGrandMother;
    private CardView cvGrandFather;
    private CardView cvBrother;
    private CardView cvSister;
    private CardView cvUncle;
    private CardView cvAunt;
    private CardView cvCousins;
    private CardView cvBaby;
    private SoundPool soundPool;
    private int so1, so2 ,so3, so4,so5 ,so6, so7, so8, so9, so10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_listener);
        this.setTitle("Family Listener");

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        cvMother = (CardView) findViewById(R.id.cv_mother);
        cvFather = (CardView) findViewById(R.id.cv_father);
        cvGrandMother = (CardView) findViewById(R.id.cv_grandmother);
        cvGrandFather = (CardView) findViewById(R.id.cv_grandfather);
        cvBrother = (CardView) findViewById(R.id.cv_brother);
        cvSister = (CardView) findViewById(R.id.cv_sister);
        cvUncle = (CardView) findViewById(R.id.cv_uncle);
        cvAunt = (CardView) findViewById(R.id.cv_aunt);
        cvCousins = (CardView) findViewById(R.id.cv_cusin);
        cvBaby = (CardView) findViewById(R.id.cv_baby);

        cvMother.setOnClickListener(this);
        cvFather.setOnClickListener(this);
        cvGrandMother.setOnClickListener(this);
        cvGrandFather.setOnClickListener(this);
        cvBrother.setOnClickListener(this);
        cvSister.setOnClickListener(this);
        cvUncle.setOnClickListener(this);
        cvAunt.setOnClickListener(this);
        cvCousins.setOnClickListener(this);
        cvBaby.setOnClickListener(this);

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        so1 = soundPool.load(this,R.raw.mother,1);
        so2 = soundPool.load(this,R.raw.father,1);
        so3 = soundPool.load(this,R.raw.grandmother,1);
        so4 = soundPool.load(this,R.raw.grandfather,1);
        so5 = soundPool.load(this,R.raw.brother,1);
        so6 = soundPool.load(this,R.raw.sister,1);
        so7 = soundPool.load(this,R.raw.uncle,1);
        so8 = soundPool.load(this,R.raw.aunt,1);
        so9 = soundPool.load(this,R.raw.cousin,1);
        so10 = soundPool.load(this,R.raw.baby,1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cv_mother:
                soundPool.play(so1, 1,1,0,0,1);
                break;
            case R.id.cv_father:
                soundPool.play(so2, 1,1,0,0,1);
                break;
            case R.id.cv_grandmother:
                soundPool.play(so3, 1,1,0,0,1);
                break;
            case R.id.cv_grandfather:
                soundPool.play(so4, 1,1,0,0,1);
                break;
            case R.id.cv_brother:
                soundPool.play(so5, 1,1,0,0,1);
                break;
            case R.id.cv_sister:
                soundPool.play(so6, 1,1,0,0,1);
                break;
            case R.id.cv_uncle:
                soundPool.play(so7, 1,1,0,0,1);
                break;
            case R.id.cv_aunt:
                soundPool.play(so8, 1,1,0,0,1);
                break;
            case R.id.cv_cusin:
                soundPool.play(so9, 1,1,0,0,1);
                break;
            case R.id.cv_baby:
                soundPool.play(so10, 1,1,0,0,1);
                break;
        }

    }
}
