package org.example;

public class Dog extends HomeAnimal{
    public Dog(String name, String date) {
        super(name, date);
    }

    @Override
    public String toString() {
        return "Dog {" +
                "name = '" + super.getName() + '\'' +
                ", commands = " + super.getCommands() +
                ", dateOfBirth = '" + super.getDateOfBirth() + '\'' +
                '}';
    }
}
