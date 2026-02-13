package cc.cassian.ender_christmas.mixins;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.SpriteId;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.client.renderer.Sheets.*;
import static net.minecraft.client.renderer.blockentity.ChestRenderer.xmasTextures;


@Mixin(Sheets.class)
public abstract class SheetsMixin {

	@Inject(cancellable = true, at = @At("RETURN"), method = "chooseSprite(Lnet/minecraft/client/renderer/blockentity/state/ChestRenderState$ChestMaterialType;Lnet/minecraft/world/level/block/state/properties/ChestType;)Lnet/minecraft/client/resources/model/SpriteId;")
	private static void enderChristmas$chooseMaterial(ChestRenderState.ChestMaterialType variant, ChestType type, CallbackInfoReturnable<SpriteId> cir) {
		boolean christmas = xmasTextures();
		if (variant.equals(ChestRenderState.ChestMaterialType.ENDER_CHEST) && christmas) {
			cir.setReturnValue(CHEST_MAPPER.apply(Identifier.fromNamespaceAndPath("ender_christmas", "entity/chest/ender_christmas")));
		}
		if (variant.equals(ChestRenderState.ChestMaterialType.REGULAR) && christmas) {
			cir.setReturnValue(getChestTextureId(type, CHEST_XMAS_LOCATION, CHEST_XMAS_LOCATION_LEFT, CHEST_XMAS_LOCATION_RIGHT));
		}
	}

	private static SpriteId getChestTextureId(ChestType type, SpriteId single, SpriteId left, SpriteId right) {
        return switch (type) {
            case LEFT -> left;
            case RIGHT -> right;
            default -> single;
        };
	}


}
