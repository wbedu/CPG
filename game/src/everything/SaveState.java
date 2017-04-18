package everything;
import org.json.*;

/**
 * Created by Aaron on 3/13/17.
 */
public class SaveState {
    String safePath = "savePath/saveFile.json";

    private void saveGame(User user,Hand hand){
    	JSONObject saveFile = new JSONObject();
    	saveFile.put("name",user.getName());
    	saveFile.put("maxHealth",user.getMaxHealth());
    	saveFile.put("hand","");
    	    	
        System.out.println("game has been saved");
    }

    private void loadGame(){
        System.out.println("game has been loaded");

    }


}
