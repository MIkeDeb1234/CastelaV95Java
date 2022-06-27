package config;

import com.esotericsoftware.yamlbeans.YamlReader;
import net.Server;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class YamlConfig {
    private static final String fromFileStr = "config.yaml";
    private static YamlConfig config = fromFile();

    public ServerConfig ServerConfig;

    public static YamlConfig getConfig() {
        return config;
    }


    private static void reloadYaml() {
        config = fromFile();
    }

    private static YamlConfig fromFile() {
        try {
            YamlReader reader = new YamlReader(new FileReader(fromFileStr));
            YamlConfig config = reader.read(YamlConfig.class);
            reader.close();
            return config;
        } catch (FileNotFoundException e) {
            String message = "Could not read config file " + fromFileStr + ": " + e.getMessage();
            throw new RuntimeException(message);
        } catch (IOException e) {
            String message = "Could not successfully parse config file " + fromFileStr + ": " + e.getMessage();
            throw new RuntimeException(message);
        }
    }
}
