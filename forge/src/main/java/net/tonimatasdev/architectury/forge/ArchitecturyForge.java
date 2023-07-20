package net.tonimatasdev.architectury.forge;

import dev.architectury.platform.forge.EventBuses;
import net.tonimatasdev.architectury.Example;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Example.MOD_ID)
public class ArchitecturyForge {
    public ArchitecturyForge() {
		// Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Example.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
            Example.init();
    }
}