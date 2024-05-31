
public class Logger {
	private static Logger logger;

	public static Logger getInstance() {
		if(logger == null) {
			logger = new Logger();
		}
		return logger;
		
	}
	public void info(String message) {
		System.out.println("info: "+message);
	}
	//Use of System.error to print message in red
	public void warning(String message) {
		System.err.println("warning: "+message);
	}
	
	//Fonction utilisée pour print les différents ingrédients d'un plat
	public void decorator(String message) {
		System.out.println(message);
	}
}
