package au.com.rodofile.personalcaloriecounter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {
    FoodController food_controller = new FoodController(this);
    ArrayList<String> foodArrayList = new ArrayList<String>();
    ArrayAdapter<String> adapter_food;

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
        EditText editTextCalories = (EditText) findViewById(R.id.EditTextCalories);
        EditText editTextKilojoules = (EditText) findViewById(R.id.EditTextKilojoules);
        editTextCalories.setOnFocusChangeListener(cal_to_kj);
        editTextKilojoules.setOnFocusChangeListener(kj_to_cal);

        ListView ListViewFood = (ListView) findViewById(R.id.ListViewFood);
        this.adapter_food = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, foodArrayList);
        ListViewFood.setAdapter(adapter_food);
        appendFoods();
    }

    private void appendFoods(){
        foodArrayList.clear();
        List<Food> foods = this.food_controller.read();
        for (Food food: foods) {
            foodArrayList.add(food.getName());
        }
        this.adapter_food.notifyDataSetChanged();
    }

    private void showToast(CharSequence text){
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();
    }

    View.OnFocusChangeListener cal_to_kj = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            double cal_in_kj = 0.239006;
            EditText editTextCalories = (EditText) findViewById(R.id.EditTextCalories);
            EditText editTextKilojoules = (EditText) findViewById(R.id.EditTextKilojoules);
            String kilojoules_str = editTextKilojoules.getText().toString();
            if(kilojoules_str.length() > 0) {
                double kilojoules = Double.parseDouble(kilojoules_str);
                double calories = (cal_in_kj * kilojoules);
                String calories_string = Double.toString(calories);
                editTextCalories.setText(calories_string);
            }
        }
    };

    View.OnFocusChangeListener kj_to_cal = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            double kj_in_cal = 4.184;
            EditText editTextKilojoules = (EditText) findViewById(R.id.EditTextKilojoules);
            EditText editTextCalories = (EditText) findViewById(R.id.EditTextCalories);
            String calories_str = editTextCalories.getText().toString();
            if(calories_str.length() > 0){
                double calories = Double.parseDouble(calories_str);
                Double kilojoules = kj_in_cal * calories;
                String kilojoules_string = Double.toString(kilojoules);
                editTextKilojoules.setText(kilojoules_string);
            }

        }
    };

    View.OnClickListener CreateFood = new View.OnClickListener() {
        public void onClick(View v) {
            final EditText editTextName = (EditText) findViewById(R.id.EditTextName);
            final EditText editTextKilojoules = (EditText) findViewById(R.id.EditTextKilojoules);
            final EditText editTextCalories = (EditText) findViewById(R.id.EditTextCalories);
            final EditText editTextAmount = (EditText) findViewById(R.id.EditTextAmount);
            final Spinner spinnerMeasurement = (Spinner) findViewById(R.id.spinnerMeasurement);

            String name = editTextName.getText().toString();
            double kilojoules = Double.parseDouble(editTextKilojoules.getText().toString());
            double calories = Double.parseDouble(editTextCalories.getText().toString());
            int amount = Integer.parseInt(editTextAmount.getText().toString());
            String measurement = spinnerMeasurement.getSelectedItem().toString();
            Food food = new Food();
            food.setName(name);
            food.setKilojoules(kilojoules);
            food.setCalories(calories);
            food.setAmount(amount);
            food.setMesurment(measurement);

            boolean results = food_controller.create(food);
            CharSequence text = name + " Failed to add";
            if (results){
                text = name + " Added";
                editTextName.setText("");
                editTextKilojoules.setText("");
                editTextCalories.setText("");
                editTextAmount.setText("");
            }
            showToast(text);
            appendFoods();
        }
    };
}
