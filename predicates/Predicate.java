package predicates;

public interface Predicate<E extends Enum<E>> {
	boolean isVisible(boolean currentVisibility, VisibilitiesGroups<E> g1, VisibilitiesGroups<E> g2);
}
