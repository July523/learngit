package basic;//在之前的基础上做了一些修改，驼峰命名问题做了调整，做了方法的封装,优化了许多方法，主要是算法的简单和使用，以及对多于代码的删除
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
            while (true) {
                System.out.println("*********学生管理系统*********");
                System.out.println("        1.查看学生信息");
                System.out.println("        2.增加学生");
                System.out.println("        3.修改学生");
                System.out.println("        4.删除学生");
                System.out.println("        5.将绩点排序后输出");
                System.out.println("        6.退出此系统");//这种作用的的东西还是要写一下的
                Scanner shuru = new Scanner(System.in);
                System.out.println("请选择功能：");
                String gongNeng = shuru.nextLine();
                switch (gongNeng) {
                    case "1":
                        Method.findstudent();
                        break;
                    case "2":
                        Method.addstudent();
                        break;
                    case "3":
                        Method.changestudent();
                        break;
                    case "4":
                        Method.deletestudent();
                        break;
                    case "5":
                        ArrayList jihe = Method.readIn();
                        Method.jidianSort(jihe);
                        break;
                    case "6"://没东西直接跳过进行下一种情况
                    default:
                        System.out.println("谢谢你的使用.");
                        System.exit(0);//百度到的方法可以退出系统
                        break;
                }
            }
        }
    }
//暂未解决问题，修改和排序(如果以后忘了删，请忽略这个注释，解决后我就会删掉它，哈哈哈~~~~~~)