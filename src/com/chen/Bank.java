package com.chen;

import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;

import java.awt.*;
import java.util.Scanner;

/**
 * @auther chen
 * @creath 2020-08-02 19:35
 */
public class Bank {
    private User[] users = new User[5];
    private int size;

    public void initial() {
        User u1 = new User();
        u1.setCardNo("123456789");
        u1.setIdentity("123456");
        u1.setUserNname("曹操");
        u1.setPassword("123456");
        u1.setPhone("134123123123");
        u1.setBalance(10000);

        User u2 = new User("987654321", "654321", "刘备", "654321", "134321321321", 20000);
        users[0] = u1;
        users[1] = u2;
        size = 2;
    }

    public Bank() {
        initial();
    }

    public void login() {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入卡号：");
        String cardNo = s.next();
        System.out.println("请输入密码：");
        String password = s.next();
        User u =null;
        for (int i = 0; i < size; i++) {
            if (users[i].getCardNo().equals(cardNo)&&users[i].getPassword().equals(password)){
                u = users[i];
                break;
            }
        }
        if (u != null){
            showMenu(u);
        }else{
            System.out.println("请输入正确的卡号或密码");
        }
    }
    public void showMenu(User u){
        Scanner s = new Scanner(System.in);
        System.out.println("欢迎");
        System.out.println("请选择菜单");
        do {
            System.out.println("1.存款  2.取款  3.转账  4.查询余额  5.修改密码  0.退出");
            byte choice = s.nextByte();
            switch (choice){
                case 1:
                    this.save(u);
                    break;
                case 2:
                    this.withDraw(u);
                    break;
                case 3:
                    this.trans(u);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    break;
                default:
                    break;

            }
        } while (true);
    }
    public void save(User u){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入存款金额");
        int i = s.nextInt();
        if (i > 0){
            u.setBalance(u.getBalance() + i);
            System.out.println("存钱成功 余额：" + u.getBalance());
        }else {
            System.out.println("请输入正确金额");
        }
    }
    public void withDraw(User u){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入取款金额");
        int i = s.nextInt();
        if (i < u.getBalance()){
            u.setBalance(u.getBalance()-i);
            System.out.println("取款成功 余额："+ u.getBalance());
        }else {
            System.out.println("取款失败，余额不足");
        }
    }
    public void trans(User u){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入转账卡号");
        String cardNo = s.next();
        System.out.println("请输入转账金额");
        double v = s.nextDouble();
        User toUser = null;
        for (int i = 0; i < size; i++) {
            if (users[i].getCardNo().equals(cardNo)){
                toUser = users[i];
                break;
            }
        }
        if (toUser != null){
            if (v < u.getBalance()){
                u.setBalance(u.getBalance()-v);
                toUser.setBalance(toUser.getBalance()+v);
                System.out.println("转账成功");
            }else {
                System.out.println("转账失败，余额不足");
            }
        }else {
            System.out.println("卡号不存在");
        }

    }

}
