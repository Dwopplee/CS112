import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WeirdSort {
  public static void main(String[] args) {
    try {
      for (int current : Files.lines(Path.of("unsorted-numbers.txt")).mapToInt(Integer::parseInt).toArray())
        new Thread(() -> {
          try {
            Thread.sleep(current * 1000);
            System.out.println(current + " ");
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }).start();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
