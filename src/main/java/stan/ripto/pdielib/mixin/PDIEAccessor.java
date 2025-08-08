package stan.ripto.pdielib.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(LivingEntity.class)
public interface PDIEAccessor {
    @Invoker("getMainHandItem")
    ItemStack accessGetMainHandItem();
}
