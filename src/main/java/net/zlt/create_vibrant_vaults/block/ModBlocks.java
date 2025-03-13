package net.zlt.create_vibrant_vaults.block;

import com.simibubi.create.AllMountedStorageTypes;
import com.simibubi.create.Create;
import com.simibubi.create.content.logistics.packagePort.PackagePortItem;
import com.simibubi.create.content.logistics.packagerLink.LogisticallyLinkedBlockItem;
import com.simibubi.create.content.logistics.redstoneRequester.RedstoneRequesterBlockItem;
import com.simibubi.create.content.logistics.vault.ItemVaultBlock;
import com.simibubi.create.content.logistics.vault.ItemVaultItem;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.createmod.catnip.lang.Lang;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.zlt.create_vibrant_vaults.CreateVibrantVaults;
import net.zlt.create_vibrant_vaults.ct.HorizontalVaultCTBehaviour;
import net.zlt.create_vibrant_vaults.ct.VerticalVaultCTBehaviour;
import net.zlt.create_vibrant_vaults.data.VibrantPackagerBlockStateGenerator;
import net.zlt.create_vibrant_vaults.data.VibrantStockLinkBlockStateGenerator;
import net.zlt.create_vibrant_vaults.item.ModCreativeModeTabs;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;

import static com.simibubi.create.api.contraption.storage.item.MountedItemStorageType.mountedItemStorage;
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

public final class ModBlocks {
    private ModBlocks() {
    }

    static {
        CreateVibrantVaults.REGISTRATE.setCreativeTab(ModCreativeModeTabs.BASE_CREATIVE_TAB);
    }

    /**
     * Same order as {@link DyeColor} from white to black.
     */
    public enum VibrantVaultColor implements StringRepresentable {
        WHITE(DyeColor.WHITE.getMapColor()),
        ORANGE(DyeColor.ORANGE.getMapColor()),
        MAGENTA(DyeColor.MAGENTA.getMapColor()),
        LIGHT_BLUE(DyeColor.LIGHT_BLUE.getMapColor()),
        YELLOW(DyeColor.YELLOW.getMapColor()),
        LIME(DyeColor.LIME.getMapColor()),
        PINK(DyeColor.PINK.getMapColor()),
        GRAY(DyeColor.GRAY.getMapColor()),
        LIGHT_GRAY(DyeColor.LIGHT_GRAY.getMapColor()),
        CYAN(DyeColor.CYAN.getMapColor()),
        PURPLE(DyeColor.PURPLE.getMapColor()),
        BLUE(DyeColor.BLUE.getMapColor()),
        BROWN(DyeColor.BROWN.getMapColor()),
        GREEN(DyeColor.GREEN.getMapColor()),
        RED(DyeColor.RED.getMapColor()),
        BLACK(DyeColor.BLACK.getMapColor()),
        BASE(MapColor.TERRACOTTA_BLUE);

        @SuppressWarnings("deprecation")
        public static final StringRepresentable.EnumCodec<VibrantVaultColor> CODEC = StringRepresentable.fromEnum(VibrantVaultColor::values);
        private static final IntFunction<VibrantVaultColor> BY_ID = ByIdMap.continuous(Enum::ordinal, values(), ByIdMap.OutOfBoundsStrategy.ZERO);

        public final MapColor mapColor;

        VibrantVaultColor(MapColor mapColor) {
            this.mapColor = mapColor;
        }

        public String asId() {
            return Lang.asId(name());
        }

        public static VibrantVaultColor byId(int id) {
            return BY_ID.apply(id);
        }

        public static VibrantVaultColor byName(String name) {
            return CODEC.byName(name, BASE);
        }

        @Override
        public String getSerializedName() {
            return asId();
        }
    }

    public enum VibrantVaultType {
        ITEM_VAULT,
        SHIPPING_CONTAINER,
        BASIC_SHIPPING_CONTAINER;

        public String asId(boolean vertical) {
            String id = Lang.asId(name());
            return vertical ? "vertical_" + id : id;
        }
    }

    public static final List<List<BlockEntry<VibrantVaultBlock>>> VIBRANT_VAULTS = getVibrantVaults();
    public static final List<BlockEntry<VibrantFrogportBlock>> VIBRANT_FROGPORTS = getVibrantFrogports();
    public static final List<BlockEntry<VibrantStockLinkBlock>> VIBRANT_STOCK_LINKS = getVibrantStockLinks();
    public static final List<BlockEntry<VibrantRedstoneRequesterBlock>> VIBRANT_REDSTONE_REQUESTERS = getVibrantRedstoneRequesters();
    public static final List<BlockEntry<VibrantPackagerBlock>> VIBRANT_PACKAGERS = getVibrantPackagers();

    public static BlockEntry<VibrantVaultBlock> getVibrantVault(VibrantVaultType type, VibrantVaultColor color, boolean vertical) {
        return VIBRANT_VAULTS.get(type.ordinal() * 2 + (vertical ? 1 : 0)).get(color.ordinal());
    }

    public static BlockEntry<VibrantFrogportBlock> getVibrantFrogport(VibrantVaultColor color) {
        return VIBRANT_FROGPORTS.get(color.ordinal());
    }

    public static BlockEntry<VibrantStockLinkBlock> getVibrantStockLink(VibrantVaultColor color) {
        return VIBRANT_STOCK_LINKS.get(color.ordinal());
    }

    public static BlockEntry<VibrantRedstoneRequesterBlock> getVibrantRedstoneRequester(VibrantVaultColor color) {
        return VIBRANT_REDSTONE_REQUESTERS.get(color.ordinal());
    }

    public static BlockEntry<VibrantPackagerBlock> getVibrantPackager(VibrantVaultColor color) {
        return VIBRANT_PACKAGERS.get(color.ordinal());
    }

    private static NonNullBiConsumer<DataGenContext<Block, VibrantVaultBlock>, RegistrateBlockstateProvider> vibrantVaultBlockState(String blockName, String typeId, String colorId, boolean vertical) {
        return vertical ?
            (c, p) -> p.simpleBlock(c.get(), p.models()
                .withExistingParent(blockName, CreateVibrantVaults.asResource("block/template_vertical_item_vault"))
                .texture("top", p.modLoc("block/" + typeId + "/" + colorId + "/vault_top_small"))
                .texture("side", p.modLoc("block/" + typeId + "/" + colorId + "/vault_side_small"))
            ) :
            (c, p) -> p.getVariantBuilder(c.get())
                .forAllStates(s -> ConfiguredModel.builder()
                    .modelFile(p.models()
                        .getBuilder(blockName).parent(new ModelFile.UncheckedModelFile(Create.asResource("block/item_vault")))
                        .texture("0", p.modLoc("block/" + typeId + "/" + colorId + "/vault_bottom_small"))
                        .texture("1", p.modLoc("block/" + typeId + "/" + colorId + "/vault_front_small"))
                        .texture("2", p.modLoc("block/" + typeId + "/" + colorId + "/vault_side_small"))
                        .texture("3", p.modLoc("block/" + typeId + "/" + colorId + "/vault_top_small"))
                        .texture("particle", p.modLoc("block/" + typeId + "/" + colorId + "/vault_top_small"))
                    )
                    .rotationY(s.getValue(ItemVaultBlock.HORIZONTAL_AXIS) == Direction.Axis.X ? 90 : 0)
                    .build()
                );
    }

    private static BlockEntry<VibrantVaultBlock> vibrantVault(VibrantVaultType type, VibrantVaultColor color, boolean vertical) {
        String typeId = type.asId(vertical);
        String colorId = color.asId();
        String blockName = color == VibrantVaultColor.BASE ? typeId : colorId + "_" + typeId;
        return CreateVibrantVaults.REGISTRATE.block(blockName, properties -> vertical ? new VerticalVaultBlock(type, color, properties) : new HorizontalVaultBlock(type, color, properties))
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p
                .mapColor(color.mapColor)
                .sound(SoundType.NETHERITE_BLOCK)
                .explosionResistance(1200)
            )
            .transform(pickaxeOnly())
            .blockstate(vibrantVaultBlockState(blockName, typeId, colorId, vertical))
            .onRegister(connectedTextures(() -> vertical ? new VerticalVaultCTBehaviour(type, color) : new HorizontalVaultCTBehaviour(type, color)))
            .transform(mountedItemStorage(AllMountedStorageTypes.VAULT))
            .item(ItemVaultItem::new)
            .build()
            .register();
    }

    @SuppressWarnings("removal")
    private static BlockEntry<VibrantFrogportBlock> vibrantFrogport(VibrantVaultColor color) {
        return CreateVibrantVaults.REGISTRATE.block(color.asId() + "_package_frogport", properties -> new VibrantFrogportBlock(color, properties))
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p
                .noOcclusion()
                .mapColor(color.mapColor)
                .sound(SoundType.NETHERITE_BLOCK)
            )
            .transform(pickaxeOnly())
            .addLayer(() -> RenderType::cutoutMipped)
            .blockstate((c, p) -> p.simpleBlock(c.getEntry(), new ModelFile.UncheckedModelFile(p.modLoc("block/" + c.getName() + "/block"))))
            .item(PackagePortItem::new)
            .model(AssetLookup::customItemModel)
            .build()
            .register();
    }

    private static BlockEntry<VibrantStockLinkBlock> vibrantStockLink(VibrantVaultColor color) {
        return CreateVibrantVaults.REGISTRATE.block(color.asId() + "_stock_link", properties -> new VibrantStockLinkBlock(color, properties))
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p
                .mapColor(color.mapColor)
                .sound(SoundType.NETHERITE_BLOCK)
            )
            .transform(pickaxeOnly())
            .blockstate(new VibrantStockLinkBlockStateGenerator()::generate)
            .item(LogisticallyLinkedBlockItem::new)
            .transform(customItemModel("_", "block_vertical"))
            .register();
    }

    private static BlockEntry<VibrantRedstoneRequesterBlock> vibrantRedstoneRequester(VibrantVaultColor color) {
        return CreateVibrantVaults.REGISTRATE.block(color.asId() + "_redstone_requester", properties -> new VibrantRedstoneRequesterBlock(color, properties))
            .initialProperties(SharedProperties::stone)
            .properties(p -> p
                .sound(SoundType.NETHERITE_BLOCK)
                .noOcclusion()
            )
            .transform(pickaxeOnly())
            .blockstate((c, p) -> BlockStateGen.horizontalAxisBlock(c, p, state -> state.getValue(BlockStateProperties.POWERED) ? new ModelFile.UncheckedModelFile(p.modLoc("block/" + c.getName() + "/block_powered")) : new ModelFile.UncheckedModelFile(p.modLoc("block/" + c.getName() + "/block"))))
            .item(RedstoneRequesterBlockItem::new)
            .transform(customItemModel("_", "block"))
            .register();
    }

    @SuppressWarnings("removal")
    private static BlockEntry<VibrantPackagerBlock> vibrantPackager(VibrantVaultColor color) {
        return CreateVibrantVaults.REGISTRATE.block(color.asId() + "_packager", properties -> new VibrantPackagerBlock(color, properties))
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p
                .noOcclusion()
                .isRedstoneConductor(($1, $2, $3) -> false)
                .mapColor(color.mapColor)
                .sound(SoundType.NETHERITE_BLOCK)
            )
            .transform(pickaxeOnly())
            .addLayer(() -> RenderType::cutoutMipped)
            .blockstate(new VibrantPackagerBlockStateGenerator()::generate)
            .item()
            .model(AssetLookup::customItemModel)
            .build()
            .register();
    }

    private static List<List<BlockEntry<VibrantVaultBlock>>> getVibrantVaults() {
        VibrantVaultColor[] colors = VibrantVaultColor.values();
        VibrantVaultType[] types = VibrantVaultType.values();
        List<List<BlockEntry<VibrantVaultBlock>>> result = new ArrayList<>(types.length * 2);
        for (VibrantVaultType type : types) {
            boolean includeBaseColor = type != VibrantVaultType.ITEM_VAULT;
            List<BlockEntry<VibrantVaultBlock>> horizontalVaults = new ArrayList<>(includeBaseColor ? colors.length : colors.length - 1);
            List<BlockEntry<VibrantVaultBlock>> verticalVaults = new ArrayList<>(colors.length);
            for (VibrantVaultColor color : colors) {
                if (color != VibrantVaultColor.BASE || includeBaseColor) {
                    horizontalVaults.add(color.ordinal(), vibrantVault(type, color, false));
                }
                verticalVaults.add(color.ordinal(), vibrantVault(type, color, true));
            }
            result.add(type.ordinal() * 2, horizontalVaults);
            result.add(type.ordinal() * 2 + 1, verticalVaults);
        }
        return result;
    }

    private static List<BlockEntry<VibrantFrogportBlock>> getVibrantFrogports() {
        VibrantVaultColor[] colors = VibrantVaultColor.values();
        List<BlockEntry<VibrantFrogportBlock>> result = new ArrayList<>(colors.length - 1);
        for (VibrantVaultColor color : colors) {
            if (color != VibrantVaultColor.BASE) {
                result.add(color.ordinal(), vibrantFrogport(color));
            }
        }
        return result;
    }

    private static List<BlockEntry<VibrantStockLinkBlock>> getVibrantStockLinks() {
        VibrantVaultColor[] colors = VibrantVaultColor.values();
        List<BlockEntry<VibrantStockLinkBlock>> result = new ArrayList<>(colors.length - 1);
        for (VibrantVaultColor color : colors) {
            if (color != VibrantVaultColor.BASE) {
                result.add(color.ordinal(), vibrantStockLink(color));
            }
        }
        return result;
    }

    private static List<BlockEntry<VibrantRedstoneRequesterBlock>> getVibrantRedstoneRequesters() {
        VibrantVaultColor[] colors = VibrantVaultColor.values();
        List<BlockEntry<VibrantRedstoneRequesterBlock>> result = new ArrayList<>(colors.length - 1);
        for (VibrantVaultColor color : colors) {
            if (color != VibrantVaultColor.BASE) {
                result.add(color.ordinal(), vibrantRedstoneRequester(color));
            }
        }
        return result;
    }

    private static List<BlockEntry<VibrantPackagerBlock>> getVibrantPackagers() {
        VibrantVaultColor[] colors = VibrantVaultColor.values();
        List<BlockEntry<VibrantPackagerBlock>> result = new ArrayList<>(colors.length - 1);
        for (VibrantVaultColor color : colors) {
            if (color != VibrantVaultColor.BASE) {
                result.add(color.ordinal(), vibrantPackager(color));
            }
        }
        return result;
    }

    public static void init() {
    }
}
