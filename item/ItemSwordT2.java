package com.puppydemon.MoreWithersMod.item;

import com.puppydemon.MoreWithersMod.creativetab.CreativeTabMWM;

import net.minecraft.item.Item.ToolMaterial;

public class ItemSwordT2 extends ItemMWMSword
{
	public ItemSwordT2(ToolMaterial material)
	{
		super(material);
		this.setCreativeTab(CreativeTabMWM.MWM_TAB);
		this.setUnlocalizedName("WitherSwordT2");
		
	}
}
