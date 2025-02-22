package src;

import java.awt.*;


public abstract class Vehicle implements IMovable{       // Why extend from movable?
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double currentSpeed = 0;
    private char direction = 'E';
    private double x = 0;
    private double y = 0;
    private boolean engineOn = false;


    public Vehicle(int NrDoorsInput, double enginePowerInput, Color colorInput){
        nrDoors = NrDoorsInput;
        enginePower = enginePowerInput;
        color = colorInput;
    }


    public void move(){
        // n w s e
        switch(direction){
            case 'N':
                y += currentSpeed;
            case 'W':
                x -= currentSpeed;
            case 'S':
                y -= currentSpeed;
            case 'E':
                x += currentSpeed;
        }
    }

    public void turnLeft(){
        switch(direction){
            case 'N':
                direction = 'W';
            case 'W':
                direction = 'S';
            case 'S':
                direction = 'E';
            case 'E':
                direction = 'N';
            default:
                direction = 'N';
        }
    }
    public void turnRight(){
        switch(direction){
            case 'N':
                direction = 'E';
            case 'E':
                direction = 'S';
            case 'S':
                direction = 'W';
            case 'W':
                direction = 'N';
            default:
                direction = 'N';
        }
    }


    public double[] getPosition(){
        
        return new double[]{x, y};
    }

    

    public void setPosition(double xPos, double yPos){
        x = xPos;
        y = yPos;
    }

    public final int getNrDoors(){
        return nrDoors;
    }
    public final double getEnginePower(){
        return enginePower;
    }

    public final double getCurrentSpeed(){
        return currentSpeed;
    }

    public final Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    if (!engineOn){
            engineOn = true;
            System.out.printf("GOGOGO");
        }
    }

    public void stopEngine(){
	    if (engineOn){
            engineOn = false;
            currentSpeed = 0;
        }
    }

    public boolean getEngineStatus(){
        return engineOn;
    }


    public abstract double speedFactor();

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void gas(double amount){
        if (!engineOn){
            return;
        }
        System.out.println(amount);


        if  (amount >= 0 && amount <= 1){
            incrementSpeed(amount);
        }
    }

    public void brake(double amount){
        System.out.println(amount);

        if  (amount >= 0 && amount <= 1){
            decrementSpeed(amount);
        }
    }
}

