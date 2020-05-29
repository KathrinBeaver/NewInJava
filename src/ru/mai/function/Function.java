package ru.mai.function;

public interface Function {

    double calculate(int x);

    default double sqrt(int x) {
        return Math.sqrt(x);
    }
}
