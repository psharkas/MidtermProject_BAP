import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
//import java.util.Collections;

import org.junit.jupiter.api.Test;

class ClubTest {

	// test that a single club member's club is the one they're assigned
	@Test
	void testSingleClub() {
		Club planetFitness = new Club();
		SingleClubMember newMember = new SingleClubMember("Peter", 123, planetFitness);

		assertEquals(planetFitness, newMember.getClub());
	}

	// checks to see that the checkMoreThanOneName method is able to see that there
	// is more than one name
	@Test
	void testSameMemberName() {
		ArrayList<Club> clubs = new ArrayList<>();
		Club jeezlouise = new Club("Jeez Louise", "123 Joe Mama's Street");
		clubs.add(jeezlouise);

		ArrayList<Member> memberList = new ArrayList<>();
		SingleClubMember newMember1 = new SingleClubMember("Joe", 124, jeezlouise);
		SingleClubMember newMember2 = new SingleClubMember("Joe", 125, jeezlouise);
		memberList.add(newMember1);
		memberList.add(newMember2);

		boolean actual = FitnessApp.checkMoreThanOneName(memberList, "Joe");
		boolean expected = true;

		assertEquals(actual, expected);

	}

	// checks to see that multi club member check in adds points when checking in
	@Test
	void testMemberPointsSingleClub() {
		Club jeezlouise = new Club("Jeez Louise", "123 Joe Mama's Street");
		MultipleClubMember newMember1 = new MultipleClubMember("Peter", 123);

		for (int i = 0; i < 5; i++) {
			newMember1.checkIn(jeezlouise);
		}
		int expected = 250;
		int actual = newMember1.getMemPoints();

		assertEquals(actual, expected);

	}

	// checks to see that multi club member check in adds points when checking in to
	// multiple clubs
	@Test
	void testMemberPointsMultipleClubs() {
		Club jeezlouise = new Club("Jeez Louise", "123 Joe Mama's Street");
		Club catherineObvious = new Club("Catherine Obvious", "123 Joe Daddy's Street");

		MultipleClubMember newMember1 = new MultipleClubMember("Peter", 123);
		newMember1.checkIn(jeezlouise);
		newMember1.checkIn(catherineObvious);

		int expected = 100;
		int actual = newMember1.getMemPoints();

		assertEquals(actual, expected);

	}

	// checks to see that the find member by id method works
	@Test
	void testMemberIdFinder() {
		Club jeezlouise = new Club("Jeez Louise", "123 Joe Mama's Street");
		ArrayList<Member> memberIds = new ArrayList<>();
		MultipleClubMember newMember1 = new MultipleClubMember("Peter", 123);
		SingleClubMember newMember2 = new SingleClubMember("Joe", 124, jeezlouise);
		SingleClubMember newMember3 = new SingleClubMember("Naruto", 125, jeezlouise);

		memberIds.add(newMember1);
		memberIds.add(newMember2);
		memberIds.add(newMember3);

		String actual = memberIds.get(FitnessApp.findMemberById(memberIds, 124)).getName();
		String expected = "Joe";

		assertEquals(actual, expected);

	}

	// checks to see that the find member by name method works
	@Test
	void testMemberIdFinderByName() {
		Club jeezlouise = new Club("Jeez Louise", "123 Joe Mama's Street");
		ArrayList<Member> memberIds = new ArrayList<>();
		MultipleClubMember newMember1 = new MultipleClubMember("Peter", 123);
		SingleClubMember newMember2 = new SingleClubMember("Joe", 124, jeezlouise);
		SingleClubMember newMember3 = new SingleClubMember("Naruto", 125, jeezlouise);

		memberIds.add(newMember1);
		memberIds.add(newMember2);
		memberIds.add(newMember3);

		int actual = memberIds.get(FitnessApp.findMemberByName(memberIds, "Naruto")).getId();
		int expected = 125;

		assertEquals(actual, expected);

	}

}
