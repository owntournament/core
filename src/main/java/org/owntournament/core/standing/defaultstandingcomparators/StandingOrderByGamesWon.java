package org.owntournament.core.standing.defaultstandingcomparators;

import org.owntournament.core.interfaces.models.IBasePoulestandingDTO;
import org.springframework.stereotype.Component;

/**
 * Sorts {@link IBasePoulestandingDTO IbasePoulestandingDTO} by the games a team has won.
 * <p>
 * Note: this comparator imposes orderings that are inconsistent with equals.
 *
 * @author Marc Hoeve
 * @since 1.0
 */
@SuppressWarnings("unused")
@Component
public class StandingOrderByGamesWon extends AbstractStandingOrderByIntBase {
	public StandingOrderByGamesWon() {
		this.sortingOrder = SortingOrder.HIGHEST_FIRST;
		this.sortOnValue=IBasePoulestandingDTO::getGamesWon;
		this.setOrder(3);
	}
}
