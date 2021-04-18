package com.motional.cthye.taxibookingsystem.integ.service;

import com.motional.cthye.taxibookingsystem.model.World;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for World related functions
 */
@Service
public class WorldService {

    @Autowired
    public WorldService() {
    }

    public void tick() {
        World.getInstance().tick();
    }

    public void reset() {
        World.getInstance().reset();
    }

}
