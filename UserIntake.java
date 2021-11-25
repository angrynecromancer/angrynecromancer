//reax1046 Rebecka Axskjöld
import java.io.InputStream;
import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.Scanner;

@UnderTest(id = "U6.3")

//motivera för statiska variabler, måste använda static på array så att den är tillgänglig för alla instanser
public class UserIntake {

    private static ArrayList<InputStream> userInputs = new ArrayList<>();
    private Scanner input;
    
    //skapar en instans av denna klass i en annan klass - defaultvärde
    public UserIntake() {
        this(System.in); //den anropar korrekt

    }

    public UserIntake(InputStream userInput) {
        if (userInputs.contains(userInput)) {
            throw new IllegalStateException("Instans av InputStream finns redan");
        } 
            input = new Scanner(userInput);
            userInputs.add(userInput);
    }


    //lägg till lite krav på om inputen är tom eller minus eller nåt
    //börja med stor bokstav, ta bort mellanslag osv.

    public int inputInt(String number) {
        System.out.println(number + writeSign());
        int inputNumber = input.nextInt();
        input.nextLine();//för att rensa inputen
        return inputNumber;
    }

    public double inputDouble(String decimal) {
        System.out.println(decimal + writeSign());
        double inputDecimal = input.nextDouble();
        input.nextLine();//för att rensa inputen
        return inputDecimal;
    }

    public String inputString(String word) {
        System.out.println(word + writeSign());
        return input.nextLine();
    }

    private String writeSign() {
        return "?>";
    }
}
