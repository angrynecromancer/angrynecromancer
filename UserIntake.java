import java.io.InputStream;
import java.lang.annotation.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Denna annotering används för att markera klassen du ska skriva i U6.3.
 * Det enda du behöver göra är att lägga denna java-fil i samma katalog
 * som klassen du vill märka ut, och skriva @U6_3 precis ovanför klassen.
 * Ett exempel finns i instruktionerna för uppgiften.
 * <p>
 * Detta gör att testfallen kan hitta klassen, och är nödvändigt eftersom
 * du själv bestämmer namnet på klassen till skillnad från i U6.2.
 * <p>
 * Du ska INTE lämna in denna fil. Den läggs automatiskt till i VPL.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface U6_3 {
    @U6_3
    //motivera för statiska variabler, måste använda static på array så att den är tillgänglig för alla instanser
    public class UserIntake {

        //private InputStream userInput;
        private Scanner input;
        //private static InputStream[] userInputs;
        private ArrayList<InputStream> userInputs = new ArrayList<>();

        //skapar en instans av denna klass i en annan klass - defaultvärde
        public UserIntake() {
            this(System.in); //den anropar korrekt

        }
        //jämföra kolla om userInput finns i userInputs och om inte throw stateexception ÄNDRA TILL ARRAYLIST
        /*public UserIntake(InputStream userInput) {
            this.input = new Scanner(userInput);
            if(userInputs == null) { //finns userInputs deklarerat?
                userInputs = new InputStream[1]; //deklarerar array userInputs
                userInputs[0] = userInput; //userInput sätts på första index
            } else {
                for(int i = 0; i < userInputs.length; i++ ) { //om arrayen redan finns så gås den igenom i denna for-sats
                    if(userInputs[i] == userInput) { //om strömmen som ligger på index i är samma som den nya userInput
                        throw new IllegalStateException("Det finns redan en instans av detta, try again"); //om det är det så KASTAR vi
                    }
                }
                InputStream[] tempUserInputs = new InputStream[userInputs.length + 1]; //skapa temporär array med ett längre index (+1)
                System.arraycopy(userInputs, 0, tempUserInputs, 0, userInputs.length); //kopierar userInputs till tempUserInputs
                userInputs = tempUserInputs; //det blir samma array fast med en extra plats
                userInputs[userInputs.length - 1] = userInput; //lägger userInput på sista platsen
            }
        }*/

        public UserIntake(InputStream userInput) {
            this.input = new Scanner(userInput);
            if (userInputs == null) {
                
            }
        }


        //lägg till lite krav på om inputen är tom eller minus eller nåt
        //börja med stor bokstav, ta bort mellanslag osv.

        public void inputInt() {
            System.out.println("> ");
            int number = input.nextInt();
        }

        public void inputDouble() {
            System.out.println("> ");
            double decimal = input.nextDouble();
        }

        public void inputString() {
            System.out.println("> ");
            String word = input.nextLine();
        }
    }
}





