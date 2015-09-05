package com.puppydemon.MoreWithersMod.init;

import com.puppydemon.MoreWithersMod.item.ItemMWM;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems 
{
	public static final ItemMWM ItemSwordT1 = new com.puppydemon.MoreWithersMod.item.ItemSwordT1();
	
	public static void init ()
	{
		GameRegistry.registerItem(ItemSwordT1, "WitherSwordT1");
	}
}
