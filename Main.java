import java.util.*;

class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    // String variable for input data location
    String filename = "test-data.txt";
    

    // Read file for input data & save in var
    CommandReader cr = new CommandReader(filename);
    cr.read();

    // Create a robot
    Robot robot = new Robot();

    // Get next command sets and loop through commands

    LinkedList<String> commandSet = null;
    String command = null;

    while ((commandSet = cr.getNextSet()) != null) {
      while ((command = commandSet.pollFirst()) != null) {
        robot.giveCommand(command);
      }
    }

  }
}