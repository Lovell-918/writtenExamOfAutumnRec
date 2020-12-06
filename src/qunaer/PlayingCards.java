package qunaer;

import java.util.Objects;
import java.util.Scanner;

//扑克牌的牌型分析-2021技术
//时间限制： 3000MS
//内存限制： 589824KB
//题目描述：
//德州扑克的花型由N 张扑克牌组成 0 < N < 8，可以组成的牌型按照价值从高到低来区分分别为：
//1.皇家同花顺：最高为Ace（一点）的同花顺。
//如A K Q J 10 的同花顺
//2.同花顺：同一花色，五张顺序的牌。
//如：K Q J 10 9 的同花顺
//3.四条：有四张同一点数的牌。
//如：4 4 4 4 9
//4.葫芦：三张同一点数的牌，加一对其他点数的牌。
//如：3 3 3 10 10
//5.同花：五张同一花色的牌。
//如：J 10 8 7 5 的全是红桃的牌
//6.顺子：五张顺连的牌。
//如：5 4 3 2 A 的非同花牌（此牌型为最小的顺子）
//7.三条：仅有三张同一点数的牌，其余两张点数不同。
//如: 9 9 9 5 3
//8：两对：两张相同点数的牌，加另外两张相同点数的牌。
//如：K K 5 5 2
//9.一对：仅有两张相同点数的牌。
//如：10 10 9 4 2
//10.高牌：不符合上面任何一种牌型的牌型，由单牌且不连续不同花的组成，以点数决定大小。
//如：A 10 9 5 3 的非同花的牌
//这十种牌型分别输出 HuangJiaTongHuaShun、TongHuaShun、SiTiao、HuLu、TongHua、ShunZi、
// SanTiao、LiangDui、YiDui、GaoPai
//扑克牌有4种花色，分别为 （S表示黑桃，H表示红心，C表示草花，D表示方片）
//本题的输入为任意 小于 8 的 N张牌
//得到的结果为这些牌中排序最靠前的类型。
//
//
//输入描述
//2（牌数为2）
//SA HA (两张牌为黑桃A 红心A)
//
//输出描述
//YiDui (结果为一对)
public class PlayingCards {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        Pai[] array=new Pai[len];
        for(int i=0; i<len; ++i){
            array[i]=new Pai(sc.next());
        }


    }

    static class Pai{
        String color;
        int seq;
        public Pai(String input){
            color=input.substring(0,1);
            String s=input.substring(1);
            switch (s) {
                case "A":
                    seq = 1;
                    break;
                case "J":
                    seq=11;
                    break;
                case "Q":
                    seq=12;
                    break;
                case "K":
                    seq=13;
                    break;
                default:
                    seq=Integer.parseInt(s);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pai pai = (Pai) o;
            return seq == pai.seq &&
                    Objects.equals(color, pai.color);
        }

        @Override
        public int hashCode() {
            return Objects.hash(color, seq);
        }
    }
}
