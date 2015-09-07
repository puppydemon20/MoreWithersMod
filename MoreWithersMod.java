package com.puppydemon.MoreWithersMod;

import com.puppydemon.MoreWithersMod.handler.ConfigurationHandler;
import com.puppydemon.MoreWithersMod.init.ModItems;
import com.puppydemon.MoreWithersMod.proxy.IProxy;
import com.puppydemon.MoreWithersMod.reference.Reference;
import com.puppydemon.MoreWithersMod.utility.LogHelper;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class MoreWithersMod
{
	@Mod.Instance(Reference.MOD_ID)
	public static MoreWithersMod instance;
	
	@SidedProxy (clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
			ConfigurationHandler.init(event.getSuggestedConfigurationFile());
			FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
			LogHelper.info("Pre Initialization Complete!");
			
			ModItems.init();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
			
	}
	
	@Mod.EventHandler
	public void postinit(FMLPostInitializationEvent event)
	{
			
	}
}
