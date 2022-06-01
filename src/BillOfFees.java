public class BillOfFees {
	
	private static double singleFee = 9.99;
	private static double multiFee = 19.99;
	
	public static void getFee(SingleClubMember member) {
		System.out.println("Fee for " + member.getName() + " is " + singleFee);
	}
	
	public static void getFee(MultipleClubMember member) {
		System.out.println("Fee for " + member.getName() + " is " + multiFee);
		System.out.println(member.getName() + " has " + member.getMemPoints() + " points");

	}
	
	public static void getFee(Member mem) {
		if(mem instanceof MultipleClubMember) {
			getFee((MultipleClubMember) mem);
		}else if (mem instanceof SingleClubMember) {
			getFee((SingleClubMember) mem);
		}

	}

}