package lavachicken.death;

import lavachicken.item.ModItems;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public class LavaChickenDeathHandler {
    public static void register() {
        ServerLivingEntityEvents.AFTER_DEATH.register(((livingEntity, damageSource) -> {
            // Check: Is this a ChickenEntity and is it on the server?
            if (!(livingEntity instanceof ChickenEntity) || livingEntity.getWorld().isClient()) return;


            if (isFireDamage(damageSource)) {
                livingEntity.dropStack(ItemStack.EMPTY);
                // Drop the lava chicken item at the death location
                ServerWorld world = (ServerWorld) livingEntity.getWorld();
                Vec3d pos = livingEntity.getPos();
                ItemStack drop = new ItemStack(ModItems.LAVA_CHICKEN);
                livingEntity.dropStack(drop, 0.0f);
            }
        }));
    }

    private static boolean isFireDamage(DamageSource source) {
        String name = source.getName(); // or getMsgId() in newer versions
        System.out.println(name);
        return name.equals("lava") || name.equals("in_fire") || name.equals("on_fire");
    }
}
