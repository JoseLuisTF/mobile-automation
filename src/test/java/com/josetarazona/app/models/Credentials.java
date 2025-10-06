package com.josetarazona.app.models;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Credentials {
    private final String username;
    private final String password;

    private Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }

    public static Credentials fromProperties() {
        Properties properties = new Properties();
        try (InputStream input = Credentials.class.getClassLoader().getResourceAsStream("user-data.properties")) {
            if (input == null) {
                throw new RuntimeException("No se encontró user-data.properties");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo user-data.properties", e);
        }
        return new Credentials(properties.getProperty("username"), properties.getProperty("password"));
    }
}
