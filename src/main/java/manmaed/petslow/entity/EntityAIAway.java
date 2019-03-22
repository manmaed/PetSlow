package manmaed.petslow.entity;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityTameable;

/**
 * Created by manmaed on 22/03/2019.
 */
public class EntityAIAway extends EntityAIBase {

    private final EntityTameable entity;
    private boolean isaway;
    private  int cooldown = -1;

    public EntityAIAway(EntityTameable entityIn) {
        this.entity = entityIn;
        this.cooldown = this.entity.getRNG().nextInt(500);
    }


    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute() {
        if (this.entity.isSitting()) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        if (this.isaway && this.cooldown == 0) {
            this.setAway(false);
            this.cooldown = this.entity.getRNG().nextInt(500);
        }
        if(!this.isaway && this.cooldown == 0) {
            this.setAway(true);
            this.cooldown = this.entity.getRNG().nextInt(500);
        }
    }

    public void setAway(boolean away) {
        this.isaway = away;
    }
    public boolean isAway() {
         return this.isaway;
    }
}
/*
if (this.isaway && this.cooldown == 0) {
        this.isaway = false;
        this.cooldown = this.entity.getRNG().nextInt(500);
        }
        if(!this.isaway && this.cooldown == 0) {
        this.isaway = true;
        this.cooldown = this.entity.getRNG().nextInt(500);
        }
        return this.isaway;*/
