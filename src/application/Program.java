package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		
		Scanner s = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Enter department's name: ");
		String depName = s.nextLine();
		
		System.out.println("Enter Woker Data: ");
		System.out.println("Name: ");
		String name = s.next();
		System.out.println("Level: ");
		String level =s.next();
		System.out.println("Base Salary: ");
		double baseSalary = s.nextDouble();
		Departament dep = new Departament(depName);
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, dep);
		System.out.println("How many contracts to this worker? ");
		int qtd = s.nextInt();
		
		for(int i = 1; i <= qtd; i++) {
			System.out.println("Enter contract #" + i+" data");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(s.next());
			System.out.print("Value per hour: ");
			double valuePerHour = s.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = s.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
			
		}
		
		System.out.println();
		System.out.println("Enter month and year to calculate income (MM/YYYY): ");
		String monthYear = s.next();
		int month = Integer.parseInt(monthYear.substring(0, 2));
		int year = Integer.parseInt(monthYear.substring(3));
		System.out.println("Name1: "+worker.getName());
		System.out.println("Departement: "+worker.getDepartament().getName());
		System.out.println("Income for "+monthYear+": " + String.format("%.2f", worker.income(year, month)));
		
		s.close();

	}

}
