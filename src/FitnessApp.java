import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class FitnessApp {

	public static void main(String[] args) {
		//hard-coded arraylist called into the program
		ArrayList<Member> memberList = initializeMemberList();

		Scanner scan = new Scanner(System.in);

		dashes(80);
		System.out.printf("%65s", "Welcome to BAP Fitness, where your health matters most!" + "\n");
		dashes(80);

		System.out.println("What would you like to do?" + "\n");

		while (true) {
			//ask user if they want to create new member or access existing member
			chooseMemberMenu();
			int userEntryChooseMemberMenu = promptUserForInt(scan, 3);
			int indexOfMember;

			if (userEntryChooseMemberMenu == 1) {
				// create new member
			} else if (userEntryChooseMemberMenu == 2) {
				//prompt user to enter either an id num or name, then stores the index where it is found in numOrID.
				dashes(50);
				indentPrintString(1, "1. Enter your name");
				indentPrintString(1, "2. Enter your ID number");
				int numOrID = promptUserForInt(scan, 2);

				if (numOrID == 1) {
					System.out.print("Please enter user name here: ");
					System.out.println("");
					String userNameEntry = scan.nextLine();
					indexOfMember = findMemberByName(memberList, userNameEntry);

				} else {
					System.out.print("Please enter user ID here: ");
					int userIDentry = scan.nextInt();
					System.out.println("");
					indexOfMember = findMemberById(memberList, userIDentry);
				}
				if (indexOfMember == -1) {
					System.out.println("We cannot find this member.");
					System.out.println("Please check again by entering your ID number or feel free to become a member of BAP Fitness!");
					continue;
				}
				//display menu for checking in, user info and billing, and canceling membership. Get user int to go into switch
				existingMemberMenu();
				int userEntryExistingMemberMenu = promptUserForInt(scan,3);
				

				// TODO: put this switch in a method for ease of reading main
				switch (userEntryExistingMemberMenu) {
				case 1: // check user in (ask them which club they like to check in to

					break;
				case 2:
					//Prints out member info and billing 
					System.out.println("");
					BillOfFees.getFee(memberList.get(indexOfMember));
					System.out.println("");

					break;
				case 3://ask you user if they really want to cancel, if yes, then removes member from arraylist
						
					indentPrintString(5, "ARE  YOU SURE YOU WANT TO CANCEL YOUR MEMBERSHIP?");
					indentPrintString(5, "1. Yes");
					indentPrintString(5, "2. No");
					int deleteYN = promptUserForInt(scan, 2);
					if (deleteYN == 1) {
						System.out.println(memberList.get(indexOfMember).getName() + "has been removed from BAP Fitness. We're sorry to see you go!");
						memberList.remove(indexOfMember);
						continue;
					}else if (deleteYN == 2) {
						System.out.println("");
						System.out.println("We're glad you're staying with us!");
						System.out.println();
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

	
	//menu for existing 
	public static void chooseMemberMenu() {
		dashes(50);
		indentPrintString(1, "1. Create new member");
		indentPrintString(1, "2. Access existing member");
		indentPrintString(1, "3. Exit the program");
	}
	
	//menu for existing members
	public static void existingMemberMenu() {
		dashes(50);
		indentPrintString(3, "1. Check-in!");
		indentPrintString(3, "2. See your membership information and billing");
		indentPrintString(3, "3. Cancel your membership with BAP Fitness");
	}

	public static void locationSelect() {

	}

	//prints a string with desired format indentation
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
	
	
	//hard-coded arraylist
	public static ArrayList<Member> initializeMemberList() {
		
		ArrayList<Member> memberList = new ArrayList<Member>();
		memberList.add(new MultipleClubMember("Brian Smith", 457299));
		memberList.add(new MultipleClubMember("Booboo Thefool", 123456));
		memberList.add(new SingleClubMember("Lookat Thisguy", 654321, null));
		memberList.add(new SingleClubMember("Who Dunnit", 678901, null));

		return memberList;
	}
	
	
	//prompts user to select menu option. Has a range set (1 to maxNum) and loops until it gets num in that range
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

	// gives method a list and a ID name and return the index of a member
	public static int findMemberByName(ArrayList<Member> memberList, String memberName) {
		for (int i = 0; i <= memberList.size() - 1; i++) {
			if (memberList.get(i).getName().equals(memberName)) {
				return i;
			}
		}
		return -1;
	}
	
	
	// gives method a list and a ID number and return the index of a member
	public static int findMemberById(ArrayList<Member> memberList, int ID) {
		
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
