import java.util.Scanner;

public class PoisedProject {

	public static void main(String[] args) {
		String name, surname;
		String userType;
		String telephoneNum;
		String email;
		String physicalAdd;
		String projectName, buildingType, erfNum, deadline;
		double totalFee, totalPaid;

		// User prompted to add new project details when program runs

		System.out.println("ADD NEW PROJECT");
		try (Scanner input = new Scanner(System.in)) {

			System.out.println("\nEnter Project name:");
			projectName = input.nextLine();
			System.out.println("Enter building type:");
			buildingType = input.nextLine();
			System.out.println("Enter building address:");
			physicalAdd = input.nextLine();
			System.out.println("Enter building ERF number:");
			erfNum = input.nextLine();
			System.out.println("Enter project deadline(yyyy-MM-dd):");
			deadline = input.nextLine();
			System.out.println("Overall Project Fee:");
			totalFee = input.nextDouble();
			System.out.println("Total paid to date:");
			totalPaid = input.nextDouble();
			input.nextLine();

			// created a new project Object, by calling the method and placing user input
			// about the project in the parameters
			Project newProject = new Project(projectName, buildingType, physicalAdd, erfNum, deadline, totalFee,
					totalPaid);

			// created person objects initiated as null so they're accessible out of the
			// loop (Object parameters will be allocated in the loop).
			Person customer = null;
			Person architect = null;
			Person contractor = null;
			int loop = 0;

			System.out.println("\nCustomer Details".toUpperCase());
			while (loop < 3) {
				loop++;
				System.out.println("\nEnter name:");
				name = input.nextLine();
				System.out.println("Enter surname:");
				surname = input.nextLine();
				System.out.println("Enter telephone number:");
				telephoneNum = input.nextLine();
				System.out.println("Enter email address:");
				email = input.nextLine();
				System.out.println("Enter physical address:");
				physicalAdd = input.nextLine();

				if (loop == 1) {
					userType = "Customer";
					customer = new Person(name, surname, userType, telephoneNum, email, physicalAdd);
					if (projectName.isBlank()) { // if project name not provided Building type & client surname used in
													// place of.
						newProject.projectName = newProject.buildingType + " " + surname;
					}
					System.out.println("\nProject Architect Details".toUpperCase());
				}
				if (loop == 2) {
					userType = "Architect";
					architect = new Person(name, surname, userType, telephoneNum, email, physicalAdd);
					System.out.println("\nProject Contractor Details".toUpperCase());
				}
				if (loop == 3) {
					userType = "Contractor";
					contractor = new Person(name, surname, userType, telephoneNum, email, physicalAdd);
				}
			}

			System.out.println("\n\nInformation Successfully Saved!\n\n");
			System.out.println(newProject.ProjectDetails() + "\n\n");
			System.out.println(customer.PersonDetails() + "\n\n");
			System.out.println(architect.PersonDetails() + "\n\n");
			System.out.println(contractor.PersonDetails() + "\n\n");

			// User can edit project details
			System.out.println("""
					Edit project details:
					1 - Edit contractor details
					2 - Edit project deadline
					3 - Change amount paid to date
					4 - Finalise project
					0 - exit
					Enter option:""");
			int option = input.nextInt();

			// loop used to ask user for changes they want to make until they exit the
			// program
			while (option != 0) {
				if (option == 1) {
					input.nextLine();
					System.out.println("\nEnter New Contractor Name:");
					contractor.name = input.nextLine();
					System.out.println("Surname:");
					contractor.surname = input.nextLine();
					System.out.println("Telephone number:");
					contractor.telephoneNum = input.nextLine();
					System.out.println("Email Address: ");
					contractor.email = input.nextLine();
					System.out.println("Physical Address:");
					contractor.physicalAdd = input.nextLine();
					System.out.println("\n" + contractor.PersonDetails());

				} else if (option == 2) {
					input.nextLine();
					System.out.println("\nEnter New deadline(yyy-MM-dd):");
					newProject.deadline = input.nextLine();
					System.out.println("\nDeadline changed: " + newProject.deadline);

				} else if (option == 3) {
					System.out.println("\nEnter amount paid:");
					newProject.PaidAmount(input.nextDouble());
					System.out.println("\n\n" + newProject.ProjectDetails());

				} else if (option == 4) { // invoice only provided if user hasn't already paid full amount
					if (newProject.totalFee - newProject.totalPaid != 0) {
						System.out.println(newProject.projectInvoice(customer.name));
					} else {
						System.out.println("Project fully paid. No invoice available.");
					}
				} else if (option == 0) {
					System.out.println("Logout Successful!");
					break;
				}
				System.out.println("""

						Choose an option:
						1 - Edit contractor details
						2 - Edit project deadline
						3 - Change amount paid to date
						4 - Finalise project
						0 - exit
						Enter option:""");
				option = input.nextInt();

			}

		}
	}
}
