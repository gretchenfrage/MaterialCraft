package com.phoenixkahlo.materialcraft.item;

import com.phoenixkahlo.materialcraft.MaterialCraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class BasicSword extends ItemSword implements NameableItem {

	private String name;
	
	public BasicSword(String name, ToolMaterial material) {
		super(material);
		this.name = name;
		setUnlocalizedName(MaterialCraft.MODID + "." + name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
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
