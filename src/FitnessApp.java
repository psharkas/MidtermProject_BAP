import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class FitnessApp {

	public static void main(String[] args) {
		ArrayList<Member> memberList = initializeMemberList();

		Scanner scan = new Scanner(System.in);

		dashes(80);
		System.out.printf("%65s", "Welcome to BAP Fitness, where your health matters most!" + "\n");
		dashes(80);

		System.out.println("What would you like to do?" + "\n");

		while (true) {
			chooseMemberMenu();
			int userEntryChooseMemberMenu = promptUserForInt(scan, 3);
			int indexOfMember;

			if (userEntryChooseMemberMenu == 1) {
				// create new member
			} else if (userEntryChooseMemberMenu == 2) {

				indentPrintString(1, "1. Enter your name");
				indentPrintString(1, "2. Enter your ID number");
				int numOrID = promptUserForInt(scan, 2);

				if (numOrID == 1) {
					System.out.print("Please enter user name here: ");
					String userNameEntry = scan.nextLine();
					indexOfMember = findMemberByName(memberList, userNameEntry);

				} else {
					System.out.print("Please enter user ID here: ");
					int userIDentry = scan.nextInt();
					indexOfMember = findMemberById(memberList, userIDentry);
				}
				if (indexOfMember == -1) {
					System.out.println("We cannot find this member.");
					System.out.println("Please check again by entering your ID number or feel free to become a member of BAP Fitness!");
					continue;
				}
				// TODO: method that asks user their name or id number, store index in variable

				existingMemberMenu();
				promptMenuChoice();

				int userEntryExistingMemberMenu = scan.nextInt();

				// TODO: put this switch in a method for ease of reading main
				switch (userEntryExistingMemberMenu) {
				case 1: // check user in (ask them which club they like to check in to

					break;
				case 2:
					System.out.println("");
					BillOfFees.getFee(memberList.get(indexOfMember));
					System.out.println("");

					break;
				case 3:// ask user to confirm deletion again if yes, delete. if no, exit or
						// something.... BOLANLE
					indentPrintString(5, "ARE  YOU SURE YOU WANT TO CANCEL YOUR MEMBERSHIP?");
					indentPrintString(5, "1. Yes");
					indentPrintString(5, "2. No");
					int deleteYN = promptUserForInt(scan, 2);
					if (deleteYN == 1) {
						System.out.println(memberList.get(indexOfMember).getName() + "has been removed from BAP Fitness. We're sorry to see you go!");
						memberList.remove(indexOfMember);
						continue;
					}
					
					break;
					
				default:
					System.out.println("Please enter number from menu");
				}

			}else {
				System.out.println("Thank you for using BAP Fitness!");
				break;
			}
		}
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
		indentPrintString(1, "Exit the program");
	}

	public static void existingMemberMenu() {
		indentPrintString(3, "1. Check-in!");
		indentPrintString(3, "2. See your membership information and billing");
		indentPrintString(3, "3. Cancel your membership with BAP Fitness");
	}

	public static void locationSelect() {

	}

	public static void indentPrintString(int indentLevel, String str) {
		System.out.printf("%" + indentLevel + "s", "");
		System.out.printf(str + "\n");
	}

	public static void promptMenuChoice() {
		System.out.print("\n" + "Please select menu option by number: ");
	}

	public static void currentMemberSwitch(int x, Scanner scan) {
		// TODO PLACE SWITCH HERE
	}

	public static ArrayList<Member> initializeMemberList() {
		ArrayList<Member> memberList = new ArrayList<Member>();
		memberList.add(new MultipleClubMember("Brian Smith", 457299));
		memberList.add(new MultipleClubMember("Booboo Thefool", 123456));
		memberList.add(new SingleClubMember("Lookat Thisguy", 654321, null));
		memberList.add(new SingleClubMember("Who Dunnit", 678901, null));

		return memberList;

	}

	public static int promptUserForInt(Scanner scan, int maxNum) {
		int heresANum;
		do {
			System.out.print("Please select menu option by number: ");
			heresANum = scan.nextInt();
			scan.nextLine();
			System.out.println("");
		} while (heresANum <= 0 || heresANum > maxNum);
		return heresANum;

	}

	public static int promptUserForString(Scanner scan, int indexLevel, String prompt) {
		// Print out the prompt, loop until the user gives you a non-empty string.
		return 0;
	}

	public static int promptUserToFindMember(Scanner scan, int indexLevel) {
		// The idea is to encapsulate all of your logic around "do you want to find by
		// name or id? enter name: etc"
		return 0;
	}

	public static int findMemberByName(ArrayList<Member> memberList, String memberName) {
		for (int i = 0; i <= memberList.size() - 1; i++) {
			if (memberList.get(i).getName().equals(memberName)) {
				return i;
			}
		}
		return -1;
	}

	public static int findMemberById(ArrayList<Member> memberList, int ID) {
		// The idea is to give it the list and a name and return the index of a member
		// which has
		for (int i = 0; i <= memberList.size() - 1; i++) {
			if (memberList.get(i).getId() == ID) {
				return i;
			}
		}
		return -1;
	}
}
//	public static int generateRandomID() {
//		//using secure random as it's less likely to repeat itself (
//		SecureRandom randomInt = new SecureRandom();
//		int randomIDNum = randomInt.nextInt(100000);
//		return randomIDNum;
//		TODO:check if num generated already exists in existing IDs

//TODO:	Display member info - Accessing member from whatever List their from 
// Check a member into club/points (check-in function)
// exception used to put user back to another point in the code (print exception
// message ("not your code")) CATCH IN MAIN
// Store you can use points
// points for checking in
