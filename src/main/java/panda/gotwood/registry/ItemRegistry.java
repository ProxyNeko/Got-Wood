package panda.gotwood.registry;

import net.minecraft.item.Item;
import panda.gotwood.item.ItemDates;
import panda.gotwood.item.ItemSeed;
import panda.gotwood.item.ItemWoodDoor;
import panda.gotwood.item.ItemWoodSlab;
import panda.gotwood.util.WoodMaterials;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO Use the EventBusSubscriber system and an object holder class elsewhere (Likely panda.gotwood.api.GWItems)
public final class ItemRegistry {

    public static final Item apple_door = new ItemWoodDoor(BlockRegistry.apple_door, WoodMaterials.apple);
    public static final Item maple_door = new ItemWoodDoor(BlockRegistry.maple_door, WoodMaterials.maple);
    public static final Item pine_door = new ItemWoodDoor(BlockRegistry.pine_door, WoodMaterials.pine);
    public static final Item willow_door = new ItemWoodDoor(BlockRegistry.willow_door, WoodMaterials.willow);
    public static final Item yew_door = new ItemWoodDoor(BlockRegistry.yew_door, WoodMaterials.yew);
    public static final Item ebony_door = new ItemWoodDoor(BlockRegistry.ebony_door, WoodMaterials.ebony);
    public static final Item fir_door = new ItemWoodDoor(BlockRegistry.fir_door, WoodMaterials.fir);
    public static final Item bamboo_door = new ItemWoodDoor(BlockRegistry.bamboo_door, WoodMaterials.bamboo);
    public static final Item palm_door = new ItemWoodDoor(BlockRegistry.palm_door, WoodMaterials.palm);
    public static final Item apple_seed = new ItemSeed(WoodMaterials.apple);
    public static final Item maple_seed = new ItemSeed(WoodMaterials.maple);
    public static final Item pine_seed = new ItemSeed(WoodMaterials.pine);
    public static final Item willow_seed = new ItemSeed(WoodMaterials.willow);
    public static final Item yew_seed = new ItemSeed(WoodMaterials.yew);
    public static final Item ebony_seed = new ItemSeed(WoodMaterials.ebony);
    public static final Item fir_seed = new ItemSeed(WoodMaterials.fir);
    public static final Item bamboo_seed = new ItemSeed(WoodMaterials.bamboo);
    public static final Item rubber_seed = new ItemSeed(WoodMaterials.rubber);
    public static final Item oak_seed = new ItemSeed(WoodMaterials.oak);
    public static final Item birch_seed = new ItemSeed(WoodMaterials.birch);
    public static final Item spruce_seed = new ItemSeed(WoodMaterials.spruce);
    public static final Item dark_oak_seed = new ItemSeed(WoodMaterials.darkOak);
    public static final Item jungle_seed = new ItemSeed(WoodMaterials.jungle);
    public static final Item acacia_seed = new ItemSeed(WoodMaterials.acacia);
    public static final Item apple_slab = new ItemWoodSlab(WoodMaterials.apple, BlockRegistry.apple_slab, BlockRegistry.double_apple_slab);
    public static final Item maple_slab = new ItemWoodSlab(WoodMaterials.maple, BlockRegistry.maple_slab, BlockRegistry.double_maple_slab);
    public static final Item pine_slab = new ItemWoodSlab(WoodMaterials.pine, BlockRegistry.pine_slab, BlockRegistry.double_pine_slab);
    public static final Item willow_slab = new ItemWoodSlab(WoodMaterials.willow, BlockRegistry.willow_slab, BlockRegistry.double_willow_slab);
    public static final Item yew_slab = new ItemWoodSlab(WoodMaterials.yew, BlockRegistry.yew_slab, BlockRegistry.double_yew_slab);
    public static final Item ebony_slab = new ItemWoodSlab(WoodMaterials.ebony, BlockRegistry.ebony_slab, BlockRegistry.double_ebony_slab);
    public static final Item fir_slab = new ItemWoodSlab(WoodMaterials.fir, BlockRegistry.fir_slab, BlockRegistry.double_fir_slab);
    public static final Item ash = new Item().setRegistryName("ash");
    public static final Item bamboo_pole = new Item().setRegistryName("bamboo_pole");
    public static final Item bamboo_charcoal = new Item().setRegistryName("bamboo_charcoal");
    public static final Item dates = new ItemDates();
    public static final Item maple_sap = new Item().setRegistryName("maple_sap").setMaxStackSize(1);
    public static final Item rubber_sap = new Item().setRegistryName("rubber_sap").setMaxStackSize(1);
    static final Map<String, Item> registry = new HashMap<>();

    private ItemRegistry() {
    }

    public static List<Item> getItemList() {
        List<Item> list = new ArrayList<>();
        list.add(apple_seed);
        list.add(maple_seed);
        list.add(pine_seed);
        list.add(willow_seed);
        list.add(yew_seed);
        list.add(fir_seed);
        list.add(ebony_seed);
        list.add(dates);
        list.add(bamboo_seed);
        list.add(rubber_seed);
        list.add(maple_sap);
        list.add(rubber_sap);

        list.add(apple_door);
        list.add(maple_door);
        list.add(pine_door);
        list.add(willow_door);
        list.add(yew_door);
        list.add(fir_door);
        list.add(ebony_door);
        list.add(bamboo_door);
        list.add(palm_door);

        list.add(oak_seed);
        list.add(birch_seed);
        list.add(dark_oak_seed);
        list.add(jungle_seed);
        list.add(acacia_seed);
        list.add(spruce_seed);

        list.add(apple_slab);
        list.add(maple_slab);
        list.add(pine_slab);
        list.add(willow_slab);
        list.add(yew_slab);
        list.add(ebony_slab);
        list.add(fir_slab);

        list.add(bamboo_charcoal);
        list.add(bamboo_pole);
        list.add(ash);

        return list;
    }

    public static Item getItemByName(String name) {
        return registry.get(name);
    }
}
