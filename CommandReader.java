import java.io.*;
import java.util.*;

public class CommandReader {
  String filename;
  LinkedList<String> strings;
  LinkedList<String> commandSet;
  LinkedList<LinkedList<String>> commandSets;
  /* Desired functionality
      - import file
      - parse file
      - make list with commands
      - make array with each set of commands

  */

  public CommandReader(String filename) {
    this.filename = filename;
    this.commandSet = new LinkedList<String>();
    this.commandSets = new LinkedList<LinkedList<String>>();
    this.strings = new LinkedList<String>();
  }

  public LinkedList<String> read() {
    try 
    {
      BufferedReader br = new BufferedReader(new FileReader(new File(this.filename)));
      String line = null;
      
      while ((line = br.readLine()) != null) 
      {
        strings.add(line);
      }
      br.close();
      //System.out.println(strings);
      return strings;
    } 
    catch(FileNotFoundException ex) 
    {
      System.out.println("Unable to open file '" + filename + "'");
      return strings;
    } 
    catch(IOException ex) 
    {
      System.out.println("Error reading file '" + filename + "'");
      return strings;
    }

  }
  
}