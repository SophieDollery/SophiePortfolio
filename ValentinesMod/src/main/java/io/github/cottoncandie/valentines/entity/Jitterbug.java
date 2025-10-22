package io.github.cottoncandie.valentines.entity;

import io.github.cottoncandie.valentines.goals.JitterbugJumpGoal;
import io.github.cottoncandie.valentines.init.EntityInit;
import io.github.cottoncandie.valentines.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class Jitterbug extends Animal {

    private int jumpCooldown = 0;

    public Jitterbug(EntityType<? extends Jitterbug> type, Level level) {
        super(type, level);
    }

    public Jitterbug(Level level, double x, double y, double z) {
        this(EntityInit.JITTERBUG.get(), level);
        setPos(x, y, z);

    }

    public Jitterbug(Level level, BlockPos pos) {
        this(level, pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob ageableMob) {
        return new Jitterbug(level, this.blockPosition());
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.5D, Ingredient.of(Items.HONEY_BOTTLE, ItemInit.PASSIONFRUIT.get()), false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 10f));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(8, new JitterbugJumpGoal(this, this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return AgeableMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0)
                .add(Attributes.MOVEMENT_SPEED, .25)
                .add(Attributes.JUMP_STRENGTH, 0.5);
    }

    public static boolean canSpawn(EntityType<Jitterbug> type, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return Animal.checkAnimalSpawnRules(type, level, spawnType, pos, random);
    }

    public int getJumpCooldown() {
        return jumpCooldown;
    }

    public void setJumpCooldown(int jc) {
        this.jumpCooldown = jc;
    }

    @Override
    public void tick() {
        if(jumpCooldown>0) {
            jumpCooldown--;
        }
        super.tick();
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if(isFavouriteFood(stack)) {
            this.usePlayerItem(player, hand, stack);
            this.heal(4.0f);

            if(this.isBaby()) {
                this.ageUp(2400);
            } else if(!this.isInLove()) {
                this.setInLove(player);
            }

            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    private boolean isFavouriteFood(ItemStack stack) {
        return stack.is(Items.HONEY_BOTTLE) || stack.is(ItemInit.PASSIONFRUIT.get());
    }
}
