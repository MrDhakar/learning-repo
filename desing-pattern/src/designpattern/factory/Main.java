package designpattern.factory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	

	 public static void main(String[] args) {
		
			/*
			 * AndroidCompany ac = new AndroidCompany(); Android ab = (Android)
			 * ac.getInstances(); ab.spec();;
			 */
		 
		 
		 List<String> fruitList = new ArrayList<>();
		 fruitList.add("Mango");
		 fruitList.add("Orange");
		 fruitList.add("apple");
		 fruitList.add("banana");
		 
		 
		
		 List<Integer> rateList = new ArrayList<>();
		 rateList.add(1);
		 rateList.add(5);
		 rateList.add(2);
		 rateList.add(6);
		 rateList.add(3);
		 rateList.add(4);
		 rateList.add(3);
		 rateList.add(2);
		 double avgRate= getavg(rateList);
		 List<Employee> upperCaseList = getUpperCaseList(fruitList);
		 upperCaseList.stream().forEach(x->System.out.println("id"+x.getId()+" Name "+x.getName()+" Salary"+x.getSalary()));
		 
		 double summOdd= getavg(rateList);
		 int summeven = getsum(rateList);
		 Integer removeDuplicate = removeDuplicate(rateList);
		 Integer min = findMin(rateList);
		 System.out.println(removeDuplicate);
		 System.out.println(avgRate);
		 System.out.println(summeven);
		 System.out.println(min);
		 
		 
		 
		 List<Employee> employees = new ArrayList<Employee>();
	     Employee employee = new Employee();
	     employee.setSalary(5000.00);
	     employee.setName("Jai");
	     employee.setId("1");
	     employee.setDept("IT");
	     employees.add(employee);

	     employee = new Employee();
	     employee.setSalary(8000.00);
	     employee.setName("Dhakar");
	     employee.setId("2");
	     employee.setDept("ADMIN");
	     employees.add(employee);
	     
	     employee = new Employee();
	     employee.setSalary(10000.00);
	     employee.setName("Prakash");
	     employee.setId("3");
	     employee.setDept("HR");
	     employees.add(employee);
	     
	     employee = new Employee();
	     employee.setSalary(12000.00);
	     employee.setName("Ajay");
	     employee.setId("4");
	     employee.setDept("HR");
	     employees.add(employee);
	     
	     
	     Map<String, List<Employee>> deptToEmp = mapToEnum(employees);
	     for (Map.Entry<String, List<Employee>> entry : deptToEmp.entrySet()) {
	         //action.accept(entry.getKey(), entry.getValue());
	     System.out.println(entry.getValue());
	 }
	    // BiConsumer <Map.Entry<String, List<Employee>>,> = 
	     deptToEmp.forEach((t, u) -> 
	     {   System.out.println("index "+t);
	    	 u.forEach(x-> System.out.println("Id "+ x.getId()+" "+x.getName()+" "+x.getDept()));
	     }
	    		 
	    		 )  ;
	     
	}



	private static Map<String, List<Employee>> mapToEnum(List<Employee> employees) {
		
		
		// TODO Auto-generated method stub
		//employees.stream().filter(x->x.getDept()==DEPT.ADMIN).collect(Collectors.toList());
		//employees.stream().forEach(x-> if(x.));
		//Map<String, Employee> empList = employees.stream().collect(Collectors.toMap(Employee :: getDept, Function.identity()));
		Map<String, List<Employee>> deptEmpMap = new HashMap<String,List<Employee>>();
		

		//employees.stream().collect(Collectors.toMap(x->x.getDept(),employees.stream().collect(x.)));
		
		/*forEach(x -> {
			if(DEPT.ADMIN.equals(x.getDept())) {
				List list = new ArrayList<Employee>();
				list.add(x);
				deptEmpMap.put(x.getDept(), list);
			}
			else if(DEPT.HR.equals(x.getDept())) {
				List list = new ArrayList<Employee>();
				list.add(x);
				deptEmpMap.put(x.getDept(), list);
			}else if(DEPT.IT.equals(x.getDept())) {
				List list = new ArrayList<Employee>();
				list.add(x);
				deptEmpMap.put(x.getDept(), list);
			}
		}
				);*/
		//Predicate<Boolean> predicate = x-> ("HR".equals(x));
		//Supplier <List<Employee>> supplier= ()-> employees.stream().filter(x->"HR".equals(x.getDept())).collect(Collectors.toList());
		employees.stream().forEach( x->{
				if(!deptEmpMap.containsKey(x.getDept())) {
					List list = new ArrayList<Employee>();
					deptEmpMap.put(x.getDept(), list);
				}
				deptEmpMap.get(x.getDept()).add(x);
				
		});
		//List<Employee> list = supplier.get();
		//employees.stream().map(x->x.getDept(),AbstractMap.SimpleImmutableEntry<String, Employee>())
		return employees.stream().collect(Collectors.groupingBy(Employee::getDept));
	}



	private static Integer findMin(List<Integer> rateList) {
		return rateList.stream().min(Integer::compare).orElse(null);
	}



	private static Integer removeDuplicate(List<Integer> rateList) {
		
		
		String str="eettdaababc";
		
		String[] strArr = str.split("");
		LinkedHashSet<String> hashmapList2 = new LinkedHashSet<String>();
		Stream.of(strArr).forEach(i->{
					if(hashmapList2.contains(i)) hashmapList2.remove(i);
					else hashmapList2.add(i);});
		String xyz=hashmapList2.stream().findFirst().orElse(null);
		
		//rateList.stream().distinct().collect(Collectors.toList())
		LinkedHashSet<Integer> hashmapList = new LinkedHashSet<Integer>();

		 rateList.forEach(i->{
					if(hashmapList.contains(i)) hashmapList.remove(i);
					else hashmapList.add(i);});
		 

		 return hashmapList.stream().findFirst().orElse(null);
	}
	private static int getsum(List<Integer> rateList) {
		return rateList.stream().filter(x-> x%2==0).mapToInt(Integer::intValue).sum();
	}
  


	private static List<Employee> getUpperCaseList(List<String> fruitList) {
		
	     List<Employee> employees = new ArrayList<Employee>();
	     Employee employee1 = new Employee();
	     employee1.setSalary(5000.00);
	     employee1.setName("jai");
	     employee1.setId("1");
	     employees.add(employee1);
	     
	     Employee employee2 = new Employee();
	     employee2.setSalary(8000.00);
	     employee2.setName("dhkar");
	     employee2.setId("2");
	     employees.add(employee2);
	     String criteria= "getName"; 
	     employees =employees.stream().
	    		 sorted(Comparator.comparing(Employee :: getSalary).reversed())
	    		 .collect(Collectors.toList());
	     
		//Arrays.sort(employees, Comparator.comparing(Employee::getName).thenComparing(Employee::getId));
		
	     //employees.stream().sorted(Employee: name).collect(Collectors.toList());
		List < String > ascendingOrder = fruitList.stream().map(String::toLowerCase)
			      .sorted(Comparator.reverseOrder())
			      .collect(Collectors.toList());
		//fruitList.stream().map(x->x.toUpperCase()).collect(Collectors.toList())
		//fruitList.stream().filter(x->x.startsWith("M")).collect(Collectors.toList());
		return employees;
	}

	private static double getavg(List<Integer> rateList) {
		
		return rateList.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
	}
}
