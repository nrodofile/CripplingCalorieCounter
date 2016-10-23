package au.com.rodofile.personalcaloriecounter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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

    protected static final String FIELD_NAME = "name";
    protected static final String FIELD_KILOJOULES = "kilojoules";
    protected static final String FIELD_CALORIES = "calories";
    protected static final String FIELD_AMOUNT = "amount";
    protected static final String FIELD_MEASURMENT = "mesurment";

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
}
