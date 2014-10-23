package com.infunity.libgdxGame.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.infunity.libgdxGame.model.maps.Map;

/**
 * @author Łukasz Żmudziak, @lukzdev
 * @since 2014-10-23
 */
public class GameWorld implements ContactListener {

    private Map map;
    private Box2DWorld box2dworld;

    public enum GameState {
        GAME_STARTED, GAME_FINISHED
    }

    private GameState gameState = GameState.GAME_STARTED;

    public GameWorld(Box2DWorld box2dworld, Map map) {
        this.box2dworld = box2dworld;
        this.map = map;

        // Pass all collisions through this class
        box2dworld.getWorld().setContactListener(this);
    }

    public void resetGame() {
        map.resetGame();
    }

    public void update(float delta) {
        map.update(delta);
    }

    public void draw(SpriteBatch batch, float delta) {
        map.draw(batch, delta);
    }

    @Override
    public void beginContact(Contact contact) {
        Object ent1 = contact.getFixtureA().getBody().getUserData();
        Object ent2 = contact.getFixtureB().getBody().getUserData();

        if(!(ent1 instanceof PhysicsObject) || !(ent2 instanceof PhysicsObject)) {
            return;
        }

        PhysicsObject physo1 = (PhysicsObject)ent1;
        PhysicsObject physo2 = (PhysicsObject)ent2;

        physo1.handleBeginContact(physo2, map);
        physo2.handleBeginContact(physo1, map);
    }

    @Override
    public void endContact(Contact contact) {
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
    }

    public Map getMap() {
        return map;
    }

    public Box2DWorld getBox2dworld() {
        return box2dworld;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void dispose() {
        map.dispose();
    }
}
