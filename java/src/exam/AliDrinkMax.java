package exam;

import java.util.Scanner;

/**
 * 阿里巴巴的食堂搞活动促销，已知某饮料1瓶3元钱，4个瓶盖可以换一瓶，2个空瓶可以换一瓶，则30元最多可以喝几瓶。
 输入：
 A   //A表示饮料单价
 B  //B表示瓶盖换瓶比
 C  //C表示空瓶换瓶比
 D  //D表示给定的钱数
 输出：S
 例：
 输入：
 3
 4
 2
 30
 输出:
 35
 */
public class AliDrinkMax implements ITestRun {

    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        int res;

        int _price;
        _price = Integer.parseInt(in.nextLine().trim());

        int _cap;
        _cap = Integer.parseInt(in.nextLine().trim());

        int _emptyBottle;
        _emptyBottle = Integer.parseInt(in.nextLine().trim());

        int _money;
        _money = Integer.parseInt(in.nextLine().trim());

        res = maxMount(_price, _cap, _emptyBottle, _money);
        System.out.println(String.valueOf(res));
    }

    private int maxMount(int price, int cap, int emptyBottle, int money) {
        int maxMount = money/price;
        int capNum = maxMount;
        int emptyBottleNum = maxMount;
        while (capNum >= cap || emptyBottleNum >= emptyBottle){
            int temp = capNum/cap;
            capNum = capNum%cap;
            temp += emptyBottleNum/emptyBottle;
            emptyBottleNum = emptyBottleNum%emptyBottle;
            maxMount += temp;
            capNum += temp;
            emptyBottleNum += temp;
        }
        return maxMount;
    }


}
