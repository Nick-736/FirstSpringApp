package ge.ibsu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//git add .
//git commit -m "Changes Added"
//git push origin main/git pull origin main
//git clone https://github.com/Nick-736/FirstSpringApp.git



//Add the following enhancements to the Spring project based on the sample HR database:
//
//1.Create new entities: Location, Country, and Region.
//2.Update the Department entity:
//-Add a relationship to Location.
//-Add a manager property (linked to the appropriate Employee entity).
//3.Implement an API endpoint to retrieve a list of all departments with the following fields:
//-Department name
//-Manager full name (concatenation of firstName and lastName)
//-Country
//-City
//-Street address
//4.The API should support filtering by:
//-Country
//-City
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
