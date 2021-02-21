package org.owntournament.core.interfaces;

import org.owntournament.core.interfaces.models.IBasePoulestandingDTO;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.util.Comparator;

public interface IStandingOrderComparator extends Comparator<IBasePoulestandingDTO>, Serializable {
	/**
	 * Set or unset the comparator as active
	 * @param isActive set to true if the comparator is active
	 */
	void isActive(boolean isActive);
	
	/**
	 * Returns true if this comparator is active
	 *
	 * @return true if active
	 */
	boolean isActive();
	
	/**
	 * Specifies the place within the order chain
	 * @param order the place within the chain
	 */
	void setOrder(int order);
	
	/**
	 * Returns de order of this comparator within the chain
	 *
	 * @return zero-based int value of order within the chain
	 */
	int order();
	
	/**
	 * Specifies if the chain must continue when the values are equal
	 *
	 * @param continueSortingWhenEqual true when the chain must continue
	 */
	void continueSortingWhenNotEqual(boolean continueSortingWhenEqual);
	
	/**
	 * Returns true if sorting has to continue when values are equal
	 *
	 * @return true when sorting has to continue
	 */
	boolean continueSortingWhenNotEqual();
}
