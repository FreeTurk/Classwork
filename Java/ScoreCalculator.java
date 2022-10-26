import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ScoreCalculator {
  public static void main(String[] args) {
    Random random = new Random();
    int[] examP = random.ints(5, 0, 100).toArray();
    int[] quizP = random.ints(5, 0, 100).toArray();
    double[] finalP = { 0, 0, 0, 0, 0 };
    List<Double> failed = new ArrayList<>();
    List<Double> passed = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      finalP[i] = (examP[i] * 0.4 + quizP[i] * 0.6);
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
    System.out.println("");
    System.out.printf(
        "Average: %s%nMin: %s%nMax: %s%nExam scores: %s%nQuiz scores: %s%nFinal scores: %s%nFailed scores: %s%nPassed scores: %s%n",
        average, min, max, Arrays.toString(examP), Arrays.toString(quizP), Arrays.toString(finalP),
        Arrays.toString(failed.toArray()), Arrays.toString(passed.toArray()));
  }
}