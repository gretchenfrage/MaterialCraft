package com.phoenixkahlo.materialcraft.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public interface NameableBlock {

	String getName();
	
	Block toBlock();
	
	Item toItem();
	
}
