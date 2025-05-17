package lavachicken.item;

import lavachicken.Lavachicken;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item LAVA_CHICKEN = registerItem("lava_chicken", new Item(new Item.Settings()
            .food(ModFoodComponents.LAVA_CHICKEN)
            .fireproof()
            .rarity(Rarity.COMMON)
    ));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Lavachicken.MOD_ID, name), item);
    }
    public static void registerModItems() {
        Lavachicken.LOGGER.info("Registering Mod Items for " + Lavachicken.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(LAVA_CHICKEN);
        });
    }

    public static void register() {
    }
}