package com.puppydemon.MoreWithersMod.guicontainer;

import com.puppydemon.MoreWithersMod.augments.AugmentHelper;
import com.puppydemon.MoreWithersMod.inventory.SlotAugment;
import com.puppydemon.MoreWithersMod.inventory.SlotAugment1;
import com.puppydemon.MoreWithersMod.inventory.SlotAugment2;
import com.puppydemon.MoreWithersMod.inventory.SlotMWM;
import com.puppydemon.MoreWithersMod.reference.AugmentReference;
import com.puppydemon.MoreWithersMod.tileentity.TileEntityMWM;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.gui.IUpdatePlayerListBox;

public class ContainerTileEntityMWM extends Container
{
    private TileEntityMWM te;
    public static Slot MWMSlot1;
    public static Slot MWMSlot2;
    public static Slot MWMSlot3;

    public ContainerTileEntityMWM(IInventory playerInv, TileEntityMWM te)
    {
    	this.te = te;
    	// Tile Entity, Slot 0-3, Slot IDs 0-3
    	this.addSlotToContainer(new SlotMWM(te, 0, 54, 35));
    	this.addSlotToContainer(new SlotAugment(te, 1, 72, 35));
    	this.addSlotToContainer(new SlotAugment1(te, 2, 90, 35));
    	this.addSlotToContainer(new SlotAugment2(te, 3, 108, 35));

        // Player Inventory, Slot 4-30, Slot IDs 4-30
        for (int y = 0; y < 3; ++y)
        {
            for (int x = 0; x < 9; ++x)
            {
                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }

        // Player Inventory, Slot 0-8, Slot IDs 31-39
        for (int x = 0; x < 9; ++x)
        {
            this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
        }

        /*
         * SLOTS:
         * 
         * Tile Entity 0-8 ........ 0  - 3
         * Player Inventory 9-35 .. 3  - 30
         * Player Inventory 0-8 ... 31 - 39
         */
    }

	@Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.te.isUseableByPlayer(playerIn);
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot)
    {
        ItemStack previous = null;
        Slot slot = (Slot) this.inventorySlots.get(fromSlot);

        if (slot != null && slot.getHasStack())
        {
            ItemStack current = slot.getStack();
            previous = current.copy();

            if (fromSlot < 3)
            {
                // From TE Inventory to Player Inventory
                if (!this.mergeItemStack(current, 3, 39, true))
                {
                	return null;
                }
            }
            else
            {
                // From Player Inventory to TE Inventory
                if (!this.mergeItemStack(current, 0, 3, false))
                {
                	return null; 
                }
            }

            if (current.stackSize == 0){
            	slot.putStack((ItemStack) null); }
            else {
            	slot.onSlotChanged(); }

            if (current.stackSize == previous.stackSize) {
            	return null; }
            slot.onPickupFromSlot(playerIn, current);

        }
        return previous;
    }
    public static Boolean checkSword()
    {
    	if (SlotMWM.SwordPlaced == 0)
    		return false;
    	return true;
    }
    public void removeAugments (int slotNumber)
    {
    	Slot slot = (Slot) this.inventorySlots.get(slotNumber);
    	ItemStack itemstack = slot.getStack();
    	if (!(this.inventorySlots.get(slotNumber) == null))
    		itemstack = null;
    }
    public static void getEquppedAugments (ItemStack itemstack)
    {
    	for (int i = 1; i < SlotMWM.AugmentCap; i++)
    	{
    		ItemStack slot1 = MWMSlot1.getStack();
    		ItemStack slot2 = MWMSlot2.getStack();
    		ItemStack slot3 = MWMSlot3.getStack();
    		ItemStack itemstackNew = new ItemStack(AugmentReference.getAugmentName(AugmentHelper.checkEquippedAugments(itemstack, i)));
    		if (i == 1)
    			SlotAugment.itemStack = slot1;
    		if (i == 2)
    			SlotAugment1.itemStack = slot2;
    		if (i == 3)
    			SlotAugment2.itemStack = slot3;
    		
    	}
    }
    //Testing Code
    public void Method(int ID)
    {
    	for (int i = 1; i < 4; i++)
    	{
    		if (i == 1)
    			this.inventoryItemStacks.set(i, new ItemStack(AugmentReference.getAugmentName(ID)));
    		if (i == 2)
    			this.inventoryItemStacks.set(i,  new ItemStack(AugmentReference.getAugmentName(ID)));
    		if (i == 3)
    			this.inventorySlots.set(i,  new ItemStack(AugmentReference.getAugmentName(ID)));
    	}
    }
}
