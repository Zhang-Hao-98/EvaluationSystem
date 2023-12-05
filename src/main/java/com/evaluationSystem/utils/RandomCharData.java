package com.evaluationSystem.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class RandomCharData {
    //可以将字符转换赋值给int类型，查看其ASCII码
    public static void main(String[] args) {
        //随机生成纯数字
        for(int i=0;i<15;i++) {
            createData(20);
        }
        log.info("---------------");

        //生成数字字母
        for(int i=0;i<15;i++) {
            createRandomCharData(20);
        }
    }
    //根据指定长度生成字母和数字的随机数
    //0~9的ASCII为48~57
    //A~Z的ASCII为65~90
    //a~z的ASCII为97~122
    public static String createRandomCharData(int length)
    {
        StringBuilder sb=new StringBuilder();
        Random rand=new Random();//随机用以下三个随机生成器
        Random randData=new Random();
        int data=0;
        for(int i=0;i<length;i++)
        {
            int index=rand.nextInt(2);
            //目的是随机选择生成数字，大小写字母
            switch(index)
            {
                case 0:
                    data=randData.nextInt(10);//仅仅会生成0~9
                    sb.append(data);
                    break;
                case 1:
                    do {
                        data = randData.nextInt(26) + 65;//保证只会产生65~90之间的整数
                    } while (data==73||data ==79);  // 当随机出I和O时重新随机
                    sb.append((char)data);
                    break;
            }
        }
        String result=sb.toString();
        log.info(result);
        return result;
    }

    //根据指定长度生成纯数字的随机数
    public static void createData(int length) {
        StringBuilder sb=new StringBuilder();
        Random rand=new Random();
        for(int i=0;i<length;i++)
        {
            sb.append(rand.nextInt(10));
        }
        String data=sb.toString();
        log.info(length+" random data: "+data);
    }
}
