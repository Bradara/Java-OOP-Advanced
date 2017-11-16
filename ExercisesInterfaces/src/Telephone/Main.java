package Telephone;

import Telephone.SmartPhone.Smartphone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split("\\s+");
        String[] sites = br.readLine().split("\\s+");
        Smartphone smartphone = new Smartphone();

        for (String number : numbers) {
            System.out.println(smartphone.calling(number));
        }

        for (String site : sites) {
            System.out.println(smartphone.browsing(site));
        }
    }
}