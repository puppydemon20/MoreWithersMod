package com.puppydemon.MoreWithersMod.inventory;

import com.puppydemon.MoreWithersMod.guicontainer.ContainerTileEntityMWM;
import com.puppydemon.MoreWithersMod.init.ModItems;
import com.puppydemon.MoreWithersMod.item.ItemMWMSword;
import com.puppydemon.MoreWithersMod.reference.AugmentReference;
import com.puppydemon.MoreWithersMod.utility.LogHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotMWM extends Slot 
{
	public static int AugmentCap;
	public static int SwordPlaced = 0;
	public SlotMWM(IInventory inventory, int par2, int par3, int par4)
	{
		super(inventory, par2, par3, par4);
	}
	
	@Override
	public boolean isItemValid(ItemStack itemstack)
	{
		this.SwordPlaced = 1;
		if (itemstack.getItem() == ModItems.ItemSwordT1) {this.AugmentCap = 1; placeAugments(); ContainerTileEntityMWM.getEquppedAugments(itemstack);return true;}
		else if (itemstack.getItem() == ModItems.ItemSwordT2) {this.AugmentCap = 2; return true;}
		else if (itemstack.getItem() == ModItems.ItemSwordT3) {this.AugmentCap = 3; return true;}
		else if (itemstack.getItem() == ModItems.ItemHelmetT1) {this.AugmentCap = 0; return true;}
		else if (itemstack.getItem() == ModItems.ItemChestplateT1) {this.AugmentCap = 2; return true;}
		else if (itemstack.getItem() == ModItems.ItemLeggingsT1) {this.AugmentCap = 1; return true;}
		else if (itemstack.getItem() == ModItems.ItemBootsT1) {this.AugmentCap = 0; return true;}
		else if (itemstack.getItem() == ModItems.ItemHelmetT2) {this.AugmentCap = 1; return true;}
		else if (itemstack.getItem() == ModItems.ItemChestplateT2) {this.AugmentCap = 2; return true;}
		else if (itemstack.getItem() == ModItems.ItemLeggingsT2) {this.AugmentCap = 2; return true;}
		else if (itemstack.getItem() == ModItems.ItemBootsT2) {this.AugmentCap = 1; return true;}
		else if (itemstack.getItem() == ModItems.ItemHelmetT3) {this.AugmentCap = 2; return true;}
		else if (itemstack.getItem() == ModItems.ItemChestplateT3) {this.AugmentCap = 3; return true;}
		else if (itemstack.getItem() == ModItems.ItemLeggingsT3) {this.AugmentCap = 3; return true;}
		else if (itemstack.getItem() == ModItems.ItemBootsT3) {this.AugmentCap = 2; return true;}
		else {this.SwordPlaced = 0; return false;}
	}
	@Override
	public void onPickupFromSlot(EntityPlayer player, ItemStack itemStack)
	{

		ContainerTileEntityMWM.removeAugments();
		this.onSlotChanged();
	}
	@Override
	public int getSlotStackLimit()
	{
		
		return 1;
	}
    public void placeAugments()
    {
    }
}
