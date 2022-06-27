package tools.printer;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class FilePrinter {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static boolean allowColor;

    public static void setAllowColor(boolean allowColor) {
        FilePrinter.allowColor = allowColor;
    }

    public static void print(Object obj) {
        printInColor(obj, FilePrinterColor.RESET);
    }

    public static void info(Object obj) {
        printInColor("[INFO] " + obj, FilePrinterColor.GREEN);
    }

    public static void warn(Object obj) {
        printInColor("[WARN] " + obj, FilePrinterColor.YELLOW);
    }

    public static void error(Object obj) {
        printInColor("[ERROR] " + obj, FilePrinterColor.RED);
        printStackTrace();
    }

    public static void error(Object obj, Exception ex) {
        printInColor("[ERROR] " + obj, FilePrinterColor.RED);
        ex.printStackTrace();
    }

    public static void error(Exception ex) {
        ex.printStackTrace();
    }

    private static void printStackTrace() {
        //Set Color
        System.out.print(FilePrinterColor.RED);

        //Get Stack Traces && Print Each Stack Trace
        Arrays.stream(Thread.currentThread().getStackTrace())
                .skip(3)
                .collect(Collectors.toList())
                .forEach(st -> System.out.println("\t" + st));

        //Reset Color
        System.out.println(FilePrinterColor.RESET);
    }


    private static void printInColor(Object obj, FilePrinterColor color) {
        //Set Color
        if (allowColor) {
            System.out.print(color);
        }
        //Print Time + Print Message
        System.out.printf("%s %s", dtf.format(LocalTime.now()), obj);

        //Reset Color
        if (allowColor) {
            System.out.println(FilePrinterColor.RESET);
        } else {
            System.out.println();
        }
    }
}
