package io.github.thebusybiscuit.extraheads;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class HeadListener implements Listener {
   private final ExtraHeads plugin;

   public HeadListener(ExtraHeads plugin) {
      this.plugin = plugin;
      plugin.getServer().getPluginManager().registerEvents(this, plugin);
   }

   @EventHandler(
      ignoreCancelled = true
   )
   public void onKill(EntityDeathEvent e) {
      if (this.plugin.getMobDrops().containsKey(e.getEntityType())) {
         double chance = this.plugin.getCfg().getDouble("chances." + e.getEntityType().toString());
         Player killer = e.getEntity().getKiller();
         if (killer != null && SlimefunUtils.isItemSimilar(killer.getInventory().getItemInMainHand(), SlimefunItems.SWORD_OF_BEHEADING, true)) {
            chance *= this.plugin.getCfg().getDouble("options.sword-of-beheading-multiplier");
         }

         if (Math.random() * 100.0D < chance) {
            e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), (ItemStack)this.plugin.getMobDrops().get(e.getEntityType()));
         }

      }
   }
}
