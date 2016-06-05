package com.phoenixkahlo.materialcraft;

import java.util.Random;

import com.phoenixkahlo.materialcraft.block.BlockManager;
import com.phoenixkahlo.materialcraft.item.ItemManager;
import com.phoenixkahlo.materialcraft.modifications.ModificationManager;
import com.phoenixkahlo.materialcraft.recipe.RecipeManager;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MaterialCraft.MODID, version = MaterialCraft.VERSION)
public class MaterialCraft {
	
	public static final String MODID = "materialcraft";
	public static final String VERSION = "1.0.0";

	public static final Random RANDOM = new Random();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ItemManager.preInit(event);
		BlockManager.preInit(event);
		RecipeManager.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		ItemManager.init(event);
		ModificationManager.init(event);
		BlockManager.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {		
		RecipeManager.postInit(event);
	}

}
