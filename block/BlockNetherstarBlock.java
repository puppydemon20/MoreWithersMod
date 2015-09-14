package com.puppydemon.MoreWithersMod.block;

import com.puppydemon.MoreWithersMod.reference.Reference;

import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;

public class BlockNetherstarBlock extends BlockMWM
{
		public BlockNetherstarBlock()
		{
			super(Material.iron);
			this.setUnlocalizedName("NetherstarBlock");
			this.setTextureName(Reference.MOD_ID + ":" + "NetherstarBlock");
			this.setHardness(2.0f);
	        this.setResistance(6.0f);
	        this.setHarvestLevel("pickaxe", 2);
	        this.setLightLevel(0.3f);
			MultiTexture = false;
		}
		@Override
		public IIcon getIcon(int side, int meta)
		{
			return this.icons[side];
		}
}
