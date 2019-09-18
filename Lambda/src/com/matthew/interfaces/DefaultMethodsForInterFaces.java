package com.matthew.interfaces;

/**
 * @Author: L.T.J
 * @project Lambda
 * @package com.matthew.interfaces
 * @CreateDate: 2019/9/6 13:49
 * @Version: 1.0
 */
public class DefaultMethodsForInterFaces {
    public static void main(String args[]){
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a*100);
            }
        };
        System.out.println(formula.calculate(100));
        System.out.println(formula.calculate(16));

    }
}
