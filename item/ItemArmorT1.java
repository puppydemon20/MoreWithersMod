package com.puppydemon.MoreWithersMod.item;

import com.puppydemon.MoreWithersMod.creativetab.CreativeTabMWM;
import com.puppydemon.MoreWithersMod.reference.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;



public class ItemArmorT1 extends ItemMWMArmor{


	
	public ItemArmorT1(String unlocalizedName, ArmorMaterial material, String textureName, int type)
	{
		super(unlocalizedName, material, textureName, type);
		if (this.armorType == 0)
		{
			this.setUnlocalizedName("WitherHelmetT1");
		}
		else if (this.armorType == 1)
		{
			this.setUnlocalizedName("WitherChestplateT1");
		}
		else if (this.armorType == 2)
		{
			this.setUnlocalizedName("WitherLeggingsT1");
		}
		else
		{
			this.setUnlocalizedName("WitherBootsT1");
		}
		this.textureName = textureName;
		this.setTextureName(textureName);
		this.setCreativeTab(CreativeTabMWM.MWM_TAB);
	}
}

