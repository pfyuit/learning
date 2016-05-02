'''
Created on Feb 1, 2016
@author: yupengfei
'''

class Employee:
    'Comment for Employee'
    
    num = 0
    
    def __init__(self, age, salary):
        self.age = age
        self.salary = salary
        Employee.num = Employee.num + 1
    
    def __del__(self):
        class_name = self.__class__.__name__
        print("destroy:", class_name)
    
    def displayCount(self):
        print("Total Employees", Employee.num)

    def displayEmployee(self):
        print("Information of Employee", self.age, self.salary)

   
class Manager(Employee):
    'Comment for Manager'
    
    def __init__(self, age, salary):
        self.age = age
        self.salary = salary
        
def main():
    print("==>employee test")
    emp1 = Employee(20, 100)
    emp2 = Employee(25, 150)
    
    if hasattr(emp1, 'age'):
        print(getattr(emp1, 'age'))
    setattr(emp1, 'age', 21)

    emp1.displayEmployee()
    emp2.displayEmployee()
    emp1.displayCount()
    
    print(Employee.__doc__)
    print(Employee.__name__)
    print(Employee.__bases__)
    print(Employee.__dict__)

##############################
    del emp1
    del emp2

    print("==>manager test")
    manager1 = Manager(30, 300)
    manager1.displayEmployee()


if __name__ == "__main__":
    main()

