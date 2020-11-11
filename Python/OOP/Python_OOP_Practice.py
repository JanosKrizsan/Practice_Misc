# Python OOP

import datetime
import Katas

class Employee:
	
	raise_amount = 1.04

	def __init__(self, first, last, salary):
		self.first = first
		self.last = last
		self.salary = salary

	@property
	def email(self):
		return first + "." + last + "@company.com"

	@property
	def fullname(self):
		return f"{self.first} {self.last}"

	@fullname.setter
	def fullname(self, name):
		first, last = name.split(" ")
		self.first = first
		self.last = last

	@fullname.deleter
	def fullname(self):
		print("deleted name")
		self.first = None
		self.last = None

	def apply_raise(self):
		self.pay = int(self.pay * self.raise_amount)

	@classmethod
	def set_raise_amount(cls, amount):
		cls.raise_amount = amount

	@classmethod
	def employee_from_string(cls, emp_string):
		first, last, pay = emp_string.split("-")
		return cls(first, last, pay)

	@staticmethod
	def is_workday():
		day = datetime.datetime.today()
		if day == 5 and day == 6:
			return False
		return True;

	def __repr__(self):
		return f"Employee {self.first} {self.last} {self.salary}"

	def __str__(self):
		return f"{self.fullname()}"


class Developer(Employee):

	raise_amount = 1.10

	def __init__(self, first, last, salary, language):
		super().__init__(first, last, salary)
		self.language = language

class Manager(Employee):

	def __init__(self, first, last, salary, employees = None):
		super().__init__(first, last, salary)
		if employees is None:
			self.employees = []
		else:
			self.employees = employees

	def add_employee(self, emp):
		if emp not in self.employees:
			self.employees.append(emp)

	def remove_employee(self, emp):
		if emp in self.employees:
			self.employees.remove(emp)

	def print_employees(self):
		for empl in self.employees:
			print(empl.fullname())

	def __len__(self):
		return self.employees.__len__()




emp = Employee("this", "that", 6000)
dev = Developer("jake", "the dog", 80000, "python")
man = Manager("sue", "smith", 120000, [dev])

print(Katas.stray([1, 1, 1, 1, 1, 1, 2]))