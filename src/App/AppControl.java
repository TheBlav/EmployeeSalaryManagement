package App;

import IO.Printer;
import IO.io;


public class AppControl implements Printer {

    public void appControl() {
        io inOut = new io();
        inOut.io();
        inOut.printEmployees();
        printer(inOut.getTotalCosts());

    }
}
