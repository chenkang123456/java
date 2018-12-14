package java代码;

import java.util.*;

import java.util.Map.Entry;

import java.util.stream.Collectors;

 

class Stu {// 学生类

    private String name;

    private int score;// 成绩

 

    public Stu(String name, int score) {

        this.name = name;

        this.score = score;

    }

    public double getScore() {

        return score;

    }

    public void setScore(int score) {

        this.score = score;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

}

 

//测试类

public class listtop10 {

    public static void main(String[] args) {

        List<Stu> stus = Arrays.asList(new Stu("Tom", 1), new Stu("Jack", 2), new Stu("Amdy", 3),

                new Stu("Lucy", 4), new Stu("Cherry", 5), new Stu("Jerry", 6), new Stu("Sweet", 7),

                new Stu("Solem", 8));

        fun1(stus);

        System.out.println("---------------分割线---------------------");

       
    }

 

    // 方法一:传统的方法

    public static void fun1(List<Stu> stus) {

        // 按照成绩排序

        stus.sort(new Comparator<Stu>() {

            @Override

            public int compare(Stu s1, Stu s2) {

                return -Double.compare(s1.getScore(), s2.getScore());

            }

        });

        int index = 0;// 排名

        double lastScore = -1;// 最近一次的分

 

        for (int i = 0; i < stus.size(); i++) {

            Stu s = stus.get(i);

            if (Double.compare(lastScore, s.getScore())!=0) { // 如果成绩和上一名的成绩不相同,那么排名+1

                lastScore = s.getScore();

                index++;

            }

            System.out.println("名次:" + index + "\t分数" + s.getScore() + "\t名字" + s.getName());

        }

    }  

}