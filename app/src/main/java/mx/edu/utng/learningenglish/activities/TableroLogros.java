package mx.edu.utng.learningenglish.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.PercentFormatter;

import java.util.ArrayList;
import mx.edu.utng.learningenglish.R;
import mx.edu.utng.learningenglish.sqlite.DbHelper;

@SuppressLint("SetJavaScriptEnabled") 
public class TableroLogros extends ActionBarActivity {
	DbHelper helper;
	private String idUser;
	private final static String SETTING_USER = "setting_user";
	private String user;
	SharedPreferences sharedPreferences;
	public static final  String SCORE_TABLE="scores";
	public static final String COLUMN_ID = "user_id";
	/*WebView webView;
	double test1, test2, test3, test4, test5, testFinal;
	DbHelper helper;
	private String idUser;
	private final static String SETTING_USER = "setting_user";
	private String user;
	SharedPreferences sharedPreferences;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setTitle("Tablero de Logros");
        setContentView(R.layout.tablero_logors);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);


		helper = new DbHelper(this);
		sharedPreferences = getApplicationContext().getSharedPreferences("recuperardatos", Context.MODE_PRIVATE);
		user = sharedPreferences.getString(SETTING_USER,"");
		idUser = helper.getIdUser(user);
		String calif1 = helper.getScore(idUser, 1);
		String calif2 = helper.getScore(idUser, 2);
		String calif3 = helper.getScore(idUser, 3);
		String calif4 = helper.getScore(idUser, 4);
		String calif5 = helper.getScore(idUser, 5);
		String calif6 = helper.getScore(idUser, 6);

		if(calif1==null){
			test1=0;
		}else{
			test1=Double.parseDouble(calif1);
		} if(calif2==null){
			test2=0;
		}else{
			test2=Double.parseDouble(calif2);
		} if(calif3==null){
			test3=0;
		}else{
			test3=Double.parseDouble(calif3);
		} if (calif4==null){
			test4=0;
		}else {
			test4=Double.parseDouble(calif4);
		}if (calif5==null){
			test5=0;
		}else{
			test5=Double.parseDouble(calif5);
		} if(calif6==null){
			testFinal=0;
		}else{
			testFinal=Double.parseDouble(calif6);
		}


        Intent intent = getIntent();
        test1 = intent.getDoubleExtra("Test One", test1);
        test2 = intent.getDoubleExtra("Test Two", test2);
        test3 = intent.getDoubleExtra("Test Three", test3);
        test4 = intent.getDoubleExtra("Test Four", test4);
        test5 = intent.getDoubleExtra("Test Five", test5);
        testFinal = intent.getDoubleExtra("Final test", testFinal);

        webView = (WebView)findViewById(R.id.wb_tablero_logros);
        webView.addJavascriptInterface(new WebAppInterface(), "Android");

        webView.getSettings().setJavaScriptEnabled(true); 
        webView.loadUrl("file:///android_asset/index.html");
	}

	public class WebAppInterface {

	    @JavascriptInterface
		public double getTest1() {
			return test1;
		}
		
		@JavascriptInterface
		public double getTest2() {
			return test2;
		}
		
		@JavascriptInterface
		public double getTest3() {
			return test3;
		}
		
		@JavascriptInterface
		public double getTest4() {
			return test4;
		}
		
		@JavascriptInterface
		public double getTest5() {
			return test5;
		}

		@JavascriptInterface
		public double getTestFinal() {
			return testFinal;
		}

	}*/
	private View viewToBeCaptured;
	Bitmap b;
	private RelativeLayout graficaLayout;
	private PieChart grafica;
	private float[] yData;
	private String[] xData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tablero_logors);
		helper = new DbHelper(this);
		sharedPreferences = getApplicationContext().getSharedPreferences("recuperardatos", Context.MODE_PRIVATE);
		user = sharedPreferences.getString(SETTING_USER,"");
		idUser = helper.getIdUser(user);
		int puntuacion=0;

		try{
			SQLiteDatabase db = new DbHelper(TableroLogros.this).getReadableDatabase();
			Cursor c = db.rawQuery(" SELECT sum(score_score) FROM "+ SCORE_TABLE +"  WHERE "+COLUMN_ID+ " = "+"'"+idUser+"'", null);
			//select "+COLUMN_SCORE_SCORE+" from "+ SCORE_TABLE +" where "+COLUMN_ID+ " = "+"'"+idUser+"' and "+COLUMN_ACTIVITY_ID+" = "+idActivity+";"
			c.moveToFirst();
			//if(c.moveToFirst()){
			//	do{
					puntuacion = c.getInt(0);
				//}while(c.moveToNext());
			//}
			c.close();



		}catch (Exception e){
			Log.i("EXECPION -", puntuacion + "");

		}

		yData = new float[]{puntuacion, 60 - puntuacion};
		xData = new String[]{"Cursado", "Restante"};



		graficaLayout = (RelativeLayout)findViewById(R.id.grafica_layout);
		grafica = new PieChart(this);

		// agregar la Grafica al layout
		graficaLayout.addView(grafica);
		graficaLayout.setBackgroundColor(Color.LTGRAY);

		// configurar la Grafica
		grafica.setUsePercentValues(true);


		//
		grafica.setDrawHoleEnabled(true);
		grafica.setHoleRadius(50);
		grafica.setTransparentCircleRadius(1);
		grafica.setHoleColorTransparent(true);

		//
		grafica.setRotationAngle(0);
		grafica.setRotationEnabled(true);

		grafica.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
			@Override
			public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
				if (e==null){
					return;
				}
				// Toast.makeText(Grafica.this,xData[e.getXIndex()] + " = " + e.getVal() + " % ",
				//       Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected() {

			}
		});

		// Agregar datos
		addData();

		// customizando leyendas
		Legend l = grafica.getLegend();
		l.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
		l.setXEntrySpace(7);
		l.setYEntrySpace(5);



	}

	/**
	 * Implementacion de los datos dentro de la grafica
	 */
	private void addData() {
		ArrayList<Entry> yVals1 = new ArrayList<Entry>();

		for (int i=0; i<yData.length; i++){
			yVals1.add(new Entry(yData[i],i));
		}

		ArrayList<String> xVals = new ArrayList<String>();

		for (int i=0; i < xData.length;i++){
			xVals.add(xData[i]);
		}

		//
		PieDataSet dataSet = new PieDataSet(yVals1,"");
		dataSet.setSliceSpace(3);
		dataSet.setSelectionShift(5);

		// agregar colores
		ArrayList<Integer> colores = new ArrayList<Integer>();

		for (int c: ColorTemplate.JOYFUL_COLORS){
			colores.add(c);
		}

		colores.add(ColorTemplate.getHoloBlue());
		dataSet.setColors(colores);

		// instanciar el objeto data
		PieData data = new  PieData(xVals,dataSet);
		data.setValueFormatter(new PercentFormatter());
		data.setValueTextSize(11f);
		data.setValueTextColor(Color.GRAY);

		grafica.setData(data);
		grafica.highlightValues(null);
		grafica.invalidate();
	}





}
