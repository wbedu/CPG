package everything;
import org.json.*;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Aaron on 3/13/17.
 */
public class SaveState {
    static String savePath = "savePath/saveFile.json";

    protected static void saveGame(User user) throws IOException{
    	JSONObject saveObj = new JSONObject();
    	saveObj.put("name",user.getName());
    	saveObj.put("maxHealth",user.getMaxHealth());
    	saveObj.put("hand",user.hand.getCardList());
    	saveObj.put("money", user.getMoney());
    	saveObj.put("level", user.getLevel());
    	    	
    	try(FileWriter saveFile = new FileWriter(savePath)){
    		saveFile.write(saveObj.toString());
    	}
        System.out.println("game has been saved");
    }

    protected static void loadGame(){
        System.out.println("game has been loaded");

    }


}
