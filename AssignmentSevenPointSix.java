//Rebecka Axskjöld reax1046
import java.util.ArrayList;
import java.util.Collections;

public class AssignmentSevenPointSix {
    //@UnderTest(id = "dogs")
    private ArrayList<Dog> dogs = new ArrayList<>();

    //@UnderTest(id = "U7.6.1.1") Egen metod för att byta plats
    public void swapPlaces(int i, int j){
        var x = dogs.get(i);
        var y = dogs.get(j);
        dogs.set(i, y);
        dogs.set(j, x);
    }

    //@UnderTest(id = "U7.6.1.2") Använda en metod från klass biblioteket
    public void swap(int i, int j) {
        Collections.swap(dogs, i, j);
    }

    //skriv 3 metoder, en som jämför svanslängd, en som jämför namn och en som jämför både namn och svanslängd
    //@UnderTest(id = "U7.6.2") Jämföra två hundar
    public boolean compareDogs(Dog left, Dog right) {
        if (left.getTailLength() < right.getTailLength()) {
            return true;
        } else if (left.getTailLength() == right.getTailLength()) {
            if (left.getName().compareToIgnoreCase(right.getName()) < 0 ) { //compareTo returnerar int
                return true;
            }
        }
        return false;
    }

    //@UnderTest(id = "U7.6.3") Hitta den minsta hunden
    public int findSmallestDog(int startIndex) {
        Dog dog = dogs.get(startIndex);
        int currentMinIndex = startIndex;
        Dog currentShortestDog = dog; //innan jämförelse så är det första hunden som är minst eftersom vi inte har jämfört med andra
        for (int i = startIndex + 1; i < dogs.size(); i++) {
            Dog doggie = dogs.get(i); //ändra namn
            if (compareDogs(doggie, currentShortestDog)) {
                currentMinIndex = i;
                currentShortestDog = doggie;
            }
        }
        return currentMinIndex;
    }

    //@UnderTest(id = "U7.6.4") Implementera sorteringsalgoritmen
    public int sort() {
        int numberOfSwaps = 0;
        for(int i = 0; i < dogs.size()-1; i++) {//-1 eftersom den sista redan är jämförd
            Dog currentDog = dogs.get(i);
            int smallestDogIndex = findSmallestDog(i+1);
            if (compareDogs(dogs.get(smallestDogIndex), currentDog)) {
                swapPlaces(i, smallestDogIndex);
                numberOfSwaps++;
            }
        }
        return numberOfSwaps;
    }
}
