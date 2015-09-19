package com.puppydemon.MoreWithersMod.inventory;

import com.puppydemon.MoreWithersMod.augments.AugmentHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotAugment1 extends Slot
{

	 public static ItemStack itemStack;
	 
	 public SlotAugment1(IInventory inventory, int par2, int par3, int par4)
	 {
		  super(inventory, par2, par3, par4);
	 }
	 @Override
	 public int getSlotStackLimit()
	 {
		 return 1;
	 }
	 @Override
	 public boolean isItemValid(ItemStack itemstack)
	 {
		return AugmentHelper.checkAugment(itemstack,2);
	 }
	 @Override
	 public void onPickupFromSlot(EntityPlayer player, ItemStack itemstack)
	 {
		 this.onSlotChanged();
	 }
	 
}
