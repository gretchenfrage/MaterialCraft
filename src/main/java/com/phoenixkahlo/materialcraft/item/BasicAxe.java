package com.phoenixkahlo.materialcraft.item;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.phoenixkahlo.materialcraft.MaterialCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class BasicAxe extends ItemTool implements NameableItem {

	private String name;

	private ToolMaterial material = null;
	private static Set<Block> blocks = null;

	/**
	 * This initializes the ItemAxeCustom object.
	 */
	public BasicAxe(String name, ToolMaterial material) {
		super(material, getEffectedBlocks());
		this.name = name;
		this.material = material;
		setUnlocalizedName(MaterialCraft.MODID + "." + name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);
	}

	/**
	 * This create a list of vanilla blocks that the custom axe can be used on.
	 */
	private static Set<Block> getEffectedBlocks() {
		if (blocks == null) {
			blocks = new HashSet<Block>();
			// Arcacia
			blocks.add(Blocks.ACACIA_DOOR);
			blocks.add(Blocks.ACACIA_FENCE);
			blocks.add(Blocks.ACACIA_FENCE_GATE);
			blocks.add(Blocks.ACACIA_STAIRS);
			// Birch
			blocks.add(Blocks.BIRCH_DOOR);
			blocks.add(Blocks.BIRCH_FENCE);
			blocks.add(Blocks.BIRCH_FENCE_GATE);
			blocks.add(Blocks.BIRCH_STAIRS);
			// Dark Oak
			blocks.add(Blocks.DARK_OAK_DOOR);
			blocks.add(Blocks.DARK_OAK_FENCE);
			blocks.add(Blocks.DARK_OAK_FENCE_GATE);
			blocks.add(Blocks.DARK_OAK_STAIRS);
			// Jungle
			blocks.add(Blocks.JUNGLE_DOOR);
			blocks.add(Blocks.JUNGLE_FENCE);
			blocks.add(Blocks.JUNGLE_FENCE_GATE);
			blocks.add(Blocks.JUNGLE_STAIRS);
			// Oak
			blocks.add(Blocks.OAK_DOOR);
			blocks.add(Blocks.OAK_FENCE);
			blocks.add(Blocks.OAK_FENCE_GATE);
			blocks.add(Blocks.OAK_STAIRS);
			// Spruce
			blocks.add(Blocks.SPRUCE_DOOR);
			blocks.add(Blocks.SPRUCE_FENCE);
			blocks.add(Blocks.SPRUCE_FENCE_GATE);
			blocks.add(Blocks.SPRUCE_STAIRS);
			// Logs
			blocks.add(Blocks.LOG);
			blocks.add(Blocks.LOG2);
			// Leaves
			blocks.add(Blocks.LEAVES);
			blocks.add(Blocks.LEAVES2);
			// Planks
			blocks.add(Blocks.PLANKS);
			// Crafting Table
			blocks.add(Blocks.CRAFTING_TABLE);
			// Pumkin
			blocks.add(Blocks.PUMPKIN);
			// Lit Pumkin
			blocks.add(Blocks.LIT_PUMPKIN);
			// Vines
			blocks.add(Blocks.VINE);
			// Melon
			blocks.add(Blocks.MELON_BLOCK);
		}
		return blocks;
	}

	/**
	 * @return if the block can be mined by the custom axe
	 */
	private boolean checkStrVsBlock(ItemStack stack, IBlockState state) {

		boolean b = false;

		// Check Block List that the axe can mine...
		Iterator<Block> it = blocks.iterator();

		while (it.hasNext()) {
			Block block = it.next();

			if (block == state.getBlock()) {
				b = true;
				break;
			}
		}

		// Check Materials
		Material material = state.getMaterial();

		// Added in harvest tool and harvest level
		return b || material == Material.WOOD || material == Material.PLANTS || material == Material.VINE
				|| (((state.getBlock().getHarvestTool(state) != null
						&& state.getBlock().getHarvestTool(state).equals("axe")) ? true : false)
						&& state.getBlock().getHarvestLevel(state) <= this.material.getHarvestLevel());
	}

	@Override
	public float getStrVsBlock(ItemStack stack, IBlockState state) {
		return (!checkStrVsBlock(stack, state)) ? super.getStrVsBlock(stack, state)
				: this.material.getEfficiencyOnProperMaterial();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Item toItem() {
		return this;
	}

}
