package org.b3log.pattern.state;

/**
 * @author : yu.zhang
 * Date : 2018/10/10 下午5:18
 * Email : zephyrjung@126.com
 **/
public interface AttackState {
    int harmValue(int baseHarm, int extraHarm);
}
