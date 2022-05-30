import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClubTest {
	
	// test that a single club member's club is the one they're assigned
	@Test
	void testSingleClub() {
		Club planetFitness = new Club();
		SingleClubMember newMember = new SingleClubMember("Peter",123,planetFitness);
		
		assertEquals(planetFitness,newMember.getClub());
	}
	
	// checks to see if name is settable
	@Test
	void testClubName() {
		Club planetFitness = new Club();
		planetFitness.setName("BAP Fitness Detroit");
		planetFitness.setAddress("32 Woodward Ave");
		
		assertNotNull(planetFitness.getName());
		
		

	}
	

}
