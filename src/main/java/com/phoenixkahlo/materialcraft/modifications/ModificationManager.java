package com.phoenixkahlo.materialcraft.modifications;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ModificationManager {

	public static void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new DropHandler());
	}
	
}
