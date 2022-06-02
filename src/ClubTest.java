import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class ClubTest {
	
	// test that a single club member's club is the one they're assigned
	@Test
	void testSingleClub() {
		Club planetFitness = new Club();
		SingleClubMember newMember = new SingleClubMember("Peter",123,planetFitness);
		
		assertEquals(planetFitness,newMember.getClub());
	}
	
	
	// checks to see that no generated ids are the same
	@Test
	void testGeneratedId() {
		ArrayList<Integer> ids = new ArrayList<>();
		ArrayList<Integer> nums = new ArrayList<>();
		boolean actual = false;
		boolean expected = true;
		
		for (int i = 0; i < 100; i++) {
			FitnessApp.generateId(ids);
		} 
		
		for (int i = 1; i <= 100; i++) {
			nums.add(i);
		}
		Collections.sort(ids);
		Collections.sort(nums);
		
		System.out.println(ids);
		System.out.println(nums);


		if (ids.equals(nums)) {
			actual = true;
		}
		
		assertEquals(actual,expected);
		
	}
	
	// checks to see that multi club member check in adds points when checking in
	@Test
	void testMemberPointsSingleClub() {
		Club jeezlouise = new Club("Jeez Louise", "123 Joe Mama's Street");		
		MultipleClubMember newMember1 = new MultipleClubMember("Peter",123);
		
		for (int i = 0; i < 5; i++) {
			newMember1.checkIn(jeezlouise);
		}
		int expected = 250;
		int actual = newMember1.getMemPoints();
		
		assertEquals(actual,expected);

	}
	
	// checks to see that multi club member check in adds points when checking in to multiple clubs
	@Test
	void testMemberPointsMultipleClubs() {
		Club jeezlouise = new Club("Jeez Louise", "123 Joe Mama's Street");	
		Club catherineObvious = new Club("Catherine Obvious", "123 Joe Daddy's Street");		

		MultipleClubMember newMember1 = new MultipleClubMember("Peter",123);
		newMember1.checkIn(jeezlouise);
		newMember1.checkIn(catherineObvious);

		int expected = 100;
		int actual = newMember1.getMemPoints();
		
		assertEquals(actual,expected);

	}
	
	// checks to see that the find member by id method works
	@Test
	void testMemberIdFinder() {
		Club jeezlouise = new Club("Jeez Louise", "123 Joe Mama's Street");		
		ArrayList<Member> memberIds = new ArrayList<>();
		MultipleClubMember newMember1 = new MultipleClubMember("Peter",123);
		SingleClubMember newMember2 = new SingleClubMember("Joe",124,jeezlouise);
		SingleClubMember newMember3 = new SingleClubMember("Naruto",125,jeezlouise);
		
		memberIds.add(newMember1);
		memberIds.add(newMember2);
		memberIds.add(newMember3);

		
		String actual = memberIds.get(FitnessApp.findMemberById(memberIds, 124)).getName();
		String expected = "Joe";

		assertEquals(actual,expected);

	}
	
	// checks to see that the find member by name method works
	@Test
	void testMemberIdFinderByName() {
		Club jeezlouise = new Club("Jeez Louise", "123 Joe Mama's Street");		
		ArrayList<Member> memberIds = new ArrayList<>();
		MultipleClubMember newMember1 = new MultipleClubMember("Peter",123);
		SingleClubMember newMember2 = new SingleClubMember("Joe",124,jeezlouise);
		SingleClubMember newMember3 = new SingleClubMember("Naruto",125,jeezlouise);
		
		memberIds.add(newMember1);
		memberIds.add(newMember2);
		memberIds.add(newMember3);
		
		int actual = memberIds.get(FitnessApp.findMemberByName(memberIds, "Naruto")).getId();
		int expected = 125;

		assertEquals(actual,expected);

	}
	
//	// checks to see that the select club method selects the right club
//	@Test
//	void testClubSelector() {
//		ArrayList<Club> clubs = new ArrayList<>();
//
//		Club bapFitnessNovi = new Club("BAP Fitness Novi", "42 Novi Rd");
//		Club bapFitnessNorthville = new Club("BAP Fitness Northville", "24 Griswold St");
//		Club bapFitnessWixom = new Club("BAP Fitness Wixom", "962 Alpha Dr");
//		Club bapFitnessWestBloomfield = new Club("BAP Fitness West Bloomfield","6475 Drake Rd");
//		
//		clubs.add(bapFitnessNovi);
//		clubs.add(bapFitnessNorthville);
//		clubs.add(bapFitnessWixom);
//		clubs.add(bapFitnessWestBloomfield);
//		
//		FitnessApp.s
//
//		
//		assertEquals(actual,expected);
//
//	}

}
	


