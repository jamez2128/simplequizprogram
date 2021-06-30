import java.util.ArrayList;

public class Answer {
    
    
    int questionCounter;
    int score;
    int wrongScore;
    ArrayList<String> userAnswers;
    ArrayList<String> correctAnswers;
    ArrayList<String> ticks;
    
    public void startQuiz() {
        correctAnswers = new ArrayList<>();
        userAnswers = new ArrayList<>();
        ticks = new ArrayList<>();
        score = 0;
        wrongScore =0;
        questionCounter = 0;
    }
        
   private boolean verifyAnswer(boolean caseSensitive) {
       boolean answerVerifier = caseSensitive
        ? correctAnswers.get(questionCounter).equals(userAnswers.get(questionCounter))
        : correctAnswers.get(questionCounter).equalsIgnoreCase(userAnswers.get(questionCounter));
        return answerVerifier;
   }
    
    public void checkAnswer(String correctAnswer,boolean caseSensitive) {
        if (correctAnswers == null && userAnswers == null && ticks == null) {
            System.out.println("The startQuiz() function hasn't been called.");
        } else {
            userAnswers.add(questionCounter, Main.input.nextLine());
            correctAnswers.add(questionCounter, correctAnswer);
            boolean answerVerifier = verifyAnswer(caseSensitive);
            score = answerVerifier ? score+1 : score+0;
            wrongScore = answerVerifier ? wrongScore+0 : wrongScore+1;
            ticks.add(questionCounter, answerVerifier ? "✓" : "X");
            questionCounter++;
        }
    }
}