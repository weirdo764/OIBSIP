import java.util.*;


class Game{
    public static int score = 0;
    public int randomNumber;
    public int userInput;
    public int guessNo = 0;
    Game(){
        Random r = new Random();
        randomNumber = r.nextInt(100);
        System.out.println("the generated Number is "+randomNumber);
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
            System.out.println("You Guessed is Correct "+userInput);
            System.out.println("You completed Game in "+guessNo+" Guess");
            score++;
            return false;
        }
        else if (userInput > randomNumber) {
            System.out.println("Enter Smaller Number");
        }
        else if (userInput < randomNumber) {
            System.out.println("Enter Larger Number");
        }
        return true;
    }

}

public class oibsip_Task_2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            Game g1 = new Game();
            boolean b = true;
            int attempts = 0;
            do {
                g1.takeUserInput();
                b = g1.isCorrectNumber();
                attempts++;
                System.out.println("You have "+(5-attempts)+" attempts left");
                if (attempts == 5 || !b){
                    break;
                }
            }while(b);
            System.out.println("Do you want to play again?");
            String res = sc.nextLine();
            if (res.equalsIgnoreCase("N")) {
                break;
            }
        }


        System.out.println("Your Final Score is "+ Game.score);
    }
}
