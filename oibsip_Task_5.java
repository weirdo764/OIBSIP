import java.util.ArrayList;
import java.util.Scanner;

class Book{
    String title;
    String author;
    boolean isIssued;
    Book(String title, String author){
            this.title = title;
            this.author = author;
            isIssued = false;
    }
}

class Member{
    String name;
    String pass;
    Member(String name, String pass){
        this.name = name;
        this.pass = pass;
    }
}

class Library{
    Scanner sc = new Scanner(System.in);
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();
    Library(){
//        System.out.println("Do you want to login as Admin or Member?(1 for Admin and 0 for Members)");
//        int f = sc.nextInt();
//
//        if (f==0) {
//            System.out.println("Enter Username: ");
//            String un = sc.nextLine();
//            System.out.println("Enter Password: ");
//            String ps = sc.nextLine();
//            for (Member member : members) {
//                if (!un.equalsIgnoreCase(member.name)) {
//                    if (!ps.equalsIgnoreCase(member.pass)) {
//                        System.out.println("Invalid username or password.");
//                        return;
//                    }
//                }
//            }
//        }

//        if (f == 1){
//            System.out.println("Enter Username: ");
//            String un = sc.nextLine();
//            sc.nextLine();
//            System.out.println("Enter Password: ");
//            String ps = sc.nextLine();
//            if (!un.equalsIgnoreCase("admin")){
//                if (!ps.equalsIgnoreCase("pass123")){
//                    System.out.println("Invalid username or password.");
//                    return;
//                }
//            }
//        }
        }

    void viewBooks(){
        int i =1;
        for (Book book : books) {
            System.out.println(i+". Title: " + book.title + ", Author: " + book.author + ", Issued: " + book.isIssued);
            i++;
        }
    }
    void searchBook(String title){
        for (Book book : books) {
            if(title.equalsIgnoreCase(book.title)) {
                System.out.println("Book Found\nTitle: " + book.title + "\nAuthor: " + book.author + "\nIssued: " + book.isIssued);
                return;
            }
        }
    }

    void issueBook(String issueTitle, String issueMember){
        for (Book book : books) {
            if(issueTitle.equalsIgnoreCase(book.title) && !book.isIssued) {
                System.out.println("Book: "+book.title+" is issued to "+issueMember);
                book.isIssued = true;
                return;
            }
        }
        System.out.println("Book: "+issueTitle+" is not found");
    }

    void addBook(String title, String author){
//        Book b = new Book(title, author);
//        books.add(b);
        books.add(new Book(title, author));
        System.out.println("Successfully added the "+title+" by "+author);
    }

    void deleteBook(String deleteTitle){
        for (Book book : books) {
            if(deleteTitle.equalsIgnoreCase(book.title)) {
                books.remove(book);
                System.out.println("Successfully deleted the "+deleteTitle);
                return;
            }
        }
        System.out.println("Book not found!");
    }

    void updateBook(String oldTitle, String newTitle, String newAuthor){
        for (Book book : books) {
            if(oldTitle.equalsIgnoreCase(book.title)) {
                book.title = newTitle;
                book.author = newAuthor;
                System.out.println("Successfully Updated Book");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    void addMember(String memberName, String password){
//        Member m = new Member(memberName, password);
//        members.add(m);
        members.add(new Member(memberName,password));
        System.out.println("Successfully added!");
    }

    void returnBook(String returnTitle){
        for (Book book: books){
            if (book.isIssued && book.title.equalsIgnoreCase(returnTitle)){
                System.out.println("Successfully returned the book "+ returnTitle);
            }
        }
    }

    void adminMenu(){
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. Update Book");
            System.out.println("4. Add Member");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. View All Books");
            System.out.println("8. Logout");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter book author: ");
                    String author = sc.nextLine();
                    addBook(title, author);
                    break;
                case 2:
                    System.out.print("Enter book title to delete: ");
                    String deleteTitle = sc.nextLine();
                    deleteBook(deleteTitle);
                    break;
                case 3:
                    System.out.print("Enter old book title: ");
                    String oldTitle = sc.nextLine();
                    System.out.print("Enter new book title: ");
                    String newTitle = sc.nextLine();
                    System.out.print("Enter new book author: ");
                    String newAuthor = sc.nextLine();
                    updateBook(oldTitle, newTitle, newAuthor);
                    break;
                case 4:
                    System.out.print("Enter member name: ");
                    String memberName = sc.nextLine();
                    System.out.print("Enter member password: ");
                    String email = sc.nextLine();
                    addMember(memberName, email);
                    break;
                case 5:
                    System.out.print("Enter book title to issue: ");
                    String issueTitle = sc.nextLine();
                    System.out.print("Enter member name: ");
                    String issueMember = sc.nextLine();
                    issueBook(issueTitle, issueMember);
                    break;
                case 6:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = sc.nextLine();
                    returnBook(returnTitle);
                    break;
                case 7:
                    viewBooks();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    void userMenu(){
        while (true) {
            System.out.println("\nUser Menu:");
            System.out.println("1. View All Books");
            System.out.println("2. Search Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    viewBooks();
                    break;
                case 2:
                    System.out.print("Enter book title to search: ");
                    String title = sc.nextLine();
                    searchBook(title);
                    break;
                case 3:
                    System.out.print("Enter book title to issue: ");
                    String issueTitle = sc.nextLine();
                    System.out.print("Enter your name: ");
                    String issueMember = sc.nextLine();
                    issueBook(issueTitle, issueMember);
                    break;
                case 4:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = sc.nextLine();
                    returnBook(returnTitle);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }



}

public class oibsip_Task_5{
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.adminMenu();
                    break;
                case 2:
                    library.userMenu();
                    break;
                case 3:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}