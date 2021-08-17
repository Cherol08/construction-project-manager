
public class Project {
	// project instance variables
	String projectName;
	String buildingType;
	String buildingAddress;
	String erfNum;
	String deadline;
	double totalFee;
	double totalPaid;

	// project constructor
	public Project(String projectName, String buildingType, String buildingAddress, String erfNum, String deadline,
			double totalFee, double totalPaid) {

		this.projectName = projectName;
		this.buildingType = buildingType;
		this.buildingAddress = buildingAddress;
		this.deadline = deadline;
		this.erfNum = erfNum;
		this.totalFee = totalFee;
		this.totalPaid = totalPaid;
	}

	// method returns compiled info about the project
	public String ProjectDetails() {
		return "Project: " + projectName + "\nBuilding Type: " + buildingType + "\nBuilding Address: " + buildingAddress
				+ "\nERF number: " + erfNum + "\nProject deadline: " + deadline + "\n\nTotal Project fee: R" + totalFee
				+ "\nTotal amount paid to date: R" + totalPaid;
	}

	// method updates amount user pays
	public void PaidAmount(double feePaid) {
		this.totalPaid += feePaid;
	}

	// method returns invoice only. only called if user hasn't already paid full
	// amount.
	public String projectInvoice(String customerName) {
		return "INVOIVE\nProject " + projectName + "\nClient name: " + customerName + "\nTotal Project Fees: R"
				+ totalFee + "\nTotal Paid: R" + totalPaid + "\nBalance Outstanding: R" + (totalFee - totalPaid);
	}
}
