package com.puppydemon.MoreWithersMod.item;

import com.puppydemon.MoreWithersMod.creativetab.CreativeTabMWM;

import net.minecraft.item.ItemArmor.ArmorMaterial;

public class ItemArmorT2 extends ItemMWMArmor{

	public ItemArmorT2(String unlocalizedName, ArmorMaterial material, String textureName, int type)
	{
		super(unlocalizedName, material, textureName, type);
		if (this.armorType == 0)
		{
			this.setUnlocalizedName("WitherHelmetT2");
		}
		else if (this.armorType == 1)
		{
			this.setUnlocalizedName("WitherChestplateT2");
		}
		else if (this.armorType == 2)
		{
			this.setUnlocalizedName("WitherLeggingsT2");
		}
		else
		{
			this.setUnlocalizedName("WitherBootsT2");
		}
		this.textureName = textureName;
		this.setTextureName(textureName);
		this.setCreativeTab(CreativeTabMWM.MWM_TAB);
	}

}
