package org.owntournament.core.standing.defaultstandingcomparators;

import org.owntournament.core.interfaces.models.IBasePoulestandingDTO;
import org.springframework.stereotype.Component;

/**
 * Sorts {@link IBasePoulestandingDTO IbasePoulestandingDTO} by the games a team has lost.
 * <p>
 * Note: this comparator imposes orderings that are inconsistent with equals.
 *
 * @author Marc Hoeve
 * @since 1.0
 */
@SuppressWarnings("unused")
@Component
public class StandingOrderByGamesLost extends AbstractStandingOrderByIntBase {
	public StandingOrderByGamesLost() {
		this.sortingOrder = SortingOrder.LOWEST_FIRST;
		this.sortOnValue=IBasePoulestandingDTO::getGamesLost;
		this.setOrder(4);
	}
}
