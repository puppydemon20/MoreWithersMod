package com.puppydemon.MoreWithersMod.proxy;

import com.puppydemon.MoreWithersMod.MoreWithersMod;
import com.puppydemon.MoreWithersMod.network.MWMGuiHandler;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.client.main.Main;

public abstract class CommonProxy implements IProxy
{
	public void init(FMLInitializationEvent e)
	{
	    NetworkRegistry.INSTANCE.registerGuiHandler(MoreWithersMod.instance, new MWMGuiHandler());
	}
}
