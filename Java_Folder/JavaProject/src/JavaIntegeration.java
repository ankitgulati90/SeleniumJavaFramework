import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;


@RobotKeywords

public class JavaIntegeration {
	
	
	@RobotKeyword
	public static void ShowMessage()
	{
		System.out.println("Java Jar is working");
	}
	
} 
