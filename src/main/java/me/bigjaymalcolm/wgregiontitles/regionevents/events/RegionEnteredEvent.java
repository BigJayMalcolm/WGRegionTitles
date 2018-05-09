package me.bigjaymalcolm.wgregiontitles.regionevents.events;

import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import me.bigjaymalcolm.wgregiontitles.Main;
import me.bigjaymalcolm.wgregiontitles.regionevents.MovementWay;
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

        String titleString, subtitleString;

        if (region.getFlag(Main.GREETING_TITLE_FLAG) == null)
        {
            titleString = "";
        }
        else
        {
            titleString = region.getFlag(Main.GREETING_TITLE_FLAG).toString();
        }

        if (region.getFlag(Main.GREETING_SUBTITLE_FLAG) == null)
        {
            subtitleString = "";
        }
        else
        {
            subtitleString = region.getFlag(Main.GREETING_SUBTITLE_FLAG).toString();
        }

        player.sendTitle(titleString, subtitleString, 10, 50, 20);
    }
}