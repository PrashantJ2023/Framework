package mavenForJenkins;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class sendWeatherMail {

	
public static void sendWeatherMailreport(String city, String Ctemp,String temp) throws Throwable {
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("testprashant727@gmail.com", "tpcidncnefyezvqh"));
		email.setSSLOnConnect(true);
		email.setFrom("testprashant727@gmail.com");
		email.setSubject("Today Weather report"); 
		

		email.setMsg("Hi,\n   \nToday weather forecast report is\n \n" +city +"\n" + Ctemp + temp +"\nThanks and Regards \n Prashant ");
		
		
		email.addTo("prashant.jadar@gmail.com");
		email.send();
	System.out.println("Email sent");
		
		
	}
}
