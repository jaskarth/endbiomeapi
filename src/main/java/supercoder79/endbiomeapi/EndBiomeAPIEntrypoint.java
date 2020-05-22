package supercoder79.endbiomeapi;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.biome.Biomes;
import supercoder79.endbiomeapi.api.EndBiomeAPI;

public class EndBiomeAPIEntrypoint implements ModInitializer {
    @Override
    public void onInitialize() {
        // add default end biomes
        EndBiomeAPI.addBarrensBiome(Biomes.END_BARRENS, 1.0);
        EndBiomeAPI.addIslandsBiome(Biomes.SMALL_END_ISLANDS, 1.0);
        EndBiomeAPI.addMidlandsBiome(Biomes.END_MIDLANDS, 1.0);
        EndBiomeAPI.addHighlandsBiome(Biomes.END_HIGHLANDS, 1.0);
    }
}
