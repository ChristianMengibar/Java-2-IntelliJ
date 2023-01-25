import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class ConfigurationDAO {

    @Bean
    public DepartmentDAO departmentDAO(){
        return new InMemoryDepartmentDAO();
    }

    @Bean
    public EmployeeDAO employeeDAO(){
        return new InMemoryEmployeeDAO();
    }
}
