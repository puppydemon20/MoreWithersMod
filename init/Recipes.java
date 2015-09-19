package com.puppydemon.MoreWithersMod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes
{
	public static void init()
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.Augmenter), "gig", "ini", "gig", 'g', "ingotGold", 'i', "ingotIron", 'n', new ItemStack (Items.nether_star)));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.NetherstarBlock), new ItemStack (Items.nether_star), new ItemStack (Items.nether_star), new ItemStack (Items.nether_star), new ItemStack (Items.nether_star), new ItemStack (Items.nether_star), new ItemStack (Items.nether_star), new ItemStack (Items.nether_star), new ItemStack (Items.nether_star), new ItemStack (Items.nether_star));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.nether_star), new ItemStack (ModItems.WitherShard), new ItemStack (ModItems.WitherShard), new ItemStack (ModItems.WitherShard), new ItemStack (ModItems.WitherShard), new ItemStack (ModItems.WitherShard), new ItemStack (ModItems.WitherShard), new ItemStack (ModItems.WitherShard), new ItemStack (ModItems.WitherShard), new ItemStack (ModItems.WitherShard));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.nether_star, 9), new ItemStack (ModBlocks.NetherstarBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ItemSwordT1), new ItemStack (Blocks.stone), new ItemStack (Blocks.stone), new ItemStack (Blocks.stone));
	}
}
