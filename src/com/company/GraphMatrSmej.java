package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GraphMatrSmej {

    NodeStruct[][] matrSmej;
    Map<String, Integer> vertexes = new HashMap<String, Integer>();
    int numbOfVertex = 0;


    public GraphMatrSmej() {
        matrSmej = new NodeStruct[10][10];
        graphFil();
    }

    public GraphMatrSmej(int size) {
        matrSmej = new NodeStruct[size][size];
        graphFil();
    }

    private void graphFil() {
        for (int i = 0; i < matrSmej.length; i++) {
            for (int j = 0; j < matrSmej.length; j++) {
                matrSmej[i][j] = new NodeStruct();
            }
        }

    }

    public void addVertex(String name) {
        vertexes.put(name, numbOfVertex);
        numbOfVertex++;
    }

    public void delVertex(String name) {
        int numbOfVertex = vertexes.get(name);
        vertexes.remove(name);

        for (int i = 0; i < matrSmej.length; i++) {
            matrSmej[i][numbOfVertex].clear();
            matrSmej[numbOfVertex][i].clear();
        }
    }


    private String getNameByIndex(int index) {
        Set<Map.Entry<String, Integer>> entrySet = vertexes.entrySet();

        Integer desiredIndex = index;//что хотим найти
        for (Map.Entry<String, Integer> pair : entrySet) {
            if (desiredIndex.equals(pair.getValue())) {
                return pair.getKey();// нашли наше значение и возвращаем  ключ
            }
        }
        return "-no-";
    }

    public void addNode(String nameOfVertex1, String nameOfVertex2, String name) {
        Integer index1 = vertexes.get(nameOfVertex1);
        Integer index2 = vertexes.get(nameOfVertex2);

        matrSmej[index1][index2].name = name;
    }

    public void addAtr(String nameOfVertex1, String nameOfVertex2, String key, String value) {
        matrSmej[vertexes.get(nameOfVertex1)][vertexes.get(nameOfVertex2)].addAtr(key, value);

    }



    /*public void addAtr(String nameOfVertex1, String nameOfVertex2, String key, String value) {
        matrSmej[vertexes.get(nameOfVertex1)][vertexes.get(nameOfVertex2)].addAtr(key, value);

    }*/

    public void delNode(String nameOfVertex1, String nameOfVertex2) {
        matrSmej[vertexes.get(nameOfVertex1)][vertexes.get(nameOfVertex2)].clear();
    }


    public void printAll() {// вывод пустых узлов

     /*   for (int i = 0; i < matrSmej.length; i++) {
            for (int j = 0; j < matrSmej.length; j++) {
                if (matrSmej[i][j].name == "-" && matrSmej[j][i].name == "-") {
                    if (vertexes.get(getNameByIndex(i)) != null) {
                        System.out.println(getNameByIndex(i) + " ---/---> ");
                    }
                }
            }
        }*/

        System.out.println("Вершины:");

        for (Map.Entry<String, Integer> entry : vertexes.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println(value + ")" + " *" + key);
        }

        System.out.println("Сеть");


        for (int i = 0; i < matrSmej.length; i++) {
            for (int j = 0; j < matrSmej.length; j++) {
                if (matrSmej[i][j].name != "-") {
                    System.out.println(getNameByIndex(i) + " --- " +
                            matrSmej[i][j].name + " ---> " +
                            getNameByIndex(j));

                    Map<String, String> map = matrSmej[i][j].getAtrs();


                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();

                        System.out.println("-- " + key + " -> " + value);
                    }


                } else {

                }
            }
        }


    }

}
