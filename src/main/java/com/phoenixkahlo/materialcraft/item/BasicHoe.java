package com.phoenixkahlo.materialcraft.item;

import com.phoenixkahlo.materialcraft.MaterialCraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item.ToolMaterial;

public class BasicHoe extends ItemHoe implements NameableItem {

	private String name;
	
	public BasicHoe(String name, ToolMaterial material) {
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
