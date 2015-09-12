package com.puppydemon.MoreWithersMod.guicontainer;

import com.puppydemon.MoreWithersMod.tileentity.TileEntityMWM;
import com.puppydemon.MoreWithersMod.utility.LogHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerTileEntityMWM extends Container
{
    private TileEntityMWM te;

    public ContainerTileEntityMWM(IInventory playerInv, TileEntityMWM te)
    {
    	this.te = te;
    	LogHelper.info("Container Line 19");
        
        // Tile Entity, Slot 0-8, Slot IDs 0-8
        for (int y = 0; y < 3; ++y)
        {
            for (int x = 0; x < 3; ++x)
            {
                this.addSlotToContainer(new Slot(te, x + y * 3, 62 + x * 18, 17 + y * 18));
            }
        }
    	LogHelper.info("Container Line 29");

        // Player Inventory, Slot 9-35, Slot IDs 9-35
        for (int y = 0; y < 3; ++y)
        {
            for (int x = 0; x < 9; ++x)
            {
                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }

        // Player Inventory, Slot 0-8, Slot IDs 36-44
        for (int x = 0; x < 9; ++x)
        {
            this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
        }
    	LogHelper.info("Container Line 45");

        /*
         * SLOTS:
         * 
         * Tile Entity 0-8 ........ 0  - 8
         * Player Inventory 9-35 .. 9  - 35
         * Player Inventory 0-8 ... 36 - 44
         */
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
    	LogHelper.info("Container Line 59");
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
        	LogHelper.info("Container Line 73");

            if (fromSlot < 9)
            {
                // From TE Inventory to Player Inventory
                if (!this.mergeItemStack(current, 9, 45, true))
                	LogHelper.info("Container Line 79 Returned Null");
                return null;
            }
            else
            {
                // From Player Inventory to TE Inventory
                if (!this.mergeItemStack(current, 0, 9, false))
                {
                	LogHelper.info("Container Line 87 Returned Null");
                	return null; 
                }
            }

            if (current.stackSize == 0){
            	LogHelper.info("Container Line 93");
            	slot.putStack((ItemStack) null); }
            else {
            	LogHelper.info("Container Line 96");
            	slot.onSlotChanged(); }

            if (current.stackSize == previous.stackSize) {
            	LogHelper.info("Container Line 100 Returned Null");
            	return null; }
            slot.onPickupFromSlot(playerIn, current);
        	LogHelper.info("Container Line 103");

        }
    	LogHelper.info("Container Line 106");
        return previous;
    }
}
