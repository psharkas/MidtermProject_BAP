import java.util.ArrayList;

public class Club {
	
	private String name;
	private String address;
	
	// adds an mcm to the Club class, since every Club should be able to access the members
	static ArrayList<MultipleClubMember> multiMembers = new ArrayList<>();
	
	// adds an scm to the specific instance of a Club
	ArrayList<SingleClubMember> singleMembers = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void addMember(SingleClubMember member) {
		singleMembers.add(member);
	}
	
	// when adding the multiple club members, the method can be static due to the fact that we're not referring to a specific
	// object of Club
	public static void addMember(MultipleClubMember member) {
		multiMembers.add(member);
	}
	
	public void removeMember(SingleClubMember member) {
		singleMembers.remove(member);
	}
	
	// when removing the multiple club members, the method can be static due to the fact that we're not referring to a specific
	// object of Club
	public static void removeMember(MultipleClubMember member) {
		multiMembers.remove(member);
	}
	
	
	
	
}
