package com.puppydemon.MoreWithersMod.network;

import com.puppydemon.MoreWithersMod.client.gui.GuiTileEntityMWM;
import com.puppydemon.MoreWithersMod.guicontainer.ContainerTileEntityMWM;
import com.puppydemon.MoreWithersMod.tileentity.TileEntityMWM;
import com.puppydemon.MoreWithersMod.utility.LogHelper;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MWMGuiHandler implements IGuiHandler
{
    public static final int MWM_AUGMENTER_GUI = 0;
	private IInventory playerInv;
	private TileEntityMWM te;
    
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
    	TileEntity tileEntity = world.getTileEntity(x,y,z);
    	if (tileEntity instanceof TileEntityMWM) {
    		LogHelper.info("ServerGuiElement ran succesfully");
            return new ContainerTileEntityMWM(player.inventory, (TileEntityMWM) tileEntity);
    	}
		LogHelper.info("ServerGuiElement returned null");
    	return null;
    }
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
    	TileEntity tileEntity = world.getTileEntity(x,y,z);
    	if (tileEntity instanceof TileEntityMWM) {
    		LogHelper.info("ClientGuiElement ran succesfully");
    		return new GuiTileEntityMWM(new ContainerTileEntityMWM(player.inventory, (TileEntityMWM) tileEntity), playerInv, te);
    	}
		LogHelper.info("ClientGuiElement returned null");
    	return null;
    }
}
