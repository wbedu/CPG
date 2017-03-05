import java.util.*;


public class TestPlayer{

    public static void main(String[] args){

        int atk1= genRand(1, 20);
        int atk2= genRand(1,20);
        int def1= genRand(1,2);
        int def2= genRand(1,2);


        Player player1 = new Player("Steve",100,atk1,def1);
        Player player2 = new Player("Aaron",100,atk2,def2);

        battle(player1,player2);
    }


    public static void battle(Player player1,Player player2){
        int atk1= player1.getAttack();
        int atk2= player2.getAttack();
        int round = 0;

        int winner=0;
        while(true){
            System.out.println("Round:"+  round++);
            player1.takeDamage(atk2);

            if(!player1.isDead()){
                winner++;
                System.out.println("Steve is D-E-D Dead");
                break;
            }
            player2.takeDamage(atk1);

            if(!player2.isDead()){
                winner++;
                System.out.println("Aaron is D-E-D Dead");
                break;
            }

            player1.printStats();
            player2.printStats();

            round++;
           if(round>30){

               System.out.println("Stalemate");
               break;
           }
        }

    }

    public static int genRand(int min, int max){
       int ret=min + (int)(Math.random() * ((max - min) + 1));

       return ret;
    }
}