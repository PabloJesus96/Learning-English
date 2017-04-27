package mx.edu.utng.learningenglish.activities.listener;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import mx.edu.utng.learningenglish.R;

public class GeometricFiguresListenerActivity extends AppCompatActivity  implements View.OnClickListener{
    private CardView cvRectangle;
    private CardView cvDiamond;
    private CardView cvCross;
    private CardView cvTriangle;
    private CardView cvArrow;
    private CardView cvPentagon;
    private CardView cvSquare;
    private CardView cvCircle;
    private CardView cvStar;
    private CardView cvHexagon;
    private CardView cvHeart;
    private CardView cvOval;
    private SoundPool soundPool;
    private int loaderRectangle;
    private int loaderDiamond;
    private int loaderCross;
    private int loaderTriangle;
    private int loaderArrow;
    private int loaderPentagon;
    private int loaderSquare;
    private int loaderCircle;
    private int loaderStar;
    private int loaderHexagon;
    private int loaderHeart;
    private int loaderOval;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometric_figures_listening);
        this.setTitle("geometric figures Listener");

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        cvSquare = (CardView) findViewById(R.id.cv_square);
        cvCircle = (CardView) findViewById(R.id.cv_circle);
        cvTriangle = (CardView) findViewById(R.id.cv_triangle);
        cvRectangle = (CardView) findViewById(R.id.cv_rectangle);
        cvDiamond = (CardView) findViewById(R.id.cv_diamond);
        cvCross = (CardView) findViewById(R.id.cv_cross);
        cvArrow = (CardView) findViewById(R.id.cv_arrow);
        cvPentagon = (CardView) findViewById(R.id.cv_pentagon);
        cvStar = (CardView) findViewById(R.id.cv_star);
        cvHexagon = (CardView) findViewById(R.id.cv_hexagon);
        cvHeart = (CardView) findViewById(R.id.cv_heart);
        cvOval = (CardView) findViewById(R.id.cv_oval);


        cvSquare.setOnClickListener(this);
        cvCircle.setOnClickListener(this);
        cvTriangle.setOnClickListener(this);
        cvRectangle.setOnClickListener(this);
        cvDiamond.setOnClickListener(this);
        cvCross.setOnClickListener(this);
        cvArrow.setOnClickListener(this);
        cvPentagon.setOnClickListener(this);
        cvStar.setOnClickListener(this);
        cvHexagon.setOnClickListener(this);
        cvHeart.setOnClickListener(this);
        cvOval.setOnClickListener(this);

        soundPool = new SoundPool(16, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        loaderSquare=soundPool.load(this,R.raw.square,1);
        loaderCircle=soundPool.load(this,R.raw.circle,1);
        loaderTriangle=soundPool.load(this,R.raw.triangle,1);
        loaderRectangle=soundPool.load(this,R.raw.rectangle,1);
        loaderDiamond=soundPool.load(this,R.raw.diamond,1);
        loaderCross=soundPool.load(this,R.raw.cross,1);
        loaderArrow=soundPool.load(this,R.raw.arrow,1);
        loaderPentagon=soundPool.load(this,R.raw.pentagon,1);
        loaderStar=soundPool.load(this,R.raw.star,1);
        loaderHexagon=soundPool.load(this,R.raw.hexagon,1);
        loaderHeart=soundPool.load(this,R.raw.heart,1);
        loaderOval=soundPool.load(this,R.raw.oval,1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cv_square:
                soundPool.play(loaderSquare, 1,1,0,0,1);
                break;
            case R.id.cv_circle:
                soundPool.play(loaderCircle, 1,1,0,0,1);
                break;
            case R.id.cv_triangle:
                soundPool.play(loaderTriangle, 1,1,0,0,1);
                break;
            case R.id.cv_rectangle:
                soundPool.play(loaderRectangle, 1,1,0,0,1);
                break;
            case R.id.cv_diamond:
                soundPool.play(loaderDiamond, 1,1,0,0,1);
                break;
            case R.id.cv_cross:
                soundPool.play(loaderCross, 1,1,0,0,1);
                break;
            case R.id.cv_arrow:
                soundPool.play(loaderArrow, 1,1,0,0,1);
                break;
            case R.id.cv_pentagon:
                soundPool.play(loaderPentagon, 1,1,0,0,1);
                break;
            case R.id.cv_star:
                soundPool.play(loaderStar, 1,1,0,0,1);
                break;
            case R.id.cv_heart:
                soundPool.play(loaderHeart, 1,1,0,0,1);
                break;
            case R.id.cv_hexagon:
                soundPool.play(loaderHexagon, 1,1,0,0,1);
                break;
            case R.id.cv_oval:
                soundPool.play(loaderOval, 1,1,0,0,1);
                break;
        }

    }
}
