
public class SingleClubMember extends Member{
	
	private Club club;
	
	public SingleClubMember(String name, int id, Club club) {
		super(name, id);
		this.club = club; 

	
	}

	
	@Override
	public void checkIn(Club club) {
		//Need exception here
		
		/*
		 * if (this.club.equals(club)) { System.out.println("Welcome to your club!"); }
		 * else { System.out.println("This is not your club."); }
		 */
		
		try {
			
			if (this.club.equals(club)) {
				throw new IllegalArgumentException("Must attend home club!");
			}
			
		
		} catch (IllegalArgumentException e) {
			System.out.println("This is not your club.");
			
		}
 
	}


	@Override
	public String toString() {
		return "SingleClubMember [club=" + club + "]";
	}
}
