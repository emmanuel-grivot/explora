package predicates;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class PredicatesTests {

	private final VisibilitiesGroups<TracksGroups>[] tracksVisibilities = new VisibilitiesGroups[18];

	private final VisibilitiesPredicates<TracksGroups> tracksVisibilitiesPrediates =
			VisibilitiesPredicates.newVisibilitiesPredicates(TracksGroups.class);

	private final boolean[] computedVisibilities = new boolean[this.tracksVisibilities.length];
	private final boolean[] expectedVisibilities = new boolean[] {
			true, false, false, false, false, false,
			false, false, false, true, false, false,
			false, false, false, false, true, false,
	};

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		int i = 0;
		for (VisibilitiesGroups<TracksGroups> trackVisibilities : this.tracksVisibilities) {
			this.tracksVisibilities[i++] = VisibilitiesGroups.newVisibilitiesGroup(TracksGroups.class);
		}

		i = 0;
		for (VisibilitiesGroups<TracksGroups> trackVisibilities : this.tracksVisibilities) {
			trackVisibilities.unsetAll();

			switch (i++) {
			case 0:
				trackVisibilities.setGroup(TracksGroups.airtracks);
				trackVisibilities.setGroup(TracksGroups.friendTrack);
				trackVisibilities.setGroup(TracksGroups.localTrack);
				break;

			case 1:
				trackVisibilities.setGroup(TracksGroups.airtracks);
				trackVisibilities.setGroup(TracksGroups.friendTrack);
				trackVisibilities.setGroup(TracksGroups.externalTrack);
				break;

			case 2:
				trackVisibilities.setGroup(TracksGroups.surfaceTrack);
				trackVisibilities.setGroup(TracksGroups.friendTrack);
				trackVisibilities.setGroup(TracksGroups.localTrack);
				break;

			case 3:
				trackVisibilities.setGroup(TracksGroups.surfaceTrack);
				trackVisibilities.setGroup(TracksGroups.friendTrack);
				trackVisibilities.setGroup(TracksGroups.externalTrack);
				break;

			case 4:
				trackVisibilities.setGroup(TracksGroups.submarineTrack);
				trackVisibilities.setGroup(TracksGroups.friendTrack);
				trackVisibilities.setGroup(TracksGroups.localTrack);
				break;

			case 5:
				trackVisibilities.setGroup(TracksGroups.submarineTrack);
				trackVisibilities.setGroup(TracksGroups.friendTrack);
				trackVisibilities.setGroup(TracksGroups.externalTrack);
				break;

			case 6:
				trackVisibilities.setGroup(TracksGroups.airtracks);
				trackVisibilities.setGroup(TracksGroups.neutralTrack);
				trackVisibilities.setGroup(TracksGroups.localTrack);
				break;

			case 7:
				trackVisibilities.setGroup(TracksGroups.airtracks);
				trackVisibilities.setGroup(TracksGroups.neutralTrack);
				trackVisibilities.setGroup(TracksGroups.externalTrack);
				break;

			case 8:
				trackVisibilities.setGroup(TracksGroups.surfaceTrack);
				trackVisibilities.setGroup(TracksGroups.neutralTrack);
				trackVisibilities.setGroup(TracksGroups.localTrack);
				break;

			case 9:
				trackVisibilities.setGroup(TracksGroups.surfaceTrack);
				trackVisibilities.setGroup(TracksGroups.neutralTrack);
				trackVisibilities.setGroup(TracksGroups.externalTrack);
				break;

			case 10:
				trackVisibilities.setGroup(TracksGroups.submarineTrack);
				trackVisibilities.setGroup(TracksGroups.neutralTrack);
				trackVisibilities.setGroup(TracksGroups.localTrack);
				break;

			case 11:
				trackVisibilities.setGroup(TracksGroups.submarineTrack);
				trackVisibilities.setGroup(TracksGroups.neutralTrack);
				trackVisibilities.setGroup(TracksGroups.externalTrack);
				break;

			case 12:
				trackVisibilities.setGroup(TracksGroups.airtracks);
				trackVisibilities.setGroup(TracksGroups.hostileTrack);
				trackVisibilities.setGroup(TracksGroups.localTrack);
				break;

			case 13:
				trackVisibilities.setGroup(TracksGroups.airtracks);
				trackVisibilities.setGroup(TracksGroups.hostileTrack);
				trackVisibilities.setGroup(TracksGroups.externalTrack);
				break;

			case 14:
				trackVisibilities.setGroup(TracksGroups.surfaceTrack);
				trackVisibilities.setGroup(TracksGroups.hostileTrack);
				trackVisibilities.setGroup(TracksGroups.localTrack);
				break;

			case 15:
				trackVisibilities.setGroup(TracksGroups.surfaceTrack);
				trackVisibilities.setGroup(TracksGroups.hostileTrack);
				trackVisibilities.setGroup(TracksGroups.externalTrack);
				break;

			case 16:
				trackVisibilities.setGroup(TracksGroups.submarineTrack);
				trackVisibilities.setGroup(TracksGroups.hostileTrack);
				trackVisibilities.setGroup(TracksGroups.localTrack);
				break;

			case 17:
				trackVisibilities.setGroup(TracksGroups.submarineTrack);
				trackVisibilities.setGroup(TracksGroups.hostileTrack);
				trackVisibilities.setGroup(TracksGroups.externalTrack);
				break;

			}
			Assert.assertEquals(3, trackVisibilities.size());
		}

		Assert.assertEquals(this.computedVisibilities.length, this.expectedVisibilities.length);

		this.setLayerVisibility();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void test1() {

		// Predicates<TracksGroups> predicates = this.tracksVisibilitiesPrediates.predicates(TracksGroups.airtracks);
		Predicates<TracksGroups> predicates = this.tracksVisibilitiesPrediates.newPredicates();

		// predicates
		// .newPredicates().isTrue(TracksGroups.airtracks).and(TracksGroups.friendTrack).and(TracksGroups.localTrack)
		// .newPredicates().isTrue(TracksGroups.surfaceTrack).and(TracksGroups.friendTrack).and(TracksGroups.localTrack);

		// predicates
		// .isTrue(TracksGroups.airtracks).and(TracksGroups.friendTrack).and(TracksGroups.externalTrack);
		//
		// predicates
		// .isTrue(TracksGroups.surfaceTrack).and(TracksGroups.friendTrack).and(TracksGroups.localTrack);
		//
		// predicates
		// .isTrue(TracksGroups.surfaceTrack).and(TracksGroups.friendTrack).and(TracksGroups.externalTrack);

		predicates
				.isTrue(TracksGroups.airtracks)
				.and(TracksGroups.hostileTrack)
				.or(TracksGroups.neutralTrack)
				.andNot(TracksGroups.localTrack);

		// Print is visible
		this.computeVisibilities();
		// predicates.and(TracksGroups.localTrack);

	}

	@Test
	@Ignore
	public void test2() {

		// Predicates<TracksGroups> predicates = this.tracksVisibilitiesPrediates.predicates(TracksGroups.airtracks);
		// Predicates<TracksGroups> predicates = this.tracksVisibilitiesPrediates.<TracksGroups> newPredicates(
		// BooleanOperator.and(TracksGroups.airtracks),
		// BooleanOperator.and(TracksGroups.airtracks)
		// );
		//
		// predicates
		// .isFalse(TracksGroups.airtracks)
		// .and(TracksGroups.hostileTrack)
		// .or(TracksGroups.neutralTrack)
		// .andNot(TracksGroups.localTrack);

		// Print is visible
		this.computeVisibilities();
		// predicates.and(TracksGroups.localTrack);

	}

	@Test
	public void testUserPredicate() {

		Predicates<TracksGroups> predicates = this.tracksVisibilitiesPrediates.newPredicates();

		predicates.addPredicate(new Predicate<TracksGroups>() {

			@Override
			public String toString() {
				return "Predicate<TracksGroups>";
			}

			@Override
			public boolean isVisible(boolean currentVisibility, VisibilitiesGroups<TracksGroups> g1, VisibilitiesGroups<TracksGroups> g2) {

				boolean visible = false;

				if ((g1.containsGroup(TracksGroups.airtracks) && g2.containsGroup(TracksGroups.airtracks)) &&
						(g1.containsGroup(TracksGroups.friendTrack) && g2.containsGroup(TracksGroups.friendTrack)) &&
						(g1.containsGroup(TracksGroups.localTrack) && g2.containsGroup(TracksGroups.localTrack))) {
					visible = true;
				}

				if ((g1.containsGroup(TracksGroups.airtracks) && g2.containsGroup(TracksGroups.airtracks)) &&
						(g1.containsGroup(TracksGroups.friendTrack) && g2.containsGroup(TracksGroups.friendTrack)) &&
						(g1.containsGroup(TracksGroups.externalTrack) && g2.containsGroup(TracksGroups.externalTrack))) {
					visible = true;
				}

				if ((g1.containsGroup(TracksGroups.surfaceTrack) && g2.containsGroup(TracksGroups.surfaceTrack)) &&
						(g1.containsGroup(TracksGroups.friendTrack) && g2.containsGroup(TracksGroups.friendTrack)) &&
						(g1.containsGroup(TracksGroups.localTrack) && g2.containsGroup(TracksGroups.localTrack))) {
					visible = true;
				}

				return visible;
			}

		});

		this.computeVisibilities();
	}

	@Test
	@Ignore
	public void testPerf() {

		// Test is visible
		boolean visible = false;
		long loop = 100000000;
		long start = System.nanoTime();
		for (int i = 0; i < loop; i++) {
			// visible = this.tracksVisibilitiesPrediates.isVisible(this.tracksVisibilities);
		}

		long stop = System.nanoTime();
		System.out.println(visible + " durée = " + (stop - start) / loop);

	}

	private void setLayerVisibility() {
		// Layer
		this.tracksVisibilitiesPrediates.setGroup(TracksGroups.airtracks);
		this.tracksVisibilitiesPrediates.setGroup(TracksGroups.friendTrack);
		this.tracksVisibilitiesPrediates.setGroup(TracksGroups.surfaceTrack);
		this.tracksVisibilitiesPrediates.setGroup(TracksGroups.neutralTrack);
		this.tracksVisibilitiesPrediates.setGroup(TracksGroups.localTrack);
		this.tracksVisibilitiesPrediates.setGroup(TracksGroups.externalTrack);
		// System.out.println("size = " + this.tracksVisibilitiesPrediates.size());
	}

	private void computeVisibilities() {
		// Print is visible
		int i = 0;
		for (VisibilitiesGroups<TracksGroups> trackVisibilities : this.tracksVisibilities) {
			this.computedVisibilities[i] = this.tracksVisibilitiesPrediates.isVisible(trackVisibilities);
			System.out.println("track [" + i + "] => visible = " + this.computedVisibilities[i] + ", expected = " + this.expectedVisibilities[i] +
					(this.computedVisibilities[i] == this.expectedVisibilities[i] ? " OK " : " KO"));
			System.out.println();
			i++;
		}
	}

	private void checkVisibilities() {

	}

}
