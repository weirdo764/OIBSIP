import java.util.*;

class OnlineReservationSystem{
    Scanner sc = new Scanner(System.in);
    boolean verifyStatus = false;
    private final String[] verifiedUsers = {"Weirdo", "Mark", "Jack", "Steven"};
    private final byte[] verifiedPass = {12, 23, 34, 87};


    private final String[] train = {"TExpress_1", "TExpress_2", "TExpress_3", "TExpress_4"};
    private final int[] trainNo = {12763, 23245, 32534, 25687};
    private final String[] traintype = {"Second Class", "First Class", "Sleeper Class-AC", "Sleeper Class-Non-AC"};
    private final String[] dateOfJourney = {"25/05/2024", "27/05/2024", "30/05/2024", "01/06/2024"};
    private final String[] Source = {"Howrah", "Delhi", "Mumbai", "Ahmedabad"};
    private final String[] Destination = {"Imphal", "Srinagar", "Okha", "Jaipur"};
    private final String[] PNRnumber = {"8979876545", "7546982431", "6495218735", "6458972344"};

    public void verify(){
        System.out.println("Enter Your Login ID: ");
        String login_ID = sc.nextLine();


        System.out.println("Enter Password : ");
        byte password = sc.nextByte();

        for (int i = 0; i < verifiedUsers.length; i++) {
            if (login_ID.equalsIgnoreCase(verifiedUsers[i])) {
                if (password == verifiedPass[i]) {
                    System.out.println("Logged In");
                    verifyStatus = true;
                } else {
                    System.out.println("Enter valid Password");
                }
                return;
            }
        }
        System.out.println("Enter valid Login ID");

    }


    public void reservationForm(){
        if (verifyStatus){
            System.out.println("Enter Number of the train: ");
            int trainNum = sc.nextInt();
            int trIndex = 0;
            for (int i=0; i<train.length-1; i++){
                if (trainNum == trainNo[i]){
                     trIndex = i;
                    System.out.println("\nTrain Name:      \t"+train[i]);
                    System.out.println("Class Type:      \t"+traintype[i]);
                    System.out.println("Date Of Journey: \t"+dateOfJourney[i]);
                    System.out.println("Source:          \t"+Source[i]);
                    System.out.println("Destination:     \t"+Destination[i]);
                    break;
                }
            }
            System.out.print("Press Y to cancel\n");
            System.out.print("Press N to Exit\n");

            sc.nextLine();
            String res = sc.nextLine();

            if (res.equalsIgnoreCase("Y")) {
                System.out.println("Booking Confirmed");
                System.out.println("Your PNR number is "+PNRnumber[trIndex]);
            }
            else if (res.equalsIgnoreCase("N")) {
                System.out.println("Exit.");
            }
            else {
                System.out.println("Invalid input. Please enter Y or N.");
            }


        }

        else {
            System.out.println("Please Complete Verification Again");
        }

    }

    public void cancellationForm(){
        int pnrIndex = 0;
        System.out.println("Enter your PNR Number: ");
        sc.nextLine();
        String user_PNR = sc.nextLine();
        for (int i=0; i< PNRnumber.length-1; i++){
            if (user_PNR.equalsIgnoreCase(PNRnumber[i])){
                pnrIndex = i;
                System.out.println("\nDo you want to cancel your booking of the following Train :");
                System.out.println("PNR Number:      \t"+user_PNR);
                System.out.println("Train Name:      \t"+train[i]);
                System.out.println("Class Type:      \t"+traintype[i]);
                System.out.println("Date Of Journey: \t"+dateOfJourney[i]);
                System.out.println("Source:          \t"+Source[i]);
                System.out.println("Destination:     \t"+Destination[i]);
                break;
            }
        }
        System.out.print("Press Y to cancel\n");
        System.out.print("Press N to Exit\n");
        String res = sc.nextLine();

        if (res.equalsIgnoreCase("Y")){
            System.out.println("Booking Cancelled");
        }
        else if (res.equalsIgnoreCase("N")){
            System.out.println("EXIT.");
        }
        else {
            System.out.println("Enter valid PNR number.");
        }

    }

}

public class oibsip_Task_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OnlineReservationSystem p1 = new OnlineReservationSystem();
        p1.verify();

        int c;
        do {
            System.out.println("\nEnter 0 to EXIT");
            System.out.println("Enter 1 for Reservation Form");
            System.out.println("Enter 2 for Cancellation Form");

            c = 0;
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    c = 1;
                    break;
                case 1:
                    p1.reservationForm();
                    break;
                case 2:
                    p1.cancellationForm();
                    break;
            }

        } while (c != 1);
    }
}
