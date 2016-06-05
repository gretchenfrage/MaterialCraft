package com.phoenixkahlo.materialcraft.block;

import net.minecraft.block.BlockHugeMushroom.EnumType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public class DirectionalBlock extends BasicBlock implements IMetaBlockName {

	public enum Direction implements IStringSerializable {
		NORTH(0, "north"),
		SOUTH(1, "south"),
		EAST(2, "east"),
		WEST(3, "west");
		
		private int id;
		private String name;
		
		private Direction(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		@Override
		public String getName() {
			return name;
		}
		
		@Override
		public String toString() {
			return name;
		}
		
		public int getID() {
			return id;
		}
	}
	
	public static final PropertyEnum DIRECTION = PropertyEnum.create("direction", Direction.class);
	
	public DirectionalBlock(String name, Material material) {
		super(name, material);
		setDefaultState(super.blockState.getBaseState().withProperty(DIRECTION, EnumType.NORTH));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContaisner(this, new IProperty[] {DIRECTION});
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		switch (meta) {
		case 0:
			return getDefaultState().withProperty(DIRECTION, Direction.NORTH);
		case 1:
			return getDefaultState().withProperty(DIRECTION, Direction.SOUTH);
		case 2:
			return getDefaultState().withProperty(DIRECTION, Direction.EAST);
		case 3:
			return getDefaultState().withProperty(DIRECTION, Direction.WEST);
		default:
			throw new IllegalArgumentException("invalid meta: " + meta);
		}
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Direction) state.getValue(DIRECTION)).getID();
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		switch (stack.getItemDamage()) {
		case 0:
			return "north";
		case 1:
			return "south";
		case 2:
			return "east";
		case 3:
			return "west";
		default:
			throw new IllegalArgumentException("invalid damange: " + stack.getItemDamage());
		}
	}

	@Override
	public Item toItem() {
		return new MetaItemBlock(this);
	}

}
