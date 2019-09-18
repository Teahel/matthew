package com.matthew.interfaces;

/**
 * @Author: L.T.J
 * @project Lambda
 * @package com.matthew.interfaces
 * @CreateDate: 2019/9/6 17:57
 * @Version: 1.0
 */
public class Apple {

    public Apple(int weight){
        this.weight=weight;
    }
    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Apple{");
        sb.append("weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}
