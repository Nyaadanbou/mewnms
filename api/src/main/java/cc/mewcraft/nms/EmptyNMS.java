package cc.mewcraft.nms;

import net.kyori.adventure.key.Key;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.NotNull;

public class EmptyNMS implements MewNMS {
    @Override public void useItem(@NotNull final Player player, @NotNull final EquipmentSlot hand) {
        // Empty
    }

    @Override public @NotNull Key biomeKey(@NotNull final Location location) {
        return Key.key("minecraft:river");
    }
}
