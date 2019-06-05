package basic;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Method {
    //输出学生信息
    public static void findstudent() {
        ArrayList jihe2 = readIn();
        if (jihe2.size() == 0) {
            System.out.println("信息为空，请先输入！！！");
            return;
        } else {
            System.out.println("学号\t姓名\t年龄\t平均绩点");//水平制表
            for (int i = 0; i < jihe2.size(); i++) {
                Student s = (Student) jihe2.get(i);
                System.out.println(s.getNumber() + "     \t" + s.getName() + "     \t" + s.getAge() + "     \t" + s.getJidian());
            }
        }
    }

    //将信息添加到数组当中

        public static void addstudent (){
        try {
            ArrayList jihe =  new ArrayList();
            ArrayList jihe2 = readIn();//将文件中的数据读进去
            Scanner shuru = new Scanner(System.in);
            String stuId;
            while (true) {
                System.out.println("请输入学号：");
                stuId = shuru.nextLine();
                boolean panduan = false;
                for (int i = 0; i < jihe2.size(); i++) {
                    Student s = (Student) jihe2.get(i);
                    if (s.getNumber().equals(stuId)) {
                        panduan = true;
                        break;
                    }
                }
                if (panduan) {
                    System.out.println("您输入的账号被占用！！！");
                } else {
                    break;
                }
            }//判断学号是否重复
            System.out.println("请输入姓名：（中英文都可以）");
            String name = shuru.nextLine();
            System.out.println("请输入年龄：");
            String age = shuru.nextLine();
            System.out.println("请输入平均绩点（输入浮点数,整数其实也可以.可以转化）：");//在设计的时候不太会所有类型都能输入的scanner方法，所以将就一下...
            float jidian = shuru.nextFloat();
            //创建学生对象
            Student s = new Student();
            s.setNumber(stuId);
            s.setName(name);
            s.setAge(age);
            s.setJidian(jidian);
            //把学生对象添加到集合
            jihe.add(s);
            writeOut(jihe);
            System.out.println("添加学生成功！");
        }catch (NullPointerException e){
            System.out.println("catch");
        }
    }


    //删除学生信息
    public static void deletestudent() {
        ArrayList jihe = readIn();
        Scanner shuru = new Scanner(System.in);
        System.out.print("请输入要删除的学号：");
        String deleId = shuru.nextLine();
        for (int i = 0; i < jihe.size(); i++) {
            Student s = (Student) jihe.get(i);
            if (s.getNumber().equals(deleId)) {
                jihe.remove(i);//ArrayList的删除方法
                System.out.println("成功！！");
                writeOutWay2(jihe);//调用直接覆盖掉，简单粗暴
                break;
            } else if(i==jihe.size()-1) {
                System.out.println("不存在，请重新选择！");
            }
        }
    }
    //修改类
    public static void changestudent() {
        ArrayList jihe = readIn();
        Scanner shuru = new Scanner(System.in);
        System.out.print("请输入要修改的学号：");
        String changeId = shuru.nextLine();
        boolean panDuan = true;
        int j = 0;
        for (int i = 0; i < jihe.size(); i++) {
            Student s = (Student) jihe.get(i);
            if (s.getNumber().equals(changeId)) {
                panDuan = false;
                j = i;
            }
        }
        if (panDuan) {
            System.out.println("您要修改的学生不存在，请重新操作！");
        } else {
            System.out.println("请输入学号 ");
            String stuId = shuru.nextLine();
            System.out.println("请输入新姓名：");
            String name = shuru.nextLine();
            System.out.println("请输入新年龄：");
            String age = shuru.nextLine();
            System.out.println("请输入平均绩点：");
            float jidian = shuru.nextFloat();
            //创建学生对象
            Student s = new Student();
            s.setNumber(stuId);
            s.setNumber(changeId);
            s.setName(name);
            s.setAge(age);
            s.setJidian(jidian);
            //修改学生对象
            jihe.set(j, s);//Arraylist的替换方法^_^
            writeOutWay2(jihe);//还是粗暴
            System.out.println("修改学生成功！！！");
        }
    }

    //排序类
    public static void jidianSort(ArrayList jihe2) {
        float temp;
        System.out.println("绩点排序前为");
        System.out.println("学号\t姓名\t年龄\t平均绩点");
        for (int i = 0; i < jihe2.size(); i++) {
            Student s = (Student) jihe2.get(i);
            System.out.println(s.getNumber() + "     \t" + s.getName() + "     \t"+s.getJidian()+"     \t" + s.getJidian());
        }
        for (int i = 0; i < jihe2.size()-1; i++) {
            for (int j = i+1; j < jihe2.size() ; j++) {
                Student s = (Student) jihe2.get(i);
                Student m = (Student) jihe2.get(j);//创建两个可以获得下标的Student对象，与结构体的定义使用类似，上面提到
                if (getBig(s.getJidian(), m.getJidian()) == 1)
                {
                    temp = s.getJidian();//调用比大小函数
                    s.setJidian(m.getJidian());
                    m.setJidian(temp);//交换排序
                }
            }
        }
        System.out.println("绩点排序过后为");
        System.out.println("平均绩点");
        for (int i = 0; i < jihe2.size(); i++) {
            Student s = (Student) jihe2.get(i);//取下标
            System.out.println( s.getJidian());
        }
    }
    static int getBig(float a, float b) {
        if (a >= b) {
            return 1;
        } else return 0;
    }
    //将文件中的数据重新返回数组
    static ArrayList<Student> readIn() {
        ArrayList Arr = new ArrayList<>();//初始化
        try (BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\July\\IdeaProjects\\io\\src\\studata.txt"))) {
            String s = null;
            while ((s = in.readLine())!=null){
                String[] strings = s.split(",");
                Student student = new Student();
                student.setNumber(strings[0]);
                student.setName(strings[1]);
                student.setAge(strings[2]);
                student.setJidian(Float.parseFloat(strings[3]));
                Arr.add(student);
            }
            return Arr;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //数据写入到文件中
    public static void writeOut(ArrayList<Student> Arr){
        //通过过滤器初始化一个对象
        try (BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\July\\IdeaProjects\\io\\src\\studata.txt",true))) {
            for (Student s:Arr) {
                out.write(s.getNumber()+","+s.getName()+","+s.getAge()+","+s.getJidian());
                out.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeOutWay2(ArrayList<Student> Arr){
        //覆盖的方法，却决于后面的参数是什么。
        try (BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\July\\IdeaProjects\\io\\src\\studata.txt"))) {
            for (Student s:Arr) {
                out.write(s.getNumber()+","+s.getName()+","+s.getAge()+","+s.getJidian());
                out.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


