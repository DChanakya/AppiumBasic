package managers;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
	Properties p;
	
	public PropertyManager() throws IOException{
		p = new Properties();
		p.load(this.getClass().getResourceAsStream("/test.properties"));
	}
	
	public String getExecutionMode() {
		return p.getProperty("executionMode");
	}
}
