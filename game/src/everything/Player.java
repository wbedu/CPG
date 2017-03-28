package everything;


public abstract class Player {
	protected int level;
    protected boolean living;
    protected int health;
    protected int attackPoints;
    protected int defensePoints;
    protected String name;
    protected Deck deck;
    public Hand hand;

 
	protected Player(){
    }


    public Player(String newName,int newHealth,int newAttackPoint,int newdefensePoints, Deck newDeck){
        name=newName;
        health=newHealth;
        attackPoints=newAttackPoint;
        defensePoints=newdefensePoints;
        living=true;
        deck=new Deck();
        hand=new Hand();
        level=0;
    }

    //decreases health but does not change any other stats
    protected void decreaseHealth(int decreaseFactor){
        health-=decreaseFactor;
    }
    //increase health but does not  change any other conditions
    public void increaseHealth(int increaseFactor) { health+=increaseFactor; }
    //increase defense but does not change any other conditions
    public void increaseDefense(int increaseFactor) { defensePoints-=increaseFactor; }
    //decreases defense but does not change any other conditions
    public void decreaseDefense(int decreaseFactor) { defensePoints+=decreaseFactor; }
    //set health of player to specific value
    public void setHealth(int healthValue) { health = healthValue; }

    //player takes the damage specified after defense is subtracted;
    //calls lifeCheck to check living status;
    public void takeDamage(int damage){
        int damageTaken = damage - defensePoints;

        if(damageTaken<1){
            damageTaken=0;
        }

        health= health -damageTaken;
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
    private void lifeCheck(){
        if(health<=0){
            living=false;
        }else{
            living=true;
        }
    }


    //returns the player living status;
    public boolean isDead(){
       return living;
    }
}