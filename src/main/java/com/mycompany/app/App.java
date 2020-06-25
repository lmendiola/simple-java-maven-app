package com.mycompany.app;

/**
 * Hello world!
 */
public class App
{

    private final String message = "Hello World!";

    public App() {}

    public static void main(String[] args) {
        System.out.println(new App().getMessage());
        system.out.println("Fin ejecución");
    }

    private final String getMessage() {
        return message;
    }

}
