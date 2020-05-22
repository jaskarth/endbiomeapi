package supercoder79.endbiomeapi.impl;

import net.minecraft.world.biome.layer.type.InitLayer;
import net.minecraft.world.biome.layer.util.IdentityCoordinateTransformer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

public class BiomePickerLayer implements InitLayer, IdentityCoordinateTransformer {
    private final BiomePicker picker;

    public BiomePickerLayer(BiomePicker picker) {
        this.picker = picker;
    }

    @Override
    public int sample(LayerRandomnessSource context, int x, int y) {
        return picker.choose(context);
    }
}
