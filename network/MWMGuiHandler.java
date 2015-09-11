package com.puppydemon.MoreWithersMod.network;

import com.puppydemon.MoreWithersMod.client.gui.GuiTileEntityMWM;
import com.puppydemon.MoreWithersMod.guicontainer.ContainerTileEntityMWM;
import com.puppydemon.MoreWithersMod.tileentity.TileEntityMWM;
import com.puppydemon.MoreWithersMod.utility.LogHelper;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MWMGuiHandler implements IGuiHandler
{
    public static final int MOD_TILE_ENTITY_GUI = 0;
    
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    	TileEntity tileEntity = world.getTileEntity(x,y,z);
    	if (ID == MOD_TILE_ENTITY_GUI)
    		LogHelper.info("ServerGuiElement Ran");
            return new ContainerTileEntityMWM(player.inventory, (TileEntityMWM) tileEntity);
    }
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
    	TileEntity tileEntity = world.getTileEntity(x,y,z);
    	if (ID == MOD_TILE_ENTITY_GUI)
    		LogHelper.info("ClientGuiElement Ran");
        	return new GuiTileEntityMWM(new ContainerTileEntityMWM(player.inventory, (TileEntityMWM) tileEntity));
    }
}
