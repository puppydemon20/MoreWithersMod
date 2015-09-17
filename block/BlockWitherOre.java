package com.puppydemon.MoreWithersMod.block;

import java.util.Random;

import com.puppydemon.MoreWithersMod.reference.Reference;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class BlockWitherOre extends BlockMWM
{
	private Item drop;
	private int meta;
	private int least_quantity;
	private int most_quantity;
	private Random rand = new Random();
	
	public BlockWitherOre(String unlocalizedName, Material mat, Item drop, int meta, int least_quantity, int most_quantity)
	{
		super(Material.iron);
	    this.drop = drop;
	    this.meta = meta;
	    this.least_quantity = least_quantity;
	    this.most_quantity = most_quantity;
		this.setUnlocalizedName("WitherOre");
		this.setTextureName(Reference.MOD_ID + ":" + "WitherOre");
		this.setHardness(3.0f);
        this.setResistance(12.0f);
        this.setHarvestLevel("pickaxe", 3);
        this.setLightLevel(0.6f);
        unlocalizedName = this.getUnlocalizedName();
		MultiTexture = false;
	}
	public BlockWitherOre(String unlocalizedName, Material mat, Item drop, int least_quantity, int most_quantity) {
	    this(unlocalizedName, mat, drop, 0, least_quantity, most_quantity);
	}

	protected BlockWitherOre(String unlocalizedName, Material mat, Item drop)
	{
	    this(unlocalizedName, mat, drop, 1, 1);
	}
	@Override
	public Item getItemDropped(int meta, Random random, int fortune) {
	    return this.drop;
	}

	@Override
	public int damageDropped(int metadata) {
	    return this.meta;
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
	    if (this.least_quantity >= this.most_quantity)
	        return this.least_quantity;
	    return this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
	}
    @Override
    public int getExpDrop(IBlockAccess world, int meta, int fortune)
    {
    	return MathHelper.getRandomIntegerInRange(rand, 10, 20);
    }
     
	@Override
	public IIcon getIcon(int side, int meta)
	{
		return this.icons[side];
	}
}
