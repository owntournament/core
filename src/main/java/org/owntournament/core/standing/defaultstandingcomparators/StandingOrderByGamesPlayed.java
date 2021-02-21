package org.owntournament.core.standing.defaultstandingcomparators;

import org.owntournament.core.interfaces.models.IBasePoulestandingDTO;
import org.springframework.stereotype.Component;

/**
 * Sorts {@link IBasePoulestandingDTO IbasePoulestandingDTO} by the games a team has played.
 * <p>
 * Note: this comparator imposes orderings that are inconsistent with equals.
 *
 * @author Marc Hoeve
 * @since 1.0
 */
@SuppressWarnings("unused")
@Component
public class StandingOrderByGamesPlayed extends AbstractStandingOrderByIntBase {
	public StandingOrderByGamesPlayed() {
		this.sortingOrder = SortingOrder.LOWEST_FIRST;
		this.sortOnValue = IBasePoulestandingDTO::getGamesPlayed;
		this.setOrder(2);
	}
}
