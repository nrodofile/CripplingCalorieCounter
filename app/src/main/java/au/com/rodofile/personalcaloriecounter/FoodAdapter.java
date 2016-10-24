package au.com.rodofile.personalcaloriecounter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nrodofile on 24/10/2016.
 */

public class FoodAdapter extends BaseAdapter {
    Context context;
    ArrayList<Food> foods;
    private static LayoutInflater inflater;

    public FoodAdapter(Context context, ArrayList<Food> food) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.foods = food;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return foods.size();
    }

    @Override
    public Object getItem(int position) {
        return foods.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long) foods.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.layout_food, null);
        TextView textViewFoodName = (TextView) vi.findViewById(R.id.textViewFoodName);
        TextView textViewAmount = (TextView) vi.findViewById(R.id.textViewAmount);
        TextView textViewMeasurement = (TextView) vi.findViewById(R.id.textViewMeasurement);
        TextView textViewKilojoules = (TextView) vi.findViewById(R.id.textViewKilojoules);
        TextView textViewCalories = (TextView) vi.findViewById(R.id.textViewCalories);
        Food food = foods.get(position);
        textViewFoodName.setText(food.getName());
        textViewAmount.setText(Integer.toString(food.getAmount()));
        textViewCalories.setText(Double.toString(food.getCalories()));
        textViewKilojoules.setText(Double.toString(food.getKilojoules()));
        textViewMeasurement.setText(food.getMesurment());
        return vi;
    }
}
