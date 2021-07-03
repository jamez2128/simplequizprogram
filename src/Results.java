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
    
    private static String quizStartTime;
    static void quizStartedTime() {
        quizStartTime = timeDate();
    }
    
    private static String quizEndTime;
    static void quizFinishedTime() {
        quizEndTime = timeDate();
    }
    
    static String quizResultsFormat() {
        String resultsFormat;
        resultsFormat
                = ("Name: " + userName + "\n"
                + "Date Started : " + quizStartTime + "\n"
                + "Date Finished: " + quizEndTime + "\n"
                + "\n"
                + "Score: \n"
                + "✓: " + answerSheet.score+"/"+answerSheet.questionCounter + "\tX: " + answerSheet.wrongScore + "/" + answerSheet.questionCounter + "\n"
                + "\n"
                + "✓/X: Your Answers:");
        return resultsFormat;
    }
    
    static String quizResultsAnswers(int questionNumber) {
        String[] results = new String[answerSheet.questionCounter];
        for (int i = 0; i < answerSheet.questionCounter; i++) {
            results[questionNumber] = (" "+answerSheet.ticks.get(questionNumber)+ "   " + (questionNumber+1) + ". " + answerSheet.userAnswers.get(questionNumber));
        }
        return results[questionNumber];
    }

    static void printResults() {
        System.out.println(quizResultsFormat());
        for (int questionNumber = 0; questionNumber < answerSheet.questionCounter; questionNumber++) {
            System.out.println(quizResultsAnswers(questionNumber));
        }
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
            String fileNameOnly = fileName().getName();
            String fullPathOnly = fileName().getAbsolutePath().replace(fileNameOnly, "");
            
            resultsWriter = new PrintWriter(fileName().getAbsolutePath());
            resultsWriter.println(quizResultsFormat());
            for (int questionNumber = 0; questionNumber < answerSheet.questionCounter; questionNumber++) {
                resultsWriter.println(quizResultsAnswers(questionNumber));
            }
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