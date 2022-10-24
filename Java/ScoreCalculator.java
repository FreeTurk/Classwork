import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ScoreCalculator {
  public static void main(String[] args) {
    Random random = new Random();
    // 'P' suffix stands for 'points', used mostly because final is a keyword
    int[] examP = random.ints(5, 0, 100).toArray();
    int[] quizP = random.ints(5, 0, 100).toArray();
    double[] finalP = { 0, 0, 0, 0, 0 };

    List<Double> failed = new ArrayList<Double>();
    List<Double> passed = new ArrayList<Double>();

    for (int i = 0; i < 5; i++) {
      finalP[i] = (double) (examP[i] * 0.4 + quizP[i] * 0.6);
    }

    double average = Arrays.stream(finalP).sum() / 5;
    double min = Arrays.stream(finalP).min().getAsDouble();
    double max = Arrays.stream(finalP).max().getAsDouble();

    for (int i = 0; i < 5; i++) {
      if (finalP[i] < average / 2) {
        failed.add(finalP[i]);
      } else {
        passed.add(finalP[i]);
      }
    }
    System.out.println("Average: " + average);
    System.out.println("Min: " + min);
    System.out.println("Max: " + max);
    System.out.println("Exam scores: " + Arrays.toString(examP));
    System.out.println("Quiz scores: " + Arrays.toString(quizP));
    System.out.println("Final scores: " + Arrays.toString(finalP));
    System.out.println("Failed scores: " + Arrays.toString(failed.toArray()));
    System.out.println("Passed scores: " + Arrays.toString(passed.toArray()));

  }
}