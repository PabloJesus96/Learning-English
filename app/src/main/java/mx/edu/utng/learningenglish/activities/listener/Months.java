package mx.edu.utng.learningenglish.activities.listener;

import mx.edu.utng.learningenglish.R;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Months extends AppCompatActivity implements View.OnClickListener{
    private TextView tvOption1;
    private TextView tvOption2;
    private TextView tvOption3;
    private ImageView ivMonth;

    private SoundPool soundPool;
    private  int july;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months);
        this.setTitle("Months");

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
        //sound
        soundPool=new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        july =soundPool.load(this,R.raw.july,1);

    }//


    @Override
    public void onClick(View v) {
        if (tvOption1.isPressed()){
            tvOption1.setBackgroundColor(Color.GREEN);
            Toast.makeText(this," :) Is correct!!",Toast.LENGTH_SHORT).show();
            soundPool.play(july,1,1,0,0,1);
            Intent intent=new Intent(Months.this,April.class);
            startActivity(intent);
        }else   if (tvOption2.isPressed()){
            tvOption2.setBackgroundColor(Color.RED);
            Toast.makeText(this," :( Error!!",Toast.LENGTH_SHORT).show();
        }else if (tvOption3.isPressed()){
            tvOption3.setBackgroundColor(Color.RED);
            Toast.makeText(this," :( Error!!",Toast.LENGTH_SHORT).show();
        }






    }
}
