package main;

import entity.QuestionContainer;
import utils.FileUtil;

import java.io.File;
import java.util.Scanner;

/**
 * 程序入口类
 */
public class Application {

    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Application app = new Application();
        while(true) {
            app.menu();
        }
    }

    /**
     * 主界面函数
     */
    public void menu() {
        System.out.println("***********欢迎使用四则运算题目生成程序***********");
        System.out.println("***************请输入以下选项序号***************");
        System.out.println("1. 生成题目");
        System.out.println("2. 批改题目");
        System.out.println("3. 退出程序");
        System.out.print("/>");
        int i = Integer.parseInt(sc.nextLine());
        switch (i) {
            case 1 : {
                gQuestionMenu();
                break;
            }
            case 2 : {
                correctMenu();
                break;
            }
            case 3 : {
                System.out.println("程序已退出，欢迎您下次使用~");
                System.exit(0);
            }
            default: {
                System.out.println("没有此选项，请重新输入！");
            }
        }
    }

    /**
     * 生成题目界面函数
     */
    public void gQuestionMenu() {
        System.out.println("************请输入您要生成的题目个数*************");
        System.out.print("/>");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("*************请输入题目数值取值范围**************");
        System.out.print("/>");
        int r = Integer.parseInt(sc.nextLine());
        QuestionContainer container = new QuestionContainer(n, r);
        // 生成题目与答案
        container.loadQuestions();
        // 保存题目与答案
        container.save();
        System.out.println("已成功题目文本和答案文本在程序所在路径下output文件夹");
        // 退出
        System.out.println("程序已退出，欢迎您下次使用~");
        System.exit(0);
    }

    /**
     * 批改作业界面函数
     */
    public void correctMenu() {
        System.out.println("************请输入题目文本的绝对路径*************");
        System.out.print("/>");
        String qPath = sc.nextLine();
        System.out.println("************请输入答案文本的绝对路径*************");
        System.out.print("/>");
        String aPath = sc.nextLine();
        FileUtil.CorrectingOutput(new File(qPath), new File(aPath));
        System.out.println("批改作业结果已成功生成题目文本所在目录下！");
        // 退出
        System.out.println("程序已退出，欢迎您下次使用~");
        System.exit(0);
    }
}
