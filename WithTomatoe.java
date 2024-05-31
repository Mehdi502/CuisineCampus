
public class WithTomatoe extends PlatDecorator{

	public WithTomatoe(Plat p) {
		super(p);
	}

	@Override
	public void getIngredients() {
		super.getIngredients();
		Logger logger = Logger.getInstance();
		logger.decorator(", avec des tomates");
	}


}
