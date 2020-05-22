package supercoder79.endbiomeapi.impl;

import net.minecraft.world.biome.layer.ScaleLayer;
import net.minecraft.world.biome.layer.type.ParentedLayer;
import net.minecraft.world.biome.layer.util.*;
import net.minecraft.world.biome.source.BiomeLayerSampler;

import java.util.function.LongFunction;

public class EndBiomeLayers {
    private static <T extends LayerSampler, C extends LayerSampleContext<T>> LayerFactory<T> stack(long seed, ParentedLayer layer, LayerFactory<T> parent, int count, LongFunction<C> contextProvider) {
        LayerFactory<T> layerFactory = parent;

        for(int i = 0; i < count; ++i) {
            layerFactory = layer.create(contextProvider.apply(seed + (long)i), layerFactory);
        }

        return layerFactory;
    }

    private static <T extends LayerSampler, C extends LayerSampleContext<T>> LayerFactory<T>[] build(LongFunction<C> contextProvider) {
        LayerFactory<T> barrensPicker = new BiomePickerLayer(EndBiomeImpl.barrensPicker).create(contextProvider.apply(1L));
        barrensPicker = stack(5L, ScaleLayer.NORMAL, barrensPicker, 6, contextProvider);

        LayerFactory<T> islandsPicker = new BiomePickerLayer(EndBiomeImpl.islandsPicker).create(contextProvider.apply(1L));
        islandsPicker = stack(5L, ScaleLayer.NORMAL, islandsPicker, 6, contextProvider);

        LayerFactory<T> midlandsPicker = new BiomePickerLayer(EndBiomeImpl.midlandsPicker).create(contextProvider.apply(1L));
        midlandsPicker = stack(5L, ScaleLayer.NORMAL, midlandsPicker, 6, contextProvider);

        LayerFactory<T> highlandsPicker = new BiomePickerLayer(EndBiomeImpl.highlandsPicker).create(contextProvider.apply(1L));
        highlandsPicker = stack(5L, ScaleLayer.NORMAL, highlandsPicker, 6, contextProvider);

        return new LayerFactory[]{barrensPicker, islandsPicker, midlandsPicker, highlandsPicker};
    }

    public static BiomeLayerSampler[] build(long seed) {
        LayerFactory<CachingLayerSampler>[] factories = build((salt) -> new CachingLayerContext(25, seed, salt));
        return new BiomeLayerSampler[]{
                new BiomeLayerSampler(factories[0]),
                new BiomeLayerSampler(factories[1]),
                new BiomeLayerSampler(factories[2]),
                new BiomeLayerSampler(factories[3])};
    }
}
