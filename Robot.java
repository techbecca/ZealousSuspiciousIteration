class Robot {
  private Integer x;
  private Integer y;
  private String direction;
  
  // Robot class properties: position, direction (& constructor)
  // Robot class methods: left, right, move, report, place

  public Robot() {
    this.x = null;
    this.y = null;
    this.direction = "";
  }

  public Integer getX() {
    return this.x;
  }
  
  public Integer getY() {
    return this.y;
  }

  public String getDirection() {
    return this.direction;
  }

  public boolean isPlaced() {
    return ((x != null) && (y != null));
  }

  public void giveCommand(String command){
    

    if (command.contains("PLACE")) 
    {
        this.place(command);
    } 
    else if (this.isPlaced())
    {
      switch(command) 
      {
        case "MOVE":
          this.move();
          break;
        case "LEFT":
          this.left();
          break;
        case "RIGHT":
          this.right();
          break;
        case "REPORT":
          this.report();
          break;
        default:
          System.out.println("Command unkown: " + command);
          break;
      }
    } 
      
  }

  private void place(String command) {

  }

  private void move() {
    

  }

  private void left() {
    String newDirection = "";
    switch(this.direction){
      case "NORTH":
        newDirection = "WEST";
        break;
      case "WEST":
        newDirection = "SOUTH";
        break;
      case "SOUTH":
        newDirection = "EAST";
        break;
      case "EAST":
        newDirection = "NORTH";
        break;
      default:
        System.out.println("Direction unkown");
        break;
    }

    this.direction = newDirection;
  }

  private void right() {
    String newDirection = "";
    switch(this.direction){
      case "NORTH":
        newDirection = "EAST";
        break;
      case "WEST":
        newDirection = "NORTH";
        break;
      case "SOUTH":
        newDirection = "WEST";
        break;
      case "EAST":
        newDirection = "SOUTH";
        break;
      default:
        System.out.println("Direction unkown");
        break;
    }

    this.direction = newDirection;

  }

  private void report() {
    System.out.println("Position: "+ x + "," + y + "," + direction);
  }

}