package hospitalManagementSystem;

import java.util.Scanner;

public class HospitalManagementSystem {

	public static void main(String[] args) {

//		p.addPatient();
//		p.viewPatient();

//		Doctor d = new Doctor("Gautami Patil ", "Neurologist");
//		d.addDoctors();
//		d.checkDoctor();
//		
		System.out.println("Enter 1 for Patient : Enter 2 for Doctor : ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter 1 for addPatient & 2 for ViewPatient : ");
			int choice1 = sc.nextInt();
			if (choice1 == 1) {
				System.out.println("Enter patient name : ");
				String pName = sc.next();
				System.out.println("Enter Patient Age : ");
				int pAge = sc.nextInt();
				System.out.println("Enter  patient Gender : ");
				String gender = sc.next();
				Patient p = new Patient(pName, pAge, gender);
				p.addPatient();
			} else {
				Patient p = new Patient();
				p.viewPatient();
			}
			break;
		case 2:
			System.out.println("Enter 1 for addDoctor : 2 for CheckDoctor : ");
			int choice2 = sc.nextInt();
			if (choice2 == 1) {
				System.out.println("Enter Doctor Name : ");
				String dName = sc.next();
				System.out.println("Enter Doctor Specilization : ");
				String specilization = sc.next();

				Doctor d = new Doctor(dName, specilization);
				d.addDoctors();
			} else {
				Doctor d = new Doctor();
				d.checkDoctor();

			}
			break;
		default:
			System.out.println("Invalid choice 🤣🤣🤣🤣");
			break;
		}
	}

}
