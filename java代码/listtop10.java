package java����;

import java.util.*;

import java.util.Map.Entry;

import java.util.stream.Collectors;

 

class Stu {// ѧ����

    private String name;

    private int score;// �ɼ�

 

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

 

//������

public class listtop10 {

    public static void main(String[] args) {

        List<Stu> stus = Arrays.asList(new Stu("Tom", 1), new Stu("Jack", 2), new Stu("Amdy", 3),

                new Stu("Lucy", 4), new Stu("Cherry", 5), new Stu("Jerry", 6), new Stu("Sweet", 7),

                new Stu("Solem", 8));

        fun1(stus);

        System.out.println("---------------�ָ���---------------------");

       
    }

 

    // ����һ:��ͳ�ķ���

    public static void fun1(List<Stu> stus) {

        // ���ճɼ�����

        stus.sort(new Comparator<Stu>() {

            @Override

            public int compare(Stu s1, Stu s2) {

                return -Double.compare(s1.getScore(), s2.getScore());

            }

        });

        int index = 0;// ����

        double lastScore = -1;// ���һ�εķ�

 

        for (int i = 0; i < stus.size(); i++) {

            Stu s = stus.get(i);

            if (Double.compare(lastScore, s.getScore())!=0) { // ����ɼ�����һ���ĳɼ�����ͬ,��ô����+1

                lastScore = s.getScore();

                index++;

            }

            System.out.println("����:" + index + "\t����" + s.getScore() + "\t����" + s.getName());

        }

    }  

}