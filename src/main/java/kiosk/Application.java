package kiosk;

import java.util.ArrayList;

public class Application {

    ArrayList<Menu> menuList;
    ArrayList<Menu> myMenu;


    public static void main(String[] args) {
        Application application=new Application();

            application.run();

    }


    public Application(){
        myMenu=new ArrayList<>();
        menuList=new ArrayList<>();
        MenuList.makeList(menuList);
    }


    int checkDuplication(Menu thisMenu){
        for(int i=0;i<myMenu.size();i++){
            if(myMenu.get(i).equals(thisMenu)) return i;
        }
        return -1;
    }


    void addMenu(int num, String type){
        for (Menu menu : menuList) {
            if (menu.getType().equals(type+num)) {
                int check = checkDuplication(menu);
                if (check < 0) myMenu.add(menu);
                else myMenu.get(check).setCount(myMenu.get(check).getCount() + 1);
            }
        }
    }


    public void run() throws IllegalArgumentException{
        Printer printer=new Printer();
        int flag=1;
        while(flag==1){
            int mainPage=printer.printMainPage();
            switch(mainPage) {
                case 1: {
                    int burger = printer.printBurgerPage();
                    if (burger == 0) break;
                    if(burger == -1) throw new IllegalArgumentException("Wrong Input\n");
                    addMenu(burger,"burger");
                    break;
                }
                case 2: {
                    int side = printer.printSidePage();
                    if (side == 0) break;
                    if(side==-1) throw new IllegalArgumentException("Wrong Input\n");
                    addMenu(side,"side");
                    break;
                }
                case 3: {
                    int drink = printer.printDrinkPage();
                    if (drink == 0) break;
                    if(drink==-1) throw new IllegalArgumentException("Wrong Input\n");
                    addMenu(drink,"drink");
                    break;
                }
                case 4:{
                    while(true){
                        int cart=printer.printCartPage(myMenu);
                        if(cart==1){
                            System.out.println("주문이 완료되었습니다!");
                            flag=0;
                            break;
                        }
                        else if(cart==2){
                            int[] edit=printer.printEditPage(myMenu);
                            if(edit==null) break;
                            else if(edit[0]==-1){
                                throw new IllegalArgumentException("Wrong Input\n");
                            }
                            else{
                                myMenu.get(edit[0]-1).setCount(edit[1]);
                            }
                        }
                        else if(cart==3){
                            int delete=printer.printDeletePage(myMenu);
                            if(delete==-1) throw new IllegalArgumentException("Wrong Input\n");
                            if(delete!=0){
                                myMenu.get(delete-1).setCount(1);
                                myMenu.remove(delete-1);
                            }
                            else break;
                        }
                        else if(cart==0) break;
                        else throw new IllegalArgumentException("Wrong Input\n");
                    }
                    break;
                }
                case 5:{
                    System.out.println("종료합니다.");
                    flag=0;
                    break;
                }
                default:{
                    throw new IllegalArgumentException("Wrong Input\n");
                }
            }
        }
    }
}