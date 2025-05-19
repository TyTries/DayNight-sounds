package tytries.daynight;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.client.MinecraftClient;

public class DayNightSoundsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
					World world = client.world;
					if (world != null) {
						long timeOfDay = world.getTimeOfDay();
						timeOfDay %= 24000;
						if (timeOfDay == 500) {
							if(MinecraftClient.getInstance().player != null)
							 	MinecraftClient.getInstance().player.playSoundToPlayer(SoundEvents.BLOCK_BELL_USE, SoundCategory.HOSTILE, 1.0f, 0.5f);
						// It's day
							System.out.println("It's daytime!" + timeOfDay);
						} else if(timeOfDay == 12500){
							if(MinecraftClient.getInstance().player != null)
								MinecraftClient.getInstance().player.playSoundToPlayer(SoundEvents.ENTITY_WOLF_HOWL, SoundCategory.HOSTILE, 1.0f, 0.5f);
							// It's night entity.wolf.howl
							System.out.println("It's nighttime!" + timeOfDay);
						}
					}
				});
	}
}

