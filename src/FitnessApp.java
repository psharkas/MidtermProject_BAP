import java.util.ArrayList;
import java.util.Scanner;

public class FitnessApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		dashes(80);
		System.out.printf("%65s", "Welcome to BAP Fitness, where your health matters most!" + "\n");
		dashes(80);

		System.out.println("What would you like to do?" + "\n");

		chooseMemberMenu();
		promptMenuChoice();
		int userEntryChooseMemberMenu = scan.nextInt();

		do {
			if (userEntryChooseMemberMenu == 1) {
				// create new member
			} else if (userEntryChooseMemberMenu == 2) {

				existingMemberMenu();
				promptMenuChoice();
				
				int userEntryExistingMemberMenu = scan.nextInt();

				switch (userEntryExistingMemberMenu) {
				case 1: // check user in (ask them which club they like to check in to
					System.out.println("What club would you like to check in to?");
					ArrayList<Club> clubArray = new ArrayList<>();
					clubArray.add(0, new Club("Club 1", "Detroit, MI"));
					clubArray.add(1, new Club("Club 2", "Detroit, MI"));
					clubArray.add(2, new Club("Club 3", "Detroit, MI"));
					clubArray.add(3, new Club("Club 4", "Detroit, MI"));
					System.out.println(clubArray.get(0).getName());
					 break; 
					
					  case 2: // select a specific member, then generate their bill (based on
					  //single or multi // member)
					  
					  break; case 3:// ask user to confirm deletion again if yes, delete. if no,
					  //exit or // something....
					  
					  break; case 4:
					  
					  break;
					  
					  default: }
					  
					  } } while (userEntryChooseMemberMenu != 1 && userEntryChooseMemberMenu != 2);
					  
					  
					  
					  
					  
					  scan.close();
					 
	}

	public static void printWithDashes(String str) {
		dashes(str.length());
		System.out.println(str);
		dashes(str.length());
	}

	public static void dashes(int x) {
		for (int i = 1; i <= x; i++) {
			System.out.print("=");
		}
		System.out.println("");
	}

	public static void chooseMemberMenu() {
		indentPrintString(1, "1. Create new member");
		indentPrintString(1, "2. Access existing member");
	}

	public static void existingMemberMenu() {
		indentPrintString(3, "1. Check-in!");
		indentPrintString(3, "2. See your membership information and billing");
		indentPrintString(3, "3. Cancel your membership with BAP Fitness");
	}

	public static void locationSelect() {

	}
	public static void indentPrintString (int indentLevel, String str) {
		System.out.printf("%"+ indentLevel +"s", "");
		System.out.printf(str + "\n");
	}
	public static void promptMenuChoice() {
		System.out.print("\n" + "Please select menu option by number: ");
	}
}
