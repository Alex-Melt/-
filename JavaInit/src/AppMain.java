import java.util.Scanner;

/*
    请在此文件中完成你的程序设计
 */
public class AppMain {
    public static void main(String[] args) {
        int per_index = 0;
        int index = 0;
        Menu[] menus = new Menu[100];
        Person[] persons = new Person[100];
        menus[index] = new Menu(index + 1, "红烧茄子", 24.00, 0);
        index++;
        menus[index] = new Menu(index + 1, "糖醋排骨", 36.00, 0);
        index++;
        menus[index] = new Menu(index + 1, "鱼香肉丝", 32.00, 0);
        index++;

        Scanner sc = new Scanner(System.in);

        System.out.println("欢迎来带\"漂亮团外卖\"");
        boolean flag = true;
        while (flag) {
            int choose = menu(sc);
            switch (choose) {
                case 0:
                    System.out.println("输入不合法，请重新输入");
                    break;
                case 1: {
                    System.out.println("请输入订餐人姓名：");
                    persons[per_index] = new Person(per_index + 1, sc.next());
                    per_index++;
                    System.out.println("序号" + "\t" + "菜名" + "\t" + "单价" + "\t" + "点赞量");
                    for (int i = 0; i < index; i++) {
                        System.out.println(menus[i].getOd() + "\t" + menus[i].getName() + "\t" + menus[i].getPrice() + "\t" + menus[i].getPraise());
                    }
                    //选菜
                    int tmp_index = 0;
                    Integer[][] tmp_menus = new Integer[100][];
                    do {
                        System.out.println("请选择您想要点的菜品编号：");
                        int tmp_od = 0;
                        while (true) {
                            try {
                                tmp_od = sc.nextInt();
                                break;
                            } catch (Exception e) {
                                sc.next();
                                System.out.println("输入不合法，请重新输入菜品编号");
                            }
                        }
                        System.out.println("请选择您想要点的菜品的份数：");
                        int tmp_od_num = 0;
                        while (true) {
                            try {
                                tmp_od_num = sc.nextInt();
                                break;
                            } catch (Exception e) {
                                sc.next();
                                System.out.println("输入不合法，请重新输入菜品份数");
                            }
                        }
                        tmp_menus[tmp_index] = new Integer[]{tmp_od, tmp_od_num};
                        tmp_index++;
                        System.out.println("退出选择菜单请输入0");
                    } while (!"0".equals(sc.next()));
                    persons[per_index - 1].setMenuNum(tmp_menus);
                    //送餐时间
                    System.out.println("请选输入送餐时间（送餐时间是10点至20点间整点送餐）：");
                    int tmp_time = 10;
                    while (true) {
                        try {
                            tmp_time = sc.nextInt();
                            if (tmp_time<10 | tmp_time>20){
                                System.out.println("您选择的时间不在送餐时间内,再次选择");
                                continue;
                            }
                            persons[per_index - 1].setTime(tmp_time);
                            break;
                        } catch (Exception e) {
                            sc.next();
                            System.out.println("输入不合法，请重新输入时间");
                        }
                    }
                    //送餐地址
                    System.out.println("请输入送餐地址");
                    persons[per_index - 1].setAddress(sc.next());
                    //订单信息
                    System.out.println("订餐成功！！！");
                    System.out.println("您的编号是：" + persons[per_index - 1].getId());
                    System.out.println("您订的是：");
                    int tmp_price = 0;
                    for (int i = 0; i < tmp_index; i++) {
                        System.out.println("\t" + menus[persons[per_index - 1].getMenuNum()[i][0] - 1].getName() + "\t" + persons[per_index - 1].getMenuNum()[i][1] + "份");
                        tmp_price += menus[persons[per_index - 1].getMenuNum()[i][0] - 1].getPrice() * persons[per_index - 1].getMenuNum()[i][1];
                    }
                    System.out.println("送餐时间：" + persons[per_index - 1].getTime() + "点");
                    System.out.println("送餐地址：" + persons[per_index - 1].getAddress());
                    if (tmp_price >= 50) {
                        System.out.println("餐费：" + tmp_price + "元" + "\t"
                                + "免费配送" + "\t" + "总计：" + tmp_price + "元");
                        persons[per_index - 1].setPrices(tmp_price);
                    } else {
                        System.out.println("餐费：" + tmp_price + "元" + "\t"
                                + "送餐费：6元" + "\t" + "总计：" + (tmp_price + 6) + "元");
                        persons[per_index - 1].setPrices(tmp_price + 6);
                    }
                }
                break;
                case 2: {
                    System.out.println("***查看订单信息***");
                    if (per_index > 0) {
                        System.out.println("序号" + "\t" + "订餐人" + "\t" + "餐品信息" + "\t" + "送餐时间" + "\t" + "送餐地址" + "\t" + "总金额" + "\t" + "订单状态" + "\t");
                        for (int i = 0; i < per_index; i++) {
                            StringBuilder tem_info = new StringBuilder();
                            for (Integer[] integers : persons[i].getMenuNum()) {
                                if (integers != null) {
                                    tem_info.append(menus[integers[0] - 1].getName()).append(integers[1]).append("份");
                                }
                            }
                            System.out.println(persons[i].getId() + "\t" + persons[i].getName() + "\t" + tem_info + "\t" + persons[i].getTime() + "点" + "\t" + persons[i].getAddress() + "\t" + persons[i].getPrices() + "元" + "\t" + persons[i].getReserve());
                        }
                    } else {
                        System.out.println("暂无订单信息");
                    }

                }
                break;
                case 3: {
                    System.out.println("***签收订单***");
                    while (true) {
                        System.out.println("请选择要签收的订单的序号：");
                        try {
                            boolean temp_flag = false;
                            int numc = sc.nextInt();
                            for (int i = 0; i < per_index; i++) {
                                if (numc == persons[i].getId()) {
                                    persons[numc - 1].setReserve("已完成");
                                    temp_flag = true;
                                    break;
                                }
                            }
                            if (temp_flag) {
                                System.out.println("订单签收成功");
                                break;
                            } else {
                                System.out.println("暂无此订单，请重新输入");
                            }
                        } catch (Exception e) {
                            sc.next();
                            System.out.println("输入不合法，请重新输入");
                        }
                        System.out.println("输入0返回菜单：");
                        String zero = sc.next();
                        if ("0".equals(zero)) {
                            break;
                        }
                    }
                }
                break;
                case 4: {
                    System.out.println("***删除订单***");
                    while (true) {
                        System.out.println("请选择要删除的订单的序号：");
                        try {
                            boolean temp_flag = false;
                            int numc = sc.nextInt();
                            for (int i = 0; i < per_index; i++) {
                                if (numc == persons[i].getId()) {
                                    if (persons[i].getReserve().equals("已完成")) {
                                        persons[i] = null;
                                        for (int j = i; j < per_index; j++) {
                                            persons[j] = persons[j + 1];
                                            persons[j + 1] = null;
                                        }
                                        per_index--;
                                        System.out.println("订单删除成功");
                                    } else {
                                        System.out.println("订单暂未完成，请稍后删除");
                                    }
                                    temp_flag = true;
                                    break;
                                }
                            }
                            if (temp_flag) {
                                break;
                            } else {
                                System.out.println("暂无此订单，请重新输入");
                            }
                        } catch (Exception e) {
                            sc.next();
                            System.out.println("输入不合法，请重新输入");
                        }
                        System.out.println("输入0返回菜单：");
                        String zero = sc.next();
                        if ("0".equals(zero)) {
                            break;
                        }
                    }
                }
                break;
                case 5: {
                    System.out.println("***我要点赞***");

                    while (true) {
                        for (int i = 0; i < index; i++) {
                            System.out.println(menus[i].getOd() + "\t" + menus[i].getName() + "\t" + menus[i].getPrice() + "\t" + menus[i].getPraise());
                        }
                        System.out.println("请选择要点赞的菜品的序号：");
                        int zan = 0;
                        try {
                            zan = sc.nextInt();
                            while (zan < 1 || zan > index) {
                                System.out.println("您输入的序号错误，再次输入");
                                zan = sc.nextInt();
                            }
                            for (int i = 0; i < index; i++) {
                                if (zan == menus[i].getOd()) {
                                    menus[i].setPraise(menus[i].getPraise() + 1);
                                    System.out.println("点赞成功");
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("您输入的序号错误，再次输入");
                            sc.next();
                            break;
                        }
                        System.out.println("输入0返回菜单：");
                        String zero = sc.next();
                        if ("0".equals(zero)) {
                            break;
                        }
                    }


                }
                break;
                case 6:
                    System.out.println("谢谢使用，欢迎下次光临");
                    flag = false;
                    break;
            }
        }

    }

    public static int menu(Scanner sc) {
        System.out.println("***********");
        System.out.println("1.我要订餐");
        System.out.println("2.我的订单");
        System.out.println("3.签收订单");
        System.out.println("4.删除订单");
        System.out.println("5.我要点赞");
        System.out.println("6.退出系统");
        System.out.println("***********");
        System.out.println("请选择：");
        int i;
        try {
            i = sc.nextInt();
        } catch (Exception e) {
            sc.next();
            i = 0;
        }
        return i;
    }

}
