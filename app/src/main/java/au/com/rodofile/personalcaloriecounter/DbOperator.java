package au.com.rodofile.personalcaloriecounter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nrodofile on 23/10/2016.
 */

public class DbOperator extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PersonalCalorieCounter";
    protected static final String TABLE_FOOD = "Food";
    protected static final String TABLE_INTAKE = "Intake";
    protected static final String TABLE_DAY = "Day";
    protected static final String TABLE_DAY_INTAKE = "Day_Intake";

    public static final String CREATE_TABLE_FOOD =
            "CREATE TABLE IF NOT EXISTS Food (" +
                    "id_Food integer PRIMARY KEY AUTOINCREMENT," +
                    "name varchar," +
                    "kilojoules integer," +
                    "calories integer," +
                    "amount integer," +
                    "mesurment varchar" +
                    ");";
    public static final String CREATE_TABLE_INTAKE =
            "CREATE TABLE IF NOT EXISTS Intake (" +
                    "id_Intake integer PRIMARY KEY AUTOINCREMENT," +
                    "id_Food integer," +
                    "consumed integer," +
                    "calories integer," +
                    "kilojoules integer," +
                    "date_Intake datetime" +
                    ");";
    public static final String CREATE_TABLE_DAY =
            "CREATE TABLE IF NOT EXISTS Day (" +
                    "id_day integer PRIMARY KEY AUTOINCREMENT," +
                    "date_day datetime," +
                    "total_calories integer," +
                    "total_kilojoules integer" +
                    ");";
    public static final String CREATE_TABLE_DAY_INTAKE =
            "CREATE TABLE IF NOT EXISTS Day_Intake (" +
                    "id_day integer," +
                    "id_Intake integer" +
                    ");";
    public static final String DROP_TABLE_FOOD = "DROP TABLE IF EXISTS Food";
    public static final String DROP_TABLE_INTAKE = "DROP TABLE IF EXISTS Intake";
    public static final String DROP_TABLE_DAY = "DROP TABLE IF EXISTS Day";
    public static final String DROP_TABLE_DAY_INTAKE = "DROP TABLE IF EXISTS Day_Intake";

    public DbOperator(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_FOOD);
        db.execSQL(CREATE_TABLE_INTAKE);
        db.execSQL(CREATE_TABLE_DAY);
        db.execSQL(CREATE_TABLE_DAY_INTAKE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_FOOD);
        db.execSQL(DROP_TABLE_INTAKE);
        db.execSQL(DROP_TABLE_DAY);
        db.execSQL(DROP_TABLE_DAY_INTAKE);
        onCreate(db);
    }
}
