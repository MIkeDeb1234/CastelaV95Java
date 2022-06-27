package database;

import config.YamlConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                YamlConfig.getConfig().ServerConfig.DbUrl
                ,YamlConfig.getConfig().ServerConfig.DbUser
                ,YamlConfig.getConfig().ServerConfig.DbPass);
    }
}
