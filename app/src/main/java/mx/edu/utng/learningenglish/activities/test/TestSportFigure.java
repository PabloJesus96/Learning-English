package mx.edu.utng.learningenglish.activities.test;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;

import mx.edu.utng.learningenglish.R;
import mx.edu.utng.learningenglish.activities.GeoFigSports;
import mx.edu.utng.learningenglish.menu.MainActivity;
import mx.edu.utng.learningenglish.sqlite.DbHelper;

public class TestSportFigure extends AppCompatActivity implements View.OnClickListener {
    private RadioButton rbSoccer;
    private RadioButton rbTennis;
    private RadioButton rbGolf;
    private RadioButton rbBasketball;
    private RadioButton rbSportVoleyball;
    private ImageButton btVoleyball;
    private RadioButton rbHexagon;
    private RadioButton rbTriangle;
    private RadioButton rbSquare;
    private RadioButton rbStar;
    private RadioButton rbRectangle;
    private ImageButton btRectangle;
    private Button btEnviar;

    private SoundPool soundPool;
    private int voleyball;
    private int rectangle;
    private DbHelper db;
    private String idUser;
    private final static String SETTING_USER = "setting_user";
    private String user;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sport_figure);

        rbSoccer=(RadioButton)findViewById(R.id.rb_soccer);
        rbTennis=(RadioButton)findViewById(R.id.rb_tennis);
        rbGolf=(RadioButton)findViewById(R.id.rb_golf);
        rbBasketball=(RadioButton)findViewById(R.id.rb_basketball_sport);
        rbSportVoleyball=(RadioButton)findViewById(R.id.rb_sport_voly);
        btVoleyball=(ImageButton)findViewById(R.id.bt_voleyball_listen);

        rbHexagon=(RadioButton)findViewById(R.id.rb_hexagon);
        rbTriangle=(RadioButton)findViewById(R.id.rb_triangle);
        rbSquare=(RadioButton)findViewById(R.id.rb_square);
        rbStar=(RadioButton)findViewById(R.id.rb_start);
        rbRectangle=(RadioButton)findViewById(R.id.rb_rectangle);
        btRectangle=(ImageButton)findViewById(R.id.bt_rectangle_listen);

        btEnviar=(Button)findViewById(R.id.bt_finish_fs);
        btEnviar.setOnClickListener(this);
        btVoleyball.setOnClickListener(this);
        btRectangle.setOnClickListener(this);
        soundPool=new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        voleyball=soundPool.load(this,R.raw.voleibol,1);
        rectangle=soundPool.load(this,R.raw.rectangle,1);

        db = new DbHelper(this);
    }

    @Override
    public void onClick(View v) {
        double scoreTest=0.0;
        if (rbSoccer.isChecked()){
            scoreTest=scoreTest+1;
        }
        if (rbTennis.isChecked()){
            scoreTest=scoreTest+1;
        }
        if (rbGolf.isChecked()){
            scoreTest=scoreTest+1;
        }
        if (rbBasketball.isChecked()){
            scoreTest=scoreTest+1;
        }
        if (rbSportVoleyball.isChecked()){
            scoreTest=scoreTest+1;
        }
        if (btVoleyball.isPressed()){
            soundPool.play(voleyball,1,1,0,0,1);
        }
        if (rbHexagon.isChecked()){
            scoreTest=scoreTest+1;
        }
        if (rbTriangle.isChecked()){
            scoreTest=scoreTest+1;
        } if (rbSquare.isChecked()){
            scoreTest=scoreTest+1;
        }
        if (rbStar.isChecked()){
            scoreTest=scoreTest+1;
        }
        if (rbRectangle.isChecked()){
            scoreTest=scoreTest+1;
        }
        if (btRectangle.isPressed()){
            soundPool.play(rectangle,1,1,0,0,1);
        }

        if (btEnviar.isPressed()){

            sharedPreferences = getApplicationContext().getSharedPreferences("recuperardatos", Context.MODE_PRIVATE);
            user = sharedPreferences.getString(SETTING_USER,"");
            idUser = db.getIdUser(user);
            Log.i("el id del usuario es ", idUser);
            String data = db.getScore(idUser, 4);
            if(data!=null){
                db.updateScore(idUser,4,String.valueOf(scoreTest));
            }else{
                db.addScore(String.valueOf(scoreTest),idUser,4);
            }
            if (scoreTest>=8) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(TestSportFigure.this);
                builder.setTitle(Html.fromHtml("<font color='#FF0000'><b>¡ F E L I C I D A D E S ! </b></font>"))
                        .setIcon(getResources().getDrawable(R.drawable.winner_acv))
                        .setMessage("HAS CONCLUIDO LA ACTIVIDAD GEOMETRIC FIGURES AND SPORTS," +
                                " AHORA PUEDES SEGUIR CON LA SIGUIENTE ACTIVIDAD:" +
                                Html.fromHtml("MONTHS AND SEASON OF YEAR"))
                        .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                        });
                builder.show();
            }else{
                final AlertDialog.Builder builderFather = new AlertDialog.Builder(TestSportFigure.this);
                builderFather.setTitle(Html.fromHtml("<font color='#FF0000'><b>¡ I N C O R R E C T O ! </b></font>"))
                        .setIcon(getResources().getDrawable(R.drawable.winner_acv))
                        .setMessage("LO SENTIMOS, PARA PODER PASAR ESTE TEST TIENES QUE " +
                                "OBTENER UNA CALIFICACION MAYOR Ó IGUAL A 8, TU CALIFICACIÓN " +
                                "ACTUAL ES: " + scoreTest)
                        .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                startActivity(new Intent(getApplicationContext(), GeoFigSports.class));
                            }
                        });
                builderFather.show();
            }
        }
    }
}
