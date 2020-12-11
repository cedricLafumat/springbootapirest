package com.campus.SpringBootApiRest;

import com.campus.SpringBootApiRest.model.Car;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootApiRestApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void testCar(){
		//récupère tout les vehicules
		String resultRequest1 = this.testRestTemplate.getForObject("/car", String.class);
		assertEquals("[{\"id\":1,\"model\":\"Fiesta\",\"marque\":\"Ford\",\"color\":\"noire\"}," +
				"{\"id\":2,\"model\":\"Mondeo\",\"marque\":\"Ford\",\"color\":\"gris\"}," +
				"{\"id\":3,\"model\":\"A7\",\"marque\":\"Audi\",\"color\":\"noire\"}]", resultRequest1);

		//Ajoute un vehicule
		Car addingCar = new Car (4, "Focus", "Ford", "gris");
		String resultRequest2 = this.testRestTemplate.postForObject("/car", addingCar, String.class);
		assertEquals("{\"id\":4,\"model\":\"Focus\",\"marque\":\"Ford\",\"color\":\"gris\"}", resultRequest2);

		//Vérification de l'ajout du véhicule
		String resultRequest3 = this.testRestTemplate.getForObject("/car", String.class);
		assertEquals("[{\"id\":1,\"model\":\"Fiesta\",\"marque\":\"Ford\",\"color\":\"noire\"}," +
				"{\"id\":2,\"model\":\"Mondeo\",\"marque\":\"Ford\",\"color\":\"gris\"}," +
				"{\"id\":3,\"model\":\"A7\",\"marque\":\"Audi\",\"color\":\"noire\"}," +
				"{\"id\":4,\"model\":\"Focus\",\"marque\":\"Ford\",\"color\":\"gris\"}]", resultRequest3);

		//Modification d'un véhicule et vérification de la modification
		Car modifyCar = new Car (2, "Mondeo", "Ford", "orange");
		this.testRestTemplate.put("/car/2", modifyCar, String.class);
		String resultRequest4 = this.testRestTemplate.getForObject("/car/2", String.class);
		assertEquals("{\"id\":2,\"model\":\"Mondeo\",\"marque\":\"Ford\",\"color\":\"orange\"}", resultRequest4);

		//Vérification de la liste des véhicules après modif
		String resultRequest5 = this.testRestTemplate.getForObject("/car", String.class);
		assertEquals("[{\"id\":1,\"model\":\"Fiesta\",\"marque\":\"Ford\",\"color\":\"noire\"}," +
				"{\"id\":2,\"model\":\"Mondeo\",\"marque\":\"Ford\",\"color\":\"orange\"}," +
				"{\"id\":3,\"model\":\"A7\",\"marque\":\"Audi\",\"color\":\"noire\"}," +
				"{\"id\":4,\"model\":\"Focus\",\"marque\":\"Ford\",\"color\":\"gris\"}]", resultRequest5);

		//Suppression d'un véhicule
		testRestTemplate.delete("/car/3", 3);
		String resultRequest6 = this.testRestTemplate.getForObject("/car", String.class);
		assertEquals("[{\"id\":1,\"model\":\"Fiesta\",\"marque\":\"Ford\",\"color\":\"noire\"}," +
				"{\"id\":2,\"model\":\"Mondeo\",\"marque\":\"Ford\",\"color\":\"orange\"}," +
				"{\"id\":4,\"model\":\"Focus\",\"marque\":\"Ford\",\"color\":\"gris\"}]", resultRequest6);
	}

	/*@Test
	public void getAllCars() {
		String resultRequest = this.testRestTemplate.getForObject("/car", String.class);
		assertEquals("[{\"id\":1,\"model\":\"Fiesta\",\"marque\":\"Ford\",\"color\":\"noire\"}," +
				"{\"id\":2,\"model\":\"Mondeo\",\"marque\":\"Ford\",\"color\":\"gris\"}," +
				"{\"id\":3,\"model\":\"A7\",\"marque\":\"Audi\",\"color\":\"noire\"}]", resultRequest);
	}

	@Test
	public void getCarById() {
		String resultRequest = this.testRestTemplate.getForObject("/car/2", String.class);
		assertEquals("{\"id\":2,\"model\":\"Mondeo\",\"marque\":\"Ford\",\"color\":\"gris\"}", resultRequest);
	}

	@Test
	public void addCar() {
		Car addingCar = new Car (4, "Focus", "Ford", "gris");
		this.testRestTemplate.postForObject("/car", addingCar, String.class);
		String resultRequest = this.testRestTemplate.getForObject("/car", String.class);
		assertEquals("[{\"id\":1,\"model\":\"Fiesta\",\"marque\":\"Ford\",\"color\":\"noire\"}," +
				"{\"id\":2,\"model\":\"Mondeo\",\"marque\":\"Ford\",\"color\":\"gris\"}," +
				"{\"id\":3,\"model\":\"A7\",\"marque\":\"Audi\",\"color\":\"noire\"}," +
				"{\"id\":4,\"model\":\"Focus\",\"marque\":\"Ford\",\"color\":\"gris\"}]", resultRequest);
		testRestTemplate.delete("/car/{4}", 4);
	}
	@Test
	public void updateCar() {
		Car modifyCar = new Car (2, "Mondeo", "Ford", "orange");
		this.testRestTemplate.put("/car/2", modifyCar, String.class);
		String resultRequest = this.testRestTemplate.getForObject("/car/2", String.class);
		assertEquals("{\"id\":2,\"model\":\"Mondeo\",\"marque\":\"Ford\",\"color\":\"orange\"}", resultRequest);
		Car remodifyCar = new Car (2, "Mondeo", "Ford", "gris");
		this.testRestTemplate.put("/car/2", remodifyCar, String.class);
	}
	@Test
	public void deleteCarById() {
		testRestTemplate.delete("/car/3", 3);
		String resultRequest = this.testRestTemplate.getForObject("/car", String.class);
		assertEquals("[{\"id\":1,\"model\":\"Fiesta\",\"marque\":\"Ford\",\"color\":\"noire\"}," +
				"{\"id\":2,\"model\":\"Mondeo\",\"marque\":\"Ford\",\"color\":\"gris\"}]", resultRequest);
	}*/

}
