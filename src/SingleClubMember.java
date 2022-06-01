
public class SingleClubMember extends Member {

	private Club club;

	public SingleClubMember(String name, int id, Club club) {
		super(name, id);
		this.club = club;

	}

	@Override
	public void checkIn(Club club) {

		if (this.club.equals(club)) {
			System.out.println("Welcome to your club!");
		} else {
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
		}

	public Club getClub() {
		return club;
	}

	@Override
	public String toString() {
		return (this.getName() + " is a single club member at " + this.club);
	}
}
