package everything;
import everything.statusPackage.*;
import java.util.ArrayList;

public abstract class Player {
	protected int level;
    protected boolean living;
    protected int health;
    protected int defensePoints;
    protected String name;
    public StatusManager statusManager;
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
        //status=new ArrayList<Status>();
        statusManager = new StatusManager();
        level=0;
    }

    //decreases health but does not change any other stats
    public void decreaseHealth(int decreaseFactor){
        health-=decreaseFactor;
    }
    //increase health but does not  change any other conditions
    public void increaseHealth(int increaseFactor) {
        if(health+increaseFactor > 30)
            this.health = 30;
        else
            health+=increaseFactor;
    }
    //increase defense but does not change any other conditions
    public void increaseDefense(int increaseFactor) { defensePoints+=increaseFactor; }
    //decreases defense but does not change any other conditions
    public void decreaseDefense(int decreaseFactor) { defensePoints-=decreaseFactor; }
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

    //prints players stats
    public void printStats(){
        System.out.println("ID: "+name+" HP: "+health+" DEF: "+defensePoints);
    }
    
    
    public void setLevel(int newLevel){
    	level=newLevel;
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
    
    public void runStatus(){
    	statusManager.runStatus();
    }
    
    public String[] getImagePaths(){
    	return hand.getImagePaths();
    }
}