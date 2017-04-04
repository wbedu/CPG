package everything;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Aaron on 3/30/17.
 */
public class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent buttonPress){
            if(buttonPress.getActionCommand() == "card1"){
                //setMessage("\nCleave: 2 DMG dealt - 1 turn CD");
                //updateCardSelect(0);
                //cardWaiting = false;
            }
            else if(buttonPress.getActionCommand() == "card2"){
                //setMessage("\nSavage Strike: 3 DMG dealt - 3 turn CD");
                //updateCardSelect(1);
                //cardWaiting = false;
            }
            else if(buttonPress.getActionCommand() == "card3"){
                //setMessage("\nBlock: Blocking incoming DMG - 1 turn CD");
                //updateCardSelect(2);
                //cardWaiting = false;
            }
            else if(buttonPress.getActionCommand() == "card4"){
                //setMessage("\nMutton: Restore 4 HP - 3 turn CD");
                //updateCardSelect(3);
                //cardWaiting = false;
            }
            else if(buttonPress.getActionCommand() == "card5"){
                //setMessage("\nShield Bash: Enemy is STUNNED - 1 turn CD");
                //updateCardSelect(4);
                //cardWaiting = false;
            }
            //setMessage("\n"+buttonPress.getActionCommand());

        }
    }

