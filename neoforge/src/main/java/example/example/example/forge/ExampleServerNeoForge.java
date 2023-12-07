package example.example.example.forge;

import example.example.example.Example;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent;

@Mod.EventBusSubscriber(modid = Example.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExampleServerNeoForge {
    @SubscribeEvent
    public static void onDedicatedServerSetup(FMLDedicatedServerSetupEvent event) {

    }
}

