
public class MultipleClubMember extends Member{
	
	public MultipleClubMember(String name, int id) {
		super(name, id);
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
		System.out.println("We welcome our multi club members. Here's 50 points!");
		
	}

	@Override
	public String toString() {
		return "MultipleClubMember [memPoints=" + memPoints + "]";
	}


	//Welcome bonus
	
	public void welcomeBonus() {
		memPoints += 3000;
	}



	
}

	
	
	


