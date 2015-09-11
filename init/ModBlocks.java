package com.puppydemon.MoreWithersMod.init;

import com.puppydemon.MoreWithersMod.block.BlockAugmenter;
import com.puppydemon.MoreWithersMod.block.BlockContainerMWM;
import com.puppydemon.MoreWithersMod.block.BlockMWM;
import com.puppydemon.MoreWithersMod.block.BlockNetherstarBlock;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;

public class ModBlocks
{
	//public static final BlockMWM Augmenter = new BlockAugmenter();
	public static final BlockMWM NetherstarBlock = new BlockNetherstarBlock();
	public static final BlockContainerMWM Augmenter = new BlockContainerMWM();
	
	public static void init()
	{
		//GameRegistry.registerBlock(AugmenterTest, "AugmenterTest");
		GameRegistry.registerBlock(Augmenter, "Augmenter");
		GameRegistry.registerBlock(NetherstarBlock, "NetherstarBlock");
	}
}
