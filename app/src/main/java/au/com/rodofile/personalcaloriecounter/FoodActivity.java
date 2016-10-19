package au.com.rodofile.personalcaloriecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class FoodActivity extends AppCompatActivity {
    private String[] measurementSpinner;
    Food food = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        this.measurementSpinner = new String[] {
                "grams", "millilitres"
        };
        Spinner s = (Spinner) findViewById(R.id.spinnerMeasurement);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, measurementSpinner);
        s.setAdapter(adapter);
    }
}
