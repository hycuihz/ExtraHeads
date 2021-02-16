package io.github.thebusybiscuit.extragear;

import io.github.thebusybiscuit.extragear.bstats.Metrics;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.core.researching.Research;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.collections.Pair;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.mrCookieSlime.Slimefun.cscorelib2.updater.GitHubBuildsUpdater;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class ExtraGear extends JavaPlugin implements SlimefunAddon {
   private int researchId = 3300;
   private Category category;

   public void onEnable() {
      Config cfg = new Config(this);
      if (cfg.getBoolean("options.auto-update")) {
         (new GitHubBuildsUpdater(this, this.getFile(), "TheBusyBiscuit/ExtraGear/master")).start();
      }

      new Metrics(this, 6469);
      this.category = new Category(new NamespacedKey(this, "items"), new CustomItem(Material.DIAMOND_SWORD, "&6更多PVP用品", new String[0]), 1);
      this.registerSword(Material.IRON_SWORD, "COPPER", "铜", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair(Enchantment.DAMAGE_UNDEAD, 2)));
      this.registerArmor(ArmorSet.LEATHER, "COPPER", "铜", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair(Enchantment.PROTECTION_EXPLOSIONS, 2)));
      this.registerSword(Material.IRON_SWORD, "TIN", "锡", SlimefunItems.TIN_INGOT, Arrays.asList(new Pair(Enchantment.DAMAGE_ALL, 1)));
      this.registerArmor(ArmorSet.IRON, "TIN", "锡", SlimefunItems.TIN_INGOT, Arrays.asList(new Pair(Enchantment.PROTECTION_EXPLOSIONS, 3)));
      this.registerSword(Material.IRON_SWORD, "SILVER", "银", SlimefunItems.SILVER_INGOT, Arrays.asList(new Pair(Enchantment.DAMAGE_ALL, 2)));
      this.registerArmor(ArmorSet.IRON, "SILVER", "银", SlimefunItems.SILVER_INGOT, Arrays.asList(new Pair(Enchantment.PROTECTION_ENVIRONMENTAL, 2)));
      this.registerSword(Material.IRON_SWORD, "ALUMINUM", "铝", SlimefunItems.ALUMINUM_INGOT, Arrays.asList(new Pair(Enchantment.DAMAGE_ARTHROPODS, 3)));
      this.registerArmor(ArmorSet.IRON, "ALUMINUM", "铝", SlimefunItems.ALUMINUM_INGOT, Arrays.asList(new Pair(Enchantment.PROTECTION_EXPLOSIONS, 2), new Pair(Enchantment.DURABILITY, 2)));
      this.registerSword(Material.IRON_SWORD, "LEAD", "铅", SlimefunItems.LEAD_INGOT, Arrays.asList(new Pair(Enchantment.DAMAGE_ALL, 3), new Pair(Enchantment.DURABILITY, 8)));
      this.registerArmor(ArmorSet.IRON, "LEAD", "铅", SlimefunItems.LEAD_INGOT, Arrays.asList(new Pair(Enchantment.PROTECTION_ENVIRONMENTAL, 3), new Pair(Enchantment.DURABILITY, 8)));
      this.registerSword(Material.IRON_SWORD, "ZINC", "锌", SlimefunItems.ZINC_INGOT, Arrays.asList(new Pair(Enchantment.DAMAGE_ALL, 2)));
      this.registerArmor(ArmorSet.IRON, "ZINC", "锌", SlimefunItems.ZINC_INGOT, Arrays.asList(new Pair(Enchantment.PROTECTION_ENVIRONMENTAL, 3)));
      this.registerSword(Material.IRON_SWORD, "MAGNESIUM", "镁", SlimefunItems.MAGNESIUM_INGOT, Arrays.asList(new Pair(Enchantment.DAMAGE_ALL, 2), new Pair(Enchantment.DURABILITY, 5)));
      this.registerArmor(ArmorSet.IRON, "MAGNESIUM", "镁", SlimefunItems.MAGNESIUM_INGOT, Arrays.asList(new Pair(Enchantment.PROTECTION_ENVIRONMENTAL, 2), new Pair(Enchantment.DURABILITY, 5)));
      this.registerSword(Material.IRON_SWORD, "STEEL", "钢", SlimefunItems.STEEL_INGOT, Arrays.asList(new Pair(Enchantment.DAMAGE_ALL, 5), new Pair(Enchantment.DURABILITY, 6)));
      this.registerArmor(ArmorSet.IRON, "STEEL", "钢", SlimefunItems.STEEL_INGOT, Arrays.asList(new Pair(Enchantment.PROTECTION_ENVIRONMENTAL, 3), new Pair(Enchantment.DURABILITY, 4)));
      this.registerSword(Material.IRON_SWORD, "BRONZE", "青铜", SlimefunItems.BRONZE_INGOT, Arrays.asList(new Pair(Enchantment.DAMAGE_ALL, 3), new Pair(Enchantment.DURABILITY, 6)));
      this.registerSword(Material.IRON_SWORD, "DURALUMIN", "硬铝", SlimefunItems.DURALUMIN_INGOT, Arrays.asList(new Pair(Enchantment.DAMAGE_ALL, 3), new Pair(Enchantment.DURABILITY, 6)));
      this.registerSword(Material.IRON_SWORD, "BILLON", "银铜合金", SlimefunItems.BILLON_INGOT, Arrays.asList(new Pair(Enchantment.DAMAGE_ALL, 4), new Pair(Enchantment.DURABILITY, 5)));
      this.registerSword(Material.IRON_SWORD, "BRASS", "黄铜", SlimefunItems.BRASS_INGOT, Arrays.asList(new Pair(Enchantment.DAMAGE_UNDEAD, 4), new Pair(Enchantment.DURABILITY, 6)));
      this.registerSword(Material.IRON_SWORD, "ALUMINUM_BRASS", "铝黄铜", SlimefunItems.ALUMINUM_BRASS_INGOT, Arrays.asList(new Pair(Enchantment.DAMAGE_ARTHROPODS, 4), new Pair(Enchantment.DURABILITY, 4)));
      this.registerSword(Material.IRON_SWORD, "ALUMINUM_BRONZE", "铝青铜", SlimefunItems.ALUMINUM_BRONZE_INGOT, Arrays.asList(new Pair(Enchantment.DAMAGE_ARTHROPODS, 4), new Pair(Enchantment.DURABILITY, 5)));
      this.registerSword(Material.IRON_SWORD, "CORINTHIAN_BRONZE", "科林斯青铜", SlimefunItems.CORINTHIAN_BRONZE_INGOT, Arrays.asList(new Pair(Enchantment.DAMAGE_ALL, 5), new Pair(Enchantment.DURABILITY, 5)));
      this.registerSword(Material.IRON_SWORD, "SOLDER", "焊锡", SlimefunItems.SOLDER_INGOT, Arrays.asList(new Pair(Enchantment.DAMAGE_ALL, 4), new Pair(Enchantment.DURABILITY, 6)));
      this.registerSword(Material.IRON_SWORD, "DAMASCUS_STEEL", "大马士革钢", SlimefunItems.DAMASCUS_STEEL_INGOT, Arrays.asList(new Pair(Enchantment.DAMAGE_ALL, 6), new Pair(Enchantment.DURABILITY, 7)));
      this.registerSword(Material.IRON_SWORD, "HARDENED", "硬化金属", SlimefunItems.HARDENED_METAL_INGOT, Arrays.asList(new Pair(Enchantment.DAMAGE_ALL, 7), new Pair(Enchantment.DURABILITY, 10)));
      this.registerSword(Material.IRON_SWORD, "REINFORCED", "强化合金", SlimefunItems.REINFORCED_ALLOY_INGOT, Arrays.asList(new Pair(Enchantment.DAMAGE_ALL, 8), new Pair(Enchantment.DURABILITY, 8)));
      this.registerSword(Material.IRON_SWORD, "FERROSILICON", "硅", SlimefunItems.FERROSILICON, Arrays.asList(new Pair(Enchantment.DAMAGE_UNDEAD, 8), new Pair(Enchantment.DURABILITY, 4)));
      this.registerSword(Material.GOLDEN_SWORD, "GILDED_IRON", "镀金铁", SlimefunItems.GILDED_IRON, Arrays.asList(new Pair(Enchantment.DAMAGE_ARTHROPODS, 8), new Pair(Enchantment.DURABILITY, 10)));
      this.registerSword(Material.IRON_SWORD, "NICKEL", "镍", SlimefunItems.NICKEL_INGOT, Arrays.asList(new Pair(Enchantment.DAMAGE_ALL, 6), new Pair(Enchantment.DURABILITY, 5)));
      this.registerSword(Material.IRON_SWORD, "COBALT", "钴", SlimefunItems.COBALT_INGOT, Arrays.asList(new Pair(Enchantment.DAMAGE_ALL, 7), new Pair(Enchantment.DURABILITY, 7)));
      this.registerArmor(ArmorSet.IRON, "COBALT", "钴", SlimefunItems.COBALT_INGOT, Arrays.asList(new Pair(Enchantment.PROTECTION_ENVIRONMENTAL, 7), new Pair(Enchantment.DURABILITY, 7)));
   }

   private void registerSword(Material type, String component, String ChineseName, ItemStack item, List<Pair<Enchantment, Integer>> enchantments) {
      SlimefunItemStack is = new SlimefunItemStack(component + "_SWORD", type, "&r" + ChatUtils.humanize(ChineseName) + "剑", new String[0]);
      Iterator var6 = enchantments.iterator();

      while(var6.hasNext()) {
         Pair<Enchantment, Integer> enchantment = (Pair)var6.next();
         is.addUnsafeEnchantment((Enchantment)enchantment.getFirstValue(), (Integer)enchantment.getSecondValue());
      }

      SlimefunItem slimefunItem = new SlimefunItem(this.category, is, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{null, item, null, null, item, null, null, new ItemStack(Material.STICK), null});
      slimefunItem.register(this);
      ++this.researchId;
      Research research = new Research(new NamespacedKey(this, component.toLowerCase() + "_sword"), this.researchId, ChatUtils.humanize(ChineseName) + "剑", 3);
      research.addItems(new SlimefunItem[]{slimefunItem});
      research.register();
   }

   private void registerArmor(ArmorSet armorset, String component, String ChineseName, ItemStack item, List<Pair<Enchantment, Integer>> enchantments) {
      String humanizedComponent = ChatUtils.humanize(ChineseName);
      SlimefunItemStack[] armor = new SlimefunItemStack[]{new SlimefunItemStack(component + "_HELMET", armorset.getHelmet(), "&f" + humanizedComponent + "头盔", new String[0]), new SlimefunItemStack(component + "_CHESTPLATE", armorset.getChestplate(), "&f" + humanizedComponent + "胸甲", new String[0]), new SlimefunItemStack(component + "_LEGGINGS", armorset.getLeggings(), "&f" + humanizedComponent + "护腿", new String[0]), new SlimefunItemStack(component + "_BOOTS", armorset.getBoots(), "&f" + humanizedComponent + "靴子", new String[0])};
      Iterator var7 = enchantments.iterator();

      while(var7.hasNext()) {
         Pair<Enchantment, Integer> enchantment = (Pair)var7.next();
         SlimefunItemStack[] var9 = armor;
         int var10 = armor.length;

         for(int var11 = 0; var11 < var10; ++var11) {
            ItemStack is = var9[var11];
            is.addUnsafeEnchantment((Enchantment)enchantment.getFirstValue(), (Integer)enchantment.getSecondValue());
         }
      }

      SlimefunItem helmet = new SlimefunItem(this.category, armor[0], RecipeType.ARMOR_FORGE, new ItemStack[]{item, item, item, item, null, item, null, null, null});
      helmet.register(this);
      SlimefunItem chestplate = new SlimefunItem(this.category, armor[1], RecipeType.ARMOR_FORGE, new ItemStack[]{item, null, item, item, item, item, item, item, item});
      chestplate.register(this);
      SlimefunItem leggings = new SlimefunItem(this.category, armor[2], RecipeType.ARMOR_FORGE, new ItemStack[]{item, item, item, item, null, item, item, null, item});
      leggings.register(this);
      SlimefunItem boots = new SlimefunItem(this.category, armor[3], RecipeType.ARMOR_FORGE, new ItemStack[]{null, null, null, item, null, item, item, null, item});
      boots.register(this);
      ++this.researchId;
      Research research = new Research(new NamespacedKey(this, component.toLowerCase() + "_armor"), this.researchId, humanizedComponent + "护甲", 5);
      research.addItems(new SlimefunItem[]{helmet, chestplate, leggings, boots});
      research.register();
   }

   public JavaPlugin getJavaPlugin() {
      return this;
   }

   public String getBugTrackerURL() {
      return "https://github.com/TheBusyBiscuit/ExtraGear/issues";
   }
}
