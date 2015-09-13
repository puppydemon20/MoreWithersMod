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
        	this.runGenerator(this.genWitherOre, world, random, chunkX, chunkZ, 3, 4, 14);
            break;
        case -1: //Nether

            break;
        case 1: //End

            break;
        }
    }
    private WorldGenerator genWitherOre; //Generates Tutorial Ore (used in Overworld)

    public MWMWorldGen()
    {
    	this.genWitherOre = new WorldGenSingleMinable(ModBlocks.WitherOre);
    
    }
    private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chancesToSpawn; i ++) {
            int x = chunk_X * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunk_Z * 16 + rand.nextInt(16);
            generator.generate(world, rand, x, y, z);
        }
    }
}
