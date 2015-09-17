package com.puppydemon.MoreWithersMod.inventory;

import com.puppydemon.MoreWithersMod.init.ModItems;
import com.puppydemon.MoreWithersMod.reference.Itemstacks;
import com.puppydemon.MoreWithersMod.utility.LogHelper;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotMWM extends Slot 
{
	 public SlotMWM(IInventory inventory, int par2, int par3, int par4)
	 {
		  super(inventory, par2, par3, par4);
	 }

	 @Override
	 public boolean isItemValid(ItemStack itemstack)
	 {
		if (itemstack.getItem() == ModItems.ItemSwordT1) {return true;}
		else if (itemstack.getItem() == ModItems.ItemSwordT2) {return true;}
		else if (itemstack.getItem() == ModItems.ItemSwordT3) {return true;}
		else if (itemstack.getItem() == ModItems.ItemHelmetT1) {return true;}
		else if (itemstack.getItem() == ModItems.ItemChestplateT1) {return true;}
		else if (itemstack.getItem() == ModItems.ItemLeggingsT1) {return true;}
		else if (itemstack.getItem() == ModItems.ItemBootsT1) {return true;}
		else if (itemstack.getItem() == ModItems.ItemHelmetT2) {return true;}
		else if (itemstack.getItem() == ModItems.ItemChestplateT2) {return true;}
		else if (itemstack.getItem() == ModItems.ItemLeggingsT2) {return true;}
		else if (itemstack.getItem() == ModItems.ItemBootsT2) {return true;}
		else if (itemstack.getItem() == ModItems.ItemHelmetT3) {return true;}
		else if (itemstack.getItem() == ModItems.ItemChestplateT3) {return true;}
		else if (itemstack.getItem() == ModItems.ItemLeggingsT3) {return true;}
		else if (itemstack.getItem() == ModItems.ItemBootsT3) {return true;}
		else {return false;}
	 }
		   @Override
		   public int getSlotStackLimit()
		   {
		      return 1;
		   }
		}
