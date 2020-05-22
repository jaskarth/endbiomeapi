package supercoder79.endbiomeapi.mixin;

import net.minecraft.util.math.noise.SimplexNoiseSampler;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.source.BiomeLayerSampler;
import net.minecraft.world.biome.source.TheEndBiomeSource;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import supercoder79.endbiomeapi.impl.EndBiomeLayers;

@Mixin(TheEndBiomeSource.class)
public class MixinEndBiomeSource {
    @Shadow @Final private SimplexNoiseSampler noise;

    @Unique
    private BiomeLayerSampler barrensSampler;

    @Unique
    private BiomeLayerSampler islandsSampler;

    @Unique
    private BiomeLayerSampler midlandsSampler;

    @Unique
    private BiomeLayerSampler highlandsSampler;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void hookConstructor(long seed, CallbackInfo ci) {
        BiomeLayerSampler[] samplers = EndBiomeLayers.build(seed);
        barrensSampler = samplers[0];
        islandsSampler = samplers[1];
        midlandsSampler = samplers[2];
        highlandsSampler = samplers[3];
    }

    /**
     * @author SuperCoder79
     */
    @Overwrite
    public Biome getBiomeForNoiseGen(int biomeX, int biomeY, int biomeZ) {
        int i = biomeX >> 2;
        int j = biomeZ >> 2;
        if ((long)i * (long)i + (long)j * (long)j <= 4096L) {
            return Biomes.THE_END;
        } else {
            float f = TheEndBiomeSource.getNoiseAt(this.noise, i * 2 + 1, j * 2 + 1);
            if (f > 40.0F) {
                return highlandsSampler.sample(biomeX, biomeZ);
            } else if (f >= 0.0F) {
                return midlandsSampler.sample(biomeX, biomeZ);
            } else {
                return f < -20.0F ? islandsSampler.sample(biomeX, biomeZ) : barrensSampler.sample(biomeX, biomeZ);
            }
        }
    }
}
