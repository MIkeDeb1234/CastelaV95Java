package net;


import tools.printer.FilePrinter;

import java.sql.Connection;

public class Server {
    //region Singleton
    private static Server instance;

    public static Server getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new Server();
        return instance;
    }

    //endregion

    public void init() {
        //Say Starting Message
        FilePrinter.info("Starting Castela V95");

        //TODO - Reset Client Login State
    }
}
