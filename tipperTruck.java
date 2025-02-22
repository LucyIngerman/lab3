package src;

import java.awt.*;

public abstract class tipperTruck extends Truck{
    private final int dumpBoxMaxAngle;
    private int currentdumpBoxAngle = 0;


    public tipperTruck(int NrDoorsInput, double enginePowerInput, Color colorInput, double maxWeightInput,
                       int dumpBoxMaxAngleInput){
        super(NrDoorsInput, enginePowerInput, colorInput, maxWeightInput);
        dumpBoxMaxAngle = dumpBoxMaxAngleInput;
    }

    @Override public void startEngine(){
        if (getCurrentdumpBoxAngle() > 0){
            return;
        }
        super.startEngine();
    }


    public void loadCarriage(double inputWeight){
        setTransportationWeight(inputWeight + getTransportationWeight());
    }

    public void unloadCarriage(){
        setTransportationWeight(0);
    }

    public final int getCurrentdumpBoxAngle(){
        return currentdumpBoxAngle;
    }


    public void raiseDumpBox(int inputAngle){

        if (getCurrentSpeed() > 0){
            return;
        }

        if (inputAngle < 0){
            inputAngle = 0;
        }
        if (inputAngle + currentdumpBoxAngle > dumpBoxMaxAngle){
            currentdumpBoxAngle = dumpBoxMaxAngle;
        }
        else{
            currentdumpBoxAngle += inputAngle;
        }
    }

    public void lowerDumpBox(int inputAngle){



        if (inputAngle > 0){
            inputAngle = 0;
        }

        if (currentdumpBoxAngle - inputAngle < 0){
            currentdumpBoxAngle = 0;
        }
        else{
            currentdumpBoxAngle -= inputAngle;
        }
    }
}