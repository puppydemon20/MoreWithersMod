package com.puppydemon.MoreWithersMod.item;

import com.puppydemon.MoreWithersMod.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class ItemMWMArmor extends ItemArmor
{
	public String textureName;

	public ItemMWMArmor(String unlocalizedName, ArmorMaterial material, String textureName, int type)
	{
		super(material, 0, type);
	}
	
		@Override
		public String getUnlocalizedName()
		{
			return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
		}
	  
		@Override
		public String getUnlocalizedName(ItemStack itemStack)
		{
			return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
		}	   
		protected String getUnwrappedUnlocalizedName(String unlocalizedName)
		{
			return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
		}
		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
		{
			return Reference.MOD_ID.toLowerCase() + ":textures/models/armor/" + this.textureName + "_" + "model" + ".png";
		}
		
		@Override
		@SideOnly(Side.CLIENT)
		public void registerIcons(IIconRegister iconRegister)
		{
			itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
		}

	}
