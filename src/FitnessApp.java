
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math.*;

public class FitnessApp {

	public static void main(String[] args) {

		ArrayList<Club> clubs = new ArrayList<>();
		ArrayList<Integer> ids = new ArrayList<>();

		Club bapFitnessNovi = new Club("BAP Fitness Novi", "42 Novi Rd");
		Club bapFitnessNorthville = new Club("BAP Fitness Northville", "24 Griswold St");
		Club bapFitnessWixom = new Club("BAP Fitness Wixom", "962 Alpha Dr");
		Club bapFitnessWestBloomfield = new Club("BAP Fitness West Bloomfield", "6475 Drake Rd");

		clubs.add(bapFitnessNovi);
		clubs.add(bapFitnessNorthville);
		clubs.add(bapFitnessWixom);
		clubs.add(bapFitnessWestBloomfield);

		// hard-coded arraylist called into the program
		ArrayList<Member> memberList = initializeMemberList(clubs);

		Scanner scan = new Scanner(System.in);

		dashes(80);
		System.out.printf("%65s", "Welcome to BAP Fitness, where your health matters most!" + "\n");
		dashes(80);

		System.out.println("What would you like to do?" + "\n");

		while (true) {
			// ask user if they want to create new member or access existing member
			chooseMemberMenu();
			int userEntryChooseMemberMenu = promptUserForInt(scan, 3);
			int indexOfMember;

			if (userEntryChooseMemberMenu == 1) {
				// create new member
				createMember();
				int memberSelection = promptUserForInt(scan, 2);
				// scan.nextLine();

				switch (memberSelection) {
				case 1:
					getName();
					String memberName = scan.nextLine();
					System.out.println("Your name is: " + memberName);

					int memberId = generateId(ids);
					System.out.println("Your member ID is: " + memberId);

					Club memberClub = selectClub(scan, clubs);

					memberList.add(new SingleClubMember(memberName, memberId, memberClub));

					System.out.println();

					break;

				case 2:
					getName();
					String multiMemberName = scan.nextLine();
					System.out.println("Your name is: " + multiMemberName);

					int multiMemberId = generateId(ids);
					System.out.println("Your member ID is: " + multiMemberId);
					MultipleClubMember newMultiClubMem = new MultipleClubMember(multiMemberName, multiMemberId);
					memberList.add(newMultiClubMem);
					newMultiClubMem.welcomeBonus();
					System.out.println("Thank you for joining BAP Fitness!");
					break;

				default:
					System.out.println("Invalid input.");
				}

//				System.out.println("You chose: " + memberSelection);

			} else if (userEntryChooseMemberMenu == 2) {
				// prompt user to enter either an id num or name, then stores the index where it
				// is found in numOrID.
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
					System.out.println("Please check again or feel free to become a member of BAP Fitness!");
					continue;
				}
				// display menu for checking in, user info and billing, and canceling
				// membership. Get user int to go into switch
				existingMemberMenu();
				int userEntryExistingMemberMenu = promptUserForInt(scan, 3);

				// TODO: put this switch in a method for ease of reading main
				switch (userEntryExistingMemberMenu) {
				case 1: // check user in (ask them which club they like to check in to
					// checkInMenu();

					// int clubResponse = checkInClub(scan, clubs);
					try {

						memberList.get(indexOfMember).checkIn(selectClub(scan, clubs));

					} catch (IllegalArgumentException e) {

						// System.out.println("");
					}
					break;

				case 2:
					// Prints out member info and billing
					System.out.println("");
					BillOfFees.getFee(memberList.get(indexOfMember));
					System.out.println("");

					break;
				case 3:// ask you user if they really want to cancel, if yes, then removes member from
						// arraylist

					indentPrintString(5, "ARE  YOU SURE YOU WANT TO CANCEL YOUR MEMBERSHIP?");
					indentPrintString(5, "1. Yes");
					indentPrintString(5, "2. No");
					int deleteYN = promptUserForInt(scan, 2);
					if (deleteYN == 1) {
						System.out.println(memberList.get(indexOfMember).getName()
								+ " has been removed from BAP Fitness. We're sorry to see you go!");
						memberList.remove(indexOfMember);
						continue;
					} else if (deleteYN == 2) {
						System.out.println("");
						System.out.println("We're glad you're staying with us!");
						System.out.println();
					}

					break;

				default:
					System.out.println("Please enter number from menu");
				}

			} else {
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

	// menu for existing
	public static void chooseMemberMenu() {
		dashes(50);
		indentPrintString(1, "1. Create new member");
		indentPrintString(1, "2. Access existing member");
		indentPrintString(1, "3. Exit the program");
	}

	// menu for existing members
	public static void existingMemberMenu() {
		dashes(50);
		indentPrintString(3, "1. Check-in!");
		indentPrintString(3, "2. See your membership information and billing");
		indentPrintString(3, "3. Cancel your membership with BAP Fitness");
	}

	// prints a string with desired format indentation
	public static void indentPrintString(int indentLevel, String str) {
		System.out.printf("%" + indentLevel + "s", "");
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
		System.out.print("Please enter your full name: ");

	}

	public static int generateId(ArrayList<Integer> ids) {
		boolean notUsed = true;

		SecureRandom randomInt = new SecureRandom();
		int generatedId;

		do {
			generatedId = randomInt.nextInt(100000);
			if (!ids.contains(generatedId)) {
				notUsed = false;
				ids.add(generatedId);
			}
		} while (notUsed);
		return generatedId;
	}

	public static Club selectClub(Scanner scan, ArrayList<Club> clubs) {
		System.out.println("Please select your preferred club: ");
		for (int i = 0; i < clubs.size(); i++) {
			System.out.println((i + 1) + ". " + clubs.get(i));
		}
		int clubSelection = promptUserForInt(scan, clubs.size());

		return clubs.get(clubSelection - 1);
	}

	public static void currentMemberSwitch(int x, Scanner scan) {
		// TODO PLACE SWITCH HERE
	}

	// hard-coded arraylist
	public static ArrayList<Member> initializeMemberList(ArrayList<Club> clubs) {

		ArrayList<Member> memberList = new ArrayList<Member>();
		memberList.add(new MultipleClubMember("Brian Smith", 457299));
		memberList.add(new MultipleClubMember("Booboo Thefool", 123456));
		memberList.add(new SingleClubMember("Lookat Thisguy", 654321, clubs.get(1)));
		memberList.add(new SingleClubMember("Who Dunnit", 678901, clubs.get(2)));

		return memberList;
	}

	// prompts user to select menu option. Has a range set (1 to maxNum) and loops
	// until it gets num in that range
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
	
	public static boolean checkMoreThanOneName(ArrayList <Member> mem, String name) {
		int total = 0;
		for (int i = 0; i < mem.size(); i++) {
			if(mem.get(i).equals(name)) {
				total+= 1;
				if(total > 1) {
					return true;
				}
			}
			
		}
		return false;
	}

}

//fix arraylists DONE
//make name checking case insensitive

//having the same name twice (prompt id entry)
//loop through arrayList by name 
//if (name > 1) {
//	userIdBro
//}
//assigning and checking clubs for singleclub members
