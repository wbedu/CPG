package everything;
import org.json.*;

import everything.cardPackage.Block;
import everything.cardPackage.Card;
import everything.cardPackage.Cleave;
import everything.cardPackage.Mutton;
import everything.cardPackage.NordicBlood;
import everything.cardPackage.SavageStrike;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Aaron on 3/13/17.
 */
public class SaveState {
    static String savePath = "savePath/saveFile.json";
    static String shopPath = "savePath/shopFile.json";
    ArrayList<String> cards;
    
    public SaveState(){
    	cards=new ArrayList<String>();
    	storeAllCardNames();
    }

    protected static void saveGame(User user) throws IOException{
    	JSONObject saveObj = new JSONObject();
    	saveObj.put("name",user.getName());
    	saveObj.put("maxHealth",user.getMaxHealth());
    	saveObj.put("defence", user.getDefense());
    	saveObj.put("hand",user.hand.getCardList());
    	saveObj.put("money", user.getMoney());
    	saveObj.put("level", user.getLevel());
    	    	
    	try(FileWriter saveFile = new FileWriter(savePath)){
    		saveFile.write(saveObj.toString());
    	}
        System.out.println("game has been saved");
    }

   protected static User loadGame() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        System.out.println("game has been loaded");
        User newPlayer;
       String fileToString = readFile(savePath); 
       
       if(fileToString.equals("null")){
    	   return newGame();
       }
       JSONObject saveObj= stringtoJSON(fileToString);
       
       String name = saveObj.getString("name");
       int maxHealth = saveObj.getInt("maxHealth");
       int defence = saveObj.getInt("defence");
       int money = saveObj.getInt("money");
       int level = saveObj.getInt("level");
       String handList[] = getHandArray(saveObj.getJSONArray("hand"));
       Hand hand = loadHand(handList);
       
       newPlayer= new User(name,maxHealth,defence,money,hand);
       
       return newPlayer;
    }
    
    protected static User newGame(){
        User userPlayer = new User("Aaron", 30, 0);
        userPlayer.hand.addCard(new Block());
        userPlayer.hand.addCard(new Cleave());
        userPlayer.hand.addCard(new Mutton());
        userPlayer.hand.addCard(new NordicBlood());
        userPlayer.hand.addCard(new SavageStrike());
    	return userPlayer;
    }
    
    public static Hand loadHand(String arr[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
    	
    	int len = arr.length;
    	Hand hand=new Hand();
    	
    	for(int i=0;i<len;i++){
    		if(!arr[i].equals("null")){
    			Class newClass = Class.forName(arr[i]);
    			
    			Object obj = newClass.newInstance();
    			
    			hand.addCard((Card)obj);
    		}else{
    			break;
    		}

    	}
    	
    	return hand;
    }
    
    public static String[] getHandArray(JSONArray JArray){
    	int Jlen =JArray.length();
    	
    	String[] cardNames = new String[Jlen];
    	
    	for(int i=0;i<Jlen;i++){
    		cardNames[i] = JArray.getString(i);
    	}
		return cardNames;
    	
    }
    
    public static String readFile(String path){
    	try(BufferedReader reader = new BufferedReader(new FileReader(path))){
    		StringBuilder sb = new StringBuilder();
    		String line = reader.readLine();
    		
    		while(line!=null){
    			sb.append(line);
    			line=reader.readLine();
    		}
    		
    		return sb.toString();
    		
    	} catch (FileNotFoundException e) {
			return "null";
		} catch (IOException e) {
			return "null";
		}

    }
    
    public static JSONObject stringtoJSON(String readString){
    	
       	JSONObject json = new JSONObject(readString);

    	return json;
    }
    
    private String[] getShopCards(){
    	String JsonString = readFile(shopPath);
    	JSONObject jObj= new JSONObject(JsonString);   	
    	JSONArray shopJArray= new JSONArray(jObj.getJSONArray("ShopList"));    	
    	String[] ret = getHandArray(shopJArray);
    	return ret;
    }
    
    private void storeAllCardNames(){
		    	File folder = new File("everything/cardPackage");
		    	File[] files = folder.listFiles();
		    	int len = files.length;
		    	String buf;
		    	for(int i=0;i<len;i++){
		    		if(files[i].isFile()){
		    			buf =files[i].getName();
		    			if((buf.contains(".java"))&&(!buf.equals("card.java"))){
		    			
		    				cards.add(buf.substring(0,buf.lastIndexOf(".java")).trim());
		    			}
		    		}
		    	}
		    	
    }
    
    public ArrayList<String> getCards(){
    	return cards;
    }
    
    public void printCards(){
    	for(int i=0;i<cards.size();i++){
    		System.out.println(cards.get(i));
    	}
    }
    
    
    


}
