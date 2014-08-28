package predicates;

abstract class BooleanOperator<E extends Enum<E>> implements Predicate<E> {

	protected E value;

	BooleanOperator(E value) {
		this.value = value;
	}

	static <E extends Enum<E>> BooleanOperator<E> and(E value) {
		return new AndOperator<E>(value);
	}

	static class AndOperator<E extends Enum<E>> extends BooleanOperator<E> {
		AndOperator(E value) {
			super(value);
		}

		@Override
		public String toString() {
			return "and (" + this.value + ")";
		}

		@Override
		public boolean isVisible(boolean currentVisibility, VisibilitiesGroups<E> g1, VisibilitiesGroups<E> g2) {
			return currentVisibility && (g1.containsGroup(this.value) && g2.containsGroup(this.value));
		}

	}

	static class AndNotOperator<E extends Enum<E>> extends BooleanOperator<E> {
		AndNotOperator(E value) {
			super(value);
		}

		@Override
		public String toString() {
			return "andNot (" + this.value + ")";
		}

		@Override
		public boolean isVisible(boolean currentVisibility, VisibilitiesGroups<E> g1, VisibilitiesGroups<E> g2) {
			return currentVisibility && g1.containsGroup(this.value) && !g2.containsGroup(this.value);
		}
	}

	static class OrOperator<E extends Enum<E>> extends BooleanOperator<E> {
		OrOperator(E value) {
			super(value);
		}

		@Override
		public String toString() {
			return "or (" + this.value + ")";
		}

		@Override
		public boolean isVisible(boolean currentVisibility, VisibilitiesGroups<E> g1, VisibilitiesGroups<E> g2) {
			return currentVisibility || (g1.containsGroup(this.value) && g2.containsGroup(this.value));
		}

	}

	static class OrNotOperator<E extends Enum<E>> extends BooleanOperator<E> {
		OrNotOperator(E value) {
			super(value);
		}

		@Override
		public String toString() {
			return "orNot (" + this.value + ")";
		}

		@Override
		public boolean isVisible(boolean currentVisibility, VisibilitiesGroups<E> g1, VisibilitiesGroups<E> g2) {
			return currentVisibility || g1.containsGroup(this.value) && !g2.containsGroup(this.value);
		}
	}

	static class IsTrueOperator<E extends Enum<E>> extends BooleanOperator<E> {
		IsTrueOperator(E value) {
			super(value);
		}

		@Override
		public String toString() {
			return "isTrue (" + this.value + ")";
		}

		@Override
		public boolean isVisible(boolean currentVisibility, VisibilitiesGroups<E> g1, VisibilitiesGroups<E> g2) {
			return g1.containsGroup(this.value) && g2.containsGroup(this.value);
		}
	}

	static class IsFalseOperator<E extends Enum<E>> extends BooleanOperator<E> {
		IsFalseOperator(E value) {
			super(value);
		}

		@Override
		public String toString() {
			return "isFalse (" + this.value + ")";
		}

		@Override
		public boolean isVisible(boolean currentVisibility, VisibilitiesGroups<E> g1, VisibilitiesGroups<E> g2) {
			return g1.containsGroup(this.value) && !g2.containsGroup(this.value);
		}
	}

}
