import java.util.*;
class Game{
    public static int score = 0;
    public static int randomNumber;
    public int userInput;
    public int guessNo = 0;
    Game(int n){
        Random r = new Random();
        randomNumber = r.nextInt(100);
        System.out.println("You have "+n+" attempts to guess the number");
//        System.out.println("the generated Number is "+randomNumber);
    }

    void takeUserInput(){

        System.out.println("Enter your Number :");
        Scanner sc = new Scanner(System.in);
        userInput = sc.nextInt();
    }

    boolean isCorrectNumber()
    {
        guessNo++;
        if (userInput == randomNumber) {
            System.out.println("You Guessed the Correct number: "+userInput);
            System.out.println("You completed Game in "+guessNo+" Guess");
            if(guessNo >=15) {
                score++;
            } else if (guessNo>=10) {
                score = score+5;
            }
            else if (guessNo>=5){
                score = score+10;
            }
            else if (guessNo>1) {
                score = score+11;
            }
            return false;
        }
        else if (userInput > randomNumber) {
            System.out.println("Enter Smaller Number\n");
        }
        else if (userInput < randomNumber) {
            System.out.println("Enter Larger Number\n");
        }
        return true;
    }
}

public class oibsip_Task_2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int attempts = 0;
            System.out.println("How may attempts you want?");
            int lastAttempt = sc.nextInt();
            Game g1 = new Game(lastAttempt);
            boolean b = true;
            do {
                g1.takeUserInput();
                b = g1.isCorrectNumber();
                attempts++;
                if (attempts == lastAttempt){
                    System.out.println("You have 0 attempts left\nYou Lost");
                    break;
                }
            }while(b);
            System.out.println("\nDo you want to play again? Y/N");
            sc.nextLine();
            String res = sc.nextLine();
            if (res.equalsIgnoreCase("N")) {
                break;
            }
        }
        System.out.println("Your Final Score is "+ Game.score);
    }
}
