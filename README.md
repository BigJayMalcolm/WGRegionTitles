# WGRegionTitles

Utilising the great work done by der_mewin with WGRegionEvents, I have created a plugin which adds to the functionality of WorldGuard to allow players to add titles and sounds to regions simply using WorldGuard's built in commands.

**Commands**

```
/region flag [region_id] greeting-title [Title Content]
/region flag [region_id] greeting-subtitle [Subtitle Content]
/region flag [region_id] greeting-sound [Sound Name]
/region flag [region_id] greeting-command [Command]

/region flag [region_id] farewell-title [Title Content]
/region flag [region_id] farewell-subtitle [Subtitle Content]
/region flag [region_id] farewell-sound [Sound Name]
/region flag [region_id] farewell-command [Command]
```

Clearing a title, subtitle, sound, or command is done in the same fashion as other WorldGuard flags. Simply do the command above but don't add the content/name parameter.

For a sound name, use the org.bukkit.sound reference list.
https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Sound.html

Standard Minecraft colours codes are supported in titles and subtitles.

*This plugin requires WorldGuard 6.2+*

Need Support? https://discord.me/bigjaymalcolm