package com.puppydemon.MoreWithersMod.init;

import com.puppydemon.MoreWithersMod.tileentity.TileEntityMWM;
import cpw.mods.fml.common.registry.GameRegistry;

public final class ModTileEntities {

    public static void init() {
        GameRegistry.registerTileEntity(TileEntityMWM.class, "Augmenter");
    }

}