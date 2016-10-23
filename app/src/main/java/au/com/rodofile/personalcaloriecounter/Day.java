package au.com.rodofile.personalcaloriecounter;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by nrodofile on 17/10/2016.
 */

public class Day {
    private int id;
    private Date date;
    private Intake[] intake;
    private int total_calories;
    private int total_kilojoules;

    public Day(){}

    public Day(int id, Date date, Intake[] intake, int total_calories, int total_kilojoules) {
        this.id = id;
        this.date = date;
        this.intake = intake;
        this.total_calories = total_calories;
        this.total_kilojoules = total_kilojoules;
    }
}
