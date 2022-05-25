
abstract class Member {
	private String name;
	private int id;
	
	public Member (String name, int id) {
		this.name = name;
		this.id = id;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void printMemberInfo() {
		System.out.println("Member ID: " + id);
		System.out.println("Member name: " + name);
	}

	public abstract void checkIn(Club club);

}
