import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Results extends Main{
    
    private static String timeDate() {
        Date presentTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
        SimpleDateFormat dayOnWeekFormat = new SimpleDateFormat("EEEE");
        SimpleDateFormat clocKFormat = new SimpleDateFormat("h:mm a");
        return clocKFormat.format(presentTime)+ " " + dayOnWeekFormat.format(presentTime) + " " +dateFormat.format(presentTime);
    }
    
    private static String quizFinishedTime;
    static void quizFinishedTime() {
        quizFinishedTime = timeDate();
    }
    
    public static String quizResultsFormat(int formatNumber) {
        String[] resultsFormat = new String[2];
        resultsFormat[0] = ("Quiz finished in\n"
                          + quizFinishedTime + "\n"
                          + "\n"
                          + userName + "'s results:\n"
                          + "Score: "+ answerSheet.score + "/" + answerSheet.questionCounter + "\n"
                          + "(✓/X) Your Answers");
        
        resultsFormat[1] = ("✓: " + answerSheet.score+"/"+answerSheet.questionCounter + "\tX: " + answerSheet.wrongScore + "/" + answerSheet.questionCounter);
        return resultsFormat[formatNumber];
    }
    

    static String quizResultsAnswers(int questionNumber) {
        String[] results = new String[answerSheet.questionCounter];
        for (int i = 0; i < answerSheet.questionCounter; i++) {
            results[questionNumber] = ("( "+answerSheet.ticks.get(questionNumber)+ " ) " + (questionNumber+1) + ". " + answerSheet.userAnswers.get(questionNumber));
        }
        return results[questionNumber];
    }

    static void printResults() {
        System.out.println(quizResultsFormat(0));
        for (int questionNumber = 0; questionNumber < answerSheet.questionCounter; questionNumber++) {
            System.out.println(quizResultsAnswers(questionNumber));
        }
        System.out.println(quizResultsFormat(1));
    }
    
    static File fileName() {
        String resultsFilePath = "Quiz_results/"+userName+"/";
        File makePaths = new File(resultsFilePath);
        if (!makePaths.exists()) {
            makePaths.mkdirs(); 
        }
        File file = new File(resultsFilePath+userName+"'s_results.txt");
        if (file.exists()) { 
            file = new File(resultsFilePath+userName+"'s_results"+"("+0+")"+".txt"); 
        }
        int fileNumber = 0;
            while (file.exists()) {
                file = new File(resultsFilePath+userName+"'s_results"+"("+fileNumber+")"+".txt");
                fileNumber++;
            }
        return file;
    }
    
    static void printResultsFile() {
            PrintWriter resultsWriter;
        try {
            String fullPathOnly = fileName().getAbsolutePath().replace(fileName().getName(), "");
            String fileNameOnly = fileName().getName();
            resultsWriter = new PrintWriter(fileName().getAbsolutePath());
            resultsWriter.println(quizResultsFormat(0));
            for (int questionNumber = 0; questionNumber < answerSheet.questionCounter; questionNumber++) {
                resultsWriter.println(quizResultsAnswers(questionNumber));
            }
            resultsWriter.println(quizResultsFormat(1));
            resultsWriter.close();
            System.out.println("");
            Message.filePrintSuccess();
            Message.filePath();
            System.out.println(fullPathOnly);
            Message.fileName();
            System.out.println(fileNameOnly);
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
                Message.filePrintError();
              }
    }
}