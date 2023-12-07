package example.example.example.forge;

import example.example.example.Example;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Example.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExampleClientNeoForge {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {

    }
}
