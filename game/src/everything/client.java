package everything;

/**
 * Created by Aaron on 3/4/17.
 */
public class client {
    public static void main(String args[]){
        boolean gameLoop = true;
        panelUI panelUIInst = new panelUI();

        while(gameLoop){
            panelUIInst.setMessage("Test");
        }
    }
}
