package mx.edu.utng.learningenglish.activities.listener;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import mx.edu.utng.learningenglish.R;


public class Sport extends AppCompatActivity implements View.OnClickListener{
    ImageView ivSport;
    ImageButton ivListenSport;
    TextView tvNameSport;
    Button anterior;
    Button siguiente;
    private SoundPool soundPool;
    private int baseball;
    private  int basketball;
    private int soccer;
    private int golf;
    private  int swimming;
    private int tennis;
    private int volleyball;


    int[] imagenId = {R.drawable.baseball,R.drawable.basketball,R.drawable.soccer,R.drawable.golf,R.drawable.swimming,R.drawable.tennise,R.drawable.voleiball};
    String[] names = {"Baseball", "Basketball", "Soccer", "Golf","Swimming","Tennis","Volleyball"};

    int i = 0;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ivListenSport=(ImageButton)findViewById(R.id.iv_sports_listen);
        anterior = (Button) findViewById(R.id.bt_anterior);
        siguiente = (Button) findViewById(R.id.bt_siguiente);
        tvNameSport = (TextView) findViewById(R.id.tv_name_sport);
        ivSport = (ImageView) findViewById(R.id.iv_sports);

        anterior.setOnClickListener(this);
        siguiente.setOnClickListener(this);

        ivListenSport.setOnClickListener(this);

        total = imagenId.length;

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        basketball=soundPool.load(this,R.raw.basketball,1);
        soccer=soundPool.load(this,R.raw.soccer,1);
        golf=soundPool.load(this,R.raw.golf,1);
        swimming=soundPool.load(this,R.raw.swimming,1);
        tennis=soundPool.load(this,R.raw.tenis,1);
        volleyball=soundPool.load(this,R.raw.voleibol,1);
        baseball=soundPool.load(this,R.raw.basebol,1);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.bt_siguiente) {
            i++;
            //total =4 o7 hasta horita
            if(i == total){
                i = 0;
            }

        }

        if(id == R.id.bt_anterior) {
            i--;
            if(i == -1){
                i = total -1;
            }
        }
        //cambia de imagen segun la posicion
        ivSport.setImageResource(imagenId[i]);
        //cambia el nombre segun la posicion de la imagen
        tvNameSport.setText(names[i]);

        if(ivListenSport.isPressed()){
            if(i==1){
                soundPool.play(basketball, 1,1,0,0,1);


            }
            if(i==2){
                soundPool.play(soccer, 1,1,0,0,1);


            }
            if(i==3){
                soundPool.play(golf, 1,1,0,0,1);


            }
            if(i==4){
                soundPool.play(swimming, 1,1,0,0,1);


            }
            if(i==5){
                soundPool.play(tennis, 1,1,0,0,1);


            }
            if(i==6){
                soundPool.play(volleyball, 1,1,0,0,1);

            }
            if(i==0){
                soundPool.play(baseball, 1,1,0,0,1);


            }
        }

    }
}
