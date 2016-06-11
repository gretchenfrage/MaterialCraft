package com.phoenixkahlo.materialcraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WoodcraftBench extends DirectionalBlock {

	public WoodcraftBench() {
		super("woodcraftbench", Material.WOOD);
		setCreativeTab(CreativeTabs.DECORATIONS);
		super.isBlockContainer = true;
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new WoodcraftBenchEntity();
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		super.breakBlock(worldIn, pos, state);
		worldIn.removeTileEntity(pos);
	}

	@Override
	public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int id, int param) {
		super.eventReceived(state, worldIn, pos, id, param);
		TileEntity entity = worldIn.getTileEntity(pos);
		return entity == null ? false : entity.receiveClientEvent(id, param);
	}
	
}
