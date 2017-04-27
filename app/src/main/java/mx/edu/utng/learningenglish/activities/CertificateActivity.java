package mx.edu.utng.learningenglish.activities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.learningenglish.R;
import mx.edu.utng.learningenglish.sqlite.DbHelper;

public class CertificateActivity extends AppCompatActivity {

    private final static String SETTING_USER = "setting_user";
    private String user;
    SharedPreferences sharedPreferences;
    Bitmap b;
    DbHelper db;
    private String idUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificate);
        this.setTitle("Certificate");
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        db = new DbHelper(this);

        Button btnSaveImage = (Button) findViewById(R.id.btn_save_image);
        final ImageView iv = (ImageView) findViewById(R.id.iv);
        final TextView userName = new TextView(CertificateActivity.this);

        sharedPreferences = getApplicationContext().getSharedPreferences("recuperardatos", Context.MODE_PRIVATE);
        user = sharedPreferences.getString(SETTING_USER,"");
        String name = db.getUserName(user);
        userName.setText(name);

        String str = userName.getText().toString();
        View v = new CanvasWithText(getApplicationContext(), str);
        Bitmap bm1 = null;
        bm1 = BitmapFactory.decodeResource(getResources(), R.drawable.certificate_final);

        Bitmap.Config config = bm1.getConfig();
        if(config == null){
            config = Bitmap.Config.ARGB_8888;
        }

        Bitmap bitmap = Bitmap.createBitmap(bm1.getWidth()/*width*/, bm1.getHeight()/*height*/, config);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawBitmap(bm1,0,0,null);
        v.draw(canvas);
        b = bitmap;     //for saving "b" to the sdcard
        iv.setImageBitmap(bitmap);

        btnSaveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create directory if not exist
                final File dir = new File(Environment.getExternalStorageDirectory() + File.separator + getResources().getString(R.string.app_name));
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                idUser = db.getIdUser(user);
                File output = new File(dir, "LearningEnglish"+idUser+".png");

                OutputStream os = null;

                try {
                    os = new FileOutputStream(output);
                    b.compress(Bitmap.CompressFormat.PNG, 100, os);
                    os.flush();
                    os.close();

                    final Handler handler = new Handler();

                    //this code will scan the image so that it will appear in your gallery when you open next time
                    MediaScannerConnection.scanFile(CertificateActivity.this, new String[] { output.toString() }, null,
                            new MediaScannerConnection.OnScanCompletedListener() {
                                public void onScanCompleted(String path, Uri uri) {
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(CertificateActivity.this, CertificateActivity.this.getResources().getString(R.string.str_save_image_text) + dir.getPath(), Toast.LENGTH_LONG).show();
                                        }
                                    });
                                }
                            }
                    );
                } catch (FileNotFoundException fnfe) {
                    fnfe.printStackTrace();
                } catch (IOException ioe)   {
                    ioe.printStackTrace();
                }
            }
        });

    }

    //your canvas as per your requirement
    public class CanvasWithText extends View {
        String str;
        //Drawable drawable;
        public CanvasWithText(Context context, String str) {
            super(context);
            this.str = str;
            //drawable = context.getResources().getDrawable(R.drawable.certificate_final);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            // super.onDraw(canvas);
            //Paint paint = new Paint();
            //paint.setAntiAlias(true);
            //canvas.drawRect(0, 0, 512, 512, null);
            Paint pText = new Paint(Paint.ANTI_ALIAS_FLAG);
            pText.setColor(Color.BLACK);
            pText.setTextSize(35);
            pText.setStyle(Paint.Style.FILL);
            canvas.drawText(str,263,415,pText);
            // (str, 100, 100, pText)
        }
    }

}
