package supercoder79.endbiomeapi.api;

import net.minecraft.world.biome.Biome;
import supercoder79.endbiomeapi.impl.EndBiomeImpl;

/**
 * API to add new end biomes to the End.
 *
 * @author SuperCoder79
 */
public final class EndBiomeAPI {
    private EndBiomeAPI() {

    }

    /**
     * Adds a biome to the barrens biome region.
     * @param biome The biome to add.
     * @param weight The weight of this biome.
     */
    public static void addBarrensBiome(Biome biome, double weight) {
        EndBiomeImpl.addBarrensBiome(biome, weight);
    }

    /**
     * Adds a biome to the islands biome region.
     * @param biome The biome to add.
     * @param weight The weight of this biome.
     */
    public static void addIslandsBiome(Biome biome, double weight) {
        EndBiomeImpl.addIslandsBiome(biome, weight);
    }

    /**
     * Adds a biome to the midlands biome region.
     * @param biome The biome to add.
     * @param weight The weight of this biome.
     */
    public static void addMidlandsBiome(Biome biome, double weight) {
        EndBiomeImpl.addMidlandsBiome(biome, weight);
    }

    /**
     * Adds a biome to the highlands biome region.
     * @param biome The biome to add.
     * @param weight The weight of this biome.
     */
    public static void addHighlandsBiome(Biome biome, double weight) {
        EndBiomeImpl.addHighlandsBiome(biome, weight);
    }
}