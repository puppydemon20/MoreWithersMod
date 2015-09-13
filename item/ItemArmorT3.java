package com.puppydemon.MoreWithersMod.item;

import com.puppydemon.MoreWithersMod.creativetab.CreativeTabMWM;

import net.minecraft.item.ItemArmor.ArmorMaterial;

public class ItemArmorT3 extends ItemMWMArmor
{
	public ItemArmorT3(String unlocalizedName, ArmorMaterial material, String textureName, int type)
	{
		super(unlocalizedName, material, textureName, type);
		if (this.armorType == 0)
		{
			this.setUnlocalizedName("WitherHelmetT3");
		}
		else if (this.armorType == 1)
		{
			this.setUnlocalizedName("WitherChestplateT3");
		}
		else if (this.armorType == 2)
		{
			this.setUnlocalizedName("WitherLeggingsT3");
		}
		else
		{
			this.setUnlocalizedName("WitherBootsT3");
		}
		this.textureName = textureName;
		this.setTextureName(textureName);
	}
}
