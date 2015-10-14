package com.puppydemon.MoreWithersMod.reference;

import com.puppydemon.MoreWithersMod.init.ModItems;
import com.puppydemon.MoreWithersMod.inventory.SlotAugment;
import com.puppydemon.MoreWithersMod.inventory.SlotAugment1;
import com.puppydemon.MoreWithersMod.inventory.SlotAugment2;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

public class AugmentReference
{
	
	public static final int STRENGTH = Potion.damageBoost.id;
	
	// Returns the Id of the Augment ItemStack in given slot.
	public static int id (int slot)
	{
	if (slot == 1)
	return getAugmentID(SlotAugment.itemStack);
	if (slot == 2)
	return getAugmentID(SlotAugment1.itemStack);
	if (slot == 3)
	return getAugmentID(SlotAugment2.itemStack);
	return 0;
	}

	// Returns the Id of the Augment when given an ItemStack
	private static int getAugmentID(ItemStack itemStack)
	{
		if (itemStack.getItem() == ModItems.AugmentTest)
			return 1;
		return 0;
	}
	
	// Returns the Name of the Augment when given an ID
	public static Item getAugmentName (int ID)
	{
		if (ID == 1)
			return ModItems.AugmentTest;
		return null;
	}
	
}
