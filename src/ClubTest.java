import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClubTest {
	
	@Test
	void testMultiClubAdding() {
		Club planetFitness = new Club();
		MultipleClubMember multi = new MultipleClubMember();
		Club.addMember(multi);
		
		int expected = 0;
		int actual = planetFitness.singleMembers.size();
		assertNotNull(Club.multiMembers);
		assertEquals(expected,actual);
	}
	
	@Test
	void testNoSingleAddedWhenMultiMemberAdded() {
		Club planetFitness = new Club();
		MultipleClubMember multi = new MultipleClubMember();
		Club.addMember(multi);
		
		int expected = 0;
		int actual = planetFitness.singleMembers.size();
		assertEquals(expected,actual);
	}
	

}
