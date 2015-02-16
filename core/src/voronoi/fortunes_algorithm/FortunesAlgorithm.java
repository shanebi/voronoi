package voronoi.fortunes_algorithm;

import java.util.PriorityQueue;

/**
 * This is an implementation of Fortune's Algoriothm[1]. A new instance can be created with a set of sites, or without for a set of sites to be generated within a given bounds.
 * Layers can then be gathered from the object; the sites and the polygons it generates for the sites.
 * 
 * [1]:  Steven Fortune. A sweepline algorithm for Voronoi diagrams. Proceedings of the second annual symposium on Computational geometry. Yorktown Heights, New York, United States, pp.313–322. 1986
 *
 */
public class FortunesAlgorithm {
	/**
	 * The sites that need to be considered.
	 */
	public PriorityQueue<Site> sites;
	
	/**
	 * This creates a new instance of the Fortune's algorithm wrapper, which will generate a set of Sites for itself within the given bounds
	 * 
	 * @param min_x the minimum Y coordinate
	 * @param min_y the minimum Y coordinate
	 * @param max_x the maximum X coordinate
	 * @param max_y the maximum Y coordinate
	 * @param number the number of sites to create
	 */
	public FortunesAlgorithm(int min_x, int min_y, int max_x, int max_y, int number) {
		// Set up the data stores
		this.sites = new PriorityQueue<Site>(number, new SitesPriorityComparator());
		
		// Make the number of sites needed
		for(int i = 0; i < number; i++) {
			this.sites.offer(new Site(min_x, min_y, max_x, max_y, this.sites));
		}
	}
}
