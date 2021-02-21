package org.owntournament.core.standing.defaultstandingcomparators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.owntournament.core.interfaces.IStandingOrderByIntComparator;
import org.owntournament.core.interfaces.models.IBasePoulestandingDTO;
import org.owntournament.core.interfaces.models.IBaseTeamDTO;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class StandingOrderByTeamNameTest {
	
	StandingOrderByTeamName comparator = new StandingOrderByTeamName();
	
	@Mock
	IBasePoulestandingDTO psTeam1, psTeam2, psTeam3, psTeam4;
	
	@Mock
	IBaseTeamDTO team1, team2, team3, team4;
	
	@BeforeEach
	void setUp() {
		when(psTeam1.getTeam()).thenReturn(team1);
		when(psTeam2.getTeam()).thenReturn(team2);
		when(psTeam3.getTeam()).thenReturn(team3);
		when(psTeam4.getTeam()).thenReturn(team4);
	}
	
	@Test
	void test_NPE() {
		assertThrows(NullPointerException.class, () -> comparator.compare(null, null));
	}
	
	@Test
	void test_defaultSettings() {
		assertEquals(0, comparator.order());
	}
	
	@Test
	void test_NPE_whenNoTeamPresent() {
		when(psTeam1.getTeam()).thenReturn(null);
		assertThrows(NullPointerException.class, () -> comparator.compare(psTeam1, psTeam2));
	}
	
	@Test
	void test_AlphabeticOrder() {
		when(team1.getName()).thenReturn("D");
		when(team2.getName()).thenReturn("A");
		assertTrue(comparator.compare(psTeam1, psTeam2) > 0);
	}
	
	@Test
	void test_SortList_expectResultInRightOrder() {
		// given
		when(team1.getName()).thenReturn("D");
		when(team2.getName()).thenReturn("A");
		when(team3.getName()).thenReturn("Z");
		when(team4.getName()).thenReturn("C");
		List<IBasePoulestandingDTO> list = Arrays.asList(psTeam1, psTeam2, psTeam3, psTeam4);

		// when
		list.sort(comparator);
		
		// then
		assertEquals(psTeam2, list.get(0));
		assertEquals(psTeam4, list.get(1));
		assertEquals(psTeam1, list.get(2));
		assertEquals(psTeam3, list.get(3));
	}
	
}
