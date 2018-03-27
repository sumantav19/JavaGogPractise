package game.game2048;

public class Block {
	private int value;
	
	public Block() {
		// TODO Auto-generated constructor stub
		this.value = 2;
	}
	
	@Override
	public boolean equals(Object b1) {
		// TODO Auto-generated method stub
		return this.value == ((Block)b1).value;
	}
	
	public void addValue(Object b1){
		this.value = this.value + ((Block)b1).value;
	}
}
