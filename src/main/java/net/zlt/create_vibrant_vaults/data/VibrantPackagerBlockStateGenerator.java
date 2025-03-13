package net.zlt.create_vibrant_vaults.data;

import com.simibubi.create.Create;
import com.simibubi.create.content.logistics.packager.PackagerBlock;
import com.simibubi.create.foundation.data.SpecialBlockStateGen;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.block.VibrantPackagerBlock;
import net.zlt.create_vibrant_vaults.duck.ModelBuilderMixinDuck;

public class VibrantPackagerBlockStateGenerator extends SpecialBlockStateGen {
    @Override
    protected int getXRotation(BlockState state) {
        return 0;
    }

    @Override
    protected int getYRotation(BlockState state) {
        return horizontalAngle(state.getValue(PackagerBlock.FACING));
    }

    @Override
    public <T extends Block> ModelFile getModel(DataGenContext<Block, T> ctx, RegistrateBlockstateProvider prov, BlockState state) {
        if (!(state.getBlock() instanceof VibrantPackagerBlock vibrantPackager)) {
            throw new IllegalArgumentException("Invalid vibrant packager");
        }

        String colorId = vibrantPackager.color.asId();
        boolean linked = state.getOptionalValue(PackagerBlock.LINKED).orElse(false);
        boolean powered = state.getValue(PackagerBlock.POWERED);
        return state.getValue(PackagerBlock.FACING).getAxis() == Direction.Axis.Y ? getVerticalModel(ctx, prov, linked, powered, colorId) : getHorizontalModel(ctx, prov, linked, powered, colorId);
    }

    @SuppressWarnings("unchecked")
    private <T extends Block> ModelFile getHorizontalModel(DataGenContext<Block, T> ctx, RegistrateBlockstateProvider prov, boolean linked, boolean powered, String colorId) {
        if (linked) {
            return prov.models()
                .getBuilder("block/" + ctx.getName() + "/block_linked")
                .parent(new ModelFile.UncheckedModelFile(CreateVibrantVaults.asResource("block/" + ctx.getName() + "/block")))
                .texture("2", CreateVibrantVaults.asResource("block/packager/" + colorId + "/packager_horizontal_linked"));
        }

        if (powered) {
            return prov.models()
                .getBuilder("block/" + ctx.getName() + "/block_powered")
                .parent(new ModelFile.UncheckedModelFile(CreateVibrantVaults.asResource("block/" + ctx.getName() + "/block")))
                .texture("2", CreateVibrantVaults.asResource("block/packager/" + colorId + "/packager_horizontal_powered"));
        }

        BlockModelBuilder builder = prov.models()
            .getBuilder("block/" + ctx.getName() + "/block")
            .parent(new ModelFile.UncheckedModelFile(Create.asResource("block/packager/block")));
        ((ModelBuilderMixinDuck<BlockModelBuilder>) builder).createVibrantVaults$uncheckedTexture("0", Create.asResource("block/packager_frame"));
        builder
            .texture("1", CreateVibrantVaults.asResource("block/packager/" + colorId + "/packager_details"))
            .texture("2", CreateVibrantVaults.asResource("block/packager/" + colorId + "/packager_horizontal_unpowered"))
            .texture("particle", CreateVibrantVaults.asResource("block/packager/" + colorId + "/packager_particle"));
        return builder;
    }

    @SuppressWarnings("unchecked")
    private <T extends Block> ModelFile getVerticalModel(DataGenContext<Block, T> ctx, RegistrateBlockstateProvider prov, boolean linked, boolean powered, String colorId) {
        if (linked) {
            return prov.models()
                .getBuilder("block/" + ctx.getName() + "/block_vertical_linked")
                .parent(new ModelFile.UncheckedModelFile(CreateVibrantVaults.asResource("block/" + ctx.getName() + "/block_vertical")))
                .texture("5", CreateVibrantVaults.asResource("block/packager/" + colorId + "/packager_vertical_linked"));
        }

        if (powered) {
            return prov.models()
                .getBuilder("block/" + ctx.getName() + "/block_vertical_powered")
                .parent(new ModelFile.UncheckedModelFile(CreateVibrantVaults.asResource("block/" + ctx.getName() + "/block_vertical")))
                .texture("5", CreateVibrantVaults.asResource("block/packager/" + colorId + "/packager_vertical_powered"));
        }

        BlockModelBuilder builder = prov.models()
            .getBuilder("block/" + ctx.getName() + "/block_vertical")
            .parent(new ModelFile.UncheckedModelFile(Create.asResource("block/packager/block_vertical")));
        ((ModelBuilderMixinDuck<BlockModelBuilder>) builder).createVibrantVaults$uncheckedTexture("0", Create.asResource("block/packager_frame"));
        builder
            .texture("1", CreateVibrantVaults.asResource("block/packager/" + colorId + "/packager_details"))
            .texture("5", CreateVibrantVaults.asResource("block/packager/" + colorId + "/packager_vertical_unpowered"))
            .texture("particle", CreateVibrantVaults.asResource("block/packager/" + colorId + "/packager_particle"));
        return builder;
    }
}
