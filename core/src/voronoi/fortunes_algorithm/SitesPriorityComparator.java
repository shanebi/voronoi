package voronoi.fortunes_algorithm;

import java.util.Comparator;

/**
 * Comparator for the Site class.
 */
public class SitesPriorityComparator implements Comparator<Site> {

	@Override
	public int compare(Site site1, Site site2) {
		int[] site1_location = site1.location();
		int[] site2_location = site2.location();
		
		int x_compare = Integer.compare(site1_location[0], site2_location[0]);
		int y_compare = Integer.compare(site1_location[1], site2_location[1]);
		
		// site1 is < site 2 if site1.y < site2.y OR (site1.y == site2.y AND site1.x < site2.x)
		if(y_compare == 0) {
			return x_compare;
		} else {
			return y_compare;
		}
	}
}
