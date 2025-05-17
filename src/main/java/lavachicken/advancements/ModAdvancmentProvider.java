package lavachicken.advancements;

import lavachicken.Lavachicken;
import lavachicken.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancmentProvider extends FabricAdvancementProvider {
    public ModAdvancmentProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry getLavaChicken = Advancement.Builder.create()
                .display(
                        ModItems.LAVA_CHICKEN,
                        Text.literal("Steve's lava chicken"),
                        Text.literal("Wanna know what happens when you mix hot lava and chicken?"),
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_lavachicken", InventoryChangedCriterion.Conditions.items(ModItems.LAVA_CHICKEN))
                .build(consumer, Lavachicken.MOD_ID + ":get_lava_chicken");
    }
}