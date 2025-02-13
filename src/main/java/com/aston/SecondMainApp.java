package com.aston;

import com.aston.Controllers.AnimalViewController;
import com.aston.Controllers.BoxViewController;
import com.aston.Controllers.HumanViewController;
import com.aston.entities.Animal;
import com.aston.entities.Box;
import com.aston.entities.Human;

import java.util.Scanner;

public class SecondMainApp {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        // Пример использования метода inputElement
        Comparable element = inputElement();
        System.out.println("Введенный элемент: " + element);
    }

    public static Comparable inputElement() {
        System.out.println("\nВыберите тип элемента для ввода:");
        System.out.println("1. Человек");
        System.out.println("2. Животное");
        System.out.println("3. Бочка");
        System.out.print("Ваш выбор: ");

        int choice = SCANNER.nextInt();
        SCANNER.nextLine(); // Очистка буфера после nextInt()

        switch (choice) {
            case 1:
                HumanViewController humanViewController = new HumanViewController();
                return humanViewController.UIDialogHuman();
            case 2:
                AnimalViewController animalViewController = new AnimalViewController();
                return animalViewController.UIDialogAnimal();
            case 3:
                BoxViewController boxViewController = new BoxViewController();
                return boxViewController.UIDialogBox();
            default:
                throw new IllegalArgumentException("Неверный выбор типа элемента.");
        }
    }
}
