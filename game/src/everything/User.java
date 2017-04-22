package everything;

public class  User extends Player{

	public User(){
		
		
	}
	
	public User(String name,int health,int defencePoints){
		super(name,health,defencePoints);
		maxHealth=30;
	}

	public User(String name,int health,int defencePoints,int money,Hand hand){
		super(name,health,defencePoints);
		this.depositMoney(money);
		this.hand=hand;
	}
  	
}
