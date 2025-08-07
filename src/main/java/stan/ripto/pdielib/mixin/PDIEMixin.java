package stan.ripto.pdielib.mixin;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.ForgeEventFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

@Mixin(ToolDamageUtil.class)
public class PDIEMixin {
    @Inject(
            method = "damageAnimated(Lslimeknights/tconstruct/library/tools/nbt/IToolStackView;ILnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/InteractionHand;)Z",
            at = @At("RETURN"),
            remap = false
    )
    private static void callPlayerDestroyItemEvent(IToolStackView tool, int amount, LivingEntity entity, InteractionHand hand, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValue()) return;

        if (entity instanceof Player player) {
            ForgeEventFactory.onPlayerDestroyItem(player, player.getItemInHand(hand), hand);
        }
    }
}
