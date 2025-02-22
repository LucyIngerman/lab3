package src;

import java.awt.*;

public class Saab95 extends Car{

    public boolean turboOn = false;

    public Saab95(int NrDoorsInput, double enginePowerInput, Color colorInput, int nrSeatsInput, double weightInput,
                  double widthInput){
        super(NrDoorsInput, enginePowerInput, colorInput, nrSeatsInput, weightInput, widthInput);
    }
    
    public double speedFactor(){
        return 1;
    }

}
