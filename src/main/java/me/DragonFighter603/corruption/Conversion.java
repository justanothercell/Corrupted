package me.DragonFighter603.corruption;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.HashMap;

public class Conversion {
    public static ArrayList<Material> crimsonType = new ArrayList<Material>(){{
        add(Material.CRIMSON_NYLIUM);
        add(Material.CRIMSON_STEM);
        add(Material.CRIMSON_HYPHAE);
        add(Material.NETHER_WART_BLOCK);
        add(Material.CRIMSON_ROOTS);
        add(Material.CRIMSON_FUNGUS);
    }};
    public static HashMap<Material, Material> crimson = new HashMap<Material, Material>(){{
        put(Material.GRASS_BLOCK, Material.CRIMSON_NYLIUM);

        put(Material.OAK_LOG, Material.CRIMSON_STEM);
        put(Material.DARK_OAK_LOG, Material.CRIMSON_STEM);
        put(Material.BIRCH_LOG, Material.CRIMSON_STEM);
        put(Material.SPRUCE_LOG, Material.CRIMSON_STEM);
        put(Material.ACACIA_LOG, Material.CRIMSON_STEM);
        put(Material.JUNGLE_LOG, Material.CRIMSON_STEM);

        put(Material.OAK_WOOD, Material.CRIMSON_HYPHAE);
        put(Material.DARK_OAK_WOOD, Material.CRIMSON_HYPHAE);
        put(Material.BIRCH_WOOD, Material.CRIMSON_HYPHAE);
        put(Material.SPRUCE_WOOD, Material.CRIMSON_HYPHAE);
        put(Material.ACACIA_WOOD, Material.CRIMSON_HYPHAE);
        put(Material.JUNGLE_WOOD, Material.CRIMSON_HYPHAE);

        put(Material.OAK_LEAVES, Material.NETHER_WART_BLOCK);
        put(Material.DARK_OAK_LEAVES, Material.NETHER_WART_BLOCK);
        put(Material.BIRCH_LEAVES, Material.NETHER_WART_BLOCK);
        put(Material.SPRUCE_LEAVES, Material.NETHER_WART_BLOCK);
        put(Material.ACACIA_LEAVES, Material.NETHER_WART_BLOCK);
        put(Material.JUNGLE_LEAVES, Material.NETHER_WART_BLOCK);

        put(Material.GRASS, Material.CRIMSON_ROOTS);
        put(Material.TALL_GRASS, Material.CRIMSON_ROOTS);

        put(Material.DANDELION, Material.CRIMSON_FUNGUS);
        put(Material.POPPY, Material.CRIMSON_FUNGUS);
        put(Material.BLUE_ORCHID, Material.CRIMSON_FUNGUS);
        put(Material.ALLIUM, Material.CRIMSON_FUNGUS);
        put(Material.AZURE_BLUET, Material.CRIMSON_FUNGUS);
        put(Material.RED_TULIP, Material.CRIMSON_FUNGUS);
        put(Material.ORANGE_TULIP, Material.CRIMSON_FUNGUS);
        put(Material.WHITE_TULIP, Material.CRIMSON_FUNGUS);
        put(Material.PINK_TULIP, Material.CRIMSON_FUNGUS);
        put(Material.OXEYE_DAISY, Material.CRIMSON_FUNGUS);
        put(Material.CORNFLOWER, Material.CRIMSON_FUNGUS);
        put(Material.LILY_OF_THE_VALLEY, Material.CRIMSON_FUNGUS);

        put(Material.SUNFLOWER, Material.CRIMSON_FUNGUS);
        put(Material.LILAC, Material.CRIMSON_FUNGUS);
        put(Material.ROSE_BUSH, Material.CRIMSON_FUNGUS);
        put(Material.PEONY, Material.CRIMSON_FUNGUS);
    }};

    public static ArrayList<Material> warpedType = new ArrayList<Material>(){{
        add(Material.WARPED_NYLIUM);
        add(Material.WARPED_STEM);
        add(Material.WARPED_HYPHAE);
        add(Material.WARPED_WART_BLOCK);
        add(Material.WARPED_ROOTS);
        add(Material.WARPED_FUNGUS);
    }};
    public static HashMap<Material, Material> warped = new HashMap<Material, Material>(){{
        put(Material.GRASS_BLOCK, Material.WARPED_NYLIUM);

        put(Material.OAK_LOG, Material.WARPED_STEM);
        put(Material.DARK_OAK_LOG, Material.WARPED_STEM);
        put(Material.BIRCH_LOG, Material.WARPED_STEM);
        put(Material.SPRUCE_LOG, Material.WARPED_STEM);
        put(Material.ACACIA_LOG, Material.WARPED_STEM);
        put(Material.JUNGLE_LOG, Material.WARPED_STEM);

        put(Material.OAK_WOOD, Material.WARPED_HYPHAE);
        put(Material.DARK_OAK_WOOD, Material.WARPED_HYPHAE);
        put(Material.BIRCH_WOOD, Material.WARPED_HYPHAE);
        put(Material.SPRUCE_WOOD, Material.WARPED_HYPHAE);
        put(Material.ACACIA_WOOD, Material.WARPED_HYPHAE);
        put(Material.JUNGLE_WOOD, Material.WARPED_HYPHAE);

        put(Material.OAK_LEAVES, Material.WARPED_WART_BLOCK);
        put(Material.DARK_OAK_LEAVES, Material.WARPED_WART_BLOCK);
        put(Material.BIRCH_LEAVES, Material.WARPED_WART_BLOCK);
        put(Material.SPRUCE_LEAVES, Material.WARPED_WART_BLOCK);
        put(Material.ACACIA_LEAVES, Material.WARPED_WART_BLOCK);
        put(Material.JUNGLE_LEAVES, Material.WARPED_WART_BLOCK);

        put(Material.GRASS, Material.WARPED_ROOTS);
        put(Material.TALL_GRASS, Material.WARPED_ROOTS);

        put(Material.DANDELION, Material.WARPED_FUNGUS);
        put(Material.POPPY, Material.WARPED_FUNGUS);
        put(Material.BLUE_ORCHID, Material.WARPED_FUNGUS);
        put(Material.ALLIUM, Material.WARPED_FUNGUS);
        put(Material.AZURE_BLUET, Material.WARPED_FUNGUS);
        put(Material.RED_TULIP, Material.WARPED_FUNGUS);
        put(Material.ORANGE_TULIP, Material.WARPED_FUNGUS);
        put(Material.WHITE_TULIP, Material.WARPED_FUNGUS);
        put(Material.PINK_TULIP, Material.WARPED_FUNGUS);
        put(Material.OXEYE_DAISY, Material.WARPED_FUNGUS);
        put(Material.CORNFLOWER, Material.WARPED_FUNGUS);
        put(Material.LILY_OF_THE_VALLEY, Material.WARPED_FUNGUS);

        put(Material.SUNFLOWER, Material.WARPED_FUNGUS);
        put(Material.LILAC, Material.WARPED_FUNGUS);
        put(Material.ROSE_BUSH, Material.WARPED_FUNGUS);
        put(Material.PEONY, Material.WARPED_FUNGUS);
    }};

    public static ArrayList<Material> myceliumType = new ArrayList<Material>(){{
        add(Material.MYCELIUM);
        add(Material.MUSHROOM_STEM);
        add(Material.RED_MUSHROOM_BLOCK);
        add(Material.BROWN_MUSHROOM_BLOCK);
        add(Material.RED_MUSHROOM);
        add(Material.BROWN_MUSHROOM);
    }};
    public static HashMap<Material, Material> mycelium = new HashMap<Material, Material>(){{
        put(Material.GRASS_BLOCK, Material.MYCELIUM);

        put(Material.OAK_LOG, Material.MUSHROOM_STEM);
        put(Material.DARK_OAK_LOG, Material.MUSHROOM_STEM);
        put(Material.BIRCH_LOG, Material.MUSHROOM_STEM);
        put(Material.SPRUCE_LOG, Material.MUSHROOM_STEM);
        put(Material.ACACIA_LOG, Material.MUSHROOM_STEM);
        put(Material.JUNGLE_LOG, Material.MUSHROOM_STEM);

        put(Material.OAK_WOOD, Material.MUSHROOM_STEM);
        put(Material.DARK_OAK_WOOD, Material.MUSHROOM_STEM);
        put(Material.BIRCH_WOOD, Material.MUSHROOM_STEM);
        put(Material.SPRUCE_WOOD, Material.MUSHROOM_STEM);
        put(Material.ACACIA_WOOD, Material.MUSHROOM_STEM);
        put(Material.JUNGLE_WOOD, Material.MUSHROOM_STEM);

        put(Material.OAK_LEAVES, Material.RED_MUSHROOM_BLOCK);
        put(Material.DARK_OAK_LEAVES, Material.BROWN_MUSHROOM_BLOCK);
        put(Material.BIRCH_LEAVES, Material.BROWN_MUSHROOM_BLOCK);
        put(Material.SPRUCE_LEAVES, Material.RED_MUSHROOM_BLOCK);
        put(Material.ACACIA_LEAVES, Material.BROWN_MUSHROOM_BLOCK);
        put(Material.JUNGLE_LEAVES, Material.RED_MUSHROOM_BLOCK);

        put(Material.GRASS, Material.RED_MUSHROOM);
        put(Material.TALL_GRASS, Material.RED_MUSHROOM);

        put(Material.DANDELION, Material.BROWN_MUSHROOM);
        put(Material.POPPY, Material.BROWN_MUSHROOM);
        put(Material.BLUE_ORCHID, Material.BROWN_MUSHROOM);
        put(Material.ALLIUM, Material.BROWN_MUSHROOM);
        put(Material.AZURE_BLUET, Material.BROWN_MUSHROOM);
        put(Material.RED_TULIP, Material.BROWN_MUSHROOM);
        put(Material.ORANGE_TULIP, Material.BROWN_MUSHROOM);
        put(Material.WHITE_TULIP, Material.BROWN_MUSHROOM);
        put(Material.PINK_TULIP, Material.BROWN_MUSHROOM);
        put(Material.OXEYE_DAISY, Material.BROWN_MUSHROOM);
        put(Material.CORNFLOWER, Material.BROWN_MUSHROOM);
        put(Material.LILY_OF_THE_VALLEY, Material.BROWN_MUSHROOM);

        put(Material.SUNFLOWER, Material.BROWN_MUSHROOM);
        put(Material.LILAC, Material.BROWN_MUSHROOM);
        put(Material.ROSE_BUSH, Material.BROWN_MUSHROOM);
        put(Material.PEONY, Material.BROWN_MUSHROOM);
    }};

    public static Material convert(Material material, CorruptionType corruption){
        switch (corruption){
            case CRIMSON:
                return crimson.get(material);
            case WARPED:
                return warped.get(material);
            case MYCELIUM:
                return mycelium.get(material);
        }
        return null;
    }

    public static Material reconvert(Material material){
        Material[] logTypes = {Material.OAK_LOG, Material.DARK_OAK_LOG, Material.BIRCH_LOG, Material.SPRUCE_LOG, Material.ACACIA_LOG, Material.JUNGLE_LOG};
        Material[] woodTypes = {Material.OAK_WOOD, Material.DARK_OAK_WOOD, Material.BIRCH_WOOD, Material.SPRUCE_WOOD, Material.ACACIA_WOOD, Material.JUNGLE_WOOD};
        Material[] leavesTypes = {Material.OAK_LEAVES, Material.DARK_OAK_LEAVES, Material.BIRCH_LEAVES, Material.SPRUCE_LEAVES, Material.ACACIA_LEAVES, Material.JUNGLE_LEAVES};
        Material[] flowerTypes = {Material.DANDELION, Material.POPPY, Material.BLUE_ORCHID, Material.ALLIUM, Material.AZURE_BLUET, Material.RED_TULIP,
                Material.ORANGE_TULIP, Material.WHITE_TULIP, Material.PINK_TULIP, Material.OXEYE_DAISY, Material.CORNFLOWER, Material.LILY_OF_THE_VALLEY};
        switch (material){
            case CRIMSON_NYLIUM:
            case WARPED_NYLIUM:
            case MYCELIUM:
                return Material.GRASS_BLOCK;
            case CRIMSON_STEM:
            case WARPED_STEM:
            case MUSHROOM_STEM:
                return logTypes[(int)(Math.random()*logTypes.length)];
            case CRIMSON_HYPHAE:
            case WARPED_HYPHAE:
                return woodTypes[(int)(Math.random()*woodTypes.length)];
            case NETHER_WART_BLOCK:
            case WARPED_WART_BLOCK:
            case RED_MUSHROOM_BLOCK:
            case BROWN_MUSHROOM_BLOCK:
                return leavesTypes[(int)(Math.random()*leavesTypes.length)];
            case CRIMSON_ROOTS:
            case WARPED_ROOTS:
            case RED_MUSHROOM:
                return Material.GRASS;
            case CRIMSON_FUNGUS:
            case WARPED_FUNGUS:
            case BROWN_MUSHROOM:
                return flowerTypes[(int)(Math.random()*flowerTypes.length)];
        }
        return null;
    }

    public static CorruptionType getCorruption(Material material){
        if(crimsonType.contains(material)) return CorruptionType.CRIMSON;
        if(warpedType.contains(material)) return CorruptionType.WARPED;
        if(myceliumType.contains(material)) return CorruptionType.MYCELIUM;
        return null;
    }

    public enum CorruptionType{
        CRIMSON,
        WARPED,
        MYCELIUM,
    }
}
