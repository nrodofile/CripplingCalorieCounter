package au.com.rodofile.personalcaloriecounter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nrodofile on 23/10/2016.

 CREATE TABLE Food (
    id_Food integer PRIMARY KEY AUTOINCREMENT,
    name varchar,
    kilojoules integer,
    calories integer,
    amount integer,
    mesurment varchar
 );

 */

public class FoodController extends DbOperator {

    protected static final String FIELD_ID = "id_Food";
    protected static final String FIELD_NAME = "name";
    protected static final String FIELD_KILOJOULES = "kilojoules";
    protected static final String FIELD_CALORIES = "calories";
    protected static final String FIELD_AMOUNT = "amount";
    protected static final String FIELD_MEASURMENT = "measurement";

    public FoodController(Context context) {
        super(context);
    }

    public boolean create(Food food){
        ContentValues values = new ContentValues();
        values.put(FIELD_NAME, food.getName());
        values.put(FIELD_KILOJOULES, food.getKilojoules());
        values.put(FIELD_CALORIES, food.getCalories());
        values.put(FIELD_AMOUNT, food.getAmount());
        values.put(FIELD_MEASURMENT, food.getMesurment());
        SQLiteDatabase db = this.getWritableDatabase();
        boolean createSuccessful = db.insert(TABLE_FOOD, null, values) > 0;
        db.close();
        return createSuccessful;
    }

    public List<Food> read() {

        List<Food> recordsList = new ArrayList<Food>();

        String sql = "SELECT * FROM Food ORDER BY name;";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(FIELD_ID)));
                String name = cursor.getString(cursor.getColumnIndex(FIELD_NAME));
                double calories = cursor.getDouble(cursor.getColumnIndex(FIELD_CALORIES));
                double kilojoules = cursor.getDouble(cursor.getColumnIndex(FIELD_KILOJOULES));
                int amount = cursor.getInt(cursor.getColumnIndex(FIELD_AMOUNT));
                String measurement = cursor.getString(cursor.getColumnIndex(FIELD_MEASURMENT));

                Food food = new Food();
                food.setId(id);
                food.setName(name);
                food.setCalories(calories);
                food.setKilojoules(kilojoules);
                food.setAmount(amount);
                food.setMesurment(measurement);
                recordsList.add(food);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return recordsList;
    }
}
