package mx.edu.utng.learningenglish.activities.listener;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.learningenglish.R;

/**
 * Created by Santana on 19/04/2017.
 */

public class May extends AppCompatActivity implements View.OnClickListener{
    private TextView tvOption1;
    private TextView tvOption2;
    private TextView tvOption3;
    private ImageView ivMonth;
    private SoundPool soundPool;
    private int may;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months);
        this.setTitle("Months ");

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        tvOption1=(TextView)findViewById(R.id.tv_option_uno);
        tvOption2=(TextView)findViewById(R.id.tv_option_dos);
        tvOption3=(TextView)findViewById(R.id.tv_option_tres);

        ivMonth=(ImageView) findViewById(R.id.iv_month);
        tvOption1.setOnClickListener(this);
        tvOption2.setOnClickListener(this);
        tvOption3.setOnClickListener(this);
        //imagenes
        ivMonth.setOnClickListener(this);
//asignacion de sonido
        soundPool=new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        may =soundPool.load(this,R.raw.may,1);
        //cambia los datos mes de MAYO
        ivMonth.setImageResource(R.drawable.may);

        tvOption1.setText("July");
        tvOption1.setBackgroundColor(Color.CYAN);
        tvOption2.setText("May");
        tvOption2.setBackgroundColor(Color.CYAN);
        tvOption3.setText("November");
        tvOption3.setBackgroundColor(Color.CYAN);
    }

    @Override
    public void onClick(View v) {
        if (tvOption1.isPressed()){
            tvOption1.setBackgroundColor(Color.RED);
            Toast.makeText(this," :( Error!!",Toast.LENGTH_SHORT).show();
        }else if (tvOption2.isPressed()){
            tvOption2.setBackgroundColor(Color.GREEN);
            Toast.makeText(this," :) Is correct!!",Toast.LENGTH_SHORT).show();
            soundPool.play(may,1,1,0,0,1);
            Intent intent=new Intent(May.this,September.class);
            startActivity(intent);
        }else if (tvOption3.isPressed()){
            tvOption3.setBackgroundColor(Color.RED);
            Toast.makeText(this," :( Error!!",Toast.LENGTH_SHORT).show();


        }//mes de mayo

    }
}
