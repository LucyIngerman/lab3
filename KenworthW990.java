package src;

import java.awt.Color;

public class KenworthW990 extends CarHaulerTruck{
    
    public KenworthW990(Color colorInput){
        super(2, 405, colorInput,200, 6, 2.5);
    }

    public double speedFactor(){
        return 1;
    }
}
