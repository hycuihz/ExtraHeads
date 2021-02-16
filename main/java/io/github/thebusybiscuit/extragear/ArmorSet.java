package io.github.thebusybiscuit.extragear;

import org.bukkit.Material;

enum ArmorSet {
   LEATHER(Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS),
   IRON(Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS),
   GOLD(Material.GOLDEN_HELMET, Material.GOLDEN_CHESTPLATE, Material.GOLDEN_LEGGINGS, Material.GOLDEN_BOOTS),
   DIAMOND(Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS);

   private final Material helmet;
   private final Material chestplate;
   private final Material leggings;
   private final Material boots;

   private ArmorSet(Material helmet, Material chestplate, Material leggings, Material boots) {
      this.helmet = helmet;
      this.chestplate = chestplate;
      this.leggings = leggings;
      this.boots = boots;
   }

   public Material getHelmet() {
      return this.helmet;
   }

   public Material getChestplate() {
      return this.chestplate;
   }

   public Material getLeggings() {
      return this.leggings;
   }

   public Material getBoots() {
      return this.boots;
   }
}
