package org.owntournament.core.standing.defaultstandingcomparators;

import org.owntournament.core.interfaces.IStandingOrderComparator;
import org.owntournament.core.interfaces.models.IBasePoulestandingDTO;

public abstract class AbstractStandingOrderBase implements IStandingOrderComparator {
	private boolean isActive = true;
	private boolean continueSortingWhenNotEqual = false;
	private int order = 0;
	
	@Override
	public void isActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public boolean isActive() {
		return this.isActive;
	}
	
	@Override
	public void setOrder(int order) {
		this.order = order;
	}
	
	@Override
	public int order() {
		return this.order;
	}
	
	@Override
	public void continueSortingWhenNotEqual(boolean continueSortingWhenEqual) {
		this.continueSortingWhenNotEqual = continueSortingWhenEqual;
	}
	
	@Override
	public boolean continueSortingWhenNotEqual() {
		return this.continueSortingWhenNotEqual;
	}
	
	protected static void checkExistenceOfBasePoulestanding(IBasePoulestandingDTO o1, IBasePoulestandingDTO o2) {
		if (o1 == null || o2 == null) {
			throw new NullPointerException();
		}
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "{" +
				"isActive=" + isActive +
				", continueSortingWhenNotEqual=" + continueSortingWhenNotEqual +
				", order=" + order +
				'}';
	}
}
