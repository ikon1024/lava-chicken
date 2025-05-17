package lavachicken.datagen;

import lavachicken.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.LAVA_CHICKEN)  // Fixed closing parenthesis
                .input(Items.CHICKEN)
                .input(Items.LAVA_BUCKET)
                .criterion("has_chicken", conditionsFromItem(Items.CHICKEN))
                .criterion("has_lava", conditionsFromItem(Items.LAVA_BUCKET))
                .offerTo(exporter);  // Fixed Identifier instantiation
    }
}
