package org.b3log.pattern.state;

/**
 * @author : yu.zhang
 * Date : 2018/10/10 下午5:17
 * Email : yu.zhang@7fresh.com
 **/
public class CritAttackState implements AttackState {
    @Override
    public int harmValue(int baseHarm, int extraHarm) {
        return baseHarm + extraHarm * 10;
    }
}
