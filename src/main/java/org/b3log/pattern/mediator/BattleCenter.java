package org.b3log.pattern.mediator;

import org.b3log.pattern.proxy.Player;

/**
 * @author : yu.zhang
 * Date : 2018/10/10 下午3:12
 * Email : zephyrjung@126.com
 * 负责英雄之间的技能释放
 **/
public interface BattleCenter {
    void attack(Player a,Player b);

}
