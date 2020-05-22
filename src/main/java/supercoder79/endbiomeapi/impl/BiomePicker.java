package supercoder79.endbiomeapi.impl;

import com.google.common.collect.Lists;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

import java.util.List;

public class BiomePicker {
    private final List<Entry> biomeEntries = Lists.newArrayList();
    private double weightTotal;

    public Integer choose(LayerRandomnessSource rand) {
        if (biomeEntries.size() == 0) {
            throw new UnsupportedOperationException("No biomes registered for picker!!! This is a problem!");
        }

        double randVal = target(rand);
        int i = -1;

        while (randVal >= 0) {
            ++i;
            randVal -= biomeEntries.get(i).weight;
        }
        return Registry.BIOME.getRawId(biomeEntries.get(i).getBiome());
    }

    public void add(Biome biome, double weight) {
        this.biomeEntries.add(new Entry(biome, weight));
        weightTotal += weight;
    }

    private double target(LayerRandomnessSource random) {
        return (double) random.nextInt(Integer.MAX_VALUE) * weightTotal / Integer.MAX_VALUE;
    }

    private static class Entry {
        private final Biome biome;
        private final double weight;
        private Entry(Biome biome, double weight) {
            this.biome = biome;
            this.weight = weight;
        }

        private Biome getBiome() {
            return biome;
        }
    }
}
