package net.shadowlegacy.legacy.util.property;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.threetag.palladium.event.PalladiumEvents;

import java.util.ArrayList;
import java.util.List;

public class PalladiumProperties {

    public static final PalladiumProperty<Integer> HEALTH = new IntegerProperty("health").sync(SyncType.EVERYONE);
    public static final PalladiumProperty<Float> SPEED = new FloatProperty("speed").sync(SyncType.EVERYONE);

    public static void init() {
        PalladiumEvents.REGISTER_PROPERTY.register(handler -> {
            if (handler.entity instanceof Player) {
                handler.register(HEALTH, 20);
                handler.register(SPEED, 0.1F)
            }
        });
    }
}
