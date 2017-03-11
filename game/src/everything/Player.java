package everything;

import java.util.*;


public class Player {
    private boolean living;
    private int health;
    private int attackPoints;
    private int defencePoints;
    private String name;
    private Deck hand;


    //set to private as this should never be initialized as with NULL stats
    private Player(){
    }


    public Player(String newName,int newHealth,int newAttackPoint,int newdefencePoints, Deck newHand){
        name=newName;
        health=newHealth;
        attackPoints=newAttackPoint;
        defencePoints=newdefencePoints;
        living=true;
        hand=newHand;
    }

    //decreases health but does not change any other stats
    public void decreaseHealth(int decreaseFactor){
        health-=decreaseFactor;
    }
    //increase health but does not  change any other conditions
    public void increaseHealth(int increaseFactor) { health+=increaseFactor; }
    //increase defence but does not change any other conditions
    public void increaseDefence(int increaseFactor) { defencePoints-=increaseFactor; }
    //decreases defence but does not change any other conditions
    public void decreaseDefence(int decreaseFactor) { defencePoints+=decreaseFactor; }
    //set health of player to specific value
    public void setHealth(int healthValue) { health = healthValue; }

    //player takes the damage specified after defence is subtracted;
    //calls lifeCheck to check living status;
    public void takeDamage(int damage){
        int damageTaken = damage - defencePoints;

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

    //returns defence points
    public int getDefence(){
        return defencePoints;
    }

    //returns health points
    public int getHealth(){
        return health;
    }

    //prints players stats
    public void printStats(){
        System.out.println("ID: "+name+" HP: "+health+" ATK: "+attackPoints+" DEF: "+defencePoints);
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