import java.util.*;

public class Player {
    private int health;
    private int attackPoints;
    private int defencePoints;
    private String name;

    public Player(){


    }
    public Player(String newName,int newHealth,int newAttackPoint,int newdefencePoints){
        name=newName;
        health=newHealth;
        attackPoints=newAttackPoint;
        defencePoints=newdefencePoints;
    }


    public void decreaseHealth(int decreaseFactor){
        health-=decreaseFactor;
    }

    public void increaseHealth(int increaseFactor){
        health+=increaseFactor;
    }

    /*public void takeDamage(int damage){
        int damageTaken = damage - defencePoints;

        if(damageTaken>1){
            damageTaken=0;
        }

        health-=damageTaken;
    }*/

    public int takeDamage(int damage){
        int damageTaken = damage - defencePoints;

        if(damageTaken<1){
            damageTaken=0;
        }

        health= health -damageTaken;

        return damageTaken;
    }

    public int getAttack(){
        return attackPoints;
    }

    public int getDefence(){
        return defencePoints;
    }

    public int getHealth(){
        return health;
    }

    public void printStats(){
        System.out.println("ID: "+name+" HP: "+health+" ATK: "+attackPoints+" DEF: "+defencePoints);
    }

    public void isDead(){
        if(health<=0){
            System.out.println( name + "is dead");
        }
    }
}