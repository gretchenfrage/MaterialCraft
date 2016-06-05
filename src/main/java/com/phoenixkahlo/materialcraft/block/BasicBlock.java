package com.phoenixkahlo.materialcraft.block;

import com.phoenixkahlo.materialcraft.MaterialCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BasicBlock extends Block implements NameableBlock {

	private String name;
	
	public BasicBlock(String name, Material material) {
		super(material);
		this.name = name;
		setRegistryName(name);
		setUnlocalizedName(MaterialCraft.MODID + "." + name);
	}
	
	@Override
	public Item toItem() {
		ItemBlock out = new ItemBlock(this);
		out.setRegistryName(name);
		return out;
	}
	
	@Override
	public Block toBlock() {
		return this;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
}
