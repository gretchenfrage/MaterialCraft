package com.phoenixkahlo.materialcraft.recipe;

import java.util.List;

import com.phoenixkahlo.materialcraft.block.BlockManager;
import com.phoenixkahlo.materialcraft.item.ItemManager;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeManager {

	public static void preInit(FMLPreInitializationEvent event) {
		GameRegistry.addShapedRecipe(new ItemStack(ItemManager.rock),
				"DD",
				"DD"
				,'D', Blocks.DIRT);
		GameRegistry.addShapedRecipe(new ItemStack(ItemManager.primitiveSword),
				"RT",
				"RW",
				'T', ItemManager.grassTwine,
				'R', ItemManager.rock,
				'W', ItemManager.woodChunk);
		GameRegistry.addShapedRecipe(new ItemStack(ItemManager.primitivePickaxe),
				"TR",
				" W",
				'T', ItemManager.grassTwine,
				'R', ItemManager.rock,
				'W', ItemManager.woodChunk);
		GameRegistry.addShapedRecipe(new ItemStack(ItemManager.primitiveShovel),
				"RT",
				" W",
				'T', ItemManager.grassTwine,
				'R', ItemManager.rock,
				'W', ItemManager.woodChunk);
		GameRegistry.addShapedRecipe(new ItemStack(ItemManager.primitiveAxe),
				"RR",
				"TW",
				'T', ItemManager.grassTwine,
				'R', ItemManager.rock,
				'W', ItemManager.woodChunk);
		GameRegistry.addShapedRecipe(new ItemStack(ItemManager.primitiveHoe),
				"TW",
				"R ",
				'T', ItemManager.grassTwine,
				'R', ItemManager.rock,
				'W', ItemManager.woodChunk);
		GameRegistry.addShapedRecipe(new ItemStack(BlockManager.woodcraftBench),
				"RR",
				"TT",
				'R', ItemManager.rock,
				'T', ItemManager.woodChunk);
	}
	
	public static void postInit(FMLPostInitializationEvent event) {
		r(Items.WOODEN_AXE);
		r(Items.WOODEN_HOE);
		r(Items.WOODEN_PICKAXE);
		r(Items.WOODEN_SHOVEL);
		r(Items.WOODEN_SWORD);
		r(Items.STONE_AXE);
		r(Items.STONE_HOE);
		r(Items.STONE_PICKAXE);
		r(Items.STONE_SHOVEL);
		r(Items.STONE_SWORD);
		r(Items.IRON_AXE);
		r(Items.IRON_HOE);
		r(Items.IRON_PICKAXE);
		r(Items.IRON_SHOVEL);
		r(Items.IRON_SWORD);
		r(Items.GOLDEN_AXE);
		r(Items.GOLDEN_PICKAXE);
		r(Items.GOLDEN_SHOVEL);
		r(Items.GOLDEN_SWORD);
		r(Items.DIAMOND_AXE);
		r(Items.DIAMOND_PICKAXE);
		r(Items.DIAMOND_SHOVEL);
		r(Items.DIAMOND_SWORD);
		r(Items.LEATHER_BOOTS);
		r(Items.LEATHER_CHESTPLATE);
		r(Items.LEATHER_HELMET);
		r(Items.LEATHER_LEGGINGS);
		r(Items.IRON_BOOTS);
		r(Items.IRON_CHESTPLATE);
		r(Items.IRON_HELMET);
		r(Items.IRON_LEGGINGS);
		r(Items.GOLDEN_BOOTS);
		r(Items.GOLDEN_CHESTPLATE);
		r(Items.GOLDEN_HELMET);
		r(Items.GOLDEN_LEGGINGS);
		r(Items.DIAMOND_BOOTS);
		r(Items.DIAMOND_CHESTPLATE);
		r(Items.DIAMOND_HELMET);
		r(Items.DIAMOND_LEGGINGS);
		r(Blocks.PLANKS);
		r(Blocks.ACACIA_FENCE);
		r(Blocks.ACACIA_FENCE_GATE);
		r(Blocks.BIRCH_FENCE);
		r(Blocks.BIRCH_FENCE_GATE);
		r(Blocks.DARK_OAK_FENCE);
		r(Blocks.DARK_OAK_FENCE_GATE);
		r(Blocks.JUNGLE_FENCE);
		r(Blocks.JUNGLE_FENCE_GATE);
		r(Blocks.OAK_FENCE);
		r(Blocks.OAK_FENCE_GATE);
		r(Blocks.SPRUCE_FENCE);
		r(Blocks.SPRUCE_FENCE_GATE);
		r(Blocks.ACACIA_DOOR);
		r(Blocks.BIRCH_DOOR);
		r(Blocks.DARK_OAK_DOOR);
		r(Blocks.IRON_DOOR);
		r(Blocks.JUNGLE_DOOR);
		r(Blocks.OAK_DOOR);
		r(Blocks.SPRUCE_DOOR);
		r(Blocks.TRAPDOOR);
		r(Blocks.ACACIA_STAIRS);
		r(Blocks.BIRCH_STAIRS);
		r(Blocks.DARK_OAK_STAIRS);
		r(Blocks.JUNGLE_STAIRS);
		r(Blocks.OAK_STAIRS);
		r(Blocks.SPRUCE_STAIRS);
		r(Blocks.WOODEN_SLAB);
		r(Blocks.DOUBLE_WOODEN_SLAB);
		r(Items.ACACIA_DOOR);
		r(Items.BIRCH_DOOR);
		r(Items.DARK_OAK_DOOR);
		r(Items.IRON_DOOR);
		r(Items.JUNGLE_DOOR);
		r(Items.OAK_DOOR);
		r(Items.SPRUCE_DOOR);
		r(Items.STICK);
	}
	
	private static void r(Block block) {
		r(Item.getItemFromBlock(block));
	}
	
	private static void r(Item output) {
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		for (int i = recipes.size() - 1; i >= 0; i--) {
			if (recipes.get(i) == null || recipes.get(i).getRecipeOutput() == null ||
					recipes.get(i).getRecipeOutput().getItem() == null)
				continue; // Cautiously prevent NullPointerException
			if (recipes.get(i).getRecipeOutput().getItem() == output) {
				recipes.remove(i);
				return;
			}
		}
		System.out.println("Failed to remove " + output + "!");
	}

}
