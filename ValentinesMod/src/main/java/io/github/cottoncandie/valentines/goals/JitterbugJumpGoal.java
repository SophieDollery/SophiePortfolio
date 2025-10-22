package io.github.cottoncandie.valentines.goals;

import io.github.cottoncandie.valentines.entity.Jitterbug;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.JumpGoal;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.Minecart;

public class JitterbugJumpGoal extends JumpGoal {
    private final PathfinderMob mob;
    private int jumpCount;
    private Jitterbug jitterbug;

    private static final int MAX_JUMPS = 3;
    private static final int COOLDOWN = 1200;

    public JitterbugJumpGoal(PathfinderMob m, Jitterbug bug) {
        this.mob = m;
        this.jitterbug = bug;
    }

    @Override
    public boolean canUse() {
        return this.mob.onGround() && jitterbug.getJumpCooldown()<=0;
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean canContinueToUse() {
        return jumpCount>0;
    }

    @Override
    public void tick() {
        if(mob.onGround()&&jumpCount>0) {
            this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(0, 0.5, 0));
            jumpCount--;
        }
    }

    @Override
    public void start() {
        jumpCount = MAX_JUMPS;
        jitterbug.setJumpCooldown((COOLDOWN/2)+(int)(Math.random()*COOLDOWN));
    }
}
