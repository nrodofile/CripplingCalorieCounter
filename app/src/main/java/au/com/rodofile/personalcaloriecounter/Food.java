package au.com.rodofile.personalcaloriecounter;

/**
 * Created by nrodofile on 17/10/2016.
 */

public class Food {
    private int id;
    private String name;
    private int kilojoules;
    private int calories;
    private int amount;
    private String mesurment;

    public Food(){}

    public Food(int id, String name, int kilojoules, int calories, int amount, String mesurment) {
        this.id = id;
        this.name = name;
        this.kilojoules = kilojoules;
        this.calories = calories;
        this.amount = amount;
        this.mesurment = mesurment;
    }
}
