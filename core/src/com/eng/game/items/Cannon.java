package com.eng.game.items;

import com.badlogic.gdx.graphics.Texture;
import com.eng.game.map.BackgroundTiledMap;

public class Cannon extends Item {
    private final float damage;
    private final int range;
    private final float fireRate;


    public Cannon(int damage, int range, int fireRate, BackgroundTiledMap map) {
        super("Cannon", "A cannon that can shoot", new Texture("img/cannon.png"), map);
        this.damage = damage;
        this.range = range;
        this.fireRate = fireRate;
    }

    @Override
    public void use(int tileX, int tileY) {
        fire();
    }

    public void fire() {
        System.out.println("Firing cannon");
    }

    public float getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public float getFireRate() {
        return fireRate;
    }
}
