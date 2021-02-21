package org.owntournament.core.standing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.owntournament.core.interfaces.IStandingOrderComparator;
import org.owntournament.core.interfaces.models.IBasePoulestandingDTO;
import org.owntournament.core.interfaces.models.IBaseTeamDTO;
import org.owntournament.core.standing.defaultstandingcomparators.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ContextConfiguration
class StandingComparatorTest {
	
	@Autowired
	StandingComparator comparator;
	
	@Test
	void test_Sorting_1() {
		IBasePoulestandingDTO team1 = basePoulestandingDTO("X", 4, 2, 1, 1);
		IBasePoulestandingDTO team2 = basePoulestandingDTO("D", 4, 2, 1, 1);
		IBasePoulestandingDTO team3 = basePoulestandingDTO("B", 4, 2, 1, 1);
		IBasePoulestandingDTO team4 = basePoulestandingDTO("Z", 4, 2, 1, 1);
		
		List<IBasePoulestandingDTO> list = Arrays.asList(team1, team2, team3, team4);
		
		list.sort(comparator);
		
		assertEquals(team3, list.get(0));
		assertEquals(team2, list.get(1));
		assertEquals(team1, list.get(2));
		assertEquals(team4, list.get(3));
	}
	
	private IBasePoulestandingDTO basePoulestandingDTO(String teamname, int points, int played, int won, int lost) {
		IBaseTeamDTO mockedTeam = mock(IBaseTeamDTO.class);
		IBasePoulestandingDTO mockedPoulestanding = mock(IBasePoulestandingDTO.class);

		when(mockedPoulestanding.getTeam()).thenReturn(mockedTeam);
		when(mockedTeam.getName()).thenReturn(teamname);
		
		when(mockedPoulestanding.getPoints()).thenReturn(points);
		when(mockedPoulestanding.getGamesPlayed()).thenReturn(played);
		when(mockedPoulestanding.getGamesWon()).thenReturn(won);
		when(mockedPoulestanding.getGamesLost()).thenReturn(lost);
		
		return mockedPoulestanding;
	}
	
	@Configuration
	@ComponentScan(basePackages = "org.owntournament.core.standing")
	static class ContextConfiguration {
	
	}
}
