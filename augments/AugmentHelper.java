package com.puppydemon.MoreWithersMod.augments;

import com.puppydemon.MoreWithersMod.guicontainer.ContainerTileEntityMWM;
import com.puppydemon.MoreWithersMod.init.ModItems;
import com.puppydemon.MoreWithersMod.inventory.SlotAugment;
import com.puppydemon.MoreWithersMod.inventory.SlotAugment1;
import com.puppydemon.MoreWithersMod.inventory.SlotAugment2;
import com.puppydemon.MoreWithersMod.inventory.SlotMWM;
import com.puppydemon.MoreWithersMod.reference.AugmentReference;

import net.minecraft.item.ItemStack;

public class AugmentHelper {
	
	public static void writeToNBT (ItemStack itemStack, int augmentCap, int effect, int dur, int power)
	{
		for (int i = 0; i < augmentCap; i++) {
			itemStack.stackTagCompound.setInteger("Augment" + i + "_e", effect);
			itemStack.stackTagCompound.setInteger("Augment" + i + "_d", dur);
			itemStack.stackTagCompound.setInteger("Augment" + i + "_p", power); 
			itemStack.stackTagCompound.setInteger("Augment_" + i, AugmentReference.id(i));
			}
	}
	
	public static void removefromNBT (ItemStack itemstack)
	{
		
	}
	// Checks to see if the item is an Augment
	public static boolean checkAugment (ItemStack itemstack, int slot)
	{
		if (ContainerTileEntityMWM.checkSword() == true)
		{
			if (itemstack.getItem() == ModItems.AugmentTest)
			{
				checkSlot(itemstack, slot);
				return true;
			}
		}
		return false;
	}
	//This sets the itemStacks for each slot to a constant.
	public static void checkSlot (ItemStack itemstack, int slot)
	{
		if (slot == 1) {SlotAugment.itemStack = itemstack;}
		if (slot == 2) {SlotAugment1.itemStack = itemstack;}
		if (slot == 3) {SlotAugment2.itemStack = itemstack;}
	}
	// Returns the Augment ID from the specified augment slot.
	public static int checkEquippedAugments (ItemStack itemstack, int id)
	{
		return itemstack.stackTagCompound.getInteger("Augment_" + id);
	}
}
