public class Practice {
    public static void main(String[] args) {

    }
    /*
    【题目】
        #1.显示所有员工的姓名，部门号和部门名称。
            SELECT last_name,e.department_id,e.department_name
            FROM employees e LEFT JOIN department d;
            ON e.department_id = d.department_id;
        #2.查询90号部门员工的job_id和90号部门的location_id
            SELECT job_id,location_id
            FROM employees e JOIN department d
            ON e.department_id = d.department_id
            WHERE e.department_id = 90;
        #3.选择所有有奖金的员工的 last_name , department_name , location_id , city
            一般的所有最好都用外连接 因为不知道每个人是否同时拥有当前的查询字段 有点有两个
            有的员工没有部门 但是有奖金
            SELECT e.last_name, d.department_name, l.location_id,l.city
            FROM employees e LEFT JOIN department_name d
            ON e.department_id = d.department_id
            LEFT JOIN location l
            ON d.location_id = l.location_id
            WHERE e.commission IS NOT NULL;
        #4.选择city在Toronto工作的员工的 last_name , job_id , department_id , department_name
            SELECT e.last_name, e.job_id, d.department_id, d.department_name
            FROM employees e JOIN departments  d
            ON e.department_id = d.department_id
            JOIN location l
            ON d.department_id = l.department_id
            WHERE l.city = 'Toronto';
        #5.查询员工所在的部门名称、部门地址、姓名、工作、工资，其中员工所在部门的部门名称为'Executive'
            SELECT d.departments_name,street_address,e.last_name,d.job_id,e.salary
            FROM employees e JOIN departments d
            ON e.departments_id = d.departments_id
            JOIN location l
            ON d.location_id  = l.location_id
            WHERE d.departments_id = 'Executive';
        #6.选择指定员工的姓名，员工号，以及他的管理者的姓名和员工号，结果类似于下面的格式
            employees   Emp#manager Mgr#
            kochhar     101 king    100
            SELECT e.last_name, e.employees_id, mgr.last_name,mgr_employees_id
            FROM employees e LEFT JOIN employees mar
            ON e.employees_id = mgr.employees_id;
        #7.查询哪些部门没有员工
            SELECT departments_name
            FROM employees e RIGHT JOIN departments d
            ON e.employees_id = departments_id
            WHERE e.employees_id IS NULL;

        #8.查询哪个城市没有部门
            SELECT l.city
            FROM location l LEFT JOIN departments d
            ON l.location_id = d.location_id
            WHERE l.city IS NULL;
        #9.查询部门名为Sales或IT的员工信息
            SELECT *
            FROM employees e JOIN departments d
            ON e.departments_id = d.employees_id
            WHERE d.departments_id IN ('Sales','IT');

     */
}
