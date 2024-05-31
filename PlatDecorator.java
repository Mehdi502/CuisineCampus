
public abstract class PlatDecorator extends Plat {
	public Plat p;
	
	public PlatDecorator(Plat p) {
		this.p=p;
	}

	public void getIngredients() {
		p.getIngredients();
	}

}
