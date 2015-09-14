package com.puppydemon.MoreWithersMod.block;

import com.puppydemon.MoreWithersMod.reference.Reference;

import net.minecraft.util.IIcon;

public class BlockAugmenter extends BlockMWM
{
	public BlockAugmenter()
	{
		super();
		this.setUnlocalizedName("Augmenter");
		this.setTextureName(Reference.MOD_ID + ":" + "Augmenter");
        this.setLightLevel(0.2f);
        MultiTexture = true;
	}
	@Override
	public IIcon getIcon(int side, int meta)
	{
		return this.icons[side];
	}
}
