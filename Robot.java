class Robot {
  private Integer x;
  private Integer y;
  private String direction;
  private int dimX;
  private int dimY;
  
  public Robot() {
    this.x = null;
    this.y = null;
    this.direction = "";
    this.dimX = 5;
    this.dimY = 5;
  }

  public Robot(int boardDimensionX, int boardDimensionY) {
    this.x = null;
    this.y = null;
    this.direction = "";
    this.dimX = boardDimensionX;
    this.dimY = boardDimensionY;
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
    String[] commandSplit = command.split(" ");
    String[] posStrings = commandSplit[1].split(",");
    
    Integer newX = Integer.valueOf(posStrings[0]);
    Integer newY = Integer.valueOf(posStrings[1]);
    String newDirection = posStrings[2];    

    if (!outsideBoard(newX, newY)) {
      this.x = newX;
      this.y = newY;
      this.direction = newDirection;
    }
  }

  private void move() {
    Integer newX = this.x;
    Integer newY = this.y;

    switch(this.direction){
      case "NORTH":
        newX = this.x;
        newY = this.y + 1;
        break;
      case "WEST":
        newX = this.x - 1;
        newY = this.y;
        break;
      case "SOUTH":
        newX = this.x;
        newY = this.y - 1;
        break;
      case "EAST":
        newX = this.x + 1;
        newY = this.y;
        break;
      default:
        System.out.println("Direction unkown");
        break;
    }

    if (!outsideBoard(newX, newY)) {
      this.x = newX;
      this.y = newY;
    }
   
  }

  // Needs tests
  private boolean outsideBoard(int x, int y) {
    boolean outside = false;
    if (x >= this.dimX || x < 0 || y >= this.dimY || y < 0){
      outside = true;
    }
    return outside;
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