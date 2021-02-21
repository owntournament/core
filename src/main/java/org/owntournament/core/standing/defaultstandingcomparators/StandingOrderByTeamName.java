package org.owntournament.core.standing.defaultstandingcomparators;

import org.owntournament.core.interfaces.IStandingOrderComparator;
import org.owntournament.core.interfaces.models.IBasePoulestandingDTO;
import org.springframework.stereotype.Component;

/**
 * Sorts {@link IBasePoulestandingDTO IbasePoulestandingDTO} by teamname.
 * <p>
 * Note: this comparator imposes orderings that are inconsistent with equals.
 *
 * @author Marc Hoeve
 * @since 1.0
 */
@SuppressWarnings("unused")
@Component
public class StandingOrderByTeamName extends AbstractStandingOrderBase implements IStandingOrderComparator {
	public StandingOrderByTeamName() {
		this.setOrder(0);
		this.continueSortingWhenNotEqual(true);
	}
	
	@Override
	public int compare(IBasePoulestandingDTO o1, IBasePoulestandingDTO o2) {
		checkExistenceOfBasePoulestanding(o1, o2);
		if (o1.getTeam() == null || o2.getTeam() == null ||
				o1.getTeam().getName() == null || o2.getTeam().getName() == null) {
			throw new NullPointerException();
		}
		return o1.getTeam().getName().compareTo(o2.getTeam().getName());
	}
}
