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
        
        // Tile Entity, Slot 0-3, Slot IDs 0-3
        for (int x = 0; x < 4; ++x)
        {
            this.addSlotToContainer(new Slot(te, x, 54 + x * 18, 17 + 1 * 18));
        }

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
                return null;
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
}
