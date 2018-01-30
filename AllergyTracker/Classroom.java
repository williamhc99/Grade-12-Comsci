
/*
 * Name: William Chen, Marcus Ng, Matthew Deng, Ethan Tam
 * Date: May 30th 2017
 * Program Name: RoomSuperclass
 * Description: Classroom Superclass
 */

import java.awt.*;
import java.util.*;// scanner to get input

public class Classroom {
	ArrayList<User> al = new ArrayList<User>();
	String[] schedule = new String[6];
	int roomNumber;

	public Classroom(int roomNumber, ArrayList<User> al) {
		this.roomNumber = roomNumber;
		this.al = al;
	}

	public void inputSchedule(String[] s) {
		for (int i = 0; i < s.length; i++) {
			schedule[i] = s[i];
		}
	}

	public String[] outputSchedule() {
	
			return schedule;
		
	}

}