package kiosk;

import java.util.ArrayList;

public class MenuList {

    public static void makeList(ArrayList<Menu> menuList){
        Menu menu=new Menu("burger1","와퍼",6900);
        menuList.add(menu);
        Menu menu1=new Menu("burger2","큐브 스테이크 와퍼",8900);
        menuList.add(menu1);
        Menu menu2=new Menu("burger3","콰트로 치즈 와퍼",7900);
        menuList.add(menu2);
        Menu menu3=new Menu("burger4","몬스터 와퍼",9300);
        menuList.add(menu3);
        Menu menu4=new Menu("burger5","통새우 와퍼",7900);
        menuList.add(menu4);
        Menu menu5=new Menu("burger6","블랙바베큐 와퍼",9300);
        menuList.add(menu5);
        Menu menu6=new Menu("side1","너겟킹",2500);
        menuList.add(menu6);
        Menu menu7=new Menu("side2","헤쉬 브라운",1800);
        menuList.add(menu7);
        Menu menu8=new Menu("side3","치즈스틱",1200);
        menuList.add(menu8);
        Menu menu9=new Menu("side4","어니언링",2400);
        menuList.add(menu9);
        Menu menu10=new Menu("side5","바삭킹",3000);
        menuList.add(menu10);
        Menu menu11=new Menu("side6","감자튀김",2000);
        menuList.add(menu11);
        Menu menu12=new Menu("drink1","코카콜라",2000);
        menuList.add(menu12);
        Menu menu13=new Menu("drink2","코카콜라 제로",2000);
        menuList.add(menu13);
        Menu menu14=new Menu("drink3","펩시",2000);
        menuList.add(menu14);
        Menu menu15=new Menu("drink4","펩시 제로",2000);
        menuList.add(menu15);
        Menu menu16=new Menu("drink5","스프라이트",2000);
        menuList.add(menu16);
        Menu menu17=new Menu("drink6","스프라이트 제로",2000);
        menuList.add(menu17);
    }
}
