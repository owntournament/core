package org.owntournament.core.standing.defaultstandingcomparators;

import org.owntournament.core.interfaces.IStandingOrderByIntComparator;
import org.owntournament.core.interfaces.models.IBasePoulestandingDTO;

import java.util.function.ToIntFunction;

/**
 * Sorts {@link IBasePoulestandingDTO IbasePoulestandingDTO} by the points a team has gathered.
 * <p>
 * Note: this comparator imposes orderings that are inconsistent with equals.
 *
 * @author Marc Hoeve
 * @since 1.0
 */
@SuppressWarnings("unused")
public abstract class AbstractStandingOrderByIntBase extends AbstractStandingOrderBase implements IStandingOrderByIntComparator {
	protected SortingOrder sortingOrder = SortingOrder.HIGHEST_FIRST;
	protected ToIntFunction<? super IBasePoulestandingDTO> sortOnValue;
	
	public void setSortingOrder(SortingOrder sortingOrder) {
		this.sortingOrder = sortingOrder;
	}
	
	public SortingOrder getSortingOrder() {
		return this.sortingOrder;
	}
	
	public ToIntFunction<? super IBasePoulestandingDTO> getSortOnValue() {
		return this.sortOnValue;
	}
	
	@Override
	public int compare(IBasePoulestandingDTO o1, IBasePoulestandingDTO o2) {
		checkExistenceOfBasePoulestanding(o1, o2);
		if (this.sortingOrder == SortingOrder.HIGHEST_FIRST) {
			return Integer.compare(sortOnValue.applyAsInt(o2), sortOnValue.applyAsInt(o1));
		}
		return Integer.compare(sortOnValue.applyAsInt(o1), sortOnValue.applyAsInt(o2));
	}
	
}
