package com.puppydemon.MoreWithersMod.tileentity;

import com.puppydemon.MoreWithersMod.guicontainer.ContainerTileEntityMWM;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;


public class TileEntityMWM extends TileEntity implements IInventory, IUpdatePlayerListBox
{
    private ItemStack[] inventory;
    private String customName;
    protected ForgeDirection orientation;

	
	public TileEntityMWM()
	{
        this.inventory = new ItemStack[this.getSizeInventory()];
        orientation = ForgeDirection.SOUTH;

    }
    public ForgeDirection getOrientation()
    {
        return orientation;
    }

    public void setOrientation(ForgeDirection orientation)
    {
        this.orientation = orientation;
    }

    public void setOrientation(int orientation)
    {
        this.orientation = ForgeDirection.getOrientation(orientation);
    }
    public String getCustomName()
    {
        return this.customName;
    }
    public void setCustomName(String customName)
    {
        this.customName = customName;
    }
    @Override
    public String getInventoryName()
    {
        return this.isCustomInventoryName() ? this.customName : "container.AugmenterTileEntity";
    }

    @Override
    public boolean isCustomInventoryName()
    {
        return this.customName != null && !this.customName.equals("");
    }

    @Override
    public int getSizeInventory() {return 4;}
    
    @Override
    public ItemStack getStackInSlot(int index) {
        if (index < 0 || index >= this.getSizeInventory())
            return null;
        return this.inventory[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        if (this.getStackInSlot(index) != null) {
            ItemStack itemstack;

            if (this.getStackInSlot(index).stackSize <= count) {
                itemstack = this.getStackInSlot(index);
                this.setInventorySlotContents(index, null);
                this.markDirty();
                return itemstack;
            } else {
                itemstack = this.getStackInSlot(index).splitStack(count);

                if (this.getStackInSlot(index).stackSize <= 0) {
                    this.setInventorySlotContents(index, null);
                } else {
                    //Just to show that changes happened
                    this.setInventorySlotContents(index, this.getStackInSlot(index));
                }

                this.markDirty();
                return itemstack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index) {
        ItemStack stack = this.getStackInSlot(index);
        this.setInventorySlotContents(index, null);
        return stack;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        if (index < 0 || index >= this.getSizeInventory())
            return;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
            stack.stackSize = this.getInventoryStackLimit();
            
        if (stack != null && stack.stackSize == 0)
            stack = null;

        this.inventory[index] = stack;
        this.markDirty();
    }
   
    @Override
    public int getInventoryStackLimit() {return 64;}
    
    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
            return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}
	
    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        return true;
    }

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
	    super.writeToNBT(nbt);
	    
        nbt.setByte("teDirection", (byte) orientation.ordinal());

	    NBTTagList list = new NBTTagList();
	    for (int i = 0; i < this.getSizeInventory(); ++i) {
	        if (this.getStackInSlot(i) != null) {
	            NBTTagCompound stackTag = new NBTTagCompound();
	            stackTag.setByte("Slot", (byte) i);
	            this.getStackInSlot(i).writeToNBT(stackTag);
	            list.appendTag(stackTag);
	        }
	    }
	    nbt.setTag("Items", list);

	    if (this.isCustomInventoryName()) {
	        nbt.setString("CustomName", this.getCustomName());
	    }
	}


	@Override
	public void readFromNBT(NBTTagCompound nbt) {
	    super.readFromNBT(nbt);

	    NBTTagList list = nbt.getTagList("Items", 10);
	    for (int i = 0; i < list.tagCount(); ++i) {
	        NBTTagCompound stackTag = list.getCompoundTagAt(i);
	        int slot = stackTag.getByte("Slot") & 255;
	        this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(stackTag));
	    }

	    if (nbt.hasKey("CustomName", 8)) {
	        this.setCustomName(nbt.getString("CustomName"));
	    }
        if (nbt.hasKey("teDirection"))
        {
            this.orientation = ForgeDirection.getOrientation(nbt.getByte("teDirection"));
        }
	}
	@Override
	public void update()
	{
	}
}
