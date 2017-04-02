package everything;

import java.util.ArrayList;

public abstract class Player {
	protected int level;
    protected boolean living;
    protected int health;
    protected int attackPoints;
    protected int defensePoints;
    protected String name;
    protected ArrayList<Status> status;
    public Hand hand;

 
	protected Player(){
		
    }


    public Player(String newName,int newHealth,int newAttackPoint,int newdefensePoints){
        name=newName;
        health=newHealth;
        attackPoints=newAttackPoint;
        defensePoints=newdefensePoints;
        living=true;
        hand=new Hand();
        status=new ArrayList<Status>();
        level=0;
    }

    //decreases health but does not change any other stats
    protected void decreaseHealth(int decreaseFactor){
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
    public void increaseDefense(int increaseFactor) { defensePoints-=increaseFactor; }
    //decreases defense but does not change any other conditions
    public void decreaseDefense(int decreaseFactor) { defensePoints+=decreaseFactor; }
    //set health of player to specific value
    public void setHealth(int healthValue) { health = healthValue; }

    //player takes the damage specified after defense is subtracted;
    //calls lifeCheck to check living status;
    public void takeDamage(int damage){
      int damageTaken = damage;// - defensePoints;

        if(damageTaken<1){
            damageTaken=0;
        }

        health-=damageTaken;
        lifeCheck();
    }

    //returns attack points
    public int getAttack(){
        return attackPoints;
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
        System.out.println("ID: "+name+" HP: "+health+" ATK: "+attackPoints+" DEF: "+defensePoints);
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
}