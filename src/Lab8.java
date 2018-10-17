import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab8 {
	static String[] names = { "Parmenides", "Heraclitus", "Socrates", "Plato", "Aristotle", "Peter Singer", "Alasdair MacIntyre", "Ludwig Wittgenstein", "Bertrand Russell", "John Stuart Mill"};
	static String[] hometown = { "Elea, Magna Graecia", "Ephesus, Selçuk, Turkey", "Alopece", "Athens", "Stagira", "Melbourne, Australia", "Glasgow, UK", "Vienna, Austria", "Trellech, UK", "Pentonville, UK"};
	static String[] food = { "Halloumi? Its all the same to him.", "Kykeon, but the recipe keeps changing.", "Hemlock.",
			"Protean shakes." + " Gotta keep those shoulders broad.",
			"Whatever the appetitive part of the soul desires and the rational permits.", "Salad.", "Communion wafers.", "Wienerschnitzel, vielleicht?", "Tea and crumpets.", "The greatest pizza in the greatest number."};

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String userResponse = null;
		
		do {
			System.out.println(getInfo());
			System.out.println("Would you like to learn more? (Enter 'y' to continue)");
			userResponse = scnr.next();
		}while (userResponse.equalsIgnoreCase("y"));
		
		System.out.println("Goodbye.");

	}

	public static String getInfo() {
		Scanner scnr = new Scanner(System.in);
		int studentInfo = 0;
		
		System.out.println("Which student would you like to learn more about? (Enter 1-10)");
		String userInput = scnr.next();
		
		try {
			studentInfo = Integer.parseInt(userInput);
		}catch(NumberFormatException e) {
			System.out.println("That is not a number.");
			System.out.println(getInfo());
		}
		
		try {
			System.out.println("You selected: " + names[studentInfo -1]);
		}catch (IndexOutOfBoundsException e) {
			System.out.println("Invalid entry. No such student.");
			System.out.println(getInfo());
		}
		System.out.println("What would you like to know about " + names[studentInfo -1] + "?"
				+ " Enter 'h' for their hometown and 'f' for their favorite food.");
		String userChoice = scnr.next();
		if(foodOrHome(userChoice).equalsIgnoreCase("f")) {
			System.out.println(names[studentInfo -1] + "'s favorite food is: " + food[studentInfo -1]);
		}
		else {
			System.out.println(names[studentInfo -1] + "'s hometown is: " + hometown[studentInfo -1]);
		}
		return  "Cool, huh?";
	}

	public static boolean isNumber(String i) {
		Scanner scnr = new Scanner(System.in);
		

		try {

			int num = Integer.parseInt(i);

		} catch (NumberFormatException e) {
			System.out.println("Invalid entry. Please enter a number: ");
			i = scnr.next();

			isNumber(i);

		}
		return true;
	}
	
	public static String foodOrHome(String userChoice) {
		Scanner scnr = new Scanner(System.in);
		String userInput = userChoice;
		if (userInput.equalsIgnoreCase("h")) {
			return userInput;
		}else if (userInput.equalsIgnoreCase("f")) {
			return userInput;
		}else {
			System.out.println("Invalid entry. Enter 'h' for their hometown and 'f' for their favorite food.");
			userInput = scnr.next();
			System.out.println(foodOrHome(userInput));
		}
		return userInput;
	}

}
