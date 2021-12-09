//reax1046 Rebecka Axskjöld
import java.io.InputStream;
import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.Scanner;

//@UnderTest(id = "U6.3")

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


    public int inputInt(String number) {
        System.out.print(number + writeSign());
        int inputNumber = input.nextInt();
        while(inputNumber < 0) {
            System.out.println("Error: input cannot be empty.");
            System.out.print(number + writeSign());
            inputNumber = input.nextInt();
        }
        //input.nextLine();//för att rensa inputen
        return inputNumber;
    }

    public double inputDouble(String decimal) {
        System.out.print(decimal + writeSign());
        double inputDecimal = input.nextDouble();
        while (inputDecimal < 0.0) {
            System.out.println("Error: input cannot be empty.");
            inputDecimal = input.nextDouble();
        }
        //input.nextLine();//för att rensa inputen
        return inputDecimal;
    }

    public String inputString(String word) {
        System.out.print(word + writeSign());
        String inputWord = input.nextLine();
        while(inputWord.equals("") || inputWord.trim().equals("")) {
            System.out.println("Error: input cannot be empty.");
            System.out.print(word + writeSign());
            inputWord = input.nextLine();
        }
        inputWord = trimString(inputWord);
        inputWord = makeItFancy(inputWord); //sparar resultatet av metoden
        return inputWord;
    }

    private String writeSign() {
        return "?>";
    }


    private String trimString(String strWord){
        return strWord.trim().replaceAll(" +", " ");
    }

    private String makeItFancy(String strWord) { //ändra namnet på denna
        return strWord.substring(0,1).toUpperCase() + strWord.substring(1).toLowerCase();
    }


    public String extraRow() {
        return input.nextLine();
    }
}
