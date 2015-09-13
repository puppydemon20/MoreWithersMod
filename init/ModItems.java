package com.puppydemon.MoreWithersMod.init;

import com.puppydemon.MoreWithersMod.item.ItemArmorT1;
import com.puppydemon.MoreWithersMod.item.ItemArmorT2;
import com.puppydemon.MoreWithersMod.item.ItemArmorT3;
import com.puppydemon.MoreWithersMod.item.ItemMWM;
import com.puppydemon.MoreWithersMod.item.ItemMWMSword;
import com.puppydemon.MoreWithersMod.item.ItemSwordT1;
import com.puppydemon.MoreWithersMod.item.ItemSwordT2;
import com.puppydemon.MoreWithersMod.item.ItemSwordT3;
import com.puppydemon.MoreWithersMod.item.ItemWitherShard;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems 
{
	//Materials
	public static ToolMaterial WITHERT1 = EnumHelper.addToolMaterial("WITHERT1", -1, -1, 2.0F, 8.0F, 0);
	public static ToolMaterial WITHERT2 = EnumHelper.addToolMaterial("WITHERT2", -1, -1, 2.0F, 14.0F, 0);
	public static ToolMaterial WITHERT3 = EnumHelper.addToolMaterial("WITHERT3", -1, -1, 2.0F, 21.0F, 0);
	public static ArmorMaterial WITHERARMOR = EnumHelper.addArmorMaterial("WITHERARMOR", -1, new int[]{3,7,5,2}, 0);
	//Items
	public static final ItemMWM WitherShard = new ItemWitherShard();
	//Three Tiers of Swords
	public static final ItemMWMSword ItemSwordT1 = new ItemSwordT1(WITHERT1);
	public static final ItemMWMSword ItemSwordT2 = new ItemSwordT2(WITHERT2);
	public static final ItemMWMSword ItemSwordT3 = new ItemSwordT3(WITHERT3);
	//Tier One Armor
	public static final ItemArmorT1 ItemHelmetT1 = new ItemArmorT1("WitherHelmetT1", WITHERARMOR,"WitherHelmetT1", 0);
	public static final ItemArmorT1 ItemChestplateT1 = new ItemArmorT1("WitherChestplateT1", WITHERARMOR,"WitherChestplateT1", 1);
	public static final ItemArmorT1 ItemLeggingsT1 = new ItemArmorT1("WitherLeggingsT1", WITHERARMOR,"WitherLeggingsT1", 2);
	public static final ItemArmorT1 ItemBootsT1 = new ItemArmorT1("WitherBootsT1", WITHERARMOR,"WitherBootsT1", 3);
	//Tier Two Armor
	public static final ItemArmorT2 ItemHelmetT2 = new ItemArmorT2("WitherHelmetT2", WITHERARMOR,"WitherHelmetT2", 0);
	public static final ItemArmorT2 ItemChestplateT2 = new ItemArmorT2("WitherChestplateT2", WITHERARMOR,"WitherChestplateT2", 1);
	public static final ItemArmorT2 ItemLeggingsT2 = new ItemArmorT2("WitherLeggingsT2", WITHERARMOR,"WitherLeggingsT2", 2);
	public static final ItemArmorT2 ItemBootsT2 = new ItemArmorT2("WitherBootsT2", WITHERARMOR,"WitherBootsT2", 3);
	//Tier Three Armor
	public static final ItemArmorT3 ItemHelmetT3 = new ItemArmorT3("WitherHelmetT3", WITHERARMOR,"WitherHelmetT3", 0);
	public static final ItemArmorT3 ItemChestplateT3 = new ItemArmorT3("WitherChestplateT3", WITHERARMOR,"WitherChestplateT3", 1);
	public static final ItemArmorT3 ItemLeggingsT3 = new ItemArmorT3("WitherLeggingsT3", WITHERARMOR,"WitherLeggingsT3", 2);
	public static final ItemArmorT3 ItemBootsT3 = new ItemArmorT3("WitherBootsT3", WITHERARMOR,"WitherBootsT3", 3);
	
	public static void init ()
	{
		//Items
		GameRegistry.registerItem(WitherShard, "WitherShard");
		//Tier One Armor
		GameRegistry.registerItem(ItemHelmetT1, "WitherHelmetT1");
		GameRegistry.registerItem(ItemChestplateT1, "WitherChestplateT1");
		GameRegistry.registerItem(ItemLeggingsT1, "WitherLeggingsT1");
		GameRegistry.registerItem(ItemBootsT1, "WitherBootsT1");
		//Tier Two Armor
		GameRegistry.registerItem(ItemHelmetT2, "WitherHelmetT2");
		GameRegistry.registerItem(ItemChestplateT2, "WitherChestplateT2");
		GameRegistry.registerItem(ItemLeggingsT2, "WitherLeggingsT2");
		GameRegistry.registerItem(ItemBootsT2, "WitherBootsT2");
		//Tier Three Armor
		GameRegistry.registerItem(ItemHelmetT3, "WitherHelmetT3");
		GameRegistry.registerItem(ItemChestplateT3, "WitherChestplateT3");
		GameRegistry.registerItem(ItemLeggingsT3, "WitherLeggingsT3");
		GameRegistry.registerItem(ItemBootsT3, "WitherBootsT3");
		//Three Tiers of Swords
		GameRegistry.registerItem(ItemSwordT1, "WitherSwordT1");
		GameRegistry.registerItem(ItemSwordT2, "WitherSwordT2");
		GameRegistry.registerItem(ItemSwordT3, "WitherSwordT3");
	}
	

}
