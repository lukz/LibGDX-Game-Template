package com.infunity.libgdxGame.model;

import com.badlogic.gdx.physics.box2d.Body;
import com.infunity.libgdxGame.model.maps.Map;

/**
 * @author Łukasz Żmudziak, @lukzdev
 * @since 2014-10-23
 */
public interface PhysicsObject {
    public void handleBeginContact(PhysicsObject psycho2, Map map);

    public Body getBody();
    public boolean getFlagForDelete();
    public void setFlagForDelete(boolean flag);
}
