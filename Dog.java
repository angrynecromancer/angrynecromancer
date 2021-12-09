//reax1046 Rebecka Axskjöld

public class Dog {
    private static final double TAIL_DIVIDER = 10.0;
    private static final double TAX_TAIL_LENGTH = 3.7;
    private String name;
    private String breed;
    private int age;
    private int weight;
    private double tailLength;

    public Dog(String name, String breed, int age, int weight) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
        calculateTailLength();
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public double getTailLength() {
        //calculateTailLength();
        return tailLength;
    }

    public void calculateTailLength() {
        if (breed.equalsIgnoreCase("tax") || breed.equalsIgnoreCase("dachshund")) {
            tailLength = TAX_TAIL_LENGTH;
        } else {
            tailLength = age * weight / TAIL_DIVIDER;
        }
    }

    /*public void increaseAge(int year) {
        int currentAge = getAge();
        age = currentAge + year;
        calculateTailLength();
    }*/

    public void increaseAge() {
        age++;
        calculateTailLength();
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Breed: " + getBreed() + ", Age: " + getAge() + ", Weight: " + getWeight() + ", TailLength: " + getTailLength();
    }


}
