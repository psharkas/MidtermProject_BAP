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
<<<<<<< Updated upstream
					System.out.println("What club would you like to check in to?");
					ArrayList<Club> clubArray = new ArrayList<>();
					clubArray.add(0, new Club("Club 1", "Detroit, MI"));
					clubArray.add(1, new Club("Club 2", "Detroit, MI"));
					clubArray.add(2, new Club("Club 3", "Detroit, MI"));
					clubArray.add(3, new Club("Club 4", "Detroit, MI"));
					System.out.println(clubArray.get(0).getName());
					 break; 
=======
					checkInMenu();
					
					//int clubResponse = checkInClub(scan, clubs);
					try {
						checkIn(NEED TO ADD CLUB);
					} catch (IllegalArgumentException e) {
					
						System.out.println("");
						
					}
					  
					  
					 

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
>>>>>>> Stashed changes
					
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
	
	//menu for Check In
		public static void checkInMenu() {
			dashes(50);
			indentPrintString(3, "1. Novi");
			indentPrintString(3, "2. Northville");
			indentPrintString(3, "3. Wixom");
			indentPrintString(3, "3. West Bloomfield");
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
<<<<<<< Updated upstream
=======

	
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
	
		
		SecureRandom randomInt = new SecureRandom();
		int generatedId;
	
		
		do {
			generatedId= randomInt.nextInt(100000);
			if (!ids.contains(generatedId)) {
				notUsed = false;
				ids.add(generatedId);
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
	
	
	public static Club checkInClub(Scanner scan, ArrayList<Club> clubs) {
		System.out.println("What club would you like to check in to?");
		for (int i = 0; i < clubs.size(); i++) {
			System.out.println( (i+1) + ". " + clubs.get(i));
		}
		int clubResponse = scan.nextInt();
		scan.nextLine();
	
		return clubs.get(clubResponse-1);
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

>>>>>>> Stashed changes
}
