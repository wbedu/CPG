/**
 * 
 */
package everything.statusPackage;
import everything.*;
public class BlockStatus extends Status{
	public static final String text="Hold your shield up, negating all damage for the turn";

	
	public BlockStatus(Player newUser){
		user=newUser;
		turns =1;
	}
	
	@Override
	public void statusEffect(){
		
		if(turns==0){
		user.decreaseDefense(100);
		}
	}
}
