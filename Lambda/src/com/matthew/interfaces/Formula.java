package com.matthew.interfaces;

/**
 * @Author: L.T.J
 * @project Lambda
 * @package com.matthew.interfaces
 * @CreateDate: 2019/9/6 13:49
 * @Version: 1.0
 */
public interface Formula {
    double calculate(int a);

    default double sqrt(int a){
        return Math.sqrt(a);
    }
}
