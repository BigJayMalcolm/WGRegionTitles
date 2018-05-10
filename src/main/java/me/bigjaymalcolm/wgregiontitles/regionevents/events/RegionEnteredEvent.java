package me.bigjaymalcolm.wgregiontitles.regionevents.events;

import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import me.bigjaymalcolm.wgregiontitles.Main;
import me.bigjaymalcolm.wgregiontitles.regionevents.MovementWay;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;

/**
 * event that is triggered after a player entered a WorldGuard region
 * @author mewin<mewin001@hotmail.de>
 */
public class RegionEnteredEvent extends RegionEvent
{
    /**
     * creates a new RegionEnteredEvent
     * @param region the region the player entered
     * @param player the player who triggered the event
     * @param movement the type of movement how the player entered the region
     */
    public RegionEnteredEvent(ProtectedRegion region, Player player, MovementWay movement, PlayerEvent parent)
    {
        super(region, player, movement, parent);

        String titleString = "", subtitleString = "";

        // Check whether title has been set
        if (region.getFlag(Main.GREETING_TITLE_FLAG) != null)
        {
            titleString = region.getFlag(Main.GREETING_TITLE_FLAG).toString();
        }

        // Check whether subtitle has been set
        if (region.getFlag(Main.GREETING_SUBTITLE_FLAG) != null)
        {
            subtitleString = region.getFlag(Main.GREETING_SUBTITLE_FLAG).toString();
        }

        // Only send title if there is something to display
        if (titleString != "" || subtitleString != "")
        {
            player.sendTitle(titleString, subtitleString, 10, 50, 20);
        }

        // Stop the farewell sound if it is still playing
        try
        {
            player.stopSound(Sound.valueOf(region.getFlag(Main.FAREWELL_SOUND_FLAG).toString()));
        }
        catch (Exception e) { }

        // CHeck whether sound has been set
        if (region.getFlag(Main.GREETING_SOUND_FLAG) != null)
        {
            try
            {
                player.playSound(player.getLocation(), Sound.valueOf(region.getFlag(Main.GREETING_SOUND_FLAG).toString()),  10, 1);
            }
            catch (Exception e) { }
        }

        if (region.getFlag(Main.GREETING_COMMAND_FLAG) != null)
        {
            player.performCommand(region.getFlag(Main.GREETING_COMMAND_FLAG).toString());
        }
    }
}