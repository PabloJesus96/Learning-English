package mx.edu.utng.learningenglish.menu;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import mx.edu.utng.learningenglish.R;

/**
 * Created by Alumno on 24/01/2017.
 */
public class Preferences extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set content view
        addPreferencesFromResource(R.xml.preferences);

    }
}
