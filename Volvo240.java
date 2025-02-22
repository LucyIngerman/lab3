package src;

import java.awt.*;

public class Volvo240 extends Car{


    public Volvo240(int NrDoorsInput, double enginePowerInput, Color colorInput, int nrSeatsInput, double weightInput,
                  double widthInput){
        super(NrDoorsInput, enginePowerInput, colorInput, nrSeatsInput, weightInput, widthInput);
    }

    public double speedFactor(){
        return 1;
    }
}
