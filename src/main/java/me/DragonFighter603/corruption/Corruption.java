package me.DragonFighter603.corruption;

import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public final class Corruption extends JavaPlugin {
    public Random random;

    @Override
    public void onEnable() {
        random = new Random();

        Bukkit.getPluginManager().registerEvents(new BoneMealGun(this), this);

        int w = Bukkit.getWorlds().size();
        new BukkitRunnable() {
            World world = Bukkit.getWorlds().get(0);

            @Override
            public void run() {
                tick(world);
            }
        }.runTaskTimer(this, 0, 1);
    }

    @Override
    public void onDisable() {

    }

    public void tick(World world){
        for(Chunk chunk:world.getLoadedChunks()){
            for(int i = 0;i < 20;i++) {
                tickChunk(world, chunk);
            }
        }
    }

    public void tickChunk(World world, Chunk chunk){
        Location loc = new Location(world,
                chunk.getX() * 16 + random.nextInt(16),
                random.nextInt(world.getMaxHeight() - world.getMinHeight()) + world.getMinHeight(),
                chunk.getZ() * 16 + random.nextInt(16));
        Conversion.CorruptionType type = Conversion.getCorruption(loc.getBlock().getType());
        if(type!=null) {
            for(int x = -1;x < 2;x++){
                for(int z = -1;z < 2;z++){
                    for(int y = -1;y < 2;y++){
                        Location newLoc = new Location(world, loc.getX() + x, loc.getY() + y, loc.getZ() + z);
                        if(loc.getChunk().isLoaded()){
                            Material oldMat = newLoc.getBlock().getType();
                            if(oldMat == Material.AIR){
                                while(newLoc.getY() > world.getMinHeight() && oldMat == Material.AIR) {
                                    newLoc.setY(newLoc.getY() - 1);
                                    oldMat = newLoc.getBlock().getType();
                                }
                                y = 2;
                            }
                            Material newMat = Conversion.convert(oldMat, type);
                            if(newMat != null){
                                newLoc.getBlock().setType(newMat, false);
                            }
                        }
                    }
                }
            }
        }
    }

    //public static void setBlockInWorld(World world, int x, int y, int z, int blockId, byte data, boolean applyPhysics) {
    //    net.
    //    net.minecraft.server.v1_14_R1.World nmsWorld = ((CraftWorld) world).getHandle();
    //    BlockPosition bp = new BlockPosition(x, y, z);
    //    IBlockData ibd = net.minecraft.server.v1_14_R1.Block.getByCombinedId(blockId + (data << 12));
    //    nmsWorld.setTypeAndData(bp, ibd, applyPhysics ? 3 : 2);
    //}
}
