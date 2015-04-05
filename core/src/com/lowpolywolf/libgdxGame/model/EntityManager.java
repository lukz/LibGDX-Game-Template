package com.lowpolywolf.libgdxGame.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.lowpolywolf.libgdxGame.model.entities.Entity;
import com.lowpolywolf.libgdxGame.model.maps.Map;

/**
 * @author Łukasz Żmudziak, @lukzdev
 * @since 2014-10-23
 */
public class EntityManager {

    private Array<Entity> entities;
    private Map map;

    public EntityManager(Map map) {
        this.map = map;
        this.entities = new Array<Entity>();
    }

    public void update(float delta) {
        for (Entity entity : entities) {
            entity.update(delta);
        }
    }

    public void draw(SpriteBatch batch) {
        for (Entity entity : entities) {
            entity.draw(batch);
        }
    }

    public void reset() {
        entities.clear();
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeCoin(Entity entity) {
        entities.removeValue(entity, true);

        if(entity instanceof PhysicsObject) {
            PhysicsObject physicsObject = (PhysicsObject)entity;
            physicsObject.setFlagForDelete(true);
        }
    }

    public void dispose() {
        for (Entity entity : entities) {
            entity.dispose();
        }
    }
}
