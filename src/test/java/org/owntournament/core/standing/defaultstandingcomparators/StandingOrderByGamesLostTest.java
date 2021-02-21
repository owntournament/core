package org.owntournament.core.standing.defaultstandingcomparators;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.owntournament.core.interfaces.IStandingOrderByIntComparator;
import org.owntournament.core.interfaces.models.IBasePoulestandingDTO;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StandingOrderByGamesLostTest {
	
	StandingOrderByGamesLost comparator = new StandingOrderByGamesLost();
	
	@Mock
	IBasePoulestandingDTO team1, team2, team3, team4;
	
	@Test
	void test_NPE() {
		assertThrows(NullPointerException.class, () -> comparator.compare(null, null));
	}
	
	@Test
	void test_defaultSettings() {
		assertEquals(IStandingOrderByIntComparator.SortingOrder.LOWEST_FIRST, comparator.getSortingOrder());
		assertEquals(4, comparator.order());
	}
	
	@Test
	void test_HighestFirst() {
		comparator.setSortingOrder(IStandingOrderByIntComparator.SortingOrder.LOWEST_FIRST);
		when(team1.getGamesLost()).thenReturn(5);
		when(team2.getGamesLost()).thenReturn(6);
		assertEquals(-1, comparator.compare(team1, team2));
	}
	
	@Test
	void test_LowestFirst() {
		comparator.setSortingOrder(IStandingOrderByIntComparator.SortingOrder.HIGHEST_FIRST);
		when(team1.getGamesLost()).thenReturn(5);
		when(team2.getGamesLost()).thenReturn(6);
		assertEquals(1, comparator.compare(team1, team2));
	}
	
	@Test
	void test_SortList_expectResultInRightOrder() {
		// given
		comparator.setSortingOrder(IStandingOrderByIntComparator.SortingOrder.LOWEST_FIRST);
		when(team1.getGamesLost()).thenReturn(4);
		when(team2.getGamesLost()).thenReturn(6);
		when(team3.getGamesLost()).thenReturn(5);
		when(team4.getGamesLost()).thenReturn(3);
		List<IBasePoulestandingDTO> list = Arrays.asList(team1, team2, team3, team4);

		// when
		list.sort(comparator);
		
		// then
		assertEquals(team4, list.get(0));
		assertEquals(team1, list.get(1));
		assertEquals(team3, list.get(2));
		assertEquals(team2, list.get(3));
	}
	
}
