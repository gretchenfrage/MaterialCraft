package com.phoenixkahlo.materialcraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class DirectionalBlock extends BasicBlock {
	
	public enum Direction implements IStringSerializable {
		
		NORTH(0, "north"),
		SOUTH(1, "south"),
		EAST(2, "east"),
		WEST(3, "west");
		
		private int id;
		private String name;
		
		Direction(int id, String name) {
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

	public static final PropertyEnum<Direction> DIRECTION_PROPERTY =
			PropertyEnum.create("direction", Direction.class);
	
	public DirectionalBlock(String name, Material material) {
		super(name, material);
		setDefaultState(super.blockState.getBaseState().withProperty(DIRECTION_PROPERTY, Direction.NORTH));
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		int direction = MathHelper.floor_double((double) ((placer.rotationYaw * 4f) / 360f) + 0.5d) & 3;
		switch (direction) {
		case 0:
			worldIn.setBlockState(pos, state.withProperty(DIRECTION_PROPERTY, Direction.SOUTH), 2);
			break;
		case 1:
			worldIn.setBlockState(pos, state.withProperty(DIRECTION_PROPERTY, Direction.WEST), 2);
			break;
		case 2:
			worldIn.setBlockState(pos, state.withProperty(DIRECTION_PROPERTY, Direction.NORTH), 2);
			break;
		case 3:
			worldIn.setBlockState(pos, state.withProperty(DIRECTION_PROPERTY, Direction.EAST), 2);
			break;
		}
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {DIRECTION_PROPERTY});
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		switch (meta) {
		case 0:
			return getDefaultState().withProperty(DIRECTION_PROPERTY, Direction.NORTH);
		case 1:
			return getDefaultState().withProperty(DIRECTION_PROPERTY, Direction.SOUTH);
		case 2:
			return getDefaultState().withProperty(DIRECTION_PROPERTY, Direction.EAST);
		case 3:
			return getDefaultState().withProperty(DIRECTION_PROPERTY, Direction.WEST);
		default:
			throw new IllegalStateException();
		}
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(DIRECTION_PROPERTY).getID();
	}
	
}