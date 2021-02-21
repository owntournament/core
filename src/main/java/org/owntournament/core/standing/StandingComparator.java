package org.owntournament.core.standing;

import lombok.extern.slf4j.Slf4j;
import org.owntournament.core.interfaces.IStandingOrderComparator;
import org.owntournament.core.interfaces.models.IBasePoulestandingDTO;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StandingComparator implements Comparator<IBasePoulestandingDTO>, Serializable {
	private final List<IStandingOrderComparator> comparators;
	
	public List<IStandingOrderComparator> getComparators() {
		return this.comparators;
	}
	
	public StandingComparator(List<IStandingOrderComparator> comparators) {
		comparators.stream()
				.sorted(Comparator.comparingInt(IStandingOrderComparator::order))
				.forEach(comparator -> log.info("Registring StandingComparator: {}", comparator.toString()));
		this.comparators = comparators;
	}
	
	@SuppressWarnings("java:S4838")
	@Override
	public int compare(IBasePoulestandingDTO o1, IBasePoulestandingDTO o2) {
		List<IStandingOrderComparator> useComparators = comparators.stream()
				.filter(IStandingOrderComparator::isActive)
				.sorted(Comparator.comparingInt(IStandingOrderComparator::order))
				.collect(Collectors.toList());
		
		int lastNonZeroResult = 0;
		
		for (Comparator<IBasePoulestandingDTO> comparator : useComparators) {
			int result = comparator.compare(o1, o2);
			if (result != 0) {
				if (!((IStandingOrderComparator) comparator).continueSortingWhenNotEqual()) {
					return result;
				}
				lastNonZeroResult = result;
			}
		}
		return lastNonZeroResult;
	}
}
