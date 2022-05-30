import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math.*;

public class FitnessApp {

	public static void main(String[] args) {
		
		ArrayList<MultipleClubMember> multiMembers = new ArrayList<>();
		ArrayList<Club> clubs = new ArrayList<>();
		ArrayList<Integer> ids = new ArrayList<>();
		
		Club bapFitnessNovi = new Club("BAP Fitness Novi", "42 Novi Rd");
		Club bapFitnessNorthville = new Club("BAP Fitness Northville", "24 Griswold St");
		Club bapFitnessWixom = new Club("BAP Fitness Wixom", "962 Alpha Dr");
		Club bapFitnessWestBloomfield = new Club("BAP Fitness West Bloomfield","6475 Drake Rd");
		
		clubs.add(bapFitnessNovi);
		clubs.add(bapFitnessNorthville);
		clubs.add(bapFitnessWixom);
		clubs.add(bapFitnessWestBloomfield);


		
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
				createMember();
				int memberSelection = scan.nextInt();
				scan.nextLine();
				
				switch (memberSelection) {
				case 1:
					getName();
					String memberName = scan.nextLine();
					System.out.println("Your name is: " + memberName);
					
					int memberId = generateId(ids);
					System.out.println("Your member ID is: " + memberId);
					
					Club memberClub = selectClub(scan, clubs);
					
					SingleClubMember newMember = new SingleClubMember(memberName,memberId,memberClub);
					System.out.println(newMember);
					
					break;
				
				case 2:
					getName();
					String multiMemberName = scan.nextLine();
					System.out.println("Your name is: " + multiMemberName);
					
					int multiMemberId = generateId(ids);
					System.out.println("Your member ID is: " + multiMemberId);
					
					MultipleClubMember newMultiMember = new MultipleClubMember(multiMemberName,multiMemberId);
					multiMembers.add(newMultiMember);
					System.out.println(newMultiMember);
					break;
					
				default:
					System.out.println("Invalid input.");
				}
				
//				System.out.println("You chose: " + memberSelection);
				
			} else if (userEntryChooseMemberMenu == 2) {

				existingMemberMenu();
				promptMenuChoice();
				
				int userEntryExistingMemberMenu = scan.nextInt();

				switch (userEntryExistingMemberMenu) {
				case 1: // check user in (ask them which club they like to check in to

					break;
				case 2: // select a specific member, then generate their bill (based on single or multi
						// member)

					break;
				case 3:// ask user to confirm deletion again if yes, delete. if no, exit or
						// something....

					break;
				case 4:

					break;

				default:
				}

			}
		} while (userEntryChooseMemberMenu != 1 && userEntryChooseMemberMenu != 2);
		
		
		
		
		
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
	
	public static void createMember() {
		System.out.println("Would you like to become a single or multi-club member?");
		indentPrintString(1, "1. Single Club Member");
		indentPrintString(1, "2. Multi Club Member"); 
	}
	
	public static void getName() {
		System.out.println("Please enter your full name.");
		
	}
	
	public static int generateId(ArrayList<Integer> ids) {
		boolean notUsed = true;
		int generatedId;
		
		do {
			generatedId = (int)(Math.random()*100) + 1;
			if (!ids.contains(generatedId)) {
				notUsed = false;
			}
		}while(notUsed);
		return generatedId;
	}
	
	public static Club selectClub(Scanner scan, ArrayList<Club> clubs) {
		System.out.println("Please select the club you would like to join: ");
		for (int i = 0; i < clubs.size(); i++) {
			System.out.println( (i+1) + ". " + clubs.get(i));
		}
		int clubSelection = scan.nextInt();
		scan.nextLine();
	
		return clubs.get(clubSelection-1);
	}
	
}
