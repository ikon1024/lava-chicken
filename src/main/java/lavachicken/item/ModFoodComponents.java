package lavachicken.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent LAVA_CHICKEN = new FoodComponent.Builder()
            .nutrition(6)
            .saturationModifier(1.0f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1000, 0), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1000, 2), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1000, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1000, 1), 1.0f)
            .snack()
            .build();
}
