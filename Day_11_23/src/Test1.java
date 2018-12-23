
class one{
	public one(){
		System.out.println("Hello Constructor");
	}
	public one(String s){
		this();
		System.out.println(s);
	}
}
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new one(args[0]);
	}

}


/**
class Test1{
    public int i;
    public  char a;
    public static  int x=8;//static的成员变量

    public Test1(int i,char a){//构造方法
        this.i=i;
        this.a=a;
    } 
}
public class Test{
    public static void main(String[] args) {
        Test1 test1 = new Test1(1,'a');//创建多个实例
        Test1 test2 = new Test1(2,'b');
        System.out.println("test1-"+test1.i+test1.a+test1.x);
        System.out.println("test2-"+test2.i+test2.a+test2.x);
    }
}*/


/**
class Person{
    public int age;
    public String name;
    public static String country;
}
public class Test1{
    public static void main (String[] args)
    {
        Person per = new Person();
        per.name = "龟田";
        per.age = 1;
        Person.country = "日本";
        
        Person per1 = new Person();
        per1.name = "张三";
        per1.age = 999;
        Person.country = "中国";
        
        System.out.println(per.country);
        System.out.println(per1.country);
    }

}


*/