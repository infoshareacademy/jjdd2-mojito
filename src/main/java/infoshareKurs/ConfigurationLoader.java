package infoshareKurs;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ConfigurationLoader {


    public static Configuration getConfiguration() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Configuration configuration;
            configuration = objectMapper.readerFor(Configuration.class).readValue(
                    Configuration.class.getResourceAsStream("/config.json"));
            return configuration;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}