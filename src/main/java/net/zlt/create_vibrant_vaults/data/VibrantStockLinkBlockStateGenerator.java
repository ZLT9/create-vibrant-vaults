package net.zlt.create_vibrant_vaults.data;

import com.simibubi.create.Create;
import com.simibubi.create.content.logistics.packagerLink.PackagerLinkBlock;
import com.simibubi.create.foundation.data.SpecialBlockStateGen;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import io.github.fabricators_of_create.porting_lib.models.generators.ModelFile;
import io.github.fabricators_of_create.porting_lib.models.generators.block.BlockModelBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.block.VibrantStockLinkBlock;
import net.zlt.create_vibrant_vaults.duck.ModelBuilderMixinDuck;

public class VibrantStockLinkBlockStateGenerator extends SpecialBlockStateGen {
    @Override
    protected int getXRotation(BlockState state) {
        return state.getValue(PackagerLinkBlock.FACE) == AttachFace.CEILING ? 180 : 0;
    }

    @Override
    protected int getYRotation(BlockState state) {
        return horizontalAngle(state.getValue(PackagerLinkBlock.FACING));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Block> ModelFile getModel(DataGenContext<Block, T> ctx, RegistrateBlockstateProvider prov, BlockState state) {
        if (!(state.getBlock() instanceof VibrantStockLinkBlock vibrantStockLink)) {
            throw new IllegalArgumentException("Invalid vibrant stock link");
        }

        String colorId = vibrantStockLink.color.asId();
        boolean horizontal = state.getValue(PackagerLinkBlock.FACE) == AttachFace.WALL;
        boolean powered = state.getValue(PackagerLinkBlock.POWERED);
        String variant = horizontal ? "block_horizontal" : "block_vertical";
        if (powered) {
            variant += "_powered";
        }
        BlockModelBuilder builder = prov.models().withExistingParent("block/" + colorId + "_stock_link/" + variant, CreateVibrantVaults.asResource("block/stock_link/template_" + variant));
        ((ModelBuilderMixinDuck<BlockModelBuilder>) builder).createVibrantVaults$uncheckedTexture("particle", Create.asResource("block/brass_casing"));
        builder
            .renderType("cutout")
            .customLoader(CompositeModelBuilder::begin)
            .child("base", new BlockModelBuilder(null, prov.models().existingFileHelper)
                .parent(prov.models().getExistingFile(CreateVibrantVaults.asResource("block/stock_link/template_block_" + (horizontal ? "horizontal" : "vertical") + "_base")))
                .texture("0", CreateVibrantVaults.asResource("block/stock_link/" + colorId + "/link_base_" + (powered ? "powered" : "unpowered")))
                .texture("1", CreateVibrantVaults.asResource("block/stock_link/" + colorId + "/link_details"))
                .texture("particle", CreateVibrantVaults.asResource("block/item_vault/" + colorId + "/vault_front_small")))
            .child("bulb", new BlockModelBuilder(null, prov.models().existingFileHelper)
                .parent(prov.models().getExistingFile(CreateVibrantVaults.asResource("block/stock_link/template_block_" + (horizontal ? "horizontal" : "vertical") + "_bulb")))
                .texture("1", CreateVibrantVaults.asResource("block/stock_link/" + colorId + "/link_details")));
        return builder;
    }
}
