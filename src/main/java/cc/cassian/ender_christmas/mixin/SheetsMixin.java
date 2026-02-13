package cc.cassian.ender_christmas.mixin;

import cc.cassian.ender_christmas.EnderChristmas;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.EnderChestBlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.client.renderer.Sheets.*;


@Mixin(Sheets.class)
public abstract class SheetsMixin {

	@Inject(cancellable = true, at = @At("RETURN"), method = "chooseMaterial(Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/world/level/block/state/properties/ChestType;Z)Lnet/minecraft/client/resources/model/Material;")
	private static void enderChristmas$chooseMaterial(BlockEntity blockEntity, ChestType chestType, boolean christmas, CallbackInfoReturnable<Material> cir) {
		if (EnderChristmas.CONFIG.christmasEveryday)
			christmas = true;
		if (blockEntity instanceof EnderChestBlockEntity && christmas) {
			cir.setReturnValue(new Material(CHEST_SHEET, ResourceLocation.tryBuild("ender_christmas", "entity/chest/ender_christmas")));
		}
		if (blockEntity instanceof ChestBlockEntity && christmas) {
			cir.setReturnValue(getChestTextureId(chestType, CHEST_XMAS_LOCATION, CHEST_XMAS_LOCATION_LEFT, CHEST_XMAS_LOCATION_RIGHT));
		}
	}

	private static Material getChestTextureId(ChestType type, Material single, Material left, Material right) {
		return switch (type) {
			case LEFT -> left;
			case RIGHT -> right;
			default -> single;
		};
	}

}
