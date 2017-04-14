package everything.statusPackage;
import java.util.ArrayList;

import everything.*;
public class StatusManager {
	private ArrayList<Status> status;
	
	public StatusManager(){
		status = new ArrayList<Status>();
	}
	
	public void runStatus(){
		
		for(int i=0;i<status.size();i++){
			status.get(i).statusEffect();

		}
		clearExpiredStatus();
	}
	
	public void clearExpiredStatus(){
		for(int i=0;i<status.size();i++){
	
			if(status.get(i).turns<0){
				status.remove(i);
			}
		}
	}
	
	public void addStatus(Status newStatus,Player p1){
		this.status.add(newStatus);
	}
	
	public void clearAllStatus(){
		for(int i=0;i<status.size();i++){
			
			status.get(i).turns=0;
		}
		runStatus();
	}
}
