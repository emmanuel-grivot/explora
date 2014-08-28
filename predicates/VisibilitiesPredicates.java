package predicates;

//
// stackoverflow.com/questions/13496172/converting-conditions-with-parentheses-to-equivalents-with-no-parentheses
// programmers.stackexchange.com/questions/201175/should-i-use-parentheses-in-logical-statements-even-where-not-necessary
//
public class VisibilitiesPredicates<E extends Enum<E>> {

	private final VisibilitiesGroups<E> visibilitiesGroups;
	private Predicates<E> predicates;
	private final E[] groupsValues;
	private final Class<E> enumType;

	public Predicates<E> newPredicates() {
		if (this.predicates != null) throw new IllegalStateException("Predicates already defined.");
		this.predicates = new Predicates<E>(this.enumType);
		return this.predicates;
	}

	public Predicates<E> newPredicates(Predicate<E>... predicates) {
		if (this.predicates != null) throw new IllegalStateException("Predicates already defined.");
		this.predicates = new Predicates<E>(this.enumType);
		for (Predicate<E> predicate : predicates) {

		}
		return this.predicates;
	}

	public static <E extends Enum<E>> VisibilitiesPredicates<E> newVisibilitiesPredicates(Class<E> elementType) {
		return new VisibilitiesPredicates<E>(elementType);
	}

	private VisibilitiesPredicates(Class<E> enumType) {
		this.enumType = enumType;
		this.visibilitiesGroups = VisibilitiesGroups.newVisibilitiesGroup(this.enumType);
		this.groupsValues = this.enumType.getEnumConstants();
	}

	public void setGroup(E e) {
		this.visibilitiesGroups.setGroup(e);
	}

	public void unsetGroup(E e) {
		this.visibilitiesGroups.unsetGroup(e);
	}

	public boolean containsGroup(E e) {
		return this.visibilitiesGroups.containsGroup(e);
	}

	public void clear() {
		this.visibilitiesGroups.unsetAll();
	}

	public boolean isEmpty() {
		return this.visibilitiesGroups.isEmpty();
	}

	public int size() {
		return this.visibilitiesGroups.size();
	}

	public boolean isVisible(VisibilitiesGroups<E> aVisibilitiesGroup) {

		this.printVisibilityGroup(aVisibilitiesGroup);

		boolean res = false;
		Predicate<E>[] predicates = this.getPredicates().getPredicates();

		if (predicates.length == 0) {
			for (E value : this.groupsValues) {
				res = res || (this.visibilitiesGroups.containsGroup(value) && aVisibilitiesGroup.containsGroup(value));
			}
		}
		else {
			res = this.getPredicates().isVisible(res, this.visibilitiesGroups, aVisibilitiesGroup);
		}
		return res;
	}

	private void printVisibilityGroup(VisibilitiesGroups<E> g2) {
		System.out.print("this = [");
		for (E value : this.groupsValues) {
			System.out.printf("%s, ", this.visibilitiesGroups.containsGroup(value) ? value : this.printSpace(value));
		}
		System.out.println("]");

		System.out.print("data = [");
		for (E value : this.groupsValues) {
			System.out.printf("%s, ", g2.containsGroup(value) ? value : this.printSpace(value));
		}
		System.out.println("]");
	}

	private String printSpace(E value) {
		String stringValue = value.toString();
		StringBuilder sb = new StringBuilder(stringValue.length());
		for (int i = 0; i < stringValue.length(); i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

	private Predicates<E> getPredicates() {
		if (this.predicates == null) {
			this.predicates = new Predicates<E>(this.enumType);
		}
		return this.predicates;
	}

}
