package com.eng.game.items;

import com.badlogic.gdx.graphics.Texture;
import com.eng.game.logic.ActorTable;
import com.eng.game.logic.Alliance;
import com.eng.game.map.BackgroundTiledMap;

public class Princess extends Item {
    public Princess(BackgroundTiledMap map, ActorTable actorTable) {
        super("Princess", "Return to base to win", new Texture("img/princess.png"), map, actorTable);

    }

    /**
     * If the princess is picked up by the players home college, the player wins the game.
     */
    // TODO: If home base picks up princess, you win
    @Override
    public void onPickup(Alliance alliance) {
        super.onPickup(alliance);
    }
    // Sorry I don't know where you need the function but to go to the win menu use
    // game.setScreen(new WinMenu((game)));
}
