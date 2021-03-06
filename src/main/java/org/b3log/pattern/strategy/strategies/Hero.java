package org.b3log.pattern.strategy.strategies;

import lombok.Data;
import org.b3log.pattern.state.Attack;

/**
 * @author : yu.zhang
 * Date : 2018/10/1 下午3:04
 * Email : zephyrjung@126.com
 **/
@Data
public abstract class Hero {
    protected Attack attack;

    public abstract void init();

    /**
     * 普通攻击
     */
    public abstract void attack();

    /**
     * 被动
     */
    public abstract void passiveSkill();

    /**
     * 一技能
     */
    public abstract void firstSkill();

    /**
     * 二技能
     */
    public abstract void secondSkill();

    /**
     * 大招
     */
    public abstract void finalSkill();

    /**
     * 说台词
     */
    public abstract void speak();
}
