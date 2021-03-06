package panda.gotwood.item;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import panda.gotwood.GotWood;
import panda.gotwood.util.IOreDictionaryEntry;
import panda.gotwood.util.WoodMaterial;
import panda.gotwood.util.WoodMaterials;

public class ItemSeed extends Item implements IOreDictionaryEntry, IPlantable {

    public final IBlockState sapling;
    private final WoodMaterial wood;

    public ItemSeed(WoodMaterial wood) {
        this.wood = wood;
        this.sapling = getSaplingState();
        this.setRegistryName(wood.getName() + "_seed");
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack heldItem = playerIn.getHeldItem(hand);
        if (heldItem.isEmpty()) {
            return super.onItemUse(playerIn, worldIn, pos, hand, facing, hitX, hitY, hitZ);
        }

        System.out.println(this.getSaplingState());
        if (facing == EnumFacing.UP && playerIn.canPlayerEdit(pos.offset(facing), facing, heldItem) && worldIn.isAirBlock(pos.up()) && worldIn.getBlockState(pos).getBlock().canSustainPlant(worldIn.getBlockState(pos), worldIn, pos, facing, (IPlantable) this.getSaplingState().getBlock())) {
            worldIn.setBlockState(pos.up(), this.getSaplingState());
            worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.BLOCK_GRASS_BREAK, SoundCategory.NEUTRAL, 1F, 1F);
            heldItem.shrink(1);
            return EnumActionResult.SUCCESS;
        } else {
            if (playerIn.canPlayerEdit(pos.offset(facing), facing, heldItem) && worldIn.isAirBlock(pos.up()) && worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos)) {
                worldIn.setBlockState(pos, this.getSaplingState());
                worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.BLOCK_GRASS_BREAK, SoundCategory.NEUTRAL, 1F, 1F);
                heldItem.shrink(1);
                return EnumActionResult.SUCCESS;
            }
            return EnumActionResult.FAIL;
        }
    }

    private IBlockState getSaplingState() {
        if (wood == WoodMaterials.acacia || wood == WoodMaterials.birch || wood == WoodMaterials.darkOak || wood == WoodMaterials.jungle || wood == WoodMaterials.oak || wood == WoodMaterials.spruce) {
            return Blocks.SAPLING.getStateFromMeta(wood.getMeta());
        } else {
            return Block.REGISTRY.getObject(new ResourceLocation(GotWood.MODID, wood + "_sapling")).getDefaultState();
        }
    }

    @Override
    public String getOreDictionaryName() {
        return "seed" + this.wood.getCapitalizedName();
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return EnumPlantType.Plains;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        return getSaplingState();
    }
}
