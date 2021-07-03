
import java.util.Scanner;

public class Main {
    
    static String userName;
    private static void newUser() {
        Message.welcome();
        Message.askUserName();
        userName = input.nextLine();
        userName = userName.isEmpty() ? "guest": userName.replace(" ", "");
        System.out.println("");
        Message.greet();
        System.out.println("");
        Message.help();
    }
    
    static Answer answerSheet;
    static Scanner input;
    public static void main(String[] args) {
        
        input = new Scanner(System.in);
        boolean runMainMenu = true;
        Main.newUser();
        
        do {
            switch (input.nextLine().toLowerCase()) {
                case "start":
                case "s":
                case "":
                    answerSheet = new Answer();
                    Message.skipLines(25);
                    Results.quizStartedTime();
                    Questionaire.questions();
                   
                    Message.skipLines(25);
 
                    Results.quizFinishedTime();
                    Message.reAttemptHelp = true;
                    Message.quizFinished();
                    Main.input.nextLine();
                    Results.printResults();
                    System.out.println("");
                    Message.filePrintAttempt();

                    switch (input.nextLine().toLowerCase()) {
                        case "yes":
                        case "y":
                            Results.printResultsFile();
                            break;
                        default:
                            System.out.println("");
                            Message.printFileNegative();
                            break;
                    }
                    
                    System.out.println("");
                    
                    Message.help();
                    break;    
               
                case "rules":
                case "r":
                    System.out.println("");
                    Message.rules();
                    System.out.println("");
                    Message.help();
                    break;
                    
                case "switch":
                case "su":
                case "switchuser":
                case "switch user":
                case "change":
                case "user":
                case "change user":
                case "changeuser":
                    Message.skipLines(25);
                    Message.reAttemptHelp = false;
                    Main.newUser();
                    break;
                    
                case "exit":
                case "e":
                case "log out":
                case "sign out":
                case "logout":
                case "signout":
                case "logoff":
                case "sign off":
                    System.out.println("");
                    Message.farewell();
                    runMainMenu = false;
                    break;
                    
                default:
                    System.out.println("");
                    Message.incorrectInput();
                    System.out.println("");
                    Message.help();
                    break;
            }  
        } while (runMainMenu);
    } 
}