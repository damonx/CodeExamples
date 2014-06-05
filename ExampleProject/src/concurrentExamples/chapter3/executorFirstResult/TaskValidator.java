package concurrentExamples.chapter3.executorFirstResult;

import java.util.concurrent.Callable;

public class TaskValidator implements Callable<String> {

    private UserValidator validator;
    private String user;
    private String password;
    
    public TaskValidator(UserValidator validator, String user, String password) {
        this.validator = validator;
        this.user = user;
        this.password = password;
    }

    @Override
    public String call() throws Exception {
        // TODO Auto-generated method stub
        if(!validator.validate(user, password)){
            System.out.printf("%s: The user has not been found\n",validator.getName());
            throw new Exception("Error validating user");
        }
        
        System.out.println(validator.getName() + ": The user has been found\n");
        return validator.getName();
    }

}
