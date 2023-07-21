package example.example.example.forge;

import dev.architectury.platform.forge.EventBuses;
import example.example.example.Example;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Example.MOD_ID)
public class ExampleForge {
    public ExampleForge() {
		// Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Example.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Example.init();
    }
}