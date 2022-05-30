
public class MultipleClubMember extends Member{
	
	public MultipleClubMember(String name, int id) {
		super(name, id);
		// TODO Auto-generated constructor stub
	}

	private int memPoints;

	public int getMemPoints() {
		return memPoints;
	}

	public void setMemPoints(int memPoints) {
		this.memPoints = memPoints;
	}

	@Override
	public void checkIn(Club club) {
		memPoints += 50;
		
	}

	@Override
	public String toString() {
		return (this.getName() + " is a multiple club member. " + this.getName() + " has access to all available clubs.");
	}


	

	
}

	
	
	


