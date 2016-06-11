package com.phoenixkahlo.materialcraft.block;

import com.phoenixkahlo.materialcraft.MaterialCraft;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockManager {

	public static BasicBlock woodcraftBench;
	
	public static void preInit(FMLPreInitializationEvent event) {
		woodcraftBench = new WoodcraftBench();
		
		registerBlock(woodcraftBench);
		
		GameRegistry.registerTileEntity(WoodcraftBenchEntity.class, MaterialCraft.MODID + "_woodcraft_bench_tile_entity");
	}
	
	private static void registerBlock(NameableBlock block) {
		GameRegistry.register(block.toBlock());
		GameRegistry.register(block.toItem());
	}
	
	public static void init(FMLInitializationEvent event) {
		registerRender(woodcraftBench);
	}
	
	private static void registerRender(NameableBlock block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().
				register(Item.getItemFromBlock(block.toBlock()), 0, 
				new ModelResourceLocation(MaterialCraft.MODID + ":" + block.getName(), "inventory"));
	}
	
}
