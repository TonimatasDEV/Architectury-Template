package example.example.example.fabric.data;

import example.example.example.Example;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.jetbrains.annotations.Nullable;

public class ExampleDataGenerators implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        
    }

    @Override
    public @Nullable String getEffectiveModId() {
        return Example.MOD_ID;
    }
}
