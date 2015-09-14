package com.puppydemon.MoreWithersMod.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class EnhancedWitherShardT3 extends ItemMWM
{
	public EnhancedWitherShardT3()
	{
		super();
		this.setUnlocalizedName("EnhancedWitherShardT3");
	}
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
	list.add("Tier 3");
	}
}
