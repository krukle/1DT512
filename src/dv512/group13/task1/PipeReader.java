package dv512.group13.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Pipes
 */
public class PipeReader {

  public static void main(String[] args) {
    System.out.println(ProcessHandle.current() + " " + LocalTime.now().truncatedTo(ChronoUnit.MILLIS) + " Process started");
    File pipe = new File(System.getProperty("user.home") + "/test-named-pipe");
    String line = null;
    while (true) {
      try {
        BufferedReader pipeReader = new BufferedReader(new FileReader(pipe));
        System.out.println(ProcessHandle.current() + " " + LocalTime.now().truncatedTo(ChronoUnit.MILLIS) + " Pipe opened");
        while ((line = pipeReader.readLine()) != null) {
          System.out.println(ProcessHandle.current() + " " + LocalTime.now().truncatedTo(ChronoUnit.MILLIS) + " " + line);
          Thread.sleep(3000);
        }
        pipeReader.close();
        System.out.println(ProcessHandle.current() + " " + LocalTime.now().truncatedTo(ChronoUnit.MILLIS) + " Pipe closed");

      } catch (FileNotFoundException e) {
        e.printStackTrace();
        System.out.println("File does not exist.");
      } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Error reading from pipe.");
      } catch (InterruptedException e) {
        e.printStackTrace();
        System.out.println("Error while sleeping.");
      }
    }
  }
}