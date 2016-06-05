package com.phoenixkahlo.materialcraft.modifications;

import com.phoenixkahlo.materialcraft.MaterialCraft;
import com.phoenixkahlo.materialcraft.item.BasicAxe;
import com.phoenixkahlo.materialcraft.item.ItemManager;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DropHandler {
	
	private static boolean isNonAxeMiningLog(HarvestDropsEvent event) {
		Block block = event.getState().getBlock();
		if (!(block == Blocks.LOG || block == Blocks.LOG2)) return false;
		EntityPlayer player = event.getHarvester();
		if (player == null) return true;
		ItemStack stack = player.getHeldItem(player.getActiveHand());
		if (stack == null) return true;
		Item item = stack.getItem();
		if (item instanceof ItemAxe || item instanceof BasicAxe) return false;
		return true;
	}
	
	@SubscribeEvent
	public void checkDrops(HarvestDropsEvent event) {
		if (isNonAxeMiningLog(event)) {
			event.getDrops().clear();
			event.getDrops().add(new ItemStack(ItemManager.woodChunk, MaterialCraft.RANDOM.nextInt(2) + 2));
		} else if (event.getState().getBlock() == Blocks.TALLGRASS) {
			if (MaterialCraft.RANDOM.nextFloat() < 0.06f)
				event.getDrops().add(new ItemStack(ItemManager.grassTwine));
		}
	}
	
}
