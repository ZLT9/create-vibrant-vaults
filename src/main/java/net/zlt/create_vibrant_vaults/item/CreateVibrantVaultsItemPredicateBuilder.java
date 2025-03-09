package net.zlt.create_vibrant_vaults.item;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.world.item.crafting.Ingredient;
import net.zlt.create_vibrant_vaults.duck.ItemPredicateMixinDuck;
import org.jetbrains.annotations.Nullable;

public class CreateVibrantVaultsItemPredicateBuilder extends ItemPredicate.Builder {
    @Nullable
    private Ingredient ingredient;

    private CreateVibrantVaultsItemPredicateBuilder() {
        super();
    }

    public static CreateVibrantVaultsItemPredicateBuilder create() {
        return new CreateVibrantVaultsItemPredicateBuilder();
    }

    public CreateVibrantVaultsItemPredicateBuilder ingredient(Ingredient ingredient) {
        this.ingredient = ingredient;
        return this;
    }

    @Override
    public ItemPredicate build() {
        ItemPredicate result = super.build();
        ((ItemPredicateMixinDuck) result).createVibrantVaults$setIngredient(ingredient);
        return result;
    }
}
