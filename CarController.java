package src;

import src.Car;
import src.CarView;
import src.Volvo240;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    
    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        // cc.cars.add(new Volvo240());
        Volvo240 volvo = new Volvo240(4, 70, Color.red, 4, 30, 1.4);
        cc.cars.add(volvo);
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getPosition()[0]);
                int y = (int) Math.round(car.getPosition()[1]);
                frame.drawPanel.moveit(x, y);
                // System.out.printf("X: %s, Y: %s", x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
       for (Car car : cars){
            car.gas(gas);
        }
    }

    void startCar() {
        for(Car car: cars){
            car.startEngine();
        }
    }

    void brakeCar(double amount){
        double brake = ((double) amount) / 100;

        for(Car car: cars){
            car.brake(brake);
        }
    }

    void stopCar(){
        for (Car car: cars){
            car.stopEngine();
        }
    }
}

