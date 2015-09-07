package com.puppydemon.MoreWithersMod.init;

import com.puppydemon.MoreWithersMod.item.ItemArmorT1;
import com.puppydemon.MoreWithersMod.item.ItemMWMSword;
import com.puppydemon.MoreWithersMod.item.ItemSwordT1;
import com.puppydemon.MoreWithersMod.item.ItemSwordT2;
import com.puppydemon.MoreWithersMod.item.ItemSwordT3;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems 
{
	public static ToolMaterial WITHERT1 = EnumHelper.addToolMaterial("WITHERT1", -1, -1, 2.0F, 8.0F, 0);
	public static ToolMaterial WITHERT2 = EnumHelper.addToolMaterial("WITHERT2", -1, -1, 2.0F, 14.0F, 0);
	public static ToolMaterial WITHERT3 = EnumHelper.addToolMaterial("WITHERT3", -1, -1, 2.0F, 21.0F, 0);
	public static ArmorMaterial WITHERARMOR = EnumHelper.addArmorMaterial("WITHERARMOR", -1, new int[]{3,7,5,2}, 0);
	
	public static final ItemMWMSword ItemSwordT1 = new ItemSwordT1(WITHERT1);
	public static final ItemMWMSword ItemSwordT2 = new ItemSwordT2(WITHERT2);
	public static final ItemMWMSword ItemSwordT3 = new ItemSwordT3(WITHERT3);
	
	public static final ItemArmorT1 ItemHelmetT1 = new ItemArmorT1("WitherHelmetT1", WITHERARMOR,"WitherHelmetT1", 0);
	public static final ItemArmorT1 ItemChestplateT1 = new ItemArmorT1("WitherChestplateT1", WITHERARMOR,"WitherChestplateT1", 1);
	public static final ItemArmorT1 ItemLeggingsT1 = new ItemArmorT1("WitherLeggingsT1", WITHERARMOR,"WitherLeggingsT1", 2);
	public static final ItemArmorT1 ItemBootsT1 = new ItemArmorT1("WitherBootsT1", WITHERARMOR,"WitherBootsT1", 3);
	
	public static void init ()
	{
		GameRegistry.registerItem(ItemHelmetT1, "WitherHelmetT1");
		GameRegistry.registerItem(ItemChestplateT1, "WitherChestplateT1");
		GameRegistry.registerItem(ItemLeggingsT1, "WitherLeggingsT1");
		GameRegistry.registerItem(ItemBootsT1, "WitherBootsT1");
		GameRegistry.registerItem(ItemSwordT1, "WitherSwordT1");
		GameRegistry.registerItem(ItemSwordT2, "WitherSwordT2");
		GameRegistry.registerItem(ItemSwordT3, "WitherSwordT3");
	}
	

}
