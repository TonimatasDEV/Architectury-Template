package example.example.example.forge;

import example.example.example.Example;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = Example.MOD_ID, value = Dist.DEDICATED_SERVER, bus = EventBusSubscriber.Bus.MOD)
public class ExampleServerNeoForge {
    @SubscribeEvent
    public static void onDedicatedServerSetup(FMLDedicatedServerSetupEvent event) {

    }
}

