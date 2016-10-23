package au.com.rodofile.personalcaloriecounter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class FoodActivity extends AppCompatActivity {
    FoodController food_controller = new FoodController(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        String[] measurementSpinner = new String[] {
                "grams", "millilitres"
        };
        Spinner s = (Spinner) findViewById(R.id.spinnerMeasurement);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, measurementSpinner);
        s.setAdapter(adapter);
        Button buttonCreateFood = (Button) findViewById(R.id.buttonSaveFood);
        buttonCreateFood.setOnClickListener(CreateFood);
    }

    private void showToast(CharSequence text){
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();
    }

    View.OnClickListener CreateFood = new View.OnClickListener() {
        public void onClick(View v) {
            final EditText editTextName = (EditText) findViewById(R.id.EditTextName);
            final EditText editTextKilojoules = (EditText) findViewById(R.id.EditTextKilojoules);
            final EditText editTextCalories = (EditText) findViewById(R.id.EditTextCalories);
            final EditText editTextAmount = (EditText) findViewById(R.id.EditTextAmount);
            final Spinner spinnerMeasurement = (Spinner) findViewById(R.id.spinnerMeasurement);

            String name = editTextName.getText().toString();
            int kilojoules = Integer.parseInt(editTextKilojoules.getText().toString());
            int calories = Integer.parseInt(editTextCalories.getText().toString());
            int amount = Integer.parseInt(editTextAmount.getText().toString());
            String measurment = spinnerMeasurement.getSelectedItem().toString();
            Food food = new Food();
            food.setName(name);
            food.setKilojoules(kilojoules);
            food.setCalories(calories);
            food.setAmount(amount);
            food.setMesurment(measurment);

            boolean results = food_controller.create(food);
            CharSequence text = name + " Failed to add";
            if (results){
                text = name + " Added";
            }
            showToast(text);
        }
    };
}
