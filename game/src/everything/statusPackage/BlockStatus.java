/**
 * 
 */
package everything.statusPackage;
import everything.*;
public class BlockStatus extends Status{
	public static final String text="Hold your shield up, negating all damage for the turn";

	
	public BlockStatus(Player newUser, Player newEnemy){
		user=newUser;
		enemy=newEnemy;
		turns =1;
		
	}
	
	@Override
	public void statusEffect(){
		user.decreaseDefense(100);
	}
}
