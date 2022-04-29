package com.superingo.mccourse.potion;

import com.superingo.mccourse.MCCourseMod;
import com.superingo.mccourse.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.block.PotatoBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.lwjgl.system.CallbackI;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS
            =DeferredRegister.create(ForgeRegistries.POTIONS, MCCourseMod.MOD_ID);

    public static RegistryObject<Potion> FREEZE_POTION = POTIONS.register("freeze_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.FREEZE.get(), 200, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
