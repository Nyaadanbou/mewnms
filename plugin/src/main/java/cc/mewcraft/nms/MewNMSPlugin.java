package cc.mewcraft.nms;

import me.lucko.helper.plugin.ExtendedJavaPlugin;
import me.lucko.helper.reflect.MinecraftVersion;

public class MewNMSPlugin extends ExtendedJavaPlugin {
    @Override protected void load() {
        MewNMS nms = provideNms();
        if (nms != null) {
            MewNMSProvider.register(nms);
        } else {
            MewNMSProvider.register(new EmptyNMS());
            getLogger().severe("There is no implementation on this runtime Minecraft version.");
        }
    }

    private MewNMS provideNms() {
        MinecraftVersion runtimeVersion = MinecraftVersion.getRuntimeVersion();

        //if (runtimeVersion.equals(MinecraftVersion.of(1, 19, 4)))
        //    return new V1_19_R3();
        //if (runtimeVersion.equals(MinecraftVersion.of(1, 20, 1)))
        //    return new V1_20_R1();
        //if (runtimeVersion.equals(MinecraftVersion.of(1, 20, 2)))
        //    return new V1_20_R2();
        if (runtimeVersion.equals(MinecraftVersion.of(1, 20, 2)))
            return new V1_20_R3();

        return null;
    }
}
