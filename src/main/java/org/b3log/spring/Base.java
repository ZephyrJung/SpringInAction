package org.b3log.spring;

import javax.annotation.PostConstruct;

/**
 * @author : yu.zhang
 * Date : 2018/11/12 7:50 PM
 * Email : yu.zhang@7fresh.com
 **/

public abstract class Base {
    @PostConstruct
    public void print() {
        System.out.println("Hello");
    }
}
