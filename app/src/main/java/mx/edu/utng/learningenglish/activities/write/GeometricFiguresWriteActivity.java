package mx.edu.utng.learningenglish.activities.write;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.learningenglish.R;

public class GeometricFiguresWriteActivity extends AppCompatActivity {
    private TextView tvRectangle;
    private TextView tvDiamond;
    private TextView tvCross;
    private TextView tvTriangle;
    private TextView tvArrow;
    private TextView tvPentagon;
    private TextView tvSquare;
    private TextView tvCircle;
    private TextView tvStar;
    private TextView tvHexagon;
    private TextView tvHeart;

    private EditText etRectangle;
    private EditText etDiamond;
    private EditText etCross;
    private EditText etTriangle;
    private EditText etArrow;
    private EditText etPentagon;
    private EditText etSquare;
    private EditText etCircle;
    private EditText etStar;
    private EditText etHexagon;
    private EditText etHeart;
    private Button btVerificar;
    private int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometric_figures_write);
        this.setTitle("Geometric Figures Writing");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        tvRectangle = (TextView) findViewById(R.id.tv_question_rectangle);
        tvDiamond = (TextView) findViewById(R.id.tv_question_diamond);
        tvCross = (TextView) findViewById(R.id.tv_question_cross);
        tvTriangle = (TextView) findViewById(R.id.tv_question_triangle);
        tvArrow = (TextView) findViewById(R.id.tv_question_arrow);
        tvPentagon = (TextView) findViewById(R.id.tv_question_pentagon);
        tvSquare = (TextView) findViewById(R.id.tv_question_square);
        tvCircle = (TextView) findViewById(R.id.tv_question_circle);
        tvStar = (TextView) findViewById(R.id.tv_question_star);
        tvHexagon = (TextView) findViewById(R.id.tv_question_hexagon);
        tvHeart = (TextView) findViewById(R.id.tv_question_heart);

        etRectangle = (EditText) findViewById(R.id.et_rectangle);
        etDiamond = (EditText) findViewById(R.id.et_diamond);
        etCross = (EditText) findViewById(R.id.et_cross);
        etTriangle = (EditText) findViewById(R.id.et_triangle);
        etArrow = (EditText) findViewById(R.id.et_arrow);
        etPentagon = (EditText) findViewById(R.id.et_pentagon);
        etSquare = (EditText) findViewById(R.id.et_square);
        etCircle = (EditText) findViewById(R.id.et_circle);
        etStar = (EditText) findViewById(R.id.et_star);
        etHexagon = (EditText) findViewById(R.id.et_hexagon);
        etHeart = (EditText) findViewById(R.id.et_heart);
        btVerificar = (Button) findViewById(R.id.bt_verificar);
        btVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String rectangle = etRectangle.getText().toString();
                String diamond = etDiamond.getText().toString();
                String cross = etCross.getText().toString();
                String triangle = etTriangle.getText().toString();
                String arrow = etArrow.getText().toString();
                String pentagon = etPentagon.getText().toString();
                String square = etSquare.getText().toString();
                String circle = etCircle.getText().toString();
                String star = etStar.getText().toString();
                String hexagon = etHexagon.getText().toString();
                String heart = etHeart.getText().toString();
                if (rectangle.isEmpty() || diamond.isEmpty() || cross.isEmpty() || triangle.isEmpty() ||
                        arrow.isEmpty() || pentagon.isEmpty() || square.isEmpty() || circle.isEmpty() ||
                        star.isEmpty() || hexagon.isEmpty() || heart.isEmpty()) {
                    etRectangle.setError("You should write in the box", Drawable.createFromPath(rectangle));
                    etDiamond.setError("You should write in the box", Drawable.createFromPath(diamond));
                    etCross.setError("You should write in the box", Drawable.createFromPath(cross));
                    etTriangle.setError("You should write in the box", Drawable.createFromPath(triangle));
                    etArrow.setError("You should write in the box", Drawable.createFromPath(arrow));
                    etPentagon.setError("You should write in the box", Drawable.createFromPath(pentagon));
                    etSquare.setError("You should write in the box", Drawable.createFromPath(square));
                    etCircle.setError("You should write in the box", Drawable.createFromPath(circle));
                    etStar.setError("You should write in the box", Drawable.createFromPath(star));
                    etHeart.setError("You should write in the box", Drawable.createFromPath(heart));
                    etHexagon.setError("You should write in the box", Drawable.createFromPath(hexagon));


                }
                else if (!rectangle.equals("rectangle")) {
                    etRectangle.setError("Do not be write correct", Drawable.createFromPath(rectangle));
                } else count=count+1;  if (!diamond.equals("diamond")) {
                    etDiamond.setError("Do not be write correct", Drawable.createFromPath(diamond));
                } else count=count+1; if (!cross.equals("cross")) {
                    etCross.setError("Do not be write correct", Drawable.createFromPath(cross));
                } else count=count+1; if (!triangle.equals("triangle")) {
                    etTriangle.setError("Do not be write correct", Drawable.createFromPath(triangle));
                } else count=count+1; if (!arrow.equals("arrow")) {
                    etArrow.setError("Do not be write correct", Drawable.createFromPath(arrow));
                } else count=count+1; if (!pentagon.equals("pentagon")) {
                    etPentagon.setError("Do not be write correct", Drawable.createFromPath(pentagon));
                } else count=count+1; if (!square.equals("square")) {
                    etSquare.setError("Do not be write correct", Drawable.createFromPath(square));
                } else count=count+1; if (!circle.equals("circle")) {
                    etCircle.setError("Do not be write correct", Drawable.createFromPath(circle));
                } else count=count+1; if(!star.equals("star")){
                    etStar.setError("Do not be write correct", Drawable.createFromPath(star));
                } else count=count+1; if (!heart.equals("heart")){
                    etHeart.setError("Do not be write correct", Drawable.createFromPath(heart));
                } else count=count+1; if(!hexagon.equals("hexagon")){
                    etHexagon.setError("Do not be write correct", Drawable.createFromPath(hexagon));
                }count=count+1;


            }
        });
        Toast.makeText(this, "Yo have "+count +" correct answers", Toast.LENGTH_SHORT).show();
    }






}
