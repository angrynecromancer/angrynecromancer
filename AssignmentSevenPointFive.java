//Rebecka Axskjöld reax1046

import java.util.ArrayList;

public class AssignmentSevenPointFive {
    //@UnderTest(id = "dogs")
    private ArrayList<Dog> dogs = new ArrayList<>();
    private UserIntake userIntake = new UserIntake();
    private String dogName;
    private String dogBreed;
    private int dogAge;
    private int dogWeight;
    private Dog dog;
    private double dogTailLength;

    //@UnderTest(id = "U6.4")
    public Dog newDog(Dog dog) {
        dogName = userIntake.inputString("Name");
        dogBreed = userIntake.inputString("Breed");
        dogAge = userIntake.inputInt("Age");
        dogWeight = userIntake.inputInt("Weight");
        userIntake.extraRow();
        this.dog = new Dog(dogName, dogBreed, dogAge, dogWeight);
        return this.dog;
    }

    //@UnderTest(id = "U7.1")
    public void registerDog() {
        newDog(dog);
        dogs.add(dog);
        System.out.println(dog + " was added to the register.");
    }

    //@UnderTest(id = "U7.2")
    public void listDogs() {
        if (dogs.isEmpty()) {
            System.out.println("Error: register is empty.");
        } else {
            dogTailLength = userIntake.inputDouble("Smallest tail length to display");
            userIntake.extraRow();
            System.out.println("The following dogs has such a large tail:\n ");
            for (Dog dog : dogs) {
                if (dog.getTailLength() >= dogTailLength) {
                    System.out.println(dog.getName() + " (" + dog.getBreed() + ", " + dog.getAge() + " years old, " +
                            dog.getWeight() + " kilos, " + dog.getTailLength() + " cm long tail)");
                } else {
                    System.out.println("No dogs in register with such tail length.");
                }
            }
        }
    }

    //@UnderTest(id = "U7.3")
    public Dog findDog(String findDogName) {
        for (Dog dog : dogs) {
            if (dog.getName().equalsIgnoreCase(findDogName)) {
                return dog;
            }
        }
        return null;
    }

    //@UnderTest(id = "U7.4")
    public void increaseAgeWithOne() {
        String dogName = userIntake.inputString("Enter the name of the dog");
        findDog(dogName);
        if (findDog(dogName) == null) {
            System.out.println("Error: there is no such dog");
        } else {
            findDog(dogName).increaseAge();
        }
    }

    //@UnderTest(id = "U7.5")
    public void removeDog() {
        String dogName = userIntake.inputString("Enter the name of the dog");
        findDog(dogName);
        if (findDog(dogName) == null) {
            System.out.println("Error there is no such dog");
        } else {
            dogs.remove(findDog(dogName));
        }
    }
}
