package com.puppydemon.MoreWithersMod.block;

import com.puppydemon.MoreWithersMod.MoreWithersMod;
import com.puppydemon.MoreWithersMod.creativetab.CreativeTabMWM;
import com.puppydemon.MoreWithersMod.network.MWMGuiHandler;
import com.puppydemon.MoreWithersMod.reference.Reference;
import com.puppydemon.MoreWithersMod.tileentity.TileEntityMWM;
import com.puppydemon.MoreWithersMod.utility.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.main.Main;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class BlockContainerMWM extends BlockContainer
{
	public IIcon[] icons = new IIcon[6];
	public boolean MultiTexture;
	
	public BlockContainerMWM()
	{
		super(Material.iron);
		this.setTextureName(Reference.MOD_ID + ":" + "Augmenter");
		this.setUnlocalizedName("Augmenter");
		this.setCreativeTab(CreativeTabMWM.MWM_TAB);
		this.isBlockContainer = true;
		this.setHardness(2.0f);
        this.setResistance(6.0f);
        this.setHarvestLevel("pickaxe", 2);
		MultiTexture = true;
		
	}
	
	@Override
    public void breakBlock(World world, int x, int y, int z, Block blockBroken, int meta)
    {
        super.breakBlock(world, x, y, z, blockBroken, meta);
        world.removeTileEntity(x, y, z);
    }

    @Override
    public boolean onBlockEventReceived(World worldIn, int x, int y, int z, int eventID, int eventParam) {
        super.onBlockEventReceived(worldIn, x, y, z, eventID, eventParam);
        TileEntity tileentity = worldIn.getTileEntity(x, y, z);
        return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
    }
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
    	if (MultiTexture == true)
    	{
    			for (int i = 0; i < 6; i ++)
    				this.icons[i] = iconRegister.registerIcon(this.textureName + "_" + i);
    	}
    	else
    	{
    			for (int i = 0; i < 6; i ++)
    				this.icons[i] = iconRegister.registerIcon(this.textureName);
    	}
    }
    
	@Override
	public IIcon getIcon(int side, int meta)
	{
		return this.icons[side];
	}
	
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) 
    {
        return new TileEntityMWM();
    }
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are)
    {  
    	TileEntity tileEntity = world.getTileEntity(x, y, z);
            if (tileEntity == null || player.isSneaking()) {
                    return false;
            }
            else if (!world.isRemote)
           // try
            {
            LogHelper.info("Player Initialized Gui");
            player.openGui(MoreWithersMod.instance, MWMGuiHandler.MOD_TILE_ENTITY_GUI, world, x, y, z);
           // }
            //catch (Exception e)
            //{
           // LogHelper.fatal("Gui unable to initialize. Reason: " + e);
          //  }
          //  finally
          //  {
            LogHelper.info("Player.opengui test complete");	
            return true;
            }
            return false;
    }
	@Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }	   
	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
}
