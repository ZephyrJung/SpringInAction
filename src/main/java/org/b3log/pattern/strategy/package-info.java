/**
 * @author Zhang Yu
 * Date: 18年3月30日
 * Email: 2895205695@qq.com
 *
 * 策略模式，我理解的应该是这种情况：
 * 首先有多个策略执行人，其次有多个策略，然后还有多个执行动作
 * 每个策略有不同的执行动作，每个执行人应对不同的请求会执行不同的策略
 * 比如，请求是不同的食材，策略是怎么做，执行动作有煎炒烹炸
 * 对于同一条鱼，奶奶可能做出来的是红烧鱼，爷爷可能做出来的是糟鱼，妈妈可能做出来的是糖醋鱼，爸爸可能做出来的是水煮鱼，
 * 每种做法包含了一系列的动作。而如何做，取决于孩子要求食材的属性
 */
package org.b3log.pattern.strategy;