package com.infunity.libgdxGame.model;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.infunity.libgdxGame.utils.BodyBuilder;
import com.infunity.libgdxGame.utils.FixtureDefBuilder;
import com.infunity.libgdxGame.utils.JointBuilder;

/**
 * @author Łukasz Żmudziak, @lukzdev
 * @since 2014-10-23
 */
public class Box2DWorld {

    /*
     * Statics for calculation pixel to box2d metrics and vice versa
     */
    public static final float WORLD_TO_BOX = 0.01f;
    public static final float BOX_TO_WORLD = 100f;


    /*
     * Masks and categories used to filter collisions
     */
//    public final static short OBSTACLE_MASK = Box2DWorld.CATEGORY.PLAYER | Box2DWorld.CATEGORY.PLAYER_PARTICLES;
//
//    public final static class CATEGORY {
//        public final static short GROUND = 0x0001;
//        public final static short PLAYER = 0x0002;
//        public final static short OBSTACLE = 0x0004;
//    };

    private World world;

    private FixtureDefBuilder fixtureDefBuilder;
    private BodyBuilder bodyBuilder;
    private JointBuilder jointBuilder;

    private Box2DDebugRenderer debugRenderer;

    public Box2DWorld(Vector2 gravity) {
//        World.setVelocityThreshold(WORLD_TO_BOX);
        world = new World(gravity, true);
        debugRenderer = new Box2DDebugRenderer();

        bodyBuilder = new BodyBuilder(world);
        fixtureDefBuilder = new FixtureDefBuilder();
    }

    public void update(float dt) {
        world.step(dt, 6, 2);
        //sweepDeadBodies();
    }

    /*
	 * Bodies should be removed after world step to prevent simulation crash
	 */
	/*public void sweepDeadBodies() {
		world.getBodies(bodies);
		for (Iterator<Body> iter = bodies.iterator(); iter.hasNext();) {
			Body body = iter.next();
			if (body != null && (body.getUserData() instanceof PhysicsObject)) {
                PhysicsObject data = (PhysicsObject) body.getUserData();
				if (data.getFlagForDelete()) {
					getWorld().destroyBody(body);
					body.setUserData(null);
					body = null;
				}
			}
		}
	}*/

    /*
	 * Box2D debug renderer
     */
    public void render(Camera cam) {
        debugRenderer.render(world, cam.combined.cpy().scl(BOX_TO_WORLD));
    }

    public World getWorld() {
        return world;
    }

    public BodyBuilder getBodyBuilder() {
        return bodyBuilder;
    }

    public FixtureDefBuilder getFixtureDefBuilder() {
        return fixtureDefBuilder;
    }

    public JointBuilder getJointBuilder() {
        return jointBuilder;
    }
}
