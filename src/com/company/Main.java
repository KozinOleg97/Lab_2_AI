package com.company;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        String endSymb = "1";
        //List<Elem> allElems = new ArrayList<Elem>();
        //Map<String, Elem> allElems = new HashMap<String, Elem>();

        //Graph graph = new Graph();
        GraphMatrSmej myGraph = new GraphMatrSmej(10);

        Scanner in = new Scanner(System.in);

        while (endSymb != "0") {
            System.out.println("0 - Выход; 1 - Ввод узла; 2 - Ввод связи; 3 - Вывод графа");
            System.out.println("4 - Удалить узел; 5 - Удалить связь; 6 - Добавить атриьут;");
            endSymb = in.nextLine();

            switch (endSymb) {
                case "0":
                    System.out.println("Выход");
                    endSymb = "0";
                    break;
                case "1":
                    System.out.println("Введи имя нового понятия");
                    String curName = in.nextLine();
                    myGraph.addVertex(curName);
                    break;
                case "2":
                    try {
                        System.out.println("Введите по типу: 'Понятие1' 'Понятие2' 'Связь'");
                        String elem1 = in.next();
                        String elem2 = in.next();
                        String connection = in.next();
                        in.nextLine();

                        myGraph.addNode(elem1, elem2, connection);
                    } catch (Exception e) {
                        System.out.println("Err: При создании связи");
                        endSymb = "0";
                    }
                    break;
                case "3":
                    myGraph.printAll();

                    break;
                case "4":
                    System.out.println("Введи имя Понятия для удаления");
                    String curNameToDel = in.nextLine();
                    myGraph.delVertex(curNameToDel);
                    break;

                case "5":
                    System.out.println("Введи имя Связи для удаления");
                    curNameToDel = in.nextLine();
                    myGraph.delVertex(curNameToDel);
                    break;

                case "6":
                    System.out.println("Введите по типу: 'Понятие1' 'Понятие2' 'Атрибут' 'Значение'");
                    String elem1 = in.next();
                    String elem2 = in.next();
                    String atr1 = in.next();
                    String atr2 = in.next();
                    in.nextLine();

                    myGraph.addAtr(elem1, elem2, atr1, atr2);
                    break;
                default:
                    System.out.println("Ошибка ввода");

            }


        }
        in.close();
    }
}
