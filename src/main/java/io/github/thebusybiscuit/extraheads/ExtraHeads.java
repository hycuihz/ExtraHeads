package io.github.thebusybiscuit.extraheads;

import com.meowj.langutils.lang.LanguageHelper;
import io.github.thebusybiscuit.extraheads.bstats.Metrics;
import io.github.thebusybiscuit.slimefun4.api.MinecraftVersion;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import java.util.EnumMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;
import me.mrCookieSlime.Slimefun.cscorelib2.updater.GitHubBuildsUpdater;
import me.mrCookieSlime.Slimefun.cscorelib2.updater.Updater;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class ExtraHeads extends JavaPlugin implements SlimefunAddon {
   private final Map<EntityType, ItemStack> mobs = new EnumMap(EntityType.class);
   private Config cfg;
   private Logger logger;
   private Category category;
   private RecipeType recipeType;

   public void onEnable() {
      this.cfg = new Config(this);
      this.logger = this.getLogger();
      new Metrics(this, 5650);
      if (this.getDescription().getVersion().startsWith("DEV - ")) {
         Updater updater = new GitHubBuildsUpdater(this, this.getFile(), "TheBusyBiscuit/ExtraHeads/master");
         if (this.cfg.getBoolean("options.auto-update")) {
            updater.start();
         }
      }

      this.category = new Category(new NamespacedKey(this, "heads"), new CustomItem(SkullItem.fromHash("5f1379a82290d7abe1efaabbc70710ff2ec02dd34ade386bc00c930c461cf932"), "&7更多头颅", new String[]{"", "&a> 点击打开"}), 1);
      this.recipeType = new RecipeType(new NamespacedKey(this, "decapitation"), new CustomItem(Material.IRON_SWORD, "&6杀死特定生物", new String[0]));
      this.registerHead("蝙蝠的头", EntityType.BAT, "2796aa6d18edc5b724bd89e983bc3215a41bf775d112635e9b5835d1b8ad20cb");
      this.registerHead("烈焰人的头", EntityType.BLAZE, "b78ef2e4cf2c41a2d14bfde9caff10219f5b1bf5b35a49eb51c6467882cb5f0");
      this.registerHead("洞穴蜘蛛的头", EntityType.CAVE_SPIDER, "41645dfd77d09923107b3496e94eeb5c30329f97efc96ed76e226e98224");
      this.registerHead("鸡的头", EntityType.CHICKEN, "1638469a599ceef7207537603248a9ab11ff591fd378bea4735b346a7fae893");
      this.registerHead("牛的头", EntityType.COW, "5d6c6eda942f7f5f71c3161c7306f4aed307d82895f9d2b07ab4525718edc5");
      this.registerHead("海豚的头", EntityType.DOLPHIN, "cefe7d803a45aa2af1993df2544a28df849a762663719bfefc58bf389ab7f5");
      this.registerHead("溺尸的头", EntityType.DROWNED, "c84df79c49104b198cdad6d99fd0d0bcf1531c92d4ab6269e40b7d3cbbb8e98c");
      this.registerHead("远古守卫者的头", EntityType.ELDER_GUARDIAN, "4adc4a6f53afa116027b51d6f2e433ee7afa5d59b2ffa04780be464fa5d61a");
      this.registerHead("末影人的头", EntityType.ENDERMAN, "7a59bb0a7a32965b3d90d8eafa899d1835f424509eadd4e6b709ada50b9cf");
      this.registerHead("唤魔者的头", EntityType.EVOKER, "d954135dc82213978db478778ae1213591b93d228d36dd54f1ea1da48e7cba6");
      this.registerHead("恶魂的头", EntityType.GHAST, "8b6a72138d69fbbd2fea3fa251cabd87152e4f1c97e5f986bf685571db3cc0");
      this.registerHead("守卫者的头", EntityType.GUARDIAN, "932c24524c82ab3b3e57c2052c533f13dd8c0beb8bdd06369bb2554da86c123");
      this.registerHead("马的头", EntityType.HORSE, "61902898308730c4747299cb5a5da9c25838b1d059fe46fc36896fee662729");
      this.registerHead("尸壳的头", EntityType.HUSK, "d674c63c8db5f4ca628d69a3b1f8a36e29d8fd775e1a6bdb6cabb4be4db121");
      this.registerHead("幻术师的头", EntityType.ILLUSIONER, "2f2882dd09723e47c0ab9663eab083d6a5969273706110c82910e61bf8a8f07e");
      this.registerHead("铁傀儡的头", EntityType.IRON_GOLEM, "89091d79ea0f59ef7ef94d7bba6e5f17f2f7d4572c44f90f76c4819a714");
      this.registerHead("羊驼的头", EntityType.LLAMA, "2a5f10e6e6232f182fe966f501f1c3799d45ae19031a1e4941b5dee0feff059b");
      this.registerHead("岩浆史莱姆的头", EntityType.MAGMA_CUBE, "38957d5023c937c4c41aa2412d43410bda23cf79a9f6ab36b76fef2d7c429");
      this.registerHead("哞菇的头", EntityType.MUSHROOM_COW, "d0bc61b9757a7b83e03cd2507a2157913c2cf016e7c096a4d6cf1fe1b8db");
      this.registerHead("豹猫的头", EntityType.OCELOT, "5657cd5c2989ff97570fec4ddcdc6926a68a3393250c1be1f0b114a1db1");
      this.registerHead("鹦鹉的头", EntityType.PARROT, "a4ba8d66fecb1992e94b8687d6ab4a5320ab7594ac194a2615ed4df818edbc3");
      this.registerHead("猪的头", EntityType.PIG, "621668ef7cb79dd9c22ce3d1f3f4cb6e2559893b6df4a469514e667c16aa4");
      this.registerHead("北极熊的头", EntityType.POLAR_BEAR, "442123ac15effa1ba46462472871b88f1b09c1db467621376e2f71656d3fbc");
      this.registerHead("兔子的头", EntityType.RABBIT, "ff1559194a175935b8b4fea6614bec60bf81cf524af6f564333c555e657bc");
      this.registerHead("羊的头", EntityType.SHEEP, "f31f9ccc6b3e32ecf13b8a11ac29cd33d18c95fc73db8a66c5d657ccb8be70");
      this.registerHead("潜影贝的头", EntityType.SHULKER, "b1d3534d21fe8499262de87affbeac4d25ffde35c8bdca069e61e1787ff2f");
      this.registerHead("史莱姆的头", EntityType.SLIME, "16ad20fc2d579be250d3db659c832da2b478a73a698b7ea10d18c9162e4d9b5");
      this.registerHead("蜘蛛的头", EntityType.SPIDER, "cd541541daaff50896cd258bdbdd4cf80c3ba816735726078bfe393927e57f1");
      this.registerHead("鱿鱼的头", EntityType.SQUID, "01433be242366af126da434b8735df1eb5b3cb2cede39145974e9c483607bac");
      this.registerHead("流浪者的头", EntityType.STRAY, "78ddf76e555dd5c4aa8a0a5fc584520cd63d489c253de969f7f22f85a9a2d56");
      this.registerHead("乌龟的头", EntityType.TURTLE, "0a4050e7aacc4539202658fdc339dd182d7e322f9fbcc4d5f99b5718a");
      this.registerHead("恼鬼的头", EntityType.VEX, "c2ec5a516617ff1573cd2f9d5f3969f56d5575c4ff4efefabd2a18dc7ab98cd");
      this.registerHead("村民的头", EntityType.VILLAGER, "822d8e751c8f2fd4c8942c44bdb2f5ca4d8ae8e575ed3eb34c18a86e93b");
      this.registerHead("卫道士的头", EntityType.VINDICATOR, "6deaec344ab095b48cead7527f7dee61b063ff791f76a8fa76642c8676e2173");
      this.registerHead("女巫的头", EntityType.WITCH, "ddedbee42be472e3eb791e7dbdfaf18c8fe593c638ba1396c9ef68f555cbce");
      this.registerHead("凋零的头", EntityType.WITHER, "cdf74e323ed41436965f5c57ddf2815d5332fe999e68fbb9d6cf5c8bd4139f");
      this.registerHead("僵尸村民的头", EntityType.ZOMBIE_VILLAGER, "a6224941314bca2ebbb66b10ffd94680cc98c3435eeb71a228a08fd42c24db");
      if (SlimefunPlugin.getMinecraftVersion().isAtLeast(MinecraftVersion.MINECRAFT_1_14)) {
         this.registerHead("劫掠兽的头", EntityType.RAVAGER, "1cb9f139f9489d86e410a06d8cbc670c8028137508e3e4bef612fe32edd60193");
         this.registerHead("掠夺者的头", EntityType.PILLAGER, "4aee6bb37cbfc92b0d86db5ada4790c64ff4468d68b84942fde04405e8ef5333");
         this.registerHead("狐狸的头", EntityType.FOX, "46cff7a19e683a08e4587ea1457880313d5f341f346ceb5b0551195d810e3");
         this.registerHead("熊猫的头", EntityType.PANDA, "7818b681cace1c641919f53edadecb142330d089a826b56219138c33b7a5e0db");
         this.registerHead("流浪商人的头", EntityType.WANDERING_TRADER, "5f1379a82290d7abe1efaabbc70710ff2ec02dd34ade386bc00c930c461cf932");
      }

      if (SlimefunPlugin.getMinecraftVersion().isBefore(MinecraftVersion.MINECRAFT_1_16)) {
         this.registerHead("僵尸猪人的头", EntityType.valueOf("PIG_ZOMBIE"), "74e9c6e98582ffd8ff8feb3322cd1849c43fb16b158abb11ca7b42eda7743eb");
      } else {
         this.registerHead("猪灵的头", EntityType.PIGLIN, "11d18bbd0d795b9ac8efaad655e3d0c59fcbb9b964c2a9948ef537f4a3fbbf87");
         this.registerHead("僵尸猪灵的头", EntityType.ZOMBIFIED_PIGLIN, "e935842af769380f78e8b8a88d1ea6ca2807c1e5693c2cf797456620833e936f");
         this.registerHead("炽足兽的头", EntityType.STRIDER, "18a9adf780ec7dd4625c9c0779052e6a15a451866623511e4c82e9655714b3c1");
      }

      this.cfg.save();
      new HeadListener(this);
   }

   private void registerHead(String name, EntityType type, String texture) {
      try {
         double chance = (Double)this.cfg.getOrSetDefault("chances." + type.toString(), 7.5D);
         SlimefunItemStack item = new SlimefunItemStack(type.toString() + "_HEAD", texture, "&r" + name, new String[0]);
         (new MobHead(this.category, item, this.recipeType, new CustomItem(item, "&r击杀一只 " + ChatUtils.humanize(LanguageHelper.getEntityName(type, "zh_CN")), new String[]{"&7几率: &e" + chance + "%"}))).register(this, () -> {
            this.mobs.put(type, item);
         });
      } catch (Exception var7) {
         this.logger.log(Level.WARNING, var7, () -> {
            return "无法加载生物 " + type + " 的头";
         });
      }

   }

   public Map<EntityType, ItemStack> getMobDrops() {
      return this.mobs;
   }

   public Config getCfg() {
      return this.cfg;
   }

   public JavaPlugin getJavaPlugin() {
      return this;
   }

   public String getBugTrackerURL() {
      return "https://github.com/TheBusyBiscuit/ExtraHeads/issues";
   }
}
