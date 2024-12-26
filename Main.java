import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {

    public static void main(String[] args) {
        // First window
        Gui mainWindow = new Gui(0, 0, 300, 400, "Mitt första GUI!", EXIT_ON_CLOSE);

        // Second window
        Gui secondWindow = new Gui(50, 50, 400, 400, "Mitt andra GUI!", DISPOSE_ON_CLOSE, mainWindow);

        // Third window
        Gui thirdWindow = new Gui(50, 50, 300, 200, "Mitt tredje GUI!", DISPOSE_ON_CLOSE, secondWindow);

        //  button
        secondWindow.createButton("red");
        secondWindow.createButton("blue");
        secondWindow.createButton("green");

        // Elements for third window
        thirdWindow.createElementsForThirdWindow(thirdWindow.getFrame());

        // Fourth window
        Gui fourthWindow = new Gui(200, 500, 300, 200, "Mitt fjärde GUI!", DISPOSE_ON_CLOSE, thirdWindow);

        fourthWindow.CreateIconButtons("Surfa", fourthWindow.getFrame());
        fourthWindow.CreateIconButtons("Måla", fourthWindow.getFrame());
        fourthWindow.CreateIconButtons("Låda", fourthWindow.getFrame());
    }
}
