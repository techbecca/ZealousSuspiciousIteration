import java.io.*;
import java.util.*;

public class CommandReader {
  String filename;
  LinkedList<String> commandSet;
  LinkedList<List<String>> commandSets;
  /* Desired functionality
      - import file
      - parse file
      - make list with commands
      - make array with each set of commands

  */

  public CommandReader(String filename) {
    this.filename = filename;
    this.commandSet = null;
    this.commandSets = null;
  }

  public LinkedList<List<String>> read() {
    try 
    {
      BufferedReader br = new BufferedReader(new FileReader(new File(this.filename)));
      String line = null;
      
      while ((line = br.readLine()) != null) 
      {
        while(line != "") 
        {
          this.commandSet.add(line);
        }
        commandSets.add(commandSet);
      }

      br.close();
      return commandSets;
    } 
    catch(FileNotFoundException ex) 
    {
      System.out.println("Unable to open file '" + filename + "'");
      return null;
    } 
    catch(IOException ex) 
    {
      System.out.println("Error reading file '" + filename + "'");
      return null;
    }

  }
  
}