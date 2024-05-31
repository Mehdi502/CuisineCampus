
public abstract class Plat {
	String description;
	
	public void getIngredients() {
		Logger.getInstance().info(description);
	};

}
