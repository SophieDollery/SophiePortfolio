package io.github.cottoncandie.valentines.blocks;

import io.github.cottoncandie.valentines.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;


public class PassionfruitCropBlock extends CropBlock {

    public static final int MAX_AGE = 5;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

    public PassionfruitCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ItemInit.PASSIONFRUIT_SEEDS.get();
    }

    @Override
    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(state.getValue(this.getAgeProperty())< getMaxAge()) {
            if(level.getBlockState(pos.below()).is(Blocks.FARMLAND)) {
                if(random.nextInt(7) == 0) {
                    growCrop(state, level, pos);
                }
            }
        }
    }

    private void growCrop(BlockState state, ServerLevel level, BlockPos pos) {
        int age = state.getValue(this.getAgeProperty());
        if(age < getMaxAge()) {
            level.setBlockAndUpdate(pos, state.setValue(this.getAgeProperty(), age+1));
        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean isClient) {
        return state.getValue(this.getAgeProperty()) < getMaxAge();
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        int currentAge = state.getValue(this.getAgeProperty());
        if(currentAge < getMaxAge()) {
            int newAge = Math.min(currentAge +1, getMaxAge());
            level.setBlockAndUpdate(pos, state.setValue(this.getAgeProperty(), newAge));
        }
    }
}
