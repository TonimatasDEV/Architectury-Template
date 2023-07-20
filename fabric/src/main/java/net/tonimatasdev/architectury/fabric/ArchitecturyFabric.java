package net.tonimatasdev.architectury.fabric;

import net.tonimatasdev.architectury.Example;
import net.fabricmc.api.ModInitializer;

public class ArchitecturyFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Example.init();
    }
}