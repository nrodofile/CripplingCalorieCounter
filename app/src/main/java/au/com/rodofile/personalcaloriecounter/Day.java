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
    private int totalCalories;
    private int totalKilojoules;

    public Day(){}

    public Day(int id, Date date, Intake[] intake, int totalCalories, int totalKilojoules) {
        this.id = id;
        this.date = date;
        this.intake = intake;
        this.totalCalories = totalCalories;
        this.totalKilojoules = totalKilojoules;
    }
}
