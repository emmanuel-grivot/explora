package predicates;

import java.util.EnumSet;

public class VisibilitiesGroups<E extends Enum<E>> {

	private final EnumSet<E> groups;

	public static <E extends Enum<E>> VisibilitiesGroups<E> newVisibilitiesGroup(Class<E> enumType) {
		return new VisibilitiesGroups<E>(enumType);
	}

	private VisibilitiesGroups(Class<E> enumType) {
		this.groups = EnumSet.noneOf(enumType);
	}

	public void setGroup(E e) {
		this.groups.add(e);
	}

	public void unsetGroup(E e) {
		this.groups.remove(e);
	}

	public boolean containsGroup(E e) {
		return this.groups.contains(e);
	}

	public void unsetAll() {
		this.groups.clear();
	}

	public boolean isEmpty() {
		return this.groups.isEmpty();
	}

	public int size() {
		return this.groups.size();
	}

	@Override
	public String toString() {
		return "VisibilitiesGroup " + this.groups;
	}

}
