package com.puppydemon.MoreWithersMod.item;

import com.puppydemon.MoreWithersMod.creativetab.CreativeTabMWM;
import com.puppydemon.MoreWithersMod.inventory.SlotMWM;
import com.puppydemon.MoreWithersMod.reference.Reference;
import com.puppydemon.MoreWithersMod.utility.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemMWMSword extends ItemSword
{
	public ItemMWMSword(ToolMaterial material)
	{
		super(material);
		this.setCreativeTab(CreativeTabMWM.MWM_TAB);
	}
	
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player)
	{
		LogHelper.info("Sword Created");
		itemStack.stackTagCompound = new NBTTagCompound();
		itemStack.stackTagCompound.setInteger("Augment1_e", -1);
		itemStack.stackTagCompound.setInteger("Augment1_d", -1);
		itemStack.stackTagCompound.setInteger("Augment1_p", -1);
		itemStack.stackTagCompound.setInteger("Augment2_e", -1);
		itemStack.stackTagCompound.setInteger("Augment2_d", -1);
		itemStack.stackTagCompound.setInteger("Augment2_p", -1);
		itemStack.stackTagCompound.setInteger("Augment3_e", -1);
		itemStack.stackTagCompound.setInteger("Augment3_d", -1);
		itemStack.stackTagCompound.setInteger("Augment3_p", -1);

	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean par5)
	{
		super.onUpdate(itemstack, world, entity, par4, par5);
		{
			EntityPlayer player = (EntityPlayer) entity;
			ItemStack equipped = player.getCurrentEquippedItem();
			if(equipped == itemstack)
			{
				int effect = itemstack.stackTagCompound.getInteger("Augment1_e");
				int duration = itemstack.stackTagCompound.getInteger("Augment1_d");
				int power = itemstack.stackTagCompound.getInteger("Augment1_p");
				LogHelper.info("Debug:"+effect);
				if(!(effect == -1)) {
					LogHelper.info("Pass1");
					if(!(duration == -1)) {
						LogHelper.info("Pass2");
						if(!(power == -1)) {
							LogHelper.info("Added Potion Effect");
							player.addPotionEffect(new PotionEffect(effect, duration, power));
							} 
						}
					}
				}
			}
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
