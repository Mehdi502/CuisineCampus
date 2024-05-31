
public class PlatFactory {
	//We can add others conditions for new dishes
	public static Plat createPlat(String type){
		if("Americain".equalsIgnoreCase(type)) return new Americain();
		else if("Italien".equalsIgnoreCase(type)) return new Italien();
		else if("Vietnamien".equalsIgnoreCase(type)) return new Vietnamien();
		return null;
	}
}
