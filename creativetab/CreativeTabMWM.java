package com.puppydemon.MoreWithersMod.creativetab;

import com.puppydemon.MoreWithersMod.init.ModItems;
import com.puppydemon.MoreWithersMod.reference.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabMWM
{
	public static final CreativeTabs MWM_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
	{
		@Override
		public Item getTabIconItem()
		{
			return ModItems.ItemSwordT1;
		}
	};
}
