package com.puppydemon.MoreWithersMod.item;

import com.puppydemon.MoreWithersMod.creativetab.CreativeTabMWM;
import com.puppydemon.MoreWithersMod.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;

public class ItemMWMSword extends ItemSword
{
	public ItemMWMSword(ToolMaterial material)
	{
		super(material);
		this.setCreativeTab(CreativeTabMWM.MWM_TAB);
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

	   @Override
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IIconRegister iconRegister)
	   {
	       itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	   }
	   
	   
	   protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	   {
		   return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	   }
}
