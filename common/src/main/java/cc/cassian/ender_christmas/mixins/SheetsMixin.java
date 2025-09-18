package cc.cassian.ender_christmas.mixins;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.state.ChestBlockEntityRenderState;
import net.minecraft.client.util.SpriteIdentifier;

import net.minecraft.util.Identifier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.client.render.TexturedRenderLayers.*;
import static net.minecraft.client.render.block.entity.ChestBlockEntityRenderer.isAroundChristmas;


@Environment(EnvType.CLIENT)
@Mixin(TexturedRenderLayers.class)
public abstract class SheetsMixin {

	@Inject(cancellable = true, at = @At("RETURN"), method = "getChestTextureId(Lnet/minecraft/client/render/block/entity/state/ChestBlockEntityRenderState$Variant;Lnet/minecraft/block/enums/ChestType;)Lnet/minecraft/client/util/SpriteIdentifier;")
	private static void enderChristmas$chooseMaterial(ChestBlockEntityRenderState.Variant variant, ChestType type, CallbackInfoReturnable<SpriteIdentifier> cir) {
		boolean christmas = isAroundChristmas();
		if (variant.equals(ChestBlockEntityRenderState.Variant.ENDER_CHEST) && christmas) {
			cir.setReturnValue(new SpriteIdentifier(CHEST_ATLAS_TEXTURE, Identifier.of("ender_christmas", "entity/chest/ender_christmas")));
		}
		if (variant.equals(ChestBlockEntityRenderState.Variant.REGULAR) && christmas) {
			cir.setReturnValue(getChestTextureId(type, CHRISTMAS_CHEST, CHRISTMAS_CHEST_LEFT, CHRISTMAS_CHEST_RIGHT));
		}
	}

	private static SpriteIdentifier getChestTextureId(ChestType type, SpriteIdentifier single, SpriteIdentifier left, SpriteIdentifier right) {
        return switch (type) {
            case LEFT -> left;
            case RIGHT -> right;
            default -> single;
        };
	}


}
