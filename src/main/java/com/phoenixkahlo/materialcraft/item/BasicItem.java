package com.phoenixkahlo.materialcraft.item;

import com.phoenixkahlo.materialcraft.MaterialCraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BasicItem extends Item implements NameableItem {

	private String name;
	
	public BasicItem(String name) {
		this.name = name;
		setUnlocalizedName(MaterialCraft.MODID + "." + name);
		setRegistryName(name);
	}
	
	public BasicItem(String name, CreativeTabs tab) {
		this(name);
		setCreativeTab(tab);
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
