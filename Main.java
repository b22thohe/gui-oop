import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {

    public static void main(String[] args) {
        // First window
        Gui mainWindow = new Gui(0, 0, 300, 400, "Mitt första GUI!", EXIT_ON_CLOSE);

        // Second window
        Gui secondWindow = new Gui(50, 50, 400, 400, "Mitt andra GUI!", DISPOSE_ON_CLOSE, mainWindow);

        // Red button
        secondWindow.createButton("red");
        secondWindow.createButton("blue");
        secondWindow.createButton("green");

    }
}
