package example.example.example.forge;

import example.example.example.Example;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Example.MOD_ID)
public class ExampleNeoForge {
    public ExampleNeoForge() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        Example.init();
        eventBus.register(this);
    }
}