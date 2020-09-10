package IMOOC;

import java.util.Arrays;


public class Circle {

    class Person implements Comparable<Person> {
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "height=" + height +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Person p) {
            if(this.height>p.height) {
                return 1;
            } else if(this.height < p.height) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public void calculatePeople(Person[] input) {

        int weightArray[] = new int[input.length];
        String[] output = new String[input.length];
        for (int i=0;i<input.length;i++) {
            weightArray[i] = 1;
            output[i] = input[i].toString() + "";
        }
        int maxLength = 0;

        for (int i=1;i<input.length;i++) {
            for (int j=0;j<i;j++) {
                if( weightArray[j]+1>weightArray[i] && input[i].weight>input[j].weight) {
                    weightArray[i] = weightArray[j] + 1;
                    output[i] = output[j] + " " + input[i].toString();
                    if(maxLength<weightArray[i]) {
                        maxLength = weightArray[i];
                    }
                }
            }
        }

        System.out.println();


        for (int i = 0; i < input.length; i++) {
            if (weightArray[i] == maxLength) {
                System.out.println("Longest Increasing subsequence - " + output[i] + " of length = " + maxLength);
            }
        }

    }

    public static void main(String[] args) {
        Circle ct = new Circle();
        Person p1 = ct.new Person(65,100);
        Person p2 = ct.new Person(70,150);
        Person p3 = ct.new Person(56, 90);
        Person p4 = ct.new Person(75, 190);
        Person p5 = ct.new Person(60, 95);
        Person p6 = ct.new Person(68, 110);
        Person p7 = ct.new Person(64, 110);

        Person[] array = new Person[]{p1,p2,p3,p4,p5,p6, p7};

        Arrays.sort(array);

        ct.calculatePeople(array);

    }

}