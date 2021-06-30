public class Questionaire extends Main {
    
    public static void questions() {   

        /*
        Question template:
        
        System.out.println("");
        
        
        System.out.println("Question " + (answerSheet.questionCounter+1) + ":");
        System.out.println("Your question here");
        System.out.print("Type your answer:");
        answerSheet.answer("Correct answer here", Main.input.nextLine(), true); // put true or false for case-sensitive answers
        
        
        System.out.println("");       
       */   
       
//        sample question
        System.out.println("");


        System.out.println("Question " + (answerSheet.questionCounter+1) + ":");
        System.out.println("What is 1 + 1?");
        System.out.print("Type your answer:");
        answerSheet.answer("2", Main.input.nextLine(), true); // put true or false for case-sensitive answers
        
        
        System.out.println("");
       
      
        System.out.println("Question " + (answerSheet.questionCounter+1) + ":");
        System.out.println("What is 1 + 1?");
        System.out.println("A: 420");
        System.out.println("B: 69");
        System.out.println("C: 2");
        System.out.println("D: None of the Above");               
        System.out.print("Type the correct letter:");       
        answerSheet.answer("C", Main.input.nextLine(), false); // put true or false for case-sensitive answers
        
        
        System.out.println("");                    
       
      
        System.out.println("Question " + (answerSheet.questionCounter+1) + ":");
        System.out.println("What is Obama's last name?");
        System.out.print("Type the correct answer:");
        answerSheet.answer("Obama", Main.input.nextLine(), true); // put true or false for case-sensitive answers
        
        
        System.out.println("");        
       
                  
        System.out.println("Question " + (answerSheet.questionCounter+1) + ":");
        System.out.println("What is the first name of the creator of this");
        System.out.println("program?");
        System.out.print("Type the correct answer:");
        answerSheet.answer("James", Main.input.nextLine(), true); // put true or false for case-sensitive answers
        
        
        System.out.println("");
        
    }
        
}