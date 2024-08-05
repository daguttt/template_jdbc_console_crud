package org.example;

import org.example.persistence.Database;
import org.example.utils.InputRequester;

import javax.swing.*;
import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("***********************************************************");
        System.out.println("Template JDBC + MySQL CRUD App");
        System.out.println("***********************************************************");

        String host = args[0];
        String port = args[1];
        String dbName = args[2];
        String dbUser = args[3];
        String dbPassword = args[4];

        // -****************************
        // Dependency Injection
        var database = new Database(host, port, dbName, dbUser, dbPassword);
        database.testConnection();

        // Models


        // Controller


        // -****************************

        // Menu
        boolean isMenuOpened = true;
        while (isMenuOpened) {
            var menuOptionsMessage = """
                    ********************* Menu *********************

                    Ingresa la opción que deseas hacer:

                    0. Salir.
                    1. Pedir fecha.

                    ************************************************
                    """;
            var option = InputRequester.requestString(menuOptionsMessage, true);
            boolean wantsToExit = option.isEmpty();
            if (wantsToExit) return;

            switch (option) {
                case "0" -> isMenuOpened = false;
                case "1" -> {
                    runFirstOption();
                }
                default -> JOptionPane.showMessageDialog(null, "Opción inválida. Inténtalo de nuevo");
            }
        }
    }

    public static void runFirstOption() {
        var emptyDate = InputRequester.requestLocalDate("Ingresa la fecha (Presiona ENTER para omitir)",  true);
        System.out.println(emptyDate.isEmpty() ? "Está vacia": Date.valueOf(emptyDate.get()));
    }
}