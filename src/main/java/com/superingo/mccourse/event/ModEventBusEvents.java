package com.superingo.mccourse.event;

import com.superingo.mccourse.MCCourseMod;
import com.superingo.mccourse.event.loot.DowsingRodInIglooAdditionModifier;
import com.superingo.mccourse.event.loot.TurnipSeedsFromGrassAdditionModifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = MCCourseMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
     @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                   event) {
         event.getRegistry().registerAll(
                 new TurnipSeedsFromGrassAdditionModifier.Serializer().setRegistryName
                         (new ResourceLocation(MCCourseMod.MOD_ID, "turnip_seeds_from_grass")),
                 new DowsingRodInIglooAdditionModifier.Serializer().setRegistryName
                         (new ResourceLocation(MCCourseMod.MOD_ID, "dowsing_rod_in_igloo"))
         );
     }
}
