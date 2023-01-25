import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping
public class EmployeeController {

    private EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/employees")
    public List<Employee> list() {
        return employeeDAO.list();
    }

    @RequestMapping(method = RequestMethod.GET, path = "employees/{nif}")
    public Employee employee(@PathVariable("nif") String nif) {
        Employee employee = employeeDAO.get(nif);
        if (employee == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "employee not found"
            );

        } else {
            return employee;
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "employees")
    public void insertEmployee(@PathVariable("nif") String nif) {

        Employee employee = employeeDAO.get(nif);

        if (employee == null) {

            employeeDAO.insert(employee);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "the employee already exists"
            );
        }

    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/employees/{nif}")
    public void deleteEmployee(@PathVariable("nif") String nif) {

        Employee employee = employeeDAO.get(nif);

        if (employee == null) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "employee not found"
            );
        } else {
            employeeDAO.delete(nif);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "employees")
    public List<Employee> list(@RequestParam(value = "tag", required = false) String tag) {
        return employeeDAO.list(tag);
    }
}