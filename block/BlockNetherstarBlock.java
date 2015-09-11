package com.puppydemon.MoreWithersMod.block;

import com.puppydemon.MoreWithersMod.reference.Reference;

import net.minecraft.util.IIcon;

public class BlockNetherstarBlock extends BlockMWM
{
		public BlockNetherstarBlock()
		{
			super();
			this.setUnlocalizedName("NetherstarBlock");
			this.setTextureName(Reference.MOD_ID + ":" + "NetherstarBlock");
			MultiTexture = false;
		}
		@Override
		public IIcon getIcon(int side, int meta)
		{
			return this.icons[side];
		}
}
