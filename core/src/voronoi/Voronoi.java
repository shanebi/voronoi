package voronoi;

import voronoi.fortunes_algorithm.FortunesAlgorithm;
import voronoi.fortunes_algorithm.Site;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Voronoi extends ApplicationAdapter {
	private FortunesAlgorithm fa;
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		Gdx.graphics.setDisplayMode(1000, 1000, false);
		
		// Create a new set of sites
		fa = new FortunesAlgorithm(0, 0, 1000, 1000, 20);
		batch = new SpriteBatch();
		img = new Texture("Site.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		for(Site s : fa.sites) {
			batch.begin();
			batch.draw(img, s.location()[0], s.location()[1]);
			batch.end();
		}
	}
}
