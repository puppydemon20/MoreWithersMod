package com.puppydemon.MoreWithersMod.block;

import com.puppydemon.MoreWithersMod.creativetab.CreativeTabMWM;
import com.puppydemon.MoreWithersMod.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockMWM extends Block
{
	public boolean MultiTexture;
	public IIcon[] icons = new IIcon[6];
	
	public BlockMWM(Material material)
	{
		super(material);
		this.setCreativeTab(CreativeTabMWM.MWM_TAB);
	}
	
	public BlockMWM()
	{
		this(Material.iron);
	}
	
	@Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
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
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
}
