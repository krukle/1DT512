package dv512.group13.task3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * Group 13 
 * Isak Karlsson - ik222ne
 * Christoffer Eid - ce223af
 * Olof Enström - oe222fh
 */

public class Interaction {

  public static void main(String[] args) {
    Path path = Paths.get(System.getProperty("user.home") + "/test-directory/");
    try {
      Files.createDirectories(path);
  
      System.out.println("Directory is created!");
    } catch (IOException e) {
      System.err.println("Failed to create directory!" + e.getMessage());
      e.printStackTrace();
    }

    for (int i = 0; i < 500; i++) {
      String timeStamp = LocalTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss-SSS"));
      try {
        File file = new File(path + FileSystems.getDefault().getSeparator() + timeStamp + ".txt");
        file.createNewFile();
        FileWriter fw = new FileWriter(path + FileSystems.getDefault().getSeparator() + timeStamp + ".txt");
        for (int j = 0; j < 10000; j++) {
          fw.write(timeStamp + System.lineSeparator());
        }
        fw.flush();
        fw.close();
        TimeUnit.MILLISECONDS.sleep(10);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}