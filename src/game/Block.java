package game;

public class Block {

	@Override
	public String toString() {
		if (player != null)
			return player.getName().substring(0, 1);
		return " ";
	}

	private Player player;

	public Block() {
		// TODO Auto-generated constructor stub

	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
