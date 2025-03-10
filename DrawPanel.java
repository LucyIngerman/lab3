package src;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    // To keep track of a single car's position

    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Truck> trucks = new ArrayList<>();

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);

    BufferedImage scaniaImage;

    BufferedImage saabImage;


    void currentVehiclePositions(ArrayList<Car> currentCars, ArrayList<Truck> currentTrucks){
        cars = currentCars;
        trucks = currentTrucks;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Remember to right-click src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/saab95.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }


    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Car car: cars){
            double[] position = car.getPosition();
            BufferedImage image = null;

            if (car instanceof Volvo240){
                image = volvoImage;
            }
            if (car instanceof Saab95){
                image = saabImage;
            }

            g.drawImage(image, (int) position[0], (int) position[1], null); // see javadoc for more info on the parameters
        }
        for (Truck truck: trucks){
            double[] position = truck.getPosition();
            BufferedImage image = null;

            if (truck instanceof Scania){
                image = scaniaImage;
            }
            g.drawImage(image, (int) position[0], (int) position[1], null); // see javadoc for more info on the parameters
        }

        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}
