package predicates;

import predicates.BooleanOperator.AndNotOperator;
import predicates.BooleanOperator.AndOperator;
import predicates.BooleanOperator.IsFalseOperator;
import predicates.BooleanOperator.IsTrueOperator;
import predicates.BooleanOperator.OrNotOperator;
import predicates.BooleanOperator.OrOperator;

public class Predicates<E extends Enum<E>> extends CompositePredicates<E> {

	private static final String predicatesAlreadyUsed = "Predicates are sealed because already in use.";

	private final Class<E> enumType;

	Predicates(Class<E> enumType) {
		this.enumType = enumType;
	}

	public Predicates<E> and(E value) {
		super.addPredicate(new AndOperator<E>(value));
		return this;
	}

	public Predicates<E> andNot(E value) {
		this.addPredicate(new AndNotOperator<E>(value));
		return this;
	}

	public Predicates<E> or(E value) {
		this.addPredicate(new OrOperator<E>(value));
		return this;
	}

	public Predicates<E> orNot(E value) {
		this.addPredicate(new OrNotOperator<E>(value));
		return this;
	}

	public Predicates<E> isTrue(E value) {
		this.addPredicate(new IsTrueOperator<E>(value));
		return this;
	}

	public Predicates<E> isFalse(E value) {
		this.addPredicate(new IsFalseOperator<E>(value));
		return this;
	}

	public Predicates<E> newPredicates() {
		Predicates<E> aPredicate = new Predicates<E>(this.enumType);
		this.addPredicate(aPredicate);
		return aPredicate;
	}

}
