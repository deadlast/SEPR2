package com.geeselightning.zepr;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Arrays;

public class TownLevel extends Level {

    private static final String mapLocation = "core/assets/maps/townmap.tmx";
    private static final Vector2 playerSpawn = new Vector2(0, 0);

    // Defining possible zombie spawn locations on this map
    private static final ArrayList<Vector2> zombieSpawnPoints = new ArrayList<Vector2>(
            Arrays.asList(new Vector2(0,100), new Vector2(0,50),
                    new Vector2(50,50), new Vector2(50,0))
            );

    // Defining the number of zombies to be spawned for each wave
    private static final int[] waves = new int[]{5, 10, 15};

    public TownLevel(Zepr zepr) {
        super(zepr, mapLocation, playerSpawn, zombieSpawnPoints, waves);
    }

    @Override
    public void complete() {
        if (parent.progress == 0) {
            parent.progress = parent.TOWN;
        }
        // The stage is being replayed
    }

}
