package au.com.rodofile.personalcaloriecounter;

/**
 * Created by nrodofile on 17/10/2016.
 */

public class Food {
    private int id;
    private String name;
    private double kilojoules;
    private double calories;
    private int amount;
    private String mesurment;

    public Food(){}

    public Food(int id, String name, double kilojoules, double calories, int amount, String mesurment) {
        this.id = id;
        this.name = name;
        this.kilojoules = kilojoules;
        this.calories = calories;
        this.amount = amount;
        this.mesurment = mesurment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getKilojoules() {
        return kilojoules;
    }

    public void setKilojoules(double kilojoules) {
        this.kilojoules = kilojoules;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMesurment() {
        return mesurment;
    }

    public void setMesurment(String mesurment) {
        this.mesurment = mesurment;
    }
}
