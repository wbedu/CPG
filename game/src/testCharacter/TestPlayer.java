import java.util.*;


public class TestPlayer{

    public static void main(String[] args){

        int atk1= genRand(1, 20);
        int atk2= genRand(1,20);
        int def1= genRand(1,5);
        int def2= genRand(1,5);


        Player player1 = new Player("Steve",100,atk1,def1);
        Player player2 = new Player("Aaron",100,atk2,def2);

        battle(player1,player2);
    }


    public static void battle(Player player1,Player player2){
        int atk1= player1.getAttack();
        int def1= player1.getDefence();

        int atk2= player2.getAttack();
        int def2= player2.getDefence();
        int damageTaken=0;
        int round = 0;

        int winner=0;
        while(winner==0){
            System.out.println("Round:"+  round++);
            damageTaken=player2.takeDamage(atk1);

            System.out.println("Player1 takes " +damageTaken+" damage");

            if(player2.getHealth()<=0){
                winner++;
                break;
            }
            player1.takeDamage(atk1);

            System.out.println("Player2 takes " +damageTaken+" damage");

            if(player2.getHealth()<=0){
                winner++;
            }

            player1.printStats();
            player2.printStats();

           
        }

    }

    public static int genRand(int min, int max){
       int ret=min + (int)(Math.random() * ((max - min) + 1));

       return ret;
    }
}