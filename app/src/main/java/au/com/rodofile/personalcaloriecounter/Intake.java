package au.com.rodofile.personalcaloriecounter;
import java.util.Date;

/**
 * Created by nrodofile on 17/10/2016.
 */

public class Intake {
    private int id;
    private Food food;
    private int consumed;
    private double calories;
    private double kilojoules;
    private Date date;

    public Intake(){}

    public Intake(int id, Food food, int consumed, double calories, double kilojoules, Date date) {
        this.id = id;
        this.food = food;
        this.consumed = consumed;
        this.calories = calories;
        this.kilojoules = kilojoules;
        this.date = date;
    }
}
