package panda.gotwood.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockWall;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import panda.gotwood.registry.ItemRegistry;
import panda.gotwood.util.IOreDictionaryEntry;
import panda.gotwood.util.WoodMaterial;

public class BlockBambooLog extends Block implements IOreDictionaryEntry, IGrowable{

	public BlockBambooLog(WoodMaterial wood) {
		super(Material.WOOD);
		this.blockHardness = wood.getPlankBlockHardness();
		this.blockResistance = wood.getBlastResistance();
		this.setHarvestLevel("axe", wood.getRequiredHarvestLevel());
		this.setRegistryName(wood.getName()+"_log");
		
	}
	@Override public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity)
	{ return true; }
	
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
    }

    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
    }

    @Override
	public boolean canSustainLeaves(IBlockState state, IBlockAccess world,
			BlockPos pos) {
		return true;
	}
	public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return false;
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }



    @Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos,
			IBlockState state, int fortune) {
    	List<ItemStack> ret = new java.util.ArrayList<ItemStack>();
    	ret.add(new ItemStack(ItemRegistry.bamboo));
		return ret;
	}

	@SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return side == EnumFacing.DOWN ? super.shouldSideBeRendered(blockState, blockAccess, pos, side) : true;
    }

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state,
			boolean isClient) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block) {
		this.checkAndDropBlock(world, pos, state);
	}
	
	protected final void checkAndDropBlock(World world, BlockPos pos, IBlockState state) {
		boolean flag = true;
		if (world.getBlockState(pos.down()).getBlock() == this || world.getBlockState(pos.down()).isNormalCube())
			flag = false;
		else if (flag && !world.isRemote){
			world.destroyBlock(pos, true);
			world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
		}
			
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos,
			IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isBlockSolid(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        return true;
    }

	@Override
	public String getOreDictionaryName() {
		// TODO Auto-generated method stub
		return null;
	}

}