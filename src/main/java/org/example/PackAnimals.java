package org.example;

public class PackAnimals extends Animal {
    public PackAnimals(String name, String date) {
        super(name, date);
    }

    @Override
    public String toString() {
        return "PackAnimal {" +
                "name = '" + super.getName() + '\'' +
                ", commands = " + super.getCommands() +
                ", dateOfBirth = '" + super.getDateOfBirth() + '\'' +
                '}';
    }

}
