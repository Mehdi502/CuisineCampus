
public class WithoutGluten extends PlatDecorator{

	public WithoutGluten(Plat p) {
		super(p);
	}

	@Override
	public void getIngredients() {
		super.getIngredients();
		Logger logger = Logger.getInstance();
		logger.decorator(", sans gluten");
	}


}
