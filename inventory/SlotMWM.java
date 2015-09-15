package com.puppydemon.MoreWithersMod.inventory;

import com.puppydemon.MoreWithersMod.init.ModItems;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotMWM extends Slot 
{
	 public SlotMWM(IInventory inventory, int par2, int par3, int par4) {
		  super(inventory, par2, par3, par4);
		  }

	@Override
	public boolean isItemValid(ItemStack itemstack)
	{
		if (!(itemstack == ModItems.ItemSwordT1))
			return false;
		else
			return true;	
	}
		   @Override
		   public int getSlotStackLimit() {
		      return 1;
		   }
		}
