class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    // String variable for input data location
    String filename = "test-data.txt";
    

    // Read file for input data & save in var
    CommandReader cr = new CommandReader(filename);
    cr.read();

    // Game class properties: table dimension (arg in constructor), input data (arg in constructor), robot placed, robot;
  // Game class methods: constructor, (private) validCommand, (private) robotIsPlaced, (public) runSim,

  // Loop through input data
      // Check if a robot is placed (has PLACE been commanded before?) 
        // If not, ignore command and go to next line

      // If a robot is placed, call method on robot associated with the command 
        // Note: robot or main app validates whether or not the command would cause it to fall of the board?
  }
}