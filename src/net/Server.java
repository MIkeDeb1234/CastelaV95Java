package net;


import client.enums.LoginStateType;
import config.YamlConfig;
import database.DatabaseConnection;
import tools.printer.FilePrinter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

        //Reset Client Login State
        try (Connection con = DatabaseConnection.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement("UPDATE accounts SET loginStateType = ?")) {
                ps.setInt(1, LoginStateType.LOGGED_OUT.getType());
                FilePrinter.printQuery(ps);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            FilePrinter.error( e);
        }

    }
}
