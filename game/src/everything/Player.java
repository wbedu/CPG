package everything;
import everything.statusPackage.*;
import everything.cardPackage.CardList;
import java.util.ArrayList;

public abstract class Player {
	protected int level;
    protected boolean living;
    protected int health;
    protected int maxHealth;
    protected int defensePoints;
    protected String name;
    public StatusManager statusManager;
    private int money;
    //protected ArrayList<Status> status;
    public Hand hand;
 
	protected Player(){
		
    }


    public Player(String name,int health,int defensePoints){
        this.name=name;
        this.health=health;
        this.defensePoints=defensePoints;
        living=true;
        hand=new Hand();
        cardList=new CardList();
        //status=new ArrayList<Status>();
        statusManager = new StatusManager();
        level=0;
        money=0;
    }
    

    //decreases health but does not change any other stats
    public void decreaseHealth(int decreaseFactor){
        health-=decreaseFactor;
    }
    //increase health but does not  change any other conditions
    public void increaseHealth(int increaseFactor) {
      if(health+increaseFactor > getMaxHealth())
          setHealth(maxHealth);
      else
          health+=increaseFactor;
    }
    //increase defense but does not change any other conditions
    public void increaseDefense(int increaseFactor) { defensePoints+=increaseFactor; }
    //decreases defense but does not change any other conditions
    public void decreaseDefense(int decreaseFactor) {
        if(getDefense() - decreaseFactor <= 0)
            defensePoints = 0;
        else
        defensePoints-=decreaseFactor;
    }

    //set health of player to specific value
    public void setHealth(int healthValue) { health = healthValue; }

    //player takes the damage specified after defense is subtracted;
    //calls lifeCheck to check living status;
    public void takeDamage(int damage){
      int damageTaken = damage - defensePoints;

        if(damageTaken<0){
            damageTaken=0;
        }

        health-=damageTaken;
        lifeCheck();
    }


    //returns defense points
    public int getDefense(){
        return defensePoints;
    }

    //returns health points
    public int getHealth(){
        return health;
    }
    
    public int getMaxHealth(){
    	return maxHealth;
    }
    
    public String getName(){
    	return this.name;
    }
    public int getMoney(){
    	return money;
    }
    
    public void depositMoney(int deposit){
    	money+=deposit;
    }
    
    public int withdrawMoney(int withdrawal){
    	
    	if(money-withdrawal>0){
    		money-=withdrawal;
    		return 1;
    	}
    	return 0;
    	
    }
    //prints players stats
    public void printStats(){
        System.out.println("ID: "+name+" HP: "+health+" DEF: "+defensePoints);
    }
    
    
    public void setLevel(int newLevel){
    	level=newLevel;
    }
    public void increaseLevel(){
    	level++;
    }
    public int getLevel(){
    	return level;
    }

    //sets living status based on health
    protected boolean lifeCheck(){
        if(health<=0){
            living=false;
        }else{
            living=true;
        }
        
        return living;
    }
    
    public void addStatus(Status newStatus){
    	statusManager.addStatus(newStatus,this);
    }
    
    public void runStatusStart(){
    	statusManager.runStatusBeginning();
    }

    public void runStatusEnd(){
        statusManager.runStatusEnding();
    }

    public boolean isAtMaxHealth(){
    	if(getHealth() == maxHealth)
    		return true;
    	else{
    		return false;
    	}
    }
    
    public String[] getImagePaths(){
    	return hand.getImagePaths();
    }
}