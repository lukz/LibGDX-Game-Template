package com.infunity.libgdxGame.model.entities;

import com.badlogic.gdx.math.Vector2;

/**
 * @author Łukasz Żmudziak, @lukzdev
 * @since 2014-10-23
 */
public abstract class MovableEntity extends Entity {

    protected Vector2 velocity;
    protected float speed;
    protected float rotation;

    public MovableEntity(float speed, float rotation, float x, float y, float width, float height) {
        super(x, y, width, height);
        this.speed = speed;
        this.rotation = rotation;
        this.velocity = new Vector2(0, 0);
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity.set(velocity);
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    /**
     * @return the speed
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }
}