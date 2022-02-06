package me.DragonFighter603.corruption;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class BoneMealGun implements Listener {
    public Plugin plugin;
    public int maxAmmo = 1024;

    public BoneMealGun(Plugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e){
        Player player = e.getPlayer();
        if(e.getItem() != null && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            if (e.getItem().getType() == Material.BONE_MEAL) {
                if (e.getItem().getItemMeta().getPersistentDataContainer().has(NamespacedKey.fromString("gun_id", plugin), PersistentDataType.DOUBLE)){
                    e.setCancelled(true);
                    if(player.getWorld() == Bukkit.getWorlds().get(0)) shootBoneMeal(player, e.getItem());
                }
            }
        }
    }

    @EventHandler
    public void onPickupItem(PlayerPickupItemEvent e){
        Player player = e.getPlayer();
        Item pickup = e.getItem();
        if(pickup.getItemStack().getType() == Material.BONE_MEAL) {
            if(pickup.getItemStack().getItemMeta().getPersistentDataContainer().has(NamespacedKey.fromString("gun_id", plugin), PersistentDataType.DOUBLE)) return;
            if(player.getItemInHand() == null) return;
            if (player.getItemInHand().getType() == Material.BONE_MEAL) {
                ItemMeta meta = player.getItemInHand().getItemMeta();
                PersistentDataContainer container = meta.getPersistentDataContainer();
                if (container.has(NamespacedKey.fromString("gun_id", plugin), PersistentDataType.DOUBLE)){
                    int ammo = container.get(NamespacedKey.fromString("ammunition", plugin), PersistentDataType.INTEGER);
                    if(ammo < maxAmmo){
                        e.setCancelled(true);
                        if(ammo + pickup.getItemStack().getAmount() <= maxAmmo){
                            ammo += pickup.getItemStack().getAmount();
                            container.set(NamespacedKey.fromString("ammunition", plugin), PersistentDataType.INTEGER, ammo);
                            meta.setLore(generateBoneMealGunLore(ammo));
                            pickup.remove();
                            for(Player p: Bukkit.getOnlinePlayers()){
                                p.playSound(pickup.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 3, 1.5f);
                                p.spawnParticle(Particle.COMPOSTER, pickup.getLocation(), 5, 0.05f, 0.05f, 0.05f);
                            }
                        }
                        else{
                            ItemStack itemStack = pickup.getItemStack();
                            itemStack.setAmount(pickup.getItemStack().getAmount() - (maxAmmo-ammo));
                            pickup.setItemStack(itemStack);
                            ammo = maxAmmo;
                            container.set(NamespacedKey.fromString("ammunition", plugin), PersistentDataType.INTEGER, ammo);
                            meta.setLore(generateBoneMealGunLore(ammo));
                            for(Player p: Bukkit.getOnlinePlayers()){
                                p.playSound(pickup.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 3, 1.5f);
                                p.spawnParticle(Particle.COMPOSTER, pickup.getLocation(), 5, 0.05f, 0.05f, 0.05f);
                            }
                        }
                        player.getItemInHand().setItemMeta(meta);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPrepareEnchant(PrepareItemEnchantEvent e) {
        if(e.getItem().getType() == Material.BONE_MEAL){
            if(e.getItem().getItemMeta().getPersistentDataContainer().has(NamespacedKey.fromString("gun_id", plugin), PersistentDataType.DOUBLE)) return;
            e.getItem().setAmount(0);
            e.getView().close();
            new BukkitRunnable() {
                int ticks = 0;
                @Override
                public void run() {
                    if(ticks==0){
                        Location b = e.getEnchantBlock().getLocation();
                        for(Player p: Bukkit.getOnlinePlayers()) {
                            p.spawnParticle(Particle.PORTAL, b.getX() + 0.5, b.getY() + 1, b.getZ() + 0.5, 100);
                        }
                    }
                    if(ticks == 59){
                        for(Player p: Bukkit.getOnlinePlayers()) {
                            p.playSound(e.getEnchantBlock().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 7, 1);
                        }
                    }
                    if(ticks == 60){
                        cancel();
                        Location b = e.getEnchantBlock().getLocation();
                        for(Player p: Bukkit.getOnlinePlayers()){
                            p.playSound(e.getEnchantBlock().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 7, 1.2f);
                            p.spawnParticle(Particle.COMPOSTER, b.getX() + 0.5, b.getY() + 1, b.getZ() + 0.5, 10, 0.1f, 0.1f, 0.1f);
                        }
                        World world = e.getEnchantBlock().getWorld();
                        ItemStack boneMeal = new ItemStack(Material.BONE_MEAL);
                        boneMeal.addUnsafeEnchantment(Enchantment.MENDING, 1);
                        ItemMeta meta = boneMeal.getItemMeta();
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName(ChatColor.GREEN + "Bone Meal Gun");
                        meta.setLore(generateBoneMealGunLore(0));
                        PersistentDataContainer container = meta.getPersistentDataContainer();
                        container.set(NamespacedKey.fromString("gun_id", plugin), PersistentDataType.DOUBLE, Math.random());
                        container.set(NamespacedKey.fromString("ammunition", plugin), PersistentDataType.INTEGER, 0);
                        container.set(NamespacedKey.fromString("last_used", plugin), PersistentDataType.LONG, 0L);
                        boneMeal.setItemMeta(meta);
                        world.dropItem(new Location(world,b.getX() + 0.5, b.getY() + 1, b.getZ() + 0.5), boneMeal);
                    }
                    ticks++;
                }
            }.runTaskTimer(plugin, 0, 1);
        }
    }

    public void shootBoneMeal(Player player, ItemStack boneMealGun){
        ItemMeta meta = boneMealGun.getItemMeta();
        PersistentDataContainer container = meta.getPersistentDataContainer();
        if(System.currentTimeMillis() < container.get(NamespacedKey.fromString("last_used", plugin), PersistentDataType.LONG) + 500) return;
        int ammo = container.get(NamespacedKey.fromString("ammunition", plugin), PersistentDataType.INTEGER);
        if(ammo <= 0) {
            for(Player p: Bukkit.getOnlinePlayers()){
                p.playSound(player.getLocation(), Sound.ENTITY_ENDER_EYE_DEATH, 5, 1.2f);
            }
            return;
        }
        for(Player p: Bukkit.getOnlinePlayers()) {
            p.playSound(player.getLocation(), Sound.ENTITY_ARROW_SHOOT, 5, 2f);
        }
        container.set(NamespacedKey.fromString("last_used", plugin), PersistentDataType.LONG, System.currentTimeMillis());
        container.set(NamespacedKey.fromString("ammunition", plugin), PersistentDataType.INTEGER, ammo - 1);
        meta.setLore(generateBoneMealGunLore(ammo - 1));
        boneMealGun.setItemMeta(meta);

        new BukkitRunnable(){
            int ticks = 0;

            World world = player.getWorld();
            Vector dir = player.getEyeLocation().getDirection().multiply(0.5);
            Vector pos = player.getEyeLocation().toVector();

            @Override
            public void run() {
                if(ticks < 30) {
                    for (int i = 0; i < 5; i++) {
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            p.spawnParticle(Particle.CLOUD, pos.getX(), pos.getY(), pos.getZ(), 1, 0, 0, 0, 0);
                        }
                        pos.add(dir);
                        if (ticks == 30 || !world.getBlockAt(pos.getBlockX(), pos.getBlockY(), pos.getBlockZ()).isPassable()) {
                            for (Player p : Bukkit.getOnlinePlayers()) {
                                p.spawnParticle(Particle.END_ROD, pos.getX(), pos.getY(), pos.getZ(), 100, 0, 0, 0, 0.5f);
                            }
                            ticks = 30;
                        }
                    }
                }
                else{
                    int r = ticks - 30;
                    for(int x = -r;x < r;x++){
                        for(int y = -r;y < r;y++){
                            for(int z = -r;z < r;z++){
                                int d = x * x + y * y + z * z;
                                if(d > (r-2)*(r-2) && d < r*r || r < 2){
                                    Material type = world.getType(pos.getBlockX() + x, pos.getBlockY() + y, pos.getBlockZ() + z);
                                    Material newType = Conversion.reconvert(type);
                                    if(newType != null){
                                        world.setType(pos.getBlockX() + x, pos.getBlockY() + y, pos.getBlockZ() + z, newType);
                                    }
                                }
                            }
                        }
                    }
                }
                if(ticks == 42) cancel();
                ticks++;
            }
        }.runTaskTimer(plugin, 0, 1);
    }

    public ArrayList<String> generateBoneMealGunLore(int ammunition){
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.WHITE + "[Right Click] " + ChatColor.GRAY + "to use and");
        lore.add(ChatColor.GRAY + "clean the land of fungi.");
        String full = "#";
        String empty = "-";
        int fullness = Math.round(ammunition / (float) maxAmmo * 10);
        lore.add(ChatColor.GRAY + "Ammunition " + ChatColor.GREEN +
                "[" + full.repeat(fullness) + empty.repeat(10 - fullness) + "] " +
                ChatColor.WHITE + ammunition+"/"+maxAmmo);
        lore.add(ChatColor.GRAY + "Pick up Bone Meal while holding");
        lore.add(ChatColor.GRAY + "this item to refill it.");
        lore.add(ChatColor.GRAY + "Attention, works only in the Overworld!");
        lore.add(ChatColor.GRAY + "Removes 99.9% of all fungi.");
        return lore;
    }
}
