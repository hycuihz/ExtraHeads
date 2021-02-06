package io.github.thebusybiscuit.extraheads;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

public class MobHead extends SlimefunItem {
   private Runnable runnable;

   public MobHead(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack recipe) {
      super(category, item, recipeType, new ItemStack[]{null, null, null, null, recipe, null, null, null, null});
   }

   public void register(ExtraHeads plugin, Runnable runnable) {
      this.runnable = runnable;
      this.register(plugin);
   }

   public void postRegister() {
      super.postRegister();
      if (!this.isDisabled()) {
         this.runnable.run();
      }

   }
}
