import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MultipleClubMemberTest {

	@Test
	void testcheckIn() {
		MultipleClubMember m = new MultipleClubMember();
		int expected = 0;
		int actual = m.checkIn();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testwelcomeBonus() {
		MultipleClubMember m = new MultipleClubMember();
		int expected = 0;
		int actual = 3000;
		assertEquals(expected, actual);
	}

}
