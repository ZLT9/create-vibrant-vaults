package net.zlt.create_vibrant_vaults.mixin;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.NbtPredicate;
import net.minecraft.tags.TagKey;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.crafting.Ingredient;
import net.zlt.create_vibrant_vaults.duck.ItemPredicateMixinDuck;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Set;

@Mixin(ItemPredicate.class)
public abstract class ItemPredicateMixin implements ItemPredicateMixinDuck {
    @Unique
    private Ingredient createVibrantVaults$ingredient;

    @Unique
    @Override
    public void createVibrantVaults$setIngredient(Ingredient ingredient) {
        createVibrantVaults$ingredient = ingredient;
    }

    @Inject(method = "<init>()V", at = @At("TAIL"))
    private void createVibrantVaults$initIngredient(CallbackInfo ci) {
        createVibrantVaults$ingredient = null;
    }

    @Inject(method = "<init>(Lnet/minecraft/tags/TagKey;Ljava/util/Set;Lnet/minecraft/advancements/critereon/MinMaxBounds$Ints;Lnet/minecraft/advancements/critereon/MinMaxBounds$Ints;[Lnet/minecraft/advancements/critereon/EnchantmentPredicate;[Lnet/minecraft/advancements/critereon/EnchantmentPredicate;Lnet/minecraft/world/item/alchemy/Potion;Lnet/minecraft/advancements/critereon/NbtPredicate;)V", at = @At("TAIL"))
    private void createVibrantVaults$initIngredient(TagKey<Item> tag, Set<Item> items, MinMaxBounds.Ints count, MinMaxBounds.Ints durability, EnchantmentPredicate[] enchantments, EnchantmentPredicate[] storedEnchantments, Potion potion, NbtPredicate nbt, CallbackInfo ci) {
        createVibrantVaults$ingredient = null;
    }

    @Inject(method = "matches", at = @At("HEAD"), cancellable = true)
    private void createVibrantVaults$testIngredient(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (createVibrantVaults$ingredient != null && !createVibrantVaults$ingredient.test(stack)) {
            cir.setReturnValue(false);
        }
    }

    @ModifyExpressionValue(method = "fromJson", at = @At(value = "NEW", target = "(Lnet/minecraft/tags/TagKey;Ljava/util/Set;Lnet/minecraft/advancements/critereon/MinMaxBounds$Ints;Lnet/minecraft/advancements/critereon/MinMaxBounds$Ints;[Lnet/minecraft/advancements/critereon/EnchantmentPredicate;[Lnet/minecraft/advancements/critereon/EnchantmentPredicate;Lnet/minecraft/world/item/alchemy/Potion;Lnet/minecraft/advancements/critereon/NbtPredicate;)Lnet/minecraft/advancements/critereon/ItemPredicate;"))
    private static ItemPredicate createVibrantVaults$readIngredient(ItemPredicate original, @Local(argsOnly = true) JsonElement el) {
        JsonObject ingredient = GsonHelper.getAsJsonObject((JsonObject) el, "createVibrantVaults:ingredient", null);
        if (ingredient != null) {
            ((ItemPredicateMixinDuck) original).createVibrantVaults$setIngredient(Ingredient.fromJson(ingredient));
        }
        return original;
    }

    @Inject(method = "serializeToJson", at = @At(value = "RETURN", ordinal = 1))
    private void createVibrantVaults$writeIngredient(CallbackInfoReturnable<JsonElement> cir, @Local JsonObject jsonObject) {
        if (createVibrantVaults$ingredient != null) {
            jsonObject.add("createVibrantVaults:ingredient", createVibrantVaults$ingredient.toJson());
        }
    }
}
