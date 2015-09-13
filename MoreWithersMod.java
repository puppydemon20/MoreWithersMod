package com.puppydemon.MoreWithersMod;

import com.puppydemon.MoreWithersMod.handler.ConfigurationHandler;
import com.puppydemon.MoreWithersMod.init.ModBlocks;
import com.puppydemon.MoreWithersMod.init.ModItems;
import com.puppydemon.MoreWithersMod.init.ModTileEntities;
import com.puppydemon.MoreWithersMod.init.Recipes;
import com.puppydemon.MoreWithersMod.network.MWMGuiHandler;
import com.puppydemon.MoreWithersMod.proxy.IProxy;
import com.puppydemon.MoreWithersMod.reference.Reference;
import com.puppydemon.MoreWithersMod.utility.LogHelper;
import com.puppydemon.MoreWithersMod.world.MWMWorldGen;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

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
			
			ModItems.init();
			ModBlocks.init();
			ModTileEntities.init();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		Recipes.init();
	    NetworkRegistry.INSTANCE.registerGuiHandler(MoreWithersMod.instance, new MWMGuiHandler());
	    GameRegistry.registerWorldGenerator(new MWMWorldGen(), 0);
	}
	@Mod.EventHandler
	public void postinit(FMLPostInitializationEvent event)
	{
			
	}
}
