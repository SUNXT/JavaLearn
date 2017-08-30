package exam;

import java.util.Scanner;


/**
 * 题目：
 * 跑的快是一款老少皆宜的牌类游戏，这里暂时考虑一副牌4个人玩的情况，基本规则如下：
 扣除大小王，每个人13张牌，不考虑花色
 单牌：一张一张的出牌，大小顺序是2>A>K>Q>J>10>9>8>7>6>5>4>3。
 顺子：5张以上连续的单牌，最大JQKA2，最小A2345
 对子：成双出牌，大小顺序：2对>A对>K对>Q对>J对>10对>9对>8对>7对>6对>5对>4对>3对。
 连对：两个及以上相连的对子比如：2233 778899 其中2233也可以连，但是是最小的连队，AA2233是最小的三连对。
 三带一：三张相同的牌可带一张单牌，最大三个2，三个对应牌大过对方即可，带1个的随机。
 炸弹：四个相同的牌，可以大过其他牌，最大四个2
 为简化起见
 1，输入输出，10用字符I表示，且所有字符都大写
 2，出牌时，对于能大过的请输出最小的能大过的牌即可
 3，本次答题可以暂不考虑三带一规则
 */
public class AliTestCardsGame {

    public static void run(){
        Scanner scanner = new Scanner(System.in);
        String mCards = scanner.nextLine();
        String lastCards = scanner.nextLine();
        System.out.println(process(mCards, lastCards));
    }

    public static String process(String mCards, String lastCards){
        String result = "";
        int mCardsAry[] = transIntArrays(mCards);
        int lastCardAry[] = transIntArrays(lastCards);
        switch (lastCardAry.length){
            case 1:

                break;
            case 2:
            case 4:
            case 6:
                break;

        }
        return result;
    }

    public static int[] transIntArrays(String string){
        int ary[] = new int[string.length()];
        int temp;
        for(int i = 0; i < ary.length; ++i){
            temp = (int) string.charAt(i);
            if (temp == 75){
                temp += 10;
            }else if(temp == 65){
                temp += 30;
            }else if (temp == 50){
                temp += 50;
            }
            ary[i] = temp;
        }
        return ary;
    }
}
