package org.owntournament.core.standing.defaultstandingcomparators;

import org.owntournament.core.interfaces.models.IBasePoulestandingDTO;
import org.springframework.stereotype.Component;

/**
 * Sorts {@link IBasePoulestandingDTO IbasePoulestandingDTO} by the points a team has gathered.
 * <p>
 * Note: this comparator imposes orderings that are inconsistent with equals.
 *
 * @author Marc Hoeve
 * @since 1.0
 */
@SuppressWarnings("unused")
@Component
public class StandingOrderByPoints extends AbstractStandingOrderByIntBase {
	public StandingOrderByPoints() {
		this.sortingOrder = SortingOrder.HIGHEST_FIRST;
		this.sortOnValue = IBasePoulestandingDTO::getPoints;
		this.setOrder(1);
	}
}
