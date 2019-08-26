package abc;
import java.util.Calendar;
public class Calendderex {
	public static void main(String[] args) {
		  Calendar cl = Calendar.getInstance();  
		  System.out.println("The current date is : " + cl.getTime());  
		   cl.add(Calendar.DATE, -15);  
		   System.out.println("15 days ago: " + cl.getTime());  
		   cl.add(Calendar.MONTH, 4);  
		   System.out.println("4 months later: " + cl.getTime());  
		   cl.add(Calendar.YEAR, 5);  
		   System.out.println("5 years later: " + cl.getTime());  
	}

}
