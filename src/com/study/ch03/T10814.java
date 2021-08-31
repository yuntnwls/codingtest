package com.study.ch03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public interface T10814 {
	static class Person implements Comparable<Person> {
		int index;
		int age;
		String name;
		public Person(int index, int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		@Override
		public int compareTo(Person o) {
			if (this.age == o.age) {
				return this.index - o.index;
			}
			return this.age - o.age;
		}
		
		@Override
		public String toString() {
			return String.format("%d %s", this.age, this.name);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Person> personList = new ArrayList<>();
		StringTokenizer st = null;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			personList.add(new Person(i, Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		
		Collections.sort(personList);
		
		for (int i=0; i<n; i++) {
			System.out.println(personList.get(i).toString());
		}
	}
}
