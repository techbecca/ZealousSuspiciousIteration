import java.io.*;
import java.util.*;

public class CommandReader {
  String filename;
  LinkedList<String> strings;
  LinkedList<String> commandSet;
  LinkedList<LinkedList<String>> commandSets;

  public CommandReader(String filename) {
    this.filename = filename;
    this.commandSet = new LinkedList<String>();
    this.commandSets = new LinkedList<LinkedList<String>>();
    this.strings = new LinkedList<String>();
  }

  public LinkedList<LinkedList<String>> getCommandSets(){
    return this.commandSets;
  }

  public LinkedList<String> getStrings(){
    return this.strings;
  }

  public void read() {
    try 
    {
      BufferedReader br = new BufferedReader(new FileReader(new File(this.filename)));
      String line = null;
      
      while ((line = br.readLine()) != null) 
      {
        strings.add(line.trim());
      }
      
      br.close();
      parseCommands();
    } 
    catch(FileNotFoundException ex) 
    {
      System.out.println("Unable to open file '" + filename + "'");
    } 
    catch(IOException ex) 
    {
      System.out.println("Error reading file '" + filename + "'");

    }

  }

  public LinkedList<String> getNextCommands(){
    LinkedList<String> commands = this.commandSets.pollFirst();
    return commands;
  }

  public LinkedList<String> getNextSet() {
    return getNextCommands();
  }

  private void parseCommands() {
    try {
      ListIterator<String> itr = this.strings.listIterator();
      while(itr.hasNext()) {
        String command = itr.next();
        
        if (!command.isEmpty()) 
        {
          this.commandSet.add(command);
        }
        else if (command.isEmpty()) 
        {
          this.commandSets.add(commandSet);
          this.commandSet = new LinkedList<String>();
        }
      }

      // Add last set to commandSets
      if (commandSet.size() != 0) 
      {
        this.commandSets.add(commandSet);
      }

    } catch(NullPointerException ex){
      System.out.println("Error reading command sets: ");
    }
  }
  
}