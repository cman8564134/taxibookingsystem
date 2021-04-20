package com.motional.cthye.taxibookingsystem.integ.service;

import com.motional.cthye.taxibookingsystem.model.World;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for World related functions
 */
@Service
public class WorldService {

    private final World world;

    @Autowired
    public WorldService(World world) {
        this.world = world;
    }

    public void tick() {
        world.tick();
    }

    public void reset() {
        world.reset();
    }

}
