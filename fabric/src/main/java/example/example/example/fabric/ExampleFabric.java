package example.example.example.fabric;

import example.example.example.Example;
import net.fabricmc.api.ModInitializer;

public class ExampleFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Example.init();
    }
}