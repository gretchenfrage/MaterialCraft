package com.phoenixkahlo.materialcraft.item;

import com.phoenixkahlo.materialcraft.MaterialCraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSpade;

public class BasicShovel extends ItemSpade implements NameableItem {

	private String name;
	
	public BasicShovel(String name, ToolMaterial material) {
		super(material);
		this.name = name;
		setUnlocalizedName(MaterialCraft.MODID + "." + name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);
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
