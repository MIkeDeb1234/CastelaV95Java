import net.Server;
import tools.printer.FilePrinter;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            FilePrinter.setAllowColor(Boolean.parseBoolean(args[0]));
        }
        Server.getInstance().init();

    }
}