package me.bigjaymalcolm.wgregiontitles.regionevents.events;

import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import me.bigjaymalcolm.wgregiontitles.Main;
import me.bigjaymalcolm.wgregiontitles.regionevents.MovementWay;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;

/**
 * event that is triggered after a player left a WorldGuard region
 * @author mewin<mewin001@hotmail.de>
 */
public class RegionLeftEvent extends RegionEvent
{
    /**
     * creates a new RegionLeftEvent
     * @param region the region the player has left
     * @param player the player who triggered the event
     * @param movement the type of movement how the player left the region
     */
    public RegionLeftEvent(ProtectedRegion region, Player player, MovementWay movement, PlayerEvent parent)
    {
        super(region, player, movement, parent);

        String titleString = "", subtitleString = "";

        // Check whether title has been set
        if (region.getFlag(Main.FAREWELL_TITLE_FLAG) != null)
        {
            titleString = region.getFlag(Main.FAREWELL_TITLE_FLAG).toString();
        }

        // Check whether subtitle has been set
        if (region.getFlag(Main.FAREWELL_SUBTITLE_FLAG) != null)
        {
            subtitleString = region.getFlag(Main.FAREWELL_SUBTITLE_FLAG).toString();
        }

        // Only send title if there is something to display
        if (titleString != "" || subtitleString != "")
        {
            player.sendTitle(titleString, subtitleString, 10, 50, 20);
        }

        // Stop the greeting sound if it is still playing
        try
        {
            player.stopSound(Sound.valueOf(region.getFlag(Main.GREETING_SOUND_FLAG).toString()));
        }
        catch (Exception e) { }

        // Check whether sound has been set
        if (region.getFlag(Main.FAREWELL_SOUND_FLAG) != null)
        {
            try
            {
                player.playSound(player.getLocation(), Sound.valueOf(region.getFlag(Main.FAREWELL_SOUND_FLAG).toString()),  10, 1);
            }
            catch (Exception e) { }
        }

        if (region.getFlag(Main.FAREWELL_COMMAND_FLAG) != null)
        {
            player.performCommand(region.getFlag(Main.FAREWELL_COMMAND_FLAG).toString());
        }
    }
}