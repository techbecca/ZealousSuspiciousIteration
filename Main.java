class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    // String variable for input data location
    String filename = "test-data.txt";

    // Read file for input data & save in var
    CommandReader cr = new CommandReader(filename);
    cr.read();

    // Construct simulator w/ table dimension, input data
    // Run simulator

  }
}