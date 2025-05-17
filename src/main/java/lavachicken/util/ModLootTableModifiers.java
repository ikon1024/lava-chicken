package lavachicken.util;

import lavachicken.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.DamageSourcePropertiesLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.entity.DamageSourcePredicate;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier CHICKEN_ID = Identifier.of("minecraft", "entities/chicken");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) -> {
            if (CHICKEN_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(DamageSourcePropertiesLootCondition.builder(
                                DamageSourcePredicate.Builder.create()

                        ).build())
                        .with(ItemEntry.builder(ModItems.LAVA_CHICKEN));

                tableBuilder.pool(poolBuilder);
            }
        });
    }
}
