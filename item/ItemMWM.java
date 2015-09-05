package com.puppydemon.MoreWithersMod.item;

import com.puppydemon.MoreWithersMod.reference.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMWM extends Item
{
	public ItemMWM()
	{
		super();
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
}
