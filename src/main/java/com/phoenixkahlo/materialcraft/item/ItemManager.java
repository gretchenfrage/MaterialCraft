package com.phoenixkahlo.materialcraft.item;

import com.phoenixkahlo.materialcraft.MaterialCraft;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class ItemManager {

	public static ToolMaterial primitive;
	
	public static BasicItem rock;
	public static BasicItem woodChunk;
	public static BasicItem grassTwine;
	public static BasicSword primitiveSword;
	public static BasicPickaxe primitivePickaxe;
	public static BasicShovel primitiveShovel;
	public static BasicAxe primitiveAxe;
	public static BasicHoe primitiveHoe;
	
	public static void preInit(FMLPreInitializationEvent event) {
		primitive = EnumHelper.addToolMaterial("primitive", 1, 60, 1.8f, 0.5f, 0);
		
		rock = new BasicItem("rock", CreativeTabs.MISC);
		woodChunk = new BasicItem("woodchunk", CreativeTabs.MISC);
		grassTwine = new BasicItem("grasstwine", CreativeTabs.MISC);
		primitiveSword = new BasicSword("primitivesword", primitive);
		primitivePickaxe = new BasicPickaxe("primitivepickaxe", primitive);
		primitiveShovel = new BasicShovel("primitiveshovel", primitive);
		primitiveAxe = new BasicAxe("primitiveaxe", primitive);
		primitiveHoe = new BasicHoe("primitivehoe", primitive);
		
		GameRegistry.register(rock);
		GameRegistry.register(woodChunk);
		GameRegistry.register(grassTwine);
		GameRegistry.register(primitiveSword);
		GameRegistry.register(primitivePickaxe);
		GameRegistry.register(primitiveShovel);
		GameRegistry.register(primitiveAxe);
		GameRegistry.register(primitiveHoe);
	}
	
	public static void init(FMLInitializationEvent event) {
		if (event.getSide() == Side.CLIENT) {
			registerTexture(rock);
			registerTexture(woodChunk);
			registerTexture(grassTwine);
			registerTexture(primitiveSword);
			registerTexture(primitivePickaxe);
			registerTexture(primitiveShovel);
			registerTexture(primitiveAxe);
			registerTexture(primitiveHoe);
		}
	}
	
	private static void registerTexture(NameableItem item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
				.register(item.toItem(), 0, new ModelResourceLocation(MaterialCraft.MODID + 
				":" + item.getName(), "inventory"));
	}
	
}
