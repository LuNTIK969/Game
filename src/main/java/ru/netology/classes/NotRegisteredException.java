package ru.netology.classes;

public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException (String name) {
        super("Пользователь с именем " + name + " не обнаружен.");
    }
}

