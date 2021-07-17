public class Message extends Main{
    
    public static void welcome() {
        System.out.println("Hi! Welcome to the simple quiz program.");
    }
    
    public static void askUserName() {
        System.out.println("Now why not introduce yourself?");
        System.out.println("What is your name?");
        System.out.print("Type your username:");
    }
    
    public static void greet() {  
        System.out.println("Hi " + userName + "! Nice to meet you.");
    }
    
    static boolean reAttemptHelp;
    public static void help() {
        System.out.println("Here are the commands to run, " + userName);
        System.out.println("Type \"Start\" to " + (reAttemptHelp ? "re-attempt" : "answer") +" the quiz");
        System.out.println("Type \"Rules\" to see the rules");
        System.out.println("Type \"Switch User\" to change the user");
        System.out.println("Type \"Exit\" to exit the program");
        System.out.print("Type in the command you want to run:");
    }
    
    public static void rules() {
        System.out.println("Here are the rules " + userName);
        System.out.println("1. Some answers are case-sensitive such as names.");
        System.out.println("2. Make sure to double check your answers before");
        System.out.println("pressing the Enter key.");
        System.out.println("3. Multiple choices questions doesn't require");
        System.out.println("case-sensitive answers");       
    }
    
    public static void incorrectInput() {
        System.out.println("Sorry, wrong input " + userName);
        System.out.println("Please try again");
    }
    
    public static void quizFinished() {
        System.out.println("Congratulations!");
        System.out.println("You finished the quiz!");
        System.out.println("Press the Enter Key to see your results.");
    }
    
    public static void filePrintAttempt() {
        System.out.println("Do you want a file printed out?");
        System.out.print("[y/N]:");
    }
    
    public static void filePrintSuccess() {
        System.out.println("Your file has been printed successfully.");
    }
    
    public static void fileName() {
        System.out.print("Your file is called: ");
    }
    
    public static void filePath() {
        System.out.println("Check your folder where the program is located");
        System.out.println("Which is in:");
    }
    
    public static void filePrintError() {
        System.out.println("Sorry something unusual happened.");
    }
    
    public static void fileReadOnlyError() {
        System.out.println("The file system is in Read-Only permission");
        System.out.println("Make sure it is set to Read-Write.");
    }
    
    public static void fileDirectoryError() {
        System.out.println("Directory may be moved, deleted or, modified.");
    }
    
    public static void filePrintFailed() {
        System.out.println("Your file didn't print successfully");
    }
    
    public static void printFileNegative() {
        System.out.println("The program didn't attempt to print a file.");
    }
    
    public static void farewell() {
        System.out.println("Thank you for using simple quiz program.");
        System.out.println("Have a great day!");
    }
    public static void skipLines(int lines) {
        for (int skip = 0; skip < lines; skip++) {
            System.out.println("");
        }
    }
}