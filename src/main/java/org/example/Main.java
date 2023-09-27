package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<String, Animal> registry = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создаем животное Мурка и добавляем его в реестр
        Animal murka = new Cat("Мурка", "10.12.2021");
        murka.addCommand("мяу мяу");
        registry.put("Мурка", murka);

// Создаем животное Шарик и добавляем его в реестр
        Animal sharik = new Dog("Шарик", "02.03.2019");
        sharik.addCommand("фас");
        registry.put("Шарик", sharik);


        while (true) {
            System.out.println(" ");
            System.out.println("Что вы хотите сделать: ");
            System.out.println("1 - Список всех животных");
            System.out.println("2 - Завести новое животное");
            System.out.println("3 - Определить животное в правильный класс");
            System.out.println("4 - Увидеть список команд, которые выполняет животное");
            System.out.println("5 - Обучить животное новым командам");
            System.out.println("6 - Удалить животное");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Считываем лишний символ перевода строки

            switch (choice) {
                case 1:
                    listAllAnimals();
                    break;
                case 2:
                    createAnimal(scanner);
                    break;
                case 3:
                    classifyAnimal(scanner);
                    break;
                case 4:
                    showAnimalCommands(scanner);
                    break;
                case 5:
                    trainAnimal(scanner);
                    break;
                case 6:
                    deleteAnimal(scanner);
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }

    private static void listAllAnimals() {
        System.out.println("Список всех животных в реестре:");
        int count = 1;
        for (Map.Entry<String, Animal> entry : registry.entrySet()) {
            String name = entry.getKey();
            Animal animal = entry.getValue();
            String dateOfBirth = animal.getDateOfBirth();
            System.out.println(count + ". Имя: " + name + ", Класс: " + animal.getClass().getSimpleName() + ", Дата рождения: " + dateOfBirth);
            count++;
        }
    }



    private static void createAnimal(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        System.out.print("Введите дату рождения животного: ");
        String dateOfBirth = scanner.nextLine();

        System.out.print("Введите тип животного (Кошка, Собака, Хомяк, Лошадь, Осел, Верблюд): ");
        String type = scanner.nextLine();

        Animal animal;

        if (type.equalsIgnoreCase("Кошка")) {
            animal = createCat(name, dateOfBirth);
        } else if (type.equalsIgnoreCase("Собака")) {
            animal = createDog(name, dateOfBirth);
        } else if (type.equalsIgnoreCase("Хомяк")) {
            animal = createHamster(name, dateOfBirth);
        } else if (type.equalsIgnoreCase("Лошадь")) {
            animal = createHorse(name, dateOfBirth);
        } else if (type.equalsIgnoreCase("Осел")) {
            animal = createDonkey(name, dateOfBirth);
        } else if (type.equalsIgnoreCase("Верблюд")) {
            animal = createCamel(name, dateOfBirth);
        } else {
            System.out.println("Некорректный тип животного.");
            return;
        }

        registry.put(name, animal);
        System.out.println("Животное " + name + " добавлено в реестр.");
        }

    private static Animal createCat(String name, String dateOfBirth) {
        return new Cat(name, dateOfBirth);
    }

    private static Animal createDog(String name, String dateOfBirth) {
        return new Dog(name, dateOfBirth);
    }

    private static Animal createHamster(String name, String dateOfBirth) {
        return new Hamster(name, dateOfBirth);
    }

    private static Animal createHorse(String name, String dateOfBirth) {
        return new Horse(name, dateOfBirth);
    }

    private static Animal createDonkey(String name, String dateOfBirth) {
        return new Donkey(name, dateOfBirth);
    }

    private static Animal createCamel(String name, String dateOfBirth) {
        return new Camel(name, dateOfBirth);
    }


    private static void classifyAnimal(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        Animal animal = registry.get(name);

        if (animal != null) {
            System.out.println("Животное " + name + " класса " + animal.getClass().getSimpleName());

            System.out.print("Хотите изменить класс животного? (y/n): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("y")) {
                System.out.print("Введите новый класс животного (Кошка, Собака, Хомяк, Лошадь, Осел, Верблюд): ");
                String newType = scanner.nextLine();

                Animal newAnimal;

                if (newType.equalsIgnoreCase("Кошка")) {
                    newAnimal = createCat(name, animal.getDateOfBirth());
                } else if (newType.equalsIgnoreCase("Собака")) {
                    newAnimal = createDog(name, animal.getDateOfBirth());
                } else if (newType.equalsIgnoreCase("Хомяк")) {
                    newAnimal = createHamster(name, animal.getDateOfBirth());
                } else if (newType.equalsIgnoreCase("Лошадь")) {
                    newAnimal = createHorse(name, animal.getDateOfBirth());
                } else if (newType.equalsIgnoreCase("Осел")) {
                    newAnimal = createDonkey(name, animal.getDateOfBirth());
                } else if (newType.equalsIgnoreCase("Верблюд")) {
                    newAnimal = createCamel(name, animal.getDateOfBirth());
                } else {
                    System.out.println("Некорректный тип животного.");
                    return;
                }

                registry.put(name, newAnimal);
                System.out.println("Класс животного " + name + " изменен на " + newType);
            }
        } else {
            System.out.println("Животное с именем " + name + " не найдено в реестре.");
        }
    }


    private static void showAnimalCommands(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        Animal animal = registry.get(name);

        if (animal != null) {
            List<String> commands = animal.getCommands();
            if (commands.isEmpty()) {
                System.out.println(name + " не знает ни одной команды.");
            } else {
                System.out.println("Список команд для животного " + name + ":");
                for (String command : commands) {
                    System.out.println(command);
                }
            }
        } else {
            System.out.println("Животное с именем " + name + " не найдено в реестре.");
        }
    }



    private static void trainAnimal(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        Animal animal = registry.get(name);

        if (animal != null) {
            System.out.print("Введите новую команду для животного: ");
            String newCommand = scanner.nextLine();
            animal.addCommand(newCommand);
            System.out.println("Команда добавлена для животного " + name);
        } else {
            System.out.println("Животное с именем " + name + " не найдено в реестре.");
        }
    }

    private static void deleteAnimal(Scanner scanner) {
        System.out.print("Введите имя животного для удаления: ");
        String name = scanner.nextLine();

        Animal removedAnimal = registry.remove(name);

        if (removedAnimal != null) {
            System.out.println("Животное " + name + " удалено из реестра.");
        } else {
            System.out.println("Животное с именем " + name + " не найдено в реестре.");
        }
    }

}