package com.puppydemon.MoreWithersMod.world;

import java.util.Random;

import com.puppydemon.MoreWithersMod.init.ModBlocks;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class MWMWorldGen implements IWorldGenerator
{

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.dimensionId) {
        case 0: //Overworld

            break;
        case -1: //Nether

            break;
        case 1: //End

            break;
        }
        private WorldGenerator gen_tutorial_ore; //Generates Tutorial Ore (used in Overworld)

        public MWMWorldGen() {
            this.gen_tutorial_ore = new WorldGenMinable(ModBlocks.tutorial_ore, 8);
        }
    }
}
