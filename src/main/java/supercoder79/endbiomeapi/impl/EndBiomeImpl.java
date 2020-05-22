package supercoder79.endbiomeapi.impl;

import net.minecraft.world.biome.Biome;

public class EndBiomeImpl {
    public static BiomePicker barrensPicker = new BiomePicker();
    public static BiomePicker islandsPicker = new BiomePicker();
    public static BiomePicker midlandsPicker = new BiomePicker();
    public static BiomePicker highlandsPicker = new BiomePicker();

    public static void addBarrensBiome(Biome biome, double weight) {
        add(barrensPicker, biome, weight);
    }

    public static void addIslandsBiome(Biome biome, double weight) {
        add(islandsPicker, biome, weight);
    }

    public static void addMidlandsBiome(Biome biome, double weight) {
        add(midlandsPicker, biome, weight);
    }

    public static void addHighlandsBiome(Biome biome, double weight) {
        add(highlandsPicker, biome, weight);
    }

    private static void add(BiomePicker picker, Biome biome, double weight) {
        picker.add(biome, weight);
    }
}
