/*
 * Name: William Chen, Marcus Ng, Matthew Deng, Ethan Tam
 * Date: May 30th 2017
 * Program Name: User
 * Description: Student object for classroom allergy tracker
 */
public class User {

	String name;
	String allergy;

	public User(String allergy, String name) {
		this.name = name;
		this.allergy = allergy;
	}

	public String getName() {
		return name;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String newAllergy) {
		allergy = newAllergy;
	}

}