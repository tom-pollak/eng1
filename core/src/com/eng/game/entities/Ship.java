package com.eng.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.eng.game.logic.ActorTable;
import com.eng.game.logic.Pair;
import com.eng.game.map.BackgroundTiledMap;

public class Ship extends Entity {

    public final float speed = 175;
    public Vector2 velocity = new Vector2();

    public Ship(BackgroundTiledMap map, ActorTable actorTable, Texture texture, int health, int holdingCapacity, Integer movementRange) {
        super(map, actorTable, texture, health, holdingCapacity);
        actorTable.addActor(this);
        this.movementRange = movementRange;
    }

    /**
     * Updates ships position
     * Calculates the ships position based on the velocity and delta time
     * If the ship moves inside a blocked tile, the ship is moved back to the previous position and the velocity is set to 0
     *
     * @param delta time since last update
     */
    @Override
    public void act(float delta) {
        super.act(delta);
        float oldX = getX(), oldY = getY();

        setPosition(getX() + velocity.x * delta, getY() + velocity.y * delta);


        Pair<Boolean, Boolean> collisions = map.getMapCollisions(this, oldX, oldY);
        boolean collisionX = collisions.fst;
        boolean collisionY = collisions.snd;

        if (collisionX) {
            setX(oldX);
        }
        if (collisionY) {
            setY(oldY);
        }
        this.setOrigin(getX() + getWidth() / 2, getY() + getHeight() / 2);
    }

    public String toString() {
        return "Ship";
    }
}
