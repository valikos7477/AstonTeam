package com.aston.utils;

public class FileHandler {
    static int validateFileString(String s) {
        // Пример простой валидации: строка должна содержать хотя бы один символ '#'
        return s.contains("#") ? 0 : -1;
    }
}
