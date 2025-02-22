package src;

import java.awt.*;

public abstract class Car extends Vehicle{
    private final int nrSeats;
    private double weight;
    private final double width;

    public Car(int NrDoorsInput, double enginePowerInput, Color colorInput, int nrSeatsInput, double weightInput,
               double widthInput){
        super(NrDoorsInput, enginePowerInput, colorInput);
        nrSeats = nrSeatsInput;
        weight = weightInput;
        width = widthInput;

    }

    public int getNrSeats(){
        return nrSeats;
    }

    public double getWeight(){
        return weight;
    }

    public void setWeight(double amount){
        weight = amount;
    }

    public double getWidth(){
        return width;
    }

}

