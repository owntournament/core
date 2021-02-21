package org.owntournament.core.interfaces;

import org.owntournament.core.interfaces.models.IBasePoulestandingDTO;

import java.util.function.ToIntFunction;

public interface IStandingOrderByIntComparator extends IStandingOrderComparator {
	void setSortingOrder(SortingOrder sortingOrder);
	
	SortingOrder getSortingOrder();
	
	ToIntFunction<? super IBasePoulestandingDTO> getSortOnValue();
	
	enum SortingOrder {
		HIGHEST_FIRST,
		LOWEST_FIRST,
	}
}
