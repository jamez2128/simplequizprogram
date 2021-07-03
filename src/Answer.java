import java.util.ArrayList;

public class Answer {
    
    
    int questionCounter;
    int score;
    int wrongScore;
    ArrayList<String> userAnswers;
    ArrayList<String> correctAnswers;
    ArrayList<String> ticks;

    private void startQuiz() {
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
   
    private void scoreAnswer(boolean caseSensitive) {
        boolean answerVerifier = verifyAnswer(caseSensitive);
        score = answerVerifier ? score+1 : score+0;
        wrongScore = answerVerifier ? wrongScore+0 : wrongScore+1;
        ticks.add(questionCounter, answerVerifier ? "✓" : "X");
   }
   
    private void setAnswers(String correctAnswer, String userAnswer) {
        userAnswers.add(questionCounter, userAnswer);
        correctAnswers.add(questionCounter, correctAnswer);
   }
   
    private void cycleQuestion(String correctAnswer, boolean caseSensitive, String userAnswer) {
        setAnswers(correctAnswer, userAnswer);
        scoreAnswer(caseSensitive);
        questionCounter++;
   }
    
    public void answer(String correctAnswer,boolean caseSensitive, String userAnswer) {
       if (correctAnswers == null && userAnswers == null && ticks == null) {
           startQuiz();
           cycleQuestion(correctAnswer, caseSensitive, userAnswer);
        } else {
           cycleQuestion(correctAnswer, caseSensitive, userAnswer);
        }
    }
}