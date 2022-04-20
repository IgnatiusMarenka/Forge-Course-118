package com.superingo.mccourse.block.custom;

import com.superingo.mccourse.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BeetrootBlock;

public class TurnipCropBlock extends BeetrootBlock {

    public TurnipCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.TURNIP_SEEDS.get();
    }
}
