package com.sh.zfc.pracitice;

import java.util.*;
import java.util.stream.Collectors;

/*
   马踏棋盘算法， 8*8的国际象棋棋盘，一个马从任何一个位置开始，可以走遍所有位置，且不重复走相同位置。
 */
public class Mataqipan {
    int[][] qipan ;
    List<MyPoint> path;
    int qipanNum = 32;

    public Mataqipan() {
        qipan = new int[qipanNum][qipanNum];
        for (int i = 0; i < qipanNum; i++) {
            for (int j = 0; j < qipanNum; j++) {
                qipan[i][j] = i*qipanNum +1 +j;
            }
        }
        path = new LinkedList<MyPoint>();
    }

    public boolean getPath(int x, int y ){
       // System.out.printf("起点为x=%d , y=%d\n" , x, y);
        // 起点为路径的起点，加入到list中
         MyPoint current = new MyPoint(x,y);
         path.add(current);
         //如果已经走完了，则打印
        if (path.size() == qipanNum*qipanNum) {
            printPath();
            return true;
        }
        //如果还没走完，则获取下一步所有可走的点
         List<MyPoint> nexts = getNexts(x,  y);
        //如果没有可走的点了，则返回false
        if (nexts.size() == 0) {
            path.remove(current);
            return false;
        }
        //贪心算法，把下一步的方格中，按有最少一下一步和方格排在前面，首先遍历。效率提升非常多
        nexts = sortNext(nexts);
        //遍历所有可行的下一步
        for (MyPoint next:nexts) {
            //否则path中加入，以下一个点为起点继续获取path,如果有path则返回true;如果没有path，path中删除 ，则返回false
           //如果下一个点有通路，则返回true
            if(getPath(next.x, next.y)){
                return true;
            }else {//如果下一个点没有通路，则继续遍历

            }
        }
        //如果所有的点都没有通路，则在路径中删除当前结点
        path.remove(current);
        return false;
    }

    private List<MyPoint> sortNext(List<MyPoint> nexts) {
        for (MyPoint next:nexts) {
            next.setNextNum(getNexts(next.x,next.y).size());
        }
        return nexts.stream().sorted(Comparator.comparing(MyPoint::getNextNum)).collect(Collectors.toList());
    }

    private void printPath() {
        for (int i = 0; i < path.size(); i++) {
            qipan[path.get(i).x][path.get(i).y]=i+1;
        }

        for (int i = 0; i < qipan.length; i++) {
            for (int j = 0; j < qipan.length; j++) {
                System.out.printf("%d ," ,qipan[i][j]);
            }
            System.out.printf("\n");
        }

        //path.stream().map((p)->qipan[p.x][p.y])
    }

    private List<MyPoint> getNexts( int x ,int y ) {
        List<MyPoint> resutl = new ArrayList<>();

        if (isValide(x-1 ,y-2)) {
            MyPoint mp = new MyPoint(x-1,y-2);
            if (!path.contains(mp)) {
                resutl.add(mp);
            }
        }
        if (isValide(x+1 ,y-2)) {
            MyPoint mp = new MyPoint(x+1 ,y-2);
            if (!path.contains(mp)) {
                resutl.add(mp);
            }
        }
        if (isValide(x+2 ,y-1)) {
            MyPoint mp = new MyPoint(x+2 ,y-1);
            if (!path.contains(mp)) {
                resutl.add(mp);
            }
        }
        if (isValide(x+2 ,y+1)) {
            MyPoint mp = new MyPoint(x+2 ,y+1);
            if (!path.contains(mp)) {
                resutl.add(mp);
            }
        }
        if (isValide(x-2 ,y-1)) {
            MyPoint mp = new MyPoint(x-2 ,y-1);
            if (!path.contains(mp)) {
                resutl.add(mp);
            }
        }
        if (isValide(x-2 ,y+1)) {
            MyPoint mp = new MyPoint(x-2 ,y+1);
            if (!path.contains(mp)) {
                resutl.add(mp);
            }
        }
        if (isValide(x-1 ,y+2)) {
            MyPoint mp = new MyPoint(x-1 ,y+2);
            if (!path.contains(mp)) {
                resutl.add(mp);
            }
        }
        if (isValide(x+1 ,y+2)) {
            MyPoint mp = new MyPoint(x+1 ,y+2);
            if (!path.contains(mp)) {
                resutl.add(mp);
            }
        }

        return resutl;
    }

    private boolean isValide(int x, int y) {
        if (x >=0 && x<=qipanNum-1 && y>=0 && y<=qipanNum-1) {
            return true;
        }
        return false;
    }


    class MyPoint implements Comparable{
        int x;
        int y;
        public  int nextNum;

        public int getNextNum() {
            return nextNum;
        }

        public void setNextNum(int nextNum) {
            this.nextNum = nextNum;
        }

        public MyPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            MyPoint p = (MyPoint)o;
            return (this.x==p.x && this.y== p.y)?1:0;
        }

        @Override
        public int hashCode() {
            return x+y;
        }

        @Override
        public boolean equals(Object obj) {
            MyPoint p = (MyPoint)obj;
            return p.x == this.x && p.y==this.y;
        }
    }
}
