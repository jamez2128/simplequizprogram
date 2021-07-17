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
    static void setQuizStartedTime() {
        quizStartTime = timeDate();
    }
    
    private static String quizEndTime;
    static void setQuizFinishedTime() {
        quizEndTime = timeDate();
    }
    
    static String quizResultsFormat() {
        String resultsFormat;
        resultsFormat
                = ("Name\t\t: " + userName + "\n"
                + "Date Started\t: " + quizStartTime + "\n"
                + "Date Finished\t: " + quizEndTime + "\n"
                + "Score\t\t: "+ "✓: " + answerSheet.score+"/"+answerSheet.questionCounter + "  X: " + answerSheet.wrongScore + "/" + answerSheet.questionCounter + "\n"
                + "\n"
                + "✓/X: Your Answers:");
        return resultsFormat;
    }
    
    static String[] results;
    static void setQuizResultsAnswers() {
        results = new String[answerSheet.questionCounter];
        for (int questionNumber = 0; questionNumber < answerSheet.questionCounter; questionNumber++) {
            results[questionNumber] = (" "+answerSheet.ticks.get(questionNumber)+ "   " + (questionNumber+1) + ". " + answerSheet.userAnswers.get(questionNumber));
        }
    }

    static void printResults() {
        System.out.println(quizResultsFormat());
        for (String answerNumber : results) {
            System.out.println(answerNumber);
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
            String fullPath = fileName().getAbsolutePath();
            String fileNameOnly = fileName().getName();
            String fullPathOnly = fullPath.replace(fileNameOnly, "");
            
            resultsWriter = new PrintWriter(fileName().getAbsolutePath());
            resultsWriter.println(quizResultsFormat());
            for (String answerNumber : results) {
                resultsWriter.println(answerNumber);
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
                if (!fileName().canWrite()) {
                    Message.fileReadOnlyError();
                } else {
                    Message.filePrintFailed();
                }
                Message.filePrintError();
              }
    }
}