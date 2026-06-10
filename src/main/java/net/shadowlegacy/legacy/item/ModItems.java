package net.shadowlegacy.legacy.item;

import net.shadowlegacy.legacy.Legacy;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Legacy.MOD_ID);

    public static final DeferredItem<Item> CLOUD = ITEMS.registerSimpleItem("cloud");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
