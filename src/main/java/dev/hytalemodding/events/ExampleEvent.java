package dev.hytalemodding.events;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

public final class ExampleEvent {

    private ExampleEvent() {}

    public static void onPlayerReady(PlayerReadyEvent event) {
        Player player = event.getPlayer();

        Ref<EntityStore> playerRef = player.getReference();
        if (playerRef == null) {
            return;
        }

        Store<EntityStore> store = playerRef.getStore();

        PlayerRef playerRefComponent = store.getComponent(
            playerRef,
            PlayerRef.getComponentType()
        );

        if (playerRefComponent == null) {
            return;
        }

        playerRefComponent.sendMessage(
                Message.raw("Welcome " + playerRefComponent.getUsername())
        );
    }

}