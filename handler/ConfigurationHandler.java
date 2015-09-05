package com.puppydemon.MoreWithersMod.handler;

import java.io.File;

import com.puppydemon.MoreWithersMod.reference.Reference;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler
{
	public static Configuration configuration;
	public static boolean testValue = false;
	
	public static void init (File configFile)
	{
		if (configuration == null)
		{
			configuration = new Configuration (configFile);
			loadConfiguration();
		}
		
	}


	@SubscribeEvent
	public void onConfigurationChangedEvent (ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
		{
			loadConfiguration();
		}
	}
	
	private static void loadConfiguration ()
	{
		testValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, false, "This is an example of a configuration value");
				
		if (configuration.hasChanged())
		{
			configuration.save();
		}
	}
}