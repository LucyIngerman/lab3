package src;

import java.awt.*;


public class Scania extends tipperTruck{

    public Scania(int NrDoorsInput, double enginePowerInput, Color colorInput, double maxWeightInput,
                  int dumpBoxMaxAngleInput){
        super(NrDoorsInput, enginePowerInput, colorInput, maxWeightInput, dumpBoxMaxAngleInput);

    }

    public double speedFactor(){
        return 1;
    }

}
