package com.puppydemon.MoreWithersMod.block;

import java.util.Random;

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
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockContainerMWM extends BlockContainer
{
	public IIcon[] icons = new IIcon[6];
	public boolean MultiTexture;
    private final Random rand = new Random();
	
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
    public void breakBlock(World world, int x, int y, int z, Block block, int meta)
    {
        dropInventory(world, x, y, z);
		super.breakBlock(world, x, y, z, block, meta);
    }
    protected void dropInventory(World world, int x, int y, int z)
    {
    	LogHelper.info("dropInventory was called");
        TileEntity tileEntity = world.getTileEntity(x, y, z);

        if (!(tileEntity instanceof IInventory))
        {
        	LogHelper.info("dropInventory was canceled");
            return;
        }

        IInventory inventory = (IInventory) tileEntity;

        for (int i = 0; i < inventory.getSizeInventory(); i++)
        {
            ItemStack itemStack = inventory.getStackInSlot(i);

            if (itemStack != null && itemStack.stackSize > 0)
            {
                Random rand = new Random();

                float dX = rand.nextFloat() * 0.8F + 0.1F;
                float dY = rand.nextFloat() * 0.8F + 0.1F;
                float dZ = rand.nextFloat() * 0.8F + 0.1F;

                EntityItem entityItem = new EntityItem(world, x + dX, y + dY, z + dZ, itemStack.copy());

                if (itemStack.hasTagCompound())
                {
                    entityItem.getEntityItem().setTagCompound((NBTTagCompound) itemStack.getTagCompound().copy());
                }

                float factor = 0.05F;
                entityItem.motionX = rand.nextGaussian() * factor;
                entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                entityItem.motionZ = rand.nextGaussian() * factor;
                world.spawnEntityInWorld(entityItem);
                itemStack.stackSize = 0;
            }
        }
    }
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack)
    {
        super.onBlockPlacedBy(world, x, y, z, entityLiving, itemStack);
        if (world.getTileEntity(x, y, z) instanceof TileEntityMWM)
        {
            int direction = 0;
            int facing = MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

            if (facing == 0)
            {
                direction = ForgeDirection.NORTH.ordinal();
            }
            else if (facing == 1)
            {
                direction = ForgeDirection.EAST.ordinal();
            }
            else if (facing == 2)
            {
                direction = ForgeDirection.SOUTH.ordinal();
            }
            else if (facing == 3)
            {
                direction = ForgeDirection.WEST.ordinal();
            }

            if (itemStack.hasDisplayName())
            {
                ((TileEntityMWM) world.getTileEntity(x, y, z)).setCustomName(itemStack.getDisplayName());
            }

            ((TileEntityMWM) world.getTileEntity(x, y, z)).setOrientation(direction);
        }
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
            else if (!world.isRemote && tileEntity instanceof TileEntityMWM)
            {
            player.openGui(MoreWithersMod.instance, MWMGuiHandler.MWM_AUGMENTER_GUI, world, x, y, z);
            }
            return true;
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
