package predicates;

import java.util.ArrayList;
import java.util.List;

class CompositePredicates<E extends Enum<E>> implements Predicate<E> {

	private List<Predicate<E>> predicatesList = new ArrayList<>();
	private Predicate<E>[] predicates;

	@Override
	public boolean isVisible(boolean currentVisibility, VisibilitiesGroups<E> g1, VisibilitiesGroups<E> g2) {
		boolean visible = false;
		for (Predicate<E> predicate : this.getPredicates()) {
			visible = predicate.isVisible(visible, g1, g2);
		}
		return visible;
	}

	void addPredicate(Predicate<E> aPredicate) {
		if (aPredicate == null) throw new IllegalArgumentException();
		this.predicatesList.add(aPredicate);
	}

	Predicate<E>[] getPredicates() {
		if (this.predicates == null) {
			this.predicates = this.predicatesList.toArray(new Predicate[this.predicatesList.size()]);
			this.predicatesList = null;
		}
		return this.predicates;
	}
}
