package mx.edu.utng.learningenglish.activities.listener;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import mx.edu.utng.learningenglish.R;


/**
 * Created by Santana on 1/21/2017.
 */
public class Alphabet extends AppCompatActivity implements View.OnClickListener{
    private ImageButton ibA;
    private ImageButton ibB;
    private ImageButton ibC;
    private ImageButton ibD;
    private ImageButton ibE;
    private ImageButton ibF;
    private ImageButton ibG;
    private ImageButton ibH;
    private ImageButton ibI;
    private ImageButton ibJ;
    private ImageButton ibK;
    private ImageButton ibL;
    private ImageButton ibM;
    private ImageButton ibN;
    private ImageButton ibO;
    private ImageButton ibP;
    private ImageButton ibQ;
    private ImageButton ibR;
    private ImageButton ibS;
    private ImageButton ibT;
    private ImageButton ibU;
    private ImageButton ibV;
    private ImageButton ibW;
    private ImageButton ibX;
    private ImageButton ibY;
    private ImageButton ibZ;
    private SoundPool soundPool;
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int uve;
    private int w;
    private int x;
    private int y;
    private int z;



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.activity_alphabet_listening);
        //regreso al menu
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //sound
        soundPool=new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        //relacion de elementos de la vista
      ibA =(ImageButton)findViewById(R.id.ib_a);
        ibB =(ImageButton)findViewById(R.id.ib_b);
        ibC =(ImageButton)findViewById(R.id.ib_c);
        ibD =(ImageButton)findViewById(R.id.ib_d);
        ibE =(ImageButton)findViewById(R.id.ib_e);
        ibF =(ImageButton)findViewById(R.id.ib_f);
        ibG =(ImageButton)findViewById(R.id.ib_g);
        ibH =(ImageButton)findViewById(R.id.ib_h);
        ibI =(ImageButton)findViewById(R.id.ib_i);
        ibJ =(ImageButton)findViewById(R.id.ib_j);
        ibK =(ImageButton)findViewById(R.id.ib_k);
        ibL =(ImageButton)findViewById(R.id.ib_l);
        ibM =(ImageButton)findViewById(R.id.ib_m);
        ibN =(ImageButton)findViewById(R.id.ib_n);
        ibO =(ImageButton)findViewById(R.id.ib_o);
        ibP =(ImageButton)findViewById(R.id.ib_p);
        ibQ =(ImageButton)findViewById(R.id.ib_q);
        ibR =(ImageButton)findViewById(R.id.ib_r);
        ibS =(ImageButton)findViewById(R.id.ib_s);
        ibT =(ImageButton)findViewById(R.id.ib_t);
        ibU =(ImageButton)findViewById(R.id.ib_u);
        ibV =(ImageButton)findViewById(R.id.ib_v);
        ibW =(ImageButton)findViewById(R.id.ib_w);
        ibX =(ImageButton)findViewById(R.id.ib_x);
        ibY =(ImageButton)findViewById(R.id.ib_y);
        ibZ=(ImageButton)findViewById(R.id.ib_z);
    //eschudaror para cada letra
        ibA.setOnClickListener(this);
        ibB.setOnClickListener(this);
        ibC.setOnClickListener(this);
        ibD.setOnClickListener(this);
        ibE.setOnClickListener(this);
        ibF.setOnClickListener(this);
        ibG.setOnClickListener(this);
        ibH.setOnClickListener(this);
        ibI.setOnClickListener(this);
        ibJ.setOnClickListener(this);
        ibK.setOnClickListener(this);
        ibL.setOnClickListener(this);
        ibM.setOnClickListener(this);
        ibN.setOnClickListener(this);
        ibO.setOnClickListener(this);
        ibP.setOnClickListener(this);
        ibQ.setOnClickListener(this);
        ibR.setOnClickListener(this);
        ibS.setOnClickListener(this);
        ibT.setOnClickListener(this);
        ibU.setOnClickListener(this);
        ibW.setOnClickListener(this);
        ibX.setOnClickListener(this);
        ibY.setOnClickListener(this);
        ibZ.setOnClickListener(this);
        ibV.setOnClickListener(this);
       // asiganacion de sonido por cada letra presionada
        a=soundPool.load(this,R.raw.lettera,1);
        b=soundPool.load(this,R.raw.letterb,1);
        c=soundPool.load(this,R.raw.letterc,1);
        d=soundPool.load(this,R.raw.letterd,1);
        e=soundPool.load(this,R.raw.lettere,1);
        f=soundPool.load(this,R.raw.letterf,1);
        g=soundPool.load(this,R.raw.letterg,1);
        h=soundPool.load(this,R.raw.letterh,1);
        i=soundPool.load(this,R.raw.letteri,1);
        j=soundPool.load(this,R.raw.letterj,1);
        k=soundPool.load(this,R.raw.letterk,1);
        l=soundPool.load(this,R.raw.letterl,1);
        m=soundPool.load(this,R.raw.letterm,1);
        n=soundPool.load(this,R.raw.lettern,1);
        o=soundPool.load(this,R.raw.lettero,1);
        p=soundPool.load(this,R.raw.letterp,1);
        q=soundPool.load(this,R.raw.letterq,1);
        r=soundPool.load(this,R.raw.letterr,1);
        s=soundPool.load(this,R.raw.letters,1);
        t=soundPool.load(this,R.raw.lettert,1);
        u=soundPool.load(this,R.raw.letteru,1);
        uve=soundPool.load(this,R.raw.letterv,1);
        w=soundPool.load(this,R.raw.letterw,1);
        x=soundPool.load(this,R.raw.letterx,1);
        y=soundPool.load(this,R.raw.lettery,1);
        z=soundPool.load(this,R.raw.letterz,1);
    }

    @Override
    public void onClick(View v) {
//reproduccion de sonido para cada boton presionado
        switch (v.getId()){
            case (R.id.ib_a):
                soundPool.play(a,1,1,0,0,1);
                break;
            case (R.id.ib_b):
                soundPool.play(b,1,1,0,0,1);
                break;
            case (R.id.ib_c):
                soundPool.play(c,1,1,0,0,1);
                break;
            case (R.id.ib_d):
                soundPool.play(d,1,1,0,0,1);
                break;
            case (R.id.ib_e):
                soundPool.play(e,1,1,0,0,1);
                break;
            case (R.id.ib_f):
                soundPool.play(f,1,1,0,0,1);
                break;
            case (R.id.ib_g):
                soundPool.play(g,1,1,0,0,1);
                break;
            case (R.id.ib_h):
                soundPool.play(h,1,1,0,0,1);
                break;
            case (R.id.ib_i):
                soundPool.play(i,1,1,0,0,1);
                break;
            case (R.id.ib_j):
                soundPool.play(j,1,1,0,0,1);
                break;
            case (R.id.ib_k):
                soundPool.play(k,1,1,0,0,1);
                break;
            case (R.id.ib_l):
                soundPool.play(l,1,1,0,0,1);
                break;
            case (R.id.ib_m):
                soundPool.play(m,1,1,0,0,1);
                break;
            case (R.id.ib_n):
                soundPool.play(n,1,1,0,0,1);
                break;
            case (R.id.ib_o):
                soundPool.play(o,1,1,0,0,1);
                break;
            case (R.id.ib_p):
                soundPool.play(p,1,1,0,0,1);
                break;
            case (R.id.ib_q):
                soundPool.play(q,1,1,0,0,1);
                break;
            case (R.id.ib_r):
                soundPool.play(r,1,1,0,0,1);
                break;
            case (R.id.ib_s):
                soundPool.play(s,1,1,0,0,1);
                break;
            case (R.id.ib_t):
                soundPool.play(t,1,1,0,0,1);
                break;
            case (R.id.ib_u):
                soundPool.play(u,1,1,0,0,1);
                break;
            case (R.id.ib_v):
                soundPool.play(uve,1,1,0,0,1);
                break;
            case (R.id.ib_w):
                soundPool.play(w,1,1,0,0,1);
                break;
            case (R.id.ib_x):
                soundPool.play(x,1,1,0,0,1);
                break;
            case (R.id.ib_y):
                soundPool.play(y,1,1,0,0,1);
                break;
            case (R.id.ib_z):
                soundPool.play(z,1,1,0,0,1);
                break;

        }
    }
}
