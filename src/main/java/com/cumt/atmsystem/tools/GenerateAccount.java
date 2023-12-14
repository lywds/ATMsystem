package com.cumt.atmsystem.tools;

import java.util.Random;

public class GenerateAccount {
     public static void main(String[] args) {
            String bankCardNumber = generateBankCardNumber();
            System.out.println("生成的银行卡号：" + bankCardNumber);
        }

        public static String generateBankCardNumber() {
            // 第一位为银联卡，即6
            StringBuilder bankCardNumber = new StringBuilder("6");

            // 生成14~17位的随机数字
            Random random = new Random();
            for (int i = 0; i < 14; i++) {
                bankCardNumber.append(random.nextInt(10));
            }

            // 生成校验位，这里简单地生成一个随机数字作为校验位
            bankCardNumber.append(random.nextInt(10));

            return bankCardNumber.toString();
        }

}
