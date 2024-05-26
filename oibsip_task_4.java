import java.util.*;
class OnlineExamination{
    static int EXAM_DURATION_SECONDS = 15;
    int score = 0;
    Scanner sc = new Scanner(System.in);
    ArrayList<String> verifiedUsername = new ArrayList<>(4);
    int[] verifiedPin = {8567, 2433, 4534, 1221};
    int userIndex;
    static boolean flag=true;
    OnlineExamination(){
        verifiedUsername.add("Steven");
        verifiedUsername.add("Mark");
        verifiedUsername.add("Jack");
        verifiedUsername.add("Weirdo");

        System.out.println("Enter your Username: ");
        String username = sc.nextLine();

        System.out.println("Enter your Pin:");
        int userPin = sc.nextInt();

        for (int i = 0; i< verifiedUsername.size(); i++){
            if (verifiedUsername.get(i).equalsIgnoreCase(username)){
                if (verifiedPin[i] == userPin){
                    userIndex = i;
                    System.out.println("Successfully Logged In");
                    flag=false;
                }
            }
        }
        if (flag) {
            System.out.println("Incorrect User ID OR User Pin");
            return;
        }
    }

    
    void updateUsername(String newName){
        verifiedUsername.add(userIndex,newName);
        System.out.println("Successfully changed the username to "+newName);
    }
    
    void updatePassword(int newPass){
        verifiedPin[userIndex] = newPass;
        System.out.println("Successfully changed the Password to "+newPass);

    }
    
    void MCQ(){

        String[] questions = {
                "1. What is the capital city of France?\n"
                +"  a) Berlin\n"
                +"  b) Rome\n"
                +"  c) Paris\n"
                +"  d) Madrid\n",

                "2.What is the largest ocean on Earth?\n"
                +"  a) Indian Ocean\n"
                +"  b) Pacific Ocean\n"
                +"  c) Atlantic Ocean\n"
                +"  d) Arctic Ocean\n",

                "3.Which planet is known as the \"Red Planet\"?\n"
                +"  a) Jupiter\n"
                +"  b) Mars\n"
                +"  c) Venus\n"
                +"  d) Saturn\n",

                "4.Which country is known as the Land of the Rising Sun?\n"
                +"  a) Japan\n"
                +"  b) China\n"
                +"  c) South Korea\n"
                +"  d) Saturn\n",

                "5.What is the chemical symbol for water?\n"
                +"  a) ClO3\n"
                +"  b) NaCl\n"
                +"  c) NaNo3\n"
                +"  d) H2O\n"
        };

        String[] correctAnswers = {"c","b","b","a","d"};
        Timer timer = new Timer();


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up! Automatically submitting the exam...");
                System.out.println("Your Score in Exam is : " + score);
                System.exit(0);
//                displayMenu();
            }
        }, EXAM_DURATION_SECONDS * 1000L);

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\n"+questions[i]);
            System.out.println("Enter your answer: ");
            if (i == 0){
                sc.nextLine();
            }
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase(correctAnswers[i])) {
                score += 10;
            }
        }
        timer.cancel();
        System.out.println("Your Score in Exam is : " + score);
    }

    void displayMenu(){
        int choice;

        do {
            if (OnlineExamination.flag){
                break;
            }
            System.out.println("\n1. Update Username");
            System.out.println("2. Update Password");
            System.out.println("3. Take Exam");
            System.out.println("4. Logout");
            System.out.println("5. Quit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the new Username: ");
                    sc.nextLine();
                    String newName = sc.nextLine();
                    updateUsername(newName);
                    break;

                case 2:
                    System.out.print("Enter new Password: ");
                    int newPass = sc.nextInt();
                    updatePassword(newPass);
                    break;

                case 3:
                    MCQ();
                    break;

                case 4:
                    System.out.println("Successfully Logged Out!");
                    return;

                case 5:
                    System.out.println("Exit.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
    }

}

public class oibsip_task_4{
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            OnlineExamination oe = new OnlineExamination();
            oe.displayMenu();
            System.out.println("Do you want to start a new session? (1: Yes, 0: No) ");
            choice = sc.nextInt();
        }while(choice == 1);
    }
}
