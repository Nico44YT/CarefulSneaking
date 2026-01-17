package nico.carefulsneaking.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SweetBerryBushBlock.class)
public abstract class SweetBerryBushBlockMixin {

    //? >=1.21.1 {
    /*@WrapOperation(method = "onEntityCollision", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;damage(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/damage/DamageSource;F)Z"))
    public boolean careful_sneaking$onEntityCollision(Entity instance, ServerWorld serverWorld, DamageSource source, float amount, Operation<Boolean> original) {
        if(instance.isSneaking()) return false;
        return original.call(instance, serverWorld, source, amount);
    }
    *///?} else {
    @WrapOperation(method = "onEntityCollision", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"))
    public boolean careful_sneaking$onEntityCollision(Entity instance, DamageSource source, float amount, Operation<Boolean> original) {
        if(instance.isSneaking()) return false;
        return original.call(instance, source, amount);
    }
    //?}

}