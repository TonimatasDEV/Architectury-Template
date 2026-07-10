package example.example.example.forge;

import example.example.example.Example;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = Example.MOD_ID, value = Dist.CLIENT)
public class ExampleClientNeoForge {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {

    }
}
