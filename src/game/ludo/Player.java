package game.ludo;

public class Player {
	
	private final String name;
	private final TokenColour colour;	
	
	public Player(String name, TokenColour colour) {		
		this.name = name;
		this.colour = colour;
	}	
	
	public String getName() {
		return name;
	}
	
	public TokenColour getColour() {
		return colour;
	}
	

}
