package kiosk;

import java.util.ArrayList;
import java.util.Scanner;

public class Printer {

    Scanner in=new Scanner(System.in);

    public int printMainPage(){
        System.out.print("""
                \n=====홈=====
                
                1. 햄버거
                2. 사이드
                3. 음료
                4. 장바구니
                5. 종료
                
                메뉴선택:\s""");
        int input=in.nextInt();
        return input;
    }

    public int printBurgerPage(){
        System.out.print("""
                \n=====햄버거 메뉴=====
                
                1. 와퍼 (6900원)
                2. 큐브 스테이크 와퍼 (8900원)
                3. 콰트로 치즈 와퍼 (7900원)
                4. 몬스터 와퍼 (9300원)
                5. 통새우 와퍼 (7900원)
                6. 블랙바베큐 와퍼 (9300원)
                
                메뉴선택 (0을 선택 시 홈으로):\s""");
        int input=in.nextInt();
        if(input<0||input>6) return -1;
        return input;
    }

    public int printSidePage(){
        System.out.print("""
                \n=====사이드 메뉴=====
                
                1. 너겟킹 (2500원)
                2. 해쉬 브라운 (1800원)
                3. 치즈스틱 (1200원)
                4. 어니언링 (2400원)
                5. 바삭킹 (3000원)
                6. 감자튀김 (2000원)
                
                메뉴선택 (0을 선택 시 홈으로):\s""");
        int input=in.nextInt();
        if(input<0||input>6) return -1;
        return input;
    }

    public int printDrinkPage(){
        System.out.print("""
                \n=====음료 메뉴=====
                
                1. 코카콜라 (2000원)
                2. 코카콜라 제로 (2000원)
                3. 펩시 (2000원)
                4. 펩시 제로 (2000원)
                5. 스프라이트 (2000원)
                6. 스프라이트 제로 (2000원)
                
                메뉴선택 (0을 선택 시 홈으로):\s""");
        int input=in.nextInt();
        if(input<0||input>6) return -1;
        return input;
    }
    public int printCartPage(ArrayList<Menu> myMenu){
        int sum=0;
        System.out.println("\n===== 장바구니 =====\n");
        for(Menu menu:myMenu){
            sum+=menu.getPrice()*menu.getCount();
            System.out.println("- "+menu.getName()+" "+menu.getCount()+"개");
        }
        System.out.println("\n====================");
        System.out.printf("""
                1. 주문하기\s
                2. 수량 조절하기
                3. 삭제하기\s
                
                총 가격: %d원
                
                메뉴선택 (0을 선택 시 홈으로):\s""",sum);
        int input=in.nextInt();
        return input;
    }

    public int[] printEditPage(ArrayList<Menu> myMenu){
        System.out.println("""
                \n===== 수량 조절하기 =====
                
                현재 장바구니
                """);
        for(int i=0;i<myMenu.size();i++){
            System.out.println((i+1)+". "+myMenu.get(i).getName()+" "+myMenu.get(i).getCount()+"개");
        }
        System.out.print("\n수량을 조절할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
        int menuNum=in.nextInt();
        if(menuNum==0) return null;
        int[] menuEdit={-1,-1};
        if(myMenu.size() < menuNum || menuNum < 0) {
            return menuEdit;
        }
        System.out.print("변경할 수량을 입력하세요: ");
        int menuCount=in.nextInt();
        if(menuCount>50||menuCount<1){
            return menuEdit;
        }
        menuEdit[0]=menuNum;
        menuEdit[1]=menuCount;
        return menuEdit;
    }

    public int printDeletePage(ArrayList<Menu> myMenu){
        System.out.println("""
                \n===== 삭제하기 =====
                
                현재 장바구니
                """);
        for(int i=0;i<myMenu.size();i++){
            System.out.println((i+1)+". "+myMenu.get(i).getName()+" "+myMenu.get(i).getCount()+"개");
        }
        System.out.print("\n삭제할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
        int menuDelete=in.nextInt();
        if(menuDelete==0) return 0;
        if(myMenu.size() < menuDelete || menuDelete < 0) return -1;
        System.out.print("정말 삭제 하시겠습니까? (0: 취소 및 홈으로 1: 삭제): ");
        int check=in.nextInt();
        if(check==1) return menuDelete;
        if(check==0) return 0;
        else return -1;
    }

}
