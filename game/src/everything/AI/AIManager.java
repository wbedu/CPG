package everything.AI;

import everything.Player;

public class AIManager {


	public static AI getRandomMonster(Player user) {
		int fight = (int) (Math.random() * 2);
		if (fight < 1)
			return (new Goblin(user));
		else
			return (new Wolf(user));
	}
}
