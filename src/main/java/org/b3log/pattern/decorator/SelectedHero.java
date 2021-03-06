package org.b3log.pattern.decorator;

import lombok.Data;
import org.b3log.pattern.strategy.strategies.Hero;

/**
 * @author : yu.zhang
 * Date : 2018/10/10 下午1:48
 * Email : zephyrjung@126.com
 **/
@Data
public class SelectedHero extends Hero {
    private Hero hero;

    public SelectedHero() {
    }

    public SelectedHero(Hero hero) {
        this.hero = hero;
    }

    public void goBackHome() {
        System.out.println("三十六计走为上计~");
    }

    @Override
    public void init() {
        hero.init();
    }

    @Override
    public void attack() {
        hero.attack();
    }

    @Override
    public void passiveSkill() {
        hero.passiveSkill();
    }

    @Override
    public void firstSkill() {
        hero.firstSkill();
    }

    @Override
    public void secondSkill() {
        hero.secondSkill();
    }

    @Override
    public void finalSkill() {
        hero.finalSkill();
    }

    @Override
    public void speak() {
        hero.speak();
    }
}
